package com.astrolink.util.tools.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.astrolink.consts.Const;
import com.astrolink.util.tools.PostNetWork;

import net.sf.json.JSONObject;

public class WoChannel20NetTools {
	private int connectionTimeout = Integer.parseInt(Const.WOCHANNE_connectionTimeout);
	private int soTimeout = Integer.parseInt(Const.WOCHANNE_soTimeout);
	public static byte[] LogKey = { 97, 50, 56, 55, 49, 57, 97, 99, 101, 48, 57, 53, 97, 53, 97, 97, 98, 51, 101, 48, 98, 101, 102, 55 };
	public static byte[] EnIV = { 48, 48, 48, 48, 48, 48, 48, 48 };
	public static byte[] PayKey = { 100, 98, 55, 100, 51, 53, 102, 56, 98, 100, 99, 56, 55, 53, 102, 55, 102, 48, 101, 101, 53, 100, 98, 52 };
	public static byte[] DeIV = { 48, 48, 48, 48, 48, 48, 48, 48 };
	public static byte[] SMSKey = { 100, 51, 101, 55, 98, 102, 102, 52, 56, 54, 102, 98, 55, 56, 100, 98, 51, 55, 49, 100, 57, 49, 54, 54 };
	public static String net = "WIFI";
	public static String netLower = "wifi";

	public static void UnipaySDKUpdate(JSONObject json) {
		String sdktype = json.optString("sdktype");
		String sdkversion = json.optString("sdkversion");
		String imsi = json.optString("imsi");
		String getURL = "http://unipayupg.wostore.cn:8080/SDKStoreManager/sdkRequest/sdkupdate.do??sdktype=" + sdktype + "&currentversion=" + sdkversion + "&IMSI=" + imsi + "&channelid=&appid=&cpid=&userid=";
		// get post data
		PostNetWork postNetWork = new PostNetWork(getURL);
		postNetWork.getPostMethod().addRequestHeader("Host", "unipayupg.wostore.cn:8080");
		postNetWork.getPostMethod().addRequestHeader("Connection", "Keep-Alive");
		postNetWork.getPostMethod().addRequestHeader("Accept-Encoding", "");
		postNetWork.getPostMethod().addRequestHeader("User-Agent", "");
		postNetWork.executeMethod();
		String respString = new String(WoChannel20Tools.writeByteArray(postNetWork.getInputStream()));
		System.out.println("NetResponse:\n" + respString);
	}

	@SuppressWarnings("deprecation")
	public static void UnipayLogin(JSONObject json) {
		String model2 = json.optString("model2");
		String packagename = json.optString("packagename");
		String logtypeLogin = json.optString("logtypeLogin");
		String versionCode = json.optString("versionCode");
		String mac = json.optString("mac");
		// String appid = json.optString("appid");
		String imei = json.optString("imei");
		String userid = json.optString("userid");
		String versionName = json.optString("versionName");
		String osversion = json.optString("osversion");
		String appname = json.optString("appname");
		String sdkversion = json.optString("sdkversion");
		String brand = json.optString("brand");
		String imsi = json.optString("imsi");
		// String channel = json.optString("channel");
		String serial = json.optString("serial");
		String filetype1 = json.optString("filetype1");
		String payAppid = json.optString("payAppid");
		String payChannel = json.optString("payChannel");
		String postURL = "http://unilog.wostore.cn:8061/logserver/unipay/unipayLogin";

		// get post data
		String datetime = WoChannel20Tools.GetDateTime();
		String plainData = "{\"model\":\"" + model2 + "\",\"packagename\":\"" + packagename + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypeLogin + "\",\"userid\":\"" + userid + "\",\"versionCode\":\"" + versionCode + "\",\"appid\":\"" + payAppid + "\",\"mac\":\"" + mac + "\",\"versionName\":\"" + versionName + "\",\"net\":\"" + net + "\",\"osversion\":\"" + osversion + "\",\"appname\":\"" + appname + "\",\"sdkversion\":\"" + sdkversion + "\",\"brand\":\"" + brand + "\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"channel\":\"" + payChannel + "\",\"serial\":\"" + serial + "\"}";
		//System.out.println(plainData);
		plainData = URLEncoder.encode(plainData);
		String content = WoChannel20Tools.EnDES(LogKey, EnIV, plainData);
		String postData = "{\"content\":\"" + content + "##\\r\\n\",\"filetype\":" + filetype1 + "}";
		// System.out.println(postData);
		postData = postData.replaceAll("/", "\\\\/");

		PostNetWork postNetWork = new PostNetWork(postURL);
		postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/json;charset=utf-8");
		// postNetWork.getPostMethod().addRequestHeader("Content-Length",
		// postData.length() + "");
		postNetWork.getPostMethod().addRequestHeader("Host", "unilog.wostore.cn:8061");
		postNetWork.getPostMethod().addRequestHeader("Connection", "Keep-Alive");
		postNetWork.setInfoInputStream(postData);
		postNetWork.executeMethod();
		// String respString = new
		// String(WoChannel20Tools.writeByteArray(postNetWork.getInputStream()));
		// System.out.println("NetResponse:\n" + respString);
		System.out.println(postNetWork.getString());

	}

