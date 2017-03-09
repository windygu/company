package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.MmsExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;

import net.sf.json.JSONObject;

/**
 * 发送短信线程
 * @author sjh
 * @date 2016-4-15
 */
public class MmsExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(MmsExecLinstenerThreadDao.class);
	private String dbTableName;
	public MmsExecLog mmsExecLog;
	public IExecFinish execFinish;
	
	public MmsExecLinstenerThreadDao(MmsExecLog mmsExecLog){
		this.mmsExecLog = mmsExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		StringBuffer logBuff=new StringBuffer();
		try {
			//得到sms_exec_log
			DbTools dt=new  DbTools(Const.DB_MMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_MMS_USERNAME,Const.DB_MMS_PASSWORD);
			String sql="SELECT sms_exec_log.*,cp_info.crackSynUrl FROM mms.sms_exec_log INNER JOIN spinfo.cp_info ON sms_exec_log.cpinfoId=cp_info.cpinfoId where linkId='"+mmsExecLog.getLinkedID()+"' LIMIT 1";
			CachedRowSetImpl crsi = dt.executeQuery(sql, MusicExecLinstenerThreadDao.class);
			if(crsi!=null && crsi.next()){
				logBuff.append("linkId：" + mmsExecLog.getLinkedID()+"，开始处理。");
				JSONObject dataInfo=new JSONObject();
				dataInfo.put("phoneNumber", crsi.getString("mobile"));
				dataInfo.put("cpInfoId", crsi.getString("cpInfoId"));
				dataInfo.put("cpparam", "");
				dataInfo.put("monum", crsi.getString("monum"));
				dataInfo.put("consumeCode", crsi.getString("consumeCode"));
				dataInfo.put("imei", "");
				dataInfo.put("imsi", "");
				dataInfo.put("transId", crsi.getString("linkId"));
				dataInfo.put("ssid", crsi.getString("ssid"));
				if(mmsExecLog.getRestext().equals("1000")){
					dataInfo.put("status", "0");
				}else{
					dataInfo.put("status",mmsExecLog.getRestext());
				}
				
				dataInfo.put("chid", "0");
				crackSyn(dataInfo,crackSynUrl(dataInfo,crsi.getString("crackSynUrl"),logBuff),logBuff);
				
				deleteSmsExecLog(crsi.getString("id"),logBuff);
			}else{
				logBuff.append(",在sms_exec_log表没找到对应数据。");
			}
			deleteSendtmp(mmsExecLog.getMmsId(),logBuff);
			deleteSendstate(mmsExecLog.getMmsId(),logBuff);
		}catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			try{
				//保存历史数据
				seveSendtmpstate(logBuff);
			}catch(Exception ex){
			}finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info(",处理请求结束，id为" + this.getKey());
				}
			}
			
			logger.info(logBuff.toString());
		}
	}
	
	public  void deleteSmsExecLog(String id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM sms_exec_log WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_MMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_MMS_USERNAME,Const.DB_MMS_PASSWORD);
		logBuff.append(",deleteSmsExecLog：" + dt.upDate(sqlBuff.toString(), MmsExecLinstenerThreadDao.class));
	}
	
	public  void deleteSendtmp(String MmsId,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM sendtmp WHERE `MmsId` = '").append(MmsId).append("' ");
		DbTools dt=new  DbTools(Const.DB_MMS_URL_GW,Const.DB_MYSQL_DRIVER,Const.DB_MMS_USERNAME_GW,Const.DB_MMS_PASSWORD_GW);
		logBuff.append(",deleteSendtmp：" + dt.upDate(sqlBuff.toString(), MmsExecLinstenerThreadDao.class));
	}
	
	public  void deleteSendstate(String Msgid,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM sendstate WHERE `Msgid` = '").append(Msgid).append("' ");
		DbTools dt=new  DbTools(Const.DB_MMS_URL_GW,Const.DB_MYSQL_DRIVER,Const.DB_MMS_USERNAME_GW,Const.DB_MMS_PASSWORD_GW);
		logBuff.append(",deleteSendstate：" + dt.upDate(sqlBuff.toString(), MmsExecLinstenerThreadDao.class));
	}
	
	public void seveSendtmpstate(StringBuffer logBuff){
		JSONObject dataInfo=new JSONObject();
		dataInfo.put("smsgid",mmsExecLog.getSmsgid());
		dataInfo.put("gate",mmsExecLog.getGate());
		dataInfo.put("SrctermID",mmsExecLog.getSrctermID());
		dataInfo.put("DestMainID",mmsExecLog.getDestMainID());
		dataInfo.put("DestAttaID",mmsExecLog.getDestAttaID());
		dataInfo.put("DestSecrID",mmsExecLog.getDestSecrID());
		dataInfo.put("FeeTermID",mmsExecLog.getFeeTermID());
		dataInfo.put("MmsId",mmsExecLog.getMmsId());
		dataInfo.put("MmsSubject",mmsExecLog.getMmsSubject());
		dataInfo.put("MmsDir",mmsExecLog.getMmsDir());
		dataInfo.put("MmsPriority",mmsExecLog.getMmsPriority());
		dataInfo.put("Mms_SvcID",mmsExecLog.getMms_SvcID());
		dataInfo.put("MmsClass",mmsExecLog.getMmsClass());
		dataInfo.put("Sendvisible",mmsExecLog.getSendvisible());
		dataInfo.put("FeeType",mmsExecLog.getFeeType());
		dataInfo.put("FeeCode",mmsExecLog.getFeeCode());
		dataInfo.put("FeeUserType",mmsExecLog.getFeeUserType());
		dataInfo.put("Method",mmsExecLog.getMethod());
		dataInfo.put("MsgFormat",mmsExecLog.getMsgFormat());
		dataInfo.put("time", BasicsTools.TimestampToString(mmsExecLog.getTime()));
		dataInfo.put("LinkedID",mmsExecLog.getLinkedID());
		dataInfo.put("status",mmsExecLog.getStatus());
		dataInfo.put("devtime",mmsExecLog.getDevtime());
		dataInfo.put("resstate",mmsExecLog.getResstate());
		dataInfo.put("restext",mmsExecLog.getRestext());
		dataInfo.put("stime",BasicsTools.TimestampToString(mmsExecLog.getStime()));

		DbTools dt=new  DbTools(Const.DB_MMS_URL_GW,Const.DB_MYSQL_DRIVER,Const.DB_MMS_USERNAME_GW,Const.DB_MMS_PASSWORD_GW);
		logBuff.append(",sevePayResultLog：" + dt.insertJson("sendtmp_state", dataInfo, MmsExecLinstenerThreadDao.class));
	}
	
	public void crackSyn(JSONObject dataInfo,String url,StringBuffer logBuff){
		GetNetWork get=new GetNetWork(url);
		get.executeMethod();
		dataInfo.put("synUrl", url);
		dataInfo.put("synstatus", get.getNetState());
		dataInfo.put("synresult", get.getString().replaceAll("'",""));
		logBuff.append(",crackSynUrl:"+dataInfo.toString());
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
		sbuff.append("&").append("chid=").append(dataInfo.optString("chid"));
		sbuff.append("&").append("spProductConsumeCodeId=").append(dataInfo.optString("ssid"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			logBuff.append(ExceptionTools.exception(e));
		}
		return sbuff.toString();
	}
}
