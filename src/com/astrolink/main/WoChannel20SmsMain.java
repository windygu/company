package com.astrolink.main;

import java.io.File;

import com.astrolink.consts.LoadProperties;
import com.astrolink.service.WoChannel20SmsService;

/**
 * 小wo渠道20计费确认主入口
 * 
 * @author cuilei
 * @date 2016-11-07
 */
public class WoChannel20SmsMain {

	public static void main(String[] args) {
		String configName = "config";
		if (args.length == 1) {
			configName = args[0];
		}

		// 配置文件config.properties路径
		String configPath = "." + File.separator + "conf" + File.separator + configName + ".properties";

		new LoadProperties(configPath).init();
		WoChannel20SmsService.getInstance().doWoChannel20SmsExec();
		
		
		
		
	}
}
