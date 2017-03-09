package com.astrolink.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.types.URI;
import org.apache.axis2.databinding.types.URI.MalformedURIException;
import org.apache.log4j.Logger;

import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.HeaderFactory;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SimpleReference;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException;

import com.astrolink.consts.Const;
import com.astrolink.domain.CtccSmsSend;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;


/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccSmsExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccSmsExecLinstenerThreadDao.class);
	private String dbTableName;
	public CtccSmsSend ctccSmsSend;
	public IExecFinish execFinish; 
	private String gate;
	private String parlayXGateWayURI;
	
	public CtccSmsExecLinstenerThreadDao(CtccSmsSend ctccSmsSend){
		this.ctccSmsSend = ctccSmsSend;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}


	@Override
	public void exec() {
		logger.info("开始发送电信短信，id为" + this.getKey());
		String requestIdentifier = "";
		String sendResult = "succ";
		
		gate=Const.CTCC_GATE;
		parlayXGateWayURI=Const.CTCC_ParlayX_GW_URI;
		try {
			//requestIdentifier = doSend(dest, src, subject, serviceId, sessionId, sessionEnd, linkId, OA, FA, msg);
			requestIdentifier = doSend(
					ctccSmsSend.getDest(), 
					ctccSmsSend.getSrc(),
					ctccSmsSend.getSubject(),
					ctccSmsSend.getService_id(),
					ctccSmsSend.getSession_id(),
					ctccSmsSend.getSession_end(),
					ctccSmsSend.getLink_id(),
					ctccSmsSend.getOA(),
					ctccSmsSend.getFA(),
					ctccSmsSend.getMsg()
			);
		} catch (PolicyException e) {
			// ParlayX GW抛出PolicyException
			String msgId = e.getFaultMessage().getPolicyException().getMessageId();
			String msgText = e.getFaultMessage().getPolicyException().getText();
			sendResult = "err:PolicyException!" + msgId + ":" + msgText;

		} catch (ServiceException e) {
			// ParlayX GW抛出ServiceException
			String msgId = e.getFaultMessage().getServiceException().getMessageId();
			String msgText = e.getFaultMessage().getServiceException().getText();
			sendResult = "err:ServiceException!" + msgId + ":" + msgText;
		} catch (RemoteException e) {
			logger.error(ExceptionTools.exception(e));
			sendResult = "err:RemoteException!" + e.toString();
		}finally{
			try {
				//删除send
				deleteSendData();
				doLog(
						ctccSmsSend.getDest(), 
						ctccSmsSend.getSrc(),
						ctccSmsSend.getSubject(),
						ctccSmsSend.getService_id(),
						ctccSmsSend.getSession_id(),
						ctccSmsSend.getSession_end(),
						ctccSmsSend.getLink_id(),
						ctccSmsSend.getMethod(),
						ctccSmsSend.getOA(),
						ctccSmsSend.getFA(),
						ctccSmsSend.getMsg(),
						sendResult,
						requestIdentifier,
						ctccSmsSend.getTempCpid(),
						ctccSmsSend.getCmdErrorId()
				);
			} catch (Exception e) {
				logger.info("发送send请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
			} finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("发送send请求结束，id为" + this.getKey());
				}
			}
		}
		
		logger.info("requestIdentifier:" + requestIdentifier);
		logger.info("sendResult:" + sendResult);
	}
	
	private String doSend(String dest, String src, String subject, String serviceId, String sessionId, String sessionEnd, String linkId, String OA, String FA, String msg) throws RemoteException, PolicyException, ServiceException {

		/*
		 * SMS接口规范中定义的sendSms接口参数:
		 * 
		 * DestinationAddresses xsd:anyURI [0..unbounded] SenderName xsd:string
		 * Charging Common:ChargingInformation Message xsd:string ReceiptRequest
		 * Common:SimpleReference
		 */
		/***** begin - sendSms接口参数设置 *****/
		SendSms param = new SendSms();

		// DestinationAddresses, 目的地址(群发的情况下, DestinationAddresses为URI数组)
		URI[] addr = new URI[1];
		try {
			addr[0] = new URI("tel:" + dest);
		} catch (MalformedURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		param.setAddresses(addr);

		// SenderName
		param.setSenderName(src);

		// Charging(可选)
		param.setCharging(null);

		// Message, 短消息内容
		/*try {
			msg = new String(msg.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		System.out.println("msg : " + msg);
		param.setMessage(msg);

		// ReceiptRequest, 为null表示SP不需要状态报告; 非null表示SP需要状态报告
		SimpleReference simpleRef = new SimpleReference();
		try {
			simpleRef.setEndpoint(new URI("http://localhost:8080"));
		} catch (MalformedURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sdf_td = new SimpleDateFormat("yyyyMMddHHmmSS", Locale.SIMPLIFIED_CHINESE);
		String timestep = sdf_td.format(new Date());
		String correlator = timestep + getRandomInt(20 - timestep.length());
		simpleRef.setCorrelator(correlator);
		simpleRef.setInterfaceName("sendSms");
		param.setReceiptRequest(simpleRef); // ReceiptRequest非null表示SP需要状态报告
		// param.setReceiptRequest(null); // ReceiptRequest为null表示SP不需要状态报告

		/***** end - sendSms接口参数设置 *****/

		// ParlayX GW的SendSms开放接口URI
		String sendSmsURI = parlayXGateWayURI;
		// 创建客户端Stub类的对象
		SendSmsServiceStub sendSmsStub = new SendSmsServiceStub(sendSmsURI);
		ServiceClient client = sendSmsStub._getServiceClient();

		// 设置SOAPHeader
		SOAPHeaderBlock header = HeaderFactory.creatAOMTSoapHeader(serviceId, sessionId, sessionEnd, linkId, OA, FA);
		client.addHeader(header);

		// 设置请求消息
		SendSms7 reqMessage = new SendSms7();
		reqMessage.setSendSms(param);

		// 【调用sendSms接口并获取响应消息, 由AXIS2完成SOAP消息的封装、发送请求消息、接收响应消息】
		SendSmsResponse4 rspMessage = sendSmsStub.sendSms(reqMessage);

		String sendResult = rspMessage.getSendSmsResponse().getResult();
		System.out.println("sendResult : " + sendResult);

		return correlator;

	}
	
	private void doLog(String dest, String src, String subject, String serviceId, String sessionId, String sessionEnd, String linkId, String method, String OA, String FA, String msg, String result, String requestIdentifier,long tempCpid,long cmdErrorId) {
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("INSERT INTO ").append(Const.CTCC_SMS_TABLE_SENDTMP).append(" (dest,src,OA,FA,subject,service_id,msg,link_id,method,session_id,session_end,request_identifier,result,time) VALUES( ");
		sqlBuff.append("'").append(dest).append("',");
		sqlBuff.append("'").append(src).append("',");
		sqlBuff.append("'").append(OA).append("',");
		sqlBuff.append("'").append(FA).append("',");
		sqlBuff.append("'").append(subject).append("',");
		sqlBuff.append("'").append(serviceId).append("',");
		sqlBuff.append("'").append(msg).append("',");
		sqlBuff.append("'").append(linkId).append("',");
		sqlBuff.append("'").append(method).append("',");
		sqlBuff.append("'").append(sessionId).append("',");
		sqlBuff.append("'").append(sessionEnd).append("',");
		sqlBuff.append("'").append(requestIdentifier).append("',");
		sqlBuff.append("'").append(result).append("',");
		sqlBuff.append("now())");
		
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		int id=dt.upDateId(sqlBuff.toString(), CtccSmsExecLinstenerThreadDao.class);
		logger.info("sendLog：" + id);
		
		
		DbTools dt_otherInfo=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		JSONObject jsonSendtemp_otherInfo=new JSONObject();
		jsonSendtemp_otherInfo.put("sendtmpId", id);
		jsonSendtemp_otherInfo.put("cmdErrorId", cmdErrorId);
		jsonSendtemp_otherInfo.put("tempCpid", tempCpid);
		jsonSendtemp_otherInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		dt_otherInfo.insertJson("sendtmp_otherInfo",jsonSendtemp_otherInfo,CtccSendSmsExecLinstenerThreadDao.class);
	}
	
	private void deleteSendData(){
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		String deleteSql = "delete from "+this.dbTableName+" where id=" + ctccSmsSend.getId();
		boolean state = dt.upDate(deleteSql, CtccSmsExecLinstenerThreadDao.class);
		logger.debug("更新send状态:"+state+"，更新sql" + deleteSql);
	}

	private int getRandomInt(int len) {
		String numStr = "1";
		for (int i = 0; i < len - 1; i++) {
			numStr += new Random().nextInt(10);
		}
		return Integer.parseInt(numStr);
	}
}
