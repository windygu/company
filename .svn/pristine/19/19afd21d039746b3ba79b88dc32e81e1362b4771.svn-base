package com.astrolink.util.tools.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DmNetTools20 {
	private static Log			logger				= LogFactory.getLog(DmNetTools20.class);
	public static final String	ip					= "http://139.129.164.229:8080/migu20Server";
	public static String		cpid				= "9be321bd244faf09c96e9753770a669e";

	// 获取移动订单
	public static String getOrderId(String PayCode, String AppId, String ChannelId, long millis,String EN) {
		String xml = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>" + "<Request>" + "<MsgType>GetOrderIdReq</MsgType>" + "<PayCode>" + PayCode + "</PayCode>" + "<AppId>" + AppId + "</AppId>" + "<Timestamp>" + millis / 1000 + "</Timestamp>" + "<ChannelId>" + ChannelId + "</ChannelId>";
		if (EN.equals("N")) {
			xml += "<PayType>1002</PayType>";
		}
		xml += "</Request>";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "text/plain; charset=ISO-8859-1");
		DmNetWorkIO dmn=new DmNetWorkIO();
		String result = dmn.netWorkIO("http://218.207.208.20:20136/capacc", headers, xml);

		
		return DmTools20.getContextByTag(result, "OrderId");
	}

	// 1.短信计算校验值加加密
	public static String generateSmsSignatureAndEncrypt(String mg20irid, String smsRaw) {
		String url = ip + "/generateSmsSignatureAndEncrypt/manga/" + cpid + "/" + mg20irid;
		String data = "smsRaw=" + DmTools20.URLencode(smsRaw);
		DmNetWorkIO dmn=new DmNetWorkIO();
		String result = dmn.netWorkIO(url, null, data);
		if (!DmTools20.getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return DmTools20.getContextByTag(result, "sms");
	}

	// 2.加密网络请求
	public static String generateNetSignatureAndEncrypt(String mg20irid, String ReportStr, String netRaw, String ihJVd, String Lwkn, String SDKVersion, String EDstr, String ssov) {
		String url = ip + "/generateNetSignatureAndEncrypt/manga/" + cpid + "/" + mg20irid;
		String data = "netRaw=" + DmTools20.URLencode(netRaw) + "&ReportStr=" + DmTools20.URLencode(ReportStr) + "&ihJVd=" + DmTools20.URLencode(ihJVd) + "&Lwkn=" + DmTools20.URLencode(Lwkn) + "&SDKVersion=" + DmTools20.URLencode(SDKVersion) + "&EDstr=" + DmTools20.URLencode(EDstr) + "&ssov=" + DmTools20.URLencode(ssov);
		DmNetWorkIO dmn=new DmNetWorkIO();
		String result = dmn.netWorkIO(url, null, data);
		if (!DmTools20.getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return DmTools20.getContextByTag(result, "netStr");
	}

	// 2.加密网络请求
	public static String generateNetSignatureAndEncrypt(String mg20irid, String ReportStr, String netRaw, String ihJVd, String Lwkn, String SDKVersion,String ssov) {
		return generateNetSignatureAndEncrypt(mg20irid, ReportStr, netRaw, ihJVd, Lwkn, SDKVersion, "", ssov);
	}

	// 3解密网络请求
	public static String[] DecryptNet1(String mg20irid, String data) {
		String url = ip + "/decryptNet/manga/" + cpid + "/" + mg20irid;
		String param = "netStr=" + DmTools20.URLencode(data);
		DmNetWorkIO dmn=new DmNetWorkIO();
		String result = dmn.netWorkIO(url, null, param);
		if (!DmTools20.getContextByTag(result, "code").equals("0")) {
			return null;
		}
		String[] results = new String[2];
		results[0] = DmTools20.getContextByTag(result, "netRawStr1");
		results[1] = DmTools20.getContextByTag(result, "netRawStr2");
		return results;
	}

}
