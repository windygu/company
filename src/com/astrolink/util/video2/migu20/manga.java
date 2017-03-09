package com.astrolink.util.video2.migu20;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.astrolink.dao.VideoExecLinstenerThreadDao2;
import com.astrolink.util.tools.NetManager;
import com.astrolink.util.tools.NetResult;
import com.astrolink.util.video2.utils.Base64;
import com.astrolink.util.video2.utils.Common;
import com.astrolink.util.video2.utils.Http;
import com.astrolink.util.video2.utils.Url;

public class manga {
	// sdk�汾���
	public String apiVersion = "20";
	public String SDKVersion = "12002005";
	public String SEC_VERSION = "A";
	public String nRQd_Lx = "203";
	public String EN = "E";
	public String miguEDVersion = "miguED.20.04";
	public String soVersion = "03080101";
	public String migusdkversion = "20150";
	public String MiguPay_FileSHA1 = "G6HxBxlN4fGlw0LT76syUXOKBXg=";

	// �豸��Ϣ���
	public String isRoot = "1";

	public String imei = "";
	public String encodecid = "";
	public String websessionid = "";
	public String Serial = "0000000000000000";
	public String linux_version = "3.4.5";
	public String Hardware = "HS-U978";
	public String local_ip = "";

	public String message;
	public String phoneNumber = "";
	public String imsi = "";

	public String apkstatus = "";
	public int netcount = 1;
	public int paycount = 0;
	public String startcount = "0002";
	public String startSecond = "";
	public String webSecond = "";

	// �Ʒ�
	// ����
	public String PayCode = "";
	public String AppId = "";
	// �乾
	public String Ctype = "5"; // ��Ƶ��4
	public String cpId = "";
	public String contentId = "";
	public String ChannelCode = "";
	public String productId = "";
	public String Fee = "";
	public String ItemId = "";
	public String mg20irid;

	private String channelId = "";

	private String cpparam;
	private long currentmillis;

	private boolean useFriendPay = true;
	private String friendNum = "13886012895";
	public String RELEASE;
	public String screen;
	public String BRAND;
	public String MODEL;
	public String MacAddr;
	public String Location = "";
	public String NetworkType = "0";
	
	public String operCode;
	public String sms;
	public String resultCode="-1";
	public String goodsId;
	
	public String clientId;
	public String resourceId;

