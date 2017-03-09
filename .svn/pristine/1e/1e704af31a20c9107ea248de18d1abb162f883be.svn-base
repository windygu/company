package com.astrolink.dao;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.Complaint;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;

public class ComplaintExecLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(ComplaintExecLinstenerThreadDao.class);
	private String dbTableName;
	public Complaint complaint;
	public IExecFinish execFinish;
	
	public ComplaintExecLinstenerThreadDao(Complaint complaint) {
		this.complaint = complaint;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	
	@Override
	public void exec() {
		logger.info("开始数据同步确认，id为" + this.getKey());
		try {
			getSynBean(doGetUrl());
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}finally {
			try {
				setDataLog();
			} catch (Exception e2) {
				logger.info("处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e2));
			}finally {
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("处理请求结束，id为" + this.getKey());
				}
			}
		}

	}
	
	public void setDataLog() {
		String sql = "UPDATE spinfo.sp_complaint SET synType = '1' WHERE spComplaintId="+complaint.getSpComplaintId();
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql, ComplaintExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}
	
	private JSONObject doGetUrl() {
		JSONObject json=new JSONObject();
		try {
			String synUrl = "http://121.42.15.79:6400/complaint/sync.ashx?";
			StringBuffer sbuff=new StringBuffer();
			sbuff.append(synUrl);
			sbuff.append("mobile=").append(complaint.getMobile());
			sbuff.append("&consumeCode=").append(complaint.getConsumeCode());
			sbuff.append("&monum=").append(complaint.getMonum());
			sbuff.append("&cpParam=").append(complaint.getCpParam());
			sbuff.append("&ssid=").append(complaint.getSpProductConsumeCodeId());
			synUrl = sbuff.toString().trim();
			
			logger.info(sbuff.toString());
			
			GetNetWork gnw = new GetNetWork(sbuff.toString());
			gnw.executeMethod();
			
			int synstatus = gnw.getNetState();
			String synresult = gnw.getString();
			
			json.put("synUrl", synUrl);
			json.put("synStatus", synstatus + "");
			json.put("synResult", synresult.replaceAll("'",""));
		} catch (Exception e) {
			json.put("synStatus", String.valueOf(0));
			json.put("synResult", "nullError");
			logger.debug("访问同步地址出现异常");
			e.printStackTrace();
		}
		return json;
	}
	
	
	private void getSynBean(JSONObject json) {
		String sql = "UPDATE sp_complaint SET synStatus='"+json.optString("synStatus")+"',synResult='"+json.optString("synResult")+"',synUrl='"+json.optString("synUrl")+"' WHERE spComplaintId='"+complaint.getSpComplaintId()+"'";
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql, ComplaintExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}

}
