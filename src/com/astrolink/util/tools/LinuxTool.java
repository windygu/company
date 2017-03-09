package com.astrolink.util.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class LinuxTool {
	public static Logger logger = Logger.getLogger(JsonTools.class);
	/**
	 * java调用linux命令
	 * @param Command linux命令
	 * @return
	 */
	public ArrayList<String> callLinuxCommand(String Command){ 
		logger.info("===============callLinuxCommand==============");
		logger.info(Command);
		
		ArrayList<String> al=new ArrayList<String>();
		InputStream in = null;
		BufferedReader read = null;  
		try {
			String[] cmds = {"/bin/sh","-c",Command};  
		    Process pro = Runtime.getRuntime().exec(cmds);  
		    pro.waitFor();  
		    in = pro.getInputStream();  
		    read = new BufferedReader(new InputStreamReader(in));  
		    String line = null;  
		    while((line = read.readLine())!=null){  
		    	al.add(line);
		    }  
		} catch (Exception e) {
			logger.error(BasicsTools.getErrorInfo(e));
		} finally{
			try {
				 in.close();
				 read.close();
			} catch (Exception e2) {
				logger.error(BasicsTools.getErrorInfo(e2));
			}
		}
		logger.info(al);
		logger.info("===============callLinuxCommand==============");
		return al;
	} 
	
	public ArrayList<String> command(String command) {
		logger.info("===============command==============");
		logger.info(command);
		
		ArrayList<String> infos=new ArrayList<String>();
		Process localProcess = null;
		try {
			localProcess = Runtime.getRuntime().exec(command);
			(new StreamForwarder(localProcess.getInputStream(),infos)).start();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(infos);
		logger.info("===============callLinuxCommand==============");
		return infos;
	}

	public class StreamForwarder extends Thread {

		private final InputStream mIn;
		private final ArrayList<String> infos;

		public StreamForwarder(InputStream inputstream, ArrayList<String> infos) {
			mIn = inputstream;
			this.infos = infos;
		}
		
		public void run() {
			try {
				BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(mIn));
				String s;
				while ((s = bufferedreader.readLine()) != null) {
					this.infos.add(s);
				}
			} catch (IOException ioexception) {
				ioexception.printStackTrace();
			}
		}

	}
}
