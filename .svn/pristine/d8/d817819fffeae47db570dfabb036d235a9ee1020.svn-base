package com.astrolink.util.game2.utils;

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

	/**
	 * 从字符串中截取内容
	 * 
	 * @param content
	 * @param startLabel
	 * @param endLabel
	 * @return
	 */
	public static String getValue(String content, String startLabel,
			String endLabel) {
		int start = content.indexOf(startLabel) + startLabel.length();
		int end = content.indexOf(endLabel, start);
		return content.substring(start, end);
	}

	public static String getValue(String content, String startLabel,
			String endLabel, int startIndex) {
		int start = content.indexOf(startLabel, startIndex)
				+ startLabel.length();
		int end = content.indexOf(endLabel, start);
		return content.substring(start, end);
	}

}
