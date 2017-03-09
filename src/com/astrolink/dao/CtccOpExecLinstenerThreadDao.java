package com.astrolink.dao;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.CtccOp;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;


/**
 * CtccOp线程
 * @author sjh
 * @date 2016-05-05
 */
public class CtccOpExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccOpExecLinstenerThreadDao.class);
	private String dbTableName;
	private CtccOp ctccOp;
	public IExecFinish execFinish; 
	StringBuffer logBuff=new StringBuffer();
	
	public CtccOpExecLinstenerThreadDao(CtccOp ctccOp){
		this.ctccOp = ctccOp;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		logBuff.append("开始电信开放平台计费确认,id为" + this.getKey());
		try {
			//OPFEE+CP号(5位)+计费点ID(8位)+透传(8位)+IMSI(15位)
			String rdoMoContent = ctccOp.getContent();
			String mobile = ctccOp.getMobile();
			if(rdoMoContent!=null && !rdoMoContent.equals("") && mobile!=null && !mobile.equals("")){
				StringBuffer sbuff =new StringBuffer();
				sbuff.append("http://127.0.0.1:8081/logic/ctccOpPay");
				sbuff.append("?").append("mobile=").append(mobile);
				sbuff.append("&").append("imsi=").append(getImsi(rdoMoContent.substring(21,rdoMoContent.length())));
				sbuff.append("&").append("imei=").append(getImei(""));
				sbuff.append("&").append("ssid=").append(Integer.parseInt(rdoMoContent.substring(5,13)));
				sbuff.append("&").append("cpparam=").append(rdoMoContent.substring(13,21));
				sbuff.append("&").append("cpid=").append(Integer.parseInt(rdoMoContent.substring(0,5)));
				sbuff.append("&").append("iccid=").append("");
				sbuff.append("&").append("returnType=").append("0");
				sbuff.append("&").append("methodType=").append("0");
				logBuff.append(sbuff.toString());
				//发送请求
				GetNetWork gnw=new GetNetWork(sbuff.toString());
				gnw.executeMethod();
				
				//数据日志
				dataLog();
			}
		} catch (Exception e) {
			logBuff.append("发送CtccOp请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
		} finally{
			try {
				//删除CtccOp
				deleteCtccOpData(); 	 
			} catch (Exception e) {
				logBuff.append("发送CtccOp请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
			} finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logBuff.append("发送CtccOp请求结束，id为" + this.getKey());
				}
				
				logger.info(logBuff.toString());
			}
		}
	}
	
	private void dataLog() {
		DbTools dt=new  DbTools(Const.DB_QXT_URL,Const.DB_MYSQL_DRIVER,Const.DB_QXT_USERNAME,Const.DB_QXT_PASSWORD);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id",ctccOp.getId());
		jsonObject.put("mobile",ctccOp.getMobile() );
		jsonObject.put("content", ctccOp.getContent());
		jsonObject.put("dest", ctccOp.getDest());
		try {
			jsonObject.put("time", ctccOp.getTime().toString());
		} catch (Exception e) {}
		
		jsonObject.put("serial", ctccOp.getSerial());
		jsonObject.put("serialRev", ctccOp.getSerialRev());
		try {
			jsonObject.put("intime", ctccOp.getIntime().toString());
		} catch (Exception e) {}
		dt.insertJson("mo_log_opfee", jsonObject, CtccOpExecLinstenerThreadDao.class);
		logBuff.append("id为" + this.getKey() + "写入日志mo_log_opfee");
	}
	
	private void deleteCtccOpData(){
		DbTools dt=new  DbTools(Const.DB_QXT_URL,Const.DB_MYSQL_DRIVER,Const.DB_QXT_USERNAME,Const.DB_QXT_PASSWORD);
		String deleteSql = "delete from "+this.dbTableName+" where id=" + ctccOp.getId();
		boolean state = dt.upDate(deleteSql, CtccOpExecLinstenerThreadDao.class);
		logBuff.append("更新mo_log_opfee状态:"+state+"，更新sql" + deleteSql);
	}
	
	private String getImei(String imei){
		if(imei.length()!=15){
			imei="86"+BasicsTools.getUuid(false , 13,Const.random);
		}
		return imei;
	}
	private String getImsi(String imsi){
		if(imsi.length()!=15){
			imsi="46000"+BasicsTools.getUuid(false , 10,Const.random);
		}
		return imsi;
	}
}
