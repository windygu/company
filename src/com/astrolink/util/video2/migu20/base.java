package com.astrolink.util.video2.migu20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import com.astrolink.util.video2.utils.Aes;
import com.astrolink.util.video2.utils.Hex;
import com.astrolink.util.video2.utils.Hmac;
import com.astrolink.util.video2.utils.Http;
import com.astrolink.util.video2.utils.SHA;
import com.astrolink.util.video2.utils.Url;

public class base {

	// public static final String Init = "E0001"; //
	// http://gmota.g188.net:8080/migusdk/tl/initcttl
	// public static final String PolicyRequest = "E0003"; //
	// http://gmota.g188.net:8080/migusdk/policySecLv/queryChargePolicyInfoReq
	// public static final String PolicyRequestLocal = "E0011";
	// //recordPolicyLog //http://gmota.g188.net:8080/migusdk/tl/tcttl
	// public static final String Charge = "E0004";
	// //http://gmota.g188.net:8080/migusdk/charge/payReq
	//
	//
	// public static final String Cancel = "E0005";
	// public static final String CancelOffLine = "E1005";
	// public static final String ChargeOffLine = "E1004";
	// public static final String Exit = "E0002";
	// public static final String ExitOffLine = "E1002";
	// public static final String InitOffLine = "E1001";
	// public static final String PicReq = "E0006";
	// public static final String PolicyRequestCore = "E0012";
	// public static final String SmsCharge = "E0010";
	// public static final String SmsChargeOffLine = "E1010";
	// public static final String SmsReq = "E0007";
	// public static final String SmsTel = "E0008";
	// public static final String TokenTel = "E0009";

	public static Map<String, String> initHeaders(String apiVersion,
			String SDKVersion, String SEC_VERSION, String nRQd_Lx, String EN,
			String imsi, String imei, String mg20irid) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Connection", "Keep-Alive");
		headers.put("Accept-Encoding", "gzip");
		headers.put("Accept", "application/xml");
		headers.put("Response-Type", "xml");
		headers.put("platform", "Android");
		headers.put("Header-Key", "&apiVersion=" + apiVersion + "&SDKVersion="
				+ SDKVersion);
		headers.put("apiVersion", apiVersion);
		headers.put("SDKVersion", SDKVersion);
		headers.put("EnVer", EN);
		headers.put("nRQd-Lx", nRQd_Lx);
		headers.put("scv-Xuw", SEC_VERSION);
		headers.put("imei", imei);
		headers.put("imsi", imsi);
		headers.put("serialize", mg20irid);
		// headers.put("X-OF-Signature", Signature);
		// headers.put("Header-Signature", Signature);

