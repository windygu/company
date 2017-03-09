package com.astrolink.util.video2.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
	public static byte[] enCrypt(byte[] data, byte[] iv, byte[] key) {
		byte[] result = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
			result = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static byte[] deCrypt(byte[] data, byte[] iv, byte[] key) {
		byte[] result = null;
		System.out.println(data.length);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
			result = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static byte[] enCryptNoPadding(byte[] data, byte[] iv, byte[] key) {
		byte[] result = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
			result = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static byte[] deCryptNoPadding(byte[] data, byte[] iv, byte[] key) {
		byte[] result = null;
		System.out.println(data.length);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
			result = cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static String enCrypt2Base64(byte[] data, byte[] iv, byte[] key) {
		return Base64.encode(enCrypt(data,iv,key));
	}

	public static byte[] deCrypt(String base64_data, byte[] iv, byte[] key) {
		return deCrypt(Base64.decode2bytes(base64_data),iv,key);
	}
	
	public static String enCryptNoPadding2Base64(byte[] data, byte[] iv, byte[] key) {
		return Base64.encode(enCrypt(data,iv,key));
	}

	public static byte[] deCryptNoPadding(String base64_data, byte[] iv, byte[] key) {
		return deCrypt(Base64.decode2bytes(base64_data),iv,key);
	}
}
