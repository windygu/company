package com.astrolink.dao;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.MmExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.Base64;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTool;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.RSA;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class MmExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(MmExecLinstenerThreadDao.class);
	private String dbTableName;
	public MmExecLog mmExecLog;
	public IExecFinish execFinish;
	
	public MmExecLinstenerThreadDao(MmExecLog mmExecLog){
		this.mmExecLog = mmExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	public static String defPubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCr1sfrS/gTGiD/D3nERy1LQvk4cFDBKrGPcpw+9Ha8NhXupdmrswEnsTcHZxN/TY/HKvbz7tITuAoY2YCS3ibSbUeoumMmrzeF8fIiaU+aplRSoCC8mxgNlvCbPichHOoQSSSE/5ucLCIlz/uHyXhxEqfRYPsb3y/bmB9vDaTNZwIDAQAB";
	private static String SID="";
	private static String appuid="";
	private static String SubscriberId="";
	private static String OSInfo="";
	private static String PayCode="";
	private static String AppID="";
	private static String AppKey="";
	private static String ProgramId="";
	private static String ChannelID="";
	private static String DeviceId="";
	public static String UAInfo = "";
	public static String StaticMarkStr = "";
	public static byte[] KeyIV = null;
	public static byte[] KeyIV1 = null;
	public static byte[] KeyIV2 = null;
	public static byte[] KeyIV3 = null;
	private void init(){
		SID = "519281978";// SID为随机的8位数
		appuid = "B9FF2CFAC6E558D5";
		SubscriberId = "460001073121516";
		OSInfo = "4.1.1";
		PayCode = "30000892572702";
		AppID = "300008925727";
		AppKey = "DCF710F36EC548A40DAB30EC5D524F4B";
		ProgramId = "3367972";
		ChannelID = "000000000000";
		DeviceId = "861007020172600";
		StaticMarkStr = "AppID::300008925727||CPUx::armeabi||ApkSignature::B492FBFE22C6F4AECF6BEE545380DA5B||app.apk::2274469||libcasdkjni.so::62228||libcmcc_haze.so::121816||libcmcc_rusteze.so::20692||libDexHelper_mmb.so::360726||libidentifyapp.so::291380||libumc-auth.so::21520";
	}
	
	@Override
	public void exec() {
		logger.info("开始MM计费确认，id为" + this.getKey());
		JSONObject dataInfo = new JSONObject();
		JSONObject content = new JSONObject();
		try{
			logger.info("第一步：初始化");
			init();

			logger.info("第二步：得到随机数");
			String pubkey = RSA.getPublicKey();
			String priKey = RSA.getPrivateKey(); // 存储私钥 解密的时候要用到
			String mmwlan_applySecCertForAPPThird_request = generate_request_mmwlan_applySecCertForAPPThird(SID, appuid, SubscriberId, pubkey);
			String mmwlan_applySecCertForAPPThird_response = post_mmwlan_applySecCertForAPPThird(mmwlan_applySecCertForAPPThird_request);
			String randNum_tmp = getContextByTag(mmwlan_applySecCertForAPPThird_response, "randNum");
			if (randNum_tmp.equals("")) {
				return;
			}
			 
			logger.info("第三步：得到打码需要用的数据");
			//LinuxTool lt=new LinuxTool();
			//ArrayList<String> infos=lt.callLinuxCommand("mm getKey");
			String[] keys = generateRSAKeys();
			String PubKey = keys[0];
			String PriKey = keys[1];
			
			SID = Long.valueOf(SID) + 1 + "";
			String randNum = RSA.DecryptWithPrivate(randNum_tmp, priKey);
			String Timestamp = new Date().getTime() / 1000 + "";
			String TradeID = getTradeID(AppID, PayCode, SubscriberId, DeviceId,Timestamp);
			String Signature = getSignature(AppKey, AppID, ProgramId, Timestamp,ChannelID, TradeID, SubscriberId, DeviceId);
			String StaticMark = getStaticMark(AppID, AppKey, Timestamp,StaticMarkStr);
			String sidSignature = getSidSignature(SID, appuid, SubscriberId,randNum, priKey);
			String trusted4_request = generate_request_trusted4(OSInfo, PayCode,AppID, ProgramId, Timestamp, Signature, SubscriberId, UAInfo,TradeID, StaticMark, DeviceId, ChannelID, sidSignature, PubKey);
			trusted4_request = new BASE64Encoder().encode(RSAEncrypt(trusted4_request.getBytes(), defPubKey));
			String trusted4_response = post_trusted4(trusted4_request);
			try {
				trusted4_response = new String(RSADecrypt(new BASE64Decoder().decodeBuffer(trusted4_response),PriKey));
			} catch (Exception e1) {
				logger.info("trusted4_response = :\n" + trusted4_response);
				return;
			}
			
			logger.info("第三步：打码");
			String uuApi="";
			String CheckAnswer="";
			String mobile="-1";
			String CheckCode = getContextByTag(trusted4_response, "CheckCode");
			if (!CheckCode.equals("")) {
				String basePath="d:/";
				String [] result=httpUuGetCode(basePath,CheckCode,mmExecLog.getId()+"");
				if(result!=null){
					uuApi=result[0];
					CheckAnswer=result[1];
					if(CheckAnswer.equals("") || CheckAnswer.equals("-1")){
						CheckAnswer="0";
					}
					CheckAnswer=CheckAnswer.trim();
					String EnMethod_RSADecrypt = new String(RSADecrypt(new BASE64Decoder().decodeBuffer(new String(Base64.decode(dataInfo.getString("EnMethod")))), new String(Base64.decode(dataInfo.getString("PriKey")))));
					Timestamp = new Date().getTime() / 1000 + "";
					sidSignature = getSidSignature(dataInfo.getString("SID"),  dataInfo.getString("appuid"), dataInfo.getString("imsi"), dataInfo.getString("randNum"), new String(Base64.decode(dataInfo.getString("soPriKey"))));
					String PayPwd = getPayPwd(dataInfo.getString("SessionID"));
					String dyAnswer = getdyAnswer(new String(Base64.decode(dataInfo.getString("DynamicQuest"))), dataInfo.getString("spProductCode"), dataInfo.getString("ApkSignature"), dataInfo.getString("SessionID"),basePath); //dyAnswer等于null 代表so文件找不到
					
					if(dyAnswer!=null){
						try {
							String DynamicMark = contentEncrypt(dyAnswer, dataInfo.getString("spProductCode"), dataInfo.getString("AppKey"), dataInfo.getString("ProgramId"), dataInfo.getString("ChannelID"), dataInfo.getString("consumeCode"), Timestamp, dataInfo.getString("imsi"), dataInfo.getString("imei"), EnMethod_RSADecrypt, dataInfo.getString("Signature"), dataInfo.getString("apkmodulus"), dataInfo.getString("dexSHA1"), dyAnswer, dataInfo.getString("SessionID"), sidSignature);
							String ApData = contentEncrypt(dataInfo.getString("apkmodulus"), dataInfo.getString("spProductCode"), dataInfo.getString("AppKey"), dataInfo.getString("ProgramId"), dataInfo.getString("ChannelID"), dataInfo.getString("consumeCode"), Timestamp, dataInfo.getString("imsi"), dataInfo.getString("imei"), EnMethod_RSADecrypt, dataInfo.getString("Signature"),  dataInfo.getString("apkmodulus"), dataInfo.getString("dexSHA1"), dyAnswer, dataInfo.getString("SessionID"), sidSignature);
							String DexData = contentEncrypt(dataInfo.getString("dexSHA1"), dataInfo.getString("spProductCode"), dataInfo.getString("AppKey"), dataInfo.getString("ProgramId"), dataInfo.getString("ChannelID"), dataInfo.getString("consumeCode"), Timestamp, dataInfo.getString("imsi"), dataInfo.getString("imei"), EnMethod_RSADecrypt, dataInfo.getString("Signature"),  dataInfo.getString("apkmodulus"), dataInfo.getString("dexSHA1"), dyAnswer, dataInfo.getString("SessionID"), sidSignature);
							String ReqMD5 = getReqMD5(dataInfo.getString("AppKey"), dataInfo.getString("SessionID"), dataInfo.getString("consumeCode"), dataInfo.getString("spProductCode"), dataInfo.getString("CheckID"), dataInfo.getString("ChannelID"), dataInfo.getString("imsi"), dataInfo.getString("imei"), dataInfo.getString("ProgramId"), Timestamp, ApData, DexData);
							
							String SnbBillingService_request = generate_request_SnbBillingService(dataInfo.getString("SessionID"), dataInfo.getString("spProductCode"), dataInfo.getString("consumeCode"), dataInfo.getString("CheckID"), CheckAnswer, PayPwd, DynamicMark, dataInfo.getString("imsi"), dataInfo.getString("imei"), sidSignature, dataInfo.getString("ChannelID"), dataInfo.getString("ProgramId"), Timestamp, ApData, DexData, ReqMD5, new String(Base64.decode(dataInfo.getString("PubKey"))));
							SnbBillingService_request = new BASE64Encoder().encode(RSAEncrypt(SnbBillingService_request.getBytes(), dataInfo.getString("defPubKey")));
		
							String tmpTimestamp = Long.valueOf(Timestamp) - 1262275200 + "";
							tmpTimestamp = tmpTimestamp.length() < 6 ? fillbyblank(tmpTimestamp, 6) : tmpTimestamp;
							String tmpProgramId = a(dataInfo.optLong("ProgramId"));
							tmpProgramId = tmpProgramId.length() < 6 ? fillbyblank(tmpProgramId, 6) : tmpProgramId;
							String tmpDeviceId = a(dataInfo.optLong("imei"));
							tmpDeviceId = tmpDeviceId.length() < 10 ? fillbyblank(tmpDeviceId, 10) : tmpDeviceId;
							String tmpSubscriberId = a(dataInfo.optLong("imsi"));
							tmpSubscriberId = tmpSubscriberId.length() < 10 ? fillbyblank(tmpSubscriberId, 10) : tmpSubscriberId;
							String tmpPaycode = a(dataInfo.optLong("consumeCode"));
							tmpPaycode = tmpPaycode.length() < 9 ? fillbyblank(tmpPaycode, 9) : tmpPaycode;
							String tmpChannelId = a(dataInfo.optLong("ChannelID"));
							tmpChannelId = tmpChannelId.length() < 8 ? fillbyblank(tmpChannelId, 8) : tmpChannelId;
		
							String SessionIDData = contentEncrypt(dataInfo.getString("SessionID"), dataInfo.getString("spProductCode"), dataInfo.getString("AppKey"), tmpProgramId, tmpChannelId, tmpPaycode, tmpTimestamp, tmpSubscriberId, tmpDeviceId, EnMethod_RSADecrypt, dataInfo.getString("Signature"),  dataInfo.getString("apkmodulus"), dataInfo.getString("dexSHA1"), dyAnswer, dataInfo.getString("SessionID"), sidSignature);
							String plaincontent = getplaincontent(tmpProgramId, tmpChannelId, dataInfo.getString("imsi"), dataInfo.getString("imei"), Timestamp, dataInfo.getString("consumeCode"));
							String strongEncyptCipher = strongEncyptCipher(SessionIDData, ApData, DexData);
							String userdata = strongUserDataCipher("01", plaincontent, strongEncyptCipher);
							String EncryptedContFlex = GetEncryptedContFlex("0000", plaincontent + userdata, strongEncyptCipher,Base64.decode(dataInfo.getString("KeyIV")),Base64.decode(dataInfo.getString("KeyIV1")),Base64.decode(dataInfo.getString("KeyIV2")),Base64.decode(dataInfo.getString("KeyIV3")));
							String billSecData = Arrays.toString(a(encode(EncryptedContFlex))); 
							
							content.put("SnbBillingService_request",  Base64.encode(SnbBillingService_request.getBytes()));
							content.put("billSecData", Base64.encode(billSecData.getBytes()));
							//content.put("nextUrl", Constants.mmClientSteps+"?steps=3&linkId=" + linkId);
							
							//String SnbBillingService_response = post_SnbBillingService(SnbBillingService_request, billSecData);
							//try {
								//System.out.println(new String(mt.RSADecrypt(new BASE64Decoder().decodeBuffer(SnbBillingService_response), new String(Base64.decode(dataInfo.getString("PriKey")))),"utf-8"));
							//} catch (Exception e1) {
								//e1.printStackTrace();
							//}
							//System.out.println(dataInfo);
							
//							softwareStatus="3";
//							softwareMessage="mm第三步加密完成";
						} catch (Exception e) {
//							softwareStatus="-7";
//							softwareMessage="mm第二步加密异常";
//							log.error(ExceptionTool.getErrorInfo(e));
						}
					}else{
//						softwareStatus="-6";
//						softwareMessage="获取so配置信息失败";
					}
				}else{
//					softwareStatus="-10";
//					softwareMessage="打码异常";
				}
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}finally{
			try {
//				try {
//					status=Integer.parseInt(status)+"";
//				} catch (Exception e2) {
//					status="-1";
//				}
//				
//				if(payStepNum==2 && Integer.parseInt(status)==0){
//					updataExecLog(mmExecLog.getId());
//					sevePayResultLog(payStepNum,status,message,phoneNumber,dmExecLog.getCrackSynUrl(),en_session,dmExecLog.getId());
//				}else{
//					if(mmExecLog.getExecNum()<Const.COMIC_LOGIC_RETRY_NUM-1){
//						updateExecNum(mmExecLog.getId());
//					}else{
//						updataExecLog(mmExecLog.getId());
//						sevePayResultLog(payStepNum,status,message,phoneNumber,dmExecLog.getCrackSynUrl(),en_session,dmExecLog.getId());
//					}
//				}
			} catch (Exception e) {
				logger.info("处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
			} finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("处理请求结束，id为" + this.getKey());
				}
			}
		}
	}
	
	
	public  void updateExecNum(long id){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE ").append(dbTableName).append(" SET  execNum = execNum+1, updateDate='").append(BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss")).append("'  WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_COMIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_COMIC_USERNAME,Const.DB_COMIC_PASSWORD);
		logger.info("updateExecNum：" + dt.upDate(sqlBuff.toString(), MmExecLinstenerThreadDao.class));
	}
	
	public  void deleteExecLog(long id){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM ").append(dbTableName).append(" WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_COMIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_COMIC_USERNAME,Const.DB_COMIC_PASSWORD);
		logger.info("deleteExecLog：" + dt.upDate(sqlBuff.toString(), MmExecLinstenerThreadDao.class));
	}
	
	public  void updataExecLog(long id){
		StringBuffer sqlBuff=new StringBuffer();
		//sqlBuff.append("UPDATE comic.exec_log SET deleteType = '1' WHERE id= '").append(id).append("'");
		sqlBuff.append("DELETE FROM comic.exec_log WHERE id = '").append(id).append("'");
		DbTools dt=new  DbTools(Const.DB_COMIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_COMIC_USERNAME,Const.DB_COMIC_PASSWORD);
		logger.info("deleteExecLog：" + dt.upDate(sqlBuff.toString(), MmExecLinstenerThreadDao.class));
	}
	
	public void sevePayResultLog(int payStepNum,String status,String message,String phoneNumber,String crackSynUrl,String en_session,long execLogId){
		JSONObject dataInfo=new JSONObject();
		dataInfo.put("payStepNum", payStepNum);
		dataInfo.put("execLogId", execLogId);
		dataInfo.put("status", status);
		dataInfo.put("message", message);
		dataInfo.put("en_session", en_session);
		dataInfo.put("imei", mmExecLog.getImei());
		dataInfo.put("imsi", mmExecLog.getImsi());
		dataInfo.put("monum", mmExecLog.getMonum());
		dataInfo.put("consumeCode", mmExecLog.getConsumeCode());
		dataInfo.put("cpparam", mmExecLog.getCpparam());
		dataInfo.put("execNum", mmExecLog.getExecNum());
		dataInfo.put("phoneNumber", phoneNumber);
		dataInfo.put("cpInfoId", mmExecLog.getCpid());
		dataInfo.put("transId", mmExecLog.getRand16Num()+mmExecLog.getTimeStamp());
		dataInfo.put("dayTime", BasicsTools.getForDate("yyyy-MM-dd"));
		dataInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));	
		dataInfo.put("methodType", mmExecLog.getMethodType());
		if(!status.equals("1010")){
			try {
				crackSyn(dataInfo,crackSynUrl(dataInfo,crackSynUrl));
			} catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			}
		}
		DbTools dt=new  DbTools(Const.DB_COMIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_COMIC_USERNAME,Const.DB_COMIC_PASSWORD);
		logger.info("sevePayResultLog：" + dt.insertJson(Const.COMIC_TABLE_PAY_RESULT_LOG, dataInfo, MmExecLinstenerThreadDao.class));
	}
	
	public void crackSyn(JSONObject dataInfo,String url){
		GetNetWork get=new GetNetWork(url);
		get.executeMethod();
		dataInfo.put("synUrl", url);
		dataInfo.put("synstatus", get.getNetState());
		dataInfo.put("synresult", get.getString().replaceAll("'",""));
	}
	
	public String crackSynUrl(JSONObject dataInfo,String crackSynUrl){
		StringBuffer sbuff =new StringBuffer();
		sbuff.append(crackSynUrl);
		sbuff.append("?").append("mobile=").append(dataInfo.optString("phoneNumber"));
		sbuff.append("&").append("cpid=").append(dataInfo.optString("cpInfoId"));
		sbuff.append("&").append("cpparam=").append(dataInfo.optString("cpparam"));
		sbuff.append("&").append("monum=").append(dataInfo.optString("monum"));
		sbuff.append("&").append("sid=").append(dataInfo.optString("consumeCode"));
		sbuff.append("&").append("imei=").append(dataInfo.optString("imei"));
		sbuff.append("&").append("imsi=").append(dataInfo.optString("imsi"));
		sbuff.append("&").append("linkId=").append(dataInfo.optString("transId"));
		sbuff.append("&").append("status=").append(dataInfo.optString("status"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sbuff.toString();
	}
	
	public JSONObject getItemInfo(JSONArray item,String consumeCode){
		for(int i=0;i<item.size();i++){
			JSONObject json=item.getJSONObject(i);
			if(json.getString("itemId").equals(consumeCode)){
				return json;
			}
		}
		return null;
	}
	
	public static String generate_request_mmwlan_applySecCertForAPPThird(
			String SID, String appuid, String SubscriberId, String pubkey) {
		String result = "";
		result += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		result += "<request>";
		result += "<sid>" + SID + "</sid>";
		result += "<appuid>" + appuid + "</appuid>";
		result += "<pubkey>" + pubkey + "</pubkey>";
		result += "<imsi>" + md5_base64(SubscriberId.getBytes()) + "</imsi>";
		result += "</request>";
		return result;
	}
	
	public static String md5_base64(byte[] data) {
		MessageDigest localMessageDigest = null;
		try {
			localMessageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		localMessageDigest.update(data);
		byte[] arrayOfByte = localMessageDigest.digest();

		return (new BASE64Encoder()).encode(arrayOfByte);
	}
	
	public static String post_mmwlan_applySecCertForAPPThird(String context) {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://ospd.mmarket.com:80/mmwlan/applySecCertForAPPThird ");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "text/xml");
			conn.setRequestProperty("Host", "ospd.mmarket.com:80");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent",
					"Apache-HttpClient/UNAVAILABLE (java 1.4)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(context);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
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
		return result;
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
	
	public static String getTradeID(String AppID, String PayCode,
			String SubscriberId, String DeviceId, String Timestamp) {
		String result = "";
		result = md52String32((AppID + "$" + PayCode + "$" + DeviceId + "$"
				+ SubscriberId + "$" + Timestamp).getBytes());
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
	
	public static String getSignature(String AppKey, String AppID,
			String ProgramId, String Timestamp, String ChannelID,
			String TradeID, String SubscriberId, String DeviceId) {
		String result = "";
		result += AppKey + "&";
		result += AppID + "&";
		result += ProgramId + "&";
		result += Timestamp + "&";
		result += ChannelID + "&";
		result += "3.1.9" + "&";
		result += "0" + "&";
		result += "1" + "&";
		result += TradeID + "&";
		result += SubscriberId + "&";
		result += DeviceId;

		System.out.println("getSignature:\t" + result);
		result = (new BASE64Encoder()).encode(md52String32(result.getBytes())
				.getBytes());
		System.out.println("getSignature:\t" + result);
		return result;
	}
	
	public static String getStaticMarkStr(String AppID, String ApkSignature) {
		String result = "AppID::" + AppID + "||CPUx::armeabi||ApkSignature::"
				+ ApkSignature + getApkAndAllSoLength("./" + AppID + "/");
		return result;
	}
	
	public static String getApkAndAllSoLength(String path) {
		String result = "";
		File dir = new File(path);
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {

			if (!fs[i].isDirectory()) {
				result += "||" + fs[i].getName() + "::" + fs[i].length();
			}
		}
		return result;
	}
	
	public static String getStaticMark(String AppID, String AppKey,
			String Timestamp, String StaticMarkStr) {
		String result = "";
		// String str = "AppID::" + AppID + "||CPUx::armeabi||ApkSignature::" +
		// ApkSignature + "||app.apk::" + app_apk_len + "||libcasdkjni.so::"+
		// lib_casdkjni_len + "||libidentifyapp.so::" + lib_identifyapp;
		// String StaticMarkStr =
		// "AppID::300008792635||CPUx::armeabi||ApkSignature::64556E68F4026A686B767737A4B32843||app.apk::8767781||libbox2d.so::669700||libcasdkjni.so::48492||libchipmunk.so::514228||libcmcc_haze.so::125840||libcmcc_rusteze.so::21632||libiap.so::111852||libidentifyapp.so::50448||liblua.so::664812||libwiengine.so::1562824||libwiengine_binding.so::287860||libwinetwork.so::124140||libwisound.so::91372";
		String key = AppID + AppKey + Timestamp;
		byte[] key_byte = md5_byte(key.getBytes());

		byte[] data = StaticMarkStr.getBytes();
		int i = ((data.length + 7) / 8) * 8 - data.length;
		byte[] tmp = new byte[i];
		byte[] new_data = new byte[data.length + tmp.length];
		System.arraycopy(data, 0, new_data, 0, data.length);
		System.arraycopy(tmp, 0, new_data, data.length, tmp.length);
		try {
			DESKeySpec desKeySpec = new DESKeySpec(key_byte);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			Cipher enCipher = Cipher.getInstance("DES/ECB/NoPadding");
			enCipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = (new BASE64Encoder()).encode(enCipher.doFinal(new_data));
		} catch (Exception e) {
		}
		return result;
	}
	
	public static String[] generateRSAKeys() // 0-publickey 1-privatekey
	{
		RSAPrivateKey myPrivateKey;
		RSAPublicKey myPublicKey;
		KeyPairGenerator KeyPairGenerator = null;
		try {
			KeyPairGenerator = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		KeyPairGenerator.initialize(1024, new SecureRandom());
		KeyPair localKeyPair = KeyPairGenerator.generateKeyPair();
		myPublicKey = (RSAPublicKey) localKeyPair.getPublic();
		myPrivateKey = (RSAPrivateKey) localKeyPair.getPrivate();
		String[] keys = new String[2];
		keys[0] = (new BASE64Encoder()).encodeBuffer(myPublicKey.getEncoded());
		keys[1] = (new BASE64Encoder()).encodeBuffer(myPrivateKey.getEncoded());
		return keys;
	}
	
	public static byte[] md5_byte(byte[] data) {
		MessageDigest localMessageDigest = null;
		try {
			localMessageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		localMessageDigest.update(data);
		byte[] result = localMessageDigest.digest();
		return result;
	}
	
	public static String getSidSignature(String SID, String appuid,
			String SubscriberId, String randNum, String priKey) {
		String result = "";
		result += SID + "$";
		result += appuid + "$";
		result += md5_base64(SubscriberId.getBytes()) + "$";
		result += randNum;
		result += "$" + RSA.SHA1AndSignWithPrivatekey(result, priKey);
		System.out.println("getSidSignature:" + result);
		return result;
	}
	
	public static String generate_request_trusted4(String OSInfo,
			String PayCode, String AppID, String ProgramId, String Timestamp,
			String Signature, String SubscriberId, String UAInfo,
			String TradeID, String StaticMark, String DeviceId,
			String ChannelID, String sidSignature, String PubKey) {
		String result = "";
		result += "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>";
		result += "<Trusted4AuthReq>";
		result += "<MsgType>Trusted4AuthReq</MsgType>";
		result += "<Version>3.1.9</Version>";
		result += "<MiniVersion>3.1.9</MiniVersion>";
		result += "<SessionID>0</SessionID>";
		result += "<PayCode>" + PayCode + "</PayCode>";
		result += "<AppID>" + AppID + "</AppID>";
		result += "<ProgramId>" + ProgramId + "</ProgramId>";
		result += "<Timestamp>" + Timestamp + "</Timestamp>";
		result += "<ChannelID>" + ChannelID + "</ChannelID>";
		result += "<Signature>" + Signature + "</Signature>";
		result += "<osid>1</osid>";
		result += "<IsNextCycle>0</IsNextCycle>";
		result += "<SubsNumb>1</SubsNumb>";
		result += "<TradeID>" + TradeID + "</TradeID>";
		result += "<StaticMark>" + StaticMark + "</StaticMark>";
		result += "<UserType>1</UserType>";
		result += "<MccMnc>" + SubscriberId.substring(0, 5) + "</MccMnc>";
		result += "<UAInfo>" + UAInfo + "</UAInfo>";
		result += "<OSInfo>" + OSInfo + "</OSInfo>";
		result += "<BracketID></BracketID>";
		result += "<NetInfo>WIFI</NetInfo>";
		result += "<programHash></programHash>";
		result += "<imsi>" + SubscriberId + "</imsi>";
		result += "<imei>" + DeviceId + "</imei>";
		result += "<sidSignature>" + sidSignature + "</sidSignature>";
		result += "<IAPServiceID>" + AppID + "</IAPServiceID>";
		result += "<APPTYPE>" + "0" + "</APPTYPE>";
		result += "<EXDATA>" + "" + "</EXDATA>";
		result += "<PubKey>" + PubKey.replaceAll("\r", "").replaceAll("\n", "")
				+ "</PubKey>";
		result += "<Retry>" + "0" + "</Retry>";
		result += "<SDKPubKey>"
				+ PubKey.replaceAll("\r", "").replaceAll("\n", "")
				+ "</SDKPubKey>";
		result += "<emulator>0</emulator>";
		result += "</Trusted4AuthReq>";
		return result;
	}
	
	public static byte[] RSAEncrypt(byte[] data, String publicKey) {
		byte[] result = null;
		try {
			PublicKey pubkey;
			pubkey = KeyFactory.getInstance("RSA").generatePublic(
					new X509EncodedKeySpec(new BASE64Decoder()
							.decodeBuffer(publicKey)));
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(1, ((Key) pubkey));
			int len = data.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int i = 0;
			int j = 0;
			while (len - j > 0) {
				result = len - j > 0x75 ? cipher.doFinal(data, j, 0x75)
						: cipher.doFinal(data, j, len - j);
				out.write(result, 0, result.length);
				i += 1;
				j = i * 0x75;
			}
			result = out.toByteArray();
			out.close();
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	public static String post_trusted4(String context) {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL("http://ospd.mmarket.com:80/trusted4");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("x-iap-sdk-ver", "3.1.9");
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			conn.setRequestProperty("Host", "ospd.mmarket.com:80");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(context);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
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
		return result;
	}
	
	public static byte[] RSADecrypt(byte[] data, String privateKey) {
		byte[] result = null;
		try {
			PrivateKey prikey = KeyFactory.getInstance("RSA").generatePrivate(
					new PKCS8EncodedKeySpec(new BASE64Decoder()
							.decodeBuffer(privateKey)));
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(2, ((Key) prikey));
			int len = data.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int i = 0;
			int j = 0;
			while (len - j > 0) {
				result = len - j > 0x80 ? cipher.doFinal(data, j, 0x80)
						: cipher.doFinal(data, j, len - j);
				out.write(result, 0, result.length);
				i += 1;
				j = i * 0x80;
			}
			result = out.toByteArray();
			out.close();
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	public String [] httpUuGetCode(String basePath,String CheckCode,String linkId){
		// 存储图片
		String path=basePath+"/uuCode/"+BasicsTools.getForDate("yyyy-MM-dd")+"/";
		
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		String filePath=path+linkId+"_"+BasicsTools.getUuid(true, 16, Const.random)+".GIF";
		byte[] decode = Base64.decode(CheckCode);
		File img=new File(filePath);
	
		
		try {
			if(!img.exists()){
				img.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(decode);
			fos.close();
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
		}
	
		// 这里接打码平台
		return BasicsTools.httpUuGetCode(filePath);
	}
	
	public static String getPayPwd(String SessionID) {
		String result = "";
		result = md52String32(result.getBytes()) + SessionID;
		result = md52String32(result.getBytes());
		return result;
	}
	
	public static String getdyAnswer(String DynamicQuest, String AppID,
			String ApkSignature, String SessionID,String basePath) {
		String result = "";

		Cipher enCipher = null;
		try {
			byte[] tmp = (new BASE64Decoder()).decodeBuffer(DynamicQuest);
			System.out.println(tmp.length);
			enCipher = Cipher.getInstance("DES/ECB/NoPadding");// /ECB/PKCS5Padding
			String seed = AppID + ApkSignature + SessionID;
			MessageDigest localMessageDigest = null;
			localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(seed.getBytes());
			byte[] keyBytes = localMessageDigest.digest();

			DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			enCipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] pasByte = enCipher.doFinal(tmp);
			int i = 0;
			for (i = 0; i < pasByte.length; i++) {
				if (pasByte[i] == 0)
					break;
			}
			// libcasdkjni.so::0::48492||libgame.so::487767::1129293||libidentifyapp.so::0::46272
			String decode_result = new String(pasByte, 0, i, "UTF-8");
			System.out.println("DynamicMark decode_context:\t" + decode_result);
			String[] stringArray = decode_result.split("\\|\\|");
			String encode_context = "";
			for (int j = 0; j < stringArray.length; j++) {
				String[] stringArrayTemp = stringArray[j].split("::");
//				byte[] fileTemp = readfile2bytes("./" + AppID + "/"
//						+ stringArrayTemp[0]);
				byte[] fileTemp = readfile2bytes(basePath+"/mmAppResources/" + AppID + "/" + stringArrayTemp[0]);
				int start = Integer.valueOf(stringArrayTemp[1]);
				int length = Integer.valueOf(stringArrayTemp[2]);
				byte[] md5Temp = new byte[length];
				System.arraycopy(fileTemp, start, md5Temp, 0, length);
				encode_context += (j + 1) + "::" + md52String32(md5Temp);
				if (j != stringArray.length - 1)
					encode_context += "||";
			}
			result = md52String32(encode_context.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		result = AppID + SessionID + result;

		result = md52String32(result.getBytes());
		return result;
	}
	
	public static byte[] readfile2bytes(String filePath) {
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}
		FileInputStream fi;
		byte[] buffer = new byte[(int) fileSize];
		try {
			fi = new FileInputStream(file);
			int offset = 0;
			int numRead = 0;
			while (offset < buffer.length
					&& (numRead = fi.read(buffer, offset, buffer.length
							- offset)) >= 0) {
				offset += numRead;
			}
			fi.close();
			if (offset != buffer.length) {
				throw new IOException("Could not completely read file "
						+ file.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
	
	public static String contentEncrypt(String Data, String AppID,
			String AppKey, String ProgramId, String ChannelId, String PayCode,
			String Timestamp, String SubscriberId, String DeviceId,
			String EnMethod_RSADecrypt, String Signature, String apkmodulus,
			String dexSHA1, String DyMark, String SessionID, String sidSignature) {
		String RandomNum = EnMethod_RSADecrypt.split(",")[5];
		String str = EnMethod_RSADecrypt.split(",")[4];
		// MD5_32(MD5_16(%MainData%%AppID%%AppKey%%PID%%ChannelId%%PayCode%%Timestamp%)MD5_16(%IMSI%%IMEI%)%RandomNum%),'
		str = str.replaceAll("%MainData%", Data);
		str = str.replaceAll("%AppID%", AppID);
		str = str.replaceAll("%AppKey%", AppKey);
		str = str.replaceAll("%PID%", ProgramId);
		str = str.replaceAll("%ChannelId%", ChannelId);
		str = str.replaceAll("%IMSI%", SubscriberId);
		str = str.replaceAll("%IMEI%", DeviceId);
		str = str.replaceAll("%PayCode%", PayCode);
		str = str.replaceAll("%Timestamp%", Timestamp);
		str = str.replaceAll("%ProgramHash%", Signature);// getSignature
		str = str.replaceAll("%ApData%", apkmodulus);
		str = str.replaceAll("%DexData%", dexSHA1);
		str = str.replaceAll("%DynamicMark%", DyMark);
		str = str.replaceAll("%SessionID%", SessionID);
		str = str.replaceAll("%SidSignature%", sidSignature);
		str = str.replaceAll("%RandomNum%", RandomNum);

		int i = 0;
		int m = 0;
		int n = 0;
		while (true) {
			n = str.indexOf(')', 0);
			if (n == -1)
				break;
			m = str.lastIndexOf('(', n);
			String data = str.substring(m + 1, n);
			String md5_32 = md52String32(data.getBytes());
			String is16 = str.substring(m - 6, m);
			if (is16.equals("MD5_16")) {
				md5_32 = md5_32.substring(8, 24);
			}
			String replace = str.substring(m - 6, n + 1);
			str = str.substring(0, m - 6) + md5_32 + str.substring(n + 1);
		}
		return str;
		// String result = "";
		// String tmp1 = md52String32((Data + AppID + AppKey + ProgramId +
		// ChannelId + PayCode + Timestamp).getBytes()).substring(8, 24);
		// String tmp2 = md52String32((SubscriberId +
		// DeviceId).getBytes()).substring(8, 24);
		// result = md52String32((tmp1 + tmp2 + RandomNum).getBytes());
		// return result;
	}
	
	public static String getReqMD5(String AppKey, String SessionID,
			String PayCode, String AppID, String CheckID, String ChannelID,
			String SubscriberId, String DeviceId, String ProgramId,
			String Timestamp, String ApData, String DexData) {
		String result = "";
		result += AppKey + "&";
		result += "3.1.9" + "&";
		result += SessionID + "&";
		result += PayCode + "&";
		result += AppID + "&";
		result += "1" + "&";
		result += "" + "&";
		result += CheckID + "&";
		result += "1" + "&";
		result += ChannelID + "&";
		result += SubscriberId + "&";
		result += DeviceId + "&";
		result += ProgramId + "&";
		result += Timestamp + "&";
		result += ApData + "&";
		result += DexData;
		result = md52String32(result.getBytes());
		result = new BASE64Encoder().encode(result.getBytes());
		return result;
	}
	
	public static String generate_request_SnbBillingService(String SessionID,
			String AppID, String PayCode, String CheckID, String CheckAnswer,
			String PayPwd, String DynamicMark, String SubscriberId,
			String DeviceId, String sidSignature, String ChannelID,
			String ProgramId, String Timestamp, String ApData, String DexData,
			String ReqMD5, String PubKey) {
		String result = "";
		result += "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>";
		result += "<Trusted4SubscribeReq>";
		result += "<MsgType>Trusted4SubscribeReq</MsgType>";
		result += "<Version>3.1.9</Version>";
		result += "<MiniVersion>3.1.9</MiniVersion>";
		result += "<SessionID>" + SessionID + "</SessionID>";
		result += "<PayCode>" + PayCode + "</PayCode>";
		result += "<AppID>" + AppID + "</AppID>";
		result += "<SubsNumb>1</SubsNumb>";
		result += "<BracketID></BracketID>";
		result += "<CheckID>" + CheckID + "</CheckID>";
		result += "<CheckAnswer>" + CheckAnswer + "</CheckAnswer>";
		result += "<PayWay>1</PayWay>";
		result += "<PayPwd>" + PayPwd + "</PayPwd>";
		result += "<RandomPwd></RandomPwd>";
		result += "<ChannelID>" + ChannelID + "</ChannelID>";
		result += "<UserType>1</UserType>";
		result += "<NetInfo>WIFI</NetInfo>";
		result += "<programHash></programHash>";
		result += "<imsi>" + SubscriberId + "</imsi>";
		result += "<imei>" + DeviceId + "</imei>";
		result += "<sidSignature>" + sidSignature + "</sidSignature>";
		result += "<ProgramId>" + ProgramId + "</ProgramId>";
		result += "<APPTYPE>" + "0" + "</APPTYPE>";
		result += "<Timestamp>" + Timestamp + "</Timestamp>";
		result += "<DynamicMark>" + DynamicMark + "</DynamicMark>";
		result += "<ApData>" + ApData + "</ApData>";
		result += "<DexData>" + DexData + "</DexData>";
		result += "<Retry>" + "0" + "</Retry>";
		result += "<ReqMD5>" + ReqMD5 + "</ReqMD5>";
		result += "<SDKPubKey>"
				+ PubKey.replaceAll("\r", "").replaceAll("\n", "")
				+ "</SDKPubKey>";
		result += "</Trusted4SubscribeReq>";
		return result;
	}
	
	public static String fillbyblank(String arg2, int arg3) {
		while (arg2.length() < arg3) {
			arg2 += " ";
		}
		return arg2;
	}
	
	public static String a(long paramLong) {
		String str1 = paramLong + "";
		String str2 = "";
		long l1 = paramLong / 36L;
		long l2 = paramLong % 36L;
		for (str2 = str2 + b(l2); l1 > 0L; str2 = str2 + b(l2)) {
			paramLong = l1;
			l1 = paramLong / 36L;
			l2 = paramLong % 36L;
		}
		StringBuffer localStringBuffer = new StringBuffer(str2);
		localStringBuffer.reverse().toString();
		return localStringBuffer.toString();
	}
	
	public byte[] a(String arg6) {
		byte[] v0_1;
		if (arg6 == null || (arg6.equals(""))) {
			v0_1 = null;
		} else {
			String v0 = arg6.toUpperCase();
			int v2 = v0.length() / 2;
			char[] v3 = v0.toCharArray();
			v0_1 = new byte[v2];
			int v1;
			for (v1 = 0; v1 < v2; ++v1) {
				int v4 = v1 * 2;
				v0_1[v1] = ((byte) (char2byte(v3[v4 + 1]) | char2byte(v3[v4]) << 4));
			}
		}
		return v0_1;
	}
	
	public static String getplaincontent(String ProgramId, String ChannelId,
			String SubscriberId, String DeviceId, String timeStamp,
			String PayCode) {
		return "b5" + ProgramId + ChannelId + a(Long.parseLong(SubscriberId))
				+ a(Long.parseLong(DeviceId)) + a(Long.parseLong(timeStamp))
				+ a(Long.parseLong(PayCode));
	}
	
	public static String b(long paramLong) {
		if (paramLong < 10L)
			return paramLong + "";
		long l1 = 55L + paramLong;
		char c1 = (char) (int) l1;
		return String.valueOf(c1);
	}
	
	public static String strongEncyptCipher(String SessionIDData,
			String ApData, String dexData) {
		String result = "";
		result += "1" + "00";// "00"为rid 固定
		result += SessionIDData.substring(SessionIDData.length() - 10);
		result += ApData.substring(8, 18);
		result += dexData.substring(8, 18);
		return result;
	}
	
	public static String strongUserDataCipher(String ordercount,
			String content, String enccontent) {
		String result = "";
		result += ordercount
				+ md52String32((content + enccontent.substring(1)).getBytes())
						.substring(8, 22);
		return result;
	}
	
	public static String GetEncryptedContFlex(String countString, String plaincontent, String enccontent,byte[] KeyIV,byte[] KeyIV1,byte[] KeyIV2,byte[] KeyIV3) {
		byte[] countbyte = countString.getBytes();
		String rslt = null;
		byte[] aes_countbye1 = new byte[4];
		byte[] aes_countbye2 = new byte[4];
		byte[] aes_countbye3 = new byte[4];
		System.arraycopy(AESEncryptByKeyIV(countbyte, KeyIV1), 0, aes_countbye1, 0, 4);
		System.arraycopy(AESEncryptByKeyIV(countbyte, KeyIV2), 0, aes_countbye2, 0, 4);
		System.arraycopy(AESEncryptByKeyIV(countbyte, KeyIV3), 0, aes_countbye3, 0, 4);
		//System.out.println(Arrays.toString(AESEncryptByKeyIV(countbyte, KeyIV1)));
		//System.out.println(Arrays.toString(AESEncryptByKeyIV(countbyte, KeyIV2)));
		//System.out.println(Arrays.toString(AESEncryptByKeyIV(countbyte, KeyIV3)));

		String src = plaincontent.substring(0, 51) + enccontent.substring(1, 33) + plaincontent.substring(51) + enccontent.substring(0, 1);
		byte[] en = new byte[src.getBytes().length + 16];

		System.arraycopy(src.getBytes(), 0, en, 0, src.length());
		System.arraycopy(aes_countbye1, 0, en, src.length(), 4);
		System.arraycopy(aes_countbye2, 0, en, src.length() + 4, 4);
		System.arraycopy(aes_countbye3, 0, en, src.length() + 8, 4);
		System.arraycopy(countbyte, 0, en, src.length() + 12, 4);

		byte[] byte_A6C = AESEncryptByKeyIV(en, KeyIV);
		int n = byte_A6C.length - 16;
		//System.out.println(Arrays.toString(byte_A6C));

		byte[] endBytes = new byte[4];
		System.arraycopy(byte_A6C, n, endBytes, 0, 4);

		byte[] aes_subenccontent = AESEncryptByKeyIV(enccontent.toString().substring(1, 33).getBytes(), KeyIV);

		byte[] beforeBase = new byte[aes_subenccontent.length + 20];
		System.arraycopy(aes_subenccontent, 0, beforeBase, 0, aes_subenccontent.length);
		System.arraycopy(aes_countbye3, 0, beforeBase, aes_subenccontent.length, 4);
		System.arraycopy(aes_countbye2, 0, beforeBase, aes_subenccontent.length + 4, 4);
		System.arraycopy(aes_countbye1, 0, beforeBase, aes_subenccontent.length + 8, 4);
		System.arraycopy(countbyte, 0, beforeBase, aes_subenccontent.length + 12, 4);
		System.arraycopy(endBytes, 0, beforeBase, aes_subenccontent.length + 16, 4);

		//System.out.println(Arrays.toString(beforeBase));

		rslt = plaincontent.substring(0, 51) + enccontent.substring(0, 1) + (new BASE64Encoder()).encode(beforeBase) + plaincontent.substring(51);
		return rslt;
	}
	
	public static byte[] AESEncryptByKeyIV(byte[] data, byte[] keyIV) {
		byte[] keyByte = new byte[16];
		byte[] IVByte = new byte[16];
		System.arraycopy(keyIV, 16, keyByte, 0, 16);
		System.arraycopy(keyIV, 0, IVByte, 0, 16);
		return AESEncrypt(data, IVByte, keyByte);
	}
	
	public static byte[] AESEncrypt(byte[] data, byte[] IV, byte[] keyByte) {
		byte[] result = null;

		SecretKeySpec aesKey = new SecretKeySpec(keyByte, "AES");
		Cipher cipher;
		try {
			if (data.length % 16 == 0)
				cipher = Cipher.getInstance("AES/CBC/NoPadding");
			else {
				cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			}
			cipher.init(1, aesKey, new IvParameterSpec(IV));
			result = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String encode(String str) {
		int i = 0;
		if (str == null || str.length() != str.getBytes().length) {
			return null;
		}
		String str2 = "";
		byte[] bytes = str.getBytes();
		for (int i2 = 0; i2 < bytes.length; i2++) {
			int i3 = i2 & 7;
			if (i3 == 0) {
				i = bytes[i2];
			} else {
				byte b = (byte) (i | (bytes[i2] << (8 - i3)));
				i = (bytes[i2] >> i3);
				byte b2 = (byte) i;
				str2 = str2 + byte2hexString(b);
				if (i2 == bytes.length - 1) {
					str2 = str2 + byte2hexString(b2);
				}
			}
		}
		return str2.toUpperCase();
	}
	
	public static String byte2hexString(byte b) {
		String toHexString = Integer.toHexString(b & 255);
		return toHexString.length() == 1 ? '0' + toHexString : toHexString;
	}
	
	public static byte char2byte(char arg1) {
		return ((byte) "0123456789ABCDEF".indexOf(arg1));
	}
}
