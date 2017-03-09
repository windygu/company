package com.astrolink.util.tools;

import org.apache.commons.codec.binary.Base64;

public class Base64Tools {
	/**
	 * 解密
	 * 
	 * @param pwd
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static byte[] decodeStr(String pwd) {
		Base64 base64 = new Base64();
		return base64.decodeBase64(new String(pwd).getBytes());
	}

	/**
	 * 加密
	 * 
	 * @param bs
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String encodeStr(byte[] bs) {
		Base64 base64 = new Base64();
		byte[] enbytes = base64.encodeBase64Chunked(bs);
		return new String(enbytes);
	}
}
