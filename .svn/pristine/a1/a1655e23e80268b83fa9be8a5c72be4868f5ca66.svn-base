package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.SupportExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.game2.migu20.manga;
import com.astrolink.util.tools.Base64;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.MacRandomAddress;

import net.sf.json.JSONObject;

/**
 * 音乐2.0
 * @author sjh
 * @date 2016-09-08
 */
public class Game2ExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(Game2ExecLinstenerThreadDao.class);
	public StringBuffer logBuff=new StringBuffer();
	
	private String dbTableName;
	public SupportExecLog supportExecLog;
	public IExecFinish execFinish;
	public static JSONObject supportAttrInfo ;
	private static String doChargeStatus[]=new String[2];
	private static int payStepNum=0;
	
	public Game2ExecLinstenerThreadDao(SupportExecLog supportExecLog){
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
		logBuff.append("\n===============================================================================================");
		logBuff.append("\n开始游戏2.0计费确认,id为" + this.getKey()+";imsi:"+supportExecLog.getImsi());
		try{
			supportAttrInfo = JSONObject.fromObject(supportExecLog.getSupportAttrInfo());
			logBuff.append(",参数：" + supportAttrInfo.toString());
			
			manga.initParams(supportAttrInfo);
			doChargeStatus=manga.run();
			logBuff.append("|final_Status:"+doChargeStatus[0]+",final_message:"+doChargeStatus[3]);
			if (!doChargeStatus[0].equals("0")){
				logBuff.append(",计费失败");
			}
			payStepNum++;
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			try {
				if(payStepNum<1 && doChargeStatus.equals("0")){
					doChargeStatus[0]="-1";
				}
				
				if (doChargeStatus[0].equals("0")){
					deleteExecLog(supportExecLog.getId(),logBuff);
					savePayResultLog(payStepNum,doChargeStatus[0],doChargeStatus[3],manga.phoneNumber,supportExecLog.getCrackSynUrl(),supportExecLog.getId(),logBuff);
				}else{
					if(supportExecLog.getExecNum()<Const.MUSIC_LOGIC_RETRY_NUM-1){
						updateExecNum(supportExecLog.getId(),logBuff);
					}else{
						deleteExecLog(supportExecLog.getId(),logBuff);
						savePayResultLog(payStepNum,doChargeStatus[0],doChargeStatus[3],manga.phoneNumber,supportExecLog.getCrackSynUrl(),supportExecLog.getId(),logBuff);
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
	
	public  void updateExecNum(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE ").append("spinfo.support_exec_log").append(" SET execNum = execNum+1, updateDate='").append(BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss")).append("'  WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		logBuff.append(",updateExecNum：" + dt.upDate(sqlBuff.toString(), Game2ExecLinstenerThreadDao.class));
	}
	
	public  void deleteExecLog(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM ").append("spinfo.support_exec_log").append(" WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		logBuff.append(",deleteExecLog：" + dt.upDate(sqlBuff.toString(), Game2ExecLinstenerThreadDao.class));
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

		/*
		try {
			crackSyn(dataInfo, crackSynUrl(dataInfo,crackSynUrl,logBuff),logBuff);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
		*/

		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("sevePayResultLog：" + dt.insertJson("support_pay_result", dataInfo, Game2ExecLinstenerThreadDao.class));
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
		sbuff.append("&").append("syn_spincome_repeat=true");
		sbuff.append("&").append("spProductConsumeCodeId=").append(dataInfo.optString("ssid"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			logBuff.append(",crackSynUrl:"+ExceptionTools.exception(e));
		}
		return sbuff.toString();
	}
}
