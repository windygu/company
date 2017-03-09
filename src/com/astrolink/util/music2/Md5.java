package com.astrolink.util.music2;

import java.security.MessageDigest;

public class Md5 {
	public static String md5Base64(byte[] data) {
		return Base64.encode(md52bytes(data));
	}
	
	public static String md52String32(byte[] data) {
		return Hex.bytes2HexString(md52bytes(data));
	}
	
	public static String md52String16(byte[] data) {
		return Hex.bytes2HexString(md52bytes(data)).substring(8, 24);
	}
	
	public static byte[] md52bytes(byte[] data) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(data);
			return messageDigest.digest();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
