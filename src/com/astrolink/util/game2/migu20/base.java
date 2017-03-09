package com.astrolink.util.game2.migu20;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.astrolink.util.game2.utils.Hmac;
import com.astrolink.util.game2.utils.Http;
import com.astrolink.util.game2.utils.Url;


public class base {

	public static Map<String, String> initHeaders(String apiVersion,
			String SDKVersion, String SEC_VERSION, String nRQd_Lx, String EN,
			String imsi, String imei) {
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
		// headers.put("X-OF-Signature", Signature);
		// headers.put("Header-Signature", Signature);

		return headers;
	}

	public static String generate_migu_sms(String mg20irid, String imsi,
			String imei, String encodeCID, String rand16Num,
			String smsTimeStamp, String apkstatus) {
		String result = mg20irid + imei + imsi + encodeCID + rand16Num
				+ smsTimeStamp + apkstatus + "00000000000" + "0";
		result = algorithm.generateSmsSignatureAndEncrypt(mg20irid, result);
		if (result.equals(""))
			return "";
		String sms = "AE2" + result;
		return sms;
	}

	public static String post_tl_initcttl(Map<String, String> headers,
			String BaseClientHeader, String mg20irid, String ReportStr,
			String timeStamp, String miguED) {
		String result = "";
		String tl_initcttl_raw = generate_tl_initcttl(BaseClientHeader,
				timeStamp);
		String tl_initcttl_req = algorithm.generateNetSignatureAndEncrypt(
				mg20irid, ReportStr, tl_initcttl_raw, "", "", "", miguED);
		String Signature = Hmac.HmacSHA1("+  +POST+en_initcttlreq="
				+ tl_initcttl_req + headers.get("Header-Key"), "  &");
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		tl_initcttl_req = Url.encode(tl_initcttl_req);
		result = Http.doPost("http://gmota.g188.net:8080/migusdk/tl/initcttl",
				headers, "en_initcttlreq=" + tl_initcttl_req);
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
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/verification/checkSdkUpdate",
						headers, verification_checkSdkUpdate_req);
		return result;
	}

	public static String post_charge_getSession(Map<String, String> headers,
			String mg20irid, String sms, String ReportStr, String miguED) {
		String result = "";
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr,
						sms.substring(3), "", "", "", miguED);
		String Signature = Hmac.HmacSHA1("+  +POST+en_sessionreq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/getSession",
				headers, "en_sessionreq=" + charge_getSession_req);
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
				+ "<PolicyType>0</PolicyType>"
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<OrderNum>1</OrderNum>"
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<RedListUsrId></RedListUsrId>"
				+ "<BadRecType></BadRecType>"
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
				+ "</ProductCode>"
				+ "<OrderType></OrderType>"
				+ "<BatchSaleFlag>0</BatchSaleFlag>"
				+ "<SaleNum></SaleNum>"
				+ "<ScdChannel></ScdChannel>"
				+ "</OrderInfoList>"
				+ "</request>";
		return result;
	}

	public static String post_policySecLv_queryChargePolicyInfoReq(
			Map<String, String> headers, String mg20irid, String xml,
			String ReportStr, String miguED) {
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguED);
		String Signature = Hmac.HmacSHA1("+  +POST+en_policyinforeq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/policySecLv/queryChargePolicyInfoReq",
						headers, "en_policyinforeq=" + charge_getSession_req);
		return result;
	}

	public static String generate_tl_tcttl_recordPolicyLog(
			String BaseClientHeader, String LogTimeStamp, String phoneNumber,
			String Ctype, String Orderid, String Userid, String cpId,
			String contentId, String ChannelId, String productId, String Fee,
			String policy, String channelFlag, String redFunOpenFlag) {
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
				+ "^"
				+ Userid
				+ "^"
				+ "1"
				+ "^"
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

	public static String post_tl_tcttl(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String miguED) {
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguED);
		String Signature = Hmac.HmacSHA1("+  +POST+en_tcttlreq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost("http://gmota.g188.net:8080/migusdk/tl/tcttl",
				headers, "en_tcttlreq=" + charge_getSession_req);
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
				+ "<CommLog></CommLog>"
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<RequestTime>"
				+ LogTimeStamp.substring(0, 14)
				+ "</RequestTime>"
				+ "<VasType></VasType>"
				+ "<ServType></ServType>"
				+ "<SPCode></SPCode>"
				+ "<LaunchType>0</LaunchType>"
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
			String mg20irid, String xml, String ReportStr, String miguED) {
		String result = "";
		String charge_getSession_req = algorithm
				.generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "", miguED);
		String Signature = Hmac.HmacSHA1("+  +POST+en_sessionReq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/sessionReq",
				headers, "en_sessionReq=" + charge_getSession_req);
		return result;
	}

	public static String generate_charge_payReq_EDstr(String version,
			String timeStemp, String imei, int payCount) {
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
		buffer.append("tKV3:GetFieldID error");
		return buffer.toString();
	}

	public static String generate_charge_payReq(String BaseClientHeader,
			String ChargePolicy, String phoneNumber, String ChannelFlag,
			String LogTimeStamp, String Ctype, String OrderId, String Fee,
			String ItemId, String cpId, String contentId, String ChannelId,
			String productId, String Cpparam, String gameCid, String gameChid) {
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
				+ "<VerifyInfo><SMSToken></SMSToken><Token></Token><SDKSeq></SDKSeq><FeeRequestSeq></FeeRequestSeq><PicCode></PicCode><SmsCode></SmsCode><Usrname></Usrname><Pwd></Pwd></VerifyInfo>"
				+ "<UserID>"
				+ phoneNumber
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
				+ "<ReserveParam>"
				+ gameCid
				+ ","
				+ gameChid
				+ "</ReserveParam>"
				+ "<Contendesc></Contendesc>" + "</request>";
		return result;
	}

	public static String post_charge_payReq(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String ihJVd,
			String Lwkn, String EDstr, String ssov) {
		String result = "";
		String charge_payReq_req = algorithm.generateNetSignatureAndEncrypt(
				mg20irid, ReportStr, xml, ihJVd, Lwkn,
				headers.get("SDKVersion"), EDstr, ssov);
		String Signature = Hmac.HmacSHA1("+  +POST+add=0&en_billingreq="
				+ charge_payReq_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_payReq_req = Url.encode(charge_payReq_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/payReq", headers,
				"add=0&en_billingreq=" + charge_payReq_req);
		return result;
	}

	public static String generate_BaseClientHeader(String sSdkSessionid,
			String isSelfClient, String imei, String imsi, String RELEASE,
			String screen, String BRAND, String MODEL, String SDKVersion,
			String apiVersion, String MacAddr, String Location,
			String local_ip, String NetworkType) {
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

}
