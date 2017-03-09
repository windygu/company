package com.astrolink.util.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.http.HttpEntity;
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
import com.astrolink.dao.DmLoginExecLinstenerThreadDao;
import com.astrolink.domain.DmLogin;
import com.astrolink.util.tools.business.SSL.defaultSSL;

public class DmLoginTools {
	private Logger logger = Logger.getLogger(DmLoginExecLinstenerThreadDao.class);
	public Map<Object,Object> map;
	
	public void setMap(Map<Object, Object> map) {
		this.map = map;
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
	 * 将失败信息存入自动上传信息
	 * @param id
	 */
	private void setMonitor(String id,String type,String message) {
		String sql ="INSERT INTO monitor_info (monitorInfo,sendOutType,inputDate,monitorTypeId)SELECT CONCAT('上传任务id:',spProductTaskId,'<br>业务名称:',spProductName,'<br>业务类型："+type+"<br>失败信息："+message.replace("<hr>", " ")+"'),'1',NOW(),'1' FROM sp_product  AS a INNER JOIN sp_product_task AS b ON a.spProductId=b.spProductId WHERE spProductTaskId="+id;
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			dt.upDate(sql, DmLoginExecLinstenerThreadDao.class);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
	}
	/**
	 * 模拟访问
	 * @param loginInfo
	 * @param httpclient
	 * @param dmLogin
	 * @param type
	 */
	public void doWork(String loginInfo,DmLogin dmLogin,String type,HttpClient httpclient) {
		for(int i=0;i<4;i++){
			ArrayList<String> cookie = new ArrayList<String>();
			String execTime=BasicsTools.nDaysAfterOneDateString(BasicsTools.getForDate("yyyy-MM-dd"), -1).replaceAll("-", "");
			
			String loginUrl = dmLogin.getAddress().trim();//访问首页
			String refererUrl=loginUrl;
			String html0=post_doNetWork(loginUrl,null,cookie,"utf-8",null,httpclient);
			System.out.println(html0);
			String BMEWebToken = "";
			try {
				BMEWebToken=html0.substring(html0.indexOf("BMEWebToken="),html0.length());
			} catch (Exception e) {
				if(i==3) {//第四次循环出现异常
					map.put(dmLogin.getSpProductTaskId(), dmLogin);
					setMonitor(String.valueOf(dmLogin.getSpProductTaskId()),type,"程序异常,重试http://121.42.157.151:8080/spInfo/retryAction?spProductTaskId="+dmLogin.getSpProductTaskId());
				}
				continue;
			}
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
						new NameValuePair("username", dmLogin.getUserName()),
						new NameValuePair("password", dmLogin.getPassWord()),
						new NameValuePair("vcode", uuApi),
						new NameValuePair("dstInfo", "480:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0:0"),
						new NameValuePair("language", "zh_CN"),
						new NameValuePair("name", "default"),
						new NameValuePair("logintype", "0"),
						new NameValuePair("smscode", ""),
						new NameValuePair("msisdn", "CP2090BICP"),
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
						if(html.equals("")) {
							if(i==3) {
								map.put(dmLogin.getSpProductTaskId(), dmLogin);
								setMonitor(String.valueOf(dmLogin.getSpProductTaskId()),type,"程序异常,重试http://121.42.157.151:8080/spInfo/retryAction?spProductTaskId="+dmLogin.getSpProductTaskId());
							}
							continue;
						}
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
						System.out.println("token是非法"+html);
					}else if(html.indexOf("该帐号已登录或上一次登录未正常退出系统，继续登录则已登录的用户将被强制退出系统，是否继续？")!=-1){
						System.out.println("该帐号已登录"+html);
						String usmLogConfirmUrl = "https://218.207.208.43:9083/bicp/usmLogConfirm.action?BMETheme.name=blue2.0&language=zh_CN&"+BMEWebToken;
						System.out.println(usmLogConfirmUrl);
						html=post_doNetWork(usmLogConfirmUrl,null,cookie,"utf-8",refererUrl,httpclient);
						refererUrl=usmLogConfirmUrl;
					}else{
						System.out.println(html);
					}
					
					if(html.indexOf("资源管理器")!=-1){
						System.out.println("资源管理器"+html);
						String business="http://218.207.208.43:9080/bicp/business.action?BMEBusiness=resourceList&catalogId=/RMS/favourite&resourceType=&"+BMEWebToken+"&BMETimestamp="+System.currentTimeMillis();
						System.out.println(business);
						html=post_doNetWork(business,null,cookie,"utf-8",refererUrl,httpclient);
						refererUrl=business;
						System.out.println(html);
						
						String resourceId="";
						String resourceRefId="";
						String resourceType="";
						String params = "";
						String outputs = "";
						String pageInfo = "";
						String []infs=html.split("</td></tr>");
						boolean result = false;
						String uploadUrl = "";//上传地址
						
						if(type.equals("动漫CP收入")) {
							for(String info:infs){
								//25 收入  29投诉  81或5为月报表
								if(info.indexOf("title=\"25\"")!=-1){
									System.out.println(info);
									resourceId=subStr(info,"resourceId=\"","\"");
									resourceRefId=subStr(info,"resourceRefId=\"","\"");
									resourceType=subStr(info,"resourceType=\"","\"");
									params="[{\"paramName\":\"${输入开始日期}_12\",\"paramOperator\":\">=\",\"buildinType\":false,\"paramValue\":\""+execTime+"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入结束日期}_13\",\"paramOperator\":\"<=\",\"buildinType\":false,\"paramValue\":\""+execTime+"\",\"paramTextValue\":\"\"}]";
									outputs="[{\"fieldId\":\"8aae4d87478bff5d01479214c259055e\",\"displayOrder\":0,\"fieldName\":\"统计日期\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a056b\",\"displayOrder\":1,\"fieldName\":\"省份\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a056d\",\"displayOrder\":2,\"fieldName\":\"地市\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c259055f\",\"displayOrder\":3,\"fieldName\":\"应用id\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c2590560\",\"displayOrder\":4,\"fieldName\":\"应用名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c2590561\",\"displayOrder\":5,\"fieldName\":\"厂商id\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c2590562\",\"displayOrder\":6,\"fieldName\":\"厂商名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a0563\",\"displayOrder\":7,\"fieldName\":\"收入\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a0564\",\"displayOrder\":8,\"fieldName\":\"付费次数\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a0565\",\"displayOrder\":9,\"fieldName\":\"付费用户数\",\"selected\":true},{\"fieldId\":\"8aae4d8748f2bdd4014931c255ac2ce7\",\"displayOrder\":10,\"fieldName\":\"单价\",\"selected\":true},{\"fieldId\":\"8aae4d884fa74cf2014fc9ce8a231701\",\"displayOrder\":11,\"fieldName\":\"CP编码\",\"selected\":true},{\"fieldId\":\"8aae4d884fa74cf2014fc9ce8a231702\",\"displayOrder\":12,\"fieldName\":\"CP名称\",\"selected\":true},{\"fieldId\":\"8aae4d884fa74cf2014fc9ce8a231703\",\"displayOrder\":13,\"fieldName\":\"SDK类型\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a0568\",\"displayOrder\":14,\"fieldName\":\"主渠道ID\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d01479214c25a0569\",\"displayOrder\":15,\"fieldName\":\"主渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d8a512304f1015146856f723e3f\",\"displayOrder\":16,\"fieldName\":\"渠道类型\",\"selected\":true}]";
									pageInfo="{\"curPageNo\":1,\"totalPageCount\":11,\"totalRowCount\":219,\"pageRowCount\":20}";
								}
							}
							uploadUrl = "http://121.42.157.151:8080/spInfo/upIncomeAction_upload.action?dataSource=1";
							
							
						}else if(type.equals("动漫CP投诉")) {
							for(String info:infs){
								//在这里写分支收入还是投诉   25 收入  29投诉
								if(info.indexOf("title=\"29\"")!=-1) {
									System.out.println(info);
									resourceId=subStr(info,"resourceId=\"","\"");
									resourceRefId=subStr(info,"resourceRefId=\"","\"");
									resourceType=subStr(info,"resourceType=\"","\"");
									params="[{\"paramName\":\"${输入开始日期}_10\",\"paramOperator\":\">=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入结束日期}_11\",\"paramOperator\":\"<=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入地市id}_12\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入渠道名称}_14\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入用户号码}_15\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入工单类别}_16\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":\"10010105240401\",\"paramTextValue\":\"不知情定制、取消或变更\"},{\"paramName\":\"${输入CP名称id}_21\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
									outputs="[{\"fieldId\":\"8aae4d87478bff5d0147924028cc0661\",\"displayOrder\":0,\"fieldName\":\"投诉归档日期\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0666\",\"displayOrder\":1,\"fieldName\":\"用户号码\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0663\",\"displayOrder\":2,\"fieldName\":\"省份\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0665\",\"displayOrder\":3,\"fieldName\":\"地市\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0667\",\"displayOrder\":4,\"fieldName\":\"订购日期\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0669\",\"displayOrder\":5,\"fieldName\":\"订购业务名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc066a\",\"displayOrder\":6,\"fieldName\":\"支付费用\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc066c\",\"displayOrder\":7,\"fieldName\":\"渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0673\",\"displayOrder\":8,\"fieldName\":\"子渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc066e\",\"displayOrder\":9,\"fieldName\":\"CP名称\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b81b57d68\",\"displayOrder\":10,\"fieldName\":\"渠道类型\",\"selected\":true},{\"fieldId\":\"8aae4d884c6d5698014c6dda35030589\",\"displayOrder\":11,\"fieldName\":\"应用ID\",\"selected\":true},{\"fieldId\":\"8aae4d884c6d5698014c6dda3503058a\",\"displayOrder\":12,\"fieldName\":\"应用名称\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b81b57d69\",\"displayOrder\":13,\"fieldName\":\"是否同质\",\"selected\":true}]";
									pageInfo="{\"curPageNo\":1,\"totalPageCount\":3,\"totalRowCount\":44,\"pageRowCount\":20}";
								}
							}
							uploadUrl = "http://121.42.157.151:8080/spInfo/uploadComplaintAction_upload.action?dataSource=1";
							
						}else if(type.equals("月报表")){
							for(String info:infs) {
								if(info.indexOf("title=\"81\"")!=-1 || info.indexOf("title=\"5\"")!=-1) {
									resourceId=subStr(info,"resourceId=\"","\"");
									resourceRefId=subStr(info,"resourceRefId=\"","\"");
									resourceType=subStr(info,"resourceType=\"","\"");
									
									String viewAdhoc = "http://218.207.208.43:9080/isdp/adhocView.action?action=viewAdhoc&id="+resourceRefId+"&resOprType=view&language=zh_CN&BMETheme.name=blue2.0&BMEWebToken="+BMEWebToken;
									String res = post_doNetWork(viewAdhoc,null,cookie,"utf-8",refererUrl,httpclient);
									if(res.indexOf("输入查询时间")!=-1) {
										params="[{\"paramName\":\"${输入查询时间}_23\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入合作伙伴类型ID}_26\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
									}else { 
										params="[{\"paramName\":\"${输入统计时间}_23\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入合作伙伴ID}_35\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
									}
									outputs="[{\"fieldId\":\"8aae4d87474a2aa1014786c65a380150\",\"displayOrder\":0,\"fieldName\":\"统计时间\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380153\",\"displayOrder\":1,\"fieldName\":\"省份名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380155\",\"displayOrder\":2,\"fieldName\":\"合作伙伴类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380158\",\"displayOrder\":3,\"fieldName\":\"合作伙伴名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a390164\",\"displayOrder\":4,\"fieldName\":\"业务类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a380159\",\"displayOrder\":5,\"fieldName\":\"投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a39015a\",\"displayOrder\":6,\"fieldName\":\"新增投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a39015b\",\"displayOrder\":7,\"fieldName\":\"不知情投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a39015c\",\"displayOrder\":8,\"fieldName\":\"新增不知情投诉工单量\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a390162\",\"displayOrder\":9,\"fieldName\":\"付费用户数\",\"selected\":true},{\"fieldId\":\"8aae4d8a4d4c01f7014d4c16e8cb0084\",\"displayOrder\":10,\"fieldName\":\"上月至今付费用户数\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b1f487ce2\",\"displayOrder\":11,\"fieldName\":\"是否同质\",\"selected\":true},{\"fieldId\":\"8aae4d8a51b4674b01523a1a96781bdc\",\"displayOrder\":12,\"fieldName\":\"认证渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d8a51b4674b01523a1a96781bdb\",\"displayOrder\":13,\"fieldName\":\"认证渠道ID\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b1f487ce3\",\"displayOrder\":14,\"fieldName\":\"渠道类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014786c65a390163\",\"displayOrder\":15,\"fieldName\":\"本月信息费\",\"selected\":true}]";
									pageInfo="";
								}
							}
							uploadUrl = "http://121.42.157.151:8080/spInfo/upIncomeAction_upload.action?dataSource=8&spProductId="+dmLogin.getSpProductId();
							
						}else if(type.equals("动漫渠道收入")) {
							for(String info:infs) {
								if(info.indexOf("title=\"3\"")!=-1) {
									resourceId=subStr(info,"resourceId=\"","\"");
									resourceRefId=subStr(info,"resourceRefId=\"","\"");
									resourceType=subStr(info,"resourceType=\"","\"");
									params="[{\"paramName\":\"${输入开始日期}_17\",\"paramOperator\":\">=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入结束日期}_18\",\"paramOperator\":\"<=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入省市}_19\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入厂商名称}_20\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入主渠道名称}_21\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入子渠道名称}_22\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入应用名称}_23\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入SDK_TYPE}_31\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入CHANNEL_TYPE}_33\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
									outputs="[{\"fieldId\":\"8aae4d87474a2aa1014783328442005c\",\"displayOrder\":0,\"fieldName\":\"统计日期\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284430069\",\"displayOrder\":1,\"fieldName\":\"省份名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014783328443006b\",\"displayOrder\":2,\"fieldName\":\"地市名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014783328442005d\",\"displayOrder\":3,\"fieldName\":\"应用ID\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014783328442005e\",\"displayOrder\":4,\"fieldName\":\"应用名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284430066\",\"displayOrder\":5,\"fieldName\":\"主渠道ID\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284430067\",\"displayOrder\":6,\"fieldName\":\"主渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284430064\",\"displayOrder\":7,\"fieldName\":\"子渠道ID\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284430065\",\"displayOrder\":8,\"fieldName\":\"子渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa1014783328442005f\",\"displayOrder\":9,\"fieldName\":\"厂商ID\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284420060\",\"displayOrder\":10,\"fieldName\":\"厂商名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284420061\",\"displayOrder\":11,\"fieldName\":\"收入\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284430063\",\"displayOrder\":12,\"fieldName\":\"付费用户数\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa10147833284420062\",\"displayOrder\":13,\"fieldName\":\"付费次数\",\"selected\":true},{\"fieldId\":\"8aae4d8748f2bdd4014931dd5cef2e45\",\"displayOrder\":14,\"fieldName\":\"单价\",\"selected\":true},{\"fieldId\":\"8aae4d8a4fa74da8014fc9dfed8111aa\",\"displayOrder\":15,\"fieldName\":\"SDK类型\",\"selected\":true},{\"fieldId\":\"8aae4d8a512304f1015146b12044467f\",\"displayOrder\":16,\"fieldName\":\"渠道类型\",\"selected\":true}]";
									pageInfo="";
								}
							}
							uploadUrl = "http://121.42.157.151:8080/spInfo/upIncomeAction_upload.action?dataSource=9&spProductId="+dmLogin.getSpProductId();
							
						}else if(type.equals("动漫渠道投诉")) {
							for(String info:infs) {
								if(info.indexOf("title=\"10\"")!=-1) {
									resourceId=subStr(info,"resourceId=\"","\"");
									resourceRefId=subStr(info,"resourceRefId=\"","\"");
									resourceType=subStr(info,"resourceType=\"","\"");
									params="[{\"paramName\":\"${输入开始日期}_11\",\"paramOperator\":\">=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入结束日期}_12\",\"paramOperator\":\"<=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入地市id}_13\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入CP名称}_14\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入渠道名称}_15\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入用户号码}_16\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入工单类别}_17\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
									outputs="[{\"fieldId\":\"8aae4d87474a2aa101478844a29903dd\",\"displayOrder\":0,\"fieldName\":\"投诉归档日期\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903e2\",\"displayOrder\":1,\"fieldName\":\"用户号码\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903df\",\"displayOrder\":2,\"fieldName\":\"省份\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903e1\",\"displayOrder\":3,\"fieldName\":\"地市\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903e3\",\"displayOrder\":4,\"fieldName\":\"订购日期\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903e5\",\"displayOrder\":5,\"fieldName\":\"订购业务名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903e6\",\"displayOrder\":6,\"fieldName\":\"支付费用\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29903e8\",\"displayOrder\":7,\"fieldName\":\"渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29a03ef\",\"displayOrder\":8,\"fieldName\":\"子渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e592dd400e9\",\"displayOrder\":9,\"fieldName\":\"渠道类型\",\"selected\":true},{\"fieldId\":\"8aae4d87474a2aa101478844a29a03ea\",\"displayOrder\":10,\"fieldName\":\"CP名称\",\"selected\":true},{\"fieldId\":\"8aae4d884c6d5698014c6de33d6605f1\",\"displayOrder\":11,\"fieldName\":\"应用ID\",\"selected\":true},{\"fieldId\":\"8aae4d884c6d5698014c6de33d6605f2\",\"displayOrder\":12,\"fieldName\":\"应用名称\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e592dd400ea\",\"displayOrder\":13,\"fieldName\":\"是否同质\",\"selected\":true}]";
									pageInfo="";
								}
							}
							uploadUrl = "http://121.42.157.151:8080/spInfo/uploadComplaintAction_upload.action?dataSource=1";
						}else if(type.equals("全量投诉")) {
							for(String info:infs){
								if(info.indexOf("title=\"29\"")!=-1) {
									resourceId=subStr(info,"resourceId=\"","\"");
									resourceRefId=subStr(info,"resourceRefId=\"","\"");
									resourceType=subStr(info,"resourceType=\"","\"");
									params="[{\"paramName\":\"${输入开始日期}_10\",\"paramOperator\":\">=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入结束日期}_11\",\"paramOperator\":\"<=\",\"buildinType\":false,\"paramValue\":"+execTime+",\"paramTextValue\":\"\"},{\"paramName\":\"${输入地市id}_12\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入渠道名称}_14\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入用户号码}_15\",\"paramOperator\":\"in\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入工单类别}_16\",\"paramOperator\":\"like\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"},{\"paramName\":\"${输入CP名称id}_21\",\"paramOperator\":\"=\",\"buildinType\":false,\"paramValue\":\"\",\"paramTextValue\":\"\"}]";
									outputs="[{\"fieldId\":\"8aae4d87478bff5d0147924028cc0661\",\"displayOrder\":0,\"fieldName\":\"投诉归档日期\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0666\",\"displayOrder\":1,\"fieldName\":\"用户号码\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0663\",\"displayOrder\":2,\"fieldName\":\"省份\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0665\",\"displayOrder\":3,\"fieldName\":\"地市\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0667\",\"displayOrder\":4,\"fieldName\":\"订购日期\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0669\",\"displayOrder\":5,\"fieldName\":\"订购业务名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc066a\",\"displayOrder\":6,\"fieldName\":\"支付费用\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc066c\",\"displayOrder\":7,\"fieldName\":\"渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc0673\",\"displayOrder\":8,\"fieldName\":\"子渠道名称\",\"selected\":true},{\"fieldId\":\"8aae4d87478bff5d0147924028cc066e\",\"displayOrder\":9,\"fieldName\":\"CP名称\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b81b57d68\",\"displayOrder\":10,\"fieldName\":\"渠道类型\",\"selected\":true},{\"fieldId\":\"8aae4d884c6d5698014c6dda35030589\",\"displayOrder\":11,\"fieldName\":\"应用ID\",\"selected\":true},{\"fieldId\":\"8aae4d884c6d5698014c6dda3503058a\",\"displayOrder\":12,\"fieldName\":\"应用名称\",\"selected\":true},{\"fieldId\":\"8aae4d87515b5c5101519e4b81b57d69\",\"displayOrder\":13,\"fieldName\":\"是否同质\",\"selected\":true}]";
									pageInfo="{\"curPageNo\":1,\"totalPageCount\":9,\"totalRowCount\":166,\"pageRowCount\":20}";
								}
							}
							uploadUrl = "http://121.42.157.151:8080/spInfo/uploadComplaintAction_upload.action?dataSource=7";
						}
						String filePath = "." + File.separator + "uuCode" + File.separator + uuid +dmLogin.getSpProductName()+type + ".xls";
						File file = new File(filePath);
						//下载
						result = downLoadFile(file,html,refererUrl,resourceId,cookie,BMEWebToken,execTime,resourceRefId,resourceType,uuid,params,outputs,pageInfo,httpclient,dmLogin);
						if(result) {
							logger.info(type+"上传，文件名为:"+file.getName());
							//上传
							result = uploadFile(file,uploadUrl,type,dmLogin);
							if(!result) {
								if(i==3) {
									map.put(dmLogin.getSpProductTaskId(), dmLogin);
									setMonitor(String.valueOf(dmLogin.getSpProductTaskId()),type,"上传失败,重试http://121.42.157.151:8080/spInfo/retryAction?spProductTaskId="+dmLogin.getSpProductTaskId());
								}
								continue;
							}
							break;
						}else {
							//第四次循环下载失败，发送预警
							if(i==3) {
								map.put(dmLogin.getSpProductTaskId(), dmLogin);
								setMonitor(String.valueOf(dmLogin.getSpProductTaskId()),type,"下载失败,重试http://121.42.157.151:8080/spInfo/retryAction?spProductTaskId="+dmLogin.getSpProductTaskId());
							}
						}
					}else{
						System.out.println(html);
					}
			}
		}
		String usmLogout = "http://218.207.208.43:9080/bicp/usmLogout.action?ssLogin=true&"+BMEWebToken+"&BMETheme.name=blue2.0&language=zh_CN";
		System.out.println(usmLogout);
		post_doNetWork(usmLogout,null,cookie,"utf-8",refererUrl,httpclient);
		}
		
	}
	/**
	 * 下载excel表
	 * @param html
	 * @param refererUrl
	 * @param resourceId
	 * @param cookie
	 * @param BMEWebToken
	 * @param execTime
	 * @param resourceRefId
	 * @param resourceType
	 * @param uuid
	 * @param params
	 * @param outputs
	 * @param pageInfo
	 */
	private boolean downLoadFile(File file,String html,String refererUrl,String resourceId,ArrayList<String> cookie,String BMEWebToken,String execTime,String resourceRefId,String resourceType,String uuid,String params,String outputs,String pageInfo,HttpClient httpclient,DmLogin dmLogin) {
		
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
			new NameValuePair("pageInfo", pageInfo),
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
			logger.error(ExceptionTools.exception(e));
			return false;
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
				new NameValuePair("pageInfo",pageInfo),
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
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file.getPath());
			byte[] b = new byte[1024];
			while((exelIo.read(b)) != -1){
				fos.write(b);
			}
			fos.close();
			if(file.length()>=5120) {
				logger.info("文件大小为："+file.length());
				return true;
			}
		} catch (Exception e) {
			ExceptionTools.exception(e);
		}
		return false;
	}
	
	/**
	 * 上传文件
	 * @param file 上传的文件
	 * @param url 上传地址
	 * @param type 25 收入，29投诉
	 * @return 0重试，1不重试
	 * @throws IOException 
	 */
	private boolean uploadFile(File file, String url,String type,DmLogin dmLogin){
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    
	    try {
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
	        try {
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
	                		map.put(dmLogin.getSpProductTaskId(), dmLogin);
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
	        } finally {
	            response.close();
	        }
	    } catch(Exception e) {
	    	logger.info(e.toString());
	    	map.put(dmLogin.getSpProductTaskId(), dmLogin);
			setMonitor(String.valueOf(dmLogin.getSpProductTaskId()),"月报表","上传异常");
	    }
	    finally {
	        try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return false;
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

	private String post_doNetWork(String netURL,NameValuePair[] postData,ArrayList<String> cookieList,String charsetName,String Referer,HttpClient httpclient) {
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
	
	private InputStream post_doNetWorkIO(String netURL,NameValuePair[] postData,ArrayList<String> cookieList,String Referer,HttpClient httpclient) {
		PostNetWork_singleton postNetWork =null;
		InputStream result=null;
		try {
			postNetWork=new PostNetWork_singleton(netURL);
			postNetWork.setHttpclient(httpclient);
			postNetWork.setSsl(defaultSSL.class);
			postNetWork.setConnectionTimeout(1000*60*2);
			postNetWork.setSoTimeout(1000*60*2);
			
			postNetWork.getPostMethod().addRequestHeader("Upgrade-Insecure-Requests","1");
			postNetWork.getPostMethod().addRequestHeader("Pragma", "no-cache");
			postNetWork.getPostMethod().addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36");
			
			if(Referer!=null){
				postNetWork.getPostMethod().addRequestHeader(Referer, Referer);
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
	
	private String subStr(String val,String key,String endFh){
		String info=val.substring(val.indexOf(key)+key.length(),val.length());
		info=info.substring(0,info.indexOf(endFh));
		return info;
	}

}
