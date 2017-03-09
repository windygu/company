package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.SupportExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.video2.migu20.manga;
import com.astrolink.util.tools.Base64;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.MacRandomAddress;

import net.sf.json.JSONObject;

/**
 * 视频2.0
 * @author sjh
 * @date 2016-09-08
 */
public class VideoExecLinstenerThreadDao2 extends JobThread{
	private Logger logger = Logger.getLogger(VideoExecLinstenerThreadDao2.class);
	public StringBuffer logBuff=new StringBuffer();
	
	private String dbTableName;
	public SupportExecLog supportExecLog;
	public IExecFinish execFinish;
	public static JSONObject supportAttrInfo ;
	private static String doChargeStatus="";
	private static int payStepNum=0;
	
	public VideoExecLinstenerThreadDao2(SupportExecLog supportExecLog){
		this.supportExecLog = supportExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		manga manga = new manga();
		StringBuffer logBuff=new StringBuffer();
		logBuff.append("\n=============================================================================================================================");
		logBuff.append("\n视频2.0计费确认,id为" + this.getKey()+";imsi:"+supportExecLog.getImsi());
		try{
			supportAttrInfo = JSONObject.fromObject(supportExecLog.getSupportAttrInfo());
			logBuff.append(",参数：" + supportAttrInfo.toString()+"\n");
			
			// sdk
			manga.apiVersion = supportAttrInfo.optString("apiVersion");
			manga.SDKVersion = supportAttrInfo.optString("SDKVersion");
			manga.SEC_VERSION = supportAttrInfo.optString("SEC_VERSION");
			manga.nRQd_Lx = supportAttrInfo.optString("nRQd_Lx");
			manga.EN = supportAttrInfo.optString("EN");
			manga.miguEDVersion = supportAttrInfo.optString("miguEDVersion");
			manga.soVersion = supportAttrInfo.optString("soVersion");
			manga.migusdkversion = supportAttrInfo.optString("migusdkversion");
			manga.MiguPay_FileSHA1 = supportAttrInfo.optString("MiguPay_FileSHA1");
			
			//xmxx
			manga.apkstatus=supportAttrInfo.optString("apkstatus");
			manga.imei = supportExecLog.getImei();
			manga.imsi = supportExecLog.getImsi();
			manga.Serial = supportAttrInfo.optString("Serial");
			manga.linux_version = supportAttrInfo.optString("linux_version");
			manga.local_ip = "192.168.254."+ (Const.random.nextInt(145)+100);
			manga.encodecid=supportAttrInfo.optString("encodecid");
			
			manga.AppId=supportAttrInfo.optString("AppId");
			manga.productId=supportAttrInfo.optString("productId");
//			manga.contentId=supportAttrInfo.optString("contentId");
			manga.mg20irid=supportAttrInfo.optString("mg20irid");
			manga.cpId=supportAttrInfo.optString("cpId");
			manga.ChannelCode=supportAttrInfo.optString("ChannelCode");
//			manga.channelId=supportAttrInfo.optString("channelId");
			manga.PayCode=supportAttrInfo.optString("itemId");
			manga.Fee=supportAttrInfo.optString("consumePrice");
//			manga.ItemId=supportAttrInfo.optString("itemId");
			manga.Ctype=supportAttrInfo.optString("Ctype");
			manga.goodsId=supportAttrInfo.optString("goodsId");
			
			//initDeviceInfo
			JSONObject mobileInfo =BasicsTools.randomMobileInfo(1).getJSONObject(0);
			manga.Hardware=mobileInfo.getString("name")+mobileInfo.getString("type");
			
			manga.RELEASE = mobileInfo.getString("system").substring(8,mobileInfo.getString("system").length());
			manga.screen = mobileInfo.getString("x")+"*"+mobileInfo.getString("y");;
			manga.BRAND = mobileInfo.getString("name");
			manga.MODEL = mobileInfo.getString("type");
			manga.MacAddr = MacRandomAddress.getMacAddrWithFormat(":");;
			manga.Location = "";
			manga.NetworkType = "0";
			
			manga.sms=new String(Base64.decode(supportAttrInfo.optString("sms")));
			
			manga.clientId=supportAttrInfo.optString("clientId");
			manga.resourceId=supportAttrInfo.optString("resourceId");

			doChargeStatus=manga.run();
			
			logBuff.append(",final_doChargeStatus:"+doChargeStatus);
			if (!doChargeStatus.equals("0")){
				logBuff.append(",计费失败");
			}
			payStepNum++;
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			try {
				if(payStepNum<1 && doChargeStatus.equals("0")){
					doChargeStatus="-1";
				}
				
				if (doChargeStatus.equals("0") || doChargeStatus.equals("L90000")){
					updateSupportExecLog(supportExecLog.getId(),doChargeStatus,1,logBuff);
					savePayResultLog(payStepNum,doChargeStatus,manga.message,manga.phoneNumber,supportExecLog.getCrackSynUrl(),supportExecLog.getId(),logBuff);
				}else{
					if(supportExecLog.getExecNum()<Const.MUSIC_LOGIC_RETRY_NUM-1){
						updateSupportExecLog(supportExecLog.getId(),doChargeStatus,0,logBuff);
					}else{
						updateSupportExecLog(supportExecLog.getId(),doChargeStatus,1,logBuff);
						savePayResultLog(payStepNum,doChargeStatus,manga.message,manga.phoneNumber,supportExecLog.getCrackSynUrl(),supportExecLog.getId(),logBuff);
					}
				}
			} catch (Exception e) {
				logBuff.append(",处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
			} finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					
					logBuff.append(",处理请求结束，id为" + this.getKey());
				}
				logger.info(logBuff.toString());
			}
		}
	}
	
	public  void updateSupportExecLog(long id,String doChargeStatus,int execState,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE support_exec_log SET execNum = execNum+1,execState = '"+execState+"',execResultCode='" + doChargeStatus + "',execResultInfo='',updateDate='"+BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss")+"' WHERE id= '").append(id).append("'");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		logBuff.append(",updateExecNum：" + dt.upDate(sqlBuff.toString(), VideoExecLinstenerThreadDao2.class));
	}
	
	public void savePayResultLog(int payStepNum,String status,String message,String phoneNumber,String crackSynUrl,long execLogId,StringBuffer logBuff){
		JSONObject dataInfo = new JSONObject();
		dataInfo.put("execLogId", execLogId);
		if(status==null || status.equals("")){
			status="-1";
		}
		dataInfo.put("status", status);
		dataInfo.put("message", message);
		dataInfo.put("imei", supportExecLog.getImei());
		dataInfo.put("imsi", supportExecLog.getImsi());
		dataInfo.put("monum", supportAttrInfo.optString("monum"));
		dataInfo.put("consumeCode", supportAttrInfo.optString("consumeCode"));
		dataInfo.put("cpparam", supportAttrInfo.optString("cpparam"));
		dataInfo.put("execNum", supportExecLog.getExecNum());
		if(phoneNumber==null || phoneNumber.equals("")){
			phoneNumber="0";
		}
		dataInfo.put("phoneNumber", phoneNumber);
		dataInfo.put("cpInfoId", supportExecLog.getCpInfoId());
		dataInfo.put("transId", supportAttrInfo.optString("rand16Num")+supportAttrInfo.optString("timeStamp"));
		dataInfo.put("dayTime", BasicsTools.getForDate("yyyy-MM-dd"));
		dataInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		dataInfo.put("methodType", supportAttrInfo.optString("methodType"));
		dataInfo.put("channelId", supportAttrInfo.optString("channelId"));

		dataInfo.put("infoCode", 0);
		dataInfo.put("ssid", supportAttrInfo.optString("ssid"));
		if (supportAttrInfo.optString("proxyIp").equals("")) {
			dataInfo.put("proxyIp", "");
		} else {
			dataInfo.put("proxyIp", supportAttrInfo.optString("proxyIp"));
		}

		try {
			crackSyn(dataInfo, crackSynUrl(dataInfo,crackSynUrl,logBuff),logBuff);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}

		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("sevePayResultLog：" + dt.insertJson("support_pay_result", dataInfo, VideoExecLinstenerThreadDao2.class));
	}
	
	public void crackSyn(JSONObject dataInfo,String url,StringBuffer logBuff){
		GetNetWork get=new GetNetWork(url);
		get.executeMethod();
		dataInfo.put("synUrl", url);
		dataInfo.put("synstatus", get.getNetState());
		dataInfo.put("synresult", get.getString().replaceAll("'",""));
		logBuff.append(dataInfo.toString());
	}
	
	public String crackSynUrl(JSONObject dataInfo,String crackSynUrl,StringBuffer logBuff){
		StringBuffer sbuff =new StringBuffer();
		sbuff.append(crackSynUrl);
		sbuff.append("?").append("mobile=").append(dataInfo.optString("phoneNumber"));
		sbuff.append("&").append("cpid=").append(dataInfo.optString("cpInfoId"));
		sbuff.append("&").append("cpparam=").append(dataInfo.optString("cpparam"));
		sbuff.append("&").append("monum=").append(dataInfo.optString("monum"));
		sbuff.append("&").append("sid=").append(dataInfo.optString("consumeCode"));
		sbuff.append("&").append("imei=").append(dataInfo.optString("imei"));
		sbuff.append("&").append("imsi=").append(dataInfo.optString("imsi"));
		sbuff.append("&").append("linkId=").append(dataInfo.optString("transId"));
		sbuff.append("&").append("status=").append(dataInfo.optString("status"));
		sbuff.append("&").append("chid=").append(dataInfo.optString("channelId"));
		sbuff.append("&").append("spProductConsumeCodeId=").append(dataInfo.optString("ssid"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			logBuff.append(",crackSynUrl:"+ExceptionTools.exception(e));
		}
		return sbuff.toString();
	}
}
