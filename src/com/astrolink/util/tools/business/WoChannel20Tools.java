package com.astrolink.util.tools.business;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.astrolink.util.tools.Base64Tools;
import com.astrolink.util.tools.BasicsTools;

public class WoChannel20Tools {
	
	public static String GetDateTime() {
		String tm = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tm = formatter.format(new Date());
		return tm;
	}

	public static String Convert(int a, int b, String aa) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < aa.length(); i++) {
			sum = sum.multiply(BigInteger.valueOf(a)).add(BigInteger.valueOf(GetNum(aa.charAt(i))));
		}
		String bb = "";
		while (!sum.equals(BigInteger.ZERO)) {
			bb = Retchar(sum.mod(BigInteger.valueOf(b)).intValue()) + bb;
			sum = sum.divide(BigInteger.valueOf(b));
		}
		if (bb.equals(""))
			bb = "0";
		return bb;
	}

	public static char Retchar(int i) {
		if (i <= 9)
			return (char) (i + '0');
		else
			if (i >= 10 && i <= 35)
				return (char) (i - 10 + 'A');
			else
				return (char) (i - 36 + 'a');
	}

	public static int GetNum(char m) {
		if (m >= '0' && m <= '9')
			return m - '0';
		else
			if (m >= 'A' && m <= 'Z')
				return m - 'A' + 10;
			else
				return m - 'a' + 36;
	}

	/**
	 * 3DES Encryption
	 * 
	 * @param key
	 * @param iv
	 * @param data
	 * @return
	 */
	public static String EnDES(byte[] key, byte[] iv, String data) {
		String result = "";
		int dataLen = data.length();
		int block = 8;
		if (dataLen % 8 != 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(data);
			for (int i = 0; i < block - (dataLen % 8); i++)
				sb.append(" ");
			data = new String(sb);
			// System.out.println("padded data:"+data);
		}
		try {
			Cipher cipher = Cipher.getInstance("DESede/CBC/NOPadding"); // NOPadding
																		// PKCS5Padding
			SecretKey secureKey = new SecretKeySpec(key, "DESede");
			IvParameterSpec ips = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, secureKey, ips);
			if (BasicsTools.getSystemProperties("os.name").indexOf("Windows") != -1) {
				result = Base64Tools.encodeStr(cipher.doFinal(data.getBytes())).replaceAll("\r\n", "");
			} else {
				result = Base64Tools.encodeStr(cipher.doFinal(data.getBytes())).replaceAll("\n", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 3DES Decryption
	 * 
	 * @param key
	 * @param iv
	 * @param data
	 * @return
	 */
	public static String DeDES(byte[] key, byte[] iv, String data) {
		String result = "";
		try {
			Cipher cipher = Cipher.getInstance("DESede/CBC/NOPadding"); // NOPadding
																		// PKCS5Padding
			SecretKey secureKey = new SecretKeySpec(key, "DESede");
			IvParameterSpec ips = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, secureKey, ips);
			result = new String(cipher.doFinal(Base64Tools.decodeStr(data)));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String DeSMS(byte[] key, byte[] iv, String data) {
		String result = "";
		try {
			Cipher cipher = Cipher.getInstance("DESede/CBC/NOPadding"); // NOPadding
																		// PKCS5Padding
			SecretKey secureKey = new SecretKeySpec(key, "DESede");
			IvParameterSpec ips = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, secureKey, ips);
			result = new String(cipher.doFinal(Base64Tools.decodeStr(data)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// For net request
	public static byte[] writeByteArray(InputStream inputstream) {
		try {
			InputStream in = parseInputStream(inputstream);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = in.read(b, 0, b.length)) != -1) {
				baos.write(b, 0, len);
			}
			in.close();
			baos.close();
			byte[] data = baos.toByteArray();
			return null != data && data.length > 10 ? data : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static InputStream parseInputStream(InputStream inputStream) {
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		InputStream in = null;
		try {
			bis.mark(2);
			// 取前两个字节
			byte[] header = new byte[2];
			int result = bis.read(header);
			// reset输入流到起始位置
			bis.reset();
			// 判断是否是GZIP格式
			int headerData = getShort(header);
			if (result != -1 && headerData == 0x1f8b) {
				in = new GZIPInputStream(bis);
			} else {
				in = bis;
			}
			return in;
		} catch (Exception e) {
			e.printStackTrace();
			return bis;
		}
	}

	public static int getShort(byte[] data) {
		int header = (data[0] << 8) | data[1] & 0xFF;
		return header;
	}
	
	public static String GetYMDHMSTime() {
		String tm = "";
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		tm = fm.format(new Date());
		return tm;
	}
}
