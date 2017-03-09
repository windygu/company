package com.astrolink.dao;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.SupportAttrLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.business.WoChannel20NetTools;

import net.sf.json.JSONObject;


/**
 * 执行逻辑线程
 * @author cuilei
 * @date 2015-11-30
 */
public class WoChannel20SmsExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(WoChannel20SmsExecLinstenerThreadDao.class);
	public SupportAttrLog supportAttrLog;
	public IExecFinish execFinish;
	
	public WoChannel20SmsExecLinstenerThreadDao(SupportAttrLog supportAttrLog){
		this.supportAttrLog = supportAttrLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}

	@Override
	public void exec() {
		logger.info("开始沃渠道20计费确认，id为" + this.getKey());
		JSONObject attrInfo = null;
		try {
			attrInfo = supportAttrLog.getSupportAttrInfoToJSON();
			WoChannel20NetTools.UnipaySDKUpdate(attrInfo);
			//MySleep(1000);
			WoChannel20NetTools.UnipayLogin(attrInfo);
			//MySleep();
			WoChannel20NetTools.UnipayPay(attrInfo);
			//MySleep();
			WoChannel20NetTools.UnipayQueryService(attrInfo);
			//MySleep(1000);
			WoChannel20NetTools.UnipayPrecheck(attrInfo);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		} finally{
			try {
				updataAttr(attrInfo, supportAttrLog.getSupportExecLogId());
				updataExecLog(supportAttrLog.getSupportExecLogId(), attrInfo);
				sevePayResultLog(attrInfo, supportAttrLog);
			} catch (Exception e2) {}
			
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logger.info("处理请求结束，id为" + this.getKey());
			}
		}
	}
	
	public void updataAttr(JSONObject attrInfo, long id) {
		if(attrInfo!=null){
			StringBuffer sqlBuff = new StringBuffer();
			sqlBuff.append("UPDATE support_attr_log SET supportAttrInfo = '" + String.valueOf(attrInfo) + "' WHERE supportExecLogId = '" + id + "'");
			DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
			logger.info("updateExecNum：" + dt.upDate(sqlBuff.toString(), WoChannel20SmsExecLinstenerThreadDao.class));
		}
	}

	public void updataExecLog(long id, JSONObject attrInfo) {
		StringBuffer sqlBuff = new StringBuffer();
		if(attrInfo!=null){
			sqlBuff.append("UPDATE support_exec_log SET execNum = execNum+1,execState = '1',execStep='" + attrInfo.optString("execStep", "-1") + "',execResultCode='" + attrInfo.optString("execResultCode", "-1") + "',execResultInfo='" + attrInfo.optString("execResultInfo", "error") + "' WHERE id= '").append(id).append("'");
		}else{
			sqlBuff.append("UPDATE support_exec_log SET execNum = execNum+1,execState = '1' WHERE id= '").append(id).append("'");
		}
		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("deleteExecLog：" + dt.upDate(sqlBuff.toString(), WoChannel20SmsExecLinstenerThreadDao.class));
	}
	
	public void sevePayResultLog(JSONObject attrInfo, SupportAttrLog supportAttrLog) {
		JSONObject dataInfo = new JSONObject();
		dataInfo.put("execLogId", supportAttrLog.getSupportExecLogId());
		dataInfo.put("status", attrInfo.optString("execResultCode", "-1"));
		dataInfo.put("message", attrInfo.optString("execResultInfo", "error"));
		dataInfo.put("imei", attrInfo.optString("imei"));
		dataInfo.put("imsi", attrInfo.optString("imsi"));
		dataInfo.put("monum", "10655198018");
		dataInfo.put("consumeCode", attrInfo.optString("consumeCode"));
		dataInfo.put("cpparam", attrInfo.optString("cpparam"));
		dataInfo.put("execNum", supportAttrLog.getExecNum());
		dataInfo.put("phoneNumber", attrInfo.optLong("phoneNumber"));
		dataInfo.put("cpInfoId", attrInfo.optString("cpInfoId"));
		dataInfo.put("transId", attrInfo.optString("OrderId") + BasicsTools.getUuid(true, 5, Const.random));
		dataInfo.put("dayTime", BasicsTools.getForDate("yyyy-MM-dd"));
		dataInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		dataInfo.put("methodType", supportAttrLog.getMethodType());
		dataInfo.put("channelId", attrInfo.optString("platformChannelCode"));
		dataInfo.put("infoCode", 0);
		dataInfo.put("ssid", attrInfo.optString("ssid"));
		if (attrInfo.optString("proxyIp").equals("")) {
			dataInfo.put("proxyIp", "");
		} else {
			dataInfo.put("proxyIp", attrInfo.optString("proxyIp"));
		}

		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("sevePayResultLog：" + dt.insertJson("support_pay_result", dataInfo, WoChannel20SmsExecLinstenerThreadDao.class));
	}

}