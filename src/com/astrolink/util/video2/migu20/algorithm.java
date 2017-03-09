package com.astrolink.util.video2.migu20;

import com.astrolink.util.video2.utils.Http;
import com.astrolink.util.video2.utils.Url;

public class algorithm {
	public static String cpid = "9be321bd244faf09c96e9753770a669e";
	public static final String ip = "http://139.129.164.229:8080/migu20Server";

	// 1.���ż���У��ֵ�Ӽ���
	public static String generateSmsSignatureAndEncrypt(String mg20irid,
			String smsRaw) {
		String url = ip + "/generateSmsSignatureAndEncrypt/video/" + cpid + "/"
				+ mg20irid;
		String data = "smsRaw=" + Url.encode(smsRaw);
		String result = Http.doPost(url, null, data);
		if (!base.getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return base.getContextByTag(result, "sms");
	}

	// 2.������������
	public static String generateNetSignatureAndEncrypt(String mg20irid,
			String ReportStr, String netRaw, String ihJVd, String Lwkn,
			String SDKVersion, String EDstr, String ssov) {
		String url = ip + "/generateNetSignatureAndEncrypt/video/" + cpid + "/"
				+ mg20irid;
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

	// 2.������������
	public static String generateNetSignatureAndEncrypt(String mg20irid,
			String ReportStr, String netRaw, String ihJVd, String Lwkn,
			String SDKVersion, String miguEDVersion) {
		return generateNetSignatureAndEncrypt(mg20irid, ReportStr, netRaw,
				ihJVd, Lwkn, SDKVersion, "", miguEDVersion);
	}

	// 3������������
	public static String[] DecryptNet1(String mg20irid, String data) {
		String url = ip + "/decryptNet/video/" + cpid + "/" + mg20irid;
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

	// 4.����������� //������
	public static String[] DecryptNet2(String mg20irid, String data,
			String ihJVd, String Lwkn, String SDKVersion, String ssov) {
		String url = ip + "/decryptNet/video/" + cpid + "/" + mg20irid;
		String param = "netStr=" + Url.encode(data) + "&ihJVd="
				+ Url.encode(ihJVd) + "&Lwkn=" + Url.encode(Lwkn)
				+ "&SDKVersion=" + Url.encode(SDKVersion) + "&ssov="
				+ Url.encode(ssov);
		String result = Http.doPost(url, null, param);
		if (!base.getContextByTag(result, "code").equals("0")) {
			return null;
		}
		String[] results = new String[3];
		results[0] = base.getContextByTag(result, "netRawStr1");
		results[1] = base.getContextByTag(result, "netRawStr2");
		results[2] = base.getContextByTag(result, "netRawStr3");
		return results;
	}

	// 5.���ܶ��� //������
	public static String decryptSms(String mg20irid, String sms) {
		String url = ip + "/decryptSms/video/" + cpid + "/" + mg20irid;
		String data = "sms=" + Url.encode(sms);

		String result = Http.doPost(url, null, data);
		if (!base.getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return base.getContextByTag(result, "smsRaw");

	}

}
