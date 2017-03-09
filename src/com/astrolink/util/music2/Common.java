package com.astrolink.util.music2;

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

}
