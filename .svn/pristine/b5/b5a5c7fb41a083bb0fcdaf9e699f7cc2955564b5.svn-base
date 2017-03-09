package com.astrolink.util.game2.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
	public static String encode(byte[] data) {
		return new String(new BASE64Encoder().encode(data));
	}

	public static String encode(String data) {
		return new String(new BASE64Encoder().encode(data.getBytes()));
	}

	public static byte[] decode2bytes(String data) {
		try {
			return new BASE64Decoder().decodeBuffer(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String decode2string(String data) {
		try {
			return new String(new BASE64Decoder().decodeBuffer(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
