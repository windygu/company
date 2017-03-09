/**
 * 作者： 	cuilei
 * 类说明：	Tools接口的实现类
 */
package com.astrolink.util.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.dao.Music2ExecLinstenerThreadDao;
import com.sun.rowset.CachedRowSetImpl;


/**
 * 实现：在项目中常用的方法
 * 
 * @author cuilei
 */
public class BasicsTools {
	public static Logger logger = Logger.getLogger(BasicsTools.class);

	private BasicsTools() {
	}

	/**
	 * 接口说明： 获得服务器时间
	 * 
	 * @param arg0
	 *            时间格式：如yyyy-MM-dd HH:mm:ss
	 * @return java.lang.String
	 */
	public static String getForDate(String arg0) {
		String formatData = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(arg0);
			Calendar rightNow = Calendar.getInstance();
			formatData = sdf.format(rightNow.getTime());
		} catch (Exception e) {
			logger.error(getErrorInfo(e));
		}
		return formatData;
	}

	/**
	 * 接口说明：String类型的时间格式转化
	 * 
	 * @param arg0
	 *            String时间
	 * @param arg1
	 *            时间格式：如yyyy-MM-dd HH:mm:ss
	 * @return java.lang.String
	 */
	public static String dataFormatToStrig(String arg0, String arg1) {
		String DataStr = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(arg1);
			DataStr = sdf.format(arg0);
		} catch (IllegalArgumentException e) {
			logger.error(getErrorInfo(e));
		}
		return DataStr;
	}

	/**
	 * 接口说明：String时间转换Date时间
	 * 
	 * @param arg0
	 *            String类型时间
	 * @param arg1
	 *            时间格式：如yyyy-MM-dd HH:mm:ss
	 * @return java.util.Date
	 * @throws ParseException
	 */
	public static Date dataFormatToData(String arg0, String arg1) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(arg1);
		Date date = sdf.parse(arg0);
		return date;
	}

	/**
	 * 接口说明：时间比较大小
	 * 
	 * @param arg0
	 *            时间1：
	 * @param arg1
	 *            时间2
	 * @param arg2
	 *            时间格式： 如yyyy-MM-dd HH:mm:ss
	 * @return int 0等于、1小于 、2是大于
	 */
	public static Timestamp dataFormatToTimestamp(String arg0, String arg1) {
		DateFormat dateFormat = new SimpleDateFormat(arg1, Locale.ENGLISH);// 设定格式
		dateFormat.setLenient(false);
		Date timeDate = null;
		try {
			timeDate = dateFormat.parse(arg0);
		} catch (ParseException e) {
			logger.error(getErrorInfo(e));
		}
		return new Timestamp(timeDate.getTime());
	}

	/**
	 * 接口说明：时间比较大小
	 * 
	 * @param arg0
	 *            时间1：
	 * @param arg1
	 *            时间2
	 * @param arg2
	 *            时间格式： 如yyyy-MM-dd HH:mm:ss
	 * @return int 0等于、1小于 、2是大于
	 */
	public static int timeComparison(String arg0, String arg1, String arg2) {
		int type = 0;
		java.text.DateFormat df = new java.text.SimpleDateFormat(arg2);
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		java.util.Calendar c2 = java.util.Calendar.getInstance();
		try {
			c1.setTime(df.parse(arg0));
			c2.setTime(df.parse(arg1));
		} catch (java.text.ParseException e) {
			logger.error(getErrorInfo(e));
		}
		int result = c1.compareTo(c2);
		if (result == 0)
			type = 0;
		else if (result < 0)
			type = 1;
		else
			type = 2;
		return type;
	}

	/**
	 * 接口说明：Date时间转换String时间
	 * 
	 * @param arg0
	 *            Date类型时间
	 * @param arg1
	 *            时间格式： 如yyyy-MM-dd HH:mm:ss
	 * @return java.lang.String
	 */
	public static String getDatetostr(Date arg0, String arg1) {
		String dataStr = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(arg1);
			dataStr = sdf.format(arg0);
		} catch (Exception e) {
			logger.error(getErrorInfo(e));
		}
		return dataStr;
	}

	/**
	 * 给定一个日期型字符串，返回加减n天后的日期型字符串
	 * 
	 * @param basicDate
	 *            日期
	 * @param n
	 *            加减天数
	 * @return String(yyyy-mm-dd)
	 */
	public static String nDaysAfterOneDateString(String basicDate, int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = null;
		try {
			tmpDate = df.parse(basicDate);
		} catch (Exception e) {
			logger.error("日期型字符串格式错误", e);
		}
		long nDay = (tmpDate.getTime() / (24 * 60 * 60 * 1000) + 1 + n) * (24 * 60 * 60 * 1000);
		tmpDate.setTime(nDay);

		return df.format(tmpDate);
	}

	/**
	 * 接口说明：生成随机数
	 * 
	 * @param arg0
	 *            boolean类型值 true：生成随机英文字母和数字混合字符串 false：生成随机数字字符串
	 * @param num
	 *            int类型值： 生成的随机数位数
	 * @return java.lang.String
	 */
	public static String getUuid(boolean arg0, int num, Random random) {
		String sRand = "";
		try {
			if (num > 0) {
				if (arg0) {
					char[] engdigit = { '1', '2', '3', '4', '5', '6', '6', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', };
					for (int i = 0; i < num; i++) {
						sRand += String.valueOf(engdigit[random.nextInt(engdigit.length)]);
					}
				} else {
					char[] engdigit = { '1', '2', '3', '4', '5', '6', '6', '9' };
					for (int i = 0; i < num; i++) {
						sRand += String.valueOf(engdigit[random.nextInt(engdigit.length)]);
					}
				}
			} else {
				logger.info("您所要生成的位数必须大于0");
			}
		} catch (Exception e) {
			logger.error(getErrorInfo(e));
		}
		return sRand;
	}

	/**
	 * 获取之间范围的随机数字
	 * 
	 * @param num
	 *            int类型值： 生成的随机数位数
	 * @param random
	 *            java.util.Random
	 * @param engdigit
	 *            随机范围
	 * @return
	 */
	public static int getUuid(int num, Random random, int[] engdigit) {
		int sRand = 0;
		try {
			if (num > 0) {
				for (int i = 0; i < num; i++) {
					sRand = engdigit[random.nextInt(engdigit.length)];
				}
			} else {
				logger.info("toolsImp类中getUuid方法");
			}
		} catch (Exception e) {
			logger.error(getErrorInfo(e));
		}
		return sRand;
	}

	/**
	 * 接口说明：字符编码转换
	 * 
	 * @param arg0
	 *            需要转换的值
	 * @param arg1
	 *            需要转换的编码：如UTF-8
	 * @return java.lang.String
	 */
	public static String getCoding(String string, String coding) {
		String pageEncoding = "";
		try {
			pageEncoding = new String(string.getBytes("iso-8859-1"), coding);
		} catch (UnsupportedEncodingException e) {
			logger.error(getErrorInfo(e));
		}
		return pageEncoding;
	}

	/**
	 * 接口说明：字符编码转换
	 * 
	 * @param arg0
	 *            需要转换的值
	 * @param arg1
	 *            需要转换的编码：如UTF-8
	 * @return java.lang.String
	 */
	public static String getCoding(byte[] string, String coding) {
		String pageEncoding = "";
		try {
			pageEncoding = new String(string, coding);
		} catch (UnsupportedEncodingException e) {
			logger.error(getErrorInfo(e));
		}
		return pageEncoding;
	}

	/**
	 * 接口说明： 去掉重复值 参数列表： 0、Object类型的数组 返回类型： Object类型的数组
	 */
	public static Object getRemoveRepeated(Object[] obj) {
		if (obj != null) {
			Set s = new HashSet();
			for (int i = 0; i < obj.length; i++)
				s.add(obj[i]);
			obj = new Object[s.size()];
			s.toArray(obj);
			return obj;
		} else {
			logger.info("参数不能为空");
			return null;
		}
	}

	/**
	 * 接口说明： 获取指定日期是星期几
	 * 
	 * @param dt
	 *            date类型时间
	 * @return java.lang.String 1-7 代表星期几
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;

		return weekDays[w];
	}

	/**
	 * 接口说明：计算两个日期相差多少天
	 * 
	 * @param startTime
	 *            时间1：
	 * @param endTime
	 *            时间2
	 * @param format
	 *            时间格式： 如yyyy-MM-dd HH:mm:ss
	 * @return java.util.Hashtable key： 天、时、分、秒
	 */
	public static HashMap<String, Long> getDateDiff(String startTime, String endTime, String format) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		long diff;
		HashMap<String, Long> ht = new HashMap<String, Long>();
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			long day = diff / nd;// 计算差多少天
			long hour = diff % nd / nh;// 计算差多少小时
			long min = diff % nd % nh / nm;// 计算差多少分钟
			long sec = diff % nd % nh % nm / ns;// 计算差多少秒
			// 输出结果
			ht.put("day", day);
			ht.put("hour", hour);
			ht.put("min", min);
			ht.put("sec", sec);
		} catch (ParseException e) {
			logger.error(getErrorInfo(e));
		}
		return ht;
	}

	/**
	 * 计算两个时间相差多少秒
	 * 
	 * @param startTime
	 *            起始时间
	 * @param endTime
	 *            结束时间
	 * @param format
	 *            时间格式： 如yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static long getCountSec(String startTime, String endTime, String format) {
		HashMap<String, Long> ht = getDateDiff(startTime, endTime, format);
		long day = ht.get("day") * 24 * 60 * 60;
		long hour = ht.get("hour") * 60 * 60;
		long min = ht.get("min") * 60;
		long sec = ht.get("sec");
		return day + hour + min + sec;
	}

	/**
	 * 判断是否为中文字符
	 * 
	 * @param c
	 *            内容
	 * @return 是返回true，不是返回fasle
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符按串是否是乱码
	 * 
	 * @param strName
	 *            内容
	 * @return 是乱码返回true，不是返回fasle
	 */
	public static boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = ch.length;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) {

				if (!isChinese(c)) {
					count = count + 1;
				}
			}
		}
		float result = count / chLength;
		if (result > 0.4) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取详细错误信息
	 * 
	 * @param info
	 *            错误信息
	 * @param t
	 *            异常类
	 * @return
	 */
	public static String getErrorInfo(Throwable t) {
		String errorInfo = "";
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		try {
			t.printStackTrace(writer);
			StringBuffer buffer = stringWriter.getBuffer();
			errorInfo = buffer.toString();
		} catch (Exception e) {
			logger.error(getErrorInfo(e));
		} finally {
			try {
				writer.close();
				stringWriter.close();
			} catch (IOException e) {
				logger.error(getErrorInfo(e));
			}
		}
		return errorInfo;
	}

	/**
	 * 把多条json拼接成一条
	 * 
	 * @param strs
	 *            json字符串数组
	 * @return
	 */
	public static String togetherJson(String[] strs) {
		String json = "";
		for (int i = 0; i < strs.length; i++) {
			if (i != 0)
				strs[i] = strs[i].replace("{", "");
			if (i != strs.length - 1)
				strs[i] = strs[i].replace("}", ",");
			json += strs[i];
		}
		return json;
	}

	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {

		String dest = "";

		if (str != null) {

			Pattern p = Pattern.compile("\\s*|\t|\r|\n");

			Matcher m = p.matcher(str);

			dest = m.replaceAll("");

		}

		return dest;

	}
	
	public static String toString(Object o) {

		if (o instanceof Timestamp) {
			return TimestampToString((Timestamp) o);
		}

		return o.toString();
	}

	public static String TimestampToString(Timestamp ts) {

		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			// 方法一
			tsStr = sdf.format(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tsStr;
	}
	
	//联网打码
	public static String[] httpUuGetCode(String imagePath) {
			String softID = "105784";
			String softKEY = "a0f1abb00afa4320a1408fa8601f81c8"; // KEY // 获取方式：http://dll.uuwise.com/index.php?n=ApiDoc.GetSoftIDandKEY
			String userName = "astrolink"; // 用户帐号和密码(非开发者帐号)，在打码之前，需要先设置好，给用户留一个输入帐号和密码的地方
			String passWord = "eaa7d256";
			
			UuApi mApi = new UuApi();
			mApi.setSoftInfo(softID, softKEY);//softID，softKEY
			String userid=mApi.userLogin(userName, passWord);
			System.out.println("登陆返回："+userid);
			String codeID = mApi.autoRecognition(imagePath, "1004");
			System.out.println("codeID是："+codeID);
			String result = mApi.getResult(codeID);
			System.out.println("识别结果是："+result);
			String [] codes=new String[] {codeID,result}; 
			return codes;
		}
	
	public static JSONArray randomMobileInfo(int num) {
		JSONArray json=new JSONArray();
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			StringBuffer sbuff=new StringBuffer();
			sbuff.append("SELECT a.level,a.userAgent,b.brand,b.name,b.type,b.series,b.system,b.x,b.y FROM ( ");
				sbuff.append("SELECT * FROM spinfo.android_ua WHERE `level`<16 ORDER BY RAND() LIMIT 50 ");
			sbuff.append(") AS a INNER JOIN spinfo.model_info AS b ON  a.level=b.level ORDER BY RAND() LIMIT ");
			sbuff.append(num);
			CachedRowSetImpl crsi = dt.executeQuery(sbuff.toString(), BasicsTools.class);
			while (crsi.next()) {
				JSONObject jo=new JSONObject();
				jo.put("level", crsi.getString("level"));
				jo.put("UA", crsi.getString("userAgent"));
				jo.put("brand", crsi.getString("brand"));
				jo.put("name", crsi.getString("name"));
				jo.put("type", crsi.getString("type"));
				jo.put("series", crsi.getString("series"));
				jo.put("system", crsi.getString("system"));
				jo.put("x", crsi.getString("x"));
				jo.put("y", crsi.getString("y"));
				json.add(jo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 
	 * @param key 
	 *Java的运行环境版本：java.version<br>
	 *Java的运行环境供应商：java.vendor<br>
	 *Java供应商的URL：java.vendor.url<br>
	 *Java的安装路径：java.home<br>
	 *Java的虚拟机规范版本：java.vm.specification.version<br>
	 *Java的虚拟机规范供应商：java.vm.specification.vendor<br>
	 *Java的虚拟机规范名称：java.vm.specification.name<br>
	 *Java的虚拟机实现版本：java.vm.version<br>
	 *Java的虚拟机实现供应商：java.vm.vendor<br>
	 *Java的虚拟机实现名称：java.vm.name<br>
	 *Java运行时环境规范版本：java.specification.version<br>
	 *Java运行时环境规范供应商：java.specification.vender<br>
	 *Java运行时环境规范名称：java.specification.name<br>
	 *Java的类格式版本号：java.class.version<br>
	 *Java的类路径：java.class.path<br>
	 *加载库时搜索的路径列表：java.library.path<br>
	 *默认的临时文件路径：java.io.tmpdir<br>
	 *一个或多个扩展目录的路径：java.ext.dirs<br>
	 *操作系统的名称：os.name<br>
	 *操作系统的构架：os.arch<br>
	 *操作系统的版本：os.version<br>
	 *文件分隔符：file.separator<br>
	 *路径分隔符：path.separator<br>
	 *行分隔符：line.separator<br>
	 *用户的账户名称：user.name<br>
	 *用户的主目录：user.home<br>
	 *用户的当前工作目录：user.dir<br>
	 * @return
	 */
	public static String getSystemProperties(String key){
		Properties props = System.getProperties();
		return props.getProperty(key);
	}
}
