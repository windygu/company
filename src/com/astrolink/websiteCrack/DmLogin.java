package com.astrolink.websiteCrack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpClientParams;

import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.JsonTools;
import com.astrolink.util.tools.PostNetWork_singleton;
import com.astrolink.util.tools.business.SSL.defaultSSL;

public class DmLogin {
	private static String charset = "utf-8";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));

		String loginInfo="";
		ArrayList<String> cookie = new ArrayList<String>();
		for(int i=0;i<3;i++){
			
			String execTime=BasicsTools.nDaysAfterOneDateString(BasicsTools.getForDate("yyyy-MM-dd"), -2).replaceAll("-", "");
			System.out.println(execTime);
			
			String loginUrl = "https://218.207.208.43:9083/bicp/login.action";//访问首页
			String refererUrl=loginUrl;
			String html0=post_doNetWork(loginUrl,null,cookie,"utf-8",null,httpclient);
			System.out.println(html0);
			String BMEWebToken=html0.substring(html0.indexOf("BMEWebToken="),html0.length());
			BMEWebToken=BMEWebToken.substring(0,BMEWebToken.indexOf("'"));
			System.out.println(BMEWebToken);
			
			String uuApi="-1";
			String uuid=BasicsTools.getUuid(false, 16, new Random());
			String configPath = "." + File.separator + "uuCode" + File.separator + uuid + ".jpg";
			String verifycodeurl = "https://218.207.208.43:9083/bicp/verifycode";//获取验证码
			InputStream code=post_doNetWorkIO(verifycodeurl,null,cookie,null,httpclient);
			String[] codeInfo=httpUuGetCode(configPath,code);
		
			if(codeInfo.length>1){
				uuApi=codeInfo[1];
				String authenticateUrl = "https://218.207.208.43:9083/bicp/authenticate.action";//登陆
				NameValuePair[] postData = { 
						new NameValuePair("username", "CP1741BICP"),
						new NameValuePair("password", "1234abcdABCD!"),
						new NameValuePair("vcode", uuApi),
						new NameValuePair("dstInfo", "480:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0"),
						new NameValuePair("language", "zh_CN"),
						new NameValuePair("name", "default"),
						new NameValuePair("logintype", "0"),
						new NameValuePair("smscode", ""),
						new NameValuePair("msisdn", "CP1741BICP"),
				};
				loginInfo=post_doNetWork(authenticateUrl,postData,cookie,"utf-8",refererUrl,httpclient);
				refererUrl=authenticateUrl;
				System.out.println(loginInfo);
				JSONObject json=JsonTools.getJsonData(loginInfo);
				if(json.optBoolean("isSuccess")==true ){
					String nextAction=json.optString("nextAction");
					String html="";
					if(!nextAction.equals("")){
						String nextActionUrl = "https://218.207.208.43:9083/bicp/"+nextAction+"&"+BMEWebToken+"&BMETheme.name=blue2.0&language=zh_CN";
						System.out.println(nextActionUrl);
						html=post_doNetWork(nextActionUrl,null,cookie,"utf-8",refererUrl,httpclient);
						refererUrl=nextActionUrl;
						System.out.println(html);
					}else{
						String mainUrl = "https://218.207.208.43:9083/bicp/main.action?ssLogin=true&"+BMEWebToken+"&BMETheme.name=blue2.0&language=zh_CN";
						System.out.println(mainUrl);
						html=post_doNetWork(mainUrl,null,cookie,"utf-8",refererUrl,httpclient);
						refererUrl=mainUrl;
						System.out.println(html);
					}
					
					
					if(html.indexOf("要求的token是非法的")!=-1){
						System.out.println("token是非法");
					}else if(html.indexOf("该帐号已登录或上一次登录未正常退出系统，继续登录则已登录的用户将被强制退出系统，是否继续？")!=-1){
						System.out.println("该帐号已登录或上一次登录未正常退出系统，继续登录则已登录的用户将被强制退出系统，是否继续");
						String usmLogConfirmUrl = "https://218.207.208.43:9083/bicp/usmLogConfirm.action?BMETheme.name=blue2.0&language=zh_CN&"+BMEWebToken;
						System.out.println(usmLogConfirmUrl);
						html=post_doNetWork(usmLogConfirmUrl,null,cookie,"utf-8",refererUrl,httpclient);
						refererUrl=usmLogConfirmUrl;
					}else{
						System.out.println(html);
					}
					
					
					if(html.indexOf("资源管理器")!=-1){
						String business="http://218.207.208.43:9080/bicp/business.action?BMEBusiness=resourceList&catalogId=/RMS/favourite&resourceType=&"+BMEWebToken+"&BMETimestamp="+System.currentTimeMillis();
						System.out.println(business);
						html=post_doNetWork(business,null,cookie,"utf-8",refererUrl,httpclient);
						refererUrl=business;
						System.out.println(html);
						
						
						String resourceId="";
						String resourceRefId="";
						String resourceType="";
						String []infs=html.split("</td></tr>");
						String params="",outputs = "",pageInfo = "";
						for(String info:infs){
							//在这里写分支收入还是投诉
							if(info.indexOf("title=\"81\"")!=-1 || info.indexOf("title=\"5\"")!=-1){
								resourceId=subStr(info,"resourceId=\"","\"");
								resourceRefId=subStr(info,"resourceRefId=\"","\"");
								resourceType=subStr(info,"resourceType=\"","\"");
								
								String viewAdhoc = "http://218.207.208.43:9080/isdp/adhocView.action?action=viewAdhoc&id="+resourceRefId+"&resOprType=view&language=zh_CN&BMETheme.name=blue2.0&BMEWebToken="+BMEWebToken;
								String res = post_doNetWork(viewAdhoc,null,cookie,"utf-8","",httpclient);
								if(res.indexOf("输入查询时间")!=-1) {
									params = "[{\"paramName\":\"${输入查询时间}_23\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入合作伙伴类型ID}_26\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
								}else {
									params="[{\"paramName\":\"${输入统计时间}_23\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入合作伙伴ID}_35\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
								}
								outputs="[{\"fieldId\":\"8aae4d87474a2aa1014786c65a380150\",\"displayOrder\":0,\"fieldName\":\"统计时间\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380153\",\"displayOrder\":1,\"fieldName\":\"省份名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380155\",\"displayOrder\":2,\"fieldName\":\"合作伙伴类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380158\",\"displayOrder\":3,\"fieldName\":\"合作伙伴名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a390164\",\"displayOrder\":4,\"fieldName\":\"业务类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380159\",\"displayOrder\":5,\"fieldName\":\"投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a39015a\",\"displayOrder\":6,\"fieldName\":\"新增投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a39015b\",\"displayOrder\":7,\"fieldName\":\"不知情投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a39015c\",\"displayOrder\":8,\"fieldName\":\"新增不知情投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a390162\",\"displayOrder\":9,\"fieldName\":\"付费用户数\",\"selected\":true},{\"fieldId\":\"8aae4d8a4d4c01f7014d4c16e8cb0084\",\"displayOrder\":10,\"fieldName\":\"上月至今付费用户数\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b1f487ce2\",\"displayOrder\":11,\"fieldName\":\"是否同质\",\"selected\":true},{\"fieldId\":\"8aae4d8a51b4674b01523a1a96781bdc\",\"displayOrder\":12,\"fieldName\":\"认证渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d8a51b4674b01523a1a96781bdb\",\"displayOrder\":13,\"fieldName\":\"认证渠道ID\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b1f487ce3\",\"displayOrder\":14,\"fieldName\":\"渠道类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a390163\",\"displayOrder\":15,\"fieldName\":\"本月信息费\",\"selected\":true}]";
								//pageInfo = "{\"curPageNo\":1,\"totalPageCount\":1,\"totalRowCount\":7,\"pageRowCount\":20}";
							}
						}
						
						String checkInputIsDate="http://218.207.208.43:9080/isdp/adhocView.action?action=checkInputIsDate&"+BMEWebToken+"&resOprType=modify&pattern=yyyyMMdd&dateString="+execTime;
						System.out.println(checkInputIsDate);
						html=post_doNetWork(checkInputIsDate,null,cookie,"utf-8",refererUrl,httpclient);
						System.out.println(html);
						refererUrl=checkInputIsDate;
						
						checkInputIsDate="http://218.207.208.43:9080/isdp/adhocView.action?action=checkInputIsDate&"+BMEWebToken+"&resOprType=modify&pattern=yyyyMMdd&dateString="+execTime;
						System.out.println(checkInputIsDate);
						html=post_doNetWork(checkInputIsDate,null,cookie,"utf-8",refererUrl,httpclient);
						System.out.println(html);
						refererUrl=checkInputIsDate;
						
						String getQueryProgressWin="http://218.207.208.43:9080/isdp/adhocView.action?action=getQueryProgressWin&"+BMEWebToken;
						System.out.println(getQueryProgressWin);
						NameValuePair[] getQueryProgressWinPostData = { 	
								new NameValuePair("resOprType", "view"),
								new NameValuePair("dataQueried", "false"),
								new NameValuePair("id", resourceRefId),
								new NameValuePair("executeId", "null"),
								new NameValuePair("params",params),
								new NameValuePair("outputs",outputs),
								new NameValuePair("statResultType", "null"),
								new NameValuePair("type", "before"),
								new NameValuePair("type", "before"),
								new NameValuePair("showRowNo", "true"),
								new NameValuePair("unqueryInfo", "false"),
								new NameValuePair("isRefresh", "1"),
								new NameValuePair("relatedeTable", "false"),
								new NameValuePair("pageInfo", pageInfo),
								new NameValuePair("bgExportType", "null"),
								new NameValuePair("reverseTableName", "null"),
								new NameValuePair("id", resourceRefId),
						};
						html=post_doNetWork(getQueryProgressWin,getQueryProgressWinPostData,cookie,"utf-8",refererUrl,httpclient);
						System.out.println(html);
						refererUrl=getQueryProgressWin;
						
						String requeryUrl="http://218.207.208.43:9080/isdp/adhocView.action?action=requery&requeryKey=1466152031340&"+BMEWebToken;
						NameValuePair[] requeryPostData = { 	
							new NameValuePair("resOprType", "view"),
							new NameValuePair("dataQueried", "false"),
							new NameValuePair("id", resourceRefId),
							new NameValuePair("executeId", "null"),
							new NameValuePair("params",params),
							new NameValuePair("outputs",outputs),
							new NameValuePair("statResultType", "null"),
							new NameValuePair("type", "before"),
							new NameValuePair("type", "before"),
							new NameValuePair("showRowNo", "true"),
							new NameValuePair("unqueryInfo", "false"),
							new NameValuePair("isRefresh", "1"),
							new NameValuePair("relatedeTable", "false"),
							new NameValuePair("pageInfo", ""),
							new NameValuePair("bgExportType", "null"),
							new NameValuePair("reverseTableName", "null"),
						};
						
						String executeId="";
						try {
							html=post_doNetWork(requeryUrl,requeryPostData,cookie,"utf-8",refererUrl,httpclient);
							System.out.println(html);
							refererUrl=requeryUrl;
							executeId=subStr(html,"adhoc.setExecuteId('","'");
						}catch(Exception e){
							//logger.error(ExceptionTools.exception(e));
						}
						System.out.println("executeId："+executeId);
						
						String approveAuthorizedWinUrl="http://218.207.208.43:9080/isdp/adhocView.action?action=approveAuthorizedWin&"+BMEWebToken;
						System.out.println(getQueryProgressWin);
						NameValuePair[] approveAuthorizedWinData = { 	
								new NameValuePair("resOprType", "view"),
								new NameValuePair("dataQueried", "false"),
								new NameValuePair("id", resourceRefId),
								new NameValuePair("resourceType", resourceType),
								new NameValuePair("executeId", executeId),
								new NameValuePair("exportType", "xls"),
						};
						html=post_doNetWork(approveAuthorizedWinUrl,approveAuthorizedWinData,cookie,"utf-8",refererUrl,httpclient);
						System.out.println(html);
						refererUrl=approveAuthorizedWinUrl;
						
						String exportExcelWinUrl="http://218.207.208.43:9080/isdp/adhocView.action?action=exportExcel&"+BMEWebToken;
						System.out.println(exportExcelWinUrl);
						NameValuePair[] exportExcelData = { 	
								new NameValuePair("resOprType", "view"),
								new NameValuePair("dataQueried", "true"),
								new NameValuePair("id", resourceRefId),
								new NameValuePair("executeId", executeId),
								new NameValuePair("params",params),
								new NameValuePair("outputs",outputs),
								new NameValuePair("statResultType", "null"),
								new NameValuePair("type", "before"),
								new NameValuePair("type", "before"),
								new NameValuePair("showRowNo", "true"),
								new NameValuePair("unqueryInfo", "false"),
								new NameValuePair("isRefresh", "1"),
								new NameValuePair("relatedeTable", "false"),
								new NameValuePair("pageInfo",""),
								new NameValuePair("singleRowNo", "-1"),
								new NameValuePair("singleRowCount", "0"),
								new NameValuePair("bgExportType", "xls"),
								new NameValuePair("reverseTableName", "null"),
						};
						InputStream exelIo=post_doNetWorkIO(exportExcelWinUrl,exportExcelData,cookie,null,httpclient);
						System.out.println(html);
						refererUrl=approveAuthorizedWinUrl;
						// 存储excel
						try {
							String filePath = "." + File.separator + "uuCode" + File.separator + uuid + ".xls";
							File file = new File(filePath);
							if (!file.exists()) {
								file.createNewFile();
							}
							FileOutputStream fos = new FileOutputStream(file.getPath());
							byte[] b = new byte[1024];
							while((exelIo.read(b)) != -1){
								fos.write(b);
							}
							fos.close();
						} catch (Exception e) {
							ExceptionTools.exception(e);
						}
					}
				}
			}
		}
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
			while((CheckCode.read(b)) != -1){
				fos.write(b);
			}
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 这里接打码平台
		return BasicsTools.httpUuGetCode(filePath);

	}

	private static String post_doNetWork(String netURL,NameValuePair[] postData,ArrayList<String> cookieList,String charsetName,String Referer,HttpClient httpclient) {
		PostNetWork_singleton postNetWork =null;
		String result = "";
		try {
			postNetWork=new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);
			postNetWork.setConnectionTimeout(1000*60*3);
			postNetWork.setSoTimeout(1000*60*3);
			
			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests","1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");
			
			if(Referer!=null){
				postNetWork.getPostMethod().addRequestHeader("Referer", Referer);
			}

			String cookieStrInfo="";
			for(String cookie:cookieList){
				cookieStrInfo+=cookie+";";
			}
			
			if (!cookieStrInfo.equals("")) {
				//System.out.println("setCookie:"+cookieStrInfo);
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
		 	//System.out.println("getCookie:"+cookieList);
		 	
		 	int netState=postNetWork.getNetState();
		 	System.out.println(netState);
		 	if(netState==302){
		 		Header loca = postNetWork.getPostMethod().getResponseHeader("location");
		 	    String strLoca = loca.getValue(); 
		 	    System.out.println("location："+strLoca);
		 	    result=post_doNetWork(strLoca,null,cookieList,"utf-8",netURL,httpclient);
		 	}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}
	
	private static InputStream post_doNetWorkIO(String netURL,NameValuePair[] postData,ArrayList<String> cookieList,String Referer,HttpClient httpclient) {
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
		 	result = postNetWork.getInputStream();
			
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
		 	System.out.println("getCookie:"+cookieList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}
	
	private static String subStr(String val,String key,String endFh){
		String info=val.substring(val.indexOf(key)+key.length(),val.length());
		info=info.substring(0,info.indexOf(endFh));
		return info;
	}
}
