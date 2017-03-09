package com.astrolink.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;

import com.astrolink.domain.WapMusicExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.PostNetWork_singleton;
import com.astrolink.util.tools.business.SSL.defaultSSL;

/**
 * 发送短信线程
 * @author cuilei
 * @date 2015-11-30
 */
public class WapMusicExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(WapMusicExecLinstenerThreadDao.class);
	private String dbTableName;
	public WapMusicExecLog musicExecLog;
	public IExecFinish execFinish;
	
	public WapMusicExecLinstenerThreadDao(WapMusicExecLog musicExecLog){
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
		StringBuffer logBuff=new StringBuffer();
		try{
			ArrayList<String> cookie=new ArrayList<String>();
			JSONArray a=JSONArray.fromObject(musicExecLog.getCookie());
			for(int i=0;i<a.size();i++){
				cookie.add(a.getString(i));
			}
			
			HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
			httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY); 
			httpclient.getParams().setParameter("http.protocol.single-cookie-header", true); 
			
			String regbox = "http://m.10086.cn/wireless/n/regbox.htm";//登陆
			String detailbox = "http://m.10086.cn/wireless/n/detailbox.htm";//登陆
			NameValuePair[] detailboxPostData = { 
					new NameValuePair("mobile", musicExecLog.getMobile()),
					new NameValuePair("pass", musicExecLog.getCheckCode()),
					new NameValuePair("type", "on"),
					new NameValuePair("id", "5144"),
					new NameValuePair("k", "002000A"),
					new NameValuePair("sch", "")
			};
			String detailboxInfo=post_doNetWork(detailbox,detailboxPostData,cookie,"utf-8",regbox,httpclient);
			detailboxInfo=post_doNetWork(detailbox,detailboxPostData,null,"utf-8",regbox,httpclient);
			System.out.println(detailboxInfo);
			
			String uuApi = "-1";
			String uuid = BasicsTools.getUuid(false, 16, new Random());
			String configPath = "." + File.separator + "uuCode" + File.separator + uuid + ".jpg";
			
			String verifycodeurl = "http://m.10086.cn/wireless/common/captcha.jsp?v=a";// 获取验证码
			InputStream code = post_doNetWorkIO(verifycodeurl, null, null, httpclient);
			String[] codeInfo = httpUuGetCode(configPath, code);
			
			
			String blacklist="http://m.10086.cn/wireless/common/framework/api/blacklist.jsp?song=&copyright=&billing=002000A";
			String html6 = post_doNetWork(blacklist, null,null, "utf-8", verifycodeurl, httpclient);
			System.out.println(html6);
			
			if(codeInfo.length>1){
				uuApi=codeInfo[1].toLowerCase();
				System.out.println(uuApi);
				
				String parseValueByVarname=parseValueByVarname(detailboxInfo,"pushcode");
				System.out.println(parseValueByVarname);
				
				//String orderboxurl = "http://m.10086.cn//wireless/jsp/N/n/orderbox.jsp?CAPTCHA="+uuApi1+"&toneid=5144&k=002000A&sch=&pushcode="+parseValueByVarname+"&mobile=15709448325";
				String orderboxurl = "http://m.10086.cn//wireless/jsp/N/n/orderbox.jsp";
				NameValuePair[] detailboxPostData1 = { 
						new NameValuePair("CAPTCHA", uuApi),
						new NameValuePair("toneid", "5144"),
						new NameValuePair("k", "002000A"),
						new NameValuePair("sch", ""),
						//new NameValuePair("pushcode", parseValueByVarname),
						new NameValuePair("pushcode", ""),
						new NameValuePair("mobile", musicExecLog.getMobile())
				};
				String html7 = post_doNetWork(orderboxurl, detailboxPostData1,null, "utf-8", null, httpclient);
				System.out.println(html7);
				
				//<p  class="regFail">尊敬的用户，您暂未开通彩铃！</p>
			}
			
			
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logBuff.append(",处理请求结束，id为" + this.getKey());
			}
		}
		logger.info(logBuff.toString());
	}
	
	private String post_doNetWork(String netURL, NameValuePair[] postData,ArrayList<String> cookieList,String charsetName, String Referer, HttpClient httpclient) {
		PostNetWork_singleton postNetWork = null;
		String result = "";
		try {
			postNetWork = new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);

			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");

			if (Referer != null) {
				postNetWork.getPostMethod().addRequestHeader("Referer", Referer);
			}

			if(cookieList!=null){
				String cookieStrInfo="";
				for(String cookie:cookieList){
					cookieStrInfo+=cookie+";";
				}
				
				System.out.println(cookieStrInfo);
				if (!cookieStrInfo.equals("")) {
					//System.out.println("setCookie:"+cookieStrInfo);
					postNetWork.getPostMethod().addRequestHeader("Cookie", cookieStrInfo);
				}
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
				result = post_doNetWork(strLoca, null,null, "utf-8", netURL, httpclient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}

	private InputStream post_doNetWorkIO(String netURL, NameValuePair[] postData, String Referer, HttpClient httpclient) {
		PostNetWork_singleton postNetWork = null;
		InputStream result = null;
		try {
			postNetWork = new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);

			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");
			
			if (Referer != null) {
				postNetWork.getPostMethod().addRequestHeader("Referer", Referer);
			}

			if (postData != null) {
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
	
	public String[] httpUuGetCode(String filePath, InputStream CheckCode) {
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

	 private  String parseValueByVarname(String input, String varname) {
			// <input type="hidden" id="random" name="random" value="1345157449"/>
	  		//String item_format = "<[ \t]*input[ \t]+type=\"hidden\"(?:[ \t]+id=\"{varname}\")?[ \t]+name=\"({varname})\"[ \t]+value=\"([-=+/0-9a-zA-Z]+)\"[ \t]*/>";
			String item_format = "<[ \t]*input[ \t]+type=\"hidden\"(?:[ \t]+value=\"([-=+/0-9a-zA-Z]+)\"?[ \t]+id=\"{varname}\")[ \t]+name=\"({varname})\"[ \t]*/>";
			 String regexp_str = item_format.replace("{varname}", varname);
	  		Pattern p = Pattern.compile(regexp_str, Pattern.DOTALL);
	  		Matcher m = p.matcher(input);
	  		if (m != null && m.find() && m.groupCount() >= 2) {
	  			String formatInfo=m.group(0);
	  			String value=m.group(1);
	  			String key=m.group(2);
	  			return value;
	  		}
	  		return null;
	  	}
}
