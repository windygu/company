package com.astrolink.dao;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.regex.Pattern;

import javax.crypto.Cipher;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.params.HttpClientParams;
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

public class JdGgExecLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(JdGgExecLinstenerThreadDao.class);
	public DmLogin dmLogin;
	public IExecFinish execFinish;
	
	public JdGgExecLinstenerThreadDao(DmLogin dmLogin) {
		this.dmLogin = dmLogin;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	
	public void setDbTableName(String dbTableName) {
	}

	@Override
	public void exec() {
		String execTime = BasicsTools.nDaysAfterOneDateString(BasicsTools.getForDate("yyyy-MM-dd"), 0);
		try {
			HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
			httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY); 
			httpclient.getParams().setParameter("http.protocol.single-cookie-header", true); 
			String loginInfo = "";

			System.out.println(execTime);

			String loginUrl = dmLogin.getAddress();// 访问首页
			String refererUrl = loginUrl;
			String html0 = post_doNetWork(loginUrl, null, "utf-8", null, httpclient);
			System.out.println(html0);

			String ticket = html0.split("P_TICKET=\"")[1].split("\";")[0];
			String token = html0.split("TOKENS = \"")[1].split(",")[0];
			System.out.println(ticket);
			System.out.println(token);
			ticket=URLEncoder.encode(ticket);

			String hex = "00888ffceecf1e11841a7f0758d40e78de2c052f74fb75efe4b8624eccebb08b374ef868821b3114a106eea9209ace9e276011286445c1f6f178fefee945edfa2c2edd883991ca9fcdcdc0d4e512f2d6f6c1457844cdfb686451f8e644f67a801df3a1631a88e9ea9d04fc78dc7861d898b4d613e0a3cbbc5de60c6734f200c457";
			RSAPublicKey aa = getPublicKey(hex, "010001");
			System.out.println(aa.toString());
			String passwordD = encryptByPublicKey(dmLogin.getPassWord(), aa);

			System.out.println(passwordD);

			String modifyLoginUrl = "http://218.206.191.22/prm_server/authprm/modifyLogin.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token=" + token;// 登陆
			NameValuePair[] modifyostData = { new NameValuePair("accountApply.accountName", dmLogin.getUserName()), new NameValuePair("accountApply.password", passwordD) };
			loginInfo = post_doNetWork(modifyLoginUrl, modifyostData, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);

			String authenticateUrl = "http://218.206.191.22/prm/login.ajax?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token=" + token;// 登陆
			NameValuePair[] postData = { new NameValuePair("loginName", dmLogin.getUserName()), new NameValuePair("password", passwordD), };
			loginInfo = post_doNetWork(authenticateUrl, postData, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			String main = "http://218.206.191.22/prm/portal/main.jsp";
			loginInfo = post_doNetWork(main, null, "utf-8", refererUrl, httpclient);
			refererUrl = authenticateUrl;
			System.out.println(loginInfo);
			
			String homepage = "http://218.206.191.22/prm/portal/homepage.jsp";
			loginInfo = post_doNetWork(homepage, null, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			String sp_business_list = "http://218.206.191.22/prm/preq/sp/business/sp_business_list.jsp";
			loginInfo = post_doNetWork(sp_business_list, null, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			String businessSpList = "http://218.206.191.22/prm_server/business/business!businessSpList.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
			loginInfo = post_doNetWork(businessSpList, null, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			JSONObject businessSpListJson=JSONObject.fromObject(loginInfo).getJSONObject("data");
			JSONObject spPlatforms=businessSpListJson.getJSONArray("spPlatforms").getJSONObject(0);
			JSONObject platformList=spPlatforms.getJSONArray("platformList").getJSONObject(0);
			String platformId=platformList.getString("platformId");
			String spId=platformList.getJSONArray("spPlatformList").getJSONObject(0).getString("spId");
			
			String businessRedirect = "http://218.206.191.22/prm_server/business/business!businessRedirect.action?ticket=" + ticket + "&domain=sp&isAjax=true&ts=" + System.currentTimeMillis() + "&token="+token;
			NameValuePair[] businessRedirectData = { new NameValuePair("spPlatform.spId", spId), new NameValuePair("spPlatform.platformId",platformId) };
			loginInfo = post_doNetWork(businessRedirect, businessRedirectData, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			JSONObject businessRedirectJson=JSONObject.fromObject(loginInfo);
			
			String prmLogin = businessRedirectJson.getJSONObject("data").getString("linkUrl");
			loginInfo = post_doNetWork(prmLogin, null, "utf-8", refererUrl, httpclient);
			refererUrl = prmLogin;
			System.out.println(loginInfo);

			String announ = "http://g.10086.cn/open/announ.do?method=showView&type=0&menu=gonggao";
			loginInfo = post_doNetWork(announ, null, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			
			String query = "http://g.10086.cn/open/announ.do?method=queryMsg&aN93iu=";
			NameValuePair[] queryData = {
					new NameValuePair("page", "1"),
					new NameValuePair("count", "1"),
					new NameValuePair("startTime", execTime),
					new NameValuePair("endTime", execTime),
					new NameValuePair("status", ""),
					new NameValuePair("title",""),
					new NameValuePair("bulletinType","0")
					};
			loginInfo = post_doNetWork(query, queryData, "utf-8", refererUrl, httpclient);
			System.out.println(loginInfo);
			JSONObject queryJson=JSONObject.fromObject(loginInfo);
			JSONArray rows = queryJson.getJSONArray("rows");
			if(rows.size()!=0) {
				for(int i = 0;i < rows.size();i++) {
					JSONObject row = (JSONObject) rows.get(i);
					String bulletinID = row.getString("bulletinID");
					String bulletinTitle = row.getString("bulletinTitle");
					
					String detail = "http://g.10086.cn/open/bulletinDetail.do?method=bulletinDetail&aN93iu=";
					NameValuePair[] detailData = { new NameValuePair("bulletinType", "0"), new NameValuePair("bulletinID",bulletinID) };
					loginInfo = post_doNetWork(detail, detailData, "utf-8", refererUrl, httpclient);
					JSONObject contJson=JSONObject.fromObject(loginInfo);
					String bulletinCont = contJson.getString("bulletinCont");
					bulletinCont = removeHtmlTag(bulletinCont);
					System.out.println(bulletinTitle+"\r\n"+bulletinCont);
					setContent(dmLogin,bulletinTitle,bulletinCont,execTime);
				}
			}else {
				logger.info("基地公告没数据");
			}
			
		} catch (Exception e) {
			setContent(dmLogin,"出现异常","建议手动查看",execTime);
			logger.error("出现异常:"+ExceptionTools.exception(e));
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
	 * 将信息存库
	 * @param dmLogin
	 * @param title
	 * @param content
	 * @param execTime
	 */
	private void setContent(DmLogin dmLogin,String title,String content,String execTime) {
		String sql ="INSERT INTO sp_product_announcement (spProductId,title,content,type,releaseTime,inputDate) VALUE ("+dmLogin.getSpProductId()+",'"+title+"','"+content+"',2,'"+execTime+"',NOW())";
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
	 * 移除html标签
	 * @param inputString
	 * @return
	 */
	public String removeHtmlTag(String inputString) {
		if (inputString == null)
			return null;
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		java.util.regex.Pattern p_special;
		java.util.regex.Matcher m_special;
		try {
			//定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			//定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			// 定义HTML标签的正则表达式
			String regEx_html = "<[^>]+>";
			// 定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			String regEx_special = "\\&[a-zA-Z]{1,10};";
			
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			p_special = Pattern.compile(regEx_special, Pattern.CASE_INSENSITIVE);
			m_special = p_special.matcher(htmlStr);
			htmlStr = m_special.replaceAll(""); // 过滤特殊标签
			textStr = htmlStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textStr;// 返回文本字符串
	}
	
}
