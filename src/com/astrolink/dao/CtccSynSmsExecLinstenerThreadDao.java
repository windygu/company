package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.Cmd;
import com.astrolink.domain.Sendtmp;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;


/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccSynSmsExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccSynSmsExecLinstenerThreadDao.class);
	private String dbTableName;
	public Sendtmp sendtmp;
	public IExecFinish execFinish; 
	
	public CtccSynSmsExecLinstenerThreadDao(Sendtmp sendtmp){
		this.sendtmp = sendtmp;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		logger.info("开始发送电信短信同步处理，id为" + this.getKey());
		JSONObject json=new JSONObject();
		try {
			if(getCtccSmsProductInfo(sendtmp,json)){
				seveSendanaLog(sendtmp,json);
			}
		}finally{
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logger.info("同步处理请求结束，id为" + this.getKey());
			}
		}
	}
	
	private boolean getCtccSmsProductInfo(Sendtmp sendtmp,JSONObject json){
		String consumeCode=String.valueOf(sendtmp.getSubject());
		if(consumeCode.length()>=6){
			consumeCode=consumeCode.substring(0,6);
		}
		boolean type=false;
		StringBuffer sBuff=new StringBuffer();
		sBuff.append(" SELECT a.spProductConsumeCodeId,consumeCode,consumePrice,crackSynUrl,deductSettl ");
		sBuff.append(" FROM ").append(Const.SP_INFO_TABLE_DIC_FEECODE_INFO).append(" AS a ");
		sBuff.append(" LEFT JOIN ").append(Const.SP_INFO_TABLE_GET_CURRENT_CONSUMECODE_CP_ID).append(" AS b ON a.spProductConsumeCodeId=b.spProductConsumeCodeId ");
		sBuff.append(" left join ").append(Const.SP_INFO_TABLE_CP_INFO).append(" as c on b.cpInfoId=c.cpInfoId ");
		sBuff.append(" WHERE consumeCode='").append(consumeCode).append("' AND monum='").append(sendtmp.getSrc()).append("' ").append(" AND consumecode_isEffective='1' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		CachedRowSetImpl crsi=dt.executeQuery(sBuff.toString(), CtccUpSmsExecLinstenerThreadDao.class);
		try {
			if(crsi.next()){
				json.put("consumeCode",crsi.getString("consumeCode"));
				json.put("consumePrice",crsi.getString("consumePrice"));
				json.put("crackSynUrl",crsi.getString("crackSynUrl"));
				json.put("deductSettl",crsi.getString("deductSettl"));
				type=true;
			}
		} catch (SQLException e) {
			type=false;
			logger.error(ExceptionTools.exception(e));
		}finally{
			DbTools dtd=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
			dtd.upDate("DELETE FROM "+dbTableName+" WHERE id = '"+sendtmp.getId()+"'",  CtccSynSmsExecLinstenerThreadDao.class);
		}
		return type;
	}
	
	public void seveSendanaLog(Sendtmp sendtmp,JSONObject json){
		JSONObject dataInfo=new JSONObject();
		dataInfo.put("dest",sendtmp.getDest() );
		dataInfo.put("src", sendtmp.getSrc());
		dataInfo.put("OA", sendtmp.getOA());
		dataInfo.put("FA", sendtmp.getFA());
		dataInfo.put("subject", sendtmp.getSubject());
		dataInfo.put("service_id", sendtmp.getService_id());
		dataInfo.put("msg", sendtmp.getMsg());
		dataInfo.put("link_id", sendtmp.getLink_id());
		dataInfo.put("method", sendtmp.getMethod());
		dataInfo.put("session_id", sendtmp.getSession_id());
		dataInfo.put("session_end", sendtmp.getSession_end());
		dataInfo.put("request_identifier", sendtmp.getRequest_identifier());
		dataInfo.put("result", sendtmp.getResult());
		dataInfo.put("time", sendtmp.getTime());
		dataInfo.put("dr", sendtmp.getDr());
		dataInfo.put("drtime", sendtmp.getDrtime());
		try {
			crackSyn(dataInfo,crackSynUrl(dataInfo,json,sendtmp.getTempCpid()));
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
		//dataInfo.put("consumeCode", json.optString("consumeCode"));
		
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		dt.insertJson(Const.CTCC_SMS_TABLE_SENDANA, dataInfo, CtccSynSmsExecLinstenerThreadDao.class);
		
		DbTools dtd=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		dtd.upDate("UPDATE  ctccsms.cmd_error_productInfo SET tempCpid = '0' where cmdErrorId="+sendtmp.getCmdErrorId(), CtccSynSmsExecLinstenerThreadDao.class);
		
	}
	
	public void crackSyn(JSONObject dataInfo,String url){
		GetNetWork get=new GetNetWork(url);
		get.executeMethod();
		dataInfo.put("synurl", url);
		dataInfo.put("synstatus", get.getNetState());
		dataInfo.put("synresult", get.getString().replaceAll("'",""));
	}
	
	public String crackSynUrl(JSONObject dataInfo,JSONObject json,long tempCpid){
		//http://101.201.149.173/web/sync/plan68.jsp?status=DeliveredToTerminal&linkid=01211326378859279131&spsrc=10666798103&cmd=b1134205221499&price=&mobile=18985821823&time=2016-01-21%2013%3A27%3A18
		StringBuffer sbuff =new StringBuffer();
		sbuff.append(json.optString("crackSynUrl"));
		sbuff.append("?").append("mobile=").append(dataInfo.optString("dest"));
		sbuff.append("&").append("monum=").append(dataInfo.optString("src"));
		sbuff.append("&").append("sid=");
		try {
			sbuff.append(dataInfo.optString("subject").substring(0,6));
		} catch (Exception e) {
			sbuff.append(dataInfo.optString("subject"));
		}
		sbuff.append("&").append("cpparam=").append(dataInfo.optString("subject"));
		sbuff.append("&").append("linkId=").append(dataInfo.optString("link_id"));
		if(dataInfo.optString("dr").equals("DeliveredToTerminal")){
			sbuff.append("&").append("status=").append(0);
		}else{
			sbuff.append("&").append("status=").append(dataInfo.optString("dr"));
		}
		sbuff.append("&").append("chid=").append(0);
		try {
			sbuff.append("&").append("time=").append(URLEncoder.encode(dataInfo.optString("drtime"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if(tempCpid!=0){
			sbuff.append("&").append("cpid=").append(tempCpid);
		}
		return sbuff.toString();
		
		/*
		StringBuffer sbuff =new StringBuffer();
		sbuff.append(json.optString("crackSynUrl"));
		sbuff.append("?").append("status=").append(dataInfo.optString("dr"));
		sbuff.append("&").append("linkid=").append(dataInfo.optString("link_id"));
		sbuff.append("&").append("spsrc=").append(dataInfo.optString("src"));
		sbuff.append("&").append("cmd=").append(dataInfo.optString("subject"));
		sbuff.append("&").append("price=").append(json.optString("consumePrice"));
		sbuff.append("&").append("mobile=").append(dataInfo.optString("dest"));
		try {
			sbuff.append("&").append("time=").append(URLEncoder.encode(dataInfo.optString("drtime"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sbuff.toString();
		*/
	} 

}
