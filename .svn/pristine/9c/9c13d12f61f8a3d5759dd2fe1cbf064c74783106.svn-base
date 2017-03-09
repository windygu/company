package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.WoShopExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTool;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.PostNetWork;
import com.astrolink.util.tools.business.CryptUtil;

/**
 * 
 * @author sjh
 * @date 2016-06-06
 */
public class WoShopExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(WoShopExecLinstenerThreadDao.class);
	private String dbTableName;
	public WoShopExecLog woShopExecLog;
	public IExecFinish execFinish;
	
	public WoShopExecLinstenerThreadDao(WoShopExecLog woShopExecLog){
		this.woShopExecLog = woShopExecLog;
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
		logBuff.append("跑行为开始：id为" + this.getKey()+";imsi:"+woShopExecLog.getImsi());
		try{
			precheck();
			getOff();

			// open payview
			queryAccumulate();
			getOff();

			// ensure send sms
			ordercheck();
			getOff();
			unipayLog2();
			
			updateExecNum(woShopExecLog.getId(),logBuff);
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logBuff.append(",处理请求结束，id为" + this.getKey());
			}
			logger.info(logBuff.toString());
		}
	}
	
	public  void updateExecNum(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE ").append(dbTableName).append(" SET execNum = execNum+1").append(" WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_WOPLUS_URL,Const.DB_MYSQL_DRIVER,Const.DB_WOPLUS_USERNAME,Const.DB_WOPLUS_PASSWORD);
		logBuff.append(",updateExecNum：" + dt.upDate(sqlBuff.toString(), WoShopExecLinstenerThreadDao.class));
	}
	
	private String post_doNetWork(String netURL,String proxyIp,String info) {
		PostNetWork postNetWork =null;
		String result = "";
		try {
			postNetWork = new PostNetWork(netURL);
			postNetWork.setConnectionTimeout(10000);
			postNetWork.setSoTimeout(30000);

		 	if(proxyIp==null || proxyIp.equals("null") || proxyIp.equals("")){
				postNetWork.executeMethod();
				result = postNetWork.getString("UTF-8");
			}else{
				String[] Proxy =proxyIp.split(":");
				postNetWork.setProxyHost(Proxy[0]);
				postNetWork.setProxyPort(Integer.parseInt(Proxy[1]));
				postNetWork.executeMethod(true);
				result = postNetWork.getString("UTF-8","GZIP");
			}
			postNetWork.getNetState();
			postNetWork.setInfoByte(info.getBytes());
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
		} finally {
			postNetWork.closeConn();
		}
		return result;
	} 

	private String get_doNetWork(String netURL,String proxyIp) {
		GetNetWork getNetWork =null;
		String result = "";
		try {
			getNetWork = new GetNetWork(netURL);
			getNetWork.setConnectionTimeout(10000);
			getNetWork.setSoTimeout(30000);
			
		 	if(proxyIp==null || proxyIp.equals("null") || proxyIp.equals("")){
		 		getNetWork.executeMethod();
				result = getNetWork.getString("UTF-8");
			}else{
				String[] Proxy =proxyIp.split(":");
				getNetWork.setProxyHost(Proxy[0]);
				getNetWork.setProxyPort(Integer.parseInt(Proxy[1]));
				getNetWork.executeMethod(true);
				result = getNetWork.getString("UTF-8","GZIP");
			}
		 	getNetWork.getNetState();
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
		} finally {
			getNetWork.closeConn();
		}
		return result;
	} 
	
	public void unipayLog2() throws UnsupportedEncodingException {
		String url = "http://unilog.wostore.cn:8061/logserver/unipay/unipayLog2";
		String info = CryptUtil.encryptBy3DesAndBase64(
				URLEncoder.encode(getPayLog(), "utf-8"), "logkeyStore");

		post_doNetWork(url, null,info);
	}

	private String getPayLog() {
		JSONObject json = new JSONObject();
		json.put("result", 2801);
		json.put("vaccode", woShopExecLog.getConsumeCode());
		json.put("logtype", "pay");
		json.put("userid", "");
		json.put("appid", woShopExecLog.getAppId());
		json.put("cpid", woShopExecLog.getCpId());
		json.put("payway", "");
		json.put("net", "WIFI");
		json.put("errcode", "");
		json.put("ip", "192.168.254.162");
		json.put("sdkversion", woShopExecLog.getSdkversion());
		json.put("ua", woShopExecLog.getUa());
		json.put("orderid", woShopExecLog.getCpparam());
		json.put("imsi", woShopExecLog.getImsi());
		json.put("datetime", getDateTime());
		json.put("channel", woShopExecLog.getChannel());
		json.put("isshowpage", true);
		return json.toString();
	}

	public String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public void ordercheck() throws UnsupportedEncodingException {
		String url = "http://secpay.wostore.cn:81/unipay/ordercheck";
		JSONObject json = new JSONObject();
		json.put("worderid", "");
		json.put("cpid", woShopExecLog.getCpId());
		json.put("orderid", woShopExecLog.getCpparam());
		json.put("ordertime",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		json.put("imsi", woShopExecLog.getImsi());
		json.put("serviceid", woShopExecLog.getConsumeCode());
		json.put("paytype", "1");
		String info = CryptUtil.encryptBy3DesAndBase64(
				URLEncoder.encode(json.toString(), "utf-8"), "FILTERMAN");
		post_doNetWork(url, null,info);
	}

	public void queryAccumulate() throws UnsupportedEncodingException {
		String url = "http://secpay.wostore.cn:81/unipay/queryAccumulate";
		JSONObject json = new JSONObject();
		json.put("random",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		json.put("imsi", woShopExecLog.getImsi());
		String info = CryptUtil.encryptBy3DesAndBase64(
				URLEncoder.encode(json.toString(), "utf-8"), "FILTERMAN");

		post_doNetWork(url, null,info);
	}

	public void precheck() throws UnsupportedEncodingException {
		String url = "http://secpay.wostore.cn:81/unipay/precheck";
		String info = getPayInfo();
		info = CryptUtil.encryptBy3DesAndBase64(
				URLEncoder.encode(info, "utf-8"), "FILTERMAN");

		post_doNetWork(url, null,info);
	}

	public void getOff() throws UnsupportedEncodingException {
		String url = "http://vipservice.wostore.cn/OrderServer/orderEncrypt/getOff";
		String info = getOffInfo();
		info = CryptUtil.encryptBy3DesAndBase64(
				URLEncoder.encode(info, "utf-8"), "!wostoresecret!#$%107482");

		post_doNetWork(url, null,info);
	}

	private String getOffInfo() {
		JSONObject json = new JSONObject();
		json.put("userimsi", woShopExecLog.getImsi());
		json.put("appid", woShopExecLog.getAppId());
		json.put("version", woShopExecLog.getAppversion());
		json.put("vercode", woShopExecLog.getSdkVersionCode());
		json.put("channelid", woShopExecLog.getChannel());
		return json.toString();
	}

	private String getPayInfo() {
		JSONObject json = new JSONObject();

		json.put("imei", woShopExecLog.getImei());
		json.put("appversion", woShopExecLog.getAppversion());
		json.put("appid", woShopExecLog.getAppId());
		json.put("sdktotalversion", woShopExecLog.getSdkversion());
		json.put("cpid", woShopExecLog.getCpId());
		json.put("mac", woShopExecLog.getMac());
		json.put("resolution", woShopExecLog.getResolution());
		json.put("appdeveloper", woShopExecLog.getCompany());
		json.put("channelid", woShopExecLog.getChannel());
		json.put("sdkversion", woShopExecLog.getSdkVersionCode());
		json.put("paytype", "1");
		json.put("appname", woShopExecLog.getGameName());
		json.put("imsi", woShopExecLog.getImsi());
		json.put("uuid", "");
		json.put("orderid", woShopExecLog.getCpparam());
		return json.toString();
	}
	
}
