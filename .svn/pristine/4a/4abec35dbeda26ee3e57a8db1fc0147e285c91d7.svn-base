package com.astrolink.util.game2.utils;

import java.security.Key;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Hmac {

	public static String HmacSHA1(String data, String key) {
		try {
			SecretKeySpec secretkey = new SecretKeySpec(key.getBytes("UTF-8"),
					"HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(((Key) secretkey));
			return Base64
					.encode(mac.doFinal(data.toString().getBytes("UTF-8")))
					.replace("\r\n", "");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return "";
	}
}