	public void main(String[] args) {

		wifitong();
		// toJson();
		 run();

//		 String data = Url
//		 .decode("00018205jjjR2ezEmF2SSnSLPIm0IUpZxz7y9mtN47FeA23PzvNQlDFE4pd1ZVBBjQF8dDncGF1jK%2FLUMzxYvYzV44HDnJsQ1ZdeMD8UXAe4TRv6cC%2FS8hvATnHimCWEXZPt9VaOk4yheD1koAXS%2F5LvWcsglS91Cbdf%2B0SlKExyv37Wozh667PQdxd%2Bwym6SYZ5aUa3kefG%2BIuux9v2oVMC1elbi3geTu5vihWfbdAk4r0M5MdRxCNpsXHRyYtvGHILSv3fB5L78cj5DyJQ1yLIjWiXhmA3u9TkAI6DgDIklR5iNdIwbh%2Bpyv%2Fpo6ae1Xv1n%2FJe%2B8LFfuTEpE2gruCq5FAHX%2Fp8guAmxjxcZATQkr8o9dtO8xQ4uGOCCl3kvHi78AyjBMtplaAQApbfLAaJslz6%2BWrlATY2bwOiG0RZHPR6YrpMtsqWldQebXio73hEQhBpePeGsWhvyZ2wLqCnbtL9bVUeDvx6rQuHa6KgbzjQZMPdU6LhAOR3ugPgUl41BnzW8KmAyH1vSnpqAI2JP6LQ96Bu9gkUTGJPqfnatfx67oVpaeXDVqHbL%2B2TzKdY0%2BfS9nEaCxx40JWM9xxO5lxDMNU6XkZSUnW4ljhIvJPLHJRJkqJxOLITANvHCWg54Ncs5nNL41vIH%2B%2F7xCpb3a3Shw2C0zbn9ZnigxCrRL1EBwYiKT0srfJFUrvqeAAmvtRyXIZu3%2Fy3UwtK%2B1BZUE%2FbImFpfE0r4CEBFSEntlQc5VaWbqOTLCd3Mg1mDh%2BsAHLumnxVnSu%2BTWhD0PaU0wQ0O%2FDpuEQKVsppElh3QJJ0CkTnri08FmLKTEDHtkvp1NHNXdS3bxtAxfgYl0Rcj%2FmK9ptgu0H4K8HpKG6VrsK8Z%2Bo%3D")
//		 .replace("", "");
		// mg20irid = "00018205";
//		String data = "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";
		// String[] str = algorithm.DecryptNet1(mg20irid, data);
//		String[] str = algorithm.DecryptNet2(mg20irid, data, "", "", "",
//				"miguED.20.03");
		// String[] str = algorithm.DecryptNet2(mg20irid, data,
		// "3dadcd9491884f71899d0039a4a0f223",
		// "4fab662520ad449bb50fa07bc3963375", "12002005", "miguED.20.03");
		// String ss = algorithm.generateNetSignatureAndEncrypt(mg20irid,
		// str[0].substring(0, str[0].lastIndexOf("|") + 1), str[1], "",
		// "", "");
		// System.out.println(Url.encode(ss));
		// algorithm
		// .decryptSms(
		// mg20irid,
		// "AE2000143j4z622.)z227h0\\33\"60b0%y0385q8d7pD3nGY/qsaq'r6fVZ~uCnQA=JIyCZ_=8cZWvmy;6201A101YE,090X\\j{-0bs000?0MIMLh(MZvKs'5neIfxqud|jvMqz8B=");
	}

	public void ylyy() {
		apkstatus = "21";

		imei = "862230024780033";
		// imsi = "460001033136031"; //����
		imsi = "460006103857827";

		local_ip = "192.168.254.181";

		encodecid = "pD3IGY/qsaYZt6fVxRuCWQA=";
		MiguPay_FileSHA1 = "G6HxBxlN4fGlw0LT76syUXOKBXg=";

		PayCode = "";
		AppId = "";
		mg20irid = "00014314";
		cpId = "699065";

		contentId = "";
		ChannelCode = "312400040040001";
		channelId = "";
		productId = "2028597336";
		Fee = "1000";
		ItemId = "";

		operCode = "30831000";
	}

	public void wifitong() {
		apkstatus = "21";

		imei = "862230024780033";
		// imsi = "460001033136031"; //����
		imsi = "460006103857827";

		local_ip = "192.168.254.181";

		encodecid = "pD3IGY/qsaYZt6fVxRuCWQA=";
		MiguPay_FileSHA1 = "G6HxBxlN4fGlw0LT76syUXOKBXg=";

		PayCode = "";
		AppId = "";
		mg20irid = "00018205";
		cpId = "699029";

		contentId = "";
		ChannelCode = "302200100030000";
		channelId = "";
		productId = "2028593130";
		Fee = "600";
		ItemId = "";
	}

	public void toJson() {
		JSONObject json = new JSONObject();
		json.put("apiVersion", apiVersion);
		json.put("SDKVersion", SDKVersion);
		json.put("SEC_VERSION", SEC_VERSION);
		json.put("nRQd_Lx", nRQd_Lx);
		json.put("EN", EN);
		json.put("miguEDVersion", miguEDVersion);
		json.put("soVersion", soVersion);
		json.put("migusdkversion", migusdkversion);
		json.put("Serial", Serial);
		json.put("encodecid", encodecid);
		json.put("MiguPay_FileSHA1", MiguPay_FileSHA1);
		json.put("Location", "");
		json.put("NetworkType", "0");
		json.put("linux_version", linux_version);
		json.put("isRoot", isRoot);
		json.put("Ctype", Ctype);
		// �����඼�ǿ���д����
		json.put("mg20irid", mg20irid);// �����apk�� assets/mg20irid.dat�ļ���
		json.put("apkstatus", apkstatus);// ץ�� ��Ĭ��д01 �����ͨ ��ץ��
		json.put("ChannelCode", ChannelCode);// 9λ //��assets/CHANNEL/channel.xml
												// ���������� 0000 �������channelId
												// һ����ǿ��ַ�
		json.put("channelId", channelId);// 8λ
		json.put("contentId", contentId);
		json.put("AppId", AppId);// �����Ҫץ�� ��һ��Ĭ�Ϻ�productһ��
		System.out.println(json.toString());

	}

