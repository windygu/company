package com.astrolink.main;

import java.io.File;

import com.astrolink.consts.LoadProperties;
import com.astrolink.service.CtccSmsService;

/**
 * 电信短信网关主入口
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccSmsMain {

	public static void main(String[] args) {
		String configName = "config";
		if (args.length == 1) {
			configName = args[0];
		}

		// 配置文件config.properties路径
		String configPath = "." + File.separator + "conf" + File.separator + configName + ".properties";

		new LoadProperties(configPath).init();

		CtccSmsService.getInstance().doCtccSmsExec();
	}
}