		return headers;
	}

	public static String generate_migu_sms(String mg20irid, String imsi,
			String imei, String encodeCID, String rand16Num,
			String smsTimeStamp, String apkstatus) {
		// 00000589863077028536351460001033136031PB3VVCR2w8fiiCsZE50jIAA=d4ad906640a466ca2016070511145621000000000000vImOIk9BI0wThw8VYnATbbbFSgY=
		String result = mg20irid + imei + imsi + encodeCID + rand16Num
				+ smsTimeStamp + apkstatus + "00000000000" + "0";
		// System.out.println(result);
		result = algorithm.generateSmsSignatureAndEncrypt(mg20irid, result);
		if (result.equals(""))
			return "";
		String sms = "AE2" + result;
		System.out.println("sms addresss:\n1065842232\nsms content:\n" + sms);
		// System.out
		// .println("am start -a android.intent.action.SENDTO -d sms:1065842232 --es sms_body "
		// + "\""
		// + sms.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"",
		// "\\\\\"") + "\"");
		return sms;
	}

	public static String post_tl_initcttl(Map<String, String> headers,
			String BaseClientHeader, String mg20irid, String ReportStr,
			String timeStamp, String miguEDVersion) {
		String result = "";
		String tl_initcttl_raw = generate_tl_initcttl(BaseClientHeader,
				timeStamp);
		String tl_initcttl_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr,
						tl_initcttl_raw, "", "", "", miguEDVersion);
		// System.out.println(getHmacSHA1("+  +POST+en_initcttlreq=00000589KjrJTaE9R1AGX1JNTNwArcJxQMc5WKT6JpH/o9my7tU4AQQjJz+RvmASYeY8dV7kupuUB1puHV07xo8dbNpPAN5l/Sm30a3X6hrsHay6elyw/5jd4CN+ZhEAtu9Miz5Ed55LYfFR6+cwxAnLKVJGxn1JhTzTo5UW0p1gDj4bwoadcMW872P6WcLYeWu6MLD9SFb+4mPyKOokGQuJmWtMiVfJXGtWWAbrt8ZV6ZZ4yM7zANoAyVSvZUjdoeKLn2UK5CpdyEJ0s1v0/3eWWRn+VT3/g5BqYUkxAiI0jtgxXNde2bShlFf7izoxdIZ7Pz11zLvgk3Mwu1CKKTjJy4Uhq9FLSIi9fBrsAm/y3imV7MYTatPb7Hh5AvT+rJcMCN+bQOZWBmUKZcL2OmEfa86Nxr4vtkBIah6OXcOiymumMH1HMalhmL8X9KJ8e39xtLJhkGAnB7I4SecjbX228Vyd0c9aN183ZqQpmAdvTTSspJFc4N4BGaJjnSyc/1Y3uuswR7C8w28oFCuURfY++5J6NMdixfttGXravNfIjKDRF29lysD245g4sWz5VQ8WdVYeKc9KGqv9qpndGO4eGY7ixaBpCVrO78OOvdQW3KBBAZLWO58wCe3YjgajzB2s4i8JDfNHjqWOz2lo2zMvpSmViZ3wr7W7inQQOYWe1oIBc/fII6hzC3631D6SiCOBhtpXTbzXtp1a8g9lMS0LyqL7gQXGui3/z85gLdIZSsc+Amov0e7Dc8c+jhk1Y1WwFIcBanyrLeetjmET4lJNuCS2TfTFuB6qwQ1OBGvhOMHInfPH1XW3f23WxqOxZSdYkrY/vB3VUJfDG3VfzWvTcuFjy9wU36cCJmzJCQCF6II/3BGnOcdoasyc54AvKilsaj54mooEcku5ff395e0fDmU+uw==&apiVersion=20&SDKVersion=12002003",
		// "  &"));
		String Signature = Hmac.HmacSHA1("+  +POST+en_initcttlreq="
				+ tl_initcttl_req + headers.get("Header-Key"), "  &");
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		tl_initcttl_req = Url.encode(tl_initcttl_req);
		result = Http.doPost("http://gmota.g188.net:8080/migusdk/tl/initcttl",
				headers, "en_initcttlreq=" + tl_initcttl_req);
		System.out.println(result);
		return result;
	}

	public static String generate_tl_initcttl(String BaseClientHeader,
			String LogTimeStamp) {
		// <?xml version='1.0' encoding='UTF-8' standalone='yes'
		// ?><request><LogInfo>xdeUEu076NNShPM2^0^863077028536351^460001033136031^4.1.1^720*1280^Xiaomi^MI
		// 2S^12002003^20^f8:a4:5f:5b:d7:f8^^192.168.30.228^0^E0001^20160805152139943^</LogInfo></request>
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request><LogInfo>"
				+ BaseClientHeader
				+ "E0001"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ "</LogInfo></request>";
		return result;
	}

	public static String post_verification_checkSdkUpdate(
			Map<String, String> headers, String SDKVersion,
			String miguEDVersion, String soVersion) {
		String result = "";
		String verification_checkSdkUpdate_req = "resVersionCode=00000000&sdkVersionCode="
				+ SDKVersion
				+ "&selfSoVersion="
				+ miguEDVersion.substring(miguEDVersion.lastIndexOf('.') + 1)
				+ "&soVersionCode=" + soVersion;
		String Signature = Hmac.HmacSHA1("+  +POST+"
				+ verification_checkSdkUpdate_req + headers.get("Header-Key"),
				"  &");
		verification_checkSdkUpdate_req = "sdkVersionCode=" + SDKVersion
				+ "&soVersionCode=" + soVersion
				+ "&resVersionCode=00000000&selfSoVersion="
				+ miguEDVersion.substring(miguEDVersion.lastIndexOf('.') + 1);// resVersionCode
		// MiguPay.Sdk20.Res������
		// Ĭ�Ͼ���00000000
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/verification/checkSdkUpdate",
						headers, verification_checkSdkUpdate_req);
		System.out.println(result);
		return result;
	}

	public static String post_charge_getSession(Map<String, String> headers,
			String mg20irid, String sms, String ReportStr, String miguEDVersion) {
		String result = "";
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr,
						sms.substring(3), "", "", "", miguEDVersion);
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_sessionreq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/getSession",
				headers, "en_sessionreq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}

	public static String generate_policySecLv_queryChargePolicyInfoReq(
			String BaseClientHeader, String phoneNumber, String LogTimeStamp,
			String Ctype, String OrderId, String Fee, String ItemId,
			String cpId, String contentId, String ChannelId, String productId) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<CommLog>"
				+ BaseClientHeader
				+ "E0003"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^"
				+ "1"
				+ "^"
				+ "</CommLog>"
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<PolicyType>0</PolicyType>" // OrderNum С�ڵ���1��Ϊ0����Ϊ1
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<OrderNum>1</OrderNum>"// OrderInfoList����
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<RedListUsrId></RedListUsrId>"// ������
				+ "<BadRecType></BadRecType>" // ������
				+ "<OrderInfoList>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>" + "<OrderType></OrderType>" // ������
				+ "<BatchSaleFlag>0</BatchSaleFlag>" // �̶�
				+ "<SaleNum></SaleNum>"// ������
				+ "<ScdChannel></ScdChannel>"// ������
				+ "</OrderInfoList>" + "</request>";
		return result;
	}

	public static String post_policySecLv_queryChargePolicyInfoReq(
			Map<String, String> headers, String mg20irid, String xml,
			String ReportStr, String miguEDVersion) {
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguEDVersion);
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_policyinforeq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/policySecLv/queryChargePolicyInfoReq",
						headers, "en_policyinforeq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}

	public static String generate_tl_tcttl_recordPolicyLog(
			String BaseClientHeader, String LogTimeStamp, String phoneNumber,
			String Ctype, String Orderid, String Userid, String cpId,
			String contentId, String ChannelId, String productId, String Fee,
			String policy, String channelFlag, String redFunOpenFlag) {
		// <?xml version='1.0' encoding='UTF-8' standalone='yes'
		// ?><request><LogInfo>xdeUEu076NNShPM2^0^863077028536351^460001033136031^4.1.1^720*1280^Xiaomi^MI
		// 2S^12002003^20^f8:a4:5f:5b:d7:f8^^192.168.30.228^0^E0011^20160805152151742^13811073830^1^4^^0^13811073830^1^[0000`CP2609`300000008644``,]^1^1^0^</LogInfo></request>
		// 13811073830^1^4^^0^13811073830^1^[0000`CP2609`300000008644``,]^1^1^0^
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request><LogInfo>"
				+ BaseClientHeader
				+ "E0011"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^"
				+ "1"
				+ "^"
				+ Ctype
				+ "^"
				+ Orderid
				+ "^"
				+ "0"
				+ "^" // OrderNum С�ڵ���1��Ϊ0����Ϊ1
				+ Userid
				+ "^"
				+ "1"
				+ "^" // OrderNum����
				+ "["
				+ ChannelId
				+ "`"
				+ cpId
				+ "`"
				+ productId
				+ "`"
				+ contentId
				+ "`"
				+ ",]"
				+ Fee
				+ "^"
				+ policy
				+ "^"
				+ channelFlag
				+ "^"
				+ redFunOpenFlag
				+ "^"
				+ "</LogInfo></request>";
		return result;
	}

	public static String querySMSVerifyInfoReq(String BaseClientHeader,
			String LogTimeStamp, String phoneNumber, String Ctype,
			String OrderId, String friendNum, String SDKSeq,
			String FeeRequestSeq) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request><Ctype>"
				+ Ctype
				+ "</Ctype><CommLog>"
				+ BaseClientHeader
				+ "E0007"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^"
				+ "null"
				+ "^^"
				+ "</CommLog><OrderId>"
				+ OrderId
				+ "</OrderId><UserID>"
				+ friendNum
				+ "</UserID><SDKSeq>"
				+ SDKSeq
				+ "</SDKSeq><FeeRequestSeq>"
				+ FeeRequestSeq
				+ "</FeeRequestSeq><FriendPay>1</FriendPay></request>";
		return result;
	}

	public static String querySMSVerifyInfoReq(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String miguEDVersion) {
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguEDVersion);
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_smsverifyinforeq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/smsPicVerif/querySMSVerifyInfoReq",
						headers, "en_smsverifyinforeq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}

	public static String post_tl_tcttl(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String miguEDVersion) {
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguEDVersion);
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_tcttlreq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost("http://gmota.g188.net:8080/migusdk/tl/tcttl",
				headers, "en_tcttlreq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}

	public static String generate_charge_sessionReq(String ChargePolicy,
			String phoneNumber, String LogTimeStamp, String Ctype,
			String OrderId, String Fee, String ItemId, String cpId,
			String contentId, String ChannelId, String productId, String Cpparam) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<ChargePolicy>"
				+ ChargePolicy
				+ "</ChargePolicy>"
				+ "<RedListUsrId></RedListUsrId>"
				+ "<CommLog></CommLog>" // ������
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<RequestTime>"
				+ LogTimeStamp.substring(0, 14)
				+ "</RequestTime>"
				+ "<VasType>5</VasType>"
				+ "<ServType></ServType>"
				+ "<SPCode></SPCode>"
				+ "<LaunchType>0</LaunchType>" // �̶�
				+ "<SaleType></SaleType>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ChannelClass></ChannelClass>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<SettleDate>"
				+ LogTimeStamp.substring(0, 8)
				+ "</SettleDate>"
				+ "<MemberType></MemberType>"
				+ "<StartChapter></StartChapter>"
				+ "<Chapter></Chapter>"
				+ "<SessionId></SessionId>"
				+ "<Cpparam>"
				+ Cpparam
				+ "</Cpparam>" + "<Contendesc></Contendesc>" + "</request>";
		return result;
	}

	public static String post_charge_sessionReq(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String miguEDVersion) {
		String result = "";
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguEDVersion);
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_sessionReq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/sessionReq",
				headers, "en_sessionReq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}

	public static String generate_charge_payReq_EDstr(String version,
			String timeStemp, String imei, int payCount, String startSecond,
			String orderId, String phoneNumber) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(version);
		buffer.append(timeStemp);
		buffer.append(":");
		buffer.append(imei);
		buffer.append(":");
		buffer.append(0);
		buffer.append(":");
		buffer.append(0);
		buffer.append(":");
		buffer.append(0);
		buffer.append(":");
		buffer.append(payCount);
		buffer.append(":");
		buffer.append(Integer.parseInt(startSecond) - 2);
		buffer.append(":");
		buffer.append("errorapp");
		buffer.append(":");
		buffer.append(orderId);
		buffer.append(":");
		buffer.append(phoneNumber);
		buffer.append(":");
		return buffer.toString();
	}

	public static String generate_charge_payReq(String BaseClientHeader,
			String ChargePolicy, String phoneNumber, String ChannelFlag,
			String LogTimeStamp, String Ctype, String OrderId, String Fee,
			String ItemId, String cpId, String contentId, String ChannelId,
			String productId, String Cpparam, String friendNum,
			String SMSToken, String SDKSeq, String FeeRequestSeq, String SmsCode) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<ChargePolicy>"
				+ ChargePolicy
				+ "</ChargePolicy>"
				+ "<RedListUsrId></RedListUsrId>"
				+ "<CommLog>"
				+ BaseClientHeader
				+ "E0004"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^null^"
				+ ChannelFlag
				+ "^"
				+ "</CommLog>"
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<VerifyInfo><SMSToken>"
				+ SMSToken
				+ "</SMSToken><Token></Token><SDKSeq>"
				+ SDKSeq
				+ "</SDKSeq><FeeRequestSeq>"
				+ FeeRequestSeq
				+ "</FeeRequestSeq><PicCode></PicCode><SmsCode>"
				+ SmsCode
				+ "</SmsCode><Usrname></Usrname><Pwd></Pwd></VerifyInfo>"
				+ "<UserID>"
				+ friendNum
				+ "</UserID>"
				+ "<RequestTime>"
				+ LogTimeStamp.substring(0, 14)
				+ "</RequestTime>"
				+ "<VasType></VasType>"
				+ "<ServType></ServType>"
				+ "<SPCode></SPCode>"
				+ "<LaunchType>0</LaunchType>" // �̶�
				+ "<SaleType></SaleType>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ScdChannel></ScdChannel>"
				+ "<ChannelClass></ChannelClass>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<SettleDate>"
				+ LogTimeStamp.substring(0, 8)
				+ "</SettleDate>"
				+ "<MemberType></MemberType>"
				+ "<StartChapter></StartChapter>"
				+ "<Chapter></Chapter>"
				+ "<SessionId></SessionId>"
				+ "<Cpparam>"
				+ Cpparam
				+ "</Cpparam>"
				+ "<ReserveParam></ReserveParam>"
				+ "<Contendesc></Contendesc>"
				+ "</request>";
		return result;
	}

	public static String generate_charge_payReq(String BaseClientHeader,
			String ChargePolicy, String phoneNumber, String ChannelFlag,
			String LogTimeStamp, String Ctype, String OrderId, String Fee,
			String ItemId, String cpId, String contentId, String ChannelId,
			String productId, String Cpparam) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<ChargePolicy>"
				+ ChargePolicy
				+ "</ChargePolicy>"
				+ "<RedListUsrId></RedListUsrId>"
				+ "<CommLog>"
				+ BaseClientHeader
				+ "E0004"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^1^"
				+ ChannelFlag
				+ "^"
				+ "</CommLog>"
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<VerifyInfo />"
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<RequestTime>"
				+ LogTimeStamp.substring(0, 14)
				+ "</RequestTime>"
				+ "<VasType>5</VasType>"
				+ "<ServType></ServType>"
				+ "<SPCode></SPCode>"
				+ "<LaunchType>0</LaunchType>" // �̶�
				+ "<SaleType></SaleType>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ScdChannel></ScdChannel>"
				+ "<ChannelClass></ChannelClass>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<SettleDate>"
				+ LogTimeStamp.substring(0, 8)
				+ "</SettleDate>"
				+ "<MemberType></MemberType>"
				+ "<StartChapter></StartChapter>"
				+ "<Chapter></Chapter>"
				+ "<SessionId></SessionId>"
				+ "<Cpparam>"
				+ Cpparam
				+ "</Cpparam>"
				+ "<ReserveParam></ReserveParam>"
				+ "<Contendesc></Contendesc>"
				+ "</request>";
		return result;
	}

	public static String post_charge_payReq(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String ihJVd,
			String Lwkn, String EDstr,String miguEDVersion) {
		String result = "";
		String charge_payReq_req = algorithm.generateNetSignatureAndEncrypt(
				mg20irid, ReportStr, xml, ihJVd, Lwkn,
				headers.get("SDKVersion"), EDstr, miguEDVersion);
		System.out.println(charge_payReq_req);
		String Signature = Hmac.HmacSHA1("+  +POST+add=0&en_billingreq="
				+ charge_payReq_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_payReq_req = Url.encode(charge_payReq_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/payReq", headers,
				"add=0&en_billingreq=" + charge_payReq_req);
		System.out.println(result);
		return result;
	}

	public static String generate_BaseClientHeader(String sSdkSessionid,
			String isSelfClient, String imei, String imsi, String RELEASE,
			String screen, String BRAND, String MODEL, String SDKVersion,
			String apiVersion, String MacAddr, String Location,
			String local_ip, String NetworkType) {
		// sSdkSessionid ���16λ
		// 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
		// isSelfClient Ĭ����false ����0
		// Build$VERSION.RELEASE
		// screen Width*Height
		// Location getLastKnownLocation Double.toString(v2.getLongitude()) +
		// "*" + Double.toString(v2.getLatitude())
		// NetworkType δ������0;���Ӻ��ȡNetworkInfo.getSubtype
		// 1,2,4,7��1;13��3;3,5,6,8,9,10,12,14,15��2;������0
		// xdeUEu076NNShPM2^0^863077028536351^460001033136031^4.1.1^720*1280^Xiaomi^MI
		// 2S^12002003^20^f8:a4:5f:5b:d7:f8^^192.168.30.228^0^
		String result = sSdkSessionid + "^" + isSelfClient + "^" + imei + "^"
				+ imsi + "^" + RELEASE + "^" + screen + "^" + BRAND + "^"
				+ MODEL + "^" + SDKVersion + "^" + apiVersion + "^" + MacAddr
				+ "^" + Location + "^" + local_ip + "^" + NetworkType + "^";
		return result;
	}

	public static int getRandom(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}

	public static String getLogTimeStampByMillis(long Millis) {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date(Millis));
	}

	public static String getSmsTimeStampByMillis(long Millis) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(Millis));
	}

	public static String getLogTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}

	public static String getSmsTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	public static String generate_ReportStr(String phoneNumber, String imei,
			String imsi, String encodecid, String websessionid,
			String timestamp, String apkstatus, int netcount, int paycount,
			String startcount, String startSecond, String webSecond,
			String soVersion, String migusdkversion, String payReq1,
			String payReq2, String payReq3, String payReq4, String payReq5,
			String MiguPay_FileSHA1, String Serial, String linux_version,
			String Hardware, String local_ip, String callstack, String isRoot,
			String localsessionid) {
		// |0|phoneNumber|imei|imsi|encodecid|unkown1|timestamp|apkstatus|�����������|�ƷѴ���|��������|unkown2|unkown3|soversion|sdkversion|unkown4|unkown5|unkown6|unkown7|unkown8|�ļ�assets/MiguPay.Sdk20.Lib_xxx_xxx.lib��sha1���ɴ�.MF�ļ���ȡ��|Serial(\proc\cpuinfo)|linux
		// version(\proc\version)|Hardware(\proc\cpuinfo)|local_ip|callstack|netstat|isRoot|sessionid|
		String result = "|0|" + phoneNumber + "|" + imei + "|" + imsi + "|"
				+ encodecid + "|" + websessionid + "|" + timestamp + "|"
				+ apkstatus + "|" + fillby0((netcount + ""), 4) + "|"
				+ fillby0((paycount + ""), 4) + "|" + startcount + "|"
				+ startSecond + "|" + webSecond + "|" + soVersion + "|"
				+ migusdkversion + "|" + payReq1 + "|" + payReq2 + "|"
				+ payReq3 + "|" + payReq4 + "|" + payReq5 + "|"
				+ MiguPay_FileSHA1 + "|" + Serial + "|" + linux_version + "|"
				+ Hardware + "|" + local_ip + "|" + callstack + "|" + isRoot
				+ "|" + localsessionid + "|";
		return result;
	}

	public static String fillby0(String data, int len) {
		while (data.length() < len) {
			data = "0" + data;
		}
		return data;
	}

	public static String getContextByTag(String context, String tag) {
		String result = "";
		int start = context.indexOf("<" + tag + ">")
				+ ("<" + tag + ">").length();
		int end = context.indexOf("</" + tag + ">");
		if (start != -1 && end != -1)
			result = context.substring(start, end);
		System.out.println(tag + ":\t" + result);
		return result;
	}

	public static String formateLocalip(String local_ip) {
		String[] ips = local_ip.split("\\.");
		String result = "";
		for (int i = 0; i < ips.length; i++) {
			result += fillby0(ips[i], 3);

			if (i + 1 == ips.length) {
				return result;
			}
			result += ".";
		}
		return "";
	}

	// public static List getArgsSorted(ArrayList mArgs) {
	// ArrayList list = new ArrayList();
	// list.addAll(mArgs);
	// Collections.sort(list, new Comparator(){
	// public int compare(Object o1, Object o2) {
	// return this.compare(((NameValue)o1), ((NameValue)o2));
	// }
	//
	// public int compare(NameValue nv1, NameValue nv2) {
	// int result = nv1.Name.compareTo(nv2.Name);
	// if(result == 0) {
	// result = nv1.Value.compareTo(nv2.Value);
	// }
	//
	// return result;
	// }
	// });
	// return list;
	// }
	//
	// public static String getArgString(List list) {
	// StringBuilder result = null;
	// Iterator iterator = list.iterator();
	// while(iterator.hasNext()) {
	// Object v1 = iterator.next();
	// if(result == null) {
	// result = new StringBuilder();
	// }
	// else {
	// result.append('&');
	// }
	// result.append(((NameValue)v1).Name);
	// result.append('=');
	// if(((NameValue)v1).Value == null) {
	// continue;
	// }
	// result.append(((NameValue)v1).Value);
	// }
	//
	// String v2_1 = result == null ? "" : result.toString();
	// return v2_1;
	// }
	//
	// public static class NameValue{
	// public String Name;
	// public String Value;
	// }

}
