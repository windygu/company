package com.astrolink.main;

import java.io.File;

import com.astrolink.consts.LoadProperties;
import com.astrolink.service.CtccOpService;

/**
 * 电信开放平台网关主入口(废弃)
 * @author sjh
 * @date 2016-05-05
 */
public class CtccOpMain {

	public static void main(String[] args) {
		String configName = "config";
		if (args.length == 1) {
			configName = args[0];
		}

		// 配置文件config.properties路径
		String configPath = "." + File.separator + "conf" + File.separator + configName + ".properties";

		new LoadProperties(configPath).init();

		CtccOpService.getInstance().doCtccOpExec();
	}
}
