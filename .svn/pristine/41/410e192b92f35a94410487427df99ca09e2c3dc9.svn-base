package com.astrolink.main;

import java.io.File;

import com.astrolink.consts.LoadProperties;
import com.astrolink.service.Music2Service;

/**
 * 音乐计费确认主入口
 * @author cuilei
 * @date 2015-11-30
 */
public class MusicMain2 {

	public static void main(String[] args) {
		String configName = "config";
		int methodType = 0;
		if (args.length == 2) {
			configName = args[0];
			methodType = Integer.parseInt(args[1]);
		}

		System.setProperty("myconfig.accout",methodType+"");
		System.out.print("configName="+configName+"  methodType="+methodType+"\r\n");
		// 配置文件config.properties路径
		String configPath = "." + File.separator + "conf" + File.separator + configName + ".properties";

		new LoadProperties(configPath).init();

		Music2Service.getInstance().doMusic2Exec(methodType);
	}
}
