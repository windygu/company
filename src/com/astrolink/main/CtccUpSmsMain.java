package com.astrolink.main;

import java.io.File;

import com.astrolink.consts.LoadProperties;
import com.astrolink.service.CtccSynSmsService;
import com.astrolink.service.CtccUpSmsService;

/**
 * 电信短信上行主入口
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccUpSmsMain {

	public static void main(String[] args) {
		String configName = "config";
		if (args.length == 1) {
			configName = args[0];
		}

		// 配置文件config.properties路径
		String configPath = "." + File.separator + "conf" + File.separator + configName + ".properties";

		new LoadProperties(configPath).init();

		CtccUpSmsService.getInstance().doCtccUpSmsExec();
	}
}
