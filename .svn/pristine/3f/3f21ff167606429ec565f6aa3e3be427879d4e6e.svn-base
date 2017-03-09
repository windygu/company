package com.astrolink.dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.Cmd;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTool;
import com.astrolink.util.tools.ExceptionTools;
import com.sun.rowset.CachedRowSetImpl;


/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccUpSmsExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccUpSmsExecLinstenerThreadDao.class);
	private String dbTableName;
	public Cmd cmd;
	public IExecFinish execFinish; 
	
	public CtccUpSmsExecLinstenerThreadDao(Cmd cmd){
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
		logger.info("开始发送电信短信，id为" + this.getKey());
		JSONObject json=new JSONObject();
		int status=-1;
		try {
			getCtccSmsProductInfo(cmd,json);//获取信息
			logger.info("信息:"+json);
			if(json.size()!=0){
				deleteCmd(cmd.getId());
				seve_cmd_log(cmd,json);//记录日志
				
				String message=cmd.getMessage();
				try {
					message=message.substring(0,6);
				} catch (Exception e) {}
				
				int infoCode=logicLimit(cmd.getSenderAddress(),"-1",message,json.getString("cpInfoId"),json.getString("spProductConsumeCodeId"));
				status=infoCode;
				//status=dataLimit(cmd,json);
			
				seve_cmd_error(cmd,status,json.getString("spProductCode"));//记录状态日志
				
				if((status==0 || status==1000001) && json.optInt("dicProductTypeId") !=51){
					seve_send(cmd,json);//存入发送表
				}
			}
		}finally{
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logger.info("处理请求结束，id为" + this.getKey());
			}
		}
	}
	public int logicLimit(String mobile ,String imsi,String consumeCode ,String cpInfoId, String getSpProductConsumeCodeId){
		try {
			String sqlp="SELECT spProductId FROM sp_product_consumecode WHERE spProductConsumeCodeId="+getSpProductConsumeCodeId;
			DbTools dtp=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			CachedRowSetImpl crsq=dtp.executeQuery(sqlp, CtccUpSmsExecLinstenerThreadDao.class);
			if(crsq.next()){
				String provId=mobileToProvId(mobile);
				int infoCode=-1; 
				String sql="CALL spinfo.logic_limit('"+mobile+"','"+imsi+"','"+consumeCode+"','"+cpInfoId+"',"+provId+",'"+crsq.getString("spProductId")+"')";
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				CachedRowSetImpl crsi=dt.executeQuery(sql, CtccUpSmsExecLinstenerThreadDao.class);
				ResultSetMetaData rsmd = crsi.getMetaData();
				while (crsi.next()) {
					JSONObject jo=new JSONObject();
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						jo.put(rsmd.getColumnName(i + 1), crsi.getObject(i + 1));
						if(rsmd.getColumnName(i + 1).equals("DB_infoCode")){
							infoCode=crsi.getInt("DB_infoCode");
						}
					}
				}
				return infoCode;
			}else{
				return -1;
			}	
		} catch (Exception e){
			logger.error(ExceptionTool.getErrorInfo(e));
			return -1;
		}
	}
	
	public String mobileToProvId(String mobile) {
		if(mobile.length()>7){
			String sql = "SELECT provCode FROM spinfo.mob_city WHERE mob7=" + mobile.substring(0, 7);
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			CachedRowSetImpl crsi=dt.executeQuery(sql, CtccUpSmsExecLinstenerThreadDao.class);
			try {
				while (crsi.next()) {
					return crsi.getString("provCode");
				}
			} catch (SQLException e) {
				logger.error(ExceptionTool.getErrorInfo(e));
				return "-1";
			}
		}
		return "-1";
	}
	
	private void deleteCmd(long id){
		StringBuffer sBuff=new StringBuffer();
		sBuff.append("DELETE FROM ").append(dbTableName).append(" WHERE id = '").append(id).append("'");
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		dt.upDate(sBuff.toString(), CtccUpSmsExecLinstenerThreadDao.class);
	}
	
	private boolean getCtccSmsProductInfo(Cmd cmd,JSONObject json){
		String consumeCode=String.valueOf(cmd.getMessage());
		if(consumeCode.length()>=6){
			consumeCode=consumeCode.substring(0,6);
		}
		boolean type=false;
		StringBuffer sBuff=new StringBuffer();
		
		sBuff.append(" SELECT a.spProductConsumeCodeId,downInfo,dayLimit,monthLimit,releaseTime,spProductCode,monum,product_isEffective,spCompanyCode,dicProductTypeId,c.cpInfoId ");
		sBuff.append(" FROM ").append(Const.SP_INFO_TABLE_DIC_FEECODE_INFO).append(" AS a ");
		sBuff.append(" LEFT JOIN ").append(Const.SP_INFO_TABLE_GET_CURRENT_CONSUMECODE_CP_ID).append(" AS b ON a.spProductConsumeCodeId=b.spProductConsumeCodeId ");
		sBuff.append(" left join ").append(Const.SP_INFO_TABLE_CP_INFO).append(" as c on b.cpInfoId=c.cpInfoId ");
		sBuff.append(" WHERE consumeCode='").append(consumeCode).append("' AND monum='").append(cmd.getSAN()).append("' ").append(" AND consumecode_isEffective='1' ");
		
		//sBuff.append("SELECT a.spProductConsumeCodeId,downInfo,dayLimit,monthLimit,releaseTime,spProductCode,monum,product_isEffective,spCompanyCode,dicProductTypeId FROM ").append(Const.SP_INFO_TABLE_DIC_FEECODE_INFO).append(" AS a ");
		//sBuff.append(" WHERE consumeCode='").append(consumeCode).append("' AND monum='").append(cmd.getSAN()).append("' ").append(" AND consumecode_isEffective='1' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		CachedRowSetImpl crsi=dt.executeQuery(sBuff.toString(), CtccUpSmsExecLinstenerThreadDao.class);
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
				json.put("spProductConsumeCodeId",crsi.getString("spProductConsumeCodeId"));
				json.put("cpInfoId",crsi.getString("cpInfoId"));
				
				type=true;
			}
		} catch (SQLException e) {
			type=false;
			logger.error(ExceptionTools.exception(e));
		}
		return type;
	}
	
	private void seve_cmd_error(Cmd cmd,int status,String spProductCode){
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		JSONObject jsonCmd=cmd.toJson();
		jsonCmd.put("status",status);
		int id=dt.insertJsonToId(Const.CTCC_SMS_TABLE_CMD_ERROR,jsonCmd,CtccUpSmsExecLinstenerThreadDao.class);
		
		String sql="INSERT INTO ctccsms.cmd_error_productInfo (cmdErrorId, productId) VALUES('"+id+"', '"+spProductCode+"')" ;
		DbTools dtP=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		dtP.upDate(sql, CtccUpSmsExecLinstenerThreadDao.class);
		
	}
	
	private void seve_cmd_log(Cmd cmd,JSONObject json){
		DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
		JSONObject jsonCmd=cmd.toJson();
		jsonCmd.put("result", json.opt("downInfo"));
		jsonCmd.put("rtime", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		dt.insertJson(Const.CTCC_SMS_TABLE_CMD_LOG,jsonCmd,CtccUpSmsExecLinstenerThreadDao.class);
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
		dt.insertJson(Const.CTCC_SMS_TABLE_SEND,jsonSend,CtccUpSmsExecLinstenerThreadDao.class);
	}
}
