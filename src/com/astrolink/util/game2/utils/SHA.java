package com.astrolink.util.game2.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	public static String SHA12Base64(byte[] data){
		return Base64.encode(SHA1(data));
	}
	public static String SHA2562Base64(byte[] data){
		return Base64.encode(SHA256(data));
	}
	public static String SHA12Hex(byte[] data){
		return Hex.bytes2HexString(SHA1(data));
	}
	public static String SHA2562Hex(byte[] data){
		return Hex.bytes2HexString(SHA256(data));
	}
	
	public static byte[] SHA1(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(data);
			byte result[] = digest.digest();
			return result;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] SHA256(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(data);
			byte result[] = digest.digest();
			return result;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
}
