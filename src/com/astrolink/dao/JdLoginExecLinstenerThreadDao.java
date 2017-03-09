package com.astrolink.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.DmLogin;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.PostNetWork_singleton;
import com.astrolink.util.tools.business.SSL.defaultSSL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JdLoginExecLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(JdLoginExecLinstenerThreadDao.class);
	public DmLogin dmLogin;
	public IExecFinish execFinish;
	public Map<Object,Object> map;
	
	public JdLoginExecLinstenerThreadDao(DmLogin dmLogin) {
		this.dmLogin = dmLogin;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	
	public void setDbTableName(String dbTableName) {
	}
	
	
	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}

	@Override
	public void exec() {
		try {
			HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
			File incomeFile = null;
			File complaintFile = null;
			String loginInfo = "";

			httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			httpclient.getParams().setParameter("http.protocol.single-cookie-header", true); 

			String execTime = BasicsTools.nDaysAfterOneDateString(BasicsTools.getForDate("yyyy-MM-dd"), -1);//.replaceAll("-", "");
			System.out.println(execTime);

			String loginUrl = dmLogin.getAddress();// 访问首页
			String refererUrl = loginUrl;
			String html0 = post_doNetWork(loginUrl, null, "utf-8", null, httpclient);

			String ticket = html0.split("P_TICKET=\"")[1].split("\";")[0];
			String token = html0.split("TOKENS = \"")[1].split(",")[0];
			System.out.println(ticket);
			System.out.println(token);
			ticket=URLEncoder.encode(ticket);

			String hex = "00888ffceecf1e11841a7f0758d40e78de2c052f74fb75efe4b8624eccebb08b374ef868821b3114a106eea9209ace9e276011286445c1f6f178fefee945edfa2c2edd883991ca9fcdcdc0d4e512f2d6f6c1457844cdfb686451f8e644f67a801df3a1631a88e9ea9d04fc78dc7861d898b4d613e0a3cbbc5de60c6734f200c457";
			RSAPublicKey aa = getPublicKey(hex, "010001");
			System.out.println(aa.toString());
			String passwordD = encryptByPublicKey(dmLogin.getPassWord(), aa);

			System.out.println(dmLogin.getUserName());

			String modifyLoginUrl = "http://117.136.128.54:8092/prm_server/authprm/modifyLogin.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token=" + token;// 登陆
			NameValuePair[] modifyostData = { new NameValuePair("accountApply.accountName", dmLogin.getUserName()), new NameValuePair("accountApply.password", passwordD) };
			loginInfo = post_doNetWork(modifyLoginUrl, modifyostData, "utf-8", refererUrl, httpclient);

			String authenticateUrl = "http://117.136.128.54:8092/prm/login.ajax?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token=" + token;// 登陆
			NameValuePair[] postData = { new NameValuePair("loginName", dmLogin.getUserName()), new NameValuePair("password", passwordD), };
			loginInfo = post_doNetWork(authenticateUrl, postData, "utf-8", refererUrl, httpclient);
			
			String main = "http://117.136.128.54:8092/prm/portal/main.jsp";
			loginInfo = post_doNetWork(main, null, "utf-8", refererUrl, httpclient);
			refererUrl = authenticateUrl;
			
			String homepage = "http://117.136.128.54:8092/prm/portal/homepage.jsp";
			loginInfo = post_doNetWork(homepage, null, "utf-8", refererUrl, httpclient);
			
			String sp_business_list = "http://117.136.128.54:8092/prm/preq/sp/business/sp_business_list.jsp";
			loginInfo = post_doNetWork(sp_business_list, null, "utf-8", refererUrl, httpclient);
			
			String businessSpList = "http://117.136.128.54:8092/prm_server/business/business!businessSpList.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
			loginInfo = post_doNetWork(businessSpList, null, "utf-8", refererUrl, httpclient);
			
			JSONObject businessSpListJson=JSONObject.fromObject(loginInfo).getJSONObject("data");
			JSONObject spPlatforms=null;
			spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(0);
			if(spPlatforms.toString().indexOf("和游戏开放平台")==-1) {
				spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(1);
				if(spPlatforms.toString().indexOf("和游戏开放平台")==-1) {
					spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(2);
				}
			}
			System.out.println(dmLogin.getUserName()+" spPlatforms:"+ spPlatforms);
			JSONObject platformList=spPlatforms.getJSONArray("platformList").getJSONObject(0);
			String platformId=platformList.getString("platformId");
			String spId=platformList.getJSONArray("spPlatformList").getJSONObject(0).getString("spId");

			String businessRedirect = "http://117.136.128.54:8092/prm_server/business/business!businessRedirect.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
			NameValuePair[] businessRedirectData = { new NameValuePair("spPlatform.spId", spId), new NameValuePair("spPlatform.platformId",platformId) };
			loginInfo = post_doNetWork(businessRedirect, businessRedirectData, "utf-8", refererUrl, httpclient);
			
			JSONObject businessRedirectJson=JSONObject.fromObject(loginInfo);
			String prmLogin = businessRedirectJson.getJSONObject("data").getString("linkUrl");
			loginInfo = post_doNetWork(prmLogin, null, "utf-8", refererUrl, httpclient);
			refererUrl = prmLogin;

			String common = "http://g.10086.cn/open/common.do?method=getSystemLink";
			loginInfo = post_doNetWork(common, null, "utf-8", refererUrl, httpclient);
			System.out.println(dmLogin.getUserName()+":"+ loginInfo);
			JSONObject.fromObject(loginInfo);
			
			//处理收入
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
			String footer = "http://g.10086.cn/open/common.do?method=getSystemLink&aN93iu=";
			loginInfo = post_doNetWork(footer, null, "utf-8", refererUrl, httpclient);
			
			
			String egbiLogin = "http://g.10086.cn/open/redirectSystem.do?systemSign=EGBI";
			loginInfo = post_doNetWork(egbiLogin, null, "utf-8", refererUrl, httpclient);
			refererUrl = prmLogin;
			
			//分渠道分业务
			String fixedReport = "http://oss.cmgame.com/egbi/fixedReport.do?merge_id=13743&merge_title=%E9%80%89%E6%8B%A9%E6%8A%A5%E8%A1%A8%E5%91%A8%E6%9C%9F";
			loginInfo = post_doNetWork(fixedReport, null, "utf-8", refererUrl, httpclient);
			refererUrl = prmLogin;
			
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
			loginInfo = post_doNetWork(fixedReporturl, fixedReportData, "utf-8", refererUrl, httpclient);
			
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

			String uuid=BasicsTools.getUuid(false, 16, new Random());
			String filePath = "." + File.separator + "uuCode" + File.separator + uuid + dmLogin.getUserName()+".xls";
			incomeFile = new File(filePath);
			if (!incomeFile.exists()) {
				incomeFile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(filePath);
			byte[] b = new byte[1024];
			while((exelIo.read(b)) != -1){
				fos.write(b);
			}
			fos.flush();
			fos.close();
			exelIo.close();

  
			System.out.println("文件名为:"+incomeFile.getName());
			if(incomeFile.length()==0) {
				logger.info("基地收入没数据");
				setMonitor(dmLogin.getSpProductTaskId()+"","基地收入","没数据");
				map.put(dmLogin.getSpProductTaskId(), dmLogin);
			}else {//上传收入
				String uploadUrl = "http://121.42.157.151:8080/spInfo/upIncomeAction_upload.action?dataSource=7";
				boolean uploadType = uploadFile(incomeFile,uploadUrl,"基地收入",dmLogin);
				if(uploadType) {
					logger.info("基地收入上传成功");
				}else {
					logger.info("基地收入上传失败");
					setMonitor(dmLogin.getSpProductTaskId()+"","基地收入","上传失败");
					map.put(dmLogin.getSpProductTaskId(), dmLogin);
				}
			}
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
				
				JSONObject bulletinAttachs = JSONObject.fromObject(loginInfo).getJSONArray("bulletinAttachs").getJSONObject(0);
				String fileName = bulletinAttachs.getString("attachName");
				String attachURL = bulletinAttachs.getString("attachURL");
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
				complaintFile = new File(complaintPath);
				if (!complaintFile.exists()) {
					complaintFile.createNewFile();
				}

				FileOutputStream fos1 = new FileOutputStream(complaintPath);
				byte[] ab = new byte[1024];
				while((exelIo2.read(ab)) != -1){
					fos1.write(ab);
				}
				fos1.flush();
				fos1.close();
				exelIo2.close();

				logger.info("文件名为:"+complaintFile.getName());
				String complaintUrl = "http://121.42.157.151:8080/spInfo/uploadComplaintAction_upload.action?dataSource=2";
				boolean complaintType = uploadFile(complaintFile,complaintUrl,"基地投诉",dmLogin);
				if(complaintType) {
					logger.info("基地投诉上传成功");
				}else {
					logger.info("基地投诉上传失败");
					setMonitor(dmLogin.getSpProductTaskId()+"","基地投诉","上传失败");
					map.put(dmLogin.getSpProductTaskId(), dmLogin);
				}
			}else {
				logger.info("基地投诉没数据");
				setMonitor(dmLogin.getSpProductTaskId()+"","基地投诉","没数据");
				map.put(dmLogin.getSpProductTaskId(), dmLogin);
			}
			
		} catch (Exception e) {
			setMonitor(dmLogin.getSpProductTaskId()+"","基地投诉收入","出现异常");
			map.put(dmLogin.getSpProductTaskId(), dmLogin);
			logger.error(ExceptionTools.exception(e));
		}finally {
			try {
				setDataLog(dmLogin);//处理后修改状态
			} catch (Exception e2) {
				logger.info("处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e2));
			}finally {
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("处理请求结束，id为" + this.getKey());
				}
			}
		}

	}
	
	/**
	 * 处理完数据修改状态
	 */
	public void setDataLog(DmLogin dmLogin) {
		String sql = "UPDATE spinfo.sp_product_task SET automaticState = 0 WHERE spProductTaskId="+dmLogin.getSpProductTaskId();
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql, DmLoginExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}
	/**
	 * 存入上传信息表
	 * @param id
	 */
	private void setMonitor(String id,String type,String message) {
		String sql ="INSERT INTO monitor_info (monitorInfo,sendOutType,inputDate,monitorTypeId)SELECT CONCAT('id:',spProductTaskId,'<br>业务:',spProductName,'<br>"+type+"<br>"+message+"'),'1',NOW(),'1' FROM sp_product  AS a INNER JOIN sp_product_task AS b ON a.spProductId=b.spProductId WHERE spProductTaskId="+id;
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql, DmLoginExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}
	
	private String post_doNetWork(String netURL, NameValuePair[] postData, String charsetName, String Referer, HttpClient httpclient) {
		PostNetWork_singleton postNetWork = null;
		String result = "";
		try {
			postNetWork = new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);
			postNetWork.setConnectionTimeout(2*1000*60);
			postNetWork.setSoTimeout(2*1000*60);
			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests", "1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");

			if (Referer != null) {
				postNetWork.getPostMethod().addRequestHeader(Referer, Referer);
			}

			if (postData != null) {
				postNetWork.setPostData(postData);
			}

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
	
	/*private InputStream post_doNetWorkIO(String netURL,NameValuePair[] postData,String Referer,HttpClient httpclient) {
		PostNetWork_singleton postNetWork =null;
		InputStream result=null;
		try {
			postNetWork=new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);
			
			httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION,  
					  HttpVersion.HTTP_1_0); 
			
			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests","1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");
			
			if(Referer!=null){
				postNetWork.getPostMethod().addRequestHeader("Referer", Referer);
			}
			
			if(postData!=null){
				postNetWork.setPostData(postData);
			}
			
			
			postNetWork.executeMethod();
			
		 	postNetWork.getInputStream("c:\\temp\\aaa.xls");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}*/
	
	private InputStream post_doNetWorkIO(String netURL,NameValuePair[] postData,String Referer,HttpClient httpclient) {
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
			
//			String[] Proxy ="127.0.0.1:1080".split(":");
//			postNetWork.setProxyHost(Proxy[0]);
//			postNetWork.setProxyPort(Integer.parseInt(Proxy[1]));
//			postNetWork.executeMethod(true);

			postNetWork.executeMethod();
		 	result = postNetWork.getInputStream();
			
			
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
	public String[] splitString(String string, int len) {
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
	public String bcd2Str(byte[] bytes) {
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
	public String encryptByPublicKey(String data, RSAPublicKey publicKey) throws Exception {
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
	public RSAPublicKey getPublicKey(String modulus, String exponent) {
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
	
	/**
	 * 上传文件
	 * @param file 上传的文件
	 * @param url 上传地址
	 * @param type
	 * @return 
	 * @throws ClientProtocolException 
	 * @throws IOException 
	 */
	private boolean uploadFile(File file, String url,String type,DmLogin dmLogin) throws ClientProtocolException, IOException{
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    
	        // 把一个普通参数和文件上传给下面这个地址 是一个servlet
	        HttpPost httpPost = new HttpPost(url);
	        // 把文件转换成流对象FileBody
	        FileBody bin = new FileBody(file);
	        //以浏览器兼容模式运行，防止文件名乱码。  
	        HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
	                .addPart("fileName", bin).setCharset(CharsetUtils.get("UTF-8")).build();

	        httpPost.setEntity(reqEntity);

	        System.out.println("发起请求的页面地址 " + httpPost.getRequestLine());
	        // 发起请求 并返回请求的响应
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	            // 打印响应状态
            System.out.println(response.getStatusLine());
            String status = response.getStatusLine().toString();
            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                // 打印响应长度
                System.out.println("响应长度: "+ resEntity.getContentLength());
                //响应内容
                String result = EntityUtils.toString(resEntity,Charset.forName("UTF-8"));
                if(status.indexOf("200")!=-1) {
                	if(result.indexOf("成功")==-1) {//上传后发生数据补全失败等错误,不重试
                		//发送预警邮件
                		//map.put(dmLogin.getSpProductTaskId(), dmLogin);
            			setMonitor(String.valueOf(dmLogin.getSpProductTaskId()),type,result);
                	}
                	logger.info("id为"+dmLogin.getSpProductTaskId()+",信息:"+result);
                	return true;
                }else {
                	logger.info("上传失败,错误信息为："+result);
                	if(result.indexOf("ToolsExcel")!=-1) {//下载的excel为Bad Request需重新下载
                		return false;
                	}
                }
            }
            // 销毁
            EntityUtils.consume(resEntity);
            response.close();
			httpClient.close();
		return false;
	}
}
