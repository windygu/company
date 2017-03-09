package com.astrolink.dao;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.RdoExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;

/**
 * 
 * @author sjh
 * @date 2016-03-24
 */
public class RdoExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(RdoExecLinstenerThreadDao.class);
	private String dbTableName;
	public RdoExecLog rdoExecLog;
	public IExecFinish execFinish;
	
	public RdoExecLinstenerThreadDao(RdoExecLog rdoExecLog){
		this.rdoExecLog = rdoExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		try {
			//RDFEE+CP号(5位)+计费点ID(8位)+透传(8位)+IMSI(15位)
			String rdoMoContent = rdoExecLog.getContent();
			String mobile = rdoExecLog.getMobile();
			if(rdoMoContent!=null && !rdoMoContent.equals("") && mobile!=null && !mobile.equals("")){
				rdoExecLog.setCpInfoId(Integer.parseInt(rdoMoContent.substring(0,5)));
				rdoExecLog.setSpProductConsumeCodeId(Integer.parseInt(rdoMoContent.substring(5,13)));
				rdoExecLog.setCpParam(rdoMoContent.substring(13,21));
				rdoExecLog.setMobile(mobile);
				rdoExecLog.setImsi(getImsi(rdoMoContent.substring(21,rdoMoContent.length())));
				rdoExecLog.setImei(getImei(""));
				
				
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				String uasql="SELECT consumePrice,consumeCode,spProductId FROM spinfo.dic_feecode_info where spProductConsumeCodeId='"+rdoExecLog.getSpProductConsumeCodeId()+"'";
				CachedRowSetImpl crsi = dt.executeQuery(uasql, RdoExecLinstenerThreadDao.class);
				if(crsi!=null && crsi.next()){
					rdoExecLog.setSpProductId(crsi.getString("spProductId"));
					rdoExecLog.setConsumePrice(crsi.getString("consumePrice"));
					rdoExecLog.setConsumeCode(crsi.getString("consumeCode"));
				}
				
				rdoExecLog.setSyncurl("http://211.144.37.137:9092/BillInterface/BillByCMCCRDO.aspx?version=2.8&merchantId=10090&imsi="+rdoExecLog.getImsi()+"&imei="+rdoExecLog.getImei()+"&phone="+rdoExecLog.getMobile()+"&amount="+rdoExecLog.getConsumePrice()+"&spId=100050&action=mtVerificationCode");
				
				GetNetWork get = new GetNetWork(rdoExecLog.getSyncurl());
				get.executeMethod();
				rdoExecLog.setSyncstatus(get.getNetState());
				rdoExecLog.setSyncresult(get.getString().replaceAll("'",""));
				rdoExecLog.setDayTime(BasicsTools.getForDate("yyyy-MM-dd"));
				rdoExecLog.setInputDate(BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}finally{
			try {
				sevePayResultLog();
				
				DbTools dt=new  DbTools(Const.DB_QXT_URL,Const.DB_MYSQL_DRIVER,Const.DB_QXT_USERNAME,Const.DB_QXT_PASSWORD);
				dt.upDate("delete from mo_data_rdfee where id='"+rdoExecLog.getId()+"'", RdoExecLinstenerThreadDao.class);
			} catch (Exception e) {
				logger.info("处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
			} finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("处理请求结束，id为" + this.getKey());
				}
			}
		}
	}
	
	public void sevePayResultLog(){
		JSONObject dataInfo=new JSONObject();
		dataInfo.put("cpInfoId", rdoExecLog.getCpInfoId());
		dataInfo.put("spProductId", rdoExecLog.getSpProductId());
		dataInfo.put("spProductConsumeCodeId", rdoExecLog.getSpProductConsumeCodeId());
		dataInfo.put("mobile", rdoExecLog.getMobile());
		dataInfo.put("imsi", rdoExecLog.getImsi());
		dataInfo.put("syncurl", rdoExecLog.getSyncurl());
		dataInfo.put("syncstatus", rdoExecLog.getSyncstatus());
		dataInfo.put("syncresult", rdoExecLog.getSyncresult());
		dataInfo.put("infocode", rdoExecLog.getInfocode());
		dataInfo.put("dayTime", rdoExecLog.getDayTime());
		dataInfo.put("inputDate", rdoExecLog.getInputDate());
		dataInfo.put("mocontent", rdoExecLog.getContent());
		dataInfo.put("cpParam", rdoExecLog.getCpParam());
		dataInfo.put("consumeCode", rdoExecLog.getConsumeCode());
		dataInfo.put("consumePrice", rdoExecLog.getConsumePrice());

		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		logger.info("saveRdoLog：" + dt.insertJson("log_rdo", dataInfo, RdoExecLinstenerThreadDao.class));
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
