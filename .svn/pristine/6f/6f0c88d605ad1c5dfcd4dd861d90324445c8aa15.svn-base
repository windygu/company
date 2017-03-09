package com.astrolink.util.music2;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Url {

	private static String CHARSET = "UTF-8";

	public static String encode(String data) {
		try {
			return URLEncoder.encode(data, CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decode(String data) {
		try {
			return URLDecoder.decode(data, CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
