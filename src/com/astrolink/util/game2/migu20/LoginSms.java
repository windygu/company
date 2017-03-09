package com.astrolink.util.game2.migu20;

/**
 * @Description:TODO
 * @author miyc
 * @date 2016-12-21
 */
public class LoginSms {

	private static int[] abd;
	private static int abe;

	private static byte[] aba = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1,
			-1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1,
			-1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
			41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
	private static String abb = "emag+/HF";
	private static char[] aaZ = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '+', '/' };
	static {
		bV(abb);
	}

	public static String generateLoginSMS(String imsi, String rand4num,
			String imei, String sdk_int, String chid, String contentid,
			String BRAND, String MODEL, String netstat, String sdkversion,
			String sdkSessionId, String packer) {
		String result = "BUB@T|";
		if (netstat.equals("NONE")) {
			result = "BUB@|";
		}
		result += encodeLoginSMS((imsi + "@" + rand4num + "@" + imei + "@"
				+ sdk_int + "@" + chid + "@" + contentid + "@"
				+ fixStr(BRAND, 10) + "@" + fixStr(MODEL, 12) + "@" + netstat
				+ "@" + sdkversion + "@" + sdkSessionId + "@" + packer)
				.replace("\r", "").replace("\n", "").replace("\r\n", "")
				.replace("��", ""));
		System.out.println("sms addresss:\n10658422\nsms content:\n" + result);
		return result;
	}

	public static String fixStr(String str, int maxLen) {
		int v0 = 0;
		if (maxLen > 0 || str != null) {
			if (maxLen > 0 && str == null) {
				str = "";
				while (true) {
					if (v0 < maxLen) {
						str = String.valueOf(str) + "0";
						++v0;
						continue;
					} else {
						return str;
					}
				}
			}
			if (str.length() <= maxLen) {
				return str;
			}

			if (str.length() <= maxLen) {
				return str;
			}

			if (maxLen <= 3) {
				return str;
			}
			str = str.substring(0, maxLen);
		}

		return str;
	}

	public static String encodeLoginSMS(String arg6) {

		String v0_1;
		int v0 = 0;
		if (arg6 == null) {
			v0_1 = null;
		} else {
			int v1 = arg6.length() % abe;
			if (v1 != 0) {
				char[] v2 = new char[abe - v1];
				int v3 = v2.length;
				for (v1 = 0; v1 < v3; ++v1) {
					v2[v1] = ' ';
				}

				arg6 = String.valueOf(arg6) + new String(v2);
			}

			int v2_1 = arg6.length();
			char[] v3_1 = new char[v2_1];
			for (v1 = 0; v1 < v2_1; ++v1) {
				v3_1[v1] = arg6.charAt(abd[v1 % abe] + abe * v0);
				if (v1 != 0 && (v1 + 1) % abe == 0) {
					++v0;
				}
			}

			v0_1 = bW(new String(v3_1));
		}

		return v0_1;
	}

	private static String bW(String arg5) {
		String v1;
		if (arg5 == null) {
			v1 = null;
		} else {
			v1 = new String();
			StringBuffer v3 = new StringBuffer(arg5).reverse();
			int v0;
			for (v0 = 0; v0 < v3.length(); ++v0) {
				char v2 = v3.charAt(v0);
				if (b(v2)) {
					v1 = String.valueOf(v1) + v2;
				} else {
					v2 = ((char) (v2 ^ 8));
					if (b(v2)) {
						v2 = ((char) (v2 ^ 8));
					}

					v1 = String.valueOf(v1) + v2;
				}
			}
		}

		return v1;
	}

	private static void bV(String arg6) {
		int v1 = 0;
		int[] v3 = new int[aaZ.length];
		int v2 = arg6.length();
		abe = v2;
		int v0;
		for (v0 = 0; v0 < v2; ++v0) {
			v3[a(arg6.charAt(v0))] = v0;
		}

		abd = new int[v2];
		v0 = 1;
		while (v1 < aaZ.length) {
			if (v3[v1] != 0) {
				abd[v3[v1]] = v0;
				++v0;
			}

			++v1;
		}
	}

	private static boolean b(char arg1) {
		if (arg1 < 48 || arg1 > 57) {
			if (arg1 >= 65 && arg1 <= 90) {
				return false;
			}

			if (arg1 >= 97 && arg1 <= 122) {
				return false;
			}
			return true;
		} else {
			return false;
		}

	}

	private static int a(char arg3) {
		int v1 = aaZ.length;
		int v0;
		for (v0 = 0; v0 < v1; ++v0) {
			if (aaZ[v0] == arg3) {
				return v0;
			}
		}

		return v0;
	}

}
