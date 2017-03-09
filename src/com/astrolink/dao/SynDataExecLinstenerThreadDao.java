package com.astrolink.dao;

import java.net.URLEncoder;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.SynData;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;


/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class SynDataExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(SynDataExecLinstenerThreadDao.class);
	private String dbTableName;
	public SynData synData;
	public IExecFinish execFinish;
	
	public SynDataExecLinstenerThreadDao(SynData synData){
		this.synData = synData;
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
		}finally{
			try {
				setDataLog();
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
	
	public void setDataLog() {
		String sql="UPDATE spinfo.syn_spincome SET synStatus = '1' WHERE synSpIncomeId ="+synData.getSynSpIncomeId();
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql,SynDataExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}
	
	public String getBindSynUrl(int cpid,int ssid){
		String synUrl="";
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			String sql="SELECT synUrl FROM sp_cpinfo_product_bind AS a INNER JOIN sp_product_consumecode AS b ON a.spProductId=b.spProductId WHERE a.cpInfoId='"+cpid+"' AND spProductConsumeCodeId='"+ssid+"'";
			CachedRowSetImpl  crsi=dt.executeQuery(sql, SynDataExecLinstenerThreadDao.class);
			while (crsi.next()) {
				synUrl=crsi.getString("synUrl");
			}
		} catch (Exception e) {
			synUrl="";
		}
		return synUrl;
	}
	
	/**
	 * 拼接同步url
	 * 
	 * @param tempDate
	 * @return
	 */
	private JSONObject doGetUrl() {
		JSONObject json=new JSONObject();
		try {
			//获取渠道同步url
			String syncurl = synData.getSynUrl();
			
			//获取渠道绑定业务的同步地址
			String bindSynUrl=getBindSynUrl(synData.getCpInfoId(),synData.getSpProductConsumeCodeId());
			if(!bindSynUrl.equals("")){
				syncurl=bindSynUrl;
			}
			
			syncurl = setPram(syncurl);
			
			StringBuffer sbuff=new StringBuffer();
			sbuff.append(syncurl);
			/*if(String.valueOf(synData.getCodeUser()).equals("2")){
				sbuff.append("optype=").append(synData.getOpType());
				sbuff.append("&mobile=").append(synData.getMobile());
				sbuff.append("&linkId=").append(synData.getLinkId());
				sbuff.append("&spNumber=").append(synData.getPseudoNum());
				sbuff.append("&consumeCode=").append(URLEncoder.encode(String.valueOf(synData.getPseudoCode()),"utf-8"));
				sbuff.append("&cpParam=").append(URLEncoder.encode(String.valueOf(synData.getCpParam()),"utf-8"));
				sbuff.append("&syncStatus=").append(synData.getStatus());
				sbuff.append("&price=").append(synData.getPrice());
				sbuff.append("&provinceCode=").append(synData.getProv_ID());
				sbuff.append("&cityCode=").append(synData.getCity_ID());
				sbuff.append("&deductType=").append(synData.getDeductType());
				sbuff.append("&total=").append(synData.getTotal());
				sbuff.append("&ssid=").append(synData.getSpProductConsumeCodeId());
				
				
				 	syncurl += "optype=" + tempDate.get("opType") 
						+ "&mobile=" + tempDate.get("mobile") 
						+ "&linkId=" + tempDate.get("linkId") 
						+ "&spNumber=" + tempDate.get("pseudoNum") 
						+ "&consumeCode=" + URLEncoder.encode(tempDate.get("pseudoCode"),"utf-8") 
						+ "&cpParam=" + URLEncoder.encode(tempDate.get("cpParam"),"utf-8") 
						+ "&syncStatus=" + tempDate.get("status") 
						+ "&price=" + tempDate.get("price") 
						+ "&provinceCode=" + tempDate.get("prov_ID")
						+ "&cityCode=" + tempDate.get("city_ID")
						+ "&deductType=" + tempDate.get("deductType")
						+ "&total=" + tempDate.get("total");
				
				
			}else{*/
				sbuff.append("mobile=").append(synData.getMobile());
				sbuff.append("&cpid=").append(synData.getCpInfoId());
				sbuff.append("&cpparam=").append(URLEncoder.encode(String.valueOf(synData.getCpParam()),"utf-8"));
				sbuff.append("&monum=").append(synData.getPseudoNum());
				sbuff.append("&sid=").append(URLEncoder.encode(String.valueOf(synData.getPseudoCode()),"utf-8"));
				sbuff.append("&imei=").append(synData.getImei());
				sbuff.append("&imsi=").append(synData.getImsi());
				sbuff.append("&linkId=").append(synData.getLinkId());
				sbuff.append("&ssid=").append(synData.getSpProductConsumeCodeId());
				sbuff.append("&price=").append(synData.getPrice());
				sbuff.append("&clientCpparam=").append(synData.getClientCpparam());
				if(String.valueOf(synData.getStatus()).equals("DELIVRD")){
					sbuff.append("&status=").append("0");
				}else{
					sbuff.append("&status=").append(synData.getStatus());
				}
				sbuff.append("&message=").append(URLEncoder.encode(String.valueOf(synData.getMessage()),"utf-8"));
				//sbuff.append("optype=").append(tempDate.get("opType"));
				//sbuff.append("price=").append(tempDate.get("price"));
				//sbuff.append("provinceCode=").append(tempDate.get("prov_ID"));
				//sbuff.append("cityCode=").append(tempDate.get("city_ID"));
			//}
			
			try {
				JSONObject otherInfo=JSONObject.fromObject(synData.getOtherInfo());
				if(otherInfo!=null){
					  Iterator it = otherInfo.keys();  
					  while (it.hasNext()) {  
					       String key = (String) it.next();  
					       String value = otherInfo.optString(key);
					       sbuff.append("&"+key+"=").append(URLEncoder.encode(String.valueOf(value),"utf-8"));
					  }
				}
			} catch (Exception e) {}
			
			syncurl=sbuff.toString().trim();
			logger.info(sbuff.toString());
			GetNetWork gnw = new GetNetWork(sbuff.toString());
			gnw.executeMethod();
			
			int synstatus = gnw.getNetState();
			String synresult = gnw.getString();
			
			json.put("syncurl", syncurl);
			json.put("synstatus", synstatus + "");
			json.put("synresult", synresult.replaceAll("'",""));
			gnw.closeConn();
		} catch (Exception e) {
			json.put("synstatus", String.valueOf(0));
			json.put("synresult", "nullError");
			logger.debug("访问同步地址出现异常");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 填充SYN_SDKIncomeBean
	 * 
	 * @param tempDate
	 * @return
	 */
	private void getSynBean(JSONObject json) {
		String sql="INSERT INTO syn_cp_spincomelog (synSpIncomeId,synstatus,synresult,synUrl,inputDate)VALUES('"+synData.getSynSpIncomeId()+"','"+json.optString("synstatus")+"','"+json.optString("synresult")+"','"+json.optString("syncurl")+"',now())" ;
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql,SynDataExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}

	/**
	 * 访问url拼接参数
	 * 
	 * @param url
	 *            请求url
	 * @param pram
	 *            url参数
	 * @return 访问url
	 */
	private String setPram(String url) {
		url = String.valueOf(url);
		if (!url.equals("null") && !url.equals("")) {
			if (url.indexOf("?") != -1) {
				url += "&";
			} else {
				url += "?";
			}
		} else {
			url = "";
		}
		return url;
	}
}
