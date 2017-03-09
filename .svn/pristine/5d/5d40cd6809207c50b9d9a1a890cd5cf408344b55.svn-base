package com.astrolink.util.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.log4j.Logger;

/**
 * 
 * @author cuilei
 * @date 2015-4-15
 */
public class ExceptionTools {

	private static Logger logger = Logger.getLogger(ExceptionTools.class);

	/**
	 * 将异常转成字符串
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static String exception(Throwable t) {

		if (t == null)
			return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			t.printStackTrace(new PrintStream(baos));
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return baos.toString();

	}
}
