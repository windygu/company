package com.astrolink.util.tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;

/**
 * @Description:联网控制
 * @author miyc
 * @date 2014-8-6
 */
@SuppressWarnings({ "unused", "deprecation" })
public class NetManager {

	private static NetManager instance;
	public static String RESPONSE_FAIL = "-1";
	private static SSLSocketFactory mSSLSocketFactory;

	public static NetManager getInstance() {
		if (instance == null) {
			instance = new NetManager();
			SSLContext sslContext = instance.sslContextForTrustedCertificates();
			mSSLSocketFactory = sslContext.getSocketFactory();
		}
		return instance;
	}

	public SSLContext sslContextForTrustedCertificates() {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miMT();
		trustAllCerts[0] = tm;
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, null);
			// javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return sc;
	}

	final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};

	public NetResult HTTPSConnectGet(String urlString, String[][] headers) {
		NetResult result = new NetResult();
		if (!urlString.startsWith("https://")) {
			urlString = "https://" + urlString;
		}
		try {
			URL url = new URL(urlString);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setInstanceFollowRedirects(true);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setSSLSocketFactory(mSSLSocketFactory);
			conn.setHostnameVerifier((DO_NOT_VERIFY));
			if (headers != null && headers.length > 0) {
				for (int i = 0; i < headers.length; i++) {
					conn.addRequestProperty(headers[i][0], headers[i][1]);
				}
			}

			String cookie = getCookie(conn);
			result.setCookie(cookie);
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				// s.append(str);
				bos.write(b, 0, len);
			}
			bos.flush();
			bos.close();
			result.data = bos.toByteArray();
			is.close();
			conn.disconnect();
			result.setCode("200");
			result.setContent(new String(result.data));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public NetResult HTTPSConnectPost(String urlString, String[][] headers,
			String[][] upload) {
		NetResult result = new NetResult();
		if (!urlString.startsWith("https://")) {
			urlString = "https://" + urlString;
		}
		try {
			URL url = new URL(urlString);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setInstanceFollowRedirects(true);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setSSLSocketFactory(mSSLSocketFactory);
			conn.setHostnameVerifier((DO_NOT_VERIFY));
			if (headers != null && headers.length > 0) {
				for (int i = 0; i < headers.length; i++) {
					conn.addRequestProperty(headers[i][0], headers[i][1]);
				}
			}
			conn.connect();

			if (upload != null) {
				DataOutputStream out = new DataOutputStream(
						conn.getOutputStream());
				String content = null;
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < upload.length; i++) {
					if (i > 0) {
						builder.append("&");
					}
					builder.append(upload[i][0]);
					builder.append("=");
					builder.append(upload[i][1]);
				}
				content = builder.toString();
				out.writeBytes(content);
				out.flush();
				out.close();
			}

			String cookie = getCookie(conn);
			result.setCookie(cookie);
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String response = "";
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				response = response + readLine;
			}
			is.close();
			br.close();
			conn.disconnect();
			result.setCode("200");
			result.setContent(response);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// HTTP连接
	public NetResult HTTPConnectGet(String urlString, String[][] headers,
			boolean auto) {
		NetResult result = new NetResult();
		if (!urlString.startsWith("http://")) {
			urlString = "http://" + urlString;
		}
		// String result = null;
		// 取得取得默认的HttpClient实例
		DefaultHttpClient client = new DefaultHttpClient();
		// 请求超时
		// client.getParams().setParameter(
		// CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
		// 读取超时
		// client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
		// 20000);

		client.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, auto);
		HttpGet get = new HttpGet(urlString);
		InputStream is = null;
		BufferedReader in = null;
		try {

			if (headers != null && headers.length > 0) {
				for (int i = 0; i < headers.length; i++) {
					get.setHeader(headers[i][0], headers[i][1]);
				}
			}
			// 连接服务器
			HttpResponse response = client.execute(get);

			// 取得数据记录
			HttpEntity entity = response.getEntity();

			int code = response.getStatusLine().getStatusCode();
			if (code != HttpURLConnection.HTTP_OK
					&& code != HttpURLConnection.HTTP_MOVED_TEMP) {
				return new NetResult(code + "", null);
			}
			// 取得数据记录内容
			is = entity.getContent();
			// 显示数据记录内容
			// in = new BufferedReader(new InputStreamReader(is));
			// String str = "";// in.readLine();
			// StringBuffer s = new StringBuffer("");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				// s.append(str);
				bos.write(b, 0, len);
			}
			bos.flush();
			bos.close();
			result.data = bos.toByteArray();
			Header lastHeader = response.getLastHeader("Location");
			if (lastHeader != null) {
				result.location = lastHeader.getValue();
			}
			result.setCookie(getCookie(client));
			// 释放连接
			client.getConnectionManager().shutdown();
			result.setCode(code + "");
			result.setContent(new String(result.data));
			if (is != null) {
				is.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// HTTP连接
	public NetResult HTTPConnectGet(String urlString, String[][] headers) {

		return HTTPConnectGet(urlString, headers, true);
	}

	private String getCookie(HttpClient httpClient) {
		List<Cookie> cookies = ((AbstractHttpClient) httpClient)
				.getCookieStore().getCookies();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cookies.size(); i++) {
			Cookie cookie = cookies.get(i);
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			if (cookieName != null && !"".equals(cookieName)
					&& cookieValue != null && !"".equals(cookieValue)) {
				sb.append(cookieName + "=");
				sb.append(cookieValue + ";");
			}
		}
		try {
			return URLEncoder.encode(sb.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public final NetResult HTTPConnectPost(String url, String[][] headers,
			String[][] upload) {
		return HTTPConnectPost(url, headers, upload, null);
	}

	public final NetResult HTTPConnectPost(String url, String[][] headers,
			String[][] upload, String xml) {
		NetResult result = new NetResult();
		if (!url.startsWith("http://")) {
			url = "http://" + url;
		}
		// String result = null;
		HttpPost post = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			// 请求超时
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
			// 读取超时
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					20000);

			// HttpHost proxy = new HttpHost("192.168.254.136", 8888);
			// client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
			// proxy);
			post = new HttpPost(url);
			if (headers != null && headers.length > 0) {
				for (int i = 0; i < headers.length; i++) {
					post.setHeader(headers[i][0], headers[i][1]);
				}
			}
			if (upload != null && upload.length > 0) {
				List<BasicNameValuePair> uploadPair = new ArrayList<BasicNameValuePair>();
				for (int i = 0; i < upload.length; i++) {
					BasicNameValuePair pair = new BasicNameValuePair(
							upload[i][0], upload[i][1]);
					uploadPair.add(pair);
				}
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
						uploadPair, HTTP.UTF_8);
				post.setEntity(entity);
			}
			if (xml != null && xml.length() > 0) {
				StringEntity se = new StringEntity(xml, "UTF-8");
				se.setContentType("text/xml; charset=" + "UTF-8");
				post.setEntity(se);
			}

			HttpResponse resp = client.execute(post);
			int responseCode = resp.getStatusLine().getStatusCode();
			String code = String.valueOf(responseCode);
			result.setCookie(getCookie(client));
			if (responseCode != HttpURLConnection.HTTP_OK) {// 返回状态码不是成功时
				result.setCode(code);
				return result;
			}

			HttpEntity entity = resp.getEntity();

			InputStream in = entity.getContent();
			// String msg = new String(writeByteArray(in), "UTF-8");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int len;
			while ((len = in.read(b)) != -1) {
				// s.append(str);
				bos.write(b, 0, len);
			}
			bos.flush();
			bos.close();
			result.data = bos.toByteArray();
			result.setCode(code);
			result.setContent(new String(result.data));
			// result.setContent(msg);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
	}

	// 向服务器发送post请求
	public NetResult doGet(String urlAddress) {
		NetResult result = new NetResult();
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection uRLConnection = (HttpURLConnection) url
					.openConnection();
			uRLConnection.setDoInput(true);
			uRLConnection.setDoOutput(true);
			uRLConnection.setConnectTimeout(20000);
			uRLConnection.setRequestMethod("GET");
			uRLConnection.setUseCaches(false);
			uRLConnection.setInstanceFollowRedirects(true);
			uRLConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			uRLConnection.connect();

			InputStream is = uRLConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String response = "";
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				response = response + readLine;
			}
			is.close();
			br.close();
			uRLConnection.disconnect();
			result.setCode("200");
			result.setContent(response);
			return result;
		} catch (Exception e) {
			return result;
		}
	}

	public String getCookie(URLConnection conn) {
		Map<String, List<String>> headerFields = conn.getHeaderFields();

		StringBuffer sb = new StringBuffer();

		Set<Entry<String, List<String>>> entrySet = headerFields.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			String key = entry.getKey();
			if (key == null || !key.contains("Cookie")) {
				continue;
			}
			List<String> value = entry.getValue();
			for (String string : value) {
				if (key != null && !"".equals(key) && string != null
						&& !"".equals(string)) {
					sb.append(string.split(";")[0] + ";");
				}
			}
		}
		try {
			return URLEncoder.encode(sb.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public NetResult network(String url, String[][] headers, String content) {
		NetResult result = new NetResult();
		try {
			URL realUrl = new URL("http://sdk2.cmvideo.cn/clt30/test.jsp");
			URLConnection conn = realUrl.openConnection();
			conn.setConnectTimeout(3000);

			if (headers != null && headers.length > 0) {
				for (int i = 0; i < headers.length; i++) {
					conn.setRequestProperty(headers[i][0], headers[i][1]);
				}
			}
			conn.setDoOutput(true);
			conn.setDoInput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			out.print(content);
			out.flush();

			InputStream in = conn.getInputStream();
			String msg = new String(writeByteArray(in), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int getShort(byte[] data) {
		int header = (data[0] << 8) | data[1] & 0xFF;
		return header;
	}

	public static InputStream parseInputStream(InputStream inputStream) {
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		InputStream in = null;
		try {
			bis.mark(2);
			byte[] header = new byte[2];
			int result = bis.read(header);
			bis.reset();
			int headerData = getShort(header);
			if (result != -1 && headerData == 0x1f8b) {
				in = new GZIPInputStream(bis);
			} else {
				in = bis;
			}
			return in;
		} catch (Exception e) {
			e.printStackTrace();
			return bis;
		}
	}

	public byte[] writeByteArray(InputStream inputstream) {
		try {
			InputStream in = parseInputStream(inputstream);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = in.read(b, 0, b.length)) != -1) {
				baos.write(b, 0, len);
			}
			in.close();
			baos.close();
			byte[] data = baos.toByteArray();
			return null != data && data.length > 10 ? data : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 向服务器发送post请求
	public NetResult doPost(String urlAddress, String[][] upload) {
		NetResult result = new NetResult();
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection uRLConnection = (HttpURLConnection) url
					.openConnection();
			uRLConnection.setDoInput(true);
			uRLConnection.setDoOutput(true);
			uRLConnection.setConnectTimeout(20000);
			uRLConnection.setRequestMethod("POST");
			uRLConnection.setUseCaches(false);
			uRLConnection.setInstanceFollowRedirects(false);
			uRLConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			uRLConnection.connect();

			if (upload != null) {
				DataOutputStream out = new DataOutputStream(
						uRLConnection.getOutputStream());
				String content = null;
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < upload.length; i++) {
					if (i > 0) {
						builder.append("&");
					}
					builder.append(upload[i][0]);
					builder.append("=");
					builder.append(upload[i][1]);
				}
				content = builder.toString();
				out.writeBytes(content);
				out.flush();
				out.close();
			}

			InputStream is = uRLConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String response = "";
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				// response = br.readLine();
				response = response + readLine;
			}
			is.close();
			br.close();
			uRLConnection.disconnect();
			result.setCode("200");
			result.setContent(response);
			return result;
		} catch (Exception e) {
			return result;
		}
	}

	public byte[] downloadByURL(String url) {
		InputStream in = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.connect();
			in = conn.getInputStream();
			byte[] bytes = readInstream(in, 0);
			return bytes;
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				// ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 读取指定字节的内容 leng 字节长度
	 */
	public static byte[] readInstream(InputStream inputStream, int leng)
			throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();// 创建ByteArrayOutputStream类
		byte[] buffer = new byte[1024];// 声明缓存区
		int length = -1;// 定义读取的默认长度
		while ((length = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, length);// 把缓存区中的输入到内存中
			if (leng != 0 && bos.size() > leng) {
				break;
			}
		}
		bos.close();// 关闭输入流
		inputStream.close();// 关闭输入流

		return bos.toByteArray();// 返回这个输入流的字节数组
	}

}
