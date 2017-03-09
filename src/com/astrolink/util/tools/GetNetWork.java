package com.astrolink.util.tools;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class GetNetWork {
	private Logger logger = null;
	private GetMethod get = null;
	private NameValuePair[] postData = null;
	private HttpClient httpclient = null;
	private HttpConnectionManagerParams managerParams = null;
	private String infoInputStream = "";
	private int connectionTimeout = 30000;
	private int soTimeout = 30000;
	private int netState = -1;

	private String proxyHost;
	private int proxyPort;
	private String proxyUser="";
	private String proxyPwd="";
	private GetNetWork() {}

	/**
	 * @param url
	 *            链接url
	 */
	public GetNetWork(String url) {
		this.logger = Logger.getLogger(GetNetWork.class);
		this.httpclient = new HttpClient();
		this.get = new GetMethod(url);
	}
	
	// 设置代理
		private void setProxy(HttpClient client) {
			client.getHostConfiguration().setProxy(this.proxyHost,this.proxyPort);
			client.getState().setProxyCredentials(AuthScope.ANY, new UsernamePasswordCredentials(this.proxyUser,this.proxyPwd));
		}
	/**
	 * 访问网络
	 */
	public void executeMethod(boolean isProxy) {
		if (isProxy) // 启用代理
			setProxy(this.httpclient);
		this.get.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		this.managerParams = this.httpclient.getHttpConnectionManager().getParams();
		this.managerParams.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		// 设置连接超时时间(单位毫秒)
		this.managerParams.setConnectionTimeout(this.connectionTimeout);
		// 设置读数据超时时间(单位毫秒)
		this.managerParams.setSoTimeout(this.soTimeout);
		// 开始访问网路
		try {
			this.netState = this.httpclient.executeMethod(this.get);
		} catch (Exception e) {
			this.logger.error(ExceptionTools.exception(e));
		}
	}
	
	/**
	 * 访问网络
	 */
	public void executeMethod() {
		this.get.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		this.managerParams = this.httpclient.getHttpConnectionManager().getParams();
		this.managerParams.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		// 设置连接超时时间(单位毫秒)
		this.managerParams.setConnectionTimeout(this.connectionTimeout);
		// 设置读数据超时时间(单位毫秒)
		this.managerParams.setSoTimeout(this.soTimeout);
		// 开始访问网路
		try {
			this.netState = this.httpclient.executeMethod(this.get);
		} catch (Exception e) {
			this.logger.error(ExceptionTools.exception(e));
		}
	}

	/**
	 * 返回信息数据流
	 * 
	 * @return
	 */
	public InputStream getInputStream() {
		try {
			byte[] data = this.get.getResponseBody();
			return new ByteArrayInputStream(data);
		} catch (Exception e) {
			this.logger.error(ExceptionTools.exception(e));
		}
		return null;
	}

	/**
	 * 返回信息
	 * 
	 * @return
	 */
	public String getString() {
		try {
			InputStream inputStream = this.get.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer stringBuffer = new StringBuffer();
			String str = "";
			while ((str = br.readLine()) != null) {
				stringBuffer.append(str);
			}
			return stringBuffer.toString();
		} catch (Exception e) {
			this.logger.error(ExceptionTools.exception(e));
		}
		return "";
	}
	
	/**
	 * 返回信息
	 * 
	 * @return
	 */
	public String getString(String charsetName) {
		if(!String.valueOf(charsetName).equals("") && !String.valueOf(charsetName).equals("null")){
			try {
				InputStream inputStream = this.get.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charsetName));
				StringBuffer stringBuffer = new StringBuffer();
				String str = "";
				while ((str = br.readLine()) != null) {
					stringBuffer.append(str);
				}
				return stringBuffer.toString();
			} catch (Exception e) {
				this.logger.error(ExceptionTools.exception(e));
			}
		}else{
			return this.getString();
		}
		return "";
	}
	
	/**
	 * 返回信息
	 * 
	 * @return
	 */
	public String getString(String charsetName,String zipName) {
		if(!String.valueOf(charsetName).equals("") && !String.valueOf(charsetName).equals("null")){
			try {
				InputStream inputStream = this.get.getResponseBodyAsStream();
				BufferedReader br=null;
				if(zipName.equals("GZIP")){
					GZIPInputStream  gzin = new GZIPInputStream(inputStream);  
					br=new BufferedReader(new InputStreamReader(gzin,charsetName));
				}else{
					br=new BufferedReader(new InputStreamReader(inputStream,charsetName));
				}
				StringBuffer stringBuffer = new StringBuffer();
				String str = "";
				while ((str = br.readLine()) != null) {
					stringBuffer.append(str);
				}
				return stringBuffer.toString();
			} catch (Exception e) {
				this.logger.error(ExceptionTools.exception(e));
			}
		}else{
			return this.getString();
		}
		return "";
	}

	/**
	 * 关闭链接
	 */
	public void closeConn() {
		try {
			this.get.releaseConnection();
			((SimpleHttpConnectionManager) this.httpclient.getHttpConnectionManager()).shutdown();
		} catch (Exception e) {
			this.logger.error(ExceptionTools.exception(e));
		}
	}

	/**
	 * 返回联网状态吗
	 * 
	 * @return
	 */
	public int getNetState() {
		return this.netState;
	}

	/**
	 * 获取org.apache.commons.httpclient.methods.PostMethod对象
	 * 
	 * @return org.apache.commons.httpclient.methods.PostMethod
	 */
	public GetMethod getGetMethod() {
		return this.get;
	}

	/**
	 * 获得请求信息
	 * 
	 * @return
	 */
	public String getRequestInfo() {
		HashMap hashMap = new HashMap();
		try {
			// 获取访问url
			hashMap.put("Url", this.get.getURI().toString());

			// 获取请求头信息
			Header[] headers = this.get.getRequestHeaders();
			HashMap headerHm = new HashMap();
			for (Header header : headers) {
				headerHm.put(header.getName(), header.getValue());
			}
			hashMap.put("Headers", headerHm);

		} catch (Exception e) {
			this.logger.error(ExceptionTools.exception(e));
		}
		return JsonTools.getJsonData(hashMap).toString();
	}

	public String getInfoInputStream() {
		return infoInputStream;
	}

	public void setInfoInputStream(String infoInputStream) {
		this.infoInputStream = String.valueOf(infoInputStream);
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getSoTimeout() {
		return soTimeout;
	}

	public void setSoTimeout(int soTimeout) {
		this.soTimeout = soTimeout;
	}

	public NameValuePair[] getPostData() {
		return postData;
	}

	public void setPostData(NameValuePair[] postData) {
		this.postData = postData;

	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUser() {
		return proxyUser;
	}

	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}

	public String getProxyPwd() {
		return proxyPwd;
	}

	public void setProxyPwd(String proxyPwd) {
		this.proxyPwd = proxyPwd;
	}

}
