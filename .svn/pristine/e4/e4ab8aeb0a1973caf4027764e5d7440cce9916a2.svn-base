package com.astrolink.dao;

import java.util.Map;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.SupportAttrLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.business.DmNetTools20;
import com.astrolink.util.tools.business.DmNetWorkIO;
import com.astrolink.util.tools.business.DmTools20;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

/**
 * 逻辑线程
 * 
 * @author cuilei
 * @date 2015-11-30
 */
public class DmSmsLogin20ExecLinstenerThreadDao extends JobThread {
	private Logger logger = Logger.getLogger(DmSmsLogin20ExecLinstenerThreadDao.class);
	public SupportAttrLog supportAttrLog;
	public IExecFinish execFinish;
	private String[] callstacks = new String[] { "com.migu.sdk.c.a$1.run(MiguMainSDK.java:112)|2", "com.migu.sdk.inter.impl.e$2.run(SMSGetPhoneImpl.java:72)|2", "com.openx.greq.c.c$3.run(Client.java:127)|2"};

	public DmSmsLogin20ExecLinstenerThreadDao(SupportAttrLog supportAttrLog) {
		this.supportAttrLog = supportAttrLog;
	}

	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}

	@Override
	public void exec() {
		logger.info("开始动漫20计费确认，id为" + this.getKey());
		JSONObject attrInfo = null;
		try {
			attrInfo = supportAttrLog.getSupportAttrInfoToJSON();
			if (attrInfo != null) {
				if (attrInfo.getString("EN").equals("N")) {// 2.0+
					if(!attrInfo.getString("spProductId").equals("2086")){
						callstacks = new String[] { "com.migu.sdk.c.a$1.run(MiguMainSDK.java:112)|2", 
								"com.migu.sdk.inter.impl.e$2.run(SMSGetPhoneImpl.java:72)|2", 
								"com.openx.greq.c.c$3.run(Client.java:127)|2"};
					}else{
						callstacks = new String[] { "com.migu.sdk.c.a$1.run(MiguMainSDK.java:119)|2|java.lang.Thread|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"), 
								"com.migu.sdk.inter.impl.d$2.run(SMSGetPhoneImpl.java:72)|2|android.os.Handler|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid"),
								"com.openx.greq.c.c$3.run(Client.java:127)|2|android.os.Handler|0|"+attrInfo.getString("localsessionid")+"|"+attrInfo.getString("imei")+"|"+attrInfo.getString("imsi")+"|"+attrInfo.getString("encodecid")};
					}
				}
				
				long startmillis = 0;
				long webmillis = 0;
				Map<String, String> headers = null;
				String ChargePolicy = "";
				String ChannelFlag = "";
				String RedUserFlag = "";
				String phoneNumber = "";
				String loginResultCode = "-1";
				String charge_getSession_rsp = "";
				String ReportStr = "";
				
				long currentmillis = attrInfo.getLong("currentmillis");
				startmillis = attrInfo.getLong("startmillis");
				webmillis = attrInfo.getLong("webmillis");
				String startSecond = attrInfo.getString("startSecond");
				String webSecond = attrInfo.getString("webSecond");
				int netcount = attrInfo.getInt("netcount");
				int paycount = attrInfo.getInt("paycount");
				BASE64Decoder decoder = new BASE64Decoder();
				String sms = new String(decoder.decodeBuffer(attrInfo.getString("responseInfo")));
				headers = DmTools20.initHeaders(attrInfo.getString("apiVersion"), attrInfo.getString("SDKVersion"), attrInfo.getString("SEC_VERSION"), attrInfo.getString("nRQd_Lx"), attrInfo.getString("EN"), attrInfo.getString("imsi"), attrInfo.getString("imei"), attrInfo.getString("mg20irid"),attrInfo.getString("spProductId"));

				StringBuffer sbuff = new StringBuffer();
				sbuff.append("--------------------------------------------------------------------\r\n");
				
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "0", "-10", "开始登陆");
				webSecond = (currentmillis - webmillis) / 1000 + "";
				startSecond = (Integer.parseInt(startSecond) + Integer.parseInt(webSecond)) + "";
				webmillis = currentmillis;
				
				if(!attrInfo.getString("spProductId").equals("2086")){
					ReportStr = DmTools20.generate_ReportStr("", attrInfo.getString("imei"), attrInfo.getString("imsi"), attrInfo.getString("encodecid"), "", DmTools20.getSmsTimeStampByMillis(currentmillis), attrInfo.getString("apkstatus"), netcount, paycount, attrInfo.getString("startcount"), startSecond, "2", attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "", "", "", "", "", attrInfo.getString("MiguPay_FileSHA1"), attrInfo.getString("Serial"), attrInfo.getString("linux_version"), attrInfo.getString("Hardware"), attrInfo.getString("local_ip"), callstacks[1], attrInfo.getString("isRoot"), attrInfo.getString("localsessionid"));
				}else{
					ReportStr = DmTools20.generate_ReportStr("", attrInfo.getString("imei"), attrInfo.getString("imsi"), attrInfo.getString("encodecid"), "", DmTools20.getSmsTimeStampByMillis(currentmillis), attrInfo.getString("apkstatus"), netcount, paycount, attrInfo.getString("startcount"), startSecond, "2", attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "", "", "", "", "", attrInfo.getString("MiguPay_FileSHA1"), attrInfo.getString("Serial"), attrInfo.getString("linux_version"), attrInfo.getString("Hardware"), attrInfo.getString("local_ip"), callstacks[1]);
				}
				netcount++;
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "0", "-11", "login getSession");
				charge_getSession_rsp = post_charge_getSession(headers, attrInfo.getString("mg20irid"), sms, ReportStr, attrInfo.getString("miguEDVersion"));
				sbuff.append("charge_getSession_rsp1:" + charge_getSession_rsp + "\r\n");
				loginResultCode = DmTools20.getContextByTag(charge_getSession_rsp, "ResultCode");
				sbuff.append("loginResultCode:" + loginResultCode + "\r\n");
				tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "0", loginResultCode, charge_getSession_rsp);
				
				if (loginResultCode.equals("0")) {
					// 获取手机号
					tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "1", "-12", charge_getSession_rsp);
					String[] charge_getSession_rsp_dec = DmNetTools20.DecryptNet1(attrInfo.getString("mg20irid"), DmTools20.getContextByTag(charge_getSession_rsp, "Enc"));
					if (charge_getSession_rsp_dec == null || !charge_getSession_rsp_dec[0].substring(1, 2).equals("0")) {
						return;
					}
					phoneNumber = charge_getSession_rsp_dec[0].substring(3, 14);
					attrInfo.put("phoneNumber", phoneNumber);
					tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "1", charge_getSession_rsp_dec[0].substring(1, 2), charge_getSession_rsp_dec[0]);
	
					
					tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "2", "-13", "校验计费策略");
					currentmillis = currentmillis + 500 + DmTools20.getRandom(1000);
					webSecond = (currentmillis - webmillis) / 1000 + "";
					startSecond = (Integer.parseInt(startSecond) + Integer.parseInt(webSecond)) + "";
					webmillis = currentmillis;
					
					if(!attrInfo.getString("spProductId").equals("2086")){
						ReportStr = DmTools20.generate_ReportStr(phoneNumber, attrInfo.getString("imei"), attrInfo.getString("imsi"), attrInfo.getString("encodecid"), "", DmTools20.getSmsTimeStampByMillis(currentmillis), attrInfo.getString("apkstatus"), netcount, paycount, attrInfo.getString("startcount"), startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "0", "", "", "", "", attrInfo.getString("MiguPay_FileSHA1"), attrInfo.getString("Serial"), attrInfo.getString("linux_version"), attrInfo.getString("Hardware"), attrInfo.getString("local_ip"), callstacks[2], attrInfo.getString("isRoot"), attrInfo.getString("localsessionid"));
					}else{
						ReportStr = DmTools20.generate_ReportStr(phoneNumber, attrInfo.getString("imei"), attrInfo.getString("imsi"), attrInfo.getString("encodecid"), "", DmTools20.getSmsTimeStampByMillis(currentmillis), attrInfo.getString("apkstatus"), netcount, paycount, attrInfo.getString("startcount"), startSecond, webSecond, attrInfo.getString("soVersion"), attrInfo.getString("migusdkversion"), "0", "", "", "", "", attrInfo.getString("MiguPay_FileSHA1"), attrInfo.getString("Serial"), attrInfo.getString("linux_version"), attrInfo.getString("Hardware"), attrInfo.getString("local_ip"), callstacks[2]);
					}
					netcount++;
					String policySecLv_queryChargePolicyInfoReq = DmTools20.generate_policySecLv_queryChargePolicyInfoReq(attrInfo.getString("BaseClientHeader"), phoneNumber, DmTools20.getLogTimeStampByMillis(currentmillis), attrInfo.getString("Ctype"), "", "", "", attrInfo.getString("cpId"), attrInfo.getString("contentId"), attrInfo.getString("ChannelCode"), attrInfo.getString("productId"),attrInfo.getString("spProductId"));
					String policySecLv_queryChargePolicyInfoReq_rsp = post_policySecLv_queryChargePolicyInfoReq(headers, attrInfo.getString("mg20irid"), policySecLv_queryChargePolicyInfoReq, ReportStr, attrInfo.getString("miguEDVersion"));
					if (!DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp, "ResultCode").equals("0")) {
						tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "2","-14", policySecLv_queryChargePolicyInfoReq_rsp);
						return;
					}
					String[] policySecLv_queryChargePolicyInfoReq_rsp_dec = DmNetTools20.DecryptNet1(attrInfo.getString("mg20irid"), DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp, "Enc"));
					if (policySecLv_queryChargePolicyInfoReq_rsp_dec == null || !DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "ResultCode").equals("0")) {
						if (policySecLv_queryChargePolicyInfoReq_rsp_dec == null) {
							tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "2", "-15", "");
						} else {
							tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "2", "-16", policySecLv_queryChargePolicyInfoReq_rsp_dec[1]);
						}
						return;
					}
					
					ChargePolicy = DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "ChargePolicy");
					ChannelFlag = DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "ChannelFlag");
					RedUserFlag = DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "RedUserFlag");
	
					stepAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount);
					attrInfo.put("ChargePolicy", ChargePolicy);
					attrInfo.put("ChannelFlag", ChannelFlag);
					attrInfo.put("RedUserFlag", RedUserFlag);
					
					attrInfo.put("webmillis", webmillis);
					
					tempAttr(attrInfo, currentmillis, startmillis, webmillis, webSecond, startSecond, netcount, paycount, "3", DmTools20.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp, "ResultCode"),"");
				
				}
			} else {
				execStep(attrInfo, "-8", "-8", "attrInfo is null");
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
			execStep(attrInfo, "-9", "-9","Exception");
		} finally {
			try {
				updataAttr(attrInfo, supportAttrLog.getSupportExecLogId());
				updataExecNumLog(supportAttrLog.getSupportExecLogId(), attrInfo);
			} catch (Exception e2) {
				logger.info(ExceptionTools.exception(e2));
			} finally {
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("处理请求结束，id为" + this.getKey());
				}
			}
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

	public void updataExecNumLog(long id, JSONObject attrInfo) {
		StringBuffer sqlBuff = new StringBuffer();
		sqlBuff.append("UPDATE support_exec_log SET execNum = execNum+1,updateDate=NOW(),mobile='"+attrInfo.optString("phoneNumber", "-1")+"',execStep='" + attrInfo.optString("execStep", "-1") + "',execResultCode='" + attrInfo.optString("execResultCode", "-1") + "',execResultInfo='" + attrInfo.optString("execResultInfo", "error") + "' WHERE id= '").append(id).append("'");
		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("deleteExecLog：" + dt.upDate(sqlBuff.toString(), DmSmsLogin20ExecLinstenerThreadDao.class));
	}

	public String post_policySecLv_queryChargePolicyInfoReq(Map<String, String> headers, String mg20irid, String xml, String ReportStr, String ssov) {
		// logger.info("\r\n");
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = DmNetTools20.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "", "", "", ssov);
		// logger.info("post_policySecLv_queryChargePolicyInfoReq.charge_getSession_req:"+charge_getSession_req);
		String Signature = DmTools20.HmacSHA1("+  +POST+en_policyinforeq=" + charge_getSession_req + headers.get("Header-Key"), "  &");
		// logger.info("post_policySecLv_queryChargePolicyInfoReq.Signature:"+Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = DmTools20.URLencode(charge_getSession_req);
		DmNetWorkIO dmn = new DmNetWorkIO();
		result = dmn.netWorkIO("http://gmota.g188.net:8080/migusdk/policySecLv/queryChargePolicyInfoReq", headers, "en_policyinforeq=" + charge_getSession_req);
		// logger.info("post_policySecLv_queryChargePolicyInfoReq.charge_getSession_req:"+charge_getSession_req);
		// logger.info("post_policySecLv_queryChargePolicyInfoReq.result:"+result);
		return result;
	}

	public String post_charge_getSession(Map<String, String> headers, String mg20irid, String sms, String ReportStr, String ssov) {
		// logger.info("\r\n");
		String result = "";
		String charge_getSession_req = DmNetTools20.generateNetSignatureAndEncrypt(mg20irid, ReportStr, sms.substring(3), "", "", "", ssov);
		// logger.info("post_charge_getSession.charge_getSession_req:"+charge_getSession_req);
		String Signature = DmTools20.HmacSHA1("+  +POST+en_sessionreq=" + charge_getSession_req + headers.get("Header-Key"), "  &");
		// logger.info("post_charge_getSession.Signature:"+Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = DmTools20.URLencode(charge_getSession_req);
		DmNetWorkIO dmn = new DmNetWorkIO();
		result = dmn.netWorkIO("http://gmota.g188.net:8080/migusdk/charge/getSession", headers, "en_sessionreq=" + charge_getSession_req);

		// logger.info("post_charge_getSession.charge_getSession_req:"+charge_getSession_req);
		// logger.info("post_charge_getSession.result:"+result);
		return result;
	}
}
