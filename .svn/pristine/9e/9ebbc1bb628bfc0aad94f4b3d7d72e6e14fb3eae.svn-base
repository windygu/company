package com.astrolink.dao;

import java.sql.SQLException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.Cmd;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.sun.rowset.CachedRowSetImpl;


/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccSendSmsExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccSendSmsExecLinstenerThreadDao.class);
	private String dbTableName;
	public Cmd cmd;
	public IExecFinish execFinish; 
	
	public CtccSendSmsExecLinstenerThreadDao(Cmd cmd){
		this.cmd = cmd;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		logger.info("开始发送电信包月短信，id为" + this.getKey());
		JSONObject json=new JSONObject();
		try {
			getCtccSmsProductInfo(cmd,json);//获取信息
			logger.info("信息:"+json);
			if(json.size()!=0){
					try {
						DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
						String sqlStr="UPDATE  ctccsms.order SET STATUS = '1' WHERE userID = '"+cmd.getSenderAddress()+"'  AND productID = '"+json.getString("spProductCode")+"' ";
						if(dt.upDate(sqlStr, CtccSendSmsExecLinstenerThreadDao.class)){
							seve_send(cmd,json);//存入发送表
						}
					} catch (Exception e) {
						logger.error(ExceptionTools.exception(e));
					}
			}
		}finally{
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logger.info("处理请求结束，id为" + this.getKey());
			}
		}
	}
	
	private boolean getCtccSmsProductInfo(Cmd cmd,JSONObject json){
		String consumeCode=String.valueOf(cmd.getMessage());
		if(consumeCode.length()>=6){
			consumeCode=consumeCode.substring(0,6);
		}
		boolean type=false;
		StringBuffer sBuff=new StringBuffer();
		
		//sBuff.append(" SELECT a.spProductConsumeCodeId,downInfo,dayLimit,monthLimit,releaseTime,spProductCode,monum,product_isEffective,spCompanyCode,deductSettl ");
		//sBuff.append(" FROM ").append(Const.SP_INFO_TABLE_DIC_FEECODE_INFO).append(" AS a ");
		//sBuff.append(" LEFT JOIN ").append(Const.SP_INFO_TABLE_GET_CURRENT_CONSUMECODE_CP_ID).append(" AS b ON a.spProductConsumeCodeId=b.spProductConsumeCodeId ");
		//sBuff.append(" left join ").append(Const.SP_INFO_TABLE_CP_INFO).append(" as c on b.cpInfoId=c.cpInfoId ");
		//sBuff.append(" WHERE consumeCode='").append(consumeCode).append("' AND monum='").append(cmd.getSAN()).append("' ").append(" AND consumecode_isEffective='1' ");
		
		sBuff.append("SELECT a.spProductConsumeCodeId,downInfo,dayLimit,monthLimit,releaseTime,spProductCode,monum,product_isEffective,spCompanyCode,dicProductTypeId FROM ").append(Const.SP_INFO_TABLE_DIC_FEECODE_INFO).append(" AS a ");
		sBuff.append(" WHERE consumeCode='").append(consumeCode).append("' AND monum='").append(cmd.getSAN()).append("' ").append(" AND consumecode_isEffective='1' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		CachedRowSetImpl crsi=dt.executeQuery(sBuff.toString(), CtccSendSmsExecLinstenerThreadDao.class);
		try {
			if(crsi.next()){
				json.put("downInfo",crsi.getString("downInfo"));
				json.put("spProductCode",crsi.getString("spProductCode"));
				json.put("monum",crsi.getString("monum"));
				json.put("product_isEffective",crsi.getString("product_isEffective"));
				json.put("spCompanyCode",crsi.getString("spCompanyCode"));
				//json.put("deductSettl",crsi.getString("deductSettl"));
				json.put("dayLimit",crsi.getString("dayLimit"));
				json.put("monthLimit",crsi.getString("monthLimit"));
				json.put("releaseTime",crsi.getString("releaseTime"));
				json.put("dicProductTypeId",crsi.getString("dicProductTypeId"));
				type=true;
			}
		} catch (SQLException e) {
			type=false;
			logger.error(ExceptionTools.exception(e));
		}
		return type;
	}
	
	private void seve_send(Cmd cmd,JSONObject json){
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		JSONObject jsonSend=new JSONObject();
		jsonSend.put("dest", cmd.getSenderAddress());
		jsonSend.put("src", cmd.getSAN());
		jsonSend.put("OA", cmd.getSenderAddress());
		jsonSend.put("FA", "");
		jsonSend.put("subject", cmd.getMessage());
		jsonSend.put("msg", json.getString("downInfo"));
		jsonSend.put("service_id", json.getString("spProductCode"));
		jsonSend.put("link_id", cmd.getLinkId());
		jsonSend.put("method", "SMS");
		jsonSend.put("session_id", "");
		jsonSend.put("session_end","");
		jsonSend.put("time", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		int id=dt.insertJsonToId(Const.CTCC_SMS_TABLE_SEND,jsonSend,CtccSendSmsExecLinstenerThreadDao.class);
		
		DbTools dt_otherInfo=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		JSONObject jsonSend_otherInfo=new JSONObject();
		jsonSend_otherInfo.put("sendId", id);
		jsonSend_otherInfo.put("cmdErrorId", cmd.getId());
		jsonSend_otherInfo.put("tempCpid", cmd.getTempCpid());
		jsonSend_otherInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		dt_otherInfo.insertJson("send_otherInfo",jsonSend_otherInfo,CtccSendSmsExecLinstenerThreadDao.class);
	}
}