	@SuppressWarnings("deprecation")
	public static void UnipayPay(JSONObject json) {

		String sdkversion = json.optString("sdkversion");
		String imei = json.optString("imei");
		String logtypePay = json.optString("logtypePay");
		String payAppid = json.optString("payAppid");
		String imsi = json.optString("imsi");
		String payChannel = json.optString("payChannel");
		String filetype3 = json.optString("filetype3");

		String postURL = "http://unilog.wostore.cn:8061/logserver/unipay/unipayPay";
		// get post data
		String datetime = WoChannel20Tools.GetDateTime();
		String plainData1 = "{\"result\":\"2604\",\"sdkversion\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypePay + "\",\"value\":\"1\",\"appid\":\"" + payAppid + "\",\"payway\":\"21\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"net\":\"" + netLower + "\",\"channel\":\"" + payChannel + "\",\"errcode\":\"支付开始\"}";
		plainData1 = URLEncoder.encode(plainData1);
		String content1 = WoChannel20Tools.EnDES(LogKey, EnIV, plainData1);

		datetime = WoChannel20Tools.GetDateTime();
		String plainData2 = "{\"result\":\"1001\",\"sdkversion\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypePay + "\",\"value\":\"1\",\"appid\":\"" + payAppid + "\",\"payway\":\"21\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"net\":\"" + netLower + "\",\"channel\":\"" + payChannel + "\",\"errcode\":\"\"}";
		plainData2 = URLEncoder.encode(plainData2);
		String content2 = WoChannel20Tools.EnDES(LogKey, EnIV, plainData2);

		datetime = WoChannel20Tools.GetDateTime();
		String plainData3 = "{\"result\":\"1005\",\"sdkversion\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypePay + "\",\"value\":\"1\",\"appid\":\"" + payAppid + "\",\"payway\":\"21\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"net\":\"" + netLower + "\",\"channel\":\"" + payChannel + "\",\"errcode\":\"\"}";
		plainData3 = URLEncoder.encode(plainData3);
		String content3 = WoChannel20Tools.EnDES(LogKey, EnIV, plainData3);

		datetime = WoChannel20Tools.GetDateTime();
		String plainData4 = "{\"result\":\"2648\",\"sdkversion\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypePay + "\",\"value\":\"1\",\"appid\":\"" + payAppid + "\",\"payway\":\"21\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"net\":\"" + netLower + "\",\"channel\":\"" + payChannel + "\",\"errcode\":\"\"}";
		plainData4 = URLEncoder.encode(plainData4);
		String content4 = WoChannel20Tools.EnDES(LogKey, EnIV, plainData4);

		datetime = WoChannel20Tools.GetDateTime();
		String plainData5 = "{\"result\":\"2652\",\"sdkversion\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypePay + "\",\"value\":\"1\",\"appid\":\"" + payAppid + "\",\"payway\":\"21\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"net\":\"" + netLower + "\",\"channel\":\"" + payChannel + "\",\"errcode\":\"\"}";
		plainData5 = URLEncoder.encode(plainData5);
		String content5 = WoChannel20Tools.EnDES(LogKey, EnIV, plainData5);

		// datetime = GetDateTime();
		String plainData6 = "{\"result\":\"2601\",\"sdkversion\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"logtype\":\"" + logtypePay + "\",\"value\":\"1\",\"appid\":\"" + payAppid + "\",\"payway\":\"21\",\"imsi\":\"" + imsi + "\",\"datetime\":\"" + datetime + "\",\"net\":\"" + netLower + "\",\"channel\":\"" + payChannel + "\",\"errcode\":\"支付成功\"}";
		plainData6 = URLEncoder.encode(plainData6);
		String content6 = WoChannel20Tools.EnDES(LogKey, EnIV, plainData6);

		String postData = "{\"content\":\"" + content1 + "##\\r\\n" + content2 + "##\\r\\n" + content3 + "##\\r\\n" + content4 + "##\\r\\n" + content5 + "##\\r\\n" + content6 + "##\\r\\n\",\"filetype\":" + filetype3 + "}";
		postData = postData.replaceAll("/", "\\\\/");
		// System.out.println(postData);

		PostNetWork postNetWork = new PostNetWork(postURL);
		postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/json;charset=utf-8");
		postNetWork.getPostMethod().addRequestHeader("Host", "unilog.wostore.cn:8061");
		postNetWork.getPostMethod().addRequestHeader("Connection", "Keep-Alive");
		postNetWork.setInfoInputStream(postData);
		postNetWork.executeMethod();
		// String respString = new
		// String(WoChannel20Tools.writeByteArray(postNetWork.getInputStream()));
		// System.out.println("NetResponse:\n" + respString);
		System.out.println(postNetWork.getString());

	}

