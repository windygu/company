package com.astrolink.util.tools;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.astrolink.dao.Music2ExecLinstenerThreadDao;
import com.astrolink.util.music2.Hmac;
import com.astrolink.util.music2.Http;
import com.astrolink.util.music2.Url;


public class Music2Tools {
	public static String cpid = "9be321bd244faf09c96e9753770a669e";
	public static final String ip = "http://139.129.164.229:8080/migu20Server";
	public static final String port = "music";
	
	public static String md52String32(byte[] bytes) {
		StringBuffer localStringBuffer;
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(bytes);
			byte[] arrayOfByte = localMessageDigest.digest();
			localStringBuffer = new StringBuffer("");
			for (int i2 = 0; i2 < arrayOfByte.length; i2++) {
				int i1 = arrayOfByte[i2];
				if (i1 < 0)
					i1 += 256;
				if (i1 < 16)
					localStringBuffer.append("0");
				localStringBuffer.append(Integer.toHexString(i1));
			}
			return localStringBuffer.toString().toUpperCase();
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
			localNoSuchAlgorithmException.printStackTrace();
		}
		return "";
	}
	
	public static String post_checksmsinitreturn_req(String md5imsi,
			String appid, String pubKey, String packageName, String excode,
			String UA) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",appID=\"" + appid + "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"I1.0\"";
		if (!excode.equals(""))
			Authorization += ",excode=\"" + excode + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/checksmsinitreturn");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:94");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_checksmsinitreturn_req:\n" + result);
		return result;
	}
	

	public static String getContextByTag(String context, String tag) {
		String result = "";
		int start = context.indexOf("<" + tag + ">")
				+ ("<" + tag + ">").length();
		int end = context.indexOf("</" + tag + ">");
		if (start != -1 && end != -1)
			result = context.substring(start, end);
		System.out.println(tag + ":\t" + result);
		if(result==null)result="";
		return result;
	}
	
	public static String getLogTimeStampByMillis(long Millis) {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date(Millis));
	}
	
	public static String getLogTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
	
	// OEPAUTH
	// realm="OEP",IMSI="87E9ADB2CB70AF5DFD6567E8015165C1",chCode="014A1J5",
	// appID="001826456599060449",pubKey="04355A61019679D8246184AF98ABFDB0",netMode="WIFI",
	// packageName="com.bbt.music",version="M2.1",excode="null",definedseq="",imei="862230024780033",
	// sim="460009482520609",os="4.2.2",brand="Hisense",model="HS-U978",mac="34:0a:ff:73:82:8e",payTime="20160829120233"
	public static String post_query_req(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String serviceId, String imei,
			String imsi, String os, String brand, String model, String mac,
			String payTime,String chid) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M1.3\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + imei + "\",sim=\"" + imsi + "\",os=\""
				+ os + "\",brand=\"" + brand + "\",model=\"" + model
				+ "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/cp/query");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version=\'1.0\' encoding=\'UTF-8\'?><request><serviceId>"
					+ serviceId + "</serviceId></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_query_req:\n" + result);
		return result;
	}

	public static String post_serviceEx_req(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String contentId,String chid,String DeviceId,String SubscriberId,String os,String brand,String model,String mac,String payTime,String serviceId) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M2.1\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + DeviceId + "\",sim=\"" + SubscriberId
				+ "\",os=\"" + os + "\",brand=\"" + brand + "\",model=\""
				+ model + "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/cp/serviceEx");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version=\'1.0\' encoding=\'UTF-8\'?><request><contentId>"
					+ serviceId + "</contentId></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_serviceEx_req:\n" + result);
		return result;
	}
	
	public static String post_crbt_info(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String musicId) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",appID=\"" + appid + "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M1.3\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:94/sdkServer/1.0/crbt/info");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:94");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><musicId>"
					+ musicId + "</musicId></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_crbt_info_req:\n" + result);
		return result;
	}
	
	public static String post_search_music_listbychart(String md5imsi,
			String appid, String pubKey, String packageName, String excode,
			String definedseq, String UA, String chartCode,String chid,String DeviceId,String SubscriberId,String os,String brand,String model,String mac,String payTime) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M2.1\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + DeviceId + "\",sim=\"" + SubscriberId
				+ "\",os=\"" + os + "\",brand=\"" + brand + "\",model=\""
				+ model + "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/search/music/listbychart");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><chartCode>"
					+ chartCode
					+ "</chartCode><pageNumber>1</pageNumber><numberPerPage>30</numberPerPage></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_search_music_listbychart_req:\n" + result);
		return result;
	}
	
	public static String post_song_policy(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String musicId) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",appID=\"" + appid + "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M1.3\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/song/policy");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><musicId>"
					+ musicId
					+ "</musicId><resource>000009</resource><resource>020007</resource><resource>020022</resource></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_song_policy_req:\n" + result);
		return result;
	}
	
	public static String post_ring_policy(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String musicId,String chid,String DeviceId,String SubscriberId,String os,String brand,String model,String mac,String payTime) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M2.1\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + DeviceId + "\",sim=\"" + SubscriberId
				+ "\",os=\"" + os + "\",brand=\"" + brand + "\",model=\""
				+ model + "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/ring/policy");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><musicId>"
					+ musicId
					+ "</musicId><resource>000018</resource><resource>999992</resource></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
