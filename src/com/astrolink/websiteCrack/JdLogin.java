﻿package com.astrolink.websiteCrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Random;

import javax.crypto.Cipher;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.params.HttpClientParams;

import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.PostNetWork_singleton;
import com.astrolink.util.tools.business.SSL.defaultSSL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JdLogin {
	//private static String charset = "utf-8";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
		httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY); 
		httpclient.getParams().setParameter("http.protocol.single-cookie-header", true); 
		String loginInfo = "";

		String execTime = BasicsTools.nDaysAfterOneDateString(BasicsTools.getForDate("yyyy-MM-dd"), -1);//.replaceAll("-", "");
		System.out.println(execTime);

		String loginUrl = "http://117.136.128.54:8092/prm/portal/login_inner.jsp";// 访问首页
		String refererUrl = loginUrl;
		String html0 = post_doNetWork(loginUrl, null, "utf-8", null, httpclient);
		System.out.println(html0);

		String ticket = html0.split("P_TICKET=\"")[1].split("\";")[0];
		String token = html0.split("TOKENS = \"")[1].split(",")[0];
		System.out.println(ticket);
		System.out.println(token);
		ticket=URLEncoder.encode(ticket);

		String hex = "00888ffceecf1e11841a7f0758d40e78de2c052f74fb75efe4b8624eccebb08b374ef868821b3114a106eea9209ace9e276011286445c1f6f178fefee945edfa2c2edd883991ca9fcdcdc0d4e512f2d6f6c1457844cdfb686451f8e644f67a801df3a1631a88e9ea9d04fc78dc7861d898b4d613e0a3cbbc5de60c6734f200c457";
		String passwordD = "";
		try {
			RSAPublicKey aa = getPublicKey(hex, "010001");
			System.out.println(aa.toString());
			passwordD = encryptByPublicKey("seny90698", aa);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println(passwordD);

		String modifyLoginUrl = "http://117.136.128.54:8092/prm_server/authprm/modifyLogin.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token=" + token;// 登陆
		NameValuePair[] modifyostData = { new NameValuePair("accountApply.accountName", "北京亚谷网讯科技有限01"), new NameValuePair("accountApply.password", passwordD) };
		loginInfo = post_doNetWork(modifyLoginUrl, modifyostData, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);

		String authenticateUrl = "http://117.136.128.54:8092/prm/login.ajax?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token=" + token;// 登陆
		NameValuePair[] postData = { new NameValuePair("loginName", "北京亚谷网讯科技有限01"), new NameValuePair("password", passwordD), };
		loginInfo = post_doNetWork(authenticateUrl, postData, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		String main = "http://117.136.128.54:8092/prm/portal/main.jsp";
		loginInfo = post_doNetWork(main, null, "utf-8", refererUrl, httpclient);
		refererUrl = authenticateUrl;
		System.out.println(loginInfo);
		
		String homepage = "http://117.136.128.54:8092/prm/portal/homepage.jsp";
		loginInfo = post_doNetWork(homepage, null, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		
		/*String spApply = "http://218.206.191.22/prm_server/preq/spApply!doList.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
		loginInfo = post_doNetWork(spApply, null, cookie, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		String announceList = "http://218.206.191.22/prm_server/announce/announceList!spList.action?announcement.status=A&ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
		loginInfo = post_doNetWork(announceList, null, cookie, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);*/
		
		String sp_business_list = "http://117.136.128.54:8092/prm/preq/sp/business/sp_business_list.jsp";
		loginInfo = post_doNetWork(sp_business_list, null, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		String businessSpList = "http://117.136.128.54:8092/prm_server/business/business!businessSpList.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
		loginInfo = post_doNetWork(businessSpList, null, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		JSONObject businessSpListJson=JSONObject.fromObject(loginInfo).getJSONObject("data");
		JSONObject spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(0);
		if(spPlatforms.toString().indexOf("和游戏开放平台")==-1) {
			spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(1);
			if(spPlatforms.toString().indexOf("和游戏开放平台")==-1) {
				spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(2);
			}
		}
		System.out.println(spPlatforms);
		JSONObject platformList=spPlatforms.getJSONArray("platformList").getJSONObject(0);
		String platformId=platformList.getString("platformId");
		String spId=platformList.getJSONArray("spPlatformList").getJSONObject(0).getString("spId");
		String businessRedirect = "http://117.136.128.54:8092/prm_server/business/business!businessRedirect.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
		NameValuePair[] businessRedirectData = { new NameValuePair("spPlatform.spId", spId), new NameValuePair("spPlatform.platformId",platformId) };
		loginInfo = post_doNetWork(businessRedirect, businessRedirectData, "utf-8", refererUrl, httpclient);
		
		System.out.println(loginInfo);
		
		JSONObject businessRedirectJson=JSONObject.fromObject(loginInfo);
		//{"data":{"linkUrl":"http:\/\/g.10086.cn\/open\/redirect\/prmLogin.do?ticket=dea43fde-9ffb-4799-976d-315e5dd1080c%261470110666949"},"success":true}
		String prmLogin = businessRedirectJson.getJSONObject("data").getString("linkUrl");
		loginInfo = post_doNetWork(prmLogin, null, "utf-8", refererUrl, httpclient);
		refererUrl = prmLogin;
		System.out.println(loginInfo);

		String common = "http://g.10086.cn/open/common.do?method=getSystemLink";
		loginInfo = post_doNetWork(common, null, "utf-8", refererUrl, httpclient);
		
		String clickCount = "http://g.10086.cn/open/clickLog/clickCount.do";
		NameValuePair[] clickCountData = { 
				new NameValuePair("open_module", "业务管理-总览"),
				new NameValuePair("open_project", "经营分析平台跳转"),
				new NameValuePair("open_project_number", "B1-3"),
				new NameValuePair("open_project_name", "经营分析平台跳转"),
				new NameValuePair("open_project_id", "B1-3"),
				new NameValuePair("open_url","http://g.10086.cn/open/transactionMg.do?method=showView")
				};
		loginInfo = post_doNetWork(clickCount, clickCountData, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		/*String egbi = "http://oss.cmgame.com/egbi/login";
		loginInfo = post_doNetWork(egbi, null, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);*/
		
		String footer = "http://g.10086.cn/open/common.do?method=getSystemLink&aN93iu=";
		loginInfo = post_doNetWork(footer, null, "utf-8", refererUrl, httpclient);
		System.out.println(loginInfo);
		
		
		String egbiLogin = "http://g.10086.cn/open/redirectSystem.do?systemSign=EGBI";
		loginInfo = post_doNetWork(egbiLogin, null, "utf-8", refererUrl, httpclient);
		refererUrl = prmLogin;
		System.out.println(loginInfo);
		
		
		String fixedReport = "http://oss.cmgame.com/egbi/fixedReport.do?merge_id=13743&merge_title=%E9%80%89%E6%8B%A9%E6%8A%A5%E8%A1%A8%E5%91%A8%E6%9C%9F";
		loginInfo = post_doNetWork(fixedReport, null, "utf-8", refererUrl, httpclient);
		refererUrl = prmLogin;
		System.out.println(loginInfo);
		
		System.out.println("========================================================================================");
		
		String fixedReporturl = "http://oss.cmgame.com/egbi/fixedReport.do";
		NameValuePair[] fixedReportData = { 
				new NameValuePair("search",""),
				new NameValuePair("exportCsv",""),
				new NameValuePair("currentPage","1"),
				new NameValuePair("limit","15"),
				new NameValuePair("SUM_DAY_start", execTime),
				new NameValuePair("SUM_DAY_end", execTime),
				new NameValuePair("PROVINCE_chk", "1"),
				new NameValuePair("CITY_chk", "1"),
				new NameValuePair("SPCODE_chk", "1"),
				new NameValuePair("SPCODE_value", ""),
				new NameValuePair("CPSERVICEID_chk", "1"),
				new NameValuePair("CPSERVICEID_value", ""),
				new NameValuePair("CHANNELCORP_chk", "1"),
				new NameValuePair("CHANNELCORP_value", ""),
				new NameValuePair("CHANNELID_chk", "1"),
				new NameValuePair("CHANNELID_value", ""),
				new NameValuePair("IPCORPCODE_chk", "1"),
				new NameValuePair("IPCORPCODE_value", ""),
			};
		String excelInfo = post_doNetWork(fixedReporturl, fixedReportData, "utf-8", refererUrl, httpclient);
		System.out.println(excelInfo);
		
		NameValuePair[] fixedData = { 
				new NameValuePair("exportCsv",""),
				new NameValuePair("currentPage","1"),
				new NameValuePair("limit","15"),
				new NameValuePair("SUM_DAY_start", execTime),
				new NameValuePair("SUM_DAY_end", execTime),
				new NameValuePair("PROVINCE_chk", "1"),
				new NameValuePair("CITY_chk", "1"),
				new NameValuePair("SPCODE_chk", "1"),
				new NameValuePair("SPCODE_value", ""),
				new NameValuePair("CPSERVICEID_chk", "1"),
				new NameValuePair("CPSERVICEID_value", ""),
				new NameValuePair("CHANNELCORP_chk", "1"),
				new NameValuePair("CHANNELCORP_value", ""),
				new NameValuePair("CHANNELID_chk", "1"),
				new NameValuePair("CHANNELID_value", ""),
				new NameValuePair("IPCORPCODE_chk", "1"),
				new NameValuePair("IPCORPCODE_value", ""),
			};
		InputStream exelIo= post_doNetWorkIO(fixedReporturl, fixedData, null, httpclient);
		// 存储图片

		String uuid=BasicsTools.getUuid(false, 16, new Random());
		String filePath = "." + File.separator + "uuCode" + File.separator + "jd" + File.separator + uuid + ".xls";
		File img = new File(filePath);
		try {
			if (!img.exists()) {
				img.createNewFile();
			}

			FileOutputStream fos = new FileOutputStream(filePath);
			byte[] b = new byte[1024];
			while((exelIo.read(b)) != -1){
				fos.write(b);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("文件名为:"+img.getName());
		
		//处理投诉
		String open = "http://g.10086.cn/open/announ.do?method=queryMsg&aN93iu=";
		NameValuePair[] openData = {
				new NameValuePair("page", "1"),
				new NameValuePair("count", "1"),
				new NameValuePair("startTime", execTime),
				new NameValuePair("endTime", execTime),
				new NameValuePair("status", ""),
				new NameValuePair("title","分省一线全量投诉"),
				new NameValuePair("bulletinType","0")
				};
		loginInfo = post_doNetWork(open, openData, "utf-8", refererUrl, httpclient);
		JSONArray json = JSONObject.fromObject(loginInfo).getJSONArray("rows");
		
		String bulletinID = "";
		if(json.size()>0) {
			bulletinID = (String) json.getJSONObject(0).get("bulletinID");
			System.out.println(bulletinID);
			
			String detail = "http://g.10086.cn/open/bulletinDetail.do?method=bulletinDetail&aN93iu=";
			NameValuePair[] detailDate = {
				new NameValuePair("bulletinType","0"),
				new NameValuePair("bulletinID",bulletinID)
			};
			loginInfo = post_doNetWork(detail, detailDate, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			JSONObject bulletinAttachs = JSONObject.fromObject(loginInfo).getJSONArray("bulletinAttachs").getJSONObject(0);
			String fileName = bulletinAttachs.getString("attachName");
			String attachURL = bulletinAttachs.getString("attachURL");
			try {
				String fileNameUrl = URLEncoder.encode(fileName,"utf-8");
				String downAttch = "http://g.10086.cn/open/bulletinDetail/downAttch.do?filename="+fileNameUrl+"&attchUrl="+attachURL;
				NameValuePair[] downAttchData = {
					new NameValuePair("filename",fileName),
					new NameValuePair("attchUrl",attachURL)
				};
				post_doNetWork(downAttch, downAttchData, "utf-8", refererUrl, httpclient);
				InputStream exelIo2= post_doNetWorkIO(downAttch, downAttchData, null, httpclient);
				// 存储exel
				String complaintPath =  "." + File.separator + "uuCode" + File.separator + uuid +fileName+ ".xls";
				File complaintFile = new File(complaintPath);
				if (!complaintFile.exists()) {
					complaintFile.createNewFile();
				}

				FileOutputStream fos1 = new FileOutputStream(complaintPath);
				byte[] ab = new byte[1024];
				while((exelIo2.read(ab)) != -1){
					fos1.write(ab);
				}
				fos1.close();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else {
			System.out.println("没有投诉");
		}
		
	}
	
	private static InputStream post_doNetWorkIO(String netURL,NameValuePair[] postData,String Referer,HttpClient httpclient) {
		PostNetWork_singleton postNetWork =null;
		InputStream result=null;
		try {
			postNetWork=new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);
			
			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests","1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");
			
			if(Referer!=null){
				postNetWork.getPostMethod().addRequestHeader("Referer", Referer);
			}
			
			if(postData!=null){
				postNetWork.setPostData(postData);
			}
			
			
			postNetWork.executeMethod();
		 	result = postNetWork.getInputStream();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}

	public static String[] httpUuGetCode(String filePath, InputStream CheckCode) {
		// 存储图片

		File img = new File(filePath);

		try {
			if (!img.exists()) {
				img.createNewFile();
			}

			FileOutputStream fos = new FileOutputStream(filePath);
			byte[] b = new byte[1024];
			while ((CheckCode.read(b)) != -1) {
				fos.write(b);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 这里接打码平台
		return BasicsTools.httpUuGetCode(filePath);

	}

	private static String post_doNetWork(String netURL, NameValuePair[] postData, String charsetName, String Referer, HttpClient httpclient) {
		PostNetWork_singleton postNetWork = null;
		String result = "";
		try {
			postNetWork = new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);

			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests", "1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");

			if (Referer != null) {
				postNetWork.getPostMethod().addRequestHeader(Referer, Referer);
			}

			if (postData != null) {
				postNetWork.setPostData(postData);
			}
//			String[] Proxy ="127.0.0.1:1080".split(":");
//			postNetWork.setProxyHost(Proxy[0]);
//			postNetWork.setProxyPort(Integer.parseInt(Proxy[1]));
//			postNetWork.executeMethod(true);
			postNetWork.executeMethod();
			result = postNetWork.getHtml(charsetName);

			int netState = postNetWork.getNetState();
			System.out.println(netState);
			if (netState == 302) {
				Header loca = postNetWork.getPostMethod().getResponseHeader("location");
				String strLoca = loca.getValue();
				System.out.println("location：" + strLoca);
				result = post_doNetWork(strLoca, null, "utf-8", netURL, httpclient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}

	

	/**
	 * 拆分字符串
	 */
	public static String[] splitString(String string, int len) {
		int x = string.length() / len;
		int y = string.length() % len;
		int z = 0;
		if (y != 0) {
			z = 1;
		}
		String[] strings = new String[x + z];
		String str = "";
		for (int i = 0; i < x + z; i++) {
			if (i == x + z - 1 && y != 0) {
				str = string.substring(i * len, i * len + y);
			} else {
				str = string.substring(i * len, i * len + len);
			}
			strings[i] = str;
		}
		return strings;
	}

	/**
	 * BCD转字符串
	 */
	public static String bcd2Str(byte[] bytes) {
		char temp[] = new char[bytes.length * 2], val;

		for (int i = 0; i < bytes.length; i++) {
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}

	/*
	 * 公钥加密
	 * 
	 * @param data
	 * 
	 * @param publicKey
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data, RSAPublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		// 模长
		int key_len = publicKey.getModulus().bitLength() / 8;
		// 加密数据长度 <= 模长-11
		String[] datas = splitString(data, key_len - 11);
		String mi = "";
		// 如果明文长度大于模长-11则要分组加密
		for (String s : datas) {
			mi += bcd2Str(cipher.doFinal(s.getBytes()));
		}
		return mi;
	}

	/**
	 * 使用模和指数生成RSA公钥
	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
	 * /None/NoPadding】
	 * 
	 * @param modulus
	 *            模
	 * @param exponent
	 *            指数
	 * @return
	 */
	public static RSAPublicKey getPublicKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus, 16);
			BigInteger b2 = new BigInteger(exponent, 16);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