	public void deviceInfo() {
		RELEASE = "4.2.2";
		screen = "540*960";
		BRAND = "Hisense";
		MODEL = "HS-U978";
		MacAddr = "34:0a:ff:73:82:8e";
	}

	public String login() {
		String appName = "WiFi通";
		String packageName = "com.wifi.tong";
		String version_code = "4262";// pm.getVersionCode
		String version_name = "1.6.6";// pm.getVersionName
		String signature = "81adb5b5ec34b7fdaa88804c27a941c7";// md5
		String crc = "2332661545";// new
		// ZipFile(this.context.getPackageCodePath()).getEntry("classes.dex").getCrc();
		String device_id = "f7c1e0d4-07c7-36e9-9ed0-c71cef6bfbd8";// UUID.nameUUIDFromBytes(android_id.getByte(utf-8))
		JSONObject APP_INFO = new JSONObject();
		APP_INFO.put("APP_NAME", appName);
		APP_INFO.put("PACKAGE_NAME", packageName);
		APP_INFO.put("VERSION_CODE", version_code);
		APP_INFO.put("VERSION_NAME", version_name);
		APP_INFO.put("SIGNATURE", signature);
		APP_INFO.put("CRC", crc);
		JSONObject SDK_INFO = new JSONObject();
		SDK_INFO.put("NAME", "parnter");
		SDK_INFO.put("VERSION", "1.1");
		JSONObject DEVICE_INFO = new JSONObject();
		DEVICE_INFO.put("DEVICE_ID", device_id);
		DEVICE_INFO.put("DEVICE_MODEL", "u978");
		DEVICE_INFO.put("OS_VERSION", "4.2.2");
		// DEVICE_INFO.putAll(DeviceHelper.getDeviceInfo());
		JSONObject info = new JSONObject();
		info.put("APP_INFO", APP_INFO);
		info.put("SDK_INFO", SDK_INFO);
		info.put("DEVICE_INFO", DEVICE_INFO);
		JSONObject json = new JSONObject();
		json.put("instanceId", "");
		json.put("info", info);
		json.put("timestamps", String.valueOf(System.currentTimeMillis()));
		String url = "http://api.miguvideo.com/sdkmgr/launch?clientId=c7fdb409-59aa-4288-b12e-8397b64b2caa&request="+ URLEncoder.encode(json.toString());

		NetResult httpConnectGet = NetManager.getInstance().HTTPConnectGet(url,
				new String[][] { { "Content-Type", "application/json" } });
		System.out.println(httpConnectGet.content);
		return httpConnectGet.content;
	}
	
