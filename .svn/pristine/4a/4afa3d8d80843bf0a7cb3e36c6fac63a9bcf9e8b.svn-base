package com.astrolink.util.game2.migu20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.astrolink.util.game2.utils.Base64;


/**
 * @Description:TODO
 * @author miyc
 * @date 2016-3-24
 */
public class MiguGameLogEvent {

	private String logdata;
	private HashMap<String, String> cookie;

	private String sdkSessionId;
	private String sdkversion;
	private String imei;
	private String imsi;

	public void init(String sdkSessionId, String sdkversion, String cpId,
			String contentId, String channelId, String imei, String imsi,
			String macAddr, String brand, String model) {
		this.sdkSessionId = sdkSessionId;
		this.sdkversion = sdkversion;
		this.imei = imei;
		this.imsi = imsi;

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		logdata = "sdkSessionId@"
				+ sdkSessionId
				+ ",tel@111111111,uid@,sdkType@1,sdkVer@"
				+ sdkversion
				+ ",logVer@2.1,serviceType@6,cpId@"
				+ cpId
				+ ",contentId@"
				+ contentId
				+ ",channelId@"
				+ channelId
				+ ",installFlag@0,startFlag@7,packer@,uuid@"
				+ uuid
				+ ",imei@"
				+ imei
				+ ",imsi@"
				+ imsi
				+ ",macAddr@"
				+ macAddr
				+ ",brand@"
				+ brand
				+ ",model@"
				+ model
				+ ",operator@0,network@4,apnType@0,isProxyGateway@2,invokeTime@";

		cookie = new HashMap<String, String>();
	}

