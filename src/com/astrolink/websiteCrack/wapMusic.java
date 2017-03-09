package com.astrolink.websiteCrack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.params.HttpClientParams;

import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.PostNetWork_singleton;
import com.astrolink.util.tools.business.SSL.defaultSSL;

public class wapMusic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
		httpclient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY); 
		httpclient.getParams().setParameter("http.protocol.single-cookie-header", true); 
		
		String loginUrl = "http://m.10086.cn/wireless/n/valbox.htm?id=5144&pageid=W1P1$2305593S27R27L1&breadcrumb=%E9%93%83%E9%9F%B3%E7%9B%92%7B%2Fwireless%2Fn%2";// 访问首页
		String html0 = post_doNetWork(loginUrl, null, "utf-8", null, httpclient);
		System.out.println(html0);

		String uuApi = "-1";
		String uuid = BasicsTools.getUuid(false, 16, new Random());
		String configPath = "." + File.separator + "uuCode" + File.separator + uuid + ".jpg";
		String verifycodeurl = "http://m.10086.cn/wireless/common/captchaCode.jsp?v=a";// 获取验证码
		InputStream code = post_doNetWorkIO(verifycodeurl, null, loginUrl, httpclient);
		String[] codeInfo = httpUuGetCode(configPath, code);
		
	
		if(codeInfo.length>1){
			uuApi=codeInfo[1].toLowerCase();
			String getpass="http://m.10086.cn/wireless/jsp/N/migu/n/getpass.jsp?mymobile=15709448325&CAPTCHA="+uuApi;
			String html1 = post_doNetWork(getpass, null, "utf-8", loginUrl, httpclient);
			System.out.println(html1);
			
			
			String regbox = "http://m.10086.cn/wireless/n/regbox.htm";//登陆
			NameValuePair[] postData = { 
					new NameValuePair("mobile", "15709448325"),
					new NameValuePair("img-code", uuApi),
					new NameValuePair("id", "5144"),
					new NameValuePair("id", "5144"),
					new NameValuePair("k", "002000A"),
					new NameValuePair("sch", "")
			};
			String loginInfo=post_doNetWork(regbox,postData,"utf-8",loginUrl,httpclient);
			System.out.println(loginInfo);
			
			if(!loginInfo.equals("图形验证码校验失败   ")){
				String ss = null;
				try {
					String s = null;
					File file = new File("D:\\text.txt");//Text文件
					BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
					while((s = br.readLine())!=null){//使用readLine方法，一次读一行
						ss=s;
					}
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(ss);
				
					String detailbox = "http://m.10086.cn/wireless/n/detailbox.htm";//登陆
					NameValuePair[] detailboxPostData = { 
							new NameValuePair("mobile", "15709448325"),
							new NameValuePair("pass", ss),
							new NameValuePair("type", "on"),
							new NameValuePair("id", "5144"),
							new NameValuePair("k", "002000A"),
							new NameValuePair("sch", "")
					};
					String detailboxInfo=post_doNetWork(detailbox,detailboxPostData,"utf-8",regbox,httpclient);
					detailboxInfo=post_doNetWork(detailbox,detailboxPostData,"utf-8",regbox,httpclient);
					System.out.println(detailboxInfo);
					
					
					String uuApi1 = "-1";
					String uuid1 = BasicsTools.getUuid(false, 16, new Random());
					String configPath1 = "." + File.separator + "uuCode" + File.separator + uuid1 + ".jpg";
					
					String verifycodeurl1 = "http://m.10086.cn/wireless/common/captcha.jsp?v=a";// 获取验证码
					InputStream code1 = post_doNetWorkIO(verifycodeurl1, null, null, httpclient);
					String[] codeInfo1 = httpUuGetCode(configPath1, code1);
					
					
					String blacklist="http://m.10086.cn/wireless/common/framework/api/blacklist.jsp?song=&copyright=&billing=002000A";
					String html6 = post_doNetWork(blacklist, null, "utf-8", verifycodeurl1, httpclient);
					System.out.println(html6);
					
					if(codeInfo1.length>1){
						uuApi1=codeInfo1[1].toLowerCase();
						System.out.println(uuApi1);
						
						String parseValueByVarname=parseValueByVarname(detailboxInfo,"pushcode");
						System.out.println(parseValueByVarname);
						
						//String orderboxurl = "http://m.10086.cn//wireless/jsp/N/n/orderbox.jsp?CAPTCHA="+uuApi1+"&toneid=5144&k=002000A&sch=&pushcode="+parseValueByVarname+"&mobile=15709448325";
						String orderboxurl = "http://m.10086.cn//wireless/jsp/N/n/orderbox.jsp";
						NameValuePair[] detailboxPostData1 = { 
								//new NameValuePair("captcha", uuApi1),
								new NameValuePair("CAPTCHA", uuApi1),
								new NameValuePair("toneid", "5144"),
								new NameValuePair("k", "002000A"),
								new NameValuePair("sch", ""),
								//new NameValuePair("pushcode", parseValueByVarname),
								new NameValuePair("pushcode", ""),
								new NameValuePair("mobile", "15709448325")

						};
						String html7 = post_doNetWork(orderboxurl, detailboxPostData1, "utf-8", null, httpclient);
						System.out.println(html7);
					}
			}
		}
	}

	private static String post_doNetWork(String netURL, NameValuePair[] postData, String charsetName, String Referer, HttpClient httpclient) {
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

	private static InputStream post_doNetWorkIO(String netURL, NameValuePair[] postData, String Referer, HttpClient httpclient) {
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

	 private static  String parseValueByVarname(String input, String varname) {
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