	private String getOperCode(){
		String payUrl = "http://api.miguvideo.com/sales/pricing?clientId="
				+ clientId
				+ "&request="
				+ "[%7B%22goodsId%22:%22"+goodsId+"%22,%22goodsProperties%22:%22%7B%5C%22resourceId%5C%22:%5C%22"+resourceId+"%5C%22%7D%22,%22goodsType%22:%22MIGU_PACKAGE_PROGRAM%22%7D]";
		NetResult httpConnectGet = NetManager.getInstance().HTTPConnectGet(payUrl,
				new String[][] { { "version", "v1.3*" } });
		System.out.println(httpConnectGet.content);
		return httpConnectGet.content;
	}

	
	public String run() {
//		login();
		String t = getOperCode();
		if(t!=null && !t.equals("")){
			operCode=t.substring(t.indexOf("\"operCode\":\"")+12,t.indexOf("\",\"productId\""));
			System.out.println("operCode:"+operCode);
			if(operCode==null && operCode.equals("")){
				return resultCode;
			}
		}else{
			return resultCode;
		}
		
//		String rand16Num = Common.getSession(16);
		String sSdkSessionid = VideoExecLinstenerThreadDao2.supportAttrInfo.optString("sSdkSessionid");//Common.getSession(16);
		String localsessionid = VideoExecLinstenerThreadDao2.supportAttrInfo.optString("localsessionid");//Common.getSession(12);

//		long startmillis = System.currentTimeMillis();
		long startmillis = VideoExecLinstenerThreadDao2.supportAttrInfo.optLong("startmillis");
		
//		String rand16Num = Common.getSession(16);
//		String sSdkSessionid = Common.getSession(16);
//		String localsessionid = Common.getSession(12);

		Map<String, String> headers = base.initHeaders(apiVersion, SDKVersion,
				SEC_VERSION, nRQd_Lx, EN, imsi, imei, mg20irid);
		String verification_checkSdkUpdate = base
				.post_verification_checkSdkUpdate(headers, SDKVersion,
						miguEDVersion, soVersion);

		String BaseClientHeader = base.generate_BaseClientHeader(sSdkSessionid,
				"0", imei, imsi, RELEASE, screen, BRAND, MODEL, SDKVersion,
				nRQd_Lx, MacAddr, Location, local_ip, NetworkType);
		System.out.println(BaseClientHeader);

		local_ip = base.formateLocalip(local_ip);

//		currentmillis = startmillis + base.getRandom(5000);
		currentmillis = VideoExecLinstenerThreadDao2.supportAttrInfo.optLong("reportStrCurrentmillis");
		long webmillis = currentmillis;
		startSecond = (currentmillis - startmillis) / 1000 + "";
		webSecond = (currentmillis - webmillis) / 1000 + "";

		String ReportStr = base.generate_ReportStr("", imei, imsi, encodecid,
				"", base.getSmsTimeStampByMillis(currentmillis), apkstatus,
				netcount, paycount, startcount, startSecond, webSecond,
				soVersion, migusdkversion, "", "", "", "", "",
				MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
				"com.migu.sdk.c.a$1.run(MiguMainSDK.java:73)|2", isRoot,
				localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);

		String tl_initcttl_rsp = base.post_tl_initcttl(headers,
				BaseClientHeader, mg20irid, ReportStr,
				base.getLogTimeStampByMillis(currentmillis), miguEDVersion);
		if (!base.getContextByTag(tl_initcttl_rsp, "ResultCode").equals("0")) {
			System.out.println("tl_initcttl failed!");
			return base.getContextByTag(tl_initcttl_rsp, "ResultCode");
		}
		String tl_initcttl_enc = base.getContextByTag(tl_initcttl_rsp, "Enc");

		String[] tl_initcttl_enc_dec = algorithm.DecryptNet1(mg20irid,
				tl_initcttl_enc);
		if (tl_initcttl_enc_dec == null) {
			return "-1";
		}

//		currentmillis = currentmillis + 1000 + base.getRandom(1000);
		currentmillis = VideoExecLinstenerThreadDao2.supportAttrInfo.optLong("smscurrentmillis");

//		String sms = base.generate_migu_sms(mg20irid, imsi, imei, encodecid,
//				rand16Num, base.getSmsTimeStampByMillis(currentmillis),
//				apkstatus);
		if (sms.equals("")) {
			return "-2";
		}
		// Thread.sleep(6*1000);
//		currentmillis = currentmillis + 10000 + base.getRandom(10000);
		currentmillis = VideoExecLinstenerThreadDao2.supportAttrInfo.optLong("reReportStrCurrentmillis");
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
			System.out.println("ReportStr:\t" + ReportStr);
			charge_getSession_rsp = base.post_charge_getSession(headers,
					mg20irid, sms, ReportStr, miguEDVersion);
			if (base.getContextByTag(charge_getSession_rsp, "ResultCode")
					.equals("0")) {
				break;
			} else {
				if (i == 2){// && !useFriendPay) {
					return base.getContextByTag(charge_getSession_rsp, "ResultCode");
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
		if (charge_getSession_rsp_dec == null
				|| !charge_getSession_rsp_dec[0].substring(1, 2).equals("0")) {
			return charge_getSession_rsp_dec[0].substring(1, 2);
		}
		phoneNumber = charge_getSession_rsp_dec[0].substring(3, 14);

		System.out.println("phoneNumber:\t" + phoneNumber);

		for (int i = 0; i < 3; i++) {
			resultCode=billing(localsessionid, startmillis, headers, BaseClientHeader,
					webmillis);
			if (resultCode.equals("0") || resultCode.equals("L90000")) {
				break;
			}
		}
		return resultCode;
	}

	private String billing(String localsessionid, long startmillis,
			Map<String, String> headers, String BaseClientHeader, long webmillis) {
		String ReportStr;

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
				"com.migu.sdk.c.a$3.run(MiguMainSDK.java:198)|2", isRoot,
				localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);
		String OrderId = getOrderId();
		String policySecLv_queryChargePolicyInfoReq = base
				.generate_policySecLv_queryChargePolicyInfoReq(
						BaseClientHeader, phoneNumber,
						base.getLogTimeStampByMillis(currentmillis), Ctype,
						OrderId, "", "", cpId, contentId, ChannelCode,
						productId);
		String policySecLv_queryChargePolicyInfoReq_rsp = base
				.post_policySecLv_queryChargePolicyInfoReq(headers, mg20irid,
						policySecLv_queryChargePolicyInfoReq, ReportStr,
						miguEDVersion);
		if (!base.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp,
				"ResultCode").equals("0")) {
			return base.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp,
					"ResultCode");
		}