	public String gameLogEvent1(long logInvokeTime, String webSecond) {
		String logdata1 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + webSecond
				+ ",eventId@E0001,eventType@1";
		return post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata1, cookie);
	}

	public String gameLogEvent2(long logInvokeTime, String webSecond) {
		String logdata1 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + webSecond
				+ ",eventId@E0009_1,loginAccount@,loginMode@2,eventType@9";
		return post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata1, cookie);
	}

	public void gameLogEvent4(long logInvokeTime, String webSecond,
			String gameFee, String itemName, String consumeCode,
			String chargePolicy) {
		String logdata4 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ webSecond
				+ ",gamefee@"
				+ gameFee
				+ ",chargePolicy@"
				+ chargePolicy
				+ ",policyDesc@7,itemName@"
				+ itemName
				+ ",payName@话费支付,eventId@E0002_0,policy5Tel@,eventType@2,chargeTimes@,chargeType@0,itemCode@"
				+ consumeCode;
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata4, cookie);

	}

	public void gameLogEvent5(long logInvokeTime, String webSecond,
			String gameFee, String itemName, String consumeCode,
			String chargePolicy, String screen) {
		String[] split = screen.split("\\*");
		int screen_x = Integer.parseInt(split[0]);
		int screen_y = Integer.parseInt(split[1]);
		float x = screen_x / 2.0f - 20 + base.getRandom(50);
		float y = screen_y - screen_y / 3.0f + base.getRandom(50);

		String p1 = String.valueOf(getResultToServer(x));
		String p2 = String.valueOf(getResultToServer(y));
		String p3 = String.valueOf(base.getRandom(300) + 100);
		String p4 = String.valueOf(getResultToServer(1.0f));
		String p5 = generateKey(true);
		String p6 = generateKey(false);

		String logdata5 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + webSecond + ",p6@" + p6 + ",p5@" + p5

				+ ",policyDesc@,itemName@" + itemName + ",p4@" + p4 + ",p3@"
				+ p3 + ",payName@话费支付" + ",p2@" + p2 + ",p1@" + p1
				+ ",policy5Tel@,eventType@99" + ",gamefee@" + gameFee
				+ ",chargePolicy@" + chargePolicy
				+ ",eventId@E0002,chargeTimes@1,chargeType@0,itemCode@"
				+ consumeCode;
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata5, cookie);
	}

	public void gameLogEvent6(long logInvokeTime, String webSecond,
			String gameFee, String itemName, String consumeCode,
			String chargePolicy) {
		String logdata5 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ webSecond
				+ ",gamefee@"
				+ gameFee
				+ ",chargePolicy@"
				+ chargePolicy
				+ ",policyDesc@,itemName@"
				+ itemName
				+ ",payName@话费支付"
				+ ",eventId@E0002,policy5Tel@,eventType@2,chargeTimes@1,chargeType@0,itemCode@"
				+ consumeCode;
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata5, cookie);
	}

	public void gameLogEvent7(long logInvokeTime, String webSecond,
			String gameName, String gameFee, String itemName,
			String consumeCode, String chargePolicy, String screen,
			String systemVersionName, String packageName, String versionName,
			String versionCode, long stayTime) {
		String reserve1 = screen + "_" + systemVersionName + "__" + "1" + "_"
				+ "0" + "_" + "0" + "_" + "32" + "_" + packageName + "_"
				+ gameName + "_" + versionName + "_" + versionCode;
		String reserve2 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ webSecond
				+ ",reserve10@,reserve7@,reserve6@,reserve5@,reserve4@,reserve9@,reserve8@,track@,reserve3@,reserve2@,reserve1@"
				+ reserve1;
		reserve2 = getBLD(reserve2);
		String logdata6 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ webSecond
				+ ",policyDesc@,reserve10@,rawPolicy@"
				+ chargePolicy
				+ ",policy5Tel@,eventType@12,payTime@"
				+ logInvokeTime
				+ ",actionResult@23,stayTime@"
				+ stayTime
				+ ",eventId@E0012,itemCode@"
				+ consumeCode
				+ ",reserve7@,reserve6@,gameDiscountFee@,reserve5@,itemName@"
				+ itemName
				+ ",reserve4@,reserve9@,reserve8@,track@,applyCodeTime@,actionType@3,reserve3@,reserve2@"
				+ reserve2 + ",reserve1@" + reserve1 + ",gamefee@" + gameFee
				+ ",chargePolicy@" + chargePolicy + ",chargeTimes@,chargeType@";

		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata6, cookie);
	}

	private int getResultToServer(float arg6) {
		return 506968829 ^ (Float.floatToIntBits(arg6) ^ -1) ^ 534224095;
	}

	private String generateKey(boolean arg10) {
		int v1 = base.getRandom(1000000000) + 1000000000;
		String v5 = String.valueOf(v1);
		int v0 = v5.length();
		int v6 = Integer.parseInt(v5.substring(v0 - 1, v0));
		int v4 = arg10 ? v1 - v6 + 1 : v1 - v6;
		return "-" + String.valueOf(v4);
	}

	public static String getFormatTimeByMillis(long Millis) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(
				Millis));
	}

	/**
	 * 
	 * @param gameType
	 */
	public String queryConfiguration(String sdkversion, String imei,
			String imsi, String sdkSessionId, String contentId,
			String channelId, String gameType) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+"
				+ "channelId=" + channelId + "&contentId=" + contentId
				+ "&gameType=" + gameType, "Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/startup/queryConfiguration?channelId="
				+ channelId
				+ "&contentId="
				+ contentId
				+ "&gameType="
				+ gameType;
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	/**
	 * TODO 第二个，签名没有确认
	 */
	public String queryThirdPayInfo(String sdkversion, String imei,
			String imsi, String sdkSessionId, String contentId, String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+"
				+ "channelId=" + channelId + "&contentId=" + contentId,
				"Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/thirdPay/queryThirdPayInfo";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "contentId=" + contentId + "&channelId=" + channelId;
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	/**
	 * TODO 第三个，签名没有确认
	 */
	public String queryAll(String sdkversion, String imei, String imsi,
			String sdkSessionId, String contentId, String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+"
				+ "channelId=" + channelId + "&contentId=" + contentId
				+ "&tel=", "Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/desktopShortcut/queryAll";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "contentId=" + contentId + "&channelId=" + channelId
				+ "&tel=";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	/**
	 * TODO 第四个，签名没有确认
	 */
	public String queryCfgAct(String sdkversion, String imei, String imsi,
			String sdkSessionId, String contentId, String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+"
				+ "channelId=" + channelId + "&contentId=" + contentId
				+ "&tel=&userType=0", "Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/activityCfg/queryCfgAct";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "contentId=" + contentId + "&channelId=" + channelId
				+ "&tel=" + "&userType=0";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_accountManage_SDKClientVoucher(String chid,
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String contentId, String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&contentId=" + contentId, "Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/accountManage/SDKClientVoucher";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "contentId=" + contentId + "&channelId=" + channelId;
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_message_queryPushMessages(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&clientType=2&contentId=" + contentId
				+ "&ub=&uid=", "Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/message/queryPushMessages";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "uid=&ub=&clientType=2&channelId=" + channelId
				+ "&contentId=" + contentId;
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_thirdPay_queryConsumeInfo(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId, "Signature-OF-Secret&");
		String url = "http://drm.cmgame.com/egsb/thirdPay/queryConsumeInfo";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "channelId=" + channelId + "&contentId=" + contentId;
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_normandie_CheckLoginPolicy(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String cpId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+chid="
				+ channelId + "&cid=" + contentId + "&cpId=" + cpId + "&ms=",
				"Signature-OF-Secret&");
		String url = "http://wap.cmgame.com:7758/normandie/CheckLoginPolicy";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "cid=" + contentId + "&cpId=" + cpId + "&chid="
				+ channelId + "&ms=";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_verification_checkSdkUpdate(String sdkversion,
			String imei, String imsi, String sdkSessionId, String cpId,
			String contentId, String channelId, String model, String type,
			String versionCode) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+type=" + type
				+ "&versionCode=" + versionCode, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/verification/checkSdkUpdate";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "versionCode=" + versionCode + "&type=" + type
				+ "&cpId=" + cpId + "&contentId=" + contentId + "&channelId="
				+ channelId + "&model=" + URLEncoder.encode(model)
				+ "&sdkSessionId=" + sdkSessionId + "&networkType=4&from=0";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String get_egsb_otherPay_querySMSLimitMoney(String sdkversion,
			String imei, String imsi, String sdkSessionId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/otherPay/querySMSLimitMoney";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	public String post_normandie_querySafechargeRule(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String gameType) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");

		String url = "http://wap.cmgame.com:7758/normandie/QuerySafechargeRuleV2";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "<?xml version=\"1.0\" encoding=\"utf-8\"?><REQ><cId>"
				+ contentId + "</cId><chId>" + channelId
				+ "</chId><uniqId></uniqId><gameType>" + gameType
				+ "</gameType></REQ>";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_otherPay_querySMSInterceptorConf(String sdkversion,
			String imei, String imsi, String sdkSessionId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/message/queryPushMessages";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	public String post_normandie_QueryConfigPolicy(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String gameType) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");

		String url = "http://wap.cmgame.com:7758/normandie/QueryConfigPolicy";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "<?xml version=\"1.0\" encoding=\"utf-8\"?><REQ><cId>"
				+ contentId + "</cId><chId>" + channelId
				+ "</chId><uniqId></uniqId><gameType>" + gameType
				+ "</gameType></REQ>";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_gshare_switches(String sdkversion, String imei,
			String imsi, String sdkSessionId, String contentId,
			String channelId, String model) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId + "&tel=&ua=" + model,
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/gshare/switches";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "contentId=" + contentId + "&channelId=" + channelId
				+ "&tel=&ua=" + URLEncoder.encode(model) + "&gameType=1";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_behaviorLogging_eventLogging_accept(String sdkversion,
			String imei, String imsi, String sdkSessionId, String data,
			Map<String, String> Cookie) {
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+data=" + data,
				"Signature-OF-Secret&");

		String url = "http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "data=" + URLEncoder.encode(data);
		String result = httpConnect(url, headers, content, Cookie);// TODO

		return result;
	}

	public String post_egsb_verification_getUpdateUrl(String sdkversion,
			String imei, String imsi, String sdkSessionId, String cpId,
			String contentId, String channelId, String model, String packageName) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&clientType=2&contentId=" + contentId
				+ "&packageName=" + packageName + "&ua=" + model
				+ "&versionCode=1", "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/verification/getUpdateUrl";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "contentId=" + contentId + "&ua="
				+ URLEncoder.encode(model) + "&versionCode=1&channelId="
				+ channelId + "&packageName=" + packageName + "&clientType=2";
		String result = httpConnect(url, headers, content, null);

		return result;
	}

	public String get_egsb_authentication_getUserToken(String sdkversion,
			String imei, String imsi, String sdkSessionId, String rand4num) {
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+Encrypt-IMSI=" + imsi
						+ "&Random-Code=" + rand4num, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/authentication/getUserToken?Random-Code="
				+ rand4num + "&Encrypt-IMSI=" + imsi;
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	public String post_access_login(String sdkversion, String imei,
			String imsi, String sdkSessionId, String contentId,
			String channelId, String userToken) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId
				+ "&gameId=&loginType=2&needTel=1&userToken=" + userToken,
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/access/login";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "loginType=2&gameId=&contentId=" + contentId
				+ "&channelId=" + channelId + "&userToken=" + userToken
				+ "&needTel=1&tokenType=0";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String get_egsb_game_gamePlayerAuth(String sdkversion, String imei,
			String imsi, String sdkSessionId, String uid, String ub) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+ub=" + ub
				+ "&uid=" + uid, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/game/gamePlayerAuth?uid="
				+ uid + "&ub=" + ub;
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	public String post_egsb_market_queryAnnouncement(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String channelId, String contentId, String type) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId + "&type=" + type
				+ "&ub=" + ub + "&uid=" + uid, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/market/queryAnnouncement";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "uid=" + uid + "&ub=" + ub + "&channelId=" + channelId
				+ "&contentId=" + contentId + "&type=" + type + "&versionNum=3";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_market_queryCardMarket(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String channelId, String contentId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId + "&ub=" + ub + "&uid="
				+ uid, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/market/queryCardMarket";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "uid=" + uid + "&ub=" + ub + "&channelId=" + channelId
				+ "&contentId=" + contentId;
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String get_egsb_recommendGame_gameList(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String contentId, String channelId) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&clientPlatform=03&ua=HTC_Desire",
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/recommendGame/gameList?ua=HTC_Desire&clientPlatform=03&channelId="
				+ channelId
				+ "&uid="
				+ uid
				+ "&ub="
				+ ub
				+ "&contentId="
				+ contentId;
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	public String get_egsb_game_subscribeAuth(String sdkversion, String imei,
			String imsi, String sdkSessionId, String uid, String ub,
			String contentId, String channelId) {
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+authType=1&channelId=" + channelId
						+ "&contentId=" + contentId + "&gameId=0&ub=" + ub
						+ "&uid=" + uid, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/game/subscribeAuth?uid=" + uid
				+ "&ub=" + ub + "&authType=1&contentId=" + contentId
				+ "&channelId=" + channelId + "&gameId=0";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	public String post_egsb_securityCounting_userTransLogin(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String channelId, String contentId, String cpId,
			String model) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId + "&cpId=" + cpId
				+ "&cpparam=&ua=" + model + "&ub=" + ub + "&uid=" + uid,
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/securityCounting/userTransLogin";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "uid=" + uid + "&ub=" + ub + "&contentId=" + contentId
				+ "&cpId=" + cpId + "&channelId=" + channelId + "&cpparam=&ua="
				+ URLEncoder.encode(model) + "&needNotifyCP=1";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_discount_getLowestDiscountInfo(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String channelId, String contentId, String cpId,
			String consumeCode) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&consumeCode=" + consumeCode + "&contentId="
				+ contentId + "&packageId=&serviceId=&spId=" + cpId + "&ub="
				+ ub + "&uid=" + uid, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/discount/getLowestDiscountInfo";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "uid=" + uid + "&ub=" + ub + "&contentId=" + contentId
				+ "&spId=" + cpId + "&channelId=" + channelId + "&consumeCode="
				+ consumeCode + "&serviceId=&packageId=&adviceType=2";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_props_queryPayment(String sdkversion, String imei,
			String imsi, String sdkSessionId, String uid, String ub,
			String contentId, String consumeCode) {
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+contentId="
				+ contentId + "&packageId=&propsId=" + consumeCode + "&ub="
				+ ub + "&uid=" + uid, "Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/props/queryPayment";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "uid=" + uid + "&ub=" + ub + "&contentId=" + contentId
				+ "&propsId=" + consumeCode + "&packageId=";
		String result = httpConnect(url, headers, content, null);
		return result;
	}

	public String post_egsb_codes_queryExposureURL(String sdkversion,
			String imei, String imsi, String sdkSessionId) {
		String X_OF_Signature = getHmacSHA1("+X-OF-Signature+POST+",
				"X-OF-Signature&");
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+X-OF-Signature=" + X_OF_Signature
						+ "=&apiVersion=2.2&imei=" + imei + "&imsi=" + imsi
						+ "&platform=03&responseType=xml",
				"Signature-OF-Secret&");

		String url = "http://drm.cmgame.com/egsb/codes/queryExposureURL";
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String content = "platform=03&apiVersion=2.2&imei=" + imei + "&imsi="
				+ imsi + "&X-OF-Signature=" + URLEncoder.encode(X_OF_Signature)
				+ "&responseType=xml";
		String result = httpConnect(url, headers, content, null);

		return result;
	}

	public String get_checkCode(String url, String sdkversion, String imei,
			String imsi, String sdkSessionId, String ip, String macAddr,
			String uuid) {
		// m1
		String m1 = md52String32(imei.getBytes());
		// m1a
		String m1a = md52String32("android_id".getBytes());
		// m9b acf7f3494354 = macAddr
		String m9b = md52String32(macAddr.getBytes());
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+m1=" + m1
				+ "&m1a=" + m1a + "&m1b=&m1c=&m2=&m2a=&m3=&m9=&m9b=" + m9b
				+ "&m9c=&mo=0&ni=&ns=" + ip + "&nx=" + uuid,
				"Signature-OF-Secret&");

		url = url + "?mo=0&ni=&ns=" + ip + "&m1=" + m1 + "&m2=&m3=&m1a=" + m1a
				+ "&m2a=&m9=&m9b=" + m9b + "&m1b=&m1c=&m9c=&nx=" + uuid;
		String headers[][] = new String[][] { { "X-OF-Signature", Signature },
				{ "SDKVersion", sdkversion }, { "imei", imei },
				{ "imsi", imsi }, { "signer", Signature },
				{ "sdkSessionId", sdkSessionId } };
		String result = httpConnect(url, headers, null, null);
		return result;
	}

	private String httpConnect(String url, String[][] headers, String content,
			Map<String, String> Cookie) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			for (int i = 0; i < headers.length; i++) {
				conn.setRequestProperty(headers[i][0], headers[i][1]);
			}
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.3");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			if (Cookie != null && Cookie.containsKey("Cookie")) {
				conn.setRequestProperty("Cookie", (String) Cookie.get("Cookie"));
				conn.setRequestProperty("Cookie2", "$Version=1");
			}
			conn.setDoOutput(true);
			conn.setDoInput(true);
			if (content != null) {
				out = new PrintWriter(conn.getOutputStream());
				out.print(content);
				out.flush();
				if (Cookie != null
						&& conn.getHeaderFields().containsKey("Set-Cookie")) {
					String set_cookie = conn.getHeaderField("Set-Cookie");
					Cookie.put("Cookie",
							set_cookie.substring(0, set_cookie.indexOf(';')));
				}
			}
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// MyLog.e("MiguGameLogEvent", result);
		return result;
	}

	public static String md52String32(byte[] bytes) {
		StringBuffer localStringBuffer;
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(bytes);
			byte[] arrayOfByte = localMessageDigest.digest();
			localStringBuffer = new StringBuffer("");
			for (int i2 = 0; i2 < arrayOfByte.length; i2++) {
				int i1 = arrayOfByte[i2];
				if (i1 < 0)
					i1 += 256;
				if (i1 < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i1));
			}
			return localStringBuffer.toString().toUpperCase();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
			localNoSuchAlgorithmException.printStackTrace();
		}
		return "";
	}

	public String getHmacSHA1(String data, String key) {
		try {
			SecretKeySpec secretkey = new SecretKeySpec(key.getBytes("UTF-8"),
					"HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(((Key) secretkey));
			return Base64
					.encode(mac.doFinal(data.toString().getBytes("UTF-8")))
					.replace("\r\n", "");
		} catch (Exception e2) {
		}
		return "";
	}

	public static byte[] DESdecrypt(byte[] data, String key) {
		byte[] result;
		SecureRandom v0 = new SecureRandom();
		try {
			SecretKey secretkey = SecretKeyFactory.getInstance("DES")
					.generateSecret(new DESKeySpec(key.getBytes("UTF-8")));
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(2, ((Key) secretkey), v0);
			result = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	public static String getGameType(String game_type) {
		String result = game_type;
		if (isEmpty(game_type)) {
			result = "27";
		} else if ("2".equals(result)) {
			result = "24";
		} else {
			result = "28";
		}

		return result;
	}

	private static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	private String getBLD(String data) {
		String result = "";
		byte[] encodedKey = new byte[] { 48, -126, 2, 117, 2, 1, 0, 48, 13, 6,
				9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 4, -126, 2, 95,
				48, -126, 2, 91, 2, 1, 0, 2, -127, -127, 0, -64, -4, 55, 109,
				91, -105, -18, -57, -93, 78, 35, -1, 122, -37, 56, 82, -68,
				-27, -120, -56, -67, 17, -123, -74, 10, -65, -69, 44, 115, 105,
				-31, 124, 40, -56, 44, -29, -109, -30, 49, -103, -72, -26, 81,
				-116, 116, 43, -1, 86, -59, 29, -35, 90, 29, -91, 39, 93, 74,
				19, 65, 77, -44, 75, -63, -43, 7, 54, 37, 92, -62, 96, -3, -55,
				4, -88, 19, -125, 44, 89, -123, -117, 56, 79, 60, 23, -5, 71,
				127, -24, 97, -81, -28, 123, 37, 8, -123, -107, 8, 70, 100, 7,
				45, -3, -100, 1, 106, -124, 15, -52, -100, -37, 120, -126, -77,
				64, -17, -6, 23, -72, 43, -3, -16, 53, 22, 67, 22, -31, -123,
				91, 2, 3, 1, 0, 1, 2, -127, -128, 8, 45, 103, -57, -39, 126,
				-71, -98, 121, -4, 0, -88, 125, -77, 54, 82, -61, 48, 82, -72,
				118, -46, 124, 64, -9, 121, -94, 91, -62, -44, 52, -70, -57,
				27, -100, 83, 84, 91, -36, 80, 48, 54, -118, 52, 18, 100, 30,
				-32, -75, 95, -117, -106, -102, -12, -7, -109, 9, 101, -127,
				121, -29, -54, 5, -1, -122, -2, -70, -62, -53, 11, -20, -83,
				-64, -22, 120, -63, -37, 30, -76, 15, 96, 96, 29, -5, 116, -93,
				80, 89, 28, 14, -29, -91, 86, -94, 62, 25, -42, 124, -73, 4,
				-116, 107, -11, 60, -49, 79, -32, 0, -125, -101, 80, 30, -126,
				-50, 35, -28, 95, -55, 83, -10, 4, -97, -12, 119, 125, 41, 66,
				65, 2, 65, 0, -22, 86, -111, 126, -102, 19, 27, 1, -23, 113, 4,
				57, -24, 61, -124, -53, -116, -51, -85, -15, -60, 104, -81,
				-76, -103, 39, -72, 79, 118, 36, 118, 27, -4, 116, 116, 73, 4,
				23, -28, -69, -113, 62, 120, 15, -12, -90, -6, -108, 106, -8,
				-108, 67, -65, -66, -105, -83, -2, 93, 109, -39, 76, 50, 72,
				123, 2, 65, 0, -46, -45, 16, 22, 10, 47, 125, 103, 45, -95,
				-88, 25, -98, 7, -5, 101, 2, -38, 78, 23, 104, 77, -97, 54,
				107, 85, 9, 101, 70, 5, -93, -6, 13, 86, 21, -101, 94, 125, 29,
				-50, 14, 118, -54, 126, -42, 33, 40, 125, -93, 100, -10, -72,
				-83, -115, 1, -5, 67, -99, 28, -122, -59, -70, -48, -95, 2, 64,
				102, 22, -74, -91, -25, -21, -96, -35, 113, 92, -86, 17, -84,
				42, 120, -38, -48, -119, -99, 121, -29, 46, 20, 53, -30, 111,
				26, 109, -117, -77, -112, -68, -38, 123, -59, 89, 53, -18, 78,
				-40, -93, 43, -4, -44, 62, -86, 44, 10, 82, -101, -34, -61,
				-79, 26, 16, 44, 93, -33, 72, 6, -35, -102, 30, 87, 2, 64, 79,
				-18, -42, 90, -124, -30, 28, -103, -46, 35, 72, -88, -19, -47,
				-8, -17, 3, 117, -31, -59, -34, 54, 15, -9, -126, 26, 107, -59,
				-118, 22, -7, 101, 5, 73, 110, 71, -54, 59, -123, -31, 106,
				122, 127, -84, 55, 99, -69, 6, 103, -67, 16, 14, 85, 62, -15,
				81, 99, 1, 94, -97, 122, -72, -86, 1, 2, 64, 47, 48, 114, 115,
				111, -78, 68, 40, -46, 110, -80, -45, -13, -16, 68, 117, -15,
				-14, -61, 61, -67, -80, 44, -12, 9, 29, 3, 36, 24, 48, -118,
				-43, -75, -77, -98, 99, -4, -52, 57, -50, -112, 53, -78, 56, 6,
				21, -127, -35, -125, 49, 110, 44, 85, -67, -127, 14, 110, -52,
				57, -93, -75, 9, 65, 123 };
		try {
			PKCS8EncodedKeySpec pkcs8 = new PKCS8EncodedKeySpec(encodedKey);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey myPrivateKey = keyFactory.generatePrivate(pkcs8);
			java.security.Signature sig = java.security.Signature
					.getInstance("MD5withRSA");
			sig.initSign(myPrivateKey);
			sig.update(data.getBytes("UTF-8"));
			result = Base64.encode(sig.sign()) + "6";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
