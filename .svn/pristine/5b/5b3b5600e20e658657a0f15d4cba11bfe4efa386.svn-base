package com.astrolink.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang.StringEscapeUtils;
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

public class DmGgExecLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(DmGgExecLinstenerThreadDao.class);
	public DmLogin dmLogin;
	public IExecFinish execFinish;

	public DmGgExecLinstenerThreadDao(DmLogin dmLogin) {
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
			logger.info(execTime);
			HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
			Map<String,String> location = new HashMap<String, String>();
			ArrayList<String> cookie = new ArrayList<String>();
			String serverInfo = "";
			String vcode = "";
			String loginUrl = dmLogin.getAddress();//访问首页

			String html0=post_doNetWork(loginUrl,null,cookie,"utf-8",null,httpclient,null);
			String sessionId = html0.split("name=\"sessionId\" value=\"")[1].split("\"/>")[0];
			String clientIp = html0.split("name=\"clientIp\" value=\"")[1].split("\"/>")[0];

			String login0 = "https://218.207.208.21:8443/bme/main/login.action";
			serverInfo = post_doNetWork(login0, null,cookie, "utf-8", loginUrl, httpclient,location);
			System.out.println(serverInfo);
			String execution = location.get("location").split("=")[1];
			loginUrl = "https://218.207.208.21:8443/bme/main/publicssologin.action?loginLocale=zh_CN";
			NameValuePair[] logData = { 
					new NameValuePair("execution",execution)
					};
			serverInfo = post_doNetWork(loginUrl, logData,cookie, "utf-8", location.get("location"), httpclient,null);
			
			String referer="https://218.207.208.21:8443/bme/main/publicssologin.action?loginLocale=zh_CN";
			
			String codeUrl = "https://218.207.208.21:8443/bme/main/vcode.action";
			serverInfo = post_doNetWork(codeUrl, null,cookie, "utf-8", null, httpclient,null);
			
			String checkLogin = "https://218.207.208.21:8443/bme/main/checkLoginControl.action";
			NameValuePair[] checkLoginData = { 
					new NameValuePair("loginLocale", "zh_CN"),
					new NameValuePair("username", dmLogin.getUserName()),
					new NameValuePair("password", dmLogin.getPassWord()),
					new NameValuePair("_eventId", "submit"),
					new NameValuePair("lt", "e1s1"),
					new NameValuePair("language","zh_CN"),
					new NameValuePair("clientIp",clientIp),
					new NameValuePair("sessionId",sessionId),
					new NameValuePair("vcode","0000")
					};
			serverInfo = post_doNetWork(checkLogin, checkLoginData,cookie, "utf-8", null, httpclient,null);
			System.out.println(serverInfo);
			
			String Check = "https://218.207.208.21:8443/bme/main/loginCheck.action?loginUserId="+dmLogin.getUserName()+"&loginSessionId="+sessionId+"&loginCode=0000&loginLocale=zh_CN&username="+dmLogin.getUserName()+"&password="+dmLogin.getPassWord()+"&_eventId=submit&lt=e1s1&language=zh_CN&clientIp="+clientIp+"&sessionId="+sessionId+"&vcode=0000&_="+System.currentTimeMillis();
			vcode = post_doNetWork(Check, null,cookie, "utf-8", referer, httpclient,null).replace('\n', ' ').trim();
			System.out.println(vcode);
			
			String checkVcode = "https://218.207.208.21:8443/bme/main/checkVcode.action?code="+vcode+"&time=false&userName="+dmLogin.getUserName()+"&password="+dmLogin.getPassWord();
			serverInfo = post_doNetWork(checkVcode, null,cookie, "utf-8", referer, httpclient,null);
			System.out.println(serverInfo);
			
			String login = location.get("location");
			NameValuePair[] loginData = {
					new NameValuePair("loginLocale", "zh_CN"),
					new NameValuePair("username", dmLogin.getUserName()),
					new NameValuePair("password", dmLogin.getPassWord()),
					new NameValuePair("_eventId", "submit"),
					new NameValuePair("lt", "e1s1"),
					new NameValuePair("language","zh_CN"),
					new NameValuePair("clientIp",clientIp),
					new NameValuePair("sessionId",sessionId),
					new NameValuePair("vcode",vcode)
					};
			serverInfo = post_doNetWork(login, loginData,cookie, "utf-8", referer, httpclient,location);
			System.out.println(location.get("location"));
			
			String switchhttp = "http://218.207.208.21:8080/bme/main/switchhttp.action;jsessionid="+sessionId;
			serverInfo = post_doNetWork(switchhttp, null, cookie,"utf-8", location.get("location"), httpclient,null);
			
			String frameset = "http://218.207.208.21:8080/bme/main/frameset.action;jsessionid="+sessionId;
			serverInfo = post_doNetWork(frameset, null, cookie,"utf-8", null, httpclient,null);
			
			String main = "http://218.207.208.21:8080/bme/main/preprocess.action";
			serverInfo = post_doNetWork(main, null, cookie,"utf-8", frameset, httpclient,null);
			String cpId = serverInfo.split("cpId=")[1].split("\"")[0];
			
			logger.info("cpId="+cpId);
			
			String indexProList = "http://218.207.208.16:8080/mdmc_material/proclaim!indexProList.action;jsessionid="+sessionId;
			serverInfo = post_doNetWork(indexProList, null, cookie,"utf-8", loginUrl, httpclient,null);
			System.out.println(serverInfo);

			//更多链接
			String cpProList = "http://218.207.208.16:8080/mdmc_material/proclaim!cpProList.action?search.userId="+cpId+"&search.aimType=cp";
			serverInfo = post_doNetWork(cpProList, null,cookie, "utf-8", null, httpclient,null);
			System.out.println(serverInfo);
			
			String search = "http://218.207.208.16:8080/mdmc_material/proclaim!cpProList.action";
			NameValuePair[] searchData = {
					new NameValuePair("page.dateNum", "10"),
					new NameValuePair("page.noncePage", "1"),
					new NameValuePair("search.beginTime", execTime),
					new NameValuePair("search.endTime", execTime),
					new NameValuePair("search.isUseWay", "0"),
					new NameValuePair("search.promulgator",""),
					new NameValuePair("search.proName",""),
					new NameValuePair("search.proType",""),
					new NameValuePair("search.userId",cpId)
					};
			String result = post_doNetWork(search, searchData,cookie, "utf-8", null, httpclient,null);
			
			if(result.indexOf("status=no')\" style=\"font-size:14\">")!=-1) {
				String[] arrays = result.split("onclick=\"window.open\\('");
				int count = arrays.length-1;//公告数量
				for(int i=1;i<=count;i++) {
					String title = result.split("status=no'\\)\" style=\"font-size:14\">")[i].split("</a>")[0];
					String proclamCpDetail = "http://218.207.208.16:8080/mdmc_material/"+arrays[i].split("',")[0];
					String contentResult = post_doNetWork(proclamCpDetail, null,cookie, "utf-8", null, httpclient,null);
					contentResult = StringEscapeUtils.unescapeHtml(contentResult);
					String content = contentResult.substring(contentResult.indexOf("<div id=\"procliamContent\""), contentResult.indexOf("<table border=1"));
					content = removeHtmlTag(content);
					//content = "<div style=\\'white-space:nowrap;text-overflow:ellipsis;overflow:hidden;\\' title=\\'"+content+"\\'>"+content+"</div>";
					setContent(dmLogin,title,content,execTime);
				}
			}else {
				logger.info(dmLogin.getSpProductName()+"没有公告");
			}
			
		} catch (Exception e) {
			logger.info(dmLogin.getSpProductName()+ExceptionTools.exception(e));
			setContent(dmLogin,"发生异常","建议手动查看",execTime);
		}finally {
			try {
				setDataLog(dmLogin);
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
	
	
	private String post_doNetWork(String netURL,NameValuePair[] postData,ArrayList<String> cookieList,String charsetName,String Referer,HttpClient httpclient,Map<String,String> map) {
		PostNetWork_singleton postNetWork =null;
		String result = "";
		try {
			postNetWork=new PostNetWork_singleton(netURL);
			postNetWork.setSoTimeout(1000*60*3);//修改超时时间
			postNetWork.setConnectionTimeout(1000*60*3);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);
			
			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests","1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/4.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");
			
			if(Referer!=null){
				postNetWork.getPostMethod().addRequestHeader("Referer", Referer);
			}

			String cookieStrInfo="";
			for(String cookie:cookieList){
				cookieStrInfo+=cookie+";";
			}
			
			if (!cookieStrInfo.equals("")) {
				System.out.println("setCookie:"+cookieStrInfo);
				postNetWork.getPostMethod().addRequestHeader("Cookie", cookieStrInfo);
			}
			
			if(postData!=null){
				postNetWork.setPostData(postData);
			}
			
			postNetWork.executeMethod();
			result = postNetWork.getHtml(charsetName);
		 	
		 	
		 	String cookieStr=postNetWork.getCookie();
		 	String [] cookies=cookieStr.split(";");
		 	for(String cookie:cookies){
			 	boolean type=true;
		 		for(String cookieInfo:cookieList){
			 		if(cookie.equals(cookieInfo)){
			 			type=false;
			 			break;
			 		}
			 	}
			 	if(type)cookieList.add(cookie);
		 	}

		 	int netState=postNetWork.getNetState();
		 	System.out.println(netState);
		 	if(netState==302){
		 		if(!netURL.equals("http://218.207.208.21:8080/bme/frameset/timeOut.action?errCode=-2")) {
		 			Header loca = postNetWork.getPostMethod().getResponseHeader("location");
		 			String strLoca = loca.getValue(); 
		 			if(map!=null) {
		 				map.put("location", strLoca);
		 			}
		 			System.out.println("location："+strLoca);
		 			result=post_doNetWork(strLoca,null,cookieList,"utf-8",netURL,httpclient,map);
		 		}
		 	}
		} catch (Exception e) {
			logger.info(dmLogin.getSpProductName()+"发生异常");
			setContent(dmLogin,"发生异常","建议手动查看",BasicsTools.nDaysAfterOneDateString(BasicsTools.getForDate("yyyy-MM-dd"), 0));
		} finally {
			postNetWork.closeConn();
		}
		return result;
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
		String sql ="INSERT INTO sp_product_announcement (spProductId,title,content,type,releaseTime,inputDate) VALUE ("+dmLogin.getSpProductId()+",'"+title+"','"+content+"',1,'"+execTime+"',NOW())";
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql, DmLoginExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}
	
	/**
	 * 除去字符串中html标签
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