	public static void UnipayQueryService(JSONObject json) {
		String imei = json.optString("imei");
		String model2 = json.optString("model2");
		String sdkversion = json.optString("sdkversion");
		String brand = json.optString("brand");
		String payAppid = json.optString("payAppid");
		String imsi = json.optString("imsi");
		String release = json.optString("release");
		// String payChannel = json.optString("payChannel");
		String channel = json.optString("channel");

		String postURL = "http://secpay.wostore.cn:81/unipay/queryService";
		String plainData = "{\"model\":\"" + model2 + "\",\"sdkver\":\"" + sdkversion + "\",\"imei\":\"" + imei + "\",\"brand\":\"" + brand + "\",\"appid\":\"" + payAppid + "\",\"imsi\":\"" + imsi + "\",\"release\":" + release + ",\"channelid\":\"" + channel + "\"}";
		//System.out.println(plainData);
		String content = WoChannel20Tools.EnDES(PayKey, EnIV, plainData);
		String postData = content;
		// System.out.println(postData);

		PostNetWork postNetWork = new PostNetWork(postURL);
		postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/json;charset=utf-8");
		postNetWork.getPostMethod().addRequestHeader("Host", "secpay.wostore.cn:81");
		postNetWork.getPostMethod().addRequestHeader("Connection", "close");
		postNetWork.getPostMethod().addRequestHeader("Accept-Encoding", "");
		postNetWork.getPostMethod().addRequestHeader("User-Agent", "");
		postNetWork.setInfoInputStream(postData);
		postNetWork.executeMethod();
		String respString = new String(WoChannel20Tools.writeByteArray(postNetWork.getInputStream()));
		System.out.println("NetResponse:" + respString);
		// System.out.println(postNetWork.getString());

	}

	@SuppressWarnings("deprecation")
	public static void UnipayPrecheck(JSONObject json) {
		String imsi = json.optString("imsi");
		String imei = json.optString("imei");
		String appversion = json.optString("appversion");
		String payAppid = json.optString("payAppid");
		String sdkversion = json.optString("sdkversion");
		String cpid = json.optString("cpid");
		String mac = json.optString("mac");
		String appdeveloper = json.optString("appdeveloper");
		String serviceid = json.optString("serviceid");
		String payChannel = json.optString("payChannel");
		String feename = json.optString("feename");
		String sdkversionShort = json.optString("sdkversionShort");
		String paytype = json.optString("paytype");
		String appname = json.optString("appname");
		String uuid = json.optString("uuid");
		String orderid = json.optString("orderid");
		String payfee = json.optString("payfee");

		String postURL = "http://secpay.wostore.cn:81/unipay/precheck";
		// get post data
		// String datetime = WoChannel20Tools.GetDateTime();
		String ordertime = WoChannel20Tools.GetYMDHMSTime();
		String plainData = "{\"imei\":\"" + imei + "\",\"appversion\":\"" + appversion + "\",\"appid\":\"" + payAppid + "\",\"sdktotalversion\":\"" + sdkversion + "\",\"cpid\":\"" + cpid + "\",\"mac\":\"" + mac + "\",\"ordertime\":\"" + ordertime + "\",\"appdeveloper\":\"" + appdeveloper + "\",\"serviceid\":\"" + serviceid + "\",\"channelid\":\"" + payChannel + "\",\"feename\":\"" + feename + "\",\"sdkversion\":\"" + sdkversionShort + "\",\"paytype\":\"" + paytype + "\",\"appname\":\"" + appname + "\",\"imsi\":\"" + imsi + "\",\"uuid\":\"" + uuid + "\",\"orderid\":\"" + orderid + "\",\"payfee\":\"" + payfee + "\"}";
		//System.out.println(plainData);
		plainData = URLEncoder.encode(plainData);
		String content = WoChannel20Tools.EnDES(PayKey, EnIV, plainData);
		String postData = content;
		// System.out.println(postData);

		PostNetWork postNetWork = new PostNetWork(postURL);
		postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/json;charset=utf-8");
		// postNetWork.getPostMethod().addRequestHeader("Content-Length",
		// postData.length() + "");
		postNetWork.getPostMethod().addRequestHeader("Host", "secpay.wostore.cn:81");
		postNetWork.getPostMethod().addRequestHeader("Connection", "Keep-Alive");
		postNetWork.setInfoInputStream(postData);
		postNetWork.executeMethod();
		String respString = new String(WoChannel20Tools.writeByteArray(postNetWork.getInputStream()));
		System.out.println("NetResponse:" + respString);
		// System.out.println(postNetWork.getString());

	}
}