		String[] policySecLv_queryChargePolicyInfoReq_rsp_dec = algorithm
				.DecryptNet1(mg20irid, base.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp, "Enc"));
		if (policySecLv_queryChargePolicyInfoReq_rsp_dec == null
				|| !base.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
						"ResultCode").equals("0")) {
			return base.getContextByTag(
					policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
					"ResultCode");
		}
		String ChargePolicy = base
				.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
						"ChargePolicy");
		String ChannelFlag = base.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "ChannelFlag");
		String RedUserFlag = base.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "RedUserFlag");
		//
		// ����Ʒ�ҳ��
		currentmillis = currentmillis + 20000 + base.getRandom(100000);
		// webSecond = (currentmillis - webmillis) / 1000 + "";
		// startSecond = (Integer.parseInt(startSecond) + Integer
		// .parseInt(webSecond)) + "";
		// webmillis = currentmillis;

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
				"com.migu.sdk.a.b$6.run(CatchLog.java:679)|2", isRoot,
				localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);
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
			return base.getContextByTag(tl_tcttl_recordPolicyLog_rsp, "ResultCode");
		}

		// ����Ʒ�
		currentmillis = currentmillis + 2000 + base.getRandom(10000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		ReportStr = base.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				"", base.getSmsTimeStampByMillis(currentmillis), apkstatus,
				netcount, paycount, startcount, startSecond, webSecond,
				soVersion, migusdkversion, "", "", "", "", "",
				MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
				"com.migu.sdk.ui.PayView$3.onClick(PayView.java:281)|2",
				isRoot, localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);
		UUID randomUUID = UUID.randomUUID();
		String traceId = randomUUID.toString();
		cpparam = Base64
				.encode("{\"chargeMode\":\"BOSS_MONTH\",\"chargeType\":\"UGC\",\"cpCode\":\""
						+ cpId
						+ "\",\"operCode\":\""
						+ operCode
						+ "\",\"paymentId\":\""
						+ OrderId
						+ "\",\"requestTime\":\""
						+ currentmillis
						+ "\",\"traceId\":\""
						+ traceId
						+ "\",\"version\":\"v2.0*\"}");
		// cpparam = "qwert";
		String charge_sessionReq_req = base.generate_charge_sessionReq(
				ChargePolicy, phoneNumber,
				base.getLogTimeStampByMillis(currentmillis), Ctype, OrderId,
				Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam);
		String charge_sessionReq_rsp = base.post_charge_sessionReq(headers,
				mg20irid, charge_sessionReq_req, ReportStr, miguEDVersion);
		if (!base.getContextByTag(charge_sessionReq_rsp, "ResultCode").equals(
				"0")) {
			return base.getContextByTag(charge_sessionReq_rsp, "ResultCode");
		}
		String ihJVd = base.getContextByTag(charge_sessionReq_rsp, "ihJVd");
		String Lwkn = base.getContextByTag(charge_sessionReq_rsp, "Lwkn");
		String[] charge_sessionReq_rsp_dec = algorithm.DecryptNet1(mg20irid,
				base.getContextByTag(charge_sessionReq_rsp, "Enc"));
		if (charge_sessionReq_rsp_dec == null) {
			return charge_sessionReq_rsp_dec[0];
		}
		System.out.println("charge_sessionReq_rsp_dec:\t"
				+ charge_sessionReq_rsp_dec[0]);
		String websessionid = charge_sessionReq_rsp_dec[0].substring(1, 9);
		System.out.println("websessionid:\t" + websessionid);
		currentmillis = currentmillis + 500 + base.getRandom(1000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		paycount++;
		if (paycount == 1) {
			apkstatus = chargeApkstatus();
		}
		String ChargePolicyStatus = "status=0,get=" + ChargePolicy + ",use="
				+ ChargePolicy;
		String payInfo = "," + ChannelCode + "," + "" + ",;" + cpId + ","
				+ ChannelCode + "," + productId + ",";
		ReportStr = base.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				websessionid, base.getSmsTimeStampByMillis(currentmillis),
				apkstatus, netcount, paycount, startcount, startSecond,
				webSecond, soVersion, migusdkversion, "0", ChargePolicyStatus,
				payInfo, "", "", MiguPay_FileSHA1, Serial, linux_version,
				Hardware, local_ip,
				"com.openx.greq.c.c$3.run(Client.java:127)|2", isRoot,
				localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);
		headers.put("kyMy", ihJVd);
		headers.put("ssov", miguEDVersion);
		String charge_payReq_req = base.generate_charge_payReq(
				BaseClientHeader, ChargePolicy, phoneNumber, ChannelFlag,
				base.getLogTimeStampByMillis(currentmillis), Ctype, OrderId,
				Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam);
		String edstr = base.generate_charge_payReq_EDstr(
				miguEDVersion.substring(miguEDVersion.indexOf(".") + 1),
				base.getSmsTimeStampByMillis(currentmillis
						- (8 * 60 * 60 * 1000)), imei, paycount, startSecond,
				OrderId, phoneNumber);
		String charge_payReq_rsp = base.post_charge_payReq(headers, mg20irid,
				charge_payReq_req, ReportStr, ihJVd, Lwkn, edstr,miguEDVersion);
		if (!base.getContextByTag(charge_payReq_rsp, "ResultCode").equals("0")) {
			return base.getContextByTag(charge_payReq_rsp, "ResultCode");
		}
		String[] charge_payReq_rsp_dec = algorithm.DecryptNet1(mg20irid,
				base.getContextByTag(charge_payReq_rsp, "Enc"));
		if (charge_payReq_rsp_dec == null
				|| !base.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode")
						.equals("0")) {
			return base.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode");
		}
		headers.remove("kyMy");
		headers.remove("ssov");
		System.out.println(charge_payReq_rsp_dec[1]);
		return "0";
	}

	public String getOrderId() {
		String session = Common.getSession(22);

		return session;
	}

	private String chargeApkstatus() {
		int states = Integer.parseInt(apkstatus) + 8;
		if (states < 10) {
			return "0" + states;
		}
		return states + "";
	}

}
