package com.astrolink.util.video2.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

/**
 * @Description:TODO
 * @author miyc
 * @date 2016-8-27
 */
public class Common {

	public static char[] LI = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			.toCharArray();

	private static Random random = new Random();

	public static String getSession(int paramInt) {

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < paramInt; i++) {
			int j = random.nextInt(LI.length);
			buffer.append(String.valueOf(LI[j]));
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}

	public static String getValidCode() {

		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(
					"./properties.properties")));
			String validCode = properties.getProperty("validCode");
			return validCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
