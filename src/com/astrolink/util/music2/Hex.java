package com.astrolink.util.music2;

public class Hex {
	public static String bytes2HexString(byte[] bytes) {
		char[] result = new char[2 * bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			int j = (char) (0xF & (0xF0 & bytes[i]) >> 4);
			int k = i * 2;
			if (j <= 9) {
				j = j + 48;
			} else {
				j = j + 65 - 10;
			}
			result[k] = (char) j;
			j = (char) (0xF & bytes[i]);
			k = 1 + i * 2;
			if (j <= 9) {
				j = j + 48;
			} else {
				j = j + 65 - 10;
			}
			result[k] = (char) j;
		}
		return new String(result);
	}
	
	public static byte[] hexString2Bytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	
	public static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
}
