package com.astrolink.util.tools.business;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.astrolink.util.tools.Base64;

public class CryptUtil {
	private static final char[] DIGITS;
	private static final byte[] defaultIV;
	private static final String desAlgorithm = "DESede/CBC/NoPadding";
	private static final String desKeyAlgorithm = "DESede";

	static {
		char[] arrayOfChar = new char[16];
		arrayOfChar[0] = 48;
		arrayOfChar[1] = 49;
		arrayOfChar[2] = 50;
		arrayOfChar[3] = 51;
		arrayOfChar[4] = 52;
		arrayOfChar[5] = 53;
		arrayOfChar[6] = 54;
		arrayOfChar[7] = 55;
		arrayOfChar[8] = 56;
		arrayOfChar[9] = 57;
		arrayOfChar[10] = 97;
		arrayOfChar[11] = 98;
		arrayOfChar[12] = 99;
		arrayOfChar[13] = 100;
		arrayOfChar[14] = 101;
		arrayOfChar[15] = 102;
		DIGITS = arrayOfChar;
		byte[] arrayOfByte = new byte[8];
		arrayOfByte[0] = 48;
		arrayOfByte[1] = 48;
		arrayOfByte[2] = 48;
		arrayOfByte[3] = 48;
		arrayOfByte[4] = 48;
		arrayOfByte[5] = 48;
		arrayOfByte[6] = 48;
		arrayOfByte[7] = 48;
		defaultIV = arrayOfByte;
	}

	private static IvParameterSpec IvGenerator(byte[] paramArrayOfByte) {
		return new IvParameterSpec(paramArrayOfByte);
	}

