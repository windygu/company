package com.astrolink.consts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.astrolink.util.tools.ExceptionTools;

/**
 * 初始化配置文件
 * 
 * @author cuilei
 * @date 2015-11-30
 */
public class LoadProperties {
	private static final Logger logger = Logger.getLogger(LoadProperties.class);

	// 读取configer.properties
	private static  Properties CONFIG_P = new Properties();
		
	public LoadProperties(String properties) {
		logger.info("[系统初始化]服务器配置路径" + properties);
		try {
			FileInputStream is = new FileInputStream(properties);
			CONFIG_P.load(new InputStreamReader(is, "utf-8"));
		} catch (IOException e) {
			logger.error(ExceptionTools.exception(e));
			System.exit(-1);
		}
	}

	/**
	 * 初始化加载配置文件信息
	 * 
	 * void
	 * 
	 * @date 2013-8-22
	 * @version V1.0.0
	 * @author linfenliang
	 */
	public void init() {
		try {
			Const.DB_MYSQL_DRIVER = CONFIG_P.getProperty("DB_MYSQL_DRIVER");
			Const.THREAD_MAX = Integer.parseInt(CONFIG_P.getProperty("THREAD_MAX")); 
			
			Const.CTCC_ParlayX_GW_URI = CONFIG_P.getProperty("CTCC_ParlayX_GW_URI");
			Const.CTCC_GATE = CONFIG_P.getProperty("CTCC_GATE");
			Const.CTCC_SP_ID = CONFIG_P.getProperty("CTCC_SP_ID");
			Const.CTCC_SP_PASSWORD = CONFIG_P.getProperty("CTCC_SP_PASSWORD");
			Const.CTCC_SP_NUMBER = CONFIG_P.getProperty("CTCC_SP_NUMBER");
			
			Const.DB_CTCCSMS_URL = CONFIG_P.getProperty("DB_CTCCSMS_URL");
			Const.DB_CTCCSMS_USERNAME = CONFIG_P.getProperty("DB_CTCCSMS_USERNAME");
			Const.DB_CTCCSMS_PASSWORD = CONFIG_P.getProperty("DB_CTCCSMS_PASSWORD");
			Const.CTCC_SMS_TABLE_MO = CONFIG_P.getProperty("CTCC_SMS_TABLE_MO");
			Const.CTCC_SMS_TABLE_SEND = CONFIG_P.getProperty("CTCC_SMS_TABLE_SEND");
			Const.CTCC_SMS_TABLE_SENDTMP = CONFIG_P.getProperty("CTCC_SMS_TABLE_SENDTMP");
			Const.CTCC_SMS_TABLE_STAT = CONFIG_P.getProperty("CTCC_SMS_TABLE_STAT");
			Const.CTCC_SMS_TABLE_DSMP = CONFIG_P.getProperty("CTCC_SMS_TABLE_DSMP");
			Const.CTCC_SMS_TABLE_CMD = CONFIG_P.getProperty("CTCC_SMS_TABLE_CMD");
			Const.CTCC_SMS_TABLE_CMD_ERROR = CONFIG_P.getProperty("CTCC_SMS_TABLE_CMD_ERROR");
			Const.CTCC_SMS_TABLE_CMD_LOG = CONFIG_P.getProperty("CTCC_SMS_TABLE_CMD_LOG");
			Const.CTCC_SMS_TABLE_SENDANA = CONFIG_P.getProperty("CTCC_SMS_TABLE_SENDANA");
			
			Const.DB_QXT_URL = CONFIG_P.getProperty("DB_QXT_URL");
			Const.DB_QXT_USERNAME = CONFIG_P.getProperty("DB_QXT_USERNAME");
			Const.DB_QXT_PASSWORD = CONFIG_P.getProperty("DB_QXT_PASSWORD");
			
			Const.DB_PCWEBGAME_URL = CONFIG_P.getProperty("DB_PCWEBGAME_URL");
			Const.DB_PCWEBGAME_USERNAME = CONFIG_P.getProperty("DB_PCWEBGAME_USERNAME");
			Const.DB_PCWEBGAME_PASSWORD = CONFIG_P.getProperty("DB_PCWEBGAME_PASSWORD");
			
			Const.DB_SPINFO_URL = CONFIG_P.getProperty("DB_SPINFO_URL");
			Const.DB_SPINFO_USERNAME = CONFIG_P.getProperty("DB_SPINFO_USERNAME");
			Const.DB_SPINFO_PASSWORD = CONFIG_P.getProperty("DB_SPINFO_PASSWORD");
			Const.SP_INFO_TABLE_DIC_FEECODE_INFO = CONFIG_P.getProperty("SP_INFO_TABLE_DIC_FEECODE_INFO");
			Const.SP_INFO_TABLE_GET_CURRENT_CONSUMECODE_CP_ID = CONFIG_P.getProperty("SP_INFO_TABLE_GET_CURRENT_CONSUMECODE_CP_ID");
			Const.SP_INFO_TABLE_CP_INFO = CONFIG_P.getProperty("SP_INFO_TABLE_CP_INFO");
			
			Const.COMIC_LOGIC_RETRY_NUM= Integer.parseInt(CONFIG_P.getProperty("COMIC_LOGIC_RETRY_NUM"));
			Const.COMIC_LOGIC_RETRY_NUM_SK= Integer.parseInt(CONFIG_P.getProperty("COMIC_LOGIC_RETRY_NUM_SK"));
			Const.DB_COMIC_URL = CONFIG_P.getProperty("DB_COMIC_URL");
			Const.DB_COMIC_USERNAME = CONFIG_P.getProperty("DB_COMIC_USERNAME");
			Const.DB_COMIC_PASSWORD = CONFIG_P.getProperty("DB_COMIC_PASSWORD");
			Const.COMIC_TABLE_EXEX_LOG = CONFIG_P.getProperty("COMIC_TABLE_EXEX_LOG");
			Const.COMIC_TABLE_PAY_RESULT_LOG = CONFIG_P.getProperty("COMIC_TABLE_PAY_RESULT_LOG");
			Const.COMIC_connectionTimeout= CONFIG_P.getProperty("COMIC_connectionTimeout");
			Const.COMIC_soTimeout= CONFIG_P.getProperty("COMIC_soTimeout");
			
			Const.MUSIC_LOGIC_RETRY_NUM= Integer.parseInt(CONFIG_P.getProperty("MUSIC_LOGIC_RETRY_NUM"));
			Const.MUSIC_LOGIC_RETRY_NUM_SK= Integer.parseInt(CONFIG_P.getProperty("MUSIC_LOGIC_RETRY_NUM_SK"));
			Const.DB_MUSIC_URL = CONFIG_P.getProperty("DB_MUSIC_URL");
			Const.DB_MUSIC_USERNAME = CONFIG_P.getProperty("DB_MUSIC_USERNAME");
			Const.DB_MUSIC_PASSWORD = CONFIG_P.getProperty("DB_MUSIC_PASSWORD");
			Const.MUSIC_TABLE_EXEX_LOG = CONFIG_P.getProperty("MUSIC_TABLE_EXEX_LOG");
			Const.MUSIC_TABLE_PAY_RESULT_LOG = CONFIG_P.getProperty("MUSIC_TABLE_PAY_RESULT_LOG");
			
			Const.JDGAME_LOGIC_RETRY_NUM= Integer.parseInt(CONFIG_P.getProperty("JDGAME_LOGIC_RETRY_NUM"));
			Const.JDGAME_LOGIC_RETRY_NUM_SK= Integer.parseInt(CONFIG_P.getProperty("JDGAME_LOGIC_RETRY_NUM_SK"));
			Const.DB_JDGAME_URL = CONFIG_P.getProperty("DB_JDGAME_URL");
			Const.DB_JDGAME_USERNAME = CONFIG_P.getProperty("DB_JDGAME_USERNAME");
			Const.DB_JDGAME_PASSWORD = CONFIG_P.getProperty("DB_JDGAME_PASSWORD");
			Const.JDGAME_TABLE_EXEX_LOG = CONFIG_P.getProperty("JDGAME_TABLE_EXEX_LOG");
			Const.JDGAME_TABLE_PAY_RESULT_LOG = CONFIG_P.getProperty("JDGAME_TABLE_PAY_RESULT_LOG");
			Const.JDGAME_connectionTimeout= CONFIG_P.getProperty("JDGAME_connectionTimeout");
			Const.JDGAME_soTimeout= CONFIG_P.getProperty("JDGAME_soTimeout"); 
			
			Const.DB_MMS_URL = CONFIG_P.getProperty("DB_MMS_URL");
			Const.DB_MMS_USERNAME = CONFIG_P.getProperty("DB_MMS_USERNAME");
			Const.DB_MMS_PASSWORD = CONFIG_P.getProperty("DB_MMS_PASSWORD");
			Const.DB_MMS_URL_GW = CONFIG_P.getProperty("DB_MMS_URL_GW");
			Const.DB_MMS_USERNAME_GW = CONFIG_P.getProperty("DB_MMS_USERNAME_GW");
			Const.DB_MMS_PASSWORD_GW = CONFIG_P.getProperty("DB_MMS_PASSWORD_GW");
			
			
			Const.WOCHANNE_LOGIC_RETRY_NUM= Integer.parseInt(CONFIG_P.getProperty("WOCHANNE_LOGIC_RETRY_NUM"));
			Const.WOCHANNE_LOGIC_RETRY_NUM_SK= Integer.parseInt(CONFIG_P.getProperty("WOCHANNE_LOGIC_RETRY_NUM_SK"));
			Const.DB_WOCHANNE_URL = CONFIG_P.getProperty("DB_WOCHANNE_URL");
			Const.DB_WOCHANNE_USERNAME = CONFIG_P.getProperty("DB_WOCHANNE_USERNAME");
			Const.DB_WOCHANNE_PASSWORD = CONFIG_P.getProperty("DB_WOCHANNE_PASSWORD");
			Const.WOCHANNE_TABLE_EXEX_LOG = CONFIG_P.getProperty("WOCHANNE_TABLE_EXEX_LOG");
			Const.WOCHANNE_TABLE_PAY_RESULT_LOG = CONFIG_P.getProperty("WOCHANNE_TABLE_PAY_RESULT_LOG");
			Const.WOCHANNE_connectionTimeout= CONFIG_P.getProperty("WOCHANNE_connectionTimeout");
			Const.WOCHANNE_soTimeout= CONFIG_P.getProperty("WOCHANNE_soTimeout");
			
			Const.VIDEO_LOGIC_RETRY_NUM= Integer.parseInt(CONFIG_P.getProperty("VIDEO_LOGIC_RETRY_NUM"));
			Const.DB_VIDEO_URL = CONFIG_P.getProperty("DB_VIDEO_URL");
			Const.DB_VIDEO_USERNAME = CONFIG_P.getProperty("DB_VIDEO_USERNAME");
			Const.DB_VIDEO_PASSWORD = CONFIG_P.getProperty("DB_VIDEO_PASSWORD");
			Const.VIDEO_TABLE_EXEX_LOG = CONFIG_P.getProperty("VIDEO_TABLE_EXEX_LOG");
			Const.VIDEO_TABLE_PAY_RESULT_LOG = CONFIG_P.getProperty("VIDEO_TABLE_PAY_RESULT_LOG");
			
			Const.DB_CTCC_URL = CONFIG_P.getProperty("DB_CTCC_URL");
			Const.DB_CTCC_USERNAME = CONFIG_P.getProperty("DB_CTCC_USERNAME");
			Const.DB_CTCC_PASSWORD = CONFIG_P.getProperty("DB_CTCC_PASSWORD");
			
			Const.DB_WOPLUS_URL = CONFIG_P.getProperty("DB_WOPLUS_URL");
			Const.DB_WOPLUS_USERNAME = CONFIG_P.getProperty("DB_WOPLUS_USERNAME");
			Const.DB_WOPLUS_PASSWORD = CONFIG_P.getProperty("DB_WOPLUS_PASSWORD");
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
			System.exit(-1);
		}
	}

}
