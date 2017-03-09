package com.astrolink.main.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.astrolink.consts.Const;
import com.astrolink.consts.LoadProperties;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;

public class toolsSyn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileURL= "config";
		if (args.length == 1) {
			fileURL = args[0];
		}
		try {
			File file = new File(fileURL);//Text文件
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String url = null;
			while((url = br.readLine())!=null){//使用readLine方法，一次读一行
				url=url.replaceAll("\"","");
				GetNetWork get=new GetNetWork(url);
				get.executeMethod();
				System.out.println("url:"+url+"|||||||||"+"NetState:"+get.getNetState()+"|||||||||"+get.getString("GBK"));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
