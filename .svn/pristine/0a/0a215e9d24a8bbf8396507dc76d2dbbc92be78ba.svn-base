package com.astrolink.util.game2.migu20;

import com.astrolink.util.game2.utils.Http;
import com.astrolink.util.game2.utils.Url;

public class algorithm {
	public static String cpid = "";
	public static String ip = "";

	public static String port = "";

	// 1.短信计算校验值加加密
	public static String generateSmsSignatureAndEncrypt(String mg20irid,
			String smsRaw) {
		String url = ip + "/generateSmsSignatureAndEncrypt/" + port + "/"
				+ cpid + "/" + mg20irid;
		String data = "smsRaw=" + Url.encode(smsRaw);
		String result = Http.doPost(url, null, data);
		if (!base.getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return base.getContextByTag(result, "sms");
	}

	// 2.加密网络请求
	public static String generateNetSignatureAndEncrypt(String mg20irid,
			String ReportStr, String netRaw, String ihJVd, String Lwkn,
			String SDKVersion, String EDstr, String ssov) {
		String url = ip + "/generateNetSignatureAndEncrypt/" + port + "/"
				+ cpid + "/" + mg20irid;
		String data = "netRaw=" + Url.encode(netRaw) + "&ReportStr="
				+ Url.encode(ReportStr) + "&ihJVd=" + Url.encode(ihJVd)
				+ "&Lwkn=" + Url.encode(Lwkn) + "&SDKVersion="
				+ Url.encode(SDKVersion) + "&EDstr=" + Url.encode(EDstr)
				+ "&ssov=" + Url.encode(ssov);
		String result = Http.doPost(url, null, data);
		if (!base.getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return base.getContextByTag(result, "netStr");
	}

	// 2.加密网络请求
	public static String generateNetSignatureAndEncrypt(String mg20irid,
			String ReportStr, String netRaw, String ihJVd, String Lwkn,
			String SDKVersion, String miguED) {
		return generateNetSignatureAndEncrypt(mg20irid, ReportStr, netRaw,
				ihJVd, Lwkn, SDKVersion, "", miguED);
	}

	// 3解密网络请求
	public static String[] DecryptNet1(String mg20irid, String data) {
		String url = ip + "/decryptNet/" + port + "/" + cpid + "/" + mg20irid;
		String param = "netStr=" + Url.encode(data);
		String result = Http.doPost(url, null, param);
		if (!base.getContextByTag(result, "code").equals("0")) {
			return null;
		}
		String[] results = new String[2];
		results[0] = base.getContextByTag(result, "netRawStr1");
		results[1] = base.getContextByTag(result, "netRawStr2");
		return results;
	}
}
