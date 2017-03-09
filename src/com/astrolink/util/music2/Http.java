package com.astrolink.util.music2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;

public class Http {

	public static String doPost(String url, Map<String,String> headers, String data) {
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			System.out.println(url);
			URLConnection conn = realUrl.openConnection();
			if(headers!=null){
				for(Entry<String, String> entry:headers.entrySet()){    
				     conn.setRequestProperty(entry.getKey(), entry.getValue());
//				     System.out.println(entry.getKey() + ":\t" +entry.getValue());
				}  
			}
			System.out.println(data);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(data);
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
			return "";
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
				return "";
			}
		}
		return result;
	}
}
