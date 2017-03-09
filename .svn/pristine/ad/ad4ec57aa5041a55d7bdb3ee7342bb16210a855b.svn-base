package com.astrolink.dao;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.CtccGameExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTool;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.astrolink.util.tools.PostNetWork;

/**
 * 电信爱游戏
 * @author sjh
 * @date 2016-05-19
 */
public class CtccGameExecLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccGameExecLinstenerThreadDao.class);
	private String dbTableName;
	public CtccGameExecLog ctccGameExecLog;
	public IExecFinish execFinish;
	
	public CtccGameExecLinstenerThreadDao(CtccGameExecLog ctccGameExecLog){
		this.ctccGameExecLog = ctccGameExecLog;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		StringBuffer logBuff=new StringBuffer();
		logBuff.append("跑行为开始：id为" + this.getKey()+";imsi:"+ctccGameExecLog.getImsi());
		try{
			String url = "http://log.vcgame.cn/api/v2/egame/log/config.json?app_key=" + ctccGameExecLog.getGameCode();
			get_doNetWork(url, null);

			StringBuffer buff = new StringBuffer();
			buff.append(ctccGameExecLog.getAppid());
			buff.append(ctccGameExecLog.getGameCode());
			buff.append(ctccGameExecLog.getImsi());
			buff.append(ctccGameExecLog.getChannelid());
			buff.append(ctccGameExecLog.getSdk_version());
			buff.append(ctccGameExecLog.getSdk_type());
			buff.append(ctccGameExecLog.getPackageName());
			buff.append(ctccGameExecLog.getAppKey());
			buff.append(ctccGameExecLog.getXwkey());
			String sign = sign(buff.toString().getBytes());
			String initUrl = "http://open.play.cn/api/v1/charge/epay/sdk/41x/get_init_info?app_id=" + ctccGameExecLog.getAppid() + "&game_code=" + ctccGameExecLog.getGameCode() + "&channel_code=" + ctccGameExecLog.getChannelid() + "&app_version=1&app_package_name=" + ctccGameExecLog.getPackageName() + "&imsi=" + ctccGameExecLog.getImsi() + "&imei=" + ctccGameExecLog.getImei() + "&client_ua=" + ctccGameExecLog.getUa() + "&api_level=" + ctccGameExecLog.getApiVersion() + "&sdk_version=" + ctccGameExecLog.getSdk_version() + "&sdk_type=" + ctccGameExecLog.getSdk_type() + "&user_id=&area_code=021&isp_type=1&cpu_abi=armeabi-v7a&iccid=" + ctccGameExecLog.getIccid() + "&apkmd5=&access_code_prefix=" + ctccGameExecLog.getMonum() + "&sign_msg=" + sign;

			String result = get_doNetWork(url, null);
			url = "http://open.play.cn/api/v2/mobile/channel/content.json?channel_id=710&current_page=0&rows_of_page=3&client_id=8888009&game_id=" + ctccGameExecLog.getGameId();
			result = get_doNetWork(url, null);

			// log init
//			LoveGameLogEvent event = new LoveGameLogEvent();
			// String sdk_init =
			// "{"sdk_version_name":"V4.1.9.01","sdk_type":"202","sdk_version_code":"119","app_package":"com.dipper.bomberDevilBB.egame","app_name":"炸弹人引爆恶魔岛"}";
			String sdk_init = getInitJson(ctccGameExecLog.getSdk_type(), ctccGameExecLog.getSdk_version(), ctccGameExecLog.getPackageName(), ctccGameExecLog.getAppName());
			StringBuffer initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_init, "sdk_init");
			String logUrl = "http://log.vcgame.cn/api/v2/egame/log.json";
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);

			// 此处返回参数
			get_doNetWork("http://mcore.vcgame.cn/api/v2/mcore/sdk/cv?version_code=141&client_id=8888060", null);

			// log2
			String sdk_init_config_ok = getInitOKJson(ctccGameExecLog.getSdk_type(), ctccGameExecLog.getSdk_version(), ctccGameExecLog.getPackageName(), ctccGameExecLog.getAppName(), initUrl.replace("&", ""));
			initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_init_config_ok, "sdk_init_config_ok");
			initParams.insert(initParams.indexOf("&event_value="), "&signal_cdma=3");
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);

			// open pay view
			initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_init, "sdk_pay") ;
			initParams.insert(initParams.indexOf("&event_value="), "&signal_cdma=2");
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);
			
			// TODO http://open.play.cn/api/v2/egame/log.json token获取

			//
			String sdk_open = getSDKOpen(ctccGameExecLog.getSdk_type(), ctccGameExecLog.getSdk_version(), ctccGameExecLog.getPackageName(), ctccGameExecLog.getAppName(), ctccGameExecLog.getTools_name(), ctccGameExecLog.getTools_money(), ctccGameExecLog.getTools_alias());
			initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_open, "sdk_open");
			initParams.insert(initParams.indexOf("&event_value="), "&signal_cdma=2");
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);

			// 点击确认按钮，发送计费短信-----------------------------------------------------------------------------------