//		Music2ExecLinstenerThreadDao.logBuff.append("\npost_ring_policy_req:\n" + result);
		return result;
	}
	
	public static String post_cp_open(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String serviceId, String imei,
			String imsi, String os, String brand, String model, String mac,
			String payTime,String chid,StringBuffer logBuff) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M1.3\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + imei + "\",sim=\"" + imsi + "\",os=\""
				+ os + "\",brand=\"" + brand + "\",model=\"" + model
				+ "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/cp/open");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			// <?xml version='1.0'
			// encoding='UTF-8'?><request><serviceId>600967020000006118</serviceId></request>
			out.print("<?xml version=\'1.0\' encoding=\'UTF-8\'?><request><serviceId>"
					+ serviceId + "</serviceId></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		logBuff.append("\npost_cp_open:\n" + result);
		return result;
	}
	
	public static Map<String, String> initHeaders(String apiVersion,
			String SDKVersion, String SEC_VERSION, String nRQd_Lx, String EN,
			String imsi, String imei) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Connection", "Keep-Alive");
		headers.put("Accept-Encoding", "gzip");
		headers.put("Accept", "application/xml");
		headers.put("Response-Type", "xml");
		headers.put("platform", "Android");
		headers.put("Header-Key", "&apiVersion=" + apiVersion + "&SDKVersion="
				+ SDKVersion);
		headers.put("apiVersion", apiVersion);
		headers.put("SDKVersion", SDKVersion);
		headers.put("EnVer", EN);
		headers.put("nRQd-Lx", nRQd_Lx);
		headers.put("scv-Xuw", SEC_VERSION);
		headers.put("imei", imei);
		headers.put("imsi", imsi);
		// headers.put("X-OF-Signature", Signature);
		// headers.put("Header-Signature", Signature);

		return headers;
	}
	
	public static String generate_BaseClientHeader(String sSdkSessionid,
			String isSelfClient, String imei, String imsi, String RELEASE,
			String screen, String BRAND, String MODEL, String SDKVersion,
			String apiVersion, String MacAddr, String Location,
			String local_ip, String NetworkType) {
		// sSdkSessionid 随机16位
		// 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
		// isSelfClient 默认是false 就是0
		// Build$VERSION.RELEASE
		// screen Width*Height
		// Location getLastKnownLocation Double.toString(v2.getLongitude()) +
		// "*" + Double.toString(v2.getLatitude())
		// NetworkType 未连接是0;连接后获取NetworkInfo.getSubtype
		// 1,2,4,7是1;13是3;3,5,6,8,9,10,12,14,15是2;其他是0
		// xdeUEu076NNShPM2^0^863077028536351^460001033136031^4.1.1^720*1280^Xiaomi^MI
		// 2S^12002003^20^f8:a4:5f:5b:d7:f8^^192.168.30.228^0^
		String result = sSdkSessionid + "^" + isSelfClient + "^" + imei + "^"
				+ imsi + "^" + RELEASE + "^" + screen + "^" + BRAND + "^"
				+ MODEL + "^" + SDKVersion + "^" + apiVersion + "^" + MacAddr
				+ "^" + Location + "^" + local_ip + "^" + NetworkType + "^";
		return result;
	}
	
	public static String formateLocalip(String local_ip) {
		String[] ips = local_ip.split("\\.");
		String result = "";
		for (int i = 0; i < ips.length; i++) {
			result += fillby0(ips[i], 3);

			if (i + 1 == ips.length) {
				return result;
			}
			result += ".";
		}
		return "";
	}
	
	public static String fillby0(String data, int len) {
		while (data.length() < len) {
			data = "0" + data;
		}
		return data;
	}
	
	public static int getRandom(int n) {
		Random random = new Random();
		return random.nextInt(n);
	}
	
	public static String generate_ReportStr(String phoneNumber, String imei,
			String imsi, String encodecid, String websessionid,
			String timestamp, String apkstatus, int netcount, int paycount,
			String startcount, String startSecond, String webSecond,
			String soVersion, String migusdkversion, String payReq1,
			String payReq2, String payReq3, String payReq4, String payReq5,
			String MiguPay_FileSHA1, String Serial, String linux_version,
			String Hardware, String local_ip, String callstack, String isRoot,
			String localsessionid) {
		// |0|phoneNumber|imei|imsi|encodecid|unkown1|timestamp|apkstatus|网络请求次数|计费次数|启动次数|unkown2|unkown3|soversion|sdkversion|unkown4|unkown5|unkown6|unkown7|unkown8|文件assets/MiguPay.Sdk20.Lib_xxx_xxx.lib的sha1（可从.MF文件提取）|Serial(\proc\cpuinfo)|linux
		// version(\proc\version)|Hardware(\proc\cpuinfo)|local_ip|callstack|netstat|isRoot|sessionid|
		String result = "|0|" + phoneNumber + "|" + imei + "|" + imsi + "|"
				+ encodecid + "|" + websessionid + "|" + timestamp + "|"
				+ apkstatus + "|" + fillby0((netcount + ""), 4) + "|"
				+ fillby0((paycount + ""), 4) + "|" + startcount + "|"
				+ startSecond + "|" + webSecond + "|" + soVersion + "|"
				+ migusdkversion + "|" + payReq1 + "|" + payReq2 + "|"
				+ payReq3 + "|" + payReq4 + "|" + payReq5 + "|"
				+ MiguPay_FileSHA1 + "|" + Serial + "|" + linux_version + "|"
				+ Hardware + "|" + local_ip + "|" + callstack + "|" + isRoot
				+ "|" + localsessionid + "|";
		return result;
	}
	
	public static String post_tl_initcttl(Map<String, String> headers,
			String BaseClientHeader, String mg20irid, String ReportStr,
			String timeStamp) {
		String result = "";
		String tl_initcttl_raw = generate_tl_initcttl(BaseClientHeader,
				timeStamp);
		String tl_initcttl_req = generateNetSignatureAndEncrypt(
				mg20irid, ReportStr, tl_initcttl_raw, "", "", "");
		// System.out.println(getHmacSHA1("+  +POST+en_initcttlreq=00000589KjrJTaE9R1AGX1JNTNwArcJxQMc5WKT6JpH/o9my7tU4AQQjJz+RvmASYeY8dV7kupuUB1puHV07xo8dbNpPAN5l/Sm30a3X6hrsHay6elyw/5jd4CN+ZhEAtu9Miz5Ed55LYfFR6+cwxAnLKVJGxn1JhTzTo5UW0p1gDj4bwoadcMW872P6WcLYeWu6MLD9SFb+4mPyKOokGQuJmWtMiVfJXGtWWAbrt8ZV6ZZ4yM7zANoAyVSvZUjdoeKLn2UK5CpdyEJ0s1v0/3eWWRn+VT3/g5BqYUkxAiI0jtgxXNde2bShlFf7izoxdIZ7Pz11zLvgk3Mwu1CKKTjJy4Uhq9FLSIi9fBrsAm/y3imV7MYTatPb7Hh5AvT+rJcMCN+bQOZWBmUKZcL2OmEfa86Nxr4vtkBIah6OXcOiymumMH1HMalhmL8X9KJ8e39xtLJhkGAnB7I4SecjbX228Vyd0c9aN183ZqQpmAdvTTSspJFc4N4BGaJjnSyc/1Y3uuswR7C8w28oFCuURfY++5J6NMdixfttGXravNfIjKDRF29lysD245g4sWz5VQ8WdVYeKc9KGqv9qpndGO4eGY7ixaBpCVrO78OOvdQW3KBBAZLWO58wCe3YjgajzB2s4i8JDfNHjqWOz2lo2zMvpSmViZ3wr7W7inQQOYWe1oIBc/fII6hzC3631D6SiCOBhtpXTbzXtp1a8g9lMS0LyqL7gQXGui3/z85gLdIZSsc+Amov0e7Dc8c+jhk1Y1WwFIcBanyrLeetjmET4lJNuCS2TfTFuB6qwQ1OBGvhOMHInfPH1XW3f23WxqOxZSdYkrY/vB3VUJfDG3VfzWvTcuFjy9wU36cCJmzJCQCF6II/3BGnOcdoasyc54AvKilsaj54mooEcku5ff395e0fDmU+uw==&apiVersion=20&SDKVersion=12002003",
		// "  &"));
		String Signature = Hmac.HmacSHA1("+  +POST+en_initcttlreq="
				+ tl_initcttl_req + headers.get("Header-Key"), "  &");
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		tl_initcttl_req = Url.encode(tl_initcttl_req);
		result = Http.doPost("http://gmota.g188.net:8080/migusdk/tl/initcttl",
				headers, "en_initcttlreq=" + tl_initcttl_req);
		System.out.println(result);
		return result;
	}
	
	public static String generate_tl_initcttl(String BaseClientHeader,
			String LogTimeStamp) {
		// <?xml version='1.0' encoding='UTF-8' standalone='yes'
		// ?><request><LogInfo>xdeUEu076NNShPM2^0^863077028536351^460001033136031^4.1.1^720*1280^Xiaomi^MI
		// 2S^12002003^20^f8:a4:5f:5b:d7:f8^^192.168.30.228^0^E0001^20160805152139943^</LogInfo></request>
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request><LogInfo>"
				+ BaseClientHeader
				+ "E0001"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ "</LogInfo></request>";
		return result;
	}
	
	// 2.加密网络请求
	public static String generateNetSignatureAndEncrypt(String mg20irid,
			String ReportStr, String netRaw, String ihJVd, String Lwkn,
			String SDKVersion, String EDstr) {
		String url = ip + "/generateNetSignatureAndEncrypt/" + port + "/"
				+ cpid + "/" + mg20irid;
		String data = "netRaw=" + Url.encode(netRaw) + "&ReportStr="
				+ Url.encode(ReportStr) + "&ihJVd=" + Url.encode(ihJVd)
				+ "&Lwkn=" + Url.encode(Lwkn) + "&SDKVersion="
				+ Url.encode(SDKVersion) + "&EDstr=" + Url.encode(EDstr);
		String result = Http.doPost(url, null, data);
		if (!getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return getContextByTag(result, "netStr");
	}
	
	// 2.加密网络请求
	public static String generateNetSignatureAndEncrypt(String mg20irid,
			String ReportStr, String netRaw, String ihJVd, String Lwkn,
			String SDKVersion) {
		return generateNetSignatureAndEncrypt(mg20irid, ReportStr, netRaw,
				ihJVd, Lwkn, SDKVersion, "");
	}
	
	// 3解密网络请求
	public static String[] DecryptNet1(String mg20irid, String data) {
		String url = ip + "/decryptNet/" + port + "/" + cpid + "/" + mg20irid;
		String param = "netStr=" + Url.encode(data);
		String result = Http.doPost(url, null, param);
		if (!getContextByTag(result, "code").equals("0")) {
			return null;
		}
		String[] results = new String[2];
		results[0] = getContextByTag(result, "netRawStr1");
		results[1] = getContextByTag(result, "netRawStr2");
		return results;
	}
	
	public static String generate_migu_sms(String mg20irid, String imsi,
			String imei, String encodeCID, String rand16Num,
			String smsTimeStamp, String apkstatus) {
		// 00000589863077028536351460001033136031PB3VVCR2w8fiiCsZE50jIAA=d4ad906640a466ca2016070511145621000000000000vImOIk9BI0wThw8VYnATbbbFSgY=
		String result = mg20irid + imei + imsi + encodeCID + rand16Num
				+ smsTimeStamp + apkstatus + "00000000000" + "0";
		// System.out.println(result);
		result = generateSmsSignatureAndEncrypt(mg20irid, result);
		if (result.equals(""))
			return "";
		String sms = "AE2" + result;
		System.out.println("sms addresss:\n1065842232\nsms content:\n" + sms);
		// System.out
		// .println("am start -a android.intent.action.SENDTO -d sms:1065842232 --es sms_body "
		// + "\""
		// + sms.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"",
		// "\\\\\"") + "\"");
		return sms;
	}
	
	// 1.短信计算校验值加加密
	public static String generateSmsSignatureAndEncrypt(String mg20irid,
			String smsRaw) {
		String url = ip + "/generateSmsSignatureAndEncrypt/" + port + "/"
				+ cpid + "/" + mg20irid;
		String data = "smsRaw=" + Url.encode(smsRaw);
		String result = Http.doPost(url, null, data);
		if (!getContextByTag(result, "code").equals("0")) {
			return "";
		}
		return getContextByTag(result, "sms");
	}
	
	public static String getSmsTimeStampByMillis(long Millis) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(Millis));
	}
	
	public static String post_charge_getSession(Map<String, String> headers,
			String mg20irid, String sms, String ReportStr) {
		String result = "";
		String charge_getSession_req = generateNetSignatureAndEncrypt(mg20irid, ReportStr,
						sms.substring(3), "", "", "");
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_sessionreq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/getSession",
				headers, "en_sessionreq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}
	
	public static String generate_policySecLv_queryChargePolicyInfoReq(
			String BaseClientHeader, String phoneNumber, String LogTimeStamp,
			String Ctype, String OrderId, String Fee, String ItemId,
			String cpId, String contentId, String ChannelId, String productId) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<CommLog>"
				+ BaseClientHeader
				+ "E0003"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^"
				+ "1"
				+ "^"
				+ "</CommLog>"
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<PolicyType>0</PolicyType>" // OrderNum 小于等于1则为0否则为1
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<OrderNum>1</OrderNum>"// OrderInfoList数量
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<RedListUsrId></RedListUsrId>"// 不设置
				+ "<BadRecType></BadRecType>" // 不设置
				+ "<OrderInfoList>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>" + "<OrderType></OrderType>" // 不设置
				+ "<BatchSaleFlag>0</BatchSaleFlag>" // 固定
				+ "<SaleNum></SaleNum>"// 不设置
				+ "<ScdChannel></ScdChannel>"// 不设置
				+ "</OrderInfoList>" + "</request>";
		return result;
	}
	
	public static String post_policySecLv_queryChargePolicyInfoReq(
			Map<String, String> headers, String mg20irid, String xml,
			String ReportStr) {
		String result = "";// com.openx.greq.request.Client$3.run(Client.java:127)|2
		String charge_getSession_req = generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "");
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_policyinforeq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/policySecLv/queryChargePolicyInfoReq",
						headers, "en_policyinforeq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}
	
	public static String generate_charge_sessionReq(String ChargePolicy,
			String phoneNumber, String LogTimeStamp, String Ctype,
			String OrderId, String Fee, String ItemId, String cpId,
			String contentId, String ChannelId, String productId, String Cpparam) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<ChargePolicy>"
				+ ChargePolicy
				+ "</ChargePolicy>"
				+ "<RedListUsrId></RedListUsrId>"
				+ "<CommLog></CommLog>" // 不设置
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<RequestTime>"
				+ LogTimeStamp.substring(0, 14)
				+ "</RequestTime>"
				+ "<VasType>1</VasType>"
				+ "<ServType></ServType>"
				+ "<SPCode></SPCode>"
				+ "<LaunchType>0</LaunchType>" // 固定
				+ "<SaleType></SaleType>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ChannelClass></ChannelClass>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<SettleDate>"
				+ LogTimeStamp.substring(0, 8)
				+ "</SettleDate>"
				+ "<MemberType></MemberType>"
				+ "<StartChapter></StartChapter>"
				+ "<Chapter></Chapter>"
				+ "<SessionId></SessionId>"
				+ "<Cpparam>"
				+ Cpparam
				+ "</Cpparam>" + "<Contendesc></Contendesc>" + "</request>";
		return result;
	}
	
	public static String post_charge_sessionReq(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr) {
		String result = "";
		String charge_getSession_req = generateNetSignatureAndEncrypt(mg20irid, ReportStr, xml, "",
						"", "");
		System.out.println(charge_getSession_req);
		String Signature = Hmac.HmacSHA1("+  +POST+en_sessionReq="
				+ charge_getSession_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_getSession_req = Url.encode(charge_getSession_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/sessionReq",
				headers, "en_sessionReq=" + charge_getSession_req);
		System.out.println(result);
		return result;
	}
	
	public static String generate_charge_payReq(String BaseClientHeader,
			String ChargePolicy, String phoneNumber, String ChannelFlag,
			String LogTimeStamp, String Ctype, String OrderId, String Fee,
			String ItemId, String cpId, String contentId, String ChannelId,
			String productId, String Cpparam) {
		String result = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><request>"
				+ "<Ctype>"
				+ Ctype
				+ "</Ctype>"
				+ "<ChargePolicy>"
				+ ChargePolicy
				+ "</ChargePolicy>"
				+ "<RedListUsrId></RedListUsrId>"
				+ "<CommLog>"
				+ BaseClientHeader
				+ "E0004"
				+ "^"
				+ LogTimeStamp
				+ "^"
				+ phoneNumber
				+ "^1^"
				+ ChannelFlag
				+ "^"
				+ "</CommLog>"
				+ "<OrderId>"
				+ OrderId
				+ "</OrderId>"
				+ "<VerifyInfo />"
				+ "<UserID>"
				+ phoneNumber
				+ "</UserID>"
				+ "<RequestTime>"
				+ LogTimeStamp.substring(0, 14)
				+ "</RequestTime>"
				+ "<VasType>1</VasType>"
				+ "<ServType></ServType>"
				+ "<SPCode></SPCode>"
				+ "<LaunchType>0</LaunchType>" // 固定
				+ "<SaleType></SaleType>"
				+ "<CooperateCode>"
				+ cpId
				+ "</CooperateCode>"
				+ "<ChannelCode>"
				+ ChannelId
				+ "</ChannelCode>"
				+ "<ScdChannel></ScdChannel>"
				+ "<ChannelClass></ChannelClass>"
				+ "<ProductCode>"
				+ productId
				+ "</ProductCode>"
				+ "<ContentCode>"
				+ contentId
				+ "</ContentCode>"
				+ "<Fee>"
				+ Fee
				+ "</Fee>"
				+ "<ItemId>"
				+ ItemId
				+ "</ItemId>"
				+ "<SettleDate>"
				+ LogTimeStamp.substring(0, 8)
				+ "</SettleDate>"
				+ "<MemberType>0</MemberType>"
				+ "<StartChapter></StartChapter>"
				+ "<Chapter></Chapter>"
				+ "<SessionId></SessionId>"
				+ "<Cpparam>"
				+ Cpparam
				+ "</Cpparam>"
				+ "<ReserveParam></ReserveParam>"
				+ "<Contendesc></Contendesc>"
				+ "</request>";
		return result;
	}
	
	public static String generate_charge_payReq_EDstr(String version,
			String timeStemp, String imei, int payCount) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(version);
		buffer.append(timeStemp);
		buffer.append(":");
		buffer.append(imei);
		buffer.append(":");
		buffer.append(payCount - 1);
		buffer.append(":");
		buffer.append(payCount - 1);
		buffer.append(":");
		buffer.append(payCount - 1);
		buffer.append(":");
		buffer.append(payCount);
		buffer.append(":");
		buffer.append("tKV4:GetFieldID error");
		return buffer.toString();
	}
	
	public static String post_charge_payReq(Map<String, String> headers,
			String mg20irid, String xml, String ReportStr, String ihJVd,
			String Lwkn, String EDstr) {
		String result = "";
		String charge_payReq_req = generateNetSignatureAndEncrypt(
				mg20irid, ReportStr, xml, ihJVd, Lwkn,
				headers.get("SDKVersion"), EDstr);
		System.out.println(charge_payReq_req);
		String Signature = Hmac.HmacSHA1("+  +POST+add=0&en_billingreq="
				+ charge_payReq_req + headers.get("Header-Key"), "  &");
		// System.out.println(Signature);
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		charge_payReq_req = Url.encode(charge_payReq_req);
		result = Http.doPost(
				"http://gmota.g188.net:8080/migusdk/charge/payReq", headers,
				"add=0&en_billingreq=" + charge_payReq_req);
		System.out.println(result);
		return result;
	}
	
	public static String chargeApkstatus(String apkstatus) {
		int states = Integer.parseInt(apkstatus) + 8;
		if (states < 10) {
			return "0" + states;
		}
		return states + "";
	}
	

	public static String getOrderId(long millis) {
		// 01010 20160830024812456

		return "01010"
				+ getLogTimeStampByMillis(millis - (8 * 60 * 60 * 1000));
	}
	
	public static String post_verification_checkSdkUpdate(
			Map<String, String> headers, String SDKVersion,
			String miguEDVersion, String soVersion) {
		String result = "";
		String verification_checkSdkUpdate_req = "resVersionCode=00000000&sdkVersionCode="
				+ SDKVersion
				+ "&selfSoVersion="
				+ miguEDVersion.substring(miguEDVersion.lastIndexOf('.') + 1)
				+ "&soVersionCode=" + soVersion;
		String Signature = Hmac.HmacSHA1("+  +POST+"
				+ verification_checkSdkUpdate_req + headers.get("Header-Key"),
				"  &");
		verification_checkSdkUpdate_req = "sdkVersionCode=" + SDKVersion
				+ "&soVersionCode=" + soVersion
				+ "&resVersionCode=00000000&selfSoVersion="
				+ miguEDVersion.substring(miguEDVersion.lastIndexOf('.') + 1);// resVersionCode
		// MiguPay.Sdk20.Res不存在
		// 默认就是00000000
		headers.put("X-OF-Signature", Signature);
		headers.put("Header-Signature", Signature);
		result = Http
				.doPost("http://gmota.g188.net:8080/migusdk/verification/checkSdkUpdate",
						headers, verification_checkSdkUpdate_req);
		System.out.println(result);
		return result;
	}
	
	public static String post_album_orderCount(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String musicId,String chid,String DeviceId,String SubscriberId,String os,String brand,String model,String mac,String payTime) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M2.1\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + DeviceId + "\",sim=\"" + SubscriberId
				+ "\",os=\"" + os + "\",brand=\"" + brand + "\",model=\""
				+ model + "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/album/orderCount");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><serviceId>"
					+ musicId
					+ "</serviceId><queryType>2</queryType></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("post_ring_policy_req:\n" + result);
		return result;
	}
	
	public static String billingSuccess(String md5imsi, String miguopen_appid,String pubKey, String packageName, String excode, String definedseq, String UA, String serviceId,String chid,String DeviceId,String SubscriberId,String os,String brand,String model,String mac,String payTime) {
		String post_album_order = post_album_order(md5imsi, miguopen_appid,
				pubKey, packageName, excode, definedseq, UA, serviceId,chid,DeviceId,SubscriberId,os,brand,model,mac,payTime);
		String resCode = getContextByTag(post_album_order, "resCode");
		return resCode;

	}
	
	public static String post_album_order(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String musicId,String chid,String DeviceId,String SubscriberId,String os,String brand,String model,String mac,String payTime) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M2.1\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + DeviceId + "\",sim=\"" + SubscriberId
				+ "\",os=\"" + os + "\",brand=\"" + brand + "\",model=\""
				+ model + "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/album/order");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><serviceId>"
					+ musicId + "</serviceId></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("post_ring_policy_req:\n" + result);
		return result;
	}
	
	public static String post_cp_open(String md5imsi, String appid,
			String pubKey, String packageName, String excode,
			String definedseq, String UA, String serviceId, String imei,
			String imsi, String os, String brand, String model, String mac,
			String payTime, String bizCode, String biztype, String codeRate,String chid,StringBuffer logBuff) {
		String result = "";
		String Authorization = "OEPAUTH realm=\"OEP\",IMSI=\"" + md5imsi
				+ "\",chCode=\"" + chid + "\",appID=\"" + appid
				+ "\",pubKey=\"" + pubKey
				+ "\",netMode=\"WIFI\",packageName=\"" + packageName
				+ "\",version=\"M1.3\",excode=\"";
		if (!excode.equals(""))
			Authorization += excode;
		else
			Authorization += "null";
		Authorization += "\",definedseq=\"" + definedseq + "\"";
		Authorization += ",imei=\"" + imei + "\",sim=\"" + imsi + "\",os=\""
				+ os + "\",brand=\"" + brand + "\",model=\"" + model
				+ "\",mac=\"" + mac + "\",payTime=\"" + payTime + "\"";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.200.227.123:95/sdkServer/1.0/ring/downlink");
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Authorization", Authorization);
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Content-Type", "*/*");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Token", "");
			conn.setRequestProperty("User-Agent", UA);
			conn.setRequestProperty("Host", "218.200.227.123:95");
			conn.setRequestProperty("Accept-Encoding", "gzip");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			out = new PrintWriter(conn.getOutputStream());
			// body = "<?xml version='1.0' encoding='UTF-8'?><request><musicId>"
			// + musicId
			// + "<\\/musicId><bizCode>"
			// + bizCode
			// + "<\\/bizCode><biztype>"
			// + biztype
			// + "<\\/biztype><codeRate>"
			// + codeRate
			// + "<\\/codeRate><\\/request>";
			out.print("<?xml version='1.0' encoding='UTF-8'?><request><musicId>"
					+ serviceId
					+ "</musicId><bizCode>"
					+ bizCode
					+ "</bizCode><biztype>"
					+ biztype
					+ "</biztype><codeRate>"
					+ codeRate + "</codeRate></request>");
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		logBuff.append("post_query_req:\n" + result);
		return result;
	}
	
	public static void downloadByURL(String url,StringBuffer logBuff) {
		InputStream in = null;
		URLConnection conn = null;
		try {
			URL realUrl = new URL(url);
			conn = realUrl.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(30000);
			conn.connect();
			in = conn.getInputStream();
			byte[] bytes = readInstream(in);
//			logBuff.append("musiccontent:"+new String(bytes));
		} catch (Exception e) {
			logBuff.append("发送 GET 请求出现异常！" + e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if(conn!=null){
					conn = null;
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return;
	}
	
	public static byte[] readInstream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream byteArrayOutPutStream = null;
		try {
			byteArrayOutPutStream = new ByteArrayOutputStream();// 创建ByteArrayOutputStream类
			byte[] buffer = new byte[1024];// 声明缓存区
			int length = -1;// 定义读取的默认长度
	//		while ((length = inputStream.read(buffer)) != -1) {
	//			byteArrayOutPutStream.write(buffer, 0, length);// 把缓存区中的输入到内存中
	//		}
	//		;
			inputStream.read(buffer);
			byteArrayOutPutStream.write(buffer);

			return byteArrayOutPutStream.toByteArray();// 返回这个输入流的字节数组
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutPutStream.close();// 关闭输入流
				inputStream.close();// 关闭输入流
		
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