	private static SecretKey KeyGenerator(String paramString) {
		try {
			byte[] arrayOfByte = md5Hex(paramString).substring(0, 24).getBytes("GBK");
			return new SecretKeySpec(arrayOfByte, desKeyAlgorithm);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] cryptBy3Des(String paramString, int paramInt, byte[] byte1, byte[] byte2) {
		SecretKey secretKey = KeyGenerator(paramString);
		IvParameterSpec ips;
		try {
			if (byte1 == null) {
				ips = IvGenerator(defaultIV);
				Cipher localCipher = Cipher.getInstance(desAlgorithm);
				localCipher.init(paramInt, secretKey, ips);
				byte[] arrayOfByte2 = localCipher.doFinal(byte2);
				return arrayOfByte2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decryptBy3Des(byte[] paramArrayOfByte, String paramString) {
	/*	 String str = CryptUtil
				 .decryptBy3DesAndBase64(
				 "ln8oop3ynnJvyGi664LhOOFvibHBxAR8tXtuD6Cc4MiA+uZLxtRaF0bSDRe\\/Hpp\\/1Ufj9dEJUbRJYRx8s+lQFRN7I0R9UybjegSiHp2sYr17OkdzcYtj1zeGPiopuSTR+UY6rG5f7yPfQDMG7gwMp3O+hnFD\\/LMgFrQC6mR8nvb8U95yyS86XXRYYgq9JR\\/9D\\/FQ9vT0YI+ws\\/kYeCRNCU0eu98CCHFjaQVLKnwaeKJdpXFTcXcGvpyci3PQOnKMekuGH33XUCIigH9rI3ZXyyr7xl9SOH8auinAGdzpLNofgkcft4yjzTgi\\/ZZL\\/FzSf2Hp\\/mth1Mwk8vepvrXJijuAerxY76GEE\\/XcPFFE+jX\\/xgrKHXPFfEm338sA7JbVI7Dr4AaevfM+4cB4gM8JAWudQ\\/Ot3Zj2HTkWXtaO6pOl8q4FtZ\\Qhge2oir8DjjoMcu4Wrvh1xTGPFYn9xeDJ9DlHSXxJ1i0l1RTNgqDlbj+F+MD6q2WOA0lSpnHnvbtIupFnnN1m7hy\\/BjkbpGZwThlCopUlCu1gjJK9JRmQ66SpQxlsQdqUpCQuC2r85xoZ+idI2Et1S4Av4CDM+afV5UhFr61xOPkk+bYKpDgEm82UBr7WQIr3MPS0mQFwgImh+yAujWboHw+\\/HCVc7r\\/9dECct0SfAuwN6OKhcvsK\\/kE1+hhJXuw1NRw2c75E8pPBCtKuxc\\/SJLNwCBL2mikJ2smUy5Y+F1L4sutXk12Oi6Su4GzKZZp0J\\/GuwMky5xVEUagFtp\\uhrvSd8lk4tSJqX7fM\\/nZ5EblRI5RJaXv5GJIAAxj\\/WzSJ91ulGPcL4oIafSzM6zWl5D\\/PYaAzSey5m\\/OyUFV4bTBpOcdyrQgWt9k7ZLWTSn65GQWhiclrWFJlC\\/uHcXWBiYW1IcbVcESxfBP8mV5rRVZX3qN3ADM0cDS1NEcSdc\\/4yTKDUnH7Kc7ONtJEbvk4zk7T0X0LAEtLGvbJtACL\\/OHD3zGNVW5OhIX9x+XtbnJgg4faXQZuQOdTy6EzokkOziHDTYrqGb087tOFdE+Oe6aMHLiUtlBVstcc0fkQLCKn6nxofhsPtzsq+pDHqe7n3J2CN9FKpMnoif0wVs0G\\/8D9jQfNhLxkMFBy28VK5gYDUDEH\\/djQb9mWXaVYxBDeojTpJpxZ4MF\\/nbdbIzzgXbAereQnzsavavyGIAXWmilUw3IWevDcv6Y3j6pBbtpfE9vDtFPE6aUkvNolvnz5puxON8aKW6TC7j5Dp6Gjf0sSF8wZxhykS4\\/LcCDywrKIYWAzZZGHNhDkjzFfYNH7Uli9M35vx\\/zg2kyi3RhqZK8lOHz1gYIM7w9q1hWOLpHj\\/Ioa2EYp2tkZIeYAGASwxGBvqEQQkrpbcmqK03kJtlwFkAwWXehMCyzTFsdrzg\\/ONzqCvC4wc9yEruajgN",
				 "logkeyStore");*/
		
		
		
		return cryptBy3Des(paramString, 2, null, paramArrayOfByte);
	}

	public static String decryptBy3DesAndBase64(String paramString1, String paramString2) {
		return decryptBy3DesAndBase64(paramString1, paramString2, "UTF-8");
	}

	public static String decryptBy3DesAndBase64(String paramString1, String paramString2, String paramString3) {
		try {
			String str = new String(decryptBy3Des(Base64.decode(paramString1), paramString2), paramString3).trim();
			return str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static char[] encodeHex(byte[] paramArrayOfByte) {
		int i = 0;
		int j = paramArrayOfByte.length;
		char[] arrayOfChar = new char[j << 1];
		for (int k = 0; k < j; k++) {
			int m = i + 1;
			arrayOfChar[i] = DIGITS[((0xF0 & paramArrayOfByte[k]) >>> 4)];
			i = m + 1;
			arrayOfChar[m] = DIGITS[(0xF & paramArrayOfByte[k])];
		}
		return arrayOfChar;
	}

	public static byte[] encryptBy3Des(byte[] paramArrayOfByte, String paramString) {
		return cryptBy3Des(paramString, 1, null, paramArrayOfByte);
	}

	public static String encryptBy3DesAndBase64(String paramString1, String paramString2) {
		return encryptBy3DesAndBase64(paramString1, paramString2, "UTF-8");
	}

	public static String encryptBy3DesAndBase64(String paramString1, String paramString2, String charset) {
		String str = null;
		try {
			int i = paramString1.length() % 8;
			StringBuffer localStringBuffer = new StringBuffer(paramString1);
			if (i != 0) {
				int j = 8 - i;
				// localStringBuffer = new StringBuffer(paramString1);
				for (int k = 0; k < j; k++)
					localStringBuffer.append(' ');
			}
			// for (Object localObject = new String(localStringBuffer)
			// .getBytes(paramString3);; localObject = arrayOfByte) {
			str = Base64.encode(encryptBy3Des(localStringBuffer.toString().getBytes(charset), paramString2)).replaceAll("[\\n\\r]", "");
			// }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String md5Hex(String paramString) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(paramString.getBytes("GBK"));
			return new String(encodeHex(md.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