//			int money = Integer.parseInt(tools_money);
//			String number = genSMSPort(money);
//			String orderInfo = CTCCgame.getPaySms(tools_id, Long.parseLong(chId), appKey, imsi, cpparam, money);
//			System.out.println(number);
//			System.out.println("H" + "0" + orderInfo);

			// sdk_first_sure_pay
			String sdk_first_sure_pay = getFirstSurePay(ctccGameExecLog.getSdk_type(), ctccGameExecLog.getSdk_version(), ctccGameExecLog.getPackageName(), ctccGameExecLog.getAppName(), ctccGameExecLog.getTools_name(), ctccGameExecLog.getTools_money(), ctccGameExecLog.getTools_alias());
			initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_first_sure_pay, "sdk_first_sure_pay");
			initParams.insert(initParams.indexOf("&event_value="), "&signal_cdma=3");
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);
			
			//
			String timestemp = getFormatDate();
			StringBuffer check = new StringBuffer();
			check.append(ctccGameExecLog.getAppid());
			check.append(ctccGameExecLog.getImsi());
			check.append(ctccGameExecLog.getGameCode());
			check.append(ctccGameExecLog.getChannelid());
			check.append(timestemp);
			check.append(ctccGameExecLog.getAppKey());
			check.append(ctccGameExecLog.getXwkey());
			sign = sign(check.toString().getBytes());
			// app_id=100005&imsi=460030760137541&imei=A1000038C5A21A&timestamp=20160517134006&
			// game_code=110256016654&channel_code=10000000&sign_msg=60e56565bf872520df21c6b54a3db4bd
			String checkUrl = "http://open.play.cn/api/v1/charge/epay/sdk/41x/get_user_cost_cap_info?app_id=" + ctccGameExecLog.getAppid() + "&imsi=" + ctccGameExecLog.getImsi() + "&imei=" + ctccGameExecLog.getImei() + "&timestamp=" + timestemp + "&game_code=" + ctccGameExecLog.getGameCode() + "&channel_code=" + ctccGameExecLog.getChannelid() + "&sign_msg=" + sign;
			get_doNetWork(url, null);

			// TODO sdk_open_fee_channel orderInfo生成规则
			String sdk_open_fee_channel = getOpenFeeChannel(ctccGameExecLog.getSdk_type(), ctccGameExecLog.getSdk_version(), ctccGameExecLog.getPackageName(), ctccGameExecLog.getAppName(), ctccGameExecLog.getTools_name(), ctccGameExecLog.getTools_money(), ctccGameExecLog.getTools_alias(), ctccGameExecLog.getSms(), "话费支付");
			initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_open_fee_channel, "sdk_open_fee_channel") ;
			initParams.insert(initParams.indexOf("&event_value="), "&signal_cdma=3");
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);

			// sdk_result_ok
			String sdk_result_ok = getResultOK(ctccGameExecLog.getSdk_type(), ctccGameExecLog.getSdk_version(), ctccGameExecLog.getPackageName(), ctccGameExecLog.getAppName(), ctccGameExecLog.getTools_name(), ctccGameExecLog.getTools_money(), ctccGameExecLog.getTools_alias(), ctccGameExecLog.getMonum()+ctccGameExecLog.getMonum_ext(), Integer.parseInt(ctccGameExecLog.getConsumePrice()) / 100f + "");
			initParams = getLogParams(ctccGameExecLog.getGameCode(), ctccGameExecLog.getChannelid(), ctccGameExecLog.getImsi(), ctccGameExecLog.getMac(), ctccGameExecLog.getImei(), ctccGameExecLog.getUa(), ctccGameExecLog.getBuild_id(), ctccGameExecLog.getScreen_px(), ctccGameExecLog.getApiVersion(), sdk_result_ok, "sdk_result_ok");
			initParams.insert(initParams.indexOf("&event_value="), "&signal_cdma=1");
			post_doNetWork(logUrl,initParams.toString().replace(" ", "+"), null);
			
			updateExecNum(ctccGameExecLog.getId(),logBuff);
		} catch (Exception e) {
			logBuff.append(ExceptionTools.exception(e));
		}finally{
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logBuff.append(",处理请求结束，id为" + this.getKey());
			}
			logger.info(logBuff.toString());
		}
	}
	
	public  void updateExecNum(long id,StringBuffer logBuff){
		StringBuffer sqlBuff=new StringBuffer();
		sqlBuff.append("UPDATE ").append(dbTableName).append(" SET  execNum = execNum+1").append(" WHERE `id` = '").append(id).append("' ");
		DbTools dt=new  DbTools(Const.DB_CTCC_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCC_USERNAME,Const.DB_CTCC_PASSWORD);
		logBuff.append(",updateExecNum：" + dt.upDate(sqlBuff.toString(), CtccGameExecLinstenerThreadDao.class));
	}
	
	private String post_doNetWork(String netURL,String req_log,String proxyIp) {
		PostNetWork postNetWork =null;
		String result = "";
		try {
			postNetWork = new PostNetWork(netURL);
			postNetWork.setConnectionTimeout(10000);
			postNetWork.setSoTimeout(30000);

			postNetWork.getPostMethod().addRequestHeader("req_log", req_log);
		 	if(proxyIp==null || proxyIp.equals("null") || proxyIp.equals("")){
				postNetWork.executeMethod();
				result = postNetWork.getString("UTF-8");
			}else{
				String[] Proxy =proxyIp.split(":");
				postNetWork.setProxyHost(Proxy[0]);
				postNetWork.setProxyPort(Integer.parseInt(Proxy[1]));
				postNetWork.executeMethod(true);
				result = postNetWork.getString("UTF-8","GZIP");
			}
			postNetWork.getNetState();
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
		} finally {
			postNetWork.closeConn();
		}
		return result;
	} 

	private String get_doNetWork(String netURL,String proxyIp) {
		GetNetWork getNetWork =null;
		String result = "";
		try {
			getNetWork = new GetNetWork(netURL);
			getNetWork.setConnectionTimeout(10000);
			getNetWork.setSoTimeout(30000);
			
		 	if(proxyIp==null || proxyIp.equals("null") || proxyIp.equals("")){
		 		getNetWork.executeMethod();
				result = getNetWork.getString("UTF-8");
			}else{
				String[] Proxy =proxyIp.split(":");
				getNetWork.setProxyHost(Proxy[0]);
				getNetWork.setProxyPort(Integer.parseInt(Proxy[1]));
				getNetWork.executeMethod(true);
				result = getNetWork.getString("UTF-8","GZIP");
			}
		 	getNetWork.getNetState();
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
		} finally {
			getNetWork.closeConn();
		}
		return result;
	} 
	
	

	public static final char[] ch = new char[] { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String sign(byte[] arg1) {
		MessageDigest v0_1;
		try {
			v0_1 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException v0) {
			String v0_2 = "";
			return v0_2;
		}

		v0_1.update(arg1);
		return b(v0_1.digest());
	}

	private static String a(byte[] arg3, int arg4, int arg5) {
		StringBuffer v0 = new StringBuffer(arg5 * 2);
		int v1 = arg4 + arg5;
		while (arg4 < v1) {
			a(arg3[arg4], v0);
			++arg4;
		}

		return v0.toString();
	}

	private static void a(byte arg3, StringBuffer arg4) {
		char v0 = ch[(arg3 & 240) >> 4];
		char v1 = ch[arg3 & 15];
		arg4.append(v0);
		arg4.append(v1);
	}

	private static String b(byte[] arg2) {
		return a(arg2, 0, arg2.length);
	}

	
	public String getInitJson(String sdk_type, String sdk_version,
			String packageName, String appName) {
		JSONObject json = new JSONObject();
		json.put("sdk_version_name", "V4.1.9.01");
		json.put("sdk_type", sdk_type);
		json.put("sdk_version_code", sdk_version);
		json.put("sdk_version_code", sdk_version);
		json.put("app_package", packageName);
		json.put("app_name", appName);
		return json.toString();
	}

	public String getInitOKJson(String sdk_type, String sdk_version,
			String packageName, String appName, String initUrl) {
		JSONObject json = JSONObject.fromObject(getInitJson(sdk_type,
				sdk_version, packageName, appName));
		json.put("url", initUrl);
		return json.toString();
	}

	public String getSDKOpen(String sdk_type, String sdk_version,
			String packageName, String appName, String tools_name,
			String tools_money, String tools_alias) {
		JSONObject json = JSONObject.fromObject(getInitJson(sdk_type,
				sdk_version, packageName, appName));
		json.put("risk_level", "11");
		json.put("tools_name", tools_name);
		json.put("tools_money", tools_money);
		json.put("tools_alias", tools_alias);
		json.put("prioritySmsPay", "true");
		return json.toString();
	}

	public String getFirstSurePay(String sdk_type, String sdk_version,
			String packageName, String appName, String tools_name,
			String tools_money, String tools_alias) {
		JSONObject json = JSONObject.fromObject(getInitJson(sdk_type,
				sdk_version, packageName, appName));
		json.put("risk_level", "11");
		json.put("tools_name", tools_name);
		json.put("tools_money", tools_money);
		json.put("tools_alias", tools_alias);
		return json.toString();
	}

	public String getOpenFeeChannel(String sdk_type, String sdk_version,
			String packageName, String appName, String tools_name,
			String tools_money, String tools_alias, String order_info,
			String sel_fee_channel_name) {
		JSONObject json = JSONObject.fromObject(getInitJson(sdk_type,
				sdk_version, packageName, appName));
		json.put("tools_name", tools_name);
		json.put("tools_money", tools_money);
		json.put("tools_alias", tools_alias);
		json.put("sel_fee_channel_type", "6");
		json.put("order_info", order_info);
		json.put("sel_fee_channel_name", sel_fee_channel_name);
		return json.toString();
	}

	public String getResultOK(String sdk_type, String sdk_version,
			String packageName, String appName, String tools_name,
			String tools_money, String tools_alias, String access_code,
			String fee) {
		JSONObject json = JSONObject.fromObject(getInitJson(sdk_type,
				sdk_version, packageName, appName));
		json.put("risk_level", "11");
		json.put("tools_name", tools_name);
		json.put("tools_money", tools_money);
		json.put("tools_alias", tools_alias);
		json.put("sel_fee_channel_type", "6");
		json.put("access_code", access_code);
		json.put("fee", fee);
		return json.toString();
	}

	public StringBuffer getLogParams(String app_key, String chId, String imsi,
			String mac, String imei, String ua, String build_id,
			String screen_px, String apiVersion, String event_value,
			String event_key) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("version=");
		buffer.append("120");
		buffer.append("&app_key=");
		buffer.append(app_key);
		buffer.append("&from=");
		buffer.append("paysdk");
		buffer.append("&channel_id=");
		buffer.append(chId);
		buffer.append("&imsi=");
		buffer.append(imsi);
		buffer.append("&mac=");
		buffer.append("eth" + mac);
		buffer.append("&network=");
		buffer.append("wifi");
		buffer.append("&network_int=");
		buffer.append("0");
		buffer.append("&network_class=");
		buffer.append("1");
		buffer.append("&meid=");
		buffer.append(imei);
		buffer.append("&model=");
		buffer.append(ua);
		buffer.append("&build_id=");
		buffer.append(build_id);
		buffer.append("&screen_px=");
		buffer.append(screen_px);
		buffer.append("&agency=");
		buffer.append("1");
		buffer.append("&timestamp=");
		buffer.append(System.currentTimeMillis());
		buffer.append("&api_level=");
		buffer.append(apiVersion);
		buffer.append("&cpu_abi=armeabi-v7a");
		buffer.append("&app_ver=1.0.0");
		buffer.append("&event_value=");
		buffer.append(URLEncoder.encode(event_value));
		buffer.append("&event_key=");
		buffer.append(event_key);
		return buffer;
	}
	
	private static String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
}
