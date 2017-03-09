package com.astrolink.util.game2.migu20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

import com.astrolink.dao.Game2ExecLinstenerThreadDao;
import com.astrolink.util.game2.utils.Base64;

public class game_V20154 {

	private static char[] aaZ = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '+', '/' };
	private static byte[] aba = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1,
			-1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1,
			-1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
			41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
	private static String abb = "emag+/HF";
	private static final int abc = 8;
	public static String soVersion = "03010001";
	public static String sdkversion = "20158";
	private static int[] abd;
	private static int abe;
	public static byte[] Key1 = null;
	public static byte[] Key2 = null;
	public static String gameType = null;
	public static String rules = null;
	public static String appid = null;
	public static String chid = null;
	public static String pkgid = null;
	public static String cpId = null;
	public static String imsi = null;
	public static String imei = null;
	public static String sdkSessionId = null;
	public static String contentId = null;
	public static String packer = null;
	public static String netstat = null;
	public static String rand4num = null;
	public static String sdk_int = null;
	public static String BRAND = null;
	public static String MODEL = null;
	public static String device_cid = null;

	public static String consumeCode = null;
	public static String gamefee = null;
	public static String itemName = null;

	public static String packageName = null;
	public static String displayName = null;
	public static String versionName = null;
	public static String versionCode = null;

	private static String uid = "1485786679";
	// private static String uid = null;
	private static String tel = "15709448325";
	private static String ub = "d0a9cd2bae585a90b9c031409603d8b8";
	private static int chargePolicy = 1;

	static {
		bV(abb);
	}

	public static void main(String[] args) {

	}



	// 诸神战纪EX：血族国�?
	public static void xzgd() {
		Key1 = hexString2Bytes("588E49FB4010A17BE39F523CD48A40D9B0A4C4F50002000000000000650107417D730E0F06070472010705650F446C053636363636363636363636363636363636363636363636363636363636363636363636363636363636363636");
		Key2 = hexString2Bytes("8C16DC73B1F3B19359F70F76589649CC3E2FDC9D00020000000000000F6B6D2B171964656C6D6E186B6D6F0F652E066F5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C5C");
		gameType = "6";
		appid = "00611442";
		chid = "42606000";
		pkgid = "000000000000";

		imsi = "460079550810011";// androidstyle
		imei = "861007020172600";
		contentId = "624516058119";
		packer = "";
		cpId = "799245";

		consumeCode = "006111984015";
		gamefee = "200";
		itemName = "新手礼包";

		rules = "2"; // WIFI -> 2 ; NONE -> 1
		netstat = "WIFI";

		sdk_int = "16";
		BRAND = "Xiaomi";
		MODEL = "MI 2S";
		device_cid = "45010053454d313647907255c83830d8";

		rand4num = "1359";
		sdkSessionId = "DqPc1sNszfLl";
		// //0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz

		packageName = "com.ycgame.vampire.cmcc";
		displayName = "诸神战纪EX：血族国�?";
		versionName = "5.1.1-1819727";
		versionCode = "22";
	}



	public static void run() {
		String ip = "10.0.2.15";
		String uuid = "b94c35d2cc7d4a82ba21df506cb5dd93";// UUID.randomUUID().toString().replaceAll("-",
															// "");//
															// //deviceId.txt
		String macAddr = "acf7f3494354";
		String logdata = "sdkSessionId@" + sdkSessionId
				+ ",tel@,uid@,sdkType@1,sdkVer@" + sdkversion
				+ ",logVer@2.1,serviceType@6,cpId@" + cpId + ",contentId@"
				+ contentId + ",channelId@" + chid
				+ ",installFlag@0,startFlag@7,packer@,uuid@" + uuid + ",imei@"
				+ imei + ",imsi@" + imsi + ",macAddr@" + macAddr + ",brand@"
				+ BRAND + ",model@" + MODEL
				+ ",operator@1,network@0,invokeTime@";

		long logInvokeTime = System.currentTimeMillis();
		long logEventInvokeTime = 0;

		Map<String, String> Cookie = new HashMap<String, String>();
		// start game
		post_egsb_accountManage_SDKClientVoucher(sdkversion, imei, imsi,
				sdkSessionId, contentId, chid);
		post_egsb_message_queryPushMessages(sdkversion, imei, imsi,
				sdkSessionId, contentId, chid);
		// if(true)
		// return;

		// click start button
		post_egsb_accountManage_SDKClientVoucher(sdkversion, imei, imsi,
				sdkSessionId, contentId, chid);
		post_egsb_thirdPay_queryConsumeInfo(sdkversion, imei, imsi,
				sdkSessionId, contentId, chid);
		post_normandie_CheckLoginPolicy(sdkversion, imei, imsi, sdkSessionId,
				contentId, chid, cpId);
		post_egsb_verification_checkSdkUpdate(sdkversion, imei, imsi,
				sdkSessionId, cpId, contentId, chid, MODEL, "3", "90016");// http://drm.cmgame.com/egsb/verification/checkSdkUpdate
		get_egsb_otherPay_querySMSLimitMoney(sdkversion, imei, imsi,
				sdkSessionId);
		post_normandie_querySafechargeRule(sdkversion, imei, imsi,
				sdkSessionId, contentId, chid, gameType);// http://wap.cmgame.com:7758/normandie/querySafechargeRule
		post_egsb_otherPay_querySMSInterceptorConf(sdkversion, imei, imsi,
				sdkSessionId);
		post_normandie_QueryConfigPolicy(sdkversion, imei, imsi, sdkSessionId,
				contentId, chid, gameType);
		post_egsb_verification_checkSdkUpdate(sdkversion, imei, imsi,
				sdkSessionId, cpId, contentId, chid, MODEL, "1", "5030100");// http://drm.cmgame.com/egsb/verification/checkSdkUpdate
		post_egsb_gshare_switches(sdkversion, imei, imsi, sdkSessionId,
				contentId, chid, MODEL);// http://drm.cmgame.com/egsb/gshare/switches

		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log1
		logEventInvokeTime += 30000 + getRandom(30000);
		logInvokeTime += logEventInvokeTime;
		String logdata1 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + logEventInvokeTime / 1000
				+ ",eventId@E0001,eventType@1";
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata1, Cookie);

		post_egsb_verification_checkSdkUpdate(sdkversion, imei, imsi,
				sdkSessionId, cpId, contentId, chid, MODEL, "1", sdkversion);// http://drm.cmgame.com/egsb/verification/checkSdkUpdate

		if (uid == null) {

			// login sms
			generateLoginSMS(imsi, rand4num, imei, sdk_int, chid, contentId,
					fixStr(BRAND, 10), fixStr(MODEL, 12), netstat, sdkversion,
					sdkSessionId, packer);
			// login request
			post_egsb_verification_getUpdateUrl(sdkversion, imei, imsi,
					sdkSessionId, cpId, contentId, chid, MODEL, packageName);// http://drm.cmgame.com/egsb/verification/getUpdateUrl
			String egsb_authentication_getUserToken_rep = get_egsb_authentication_getUserToken(
					sdkversion, imei, imsi, sdkSessionId, rand4num);
			String userToken = getContextByTag(
					egsb_authentication_getUserToken_rep, "userToken");
			String access_login_rsp = post_access_login(sdkversion, imei, imsi,
					sdkSessionId, contentId, chid, userToken);
			if (!getContextByTag(access_login_rsp, "status").equals("0"))
				return;
			uid = getContextByTag(access_login_rsp, "uid");
			ub = getContextByTag(access_login_rsp, "ub");
			tel = new String(DESdecrypt(
					hexString2Bytes(new String(
							Base64.decode2bytes(getContextByTag(
									access_login_rsp, "tel")))), "android_sdk"));

			System.out.println("uid=" + uid);
			System.out.println("ub=" + ub);
			System.out.println("tel=" + tel);

		}
		String egsb_game_gamePlayerAuth_rsp = get_egsb_game_gamePlayerAuth(
				sdkversion, imei, imsi, sdkSessionId, uid, ub);
		if (!getContextByTag(egsb_game_gamePlayerAuth_rsp, "status")
				.equals("0"))
			return;
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log2
		logEventInvokeTime += 15000 + getRandom(15000);
		logInvokeTime += logEventInvokeTime;
		String logdata2 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ logEventInvokeTime
				/ 1000
				+ ",smsResult@1,eventId@E0007,smsDescn@7,eventType@7,screen@720*1280,os@4.1.1,location@,isRooted@1,smsFirewall@1,packageName@"
				+ packageName + ",displayName@" + displayName + ",versionName@"
				+ versionName + ",versionCode@" + versionCode;
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata2, Cookie);
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log3
		logEventInvokeTime += 200 + getRandom(800);
		logInvokeTime += logEventInvokeTime;
		String logdata3 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + logEventInvokeTime / 1000
				+ ",eventId@E0009_1,loginAccount@" + tel
				+ ",loginMode@2,eventType@9";
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata3, Cookie);

		String egsb_market_queryAnnouncement_rsp_1 = post_egsb_market_queryAnnouncement(
				sdkversion, imei, imsi, sdkSessionId, uid, ub, chid, contentId,
				"2");
		if (!getContextByTag(egsb_market_queryAnnouncement_rsp_1, "status")
				.equals("0"))
			return;
		post_egsb_market_queryCardMarket(sdkversion, imei, imsi, sdkSessionId,
				uid, ub, chid, contentId);// http://drm.cmgame.com/egsb/market/queryCardMarket
		get_egsb_recommendGame_gameList(sdkversion, imei, imsi, sdkSessionId,
				uid, ub, contentId, chid);// http://drm.cmgame.com/egsb/recommendGame/gameList?ua=HTC_Desire&clientPlatform=03&channelId=12064000&uid=208380850&ub=9a388bf81f851efb52a6059fe3b6bdb4&contentId=622416051249
		String egsb_game_subscribeAuth_rsp = get_egsb_game_subscribeAuth(
				sdkversion, imei, imsi, sdkSessionId, uid, ub, contentId, chid);
		if (!getContextByTag(egsb_game_subscribeAuth_rsp, "status").equals("0"))
			return;
		String egsb_securityCounting_userTransLogin_rsp = post_egsb_securityCounting_userTransLogin(
				sdkversion, imei, imsi, sdkSessionId, uid, ub, chid, contentId,
				cpId, MODEL);
		if (!getContextByTag(egsb_securityCounting_userTransLogin_rsp, "status")
				.equals("0"))
			return;

		// open order window
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log4
		// logEventInvokeTime += 1000000 + getRandom(1000000);
		logEventInvokeTime += 1000 + getRandom(5000);
		logInvokeTime += logEventInvokeTime;
		long stayTime = logInvokeTime;

		// eventInvokeTime@14,gamefee@200,chargePolicy@1,policyDesc@,itemName@30个幸运星,eventId@E0002_0,policy5Tel@,eventType@2,chargeTimes@,chargeType@0,itemCode@006030454001
		String logdata4 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ logEventInvokeTime
				/ 1000
				+ ",gamefee@"
				+ gamefee
				+ ",chargePolicy@"
				+ chargePolicy
				+ ",policyDesc@,itemName@"
				+ itemName
				+ ",eventId@E0002_0,policy5Tel@,eventType@2,chargeTimes@,chargeType@0,itemCode@"
				+ consumeCode;
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata4, Cookie);

		String egsb_discount_getLowestDiscountInfo_rsp = post_egsb_discount_getLowestDiscountInfo(
				sdkversion, imei, imsi, sdkSessionId, uid, ub, chid, contentId,
				cpId, consumeCode);
		// if (!getContextByTag(egsb_discount_getLowestDiscountInfo_rsp,
		// "status")
		// .equals("0"))
		// return;
		String egsb_props_queryPayment_rsp = post_egsb_props_queryPayment(
				sdkversion, imei, imsi, sdkSessionId, uid, ub, contentId,
				consumeCode);
		String egsb_market_queryAnnouncement_rsp_2 = post_egsb_market_queryAnnouncement(
				sdkversion, imei, imsi, sdkSessionId, uid, ub, chid, contentId,
				"1");
		if (!getContextByTag(egsb_market_queryAnnouncement_rsp_2, "status")
				.equals("0"))
			return;

		// click order button
		String req = generate_portalone_GetThirdPartySession_req(
				getGameType(gameType), rules, sdkversion, contentId, chid,
				pkgid, consumeCode, imsi, imei, sdkSessionId, appid,
				device_cid, soVersion);
		String portalone_GetThirdPartySession_req = post_portalone_GetThirdPartySession(
				sdkversion, imei, imsi, sdkSessionId, req, cpId, contentId,
				chid, consumeCode);
		String sessionID = getsessionID(portalone_GetThirdPartySession_req);
		// String sessionID = null;
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log5
		logEventInvokeTime += 1000 + getRandom(5000);
		logInvokeTime += logEventInvokeTime;
		String logdata5 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ logEventInvokeTime
				/ 1000
				+ ",gamefee@"
				+ gamefee
				+ ",chargePolicy@"
				+ chargePolicy
				+ ",policyDesc@,itemName@"
				+ itemName
				+ ",eventId@E0002,policy5Tel@,eventType@2,chargeTimes@1,chargeType@0,itemCode@"
				+ consumeCode;
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata5, Cookie);

		long paytime = logInvokeTime + 10000 + getRandom(5000);
		generateOrderSMS(getGameType(gameType), rules, sdkversion, contentId,
				chid, pkgid, consumeCode, imsi, imei, sdkSessionId, appid,
				sessionID, netstat, paytime);
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log6
		logEventInvokeTime += 500 + getRandom(500);
		logInvokeTime += logEventInvokeTime;
		stayTime = logInvokeTime - stayTime;
		paytime = logInvokeTime - paytime;
		// 1_1_7_1 = isRooted + smsResult + smsDescn + smsFireWall
		String reserve1 = "720*1280" + "_" + "4.1.1" + "__" + "1" + "_" + "1"
				+ "_" + "7" + "_" + "1" + "_" + packageName + "_" + displayName
				+ "_" + versionName + "_" + versionCode;
		String reserve2 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ logEventInvokeTime
				/ 1000
				+ ",reserve10@,reserve7@,reserve6@,reserve5@,reserve4@,reserve9@,reserve8@,track@,reserve3@,reserve2@,reserve1@"
				+ reserve1;
		reserve2 = getBLD(reserve2);
		String logdata6 = logdata
				+ getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@"
				+ logEventInvokeTime / 1000
				+ ",policyDesc@,reserve10@,rawPolicy@"
				+ chargePolicy
				+ ",policy5Tel@,eventType@12,payTime@"
				+ paytime
				+ ",actionResult@20,stayTime@"
				+ stayTime
				+ ",eventId@E0012,itemCode@"
				+ consumeCode
				+ ",reserve7@,reserve6@,gameDiscountFee@"
				+ gamefee
				+ ",reserve5@,itemName@"
				+ itemName
				+ ",reserve4@,reserve9@,reserve8@,track@,applyCodeTime@,actionType@3,reserve3@,reserve2@"
				+ reserve2 + ",reserve1@" + reserve1 + ",gamefee@" + gamefee
				+ ",chargePolicy@" + chargePolicy
				+ ",chargeTimes@2,chargeType@0";
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata6, Cookie);

		// open exit window
		String egsb_codes_queryExposureURL_req = post_egsb_codes_queryExposureURL(
				sdkversion, imei, imsi, sdkSessionId);// http://drm.cmgame.com/egsb/codes/queryExposureURL
		if (!getContextByTag(egsb_codes_queryExposureURL_req, "status").equals(
				"0"))
			return;
		String checkCodeURL = getContextByTag(egsb_codes_queryExposureURL_req,
				"url");
		get_checkCode(checkCodeURL, sdkversion, imei, imsi, sdkSessionId, ip,
				macAddr, uuid);
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log7
		logEventInvokeTime += 300000 + getRandom(300000);
		logInvokeTime += logEventInvokeTime;
		String logdata7 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + logEventInvokeTime / 1000
				+ ",eventId@E0005_0,eventType@5";
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata7, Cookie);

		// click exit button
		// http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?
		// log8
		logEventInvokeTime += 2000 + getRandom(8000);
		logInvokeTime += logEventInvokeTime;
		String logdata8 = logdata + getFormatTimeByMillis(logInvokeTime)
				+ ",eventInvokeTime@" + logEventInvokeTime / 1000
				+ ",eventId@E0005,eventType@5";
		post_behaviorLogging_eventLogging_accept(sdkversion, imei, imsi,
				sdkSessionId, logdata8, Cookie);
	}

	public static String generateLoginSMS(String imsi, String rand4num,
			String imei, String sdk_int, String chid, String contentid,
			String BRAND, String MODEL, String netstat, String sdkversion,
			String sdkSessionId, String packer) {
		String result = "BUB@T|";
		if (netstat.equals("NONE")) {
			result = "BUB@|";
		}
		result += encodeLoginSMS((imsi + "@" + rand4num + "@" + imei + "@"
				+ sdk_int + "@" + chid + "@" + contentid + "@" + BRAND + "@"
				+ MODEL + "@" + netstat + "@" + sdkversion + "@" + sdkSessionId
				+ "@" + packer).replace("\r", "").replace("\n", "")
				.replace("\r\n", "").replace("�?", ""));
		System.out.println("sms addresss:\n10658422\nsms content:\n" + result);

		System.out
				.println("am start -a android.intent.action.SENDTO -d sms:10658422 --es sms_body "
						+ "\"" + result + "\"");

		return result;
	}

	public static String generateOrderSMS(String gametype, String rules,
			String sdkversion, String contentid, String chid, String pkgid,
			String consumeCode, String imsi, String imei, String sdkSessionId,
			String appid, String sessionID, String netstat, long paytime) {
		String result = "";
		String appValue = convertLongTo62Str(Long.valueOf(appid), 5);
		result = gametype + rules + sdkversion + contentid + chid + pkgid
				+ consumeCode + imsi.substring(3);
		result = "02" + firstEncrypt(result) + "0000000000000000"
				+ getIMEIUID(imei) + "@@000000000" + sdkSessionId;
		if (netstat.equals("NONE")) {
			result = result
					+ "0"
					+ appValue
					+ "1"
					+ sessionID
					+ "3"
					+ "001"
					+ generateSingnature(appValue + "1" + sessionID + "3"
							+ "001"
							+ byte2hexString(encodeSMS(result).getBytes()))
					+ "6";
		} else if (sessionID == null) {
			String timestemp = getTimeStemp(paytime);
			result = result
					+ "0"
					+ appValue
					+ "1"
					+ timestemp
					+ "6"
					+ "WW1"
					+ generateSingnature(appValue
							+ "1"
							+ timestemp
							+ "6"
							+ "WW1"
							+ byte2hexString(encodeSMS(result + "0").getBytes()))
					+ "6";
		} else {
			result = result
					+ "0"
					+ appValue
					+ "1"
					+ "5"
					+ "001"
					+ sessionID
					+ generateSingnature(appValue
							+ "1"
							+ "5"
							+ "001"
							+ sessionID
							+ byte2hexString(encodeSMS(result + "0").getBytes()))
					+ "7";
			// result = result
			// + "4"
			// + appValue
			// + "1"
			// + "5"
			// + "001"
			// + sessionID
			// + generateSingnature(appValue
			// + "1"
			// + "5"
			// + "001"
			// + sessionID
			// + byte2hexString(encodeSMS(result + "4").getBytes()))
			// + "7";
			// result = result + appValue + "6"+ "2" + "004"+ sessionID
			// +generateSingnature( appValue + "6" + "2" + "004" + sessionID
			// +byte2hexString( encodeSMS( result ).getBytes()) )+ "7";

			// 02 0KqU8TWziVI0wel2oyt6bg0000AjnLVcmAKvcMP 00000100001234563
			// wq2fi8av @@000000000 tmzgug9fr5kf00238k15001 null
			// efca7QI5Ou0kqwdNIlOEaM5qwOE=7
		}
		result = encodeSMS(result);
		result = encodeOrderSMS(result);

		System.out
				.println("sms addresss:\n1065889923\nsms content:\n" + result);

		System.out
				.println("am start -a android.intent.action.SENDTO -d sms:1065889923 --es sms_body "
						+ "\""
						+ result.replaceAll("\\\\", "\\\\\\\\")
								.replaceAll("\\\"", "\\\\\"")
								.replaceAll("\\$", "\\\\\\$") + "\"");
		return result;
	}

	public static String getTimeStemp(long paytime) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(paytime);

		System.out.println("北京时间�?" + cal.getTime());

		cal.add(Calendar.HOUR, -8);
		System.out.println("格林威治时间�?" + cal.getTime());
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		String time = getFormatTime(month) + getFormatTime(day)
				+ getFormatTime(hour) + getFormatTime(minute);
		System.out.println(time);
		return time;
	}

	public static String getFormatTime(int time) {
		if (time < 10) {
			return String.valueOf(time);
		}
		return String.valueOf(aaZ[time - 10]);
	}

	public static String post_egsb_accountManage_SDKClientVoucher(
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String contentId, String channelId) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&contentId=" + contentId, "Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/accountManage/SDKClientVoucher");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("contentId=" + contentId + "&channelId=" + channelId);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nSDKClientVoucher:\nresult:\n" + result);

		return result;
	}

	public static String post_egsb_thirdPay_queryConsumeInfo(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&contentId=" + contentId, "Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/thirdPay/queryConsumeInfo");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("channelId=" + channelId + "&contentId=" + contentId);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nqueryConsumeInfo:\nresult:\n" + result);
		return result;
	}

	public static String post_normandie_CheckLoginPolicy(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String cpId) {
		String result = "";
		PrintWriter out = null;
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+chid=" + chid
				+ "&cid=" + contentId + "&cpId=" + cpId + "&ms=",
				"Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://wap.cmgame.com:7758/normandie/CheckLoginPolicy");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("cid=" + contentId + "&cpId=" + cpId + "&chid="
					+ channelId + "&ms=");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nCheckLoginPolicy:\nresult:\n" + result);
		return result;
	}

	public static String post_normandie_querySafechargeRule(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String gameType) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://wap.cmgame.com:7758/normandie/querySafechargeRule");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQ><cId>"
					+ contentId + "</cId><chId>" + channelId
					+ "</chId><uniqId></uniqId><gameType>" + gameType
					+ "</gameType></REQ>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nquerySafechargeRule:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_gshare_switches(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String model) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId + "&tel=&ua=" + model,
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL("http://drm.cmgame.com/egsb/gshare/switches");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("contentId=" + contentId + "&channelId=" + channelId
					+ "&tel=&ua=" + URLEncoder.encode(model) + "&gameType=1");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nswitches:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_message_queryPushMessages(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId) {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&clientType=2&contentId=" + contentId + "&ub=&uid=",
				"Signature-OF-Secret&");
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/message/queryPushMessages");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("uid=&ub=&clientType=2&channelId=" + channelId
					+ "&contentId=" + contentId);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nqueryPushMessages:\nresult:\n" + result);
		return result;
	}

	public static String get_egsb_otherPay_querySMSLimitMoney(
			String sdkversion, String imei, String imsi, String sdkSessionId) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/otherPay/querySMSLimitMoney");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Game2ExecLinstenerThreadDao.logBuff.append("\nquerySMSLimitMoney:\nresult:\n" + result);
		return result;
	}

	public static String post_normandie_QueryConfigPolicy(String sdkversion,
			String imei, String imsi, String sdkSessionId, String contentId,
			String channelId, String gameType) {
		String result = "";
		PrintWriter out = null;
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://wap.cmgame.com:7758/normandie/QueryConfigPolicy");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version=\"1.0\" encoding=\"utf-8\"?><REQ><cId>"
					+ contentId + "</cId><chId>" + channelId
					+ "</chId><uniqId></uniqId><gameType>" + gameType
					+ "</gameType></REQ>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nQueryConfigPolicy:\nresult:\n" + result);
		return result;
	}

	public static String get_egsb_authentication_getUserToken(
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String rand4num) {
		String result = "";
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+Encrypt-IMSI=" + imsi
						+ "&Random-Code=" + rand4num, "Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/authentication/getUserToken?Random-Code="
							+ rand4num + "&Encrypt-IMSI=" + imsi);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Game2ExecLinstenerThreadDao.logBuff.append("\ngetUserToken:\nresult:\n" + result);
		return result;
	}

	public static String post_access_login(String sdkversion, String imei,
			String imsi, String sdkSessionId, String contentId,
			String channelId, String userToken) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&contentId=" + contentId
				+ "&gameId=&loginType=2&needTel=1&userToken=" + userToken,
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL("http://drm.cmgame.com/egsb/access/login");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("loginType=2&gameId=&contentId=" + contentId
					+ "&channelId=" + channelId + "&userToken=" + userToken
					+ "&needTel=1&tokenType=0");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nlogin:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_otherPay_querySMSInterceptorConf(
			String sdkversion, String imei, String imsi, String sdkSessionId) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+",
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/message/queryPushMessages");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nquerySMSInterceptorConf:\nresult:\n" + result);
		return result;
	}

	public static String get_egsb_game_gamePlayerAuth(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid, String ub) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+ub=" + ub
				+ "&uid=" + uid, "Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/game/gamePlayerAuth?uid=" + uid
							+ "&ub=" + ub);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Game2ExecLinstenerThreadDao.logBuff.append("\ngamePlayerAuth:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_market_queryAnnouncement(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String channelId, String contentId, String type) {
		String result = "";
		PrintWriter out = null;
		// +Signature-OF-Secret+POST+channelId=12064000&contentId=622416051249&type=1&ub=bf2b95644e81891ead60a0d9d2e0a360&uid=208380850
		// +Signature-OF-Secret+POST+channelId=12064000&contentId=622416051249&type=2&ub=bf2b95644e81891ead60a0d9d2e0a360&uid=208380850
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&contentId=" + contentId + "&type=" + type + "&ub="
				+ ub + "&uid=" + uid, "Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/market/queryAnnouncement");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			// uid=208380850&ub=bf2b95644e81891ead60a0d9d2e0a360&channelId=12064000&contentId=622416051249&type=1&versionNum=3
			out.print("uid=" + uid + "&ub=" + ub + "&channelId=" + channelId
					+ "&contentId=" + contentId + "&type=" + type
					+ "&versionNum=3");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nqueryAnnouncement:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_market_queryCardMarket(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String channelId, String contentId) {
		String result = "";
		PrintWriter out = null;
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&contentId=" + contentId + "&ub=" + ub + "&uid="
				+ uid, "Signature-OF-Secret&");
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/market/queryCardMarket");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("uid=" + uid + "&ub=" + ub + "&channelId=" + channelId
					+ "&contentId=" + contentId);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nqueryCardMarket:\nresult:\n" + result);
		return result;
	}

	public static String get_egsb_recommendGame_gameList(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String contentId, String channelId) {
		String result = "";
		BufferedReader in = null;
		// HTC_Desire 这个代码里是固定�?
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&clientPlatform=03&ua=HTC_Desire",
				"Signature-OF-Secret&");
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/recommendGame/gameList?ua=HTC_Desire&clientPlatform=03&channelId="
							+ channelId
							+ "&uid="
							+ uid
							+ "&ub="
							+ ub
							+ "&contentId=" + contentId);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Game2ExecLinstenerThreadDao.logBuff.append("\ngameList:\nresult:\n" + result);
		return result;
	}

	public static String get_egsb_game_subscribeAuth(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String contentId, String channelId) {
		String result = "";
		BufferedReader in = null;
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+authType=1&channelId=" + chid
						+ "&contentId=" + contentId + "&gameId=0&ub=" + ub
						+ "&uid=" + uid, "Signature-OF-Secret&");
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/game/subscribeAuth?uid=" + uid
							+ "&ub=" + ub + "&authType=1&contentId="
							+ contentId + "&channelId=" + channelId
							+ "&gameId=0");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? GET 请求出现异常�?" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Game2ExecLinstenerThreadDao.logBuff.append("\nsubscribeAuth:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_securityCounting_userTransLogin(
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String uid, String ub, String channelId, String contentId,
			String cpId, String model) {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&contentId=" + contentId + "&cpId=" + cpId
				+ "&cpparam=&ua=" + model + "&ub=" + ub + "&uid=" + uid,
				"Signature-OF-Secret&");
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/securityCounting/userTransLogin");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("uid=" + uid + "&ub=" + ub + "&contentId=" + contentId
					+ "&cpId=" + cpId + "&channelId=" + channelId
					+ "&cpparam=&ua=" + URLEncoder.encode(model)
					+ "&needNotifyCP=1");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nuserTransLogin:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_discount_getLowestDiscountInfo(
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String uid, String ub, String channelId, String contentId,
			String cpId, String consumeCode) {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ chid + "&consumeCode=" + consumeCode + "&contentId="
				+ contentId + "&packageId=&serviceId=&spId=" + cpId + "&ub="
				+ ub + "&uid=" + uid, "Signature-OF-Secret&");
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/discount/getLowestDiscountInfo");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("uid=" + uid + "&ub=" + ub + "&contentId=" + contentId
					+ "&spId=" + cpId + "&channelId=" + channelId
					+ "&consumeCode=" + consumeCode
					+ "&serviceId=&packageId=&adviceType=2");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\ngetLowestDiscountInfo:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_props_queryPayment(String sdkversion,
			String imei, String imsi, String sdkSessionId, String uid,
			String ub, String contentId, String consumeCode) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+contentId="
				+ contentId + "&packageId=&propsId=" + consumeCode + "&ub="
				+ ub + "&uid=" + uid, "Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/props/queryPayment");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("uid=" + uid + "&ub=" + ub + "&contentId=" + contentId
					+ "&propsId=" + consumeCode + "&packageId=");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nqueryPayment:\nresult:\n" + result);
		return result;
	}

	public static String post_portalone_GetThirdPartySession(String sdkversion,
			String imei, String imsi, String sdkSessionId, String req,
			String cpId, String contentId, String channelId, String consumeCode) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+chargeid="
				+ consumeCode + "&chid=" + chid + "&cid=" + contentId
				+ "&cpId=" + cpId + "&req=" + req + "&uid=" + getIMEIUID(imei),
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://wap.cmgame.com/portalone/GetThirdPartySession");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("req=" + URLEncoder.encode(req) + "&uid="
					+ getIMEIUID(imei) + "&cpId=" + cpId + "&cid=" + contentId
					+ "&chid=" + channelId + "&chargeid=" + consumeCode);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nGetThirdPartySession:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_verification_checkSdkUpdate(
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String cpId, String contentId, String channelId, String model,
			String type, String versionCode) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+type=" + type
				+ "&versionCode=" + versionCode, "Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/verification/checkSdkUpdate");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("versionCode=" + versionCode + "&type=" + type + "&cpId="
					+ cpId + "&contentId=" + contentId + "&channelId="
					+ channelId + "&model=" + URLEncoder.encode(model)
					+ "&sdkSessionId=" + sdkSessionId + "&networkType=4&from=0");
			out.flush();

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
//		Game2ExecLinstenerThreadDao.logBuff.append("\ncheckSdkUpdate:\nresult:\n" + result);
		return result;
	}

	public static String post_egsb_verification_getUpdateUrl(String sdkversion,
			String imei, String imsi, String sdkSessionId, String cpId,
			String contentId, String channelId, String model, String packageName) {
		String result = "";
		String Signature = getHmacSHA1("+Signature-OF-Secret+POST+channelId="
				+ channelId + "&clientType=2&contentId=" + contentId
				+ "&packageName=" + packageName + "&ua=" + model
				+ "&versionCode=1", "Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/verification/getUpdateUrl");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("contentId=" + contentId + "&ua="
					+ URLEncoder.encode(model) + "&versionCode=1&channelId="
					+ channelId + "&packageName=" + packageName
					+ "&clientType=2");
			out.flush();

			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\ngetUpdateUrl:\nresult:\n" + result);
		return result;
	}

	public static String post_behaviorLogging_eventLogging_accept(
			String sdkversion, String imei, String imsi, String sdkSessionId,
			String data, Map<String, String> Cookie) {
		String result = "";
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+data=" + data,
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://sdklog.cmgame.com/behaviorLogging/eventLogging/accept?");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			if (Cookie.containsKey("Cookie")) {
				conn.setRequestProperty("Cookie", (String) Cookie.get("Cookie"));
				conn.setRequestProperty("Cookie2", "$Version=1");
			}
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("data=" + URLEncoder.encode(data));
			out.flush();
			if (conn.getHeaderFields().containsKey("Set-Cookie")) {
				String set_cookie = conn.getHeaderField("Set-Cookie");
				Cookie.put("Cookie",
						set_cookie.substring(0, set_cookie.indexOf(';')));
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\neventLogging:\nresult:\n" + result);
		return result;
	}

	public static String generate_portalone_GetThirdPartySession_req(
			String gametype, String rules, String sdkversion, String contentid,
			String chid, String pkgid, String consumeCode, String imsi,
			String imei, String sdkSessionId, String appid, String device_cid,
			String soVersion) {
		String result = "";
		result = gametype + rules + sdkversion + contentid + chid + pkgid
				+ consumeCode + imsi.substring(3);
		result = "02" + firstEncrypt(result) + "0000000000000000"
				+ getIMEIUID(imei) + "@@000000000" + sdkSessionId + "4";
		System.out.println(result);

		String hexStr_raw = "a" + getTimeStamp() + result;
		// String hexStr_raw = "a"+ "20160106103318" +result;
		System.out.println(hexStr_raw);
		String hexStr = byte2hexString(encodeSMS(hexStr_raw).getBytes());
		System.out.println(hexStr);
		String tmp = appid + imei + imsi + encodeCID(device_cid) + "0"
				+ soVersion + "999" + "000000000000000000000000000000";
		System.out.println(tmp);

		result = hexStr_raw + tmp + generateSingnature(tmp + hexStr);
		System.out.println(result);
		result = encodeSMS(result);
		System.out.println(result);
		result = encodeOrderSMS(result);
		System.out.println(result);
		return result;
	}

	public static String post_egsb_codes_queryExposureURL(String sdkversion,
			String imei, String imsi, String sdkSessionId) {
		String result = "";
		String X_OF_Signature = getHmacSHA1("+X-OF-Signature+POST+",
				"X-OF-Signature&");
		String Signature = getHmacSHA1(
				"+Signature-OF-Secret+POST+X-OF-Signature=" + X_OF_Signature
						+ "=&apiVersion=2.2&imei=" + imei + "&imsi=" + imsi
						+ "&platform=03&responseType=xml",
				"Signature-OF-Secret&");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://drm.cmgame.com/egsb/codes/queryExposureURL");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("platform=03&apiVersion=2.2&imei=" + imei + "&imsi="
					+ imsi + "&X-OF-Signature="
					+ URLEncoder.encode(X_OF_Signature) + "&responseType=xml");
			out.flush();

			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? POST 请求出现异常�?" + e);
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
//		Game2ExecLinstenerThreadDao.logBuff.append("\nqueryExposureURL:\nresult:\n" + result);
		return result;
	}

	public static String get_checkCode(String url, String sdkversion,
			String imei, String imsi, String sdkSessionId, String ip,
			String macAddr, String uuid) {
		String result = "";
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
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url + "?mo=0&ni=&ns=" + ip + "&m1=" + m1
					+ "&m2=&m3=&m1a=" + m1a + "&m2a=&m9=&m9b=" + m9b
					+ "&m1b=&m1c=&m9c=&nx=" + uuid);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("X-OF-Signature", Signature);
			conn.setRequestProperty("X-OF-Key", "Signature-OF-RSAUtils");
			conn.setRequestProperty("OS_TYPE", "1");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Response-Type", "xml");
			conn.setRequestProperty("platform", "Android");
			conn.setRequestProperty("apiVersion", "2.2");
			conn.setRequestProperty("SDKVersion", sdkversion);
			conn.setRequestProperty("imei", imei);
			conn.setRequestProperty("imsi", imsi);
			conn.setRequestProperty("signer", Signature);
			conn.setRequestProperty("sdkSessionId", sdkSessionId);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发�?? GET 请求出现异常�?" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Game2ExecLinstenerThreadDao.logBuff.append("\ncheckCode:\nresult:\n" + result);
		return result;
	}

	public static String getsessionID(String str) {
		String result = str.substring(str.indexOf("sessionID=")
				+ "sessionID=".length());
		System.out.println("sessionID:\t" + result);
		return result;
	}

	// fix
	public static String encodeCID(String device_cid) {
		return generateSingnature(device_cid + "\n");
	}

	public static String getTimeStamp() {
		String result = "";
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		result = dateFormat.format(now);
		return result;
	}

	public static String getHmacSHA1(String data, String key) {
		try {
			SecretKeySpec secretkey = new SecretKeySpec(key.getBytes("UTF-8"),
					"HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(((Key) secretkey));
			return new BASE64Encoder().encode(
					mac.doFinal(data.toString().getBytes("UTF-8"))).replace(
					"\r\n", "");
		} catch (Exception e2) {
		}
		return "";
	}

	public static String fixStr(String str, int maxLen) {
		int v0 = 0;
		if (maxLen > 0 || !isEmpty(str)) {
			if (maxLen > 0 && isEmpty(str)) {
				str = "";
				while (true) {
					if (v0 < maxLen) {
						str = String.valueOf(str) + "0";
						++v0;
						continue;
					} else {
						return str;
					}
				}
			}
			if (str.length() <= maxLen) {
				return str;
			}

			if (str.length() <= maxLen) {
				return str;
			}

			if (maxLen <= 3) {
				return str;
			}
			str = str.substring(0, maxLen);
		}

		return str;
	}

	public static String getIMEIUID(String imei) {
		String result = convertLongTo62Str(Long.valueOf(imei), 9);

		System.out.println("encyptimei = " + result);
		if (result.length() > 9) {
			result = result.substring(0, 9);
		}
		System.out.println("IMEIUID = " + result);
		return result;
	}

	public static String getBLD(String data) {
		String result = "";
		// String hexStrKey =
		// "30820275020100300D06092A864886F70D01010105000482025F3082025B02010002818100C0FC376D5B97EEC7A34E23FF7ADB3852BCE588C8BD1185B60ABFBB2C7369E17C28C82CE393E23199B8E6518C742BFF56C51DDD5A1DA5275D4A13414DD44BC1D50736255CC260FDC904A813832C59858B384F3C17FB477FE861AFE47B25088595084664072DFD9C016A840FCC9CDB7882B340EFFA17B82BFDF035164316E1855B0203010001028180082D67C7D97EB99E79FC00A87DB33652C33052B876D27C40F779A25BC2D434BAC71B9C53545BDC5030368A3412641EE0B55F8B969AF4F99309658179E3CA05FF86FEBAC2CB0BECADC0EA78C1DB1EB40F60601DFB74A350591C0EE3A556A23E19D67CB7048C6BF53CCF4FE000839B501E82CE23E45FC953F6049FF4777D294241024100EA56917E9A131B01E9710439E83D84CB8CCDABF1C468AFB49927B84F7624761BFC7474490417E4BB8F3E780FF4A6FA946AF89443BFBE97ADFE5D6DD94C32487B024100D2D310160A2F7D672DA1A8199E07FB6502DA4E17684D9F366B5509654605A3FA0D56159B5E7D1DCE0E76CA7ED621287DA364F6B8AD8D01FB439D1C86C5BAD0A102406616B6A5E7EBA0DD715CAA11AC2A78DAD0899D79E32E1435E26F1A6D8BB390BCDA7BC55935EE4ED8A32BFCD43EAA2C0A529BDEC3B11A102C5DDF4806DD9A1E5702404FEED65A84E21C99D22348A8EDD1F8EF0375E1C5DE360FF7821A6BC58A16F96505496E47CA3B85E16A7A7FAC3763BB0667BD100E553EF15163015E9F7AB8AA0102402F3072736FB24428D26EB0D3F3F04475F1F2C33DBDB02CF4091D032418308AD5B5B39E63FCCC39CE9035B238061581DD83316E2C55BD810E6ECC39A3B509417B";
		// //权德�?
		// byte[] encodedKey = hexString2Bytes(hexStrKey);
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

	public static String encodeOrderSMS(String sms) {
		String result = "";
		String table = "k$w4Nb)_-AMYy&K#:[pVHj23WXvSOd5P1nU?hEm}/^.oBC%\\t0ez6r=cs~lIJ7qa`(>|Gf'<;gRiL+9QT]!@,*xu FD{Z8\"";
		for (int i = 0; i < sms.length(); i++) {
			result += table.charAt(((int) sms.charAt(i)) - 32);
		}
		return result;
	}

	public static String decodeOrderSMS(String sms) {
		String result = "";
		String table = "k$w4Nb)_-AMYy&K#:[pVHj23WXvSOd5P1nU?hEm}/^.oBC%\\t0ez6r=cs~lIJ7qa`(>|Gf'<;gRiL+9QT]!@,*xu FD{Z8\"";
		for (int i = 0; i < sms.length(); i++) {
			result += (char) (table.indexOf(((int) sms.charAt(i))) + 32);
		}
		return result;
	}

	public static String encodeSMS(String sms) {
		System.out.println(sms);
		String key = "xcJno2cBcwQDoOC5GiAHYjmZaZ8RyZRW"; // 咪咕游戏
		StringBuilder stringBuilderKey = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			stringBuilderKey.append(key);
		}
		String tempKeyStr = stringBuilderKey.toString();
		byte[] keyTable = new byte[1024];
		for (int i = 0; i < 1024; i = i + 4) {
			keyTable[i] = (byte) (i / 4);
		}
		int byte_1, byte_2, result, keep = 0, temp;
		for (int i = 0; i < 255; i++) {
			byte_1 = tempKeyStr.charAt(i);
			byte_2 = keyTable[i * 4];
			result = (byte_1 + keep + byte_2) & 0xff;
			keep = result;
			keyTable[4 * i] = keyTable[4 * result];
			keyTable[4 * result] = (byte) byte_2;
		}
		int m = 0;
		byte[] output = new byte[sms.length()];
		for (int i = 0; i < sms.length(); i++) {
			int n = ((i + 1) & 0xFF) * 4;
			byte_1 = keyTable[n];
			m = (m + byte_1) & 0xff;
			keyTable[n] = keyTable[m * 4];
			keyTable[m * 4] = (byte) byte_1;
			temp = (((byte_1 & 0xff) + keyTable[n]) & 0xff) * 4;

			int byteN = (sms.charAt(i) ^ keyTable[temp]) & 0xff;
			if (((byteN - 32) & 0xFF) > 0x5E || ((byteN - 96) & 0xFF) <= 0) {
				output[i] = (byte) (sms.charAt(i));
			} else {
				output[i] = (byte) (byteN);
			}
		}
		String r = new String(output);
		System.out.println(r);
		return r;

	}

	// public static String encodeSMS(String sms) {
	// // String key = "aZ8RyZRWxcJno2cBcwQDAHYjmZoOC5Gi";
	// String key = "xcJno2cBcwQDoOC5GiAHYjmZaZ8RyZRW";
	// StringBuilder stringBuilderKey = new StringBuilder();
	// for (int i = 0; i < 8; i++) {
	// stringBuilderKey.append(key);
	// }
	// String tempKeyStr = stringBuilderKey.toString();
	// byte[] keyTable = new byte[1024];
	// for (int i = 0; i < 1024; i = i + 4) {
	// keyTable[i] = (byte) (i / 4);
	// }
	// int byte_1, byte_2, result, keep = 0, temp;
	// for (int i = 0; i < 256; i++) {
	// byte_1 = tempKeyStr.charAt(i);
	// byte_2 = keyTable[i * 4];
	// result = (byte_1 + keep + byte_2) & 0xff;
	// keep = result;
	// keyTable[4 * i] = keyTable[4 * result];
	// keyTable[4 * result] = (byte) byte_2;
	// }
	// int m = 0;
	// byte[] output = new byte[sms.length()];
	// for (int i = 0; i < sms.length(); i++) {
	// int n = (i + 1) * 4;
	// byte_1 = keyTable[n];
	// m = (m + byte_1) & 0xff;
	// keyTable[n] = keyTable[m * 4];
	// keyTable[m * 4] = (byte) byte_1;
	// temp = (((byte_1 & 0xff) + keyTable[n]) & 0xff) * 4;
	//
	// int byteN = (sms.charAt(i) ^ keyTable[temp]) & 0xff;
	// if (((byteN - 32) & 0xFF) > 0x5E || ((byteN - 96) & 0xFF) <= 0) {
	// output[i] = (byte) (sms.charAt(i));
	// } else {
	// output[i] = (byte) (byteN);
	// }
	// }
	// return new String(output);
	// }

	public static String firstEncrypt(String data) {
		System.out.println(data);
		Long[] rawData = new Long[4];
		StringBuffer result = new StringBuffer();
		int j = 0;
		for (int i = 0; i < 4; i++) {
			if (i == 3) {
				j = data.length();
			} else {
				j = j + 18;
			}
			rawData[i] = Long.valueOf(data.substring(i * 18, j));
			String str1 = i == 3 ? convertLongTo62Str(rawData[i], 6)
					: convertLongTo62Str(rawData[i], 11);
			result.append(str1);
		}
		return result.toString();

	}

	public static String convertLongTo62Str(long data, int len) {
		long l1 = data;
		long l2 = 0;
		String result = "";
		while (l1 > 0L) {
			data = l1;
			l1 = data / 62L;
			l2 = data % 62;
			result = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
					.charAt((int) l2) + result;
		}
		while (result.length() < len)
			result = "0" + result;
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

	private static int V(int arg2) {
		int v0;
		for (v0 = 0; v0 < abd.length; ++v0) {
			if (arg2 == abd[v0]) {
				return v0;
			}
		}

		return v0;
	}

	private static int a(char arg3) {
		int v1 = aaZ.length;
		int v0;
		for (v0 = 0; v0 < v1; ++v0) {
			if (aaZ[v0] == arg3) {
				return v0;
			}
		}

		return v0;
	}

	private static void a(InputStream arg3, OutputStream arg4)
			throws IOException {
		byte[] v0 = new byte[1024];
		while (true) {
			int v1 = arg3.read(v0);
			if (v1 == -1) {
				return;
			}

			arg4.write(v0, 0, v1);
		}
	}

	private static boolean b(char arg1) {
		if (arg1 < 48 || arg1 > 57) {
			if (arg1 >= 65 && arg1 <= 90) {
				return false;
			}

			if (arg1 >= 97 && arg1 <= 122) {
				return false;
			}
			return true;
		} else {
			return false;
		}

	}

	public static String encodeLoginSMS(String arg6) {
		System.out.println(arg6);

		String v0_1;
		int v0 = 0;
		if (isEmpty(arg6)) {
			v0_1 = null;
		} else {
			int v1 = arg6.length() % abe;
			if (v1 != 0) {
				char[] v2 = new char[abe - v1];
				int v3 = v2.length;
				for (v1 = 0; v1 < v3; ++v1) {
					v2[v1] = ' ';
				}

				arg6 = String.valueOf(arg6) + new String(v2);
			}

			int v2_1 = arg6.length();
			char[] v3_1 = new char[v2_1];
			for (v1 = 0; v1 < v2_1; ++v1) {
				v3_1[v1] = arg6.charAt(abd[v1 % abe] + abe * v0);
				if (v1 != 0 && (v1 + 1) % abe == 0) {
					++v0;
				}
			}

			v0_1 = bW(new String(v3_1));
		}

		return v0_1;
	}

	public static String decodeLoginSMS(String arg9) {
		int v0 = 0;
		String v2 = bU(arg9);
		int v3 = v2.length();
		char[] v4 = new char[v3];
		int v1;
		for (v1 = 0; v1 < v3; ++v1) {
			int v5 = V(v1 % abe) + abe * v0;
			if (v5 >= v2.length()) {
				v4[v1] = ' ';
				System.out.println("index out of range, " + v5 + ", len="
						+ v2.length());
			} else {
				v4[v1] = v2.charAt(v5);
			}

			if (v1 != 0 && (v1 + 1) % abe == 0) {
				++v0;
			}
		}

		return new String(v4);
	}

	private static String bU(String arg5) {
		String v0;
		if (isEmpty(arg5)) {
			v0 = null;
		} else {
			v0 = "";
			int v1;
			for (v1 = 0; v1 < arg5.length(); ++v1) {
				char v2 = arg5.charAt(v1);
				if (b(v2)) {
					v0 = String.valueOf(v0) + v2;
				} else {
					v2 = ((char) (v2 ^ 8));
					if (b(v2)) {
						v2 = ((char) (v2 ^ 8));
					}

					v0 = String.valueOf(v0) + v2;
				}
			}

			v0 = new String(new StringBuffer(v0).reverse());
		}

		return v0;
	}

	private static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	private static void bV(String arg6) {
		int v1 = 0;
		int[] v3 = new int[aaZ.length];
		int v2 = arg6.length();
		abe = v2;
		int v0;
		for (v0 = 0; v0 < v2; ++v0) {
			v3[a(arg6.charAt(v0))] = v0;
		}

		abd = new int[v2];
		v0 = 1;
		while (v1 < aaZ.length) {
			if (v3[v1] != 0) {
				abd[v3[v1]] = v0;
				++v0;
			}

			++v1;
		}
	}

	private static String bW(String arg5) {
		String v1;
		if (isEmpty(arg5)) {
			v1 = null;
		} else {
			v1 = new String();
			StringBuffer v3 = new StringBuffer(arg5).reverse();
			int v0;
			for (v0 = 0; v0 < v3.length(); ++v0) {
				char v2 = v3.charAt(v0);
				if (b(v2)) {
					v1 = String.valueOf(v1) + v2;
				} else {
					v2 = ((char) (v2 ^ 8));
					if (b(v2)) {
						v2 = ((char) (v2 ^ 8));
					}

					v1 = String.valueOf(v1) + v2;
				}
			}
		}

		return v1;
	}

	public static byte[] bX(String arg9) throws UnsupportedEncodingException {
		int v6;
		int v5;
		int v1;
		int v8 = 61;
		int v7 = -1;
		int v0 = arg9.length() % 4;
		if (v0 == 2) {
			arg9 = String.valueOf(arg9) + "==";
		} else if (v0 == 3) {
			arg9 = String.valueOf(arg9) + "=";
		}

		StringBuffer v2 = new StringBuffer();
		byte[] v3 = arg9.getBytes("US-ASCII");
		int v4 = v3.length;
		v0 = 0;
		while (true) {
			if (v0 < v4) {
				while (true) {
					v1 = v0 + 1;
					v5 = aba[v3[v0]];
					if (v1 < v4 && v5 == v7) {
						v0 = v1;
						continue;
					}

					break;
				}

				if (v5 == v7) {
					return v2.toString().getBytes("iso8859-1");
				}

				while (true) {
					v0 = v1 + 1;
					v6 = aba[v3[v1]];
					if (v0 < v4 && v6 == v7) {
						v1 = v0;
						continue;
					}

					break;
				}

				if (v6 == v7) {
					return v2.toString().getBytes("iso8859-1");
				}

				v2.append(((char) (v5 << 2 | (v6 & 48) >>> 4)));
				while (true) {
					v1 = v0 + 1;
					v0 = v3[v0];
					if (v0 == v8) {
						return v2.toString().getBytes("iso8859-1");
					}

					v5 = aba[v0];
					if (v1 < v4 && v5 == v7) {
						v0 = v1;
						continue;
					}

					break;
				}

				if (v5 == v7) {
					return v2.toString().getBytes("iso8859-1");
				}

				v2.append(((char) ((v6 & 15) << 4 | (v5 & 60) >>> 2)));

				while (true) {
					v0 = v1 + 1;
					v1 = v3[v1];
					if (v1 == v8) {
						return v2.toString().getBytes("iso8859-1");
					}

					v1 = aba[v1];
					if (v0 < v4 && v1 == v7) {
						v1 = v0;
						continue;
					}

					break;
				}

				if (v1 == v7) {
					return v2.toString().getBytes("iso8859-1");
				}

				v2.append(((char) (v1 | (v5 & 3) << 6)));
				continue;
			} else {
				return v2.toString().getBytes("iso8859-1");
			}
		}

	}

	public static String encode(byte[] arg8) {
		StringBuffer v1 = new StringBuffer();
		int v2 = arg8.length;
		int v0 = 0;
		while (v0 < v2) {
			int v3 = v0 + 1;
			int v4 = arg8[v0] & 255;
			if (v3 == v2) {
				v1.append(aaZ[v4 >>> 2]);
				v1.append(aaZ[(v4 & 3) << 4]);
				v1.append("==");
			} else {
				int v5 = v3 + 1;
				v3 = arg8[v3] & 255;
				if (v5 == v2) {
					v1.append(aaZ[v4 >>> 2]);
					v1.append(aaZ[(v4 & 3) << 4 | (v3 & 240) >>> 4]);
					v1.append(aaZ[(v3 & 15) << 2]);
					v1.append("=");
				} else {
					v0 = v5 + 1;
					v5 = arg8[v5] & 255;
					v1.append(aaZ[v4 >>> 2]);
					v1.append(aaZ[(v4 & 3) << 4 | (v3 & 240) >>> 4]);
					v1.append(aaZ[(v3 & 15) << 2 | (v5 & 192) >>> 6]);
					v1.append(aaZ[v5 & 63]);
					continue;
				}
			}

			break;
		}

		return v1.toString();
	}

	public static String generateSingnature(String str) {
		System.out.println(str);
		byte[] k1 = new byte[Key1.length];
		byte[] k2 = new byte[Key2.length];
		System.arraycopy(Key1, 0, k1, 0, Key1.length);
		System.arraycopy(Key2, 0, k2, 0, Key2.length);

		getSingnature1(str.getBytes(), str.length(), k1);
		byte[] r1 = getSingnature2(k1);

		getSingnature1(r1, 20, k2);
		byte[] r2 = getSingnature2(k2);

		String result = Base64.encode(r2).replaceAll("\r\n", "");
		return result;
	}

	public static void getSingnature1(byte[] data, int datalen, byte[] key) {
		byte[] v3;
		int v4;
		int v5;
		int v6;
		int v7;
		boolean v8;
		int v9;
		int v10;
		int v11;
		byte[] v12;
		int v13;
		byte[] v14;
		int v15;
		byte v16;
		byte[] v17;
		byte[] v18;
		byte[] v19;
		byte[] v20;
		byte[] v21;
		int v22;
		int v23;
		byte v24;
		byte[] v25;

		v3 = key;
		v4 = bytes2Int(key, 20);
		v5 = datalen;
		v6 = 8 * datalen;
		v7 = v6 + v4;
		v8 = v6 + v4 >= v6;
		int2bytes(v3, v6 + v4, 20);
		if (v6 + v4 < v6)
			v7 = bytes2Int(key, 24);
		v9 = v4 >> 3;
		if (!v8) {
			int2bytes(v3, v7 + 1, 24);
		}
		v10 = v9 & 0x3F;
		v11 = 64 - v10;
		int t = bytes2Int(key, 24) + (v5 >> 29);
		int2bytes(v3, t, 24);
		v12 = data;
		if (v5 >= 64 - v10) {
			v14 = v3;
			v15 = 0;
			while (true) {
				v17 = v14;
				if (v15 >= v11)
					break;
				v16 = v12[v15];
				v17[28 + v15 + v10] = v16;
				v15++;
			}
			v13 = v11;
			getSingnature3(v3, 28, v3);
			v18 = v12;
			int i = 0;
			while (true) {
				v19 = v18;
				if (v13 >= (v5 - 63))
					break;
				getSingnature3(v3, v11 + i, v19);
				v13 += 64;
				i += 64;

			}
			v10 = 0;
		} else {
			v13 = 0;
		}
		v20 = v12;
		v21 = v3;
		v22 = v5 - v13;
		v23 = 0;
		while (true) {
			v25 = v21;
			if (v23 >= v22)
				break;
			v24 = v20[v13 + v23];
			v25[v23 + 28 + v10] = v24;
			v23++;
		}
		return;

	}

	public static byte[] getSingnature3(byte[] result, int a2, byte[] a3) {
		byte[] v2;
		int v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37, v38, v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v49, v50, v51, v52, v53, v54, v55, v56, v57, v58, v59, v60, v61, v62, v63, v64, v65, v66, v67, v68, v69, v70, v71, v72, v73, v74, v75, v76, v77, v78, v79, v80, v81, v82, v83, v84, v85, v86, v87, v88, v89, v90, v91, v92, v93, v94, v95, v96, v97, v98, v99, v100, v101, v102, v103, v104, v105, v106, v107, v108, v109, v110, v111, v112, v113, v114, v115, v116, v117, v118, v119, v120, v121, v122, v123, v124, v125, v126, v127, v128, v129, v130, v131, v132, v133, v134, v135, v136, v137, v138, v139, v140, v141, v142, v143, v144, v145, v146, v147, v148, v149, v150, v151, v152, v153, v154, v155, v156, v157, v158, v159, v160, v161, v162, v163, v164, v165, v166, v167, v168, v169, v170, v171, v172, v173, v174, v175, v176, v177, v178, v179, v180, v181, v182, v183, v184, v185, v186, v187, v188, v189, v190, v191, v192, v193, v194, v195, v196, v197, v198, v199, v200, v201, v202, v203, v204, v205, v206, v207, v208, v209, v210, v211, v212, v213, v214, v215, v216, v217, v218, v219, v220, v221, v222, v223, v224, v225, v226, v227, v228, v229, v230, v231, v232, v233, v234, v235, v236, v237, v238, v239, v240, v241, v242, v243, v244, v245, v246, v247, v248, v249, v250, v251, v252, v253, v254, v255, v256, v257, v258, v259, v260, v261, v262, v263, v264, v265, v266, v267, v268, v269, v270, v271, v272, v273, v274, v275, v276, v277, v278, v279, v280, v281, v282, v283, v284, v285, v286, v287, v288, v289, v290, v291, v292, v293, v294, v295, v296, v297, v298, v299, v300, v301, v302, v303, v304, v305, v306, v307, v308, v309, v310, v311, v312, v313, v314, v315, v316, v317, v318, v319, v320, v321, v322, v323, v324, v325, v326, v327, v328, v329, v330, v331, v332, v333, v334, v335, v336, v337, v338, v339, v340, v341, v342, v343, v344, v345, v346, v347, v348, v349, v350, v351, v352, v353, v354, v355, v356, v357, v358, v359, v360, v361, v362, v363, v364, v365, v366, v367, v368, v369, v370, v371, v372, v373, v374, v375, v376, v377, v378, v379, v380, v381, v382, v383, v384, v385, v386, v387, v388, v389, v390, v391, v392, v393, v394, v395, v396, v397, v398, v399, v400, v401, v402, v403, v404, v405, v406, v407, v408, v409, v410, v411, v412, v413, v414, v415, v416, v417, v418, v419, v420, v421, v422, v423, v424, v425, v426, v427, v428, v429, v430, v431, v432, v433, v434, v435, v436, v437, v438, v439, v440, v441, v442, v443, v444, v445, v446, v447, v448, v449, v450, v451, v452, v453, v454, v455, v456, v457, v458, v459, v460, v461, v462, v463, v464, v465, v466, v467, v468, v469, v470, v471, v472, v473, v474, v475, v476, v477, v478, v479, v480, v481, v482, v483, v484, v485, v486, v487, v488, v489, v490, v491, v492, v493, v494, v495, v496, v497, v498, v499, v500, v501, v502, v503, v504, v505, v506, v507, v508, v509, v510, v511, v512, v513, v514, v515, v516, v517, v518, v519, v520, v521, v522, v523, v524, v525, v526, v527, v528, v529, v530, v531, v532, v533, v534, v535, v536, v537, v538, v539, v540, v541, v542, v543, v544, v545, v546, v547, v548, v549, v550, v551, v552, v553, v554, v555, v556, v557, v558, v559, v560, v561, v562, v563, v564, v565, v566, v567, v568, v569, v570, v571, v572, v573, v574, v575, v576, v577, v578, v579, v580, v581, v582, v583, v584, v585, v587, v588, v589, v590, v591, v593, v594, v595, v596, v597, v598, v599, v600, v601, v602, v603, v604, v605, v606, v607;
		byte v592[];

		v2 = a3;
		v3 = 0;
		v592 = new byte[64];
		int i = 0;
		do {
			v4 = (a3[v3 + a2] & 0x000000FF) << 24;
			int2bytes(v592, v4, v3);
			v5 = v4 | ((v2[1 + i + a2] & 0x000000FF) << 16);
			int2bytes(v592, v5, v3);
			v6 = v5 | ((v2[2 + i + a2] & 0x000000FF) << 8);
			int2bytes(v592, v6, v3);
			v7 = (v2[3 + i + a2] & 0x000000FF);
			i += 4;
			int2bytes(v592, v6 | v7, v3);
			v3 += 4;
		} while (v3 != 64);
		v593 = bytes2Int(v592, 4);
		v594 = bytes2Int(v592, 8);
		v595 = bytes2Int(v592, 12);
		v596 = bytes2Int(v592, 16);
		v597 = bytes2Int(v592, 20);
		v598 = bytes2Int(v592, 24);
		v599 = bytes2Int(v592, 28);
		v600 = bytes2Int(v592, 32);
		v601 = bytes2Int(v592, 36);
		v602 = bytes2Int(v592, 40);
		v603 = bytes2Int(v592, 44);
		v604 = bytes2Int(v592, 48);
		v605 = bytes2Int(v592, 52);
		v606 = bytes2Int(v592, 56);
		v607 = bytes2Int(v592, 60);
		v8 = bytes2Int(result, 8);
		v9 = bytes2Int(result, 12);
		v10 = bytes2Int(result, 4);
		v12 = ROR4(v10, 2);
		v11 = v12;
		v13 = v12 ^ v8;
		int temp_result = bytes2Int(result, 0);
		v15 = ROR4(temp_result, 2);
		v14 = v15;
		v16 = ROR4(temp_result, 27);
		v17 = bytes2Int(v592, 0) + 1518500249 + bytes2Int(result, 16) + v16
				+ ((v9 ^ v8) & v10 ^ v9);
		v19 = ROR4(v17, 27);
		v18 = v593 + 1518500249 + v9 + (v13 & bytes2Int(result, 0) ^ v8) + v19;
		v21 = ROR4(v17, 2);
		v20 = v21;
		v22 = v17 & (v11 ^ v14) ^ v11;
		v23 = v21 ^ v14;
		v24 = v594 + 1518500249 + v8 + v22;
		v26 = ROR4(v18, 2);
		v25 = v26;
		v28 = ROR4(v18, 27);
		v27 = v24 + v28;
		v29 = v595 + 1518500249 + v11 + (v23 & v18 ^ v14);
		v31 = ROR4(v27, 2);
		v30 = v31;
		v33 = ROR4(v27, 27);
		v32 = v29 + v33;

		v34 = v596 + 1518500249 + v14 + ((v25 ^ v20) & v27 ^ v20);
		v36 = ROR4(v32, 2);
		v35 = v36;
		v38 = ROR4(v32, 27);
		v37 = v34 + v38;
		v40 = ROR4(v37, 27);

		v39 = v597 + 1518500249 + v20 + ((v30 ^ v25) & v32 ^ v25) + v40;
		v42 = ROR4(v37, 2);
		v41 = v42;
		v43 = (v35 ^ v30) & v37 ^ v30;
		v44 = v42 ^ v35;
		v45 = v598 + 1518500249 + v25 + v43;
		v47 = ROR4(v39, 2);
		v46 = v47;
		v49 = ROR4(v39, 27);
		v48 = v45 + v49;
		v50 = (v46 ^ v41) & v48 ^ v41;
		v52 = ROR4(v48, 27);
		v51 = v599 + 1518500249 + v30 + (v44 & v39 ^ v35) + v52;
		v54 = ROR4(v48, 2);
		v53 = v54;
		v55 = v54 ^ v46;
		v56 = v600 + 1518500249 + v35 + v50;
		v58 = ROR4(v51, 2);
		v57 = v58;

		v60 = ROR4(v51, 27);
		v59 = v56 + v60;
		v61 = v601 + 1518500249 + v41 + (v55 & v51 ^ v46);
		v63 = ROR4(v59, 2);
		v62 = v63;
		v65 = ROR4(v59, 27);
		v64 = v61 + v65;
		v66 = v602 + 1518500249 + v46 + ((v57 ^ v53) & v59 ^ v53);
		v68 = ROR4(v64, 2);
		v67 = v68;
		v70 = ROR4(v64, 27);
		v69 = v66 + v70;
		v72 = ROR4(v69, 27);
		v71 = v603 + 1518500249 + v53 + ((v62 ^ v57) & v64 ^ v57) + v72;
		v74 = ROR4(v69, 2);
		v73 = v74;
		v75 = v74 ^ v67;
		v76 = v604 + 1518500249 + v57 + ((v67 ^ v62) & v69 ^ v62);
		v78 = ROR4(v71, 2);
		v77 = v78;
		v80 = ROR4(v71, 27);
		v79 = v76 + v80;
		v82 = ROR4(v79, 27);
		v81 = v605 + 1518500249 + v62 + (v75 & v71 ^ v67) + v82;
		v84 = ROR4(v79, 2);
		v83 = v84;
		v85 = v606 + 1518500249 + v67 + ((v77 ^ v73) & v79 ^ v73);
		v86 = (v84 ^ v77) & v81;
		v87 = ROR4(v594 ^ bytes2Int(v592, 0) ^ v600 ^ v605, 31);
		v88 = v87;
		v90 = ROR4(v81, 2);
		v89 = v90;
		v92 = ROR4(v81, 27);
		v91 = v85 + v92;
		v93 = ROR4(v595 ^ v593 ^ v601 ^ v606, 31);

		v94 = v93;
		v96 = ROR4(v91, 2);
		v95 = v96;
		v98 = ROR4(v91, 27);
		v97 = v607 + 1518500249 + v73 + (v86 ^ v77) + v98;
		v99 = ROR4(v596 ^ v594 ^ v602 ^ v607, 31);
		v100 = v99;
		v102 = ROR4(v97, 2);
		v101 = v102;
		v103 = (v95 ^ v89) & v97 ^ v89;
		v105 = ROR4(v97, 27);
		v104 = v88 + 1518500249 + v77 + ((v89 ^ v83) & v91 ^ v83) + v105;
		v107 = ROR4(v104, 2);
		v106 = v107;
		v108 = (v101 ^ v95) & v104;
		v110 = ROR4(v104, 27);
		v109 = v94 + 1518500249 + v83 + v103 + v110;
		v111 = ROR4(v597 ^ v595 ^ v603 ^ v88, 31);
		v591 = v111;
		v112 = v100 + 1518500249 + v89 + (v108 ^ v95);
		v113 = v111 + 1518500249 + v95;
		v114 = ROR4(v598 ^ v596 ^ v604 ^ v94, 31);
		v115 = v114;
		v117 = ROR4(v109, 27);
		v116 = v112 + v117;
		v119 = ROR4(v109, 2);
		v118 = v119;
		v120 = ROR4(v599 ^ v597 ^ v605 ^ v100, 31);
		v121 = v120;
		v123 = ROR4(v116, 27);
		v122 = v113 + ((v106 ^ v101) & v109 ^ v101) + v123;
		v125 = ROR4(v116, 2);
		v124 = v125;
		v126 = v125 ^ v118;
		v128 = ROR4(v122, 27);
		v127 = v115 + 1859775393 + v101 + (v118 ^ v106 ^ v116) + v128;
		v129 = v121 + 1859775393 + v106;
		v131 = ROR4(v122, 2);
		v130 = v131;
		v133 = ROR4(v600 ^ v598 ^ v606 ^ v591, 31);
		v132 = v133;
		v134 = ROR4(v601 ^ v599 ^ v607 ^ v115, 31);
		v135 = v132;
		v136 = v134;
		v137 = v134;
		v139 = ROR4(v127, 27);
		v138 = v129 + (v126 ^ v122) + v139;
		v141 = ROR4(v127, 2);
		v140 = v141;
		v142 = ROR4(v602 ^ v600 ^ v88 ^ v121, 31);
		v143 = v142;
		v145 = ROR4(v138, 27);
		v144 = v132 + 1859775393 + v118 + (v130 ^ v124 ^ v127) + v145;
		v147 = ROR4(v138, 2);
		v146 = v147;
		v148 = v137 + 1859775393 + v124 + (v140 ^ v130 ^ v138);
		v149 = v147 ^ v140;
		v151 = ROR4(v144, 27);
		v150 = v148 + v151;
		v152 = v143 + 1859775393 + v130;
		v154 = ROR4(v144, 2);
		v153 = v154;
		v155 = ROR4(v603 ^ v601 ^ v94 ^ v135, 31);
		v156 = v155;
		v157 = v155 + 1859775393;
		v158 = v152 + (v149 ^ v144);
		v160 = ROR4(v150, 2);
		v159 = v160;
		v162 = ROR4(v150, 27);
		v161 = v158 + v162;
		v163 = ROR4(v604 ^ v602 ^ v100 ^ v136, 31);
		v164 = v163;
		v165 = v163 + 1859775393;
		v166 = ROR4(v605 ^ v603 ^ v591 ^ v143, 31);
		v167 = v166;
		v168 = v166;
		v170 = ROR4(v161, 27);
		v169 = v157 + v140 + (v153 ^ v146 ^ v150) + v170;
		v171 = v165 + v146;
		v173 = ROR4(v161, 2);
		v172 = v173;
		v174 = v171 + (v159 ^ v153 ^ v161);
		v175 = v168 + 1859775393 + v153;
		v176 = v173 ^ v159;
		v177 = ROR4(v606 ^ v604 ^ v115 ^ v156, 31);
		v178 = v177;
		v179 = ROR4(v607 ^ v605 ^ v121 ^ v164, 31);
		v180 = v179;
		v182 = ROR4(v169, 2);
		v181 = v182;
		v184 = ROR4(v169, 27);
		v183 = v174 + v184;
		v186 = ROR4(v183, 27);
		v185 = v175 + (v176 ^ v169) + v186;
		v188 = ROR4(v183, 2);
		v187 = v188;
		v189 = ROR4(v88 ^ v606 ^ v135 ^ v167, 31);
		v190 = v189;
		v192 = ROR4(v185, 27);
		v191 = v178 + 1859775393 + v159 + (v181 ^ v172 ^ v183) + v192;
		v194 = ROR4(v185, 2);
		v193 = v194;
		v195 = v180 + 1859775393 + v172 + (v187 ^ v181 ^ v185);
		v196 = v100 ^ v88 ^ v143;
		v198 = ROR4(v94 ^ v607 ^ v136 ^ v178, 31);
		v197 = v198;
		v200 = ROR4(v191, 27);
		v199 = v195 + v200;
		v201 = v197;
		v202 = v190 + 1859775393 + v181;
		v204 = ROR4(v191, 2);
		v203 = v204;
		v205 = ROR4(v196 ^ v180, 31);
		v206 = v591 ^ v94;
		v207 = v205;
		v208 = v205;
		v210 = ROR4(v199, 27);
		v209 = v202 + (v193 ^ v187 ^ v191) + v210;
		v212 = ROR4(v199, 2);
		v211 = v212;
		v213 = v100;
		v214 = v197 + 1859775393 + v187 + (v203 ^ v193 ^ v199);
		v215 = v115 ^ v213 ^ v164;
		v216 = v208 + 1859775393 + v193 + (v212 ^ v203 ^ v209);
		v218 = ROR4(v206 ^ v156 ^ v190, 31);
		v217 = v218;
		v220 = ROR4(v209, 2);
		v219 = v220;
		v222 = ROR4(v209, 27);
		v221 = v214 + v222;
		v224 = ROR4(v214 + v222, 27);
		v223 = v216 + v224;
		v225 = v217 + 1859775393 + v203;
		v227 = ROR4(v221, 2);
		v226 = v227;
		v229 = ROR4(v215 ^ v201, 31);
		v228 = v229;
		v230 = ROR4(v121 ^ v591 ^ v167 ^ v207, 31);
		v231 = v228;
		v591 = v230;
		v233 = ROR4(v223, 27);
		v232 = v225 + (v219 ^ v211 ^ v221) + v233;
		v235 = ROR4(v223, 2);
		v234 = v235;
		v236 = v235 ^ v226 ^ v232;
		v237 = ROR4(v135 ^ v115 ^ v178 ^ v217, 31);
		v238 = v237;
		v240 = ROR4(v232, 2);
		v239 = v240;
		v242 = ROR4(v232, 27);
		v241 = v228 + 1859775393 + v211 + (v226 ^ v219 ^ v223) + v242;
		v243 = ROR4(v136 ^ v121 ^ v180 ^ v228, 31);
		v244 = v243;
		v246 = ROR4(v143 ^ v135 ^ v190 ^ v591, 31);
		v245 = v246;
		v248 = ROR4(v241, 2);
		v247 = v248;
		v250 = ROR4(v241, 27);
		v249 = v591 + 1859775393 + v219 + v236 + v250;
		v251 = v245;
		v253 = ROR4(v249, 27);
		v252 = v238 + 1859775393 + v226 + (v239 ^ v234 ^ v241) + v253;
		v255 = ROR4(v249, 2);
		v254 = v255;
		v256 = v255 ^ v247;
		v257 = ROR4(v156 ^ v136 ^ v201 ^ v238, 31);
		v258 = v257;
		v260 = ROR4(v252, 2);
		v259 = v260;
		v262 = ROR4(v252, 27);
		v261 = v244 + 1859775393 + v234 + (v247 ^ v239 ^ v249) + v262;
		v263 = ROR4(v164 ^ v143 ^ v207 ^ v244, 31);
		v264 = v263;
		v266 = ROR4(v261, 27);
		v265 = v245 + 1859775393 + v239 + (v256 ^ v252) + v266;
		v267 = v258 + 1859775393 + v247;
		v269 = ROR4(v261, 2);
		v268 = v269;
		v270 = v267 + (v259 ^ v254 ^ v261);
		v271 = v265 | v269;
		v273 = ROR4(v265, 27);
		v272 = v270 + v273;
		v275 = ROR4(v265, 2);
		v274 = v275;
		v276 = ROR4(v167 ^ v156 ^ v217 ^ v245, 31);
		v277 = v276;
		v278 = v276 - 1894007588 + v259 + ((v272 | v274) & v268 | v272 & v274);
		v279 = ROR4(v178 ^ v164 ^ v231 ^ v258, 31);
		v280 = v279;
		v282 = ROR4(v272, 27);
		v281 = v264 - 1894007588 + v254 + (v271 & v259 | v265 & v268) + v282;
		v284 = ROR4(v272, 2);
		v283 = v284;
		v285 = ROR4(v180 ^ v167 ^ v591 ^ v264, 31);
		v286 = v285;
		v288 = ROR4(v281, 27);
		v287 = v278 + v288;
		v290 = ROR4(v281, 2);
		v289 = v290;
		v291 = (v281 | v283) & v274 | v281 & v283;
		v292 = (v287 | v290) & v283 | v287 & v290;
		v293 = ROR4(v190 ^ v178 ^ v238 ^ v277, 31);
		v294 = v293;
		v296 = ROR4(v287, 27);
		v295 = v280 - 1894007588 + v268 + v291 + v296;
		v298 = ROR4(v287, 2);
		v297 = v298;
		v299 = v286 - 1894007588 + v274 + v292;
		v300 = v295 | v298;
		v302 = ROR4(v295, 27);
		v301 = v299 + v302;
		v304 = ROR4(v295, 2);
		v303 = v304;
		v305 = ROR4(v201 ^ v180 ^ v244 ^ v280, 31);
		v306 = v305;
		v307 = v294 - 1894007588 + v283 + (v300 & v289 | v295 & v297);
		v308 = v305;
		v310 = ROR4(v301, 27);
		v309 = v307 + v310;
		v312 = ROR4(v301, 2);
		v311 = v312;
		v313 = ROR4(v207 ^ v190 ^ v251 ^ v286, 31);
		v314 = v313;
		v315 = v313;
		v317 = ROR4(v309, 2);
		v316 = v317;
		v319 = ROR4(v309, 27);
		v318 = v308 - 1894007588 + v289 + ((v301 | v303) & v297 | v301 & v303)
				+ v319;
		v320 = ROR4(v217 ^ v201 ^ v258 ^ v294, 31);
		v321 = v320;
		v322 = v320 - 1894007588 + v303 + ((v318 | v316) & v311 | v318 & v316);
		v324 = ROR4(v318, 27);
		v323 = v315 - 1894007588 + v297 + ((v309 | v311) & v303 | v309 & v311)
				+ v324;
		v326 = ROR4(v318, 2);
		v325 = v326;
		v328 = ROR4(v231 ^ v207 ^ v264 ^ v306, 31);
		v327 = v328;
		v330 = ROR4(v323, 27);
		v329 = v322 + v330;
		v332 = ROR4(v323, 2);
		v331 = v332;
		v333 = ROR4(v591 ^ v217 ^ v277 ^ v314, 31);
		v334 = v327 - 1894007588 + v311;
		v335 = v333;
		v336 = v333 - 1894007588 + v316 + ((v329 | v331) & v325 | v329 & v331);
		v338 = ROR4(v329, 27);
		v337 = v334 + ((v323 | v325) & v316 | v323 & v325) + v338;
		v340 = ROR4(v329, 2);
		v339 = v340;
		v342 = ROR4(v238 ^ v231 ^ v280 ^ v321, 31);
		v341 = v342;
		v344 = ROR4(v244 ^ v591 ^ v286 ^ v327, 31);
		v343 = v344;
		v346 = ROR4(v337, 27);
		v345 = v336 + v346;
		v348 = ROR4(v337, 2);
		v347 = v348;
		v591 = v343;
		v349 = v341;
		v350 = v341 - 1894007588 + v325;
		v351 = (v337 | v339) & v331 | v337 & v339;
		v352 = v343 - 1894007588 + v331;
		v353 = (v345 | v348) & v339 | v345 & v348;
		v355 = ROR4(v251 ^ v238 ^ v294 ^ v335, 31);
		v354 = v355;
		v357 = ROR4(v345, 27);
		v356 = v350 + v351 + v357;
		v358 = v354;
		v360 = ROR4(v345, 2);
		v359 = v360;
		v361 = v354 - 1894007588;
		v362 = v356 | v360;
		v364 = ROR4(v356, 27);
		v363 = v352 + v353 + v364;
		v366 = ROR4(v356, 2);
		v365 = v366;
		v367 = v362 & v347 | v356 & v359;
		v368 = ROR4(v258 ^ v244 ^ v306 ^ v349, 31);
		v369 = v368;
		v370 = v368 - 1894007588 + v347;
		v371 = ROR4(v264 ^ v251 ^ v314 ^ v591, 31);
		v372 = v371;
		v373 = (v363 | v365) & v359 | v363 & v365;
		v375 = ROR4(v363, 27);
		v374 = v361 + v339 + v367 + v375;
		v377 = ROR4(v363, 2);
		v376 = v377;
		v378 = v374 | v377;
		v380 = ROR4(v374, 27);
		v379 = v370 + v373 + v380;
		v382 = ROR4(v374, 2);
		v381 = v382;
		v383 = ROR4(v277 ^ v258 ^ v321 ^ v358, 31);
		v384 = v383;
		v385 = v372 - 1894007588 + v359 + (v378 & v365 | v374 & v376);
		v386 = v383 - 1894007588 + v365;
		v387 = (v379 | v381) & v376 | v379 & v381;
		v389 = ROR4(v379, 27);
		v388 = v385 + v389;
		v391 = ROR4(v280 ^ v264 ^ v327 ^ v369, 31);
		v390 = v391;
		v393 = ROR4(v379, 2);
		v392 = v393;
		v394 = v390;
		v395 = v388 | v393;
		v396 = v386 + v387;
		v398 = ROR4(v388, 2);
		v397 = v398;
		v400 = ROR4(v388, 27);
		v399 = v396 + v400;
		v401 = ROR4(v286 ^ v277 ^ v335 ^ v372, 31);
		v402 = v401;
		v403 = v390 - 1894007588 + v376 + (v395 & v381 | v388 & v392);
		v404 = v401 - 1894007588 + v381;
		v405 = ROR4(v294 ^ v280 ^ v349 ^ v384, 31);
		v406 = v405;
		v407 = v404 + ((v399 | v397) & v392 | v399 & v397);
		v408 = v405;
		v410 = ROR4(v399, 27);
		v409 = v403 + v410;
		v412 = ROR4(v399, 2);
		v411 = v412;
		v413 = ROR4(v306 ^ v286 ^ v591 ^ v390, 31);
		v414 = v413;
		v416 = ROR4(v409, 27);
		v415 = v407 + v416;
		v418 = ROR4(v409, 2);
		v417 = v418;
		v419 = ROR4(v314 ^ v294 ^ v358 ^ v402, 31);
		v420 = v419;
		v421 = v408 - 1894007588 + v392 + ((v409 | v411) & v397 | v409 & v411);
		v422 = v419;
		v424 = ROR4(v415, 2);
		v423 = v424;
		v426 = ROR4(v415, 27);
		v425 = v421 + v426;
		v427 = v422 - 899497514;
		v428 = v414 - 1894007588 + v397;
		v429 = v314;
		v430 = ROR4(v321 ^ v306 ^ v369 ^ v406, 31);
		v431 = v428 + ((v415 | v417) & v411 | v415 & v417);
		v432 = v430;
		v433 = v427 + v411 + (v423 ^ v417 ^ v425);
		v434 = v430;
		v436 = ROR4(v425, 2);
		v435 = v436;
		v438 = ROR4(v425, 27);
		v437 = v431 + v438;
		v439 = ROR4(v327 ^ v429 ^ v372 ^ v414, 31);
		v440 = v439;
		v441 = v434 - 899497514 + v417 + (v435 ^ v423 ^ v437);
		v442 = v439;
		v444 = ROR4(v437, 27);
		v443 = v433 + v444;
		v446 = ROR4(v437, 2);
		v445 = v446;
		v447 = ROR4(v335 ^ v321 ^ v384 ^ v420, 31);
		v448 = v447;
		v449 = v447;
		v451 = ROR4(v443, 2);
		v450 = v451;
		v453 = ROR4(v443, 27);
		v452 = v441 + v453;
		v454 = v591 ^ v335;
		v456 = ROR4(v349 ^ v327 ^ v394 ^ v432, 31);
		v455 = v456;
		v458 = ROR4(v452, 27);
		v457 = v442 - 899497514 + v423 + (v445 ^ v435 ^ v443) + v458;
		v459 = v455;
		v461 = ROR4(v452, 2);
		v460 = v461;
		v462 = v449 - 899497514 + v435 + (v450 ^ v445 ^ v452);
		v463 = v358 ^ v349;
		v464 = ROR4(v454 ^ v402 ^ v440, 31);
		v465 = v464;
		v466 = v463 ^ v406 ^ v448;
		v467 = v455 - 899497514 + v445 + (v460 ^ v450 ^ v457);
		v469 = ROR4(v457, 27);
		v468 = v462 + v469;
		v471 = ROR4(v457, 2);
		v470 = v471;
		v472 = ROR4(v466, 31);
		v473 = v369 ^ v591;
		v591 = v472;
		v475 = ROR4(v468, 2);
		v474 = v475;
		v477 = ROR4(v468, 27);
		v476 = v467 + v477;
		v478 = v465 - 899497514 + v450 + (v470 ^ v460 ^ v468);
		v479 = ROR4(v473 ^ v414 ^ v459, 31);
		v480 = v372 ^ v358 ^ v420;
		v481 = v479;
		v482 = v479;
		v483 = v591 - 899497514 + v460 + (v474 ^ v470 ^ v476);
		v485 = ROR4(v476, 2);
		v484 = v485;
		v487 = ROR4(v476, 27);
		v486 = v478 + v487;
		v488 = v384 ^ v369 ^ v432;
		v489 = ROR4(v480 ^ v465, 31);
		v490 = v489;
		v491 = v372;
		v493 = ROR4(v486, 2);
		v492 = v493;
		v495 = ROR4(v488 ^ v591, 31);
		v494 = v495;
		v497 = ROR4(v486, 27);
		v496 = v483 + v497;
		v498 = v494;
		v500 = ROR4(v496, 27);
		v499 = v482 - 899497514 + v470 + (v484 ^ v474 ^ v486) + v500;
		v502 = ROR4(v496, 2);
		v501 = v502;
		v504 = ROR4(v394 ^ v491 ^ v440 ^ v481, 31);
		v503 = v504;
		v505 = v402 ^ v384;
		v507 = ROR4(v499, 27);
		v506 = v490 - 899497514 + v474 + (v492 ^ v484 ^ v496) + v507;
		v508 = v503;
		v509 = v494 - 899497514 + v484;
		v511 = ROR4(v499, 2);
		v510 = v511;
		v512 = v406 ^ v394;
		v513 = ROR4(v505 ^ v448 ^ v490, 31);
		v514 = v513;
		v516 = ROR4(v506, 27);
		v515 = v509 + (v501 ^ v492 ^ v499) + v516;
		v517 = v503 - 899497514 + v492;
		v519 = ROR4(v506, 2);
		v518 = v519;
		v520 = v517 + (v510 ^ v501 ^ v506);
		v521 = v519 ^ v510;
		v523 = ROR4(v515, 2);
		v522 = v523;
		v525 = ROR4(v515, 27);
		v524 = v520 + v525;
		v527 = ROR4(v512 ^ v459 ^ v494, 31);
		v526 = v527;
		v528 = v527 - 899497514 + v510 + (v522 ^ v518 ^ v524);
		v530 = ROR4(v524, 2);
		v529 = v530;
		v532 = ROR4(v524, 27);
		v531 = v514 - 899497514 + v501 + (v521 ^ v515) + v532;
		v534 = ROR4(v414 ^ v402 ^ v465 ^ v508, 31);
		v533 = v534;
		v535 = v534 - 899497514;
		v537 = ROR4(v420 ^ v406 ^ v591 ^ v514, 31);
		v536 = v537;
		v539 = ROR4(v531, 27);
		v538 = v528 + v539;
		v540 = v535 + v518;
		v542 = ROR4(v531, 2);
		v541 = v542;
		v543 = ROR4(v432 ^ v414 ^ v481 ^ v526, 31);
		v544 = v420;
		v545 = v543;
		v547 = ROR4(v538, 2);
		v546 = v547;
		v549 = ROR4(v538, 27);
		v548 = v540 + (v529 ^ v522 ^ v531) + v549;
		v550 = v536 - 899497514 + v522 + (v541 ^ v529 ^ v538);
		v552 = ROR4(v440 ^ v544 ^ v490 ^ v533, 31);
		v551 = v552;
		v553 = v545 - 899497514 + v529 + (v546 ^ v541 ^ v548);
		v555 = ROR4(v548, 2);
		v554 = v555;
		v557 = ROR4(v548, 27);
		v556 = v550 + v557;
		v558 = v448 ^ v432 ^ v498 ^ v536;
		v560 = ROR4(v550 + v557, 27);
		v559 = v553 + v560;
		v562 = ROR4(v556, 2);
		v561 = v562;
		v563 = ROR4(v558, 31);
		v564 = v563 - 899497514;
		v566 = ROR4(v559, 27);
		v565 = v551 - 899497514 + v541 + (v554 ^ v546 ^ v556) + v566;
		v568 = ROR4(v559, 2);
		v567 = v568;
		v569 = ROR4(v459 ^ v440 ^ v508 ^ v545, 31);
		v570 = v564 + v546 + (v561 ^ v554 ^ v559);
		v571 = v569 - 899497514 + v554;
		v573 = ROR4(v565, 27);
		v572 = v570 + v573;
		v574 = v571 + (v567 ^ v561 ^ v565);
		v576 = ROR4(v565, 2);
		v575 = v576;
		v578 = ROR4(v572, 27);
		v577 = v574 + v578;
		v579 = v575 ^ v567 ^ v572;
		v581 = ROR4(v465 ^ v448 ^ v514 ^ v551, 31);
		v580 = v581;
		v583 = ROR4(v572, 2);
		v582 = v583;
		v585 = ROR4(v577, 27);
		v584 = v585; // 0xba0b5a21
		v592 = null;
		v587 = bytes2Int(result, 0) - 899497514 + v580 + v561 + v579 + v584;
		v588 = bytes2Int(result, 4) + v577;
		v589 = bytes2Int(result, 8) + v582;
		v590 = bytes2Int(result, 12) + v575;
		int2bytes(result, bytes2Int(result, 16) + v567, 16);
		int2bytes(result, v587, 0);
		int2bytes(result, v588, 4);
		int2bytes(result, v589, 8);
		int2bytes(result, v590, 12);
		return result;
	}

	public static byte[] getSingnature2(byte[] inputs) {
		byte[] result = new byte[20];
		byte[] temp = new byte[132];
		byte[] resultTemp = new byte[92];
		int v4 = bytes2Int(inputs, 20);
		int v13 = reverseOrder(v4);
		int v5 = reverseOrder(bytes2Int(inputs, 24));
		int v6 = (v4 >> 3) & 0x3F;
		int v7;
		if (v6 > 55)
			v7 = 120 - v6;
		else
			v7 = 56 - v6;
		temp[0] = (byte) -128;
		getSingnature1(temp, v7, inputs);
		int2bytes(temp, v5, 0);
		int2bytes(temp, v13, 4);
		getSingnature1(temp, 8, inputs);
		resultTemp = inputs;
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 0)), 0);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 4)), 4);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 8)), 8);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 12)), 12);
		int2bytes(result, reverseOrder(bytes2Int(resultTemp, 16)), 16);
		return result;
	}

	public static byte[] int2bytes(byte[] src, int value, int offset) {
		byte[] a = new byte[4];
		a[3] = (byte) ((value >> 24) & 0xff);
		a[2] = (byte) ((value >> 16) & 0xff);
		a[1] = (byte) ((value >> 8) & 0xff);
		a[0] = (byte) ((value) & 0xff);
		for (int i = 0; i < 4; i++) {
			src[offset + i] = a[i];
		}
		return src;
	}

	public static int reverseOrder(int data) {
		int v1 = ROR4(data, 24);
		int v3 = ROR4(data, 8);
		return v1 & 0xFF00FF | v3 & 0xFF00FF00;
	}

	public static int bytes2Int(byte[] src, int offset) {
		return (int) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8)
				| ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
	}

	public static int ROR4(int signed, int shift) {
		// TODO java新特性函�?
		// long unsigned = Integer.toUnsignedLong(signed);
		long unsigned = (long) signed & 0x0FFFFFFFFL;
		long right = unsigned >> shift;
		long left = unsigned << (32 - shift);
		long temp = left | right;
		return (int) temp;
	}

	public static String byte2hexString(byte[] paramArrayOfByte) {
		char[] arrayOfChar = new char[2 * paramArrayOfByte.length];
		for (int i = 0; i < paramArrayOfByte.length; i++) {
			int j = (char) (0xF & (0xF0 & paramArrayOfByte[i]) >> 4);
			int k = i * 2;
			if (j <= 9) {
				j = j + 48;
			} else {
				j = j + 97 - 10;// 97 小写 65大写
			}
			arrayOfChar[k] = (char) j;
			j = (char) (0xF & paramArrayOfByte[i]);
			k = 1 + i * 2;
			if (j <= 9) {
				j = j + 48;
			} else {
				j = j + 97 - 10;
			}
			arrayOfChar[k] = (char) j;
		}
		return new String(arrayOfChar);
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

	public static byte[] hexString2Bytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	public static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	public static String getFormatTimeByMillis(long Millis) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(
				Millis));
	}

	public static int getRandom(int n) {
		Random random = new Random();
		return random.nextInt(n);
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

	public static HashMap readeMapFromFile(String path) {
		try {
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
					new File(path)));
			return (HashMap) OIS.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void printInfoFromFile(String path) {
		HashMap a = readeMapFromFile(path);
		Iterator iter = a.entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			String key = (String) entry.getKey();
			String val = (String) entry.getValue();
			System.out.println("key:\t"
					+ new String(DESdecrypt(hexString2Bytes(key), "cmgcCMGC")));
			System.out.println("value:\t"
					+ new String(DESdecrypt(hexString2Bytes(val), "cmgcCMGC")));

		}
	}

}
