package com.astrolink.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.MusicExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.MusicTools;
import com.astrolink.util.tools.OwnBase64;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.sun.rowset.CachedRowSetImpl;

import net.sf.json.JSONObject;

/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class MusicExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(MusicExecLinstenerThreadDao.class);
	private String dbTableName;
	public MusicExecLog musicExecLog;
	public IExecFinish execFinish;
	
	public MusicExecLinstenerThreadDao(MusicExecLog musicExecLog){
		this.musicExecLog = musicExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		String doChargeStatus="";
		int payStepNum=0;
		String message="";
		String transId="";
		String phoneNumber="";
		String en_session="";
		StringBuffer logBuff=new StringBuffer();
		logBuff.append("开始音乐计费确认,id为" + this.getKey()+";imsi:"+musicExecLog.getImsi());
		try{
			MusicTools mt = new MusicTools();
			byte[] Key1=mt.hexString2Bytes(musicExecLog.getKey1());
			byte[] Key2=mt.hexString2Bytes(musicExecLog.getKey2());
			
			String excode=musicExecLog.getExcode();
			String definedseq=musicExecLog.getCpparam();
			String UA="";
			String uasql="SELECT CONCAT(NAME,'_',TYPE) AS UA FROM spinfo.model_info  ORDER BY RAND() LIMIT 1";
			DbTools dt=new  DbTools(Const.DB_MUSIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_MUSIC_USERNAME,Const.DB_MUSIC_PASSWORD);
			CachedRowSetImpl crsi = dt.executeQuery(uasql, MusicExecLinstenerThreadDao.class);
			if(crsi!=null && crsi.next()){
				UA=crsi.getString("UA");
			}
			
			logBuff.append("|第一步：获取cpparam");
			logBuff.append(",UA:"+UA);
			String md5imsi = mt.md52String32(musicExecLog.getImsi().getBytes());

			// String timeStamp = System.currentTimeMillis()/1000+"";
			// timeStamp = "1449557499";
			// System.out.println(timeStamp);
			// generateMuisicLoginSms(md5imsi,miguopen_appid,DeviceId,timeStamp,excode);
			//
			String checksmsinitreturn_rsp = mt.post_checksmsinitreturn_req(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(),excode,UA,logBuff);
			doChargeStatus = mt.getContextByTag(checksmsinitreturn_rsp, "return_code",logBuff);
			if (!doChargeStatus.equals("0")){
				message = mt.getContextByTag(checksmsinitreturn_rsp, "return_desc",logBuff);
				return;
			}

			String target = "";
			String body = "";
			String musicId = "";

			if (musicExecLog.getMode() == 0) {// 包月
				String query_rsp = mt.post_query_req(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(), musicExecLog.getPackageName(), excode,definedseq, UA,musicExecLog.getServiceId(),logBuff);
				doChargeStatus = mt.getContextByTag(query_rsp, "resCode",logBuff);
				if (!doChargeStatus.equals("300002"))
					return;
				String serviceEx_rsp = mt.post_serviceEx_req(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA,musicExecLog.getServiceId(),logBuff);

				target = "\\/1.0\\/cp\\/open";
				body = "<?xml version='1.0' encoding='UTF-8'?><request><serviceId>" + musicExecLog.getServiceId() + "<\\/serviceId><\\/request>";
			} else if (musicExecLog.getMode() == 1) {// 彩铃-订购彩铃
				musicId = musicExecLog.getServiceId();
				String post_crbt_info_rsp = mt.post_crbt_info(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA, musicId,logBuff);
				doChargeStatus = mt.getContextByTag(post_crbt_info_rsp, "resCode",logBuff);
				if (!doChargeStatus.equals("000000"))
					return;
				// {"target":"\/1.0\/crbt\/order","body":"<?xml version='1.0'
				// encoding='UTF-8'?><request><musicId>600902000009415022<\/musicId><\/request>","header":"OEPAUTH
				// realm=\"OEP\",IMSI=\"9C390DDA7CA6A8D15D6A6B0F232A2A96\",appID=\"007909429230102593\",pubKey=\"04355A61019679D8246184AF98ABFDB0\",netMode=\"WIFI\",packageName=\"com.joemusic\",version=\"M1.3\",excode=\"null\",definedseq=\"null\""}
				target = "\\/1.0\\/crbt\\/order";
				body = "<?xml version='1.0' encoding='UTF-8'?><request><musicId>" + musicId + "<\\/musicId><\\/request>";
			} else {
				// 获取排行榜
			/*	String search_chart_list_rsp = mt.post_search_chart_list(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA,logBuff);
				int resCounter = Integer.valueOf(mt.getContextByTag(search_chart_list_rsp, "resCounter",logBuff));
				String[] search_music_listbychart_rsp = new String[resCounter];
				String chartCode = "";
				String search_chart_list_rsp_copy = search_chart_list_rsp;
				// 获取各个排行榜信息
				for (int i = 0; i < resCounter; i++) {
					chartCode = mt.getContextByTag(search_chart_list_rsp_copy, "chartCode",logBuff);
					search_music_listbychart_rsp[i] = mt.post_search_music_listbychart(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA, chartCode,logBuff);
					search_chart_list_rsp_copy = search_chart_list_rsp_copy.substring(search_chart_list_rsp_copy.indexOf(chartCode) + "</chartCode><chartName>".length());
				}*/
				//int n = 0;
				//musicId = mt.getContextByTag(search_music_listbychart_rsp[n], "musicId",logBuff);// 这里修改
																						// 即可该用对应的
				//String lrcDir = mt.getContextByTag(search_music_listbychart_rsp[n], "lrcDir",logBuff);
				//mt.get_lyric(lrcDir,logBuff);
				musicId = musicExecLog.getServiceId();
				
				if (musicExecLog.getMode() == 2) {// 歌曲-订购彩铃
					String post_crbt_info_rsp = mt.post_crbt_info(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA, musicId,logBuff);
					doChargeStatus = mt.getContextByTag(post_crbt_info_rsp, "resCode",logBuff);
					if (!doChargeStatus.equals("000000"))
						return;
					String bizCode = mt.getContextByTag(post_crbt_info_rsp, "bizCode",logBuff);
					
					musicExecLog.setItemId(bizCode);
					// {"target":"\/1.0\/crbt\/order","body":"<?xml version='1.0'
					// encoding='UTF-8'?><request><musicId>4137bc8850bc06292b5c707b859751ab<\/musicId><\/request>","header":"OEPAUTH
					// realm=\"OEP\",IMSI=\"9C390DDA7CA6A8D15D6A6B0F232A2A96\",appID=\"007909429230102593\",pubKey=\"04355A61019679D8246184AF98ABFDB0\",netMode=\"WIFI\",packageName=\"com.joemusic\",version=\"M1.3\",excode=\"null\",definedseq=\"null\""}
					target = "\\/1.0\\/crbt\\/order";
					body = "<?xml version='1.0' encoding='UTF-8'?><request><musicId>" + musicId + "<\\/musicId><\\/request>";
				} else if (musicExecLog.getMode() == 3) {// 歌曲-下载全曲
					String post_song_policy_rsp = mt.post_song_policy(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA, musicId,logBuff);
					doChargeStatus = mt.getContextByTag(post_song_policy_rsp, "resCode",logBuff);
					if (!doChargeStatus.equals("000000"))
						return;
					String bizCode = mt.getContextByTag(post_song_policy_rsp, "bizCode",logBuff);
					musicExecLog.setItemId(bizCode);
					
					String biztype = mt.getContextByTag(post_song_policy_rsp, "biztype",logBuff);
					String codeRate = "0"; // 0-标清版（40kbps） 1-高清版（128kbps） 2-杜比高清版
											// // 下载全曲有 0 1 2 //下载振铃只有 0 1
					mt.post_user_query(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA,logBuff);

					// {"target":"\/1.0\/song\/downlink","body":"<?xml version='1.0'
					// encoding='UTF-8'?><request><musicId>4137bc8850bc06292b5c707b859751ab<\/musicId><bizCode>600907002000068284<\/bizCode><biztype>11<\/biztype><codeRate>2<\/codeRate><\/request>","header":"OEPAUTH
					// realm=\"OEP\",IMSI=\"9C390DDA7CA6A8D15D6A6B0F232A2A96\",appID=\"007909429230102593\",pubKey=\"04355A61019679D8246184AF98ABFDB0\",netMode=\"WIFI\",packageName=\"com.joemusic\",version=\"M1.3\",excode=\"null\",definedseq=\"null\""}
					target = "\\/1.0\\/song\\/downlink";
					body = "<?xml version='1.0' encoding='UTF-8'?><request><musicId>" + musicId + "<\\/musicId><bizCode>" + bizCode + "<\\/bizCode><biztype>" + biztype + "<\\/biztype><codeRate>" + codeRate + "<\\/codeRate><\\/request>";
				} else if (musicExecLog.getMode() == 4) {// 歌曲-下载振铃
					String post_ring_policy_rsp = mt.post_ring_policy(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName(), excode, definedseq, UA, musicId,logBuff);
					doChargeStatus = mt.getContextByTag(post_ring_policy_rsp, "resCode",logBuff);
					if (!doChargeStatus.equals("000000"))
						return;
					String bizCode = mt.getContextByTag(post_ring_policy_rsp, "bizCode",logBuff);
					musicExecLog.setItemId(bizCode);
					
					String biztype = mt.getContextByTag(post_ring_policy_rsp, "biztype",logBuff);
					String codeRate = "0"; // 0-标清版（40kbps） 1-高清版（128kbps） 2-杜比高清版
											// // 下载全曲有 0 1 2 //下载振铃只有 0 1
					mt.post_user_query(md5imsi,musicExecLog.getMiguopen_appid(),musicExecLog.getPubKey(),musicExecLog.getPackageName() , excode, definedseq, UA,logBuff);

					// {"target":"\/1.0\/ring\/downlink","body":"<?xml version='1.0'
					// encoding='UTF-8'?><request><musicId>4137bc8850bc06292b5c707b859751ab<\/musicId><bizCode>600907000000067080<\/bizCode><biztype>11<\/biztype><codeRate>1<\/codeRate><\/request>","header":"OEPAUTH
					// realm=\"OEP\",IMSI=\"9C390DDA7CA6A8D15D6A6B0F232A2A96\",appID=\"007909429230102593\",pubKey=\"04355A61019679D8246184AF98ABFDB0\",netMode=\"WIFI\",packageName=\"com.joemusic\",version=\"M1.3\",excode=\"null\",definedseq=\"null\""}
					target = "\\/1.0\\/ring\\/downlink";
					body = "<?xml version='1.0' encoding='UTF-8'?><request><musicId>" + musicId + "<\\/musicId><bizCode>" + bizCode + "<\\/bizCode><biztype>" + biztype + "<\\/biztype><codeRate>" + codeRate + "<\\/codeRate><\\/request>";
				} else if (musicExecLog.getMode() == 5) {
					String serviceEx_rsp = mt.post_serviceEx_req(md5imsi, musicExecLog.getMiguopen_appid(),
							musicExecLog.getPubKey(), musicExecLog.getPackageName(), excode, definedseq, UA, musicId,logBuff);

					String itemId = mt.getContextByTag(serviceEx_rsp, "serviceId",logBuff);
					musicExecLog.setItemId(itemId);

					target = "\\/1.0\\/exclusive\\/open";
					body = "<?xml version='1.0' encoding='UTF-8'?><request><serviceId>"
							+ musicId + "<\\/serviceId><\\/request>";
				}

			}


			String cpparamAuthorization = "OEPAUTH realm=\\\"OEP\\\",IMSI=\\\"" + md5imsi + "\\\",appID=\\\"" + musicExecLog.getMiguopen_appid() + "\\\",pubKey=\\\"" + musicExecLog.getPubKey() + "\\\",netMode=\\\"WIFI\\\",packageName=\\\"" +musicExecLog.getPackageName() + "\\\",version=\\\"M1.3\\\",excode=\\\"";
			if (!String.valueOf(excode).equals(""))
				cpparamAuthorization += excode;
			else
				cpparamAuthorization += "null";
			cpparamAuthorization += "\\\",definedseq=\\\"";
			
			String cpparam="";
			if (musicExecLog.getMode() == 5) {
				cpparamAuthorization += musicExecLog.getCpparam();
				cpparamAuthorization += "\\\"";
				cpparam = "{\"target\":\"" + target
						+ "\",\"noInterface\":true,\"body\":\"" + body
						+ "\",\"header\":\"" + cpparamAuthorization + "\"}";
			}else{
				if (!String.valueOf(definedseq).equals(""))
					cpparamAuthorization += definedseq;
				else
					cpparamAuthorization += "null";
				cpparamAuthorization += "\\\"";

				cpparam = "{\"target\":\"" + target + "\",\"body\":\"" + body + "\",\"header\":\"" + cpparamAuthorization + "\"}";
			}
			

			logBuff.append(cpparam);
			cpparam = Base64.encode(cpparam.getBytes());
			if(cpparam==null || cpparam.equals("")){
				logBuff.append(",获取cpparam失败");
				return;
			}
			payStepNum++;
			
			
			excode=musicExecLog.getChid();
			
			logBuff.append(",第二步：发送session");
			String requestTime = mt.getRequestTime();
			String enreq1 = mt.generate_enreq1(musicExecLog.getCtype(), musicExecLog.getAppid(), musicExecLog.getImsi(),musicExecLog.getImei(),musicExecLog.getEncodeCID(),musicExecLog.getRand16Num(),musicExecLog.getTimeStamp(),musicExecLog.getCpid(),musicExecLog.getContentId(),musicExecLog.getChid(),musicExecLog.getSdksessionid(),musicExecLog.getApkstatus(), requestTime, cpparam,Key1,Key2,logBuff);
			String req1singature = mt.getHmacSHA1("+15BFidS}7/+POST+en_sessionreq=" + enreq1 + "&apiVersion=1.0&SDKVersion=12001000", "15BFidS}7/&");
			mt.post_getSession1(musicExecLog.getImsi(), musicExecLog.getImei(), req1singature, enreq1,logBuff);
			
			requestTime = mt.getRequestTime();
			String enreq2 = mt.generate_enreq2(musicExecLog.getCtype(),musicExecLog.getAppid(),musicExecLog.getImsi(),musicExecLog.getImei(),musicExecLog.getEncodeCID(),musicExecLog.getRand16Num(),musicExecLog.getTimeStamp(),musicExecLog.getCpid(),musicExecLog.getContentId(),musicExecLog.getChid(),musicExecLog.getSdksessionid(),musicExecLog.getApkstatus(), requestTime, cpparam,Key1,Key2,logBuff);
			String req2singature = mt.getHmacSHA1("+15BFidS}7/+POST+en_sessionreq=" + enreq2 + "&apiVersion=1.0&SDKVersion=12001000", "15BFidS}7/&");
			String sessionrep = mt.post_getSession2(musicExecLog.getImsi(), musicExecLog.getImei(), req2singature, enreq2,logBuff);
			en_session = mt.getContextByTag(sessionrep, "en_session",logBuff);
			if (en_session.equals("")){
				doChargeStatus = mt.getContextByTag(sessionrep, "status",logBuff);
				message = mt.getContextByTag(sessionrep, "message",logBuff);
				logBuff.append(",发送session失败");
				return;
			}
			payStepNum++;
			
			logBuff.append(",第三步：计费");
			String itemExt="";
			String itemMethod = mt.getitemMethod(musicExecLog.getItemMethod());
			String de_session = mt.decode_RequestResponse(musicExecLog.getRand16Num(), en_session);
			String session = mt.getContextByTag(de_session, "session",logBuff);
			requestTime = mt.getRequestTime();

//			System.out.println(musicExecLog);
			String enreq3 = mt.generate_enreq3(musicExecLog.getCtype(),musicExecLog.getAppid(),musicExecLog.getImsi(),musicExecLog.getImei(),musicExecLog.getEncodeCID(),musicExecLog.getRand16Num(),musicExecLog.getTimeStamp(),musicExecLog.getCpid(),musicExecLog.getContentId(),musicExecLog.getChid(),musicExecLog.getSdksessionid(),musicExecLog.getApkstatus(), requestTime, session,musicExecLog.getTransId(),musicExecLog.getItemId(),musicExecLog.getItemPrice(),musicExecLog.getItemSafeLevel(),itemMethod,itemExt, cpparam,Key1,Key2,logBuff);
			String req3singature = mt.getHmacSHA1("+15BFidS}7/+POST+ctype=" + musicExecLog.getCtype() + "&en_billingreq=" + enreq3 + "&transId=" + musicExecLog.getTransId() + "&apiVersion=1.0&SDKVersion=12001000", "15BFidS}7/&");
			String chargerep = mt.post_doCharge(musicExecLog.getImsi(), musicExecLog.getImei(), req3singature, enreq3, musicExecLog.getCtype(),musicExecLog.getTransId(),logBuff);

			//doChargeStatus = mt.getContextByTag(chargerep, "status",logBuff);
			//message = mt.getContextByTag(chargerep, "message",logBuff);
			phoneNumber = mt.getContextByTag(chargerep, "phoneNumber",logBuff);
			transId=mt.getContextByTag(chargerep, "transId",logBuff);
			
			doChargeStatus = mt.getContextByTag(chargerep, "status", logBuff);
			message = mt.getContextByTag(chargerep, "message", logBuff);
			logBuff.append(",doChargeStatus:"+doChargeStatus+",message:"+message);
			
			if(doChargeStatus.equals("0")){
				String returnExt = mt.getContextByTag(chargerep, "returnExt",logBuff);
				String returnExtBase64=OwnBase64.getFromBase64(returnExt);
				
				if(returnExtBase64!=null && !returnExtBase64.equals("")){
					if(returnExtBase64.indexOf("<resCode>000000</resCode")!=-1){
						String downUrl=mt.getContextByTag(returnExtBase64, "downUrl",logBuff);
						if(downUrl!=null && !downUrl.equals("")){
							mt.downloadByURL(downUrl, logBuff);
						}
					}else{
						doChargeStatus=mt.getContextByTag(returnExtBase64, "resCode", logBuff);
						message=mt.getContextByTag(returnExtBase64, "resMsg", logBuff);
					}
				}
			}
			
			logBuff.append(",final_doChargeStatus:"+doChargeStatus);
			if (!doChargeStatus.equals("0")){
				logBuff.append(",计费失败");
			}
			payStepNum++;
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			try {
				if(payStepNum<3 && doChargeStatus.equals("0")){
					doChargeStatus="-1";
				}
				
				if (doChargeStatus.equals("0")){
					updataExecLog(musicExecLog.getId(),logBuff);
					sevePayResultLog(payStepNum,doChargeStatus,message,phoneNumber,transId,musicExecLog.getCrackSynUrl(),en_session,musicExecLog.getId(),logBuff);
				}else{
					if(musicExecLog.getExecNum()<Const.MUSIC_LOGIC_RETRY_NUM-1){
						updateExecNum(musicExecLog.getId(),logBuff);
					}else{
						updataExecLog(musicExecLog.getId(),logBuff);
						sevePayResultLog(payStepNum,doChargeStatus,message,phoneNumber,transId,musicExecLog.getCrackSynUrl(),en_session,musicExecLog.getId(),logBuff);
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
	
	public  void updateExecNum(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE ").append(dbTableName).append(" SET  execNum = execNum+1, updateDate='").append(BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss")).append("'  WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_MUSIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_MUSIC_USERNAME,Const.DB_MUSIC_PASSWORD);
		logBuff.append(",updateExecNum：" + dt.upDate(sqlBuff.toString(), MusicExecLinstenerThreadDao.class));
	}
	
	public  void deleteExecLog(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM ").append(dbTableName).append(" WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_MUSIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_MUSIC_USERNAME,Const.DB_MUSIC_PASSWORD);
		logBuff.append(",deleteExecLog：" + dt.upDate(sqlBuff.toString(), MusicExecLinstenerThreadDao.class));
	}
	
	public  void updataExecLog(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("DELETE FROM exec_log WHERE id = '").append(id).append("'");
		DbTools dt=new  DbTools(Const.DB_MUSIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_MUSIC_USERNAME,Const.DB_MUSIC_PASSWORD);
		logBuff.append(",deleteExecLog：" + dt.upDate(sqlBuff.toString(), MusicExecLinstenerThreadDao.class));
	}
	
	public void sevePayResultLog(int payStepNum,String status,String message,String phoneNumber,String transId,String crackSynUrl,String en_session,long execLogId,StringBuffer logBuff){
		JSONObject dataInfo=new JSONObject();
		dataInfo.put("payStepNum", payStepNum);
		dataInfo.put("execLogId", execLogId);
		if(status==null || status.equals("")){
			status="-1";
		}
		dataInfo.put("status", status);
		dataInfo.put("message", message);
		dataInfo.put("en_session", en_session);
		dataInfo.put("imei", musicExecLog.getImei());
		dataInfo.put("imsi", musicExecLog.getImsi());
		dataInfo.put("monum", musicExecLog.getMonum());
		dataInfo.put("consumeCode", musicExecLog.getConsumeCode());
		dataInfo.put("cpparam", musicExecLog.getCpparam());
		dataInfo.put("execNum", musicExecLog.getExecNum());
		if(phoneNumber==null || phoneNumber.equals("")){
			phoneNumber="0";
		}
		dataInfo.put("phoneNumber", phoneNumber);
		dataInfo.put("cpInfoId", musicExecLog.getCpInfoId());
		if(!transId.equals("")){
			dataInfo.put("transId", transId);
		}else{
			dataInfo.put("transId", musicExecLog.getRand16Num()+musicExecLog.getTimeStamp());
		}
		
		
		dataInfo.put("dayTime", BasicsTools.getForDate("yyyy-MM-dd"));
		dataInfo.put("inputDate", BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss"));	
		dataInfo.put("methodType", musicExecLog.getMethodType());
		dataInfo.put("spProductConsumeCodeId", musicExecLog.getSpProductConsumeCodeId());
		dataInfo.put("channelId", "0");
		try {
			crackSyn(dataInfo,crackSynUrl(dataInfo,crackSynUrl,logBuff),logBuff);
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}
		DbTools dt=new  DbTools(Const.DB_MUSIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_MUSIC_USERNAME,Const.DB_MUSIC_PASSWORD);
		logBuff.append(",sevePayResultLog：" + dt.insertJson(Const.MUSIC_TABLE_PAY_RESULT_LOG, dataInfo, MusicExecLinstenerThreadDao.class));
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
		sbuff.append("&").append("spProductConsumeCodeId=").append(dataInfo.optString("spProductConsumeCodeId"));
		try {
			sbuff.append("&").append("message=").append(URLEncoder.encode(dataInfo.optString("message"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			logBuff.append(",crackSynUrl:"+ExceptionTools.exception(e));
		}
		return sbuff.toString();
	}
}
