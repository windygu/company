package com.astrolink.main;

import java.io.File;

import com.astrolink.consts.LoadProperties;
import com.astrolink.service.VideoService2;

/**
 * 视频2.0计费确认主入口
 * @author sjh
 * @date 2016-10-13
 */
public class VideoMain2 {

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

		VideoService2.getInstance().doVideoExec2(methodType);
	}
}
