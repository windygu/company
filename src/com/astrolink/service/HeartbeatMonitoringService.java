package com.astrolink.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.PcWebGame;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.Email;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.PostNetWork;
import com.sun.rowset.CachedRowSetImpl;

import net.sf.json.JSONObject;

/**
 * 心跳监护逻辑
 * 
 * @author cuilei
 * @date 2015-11-30
 */
public class HeartbeatMonitoringService implements Runnable {

	private static Logger logger = Logger.getLogger(HeartbeatMonitoringService.class);

	public HeartbeatMonitoringService() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				//监护logic服务
				serverMonitoring("http://42.96.169.232:8081/logic/heartbeatMonitoring","logic");
				//pc企信通(mo_data_pcfee)
				//pcWebGameQxtMonitoring();
				//电信网关(ctccSendGate)
				ctccSendGateMonitoring();
				//动漫网关(exec_log)
				//dmExecLogMonitoring();
				//监控
				monitor();
			} catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			} finally{
				try {
					//Thread.sleep(1000 * 60 * 5);
					Thread.sleep(1000 * 60 * 10);
				} catch (InterruptedException e) {
					logger.error(ExceptionTools.exception(e));
				}
			}
		}
	}
	private void monitor(){
		try {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			String sql="SELECT * FROM  monitor_info WHERE sendOutType=0";
			String ids="";
			CachedRowSetImpl crsi=dt.executeQuery(sql, HeartbeatMonitoringService.class);
			StringBuffer sBuff=new StringBuffer();
			if(crsi.size()!=0){
				while (crsi.next()) {
					ids+=crsi.getString("monitorInfoId")+",";
					sBuff.append(crsi.getString("monitorInfo")).append("<hr>");
				}
				if(!ids.equals("")){
					ids=ids.substring(0,ids.length()-1);
					DbTools dtu=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
					dtu.upDate("UPDATE  spinfo.monitor_info SET sendOutType = '1' WHERE monitorInfoId IN("+ids+")", HeartbeatMonitoringService.class);
				}
				javaMailSend("预警信息:<hr>"+sBuff.toString());
			}
		} catch (Exception e) {
			javaMailSend("预警信息监测失败");
		}
		
	}
	
	
	private void pcWebGameQxtMonitoring(){
		try {
			DbTools dt=new  DbTools(Const.DB_QXT_URL,Const.DB_MYSQL_DRIVER,Const.DB_QXT_USERNAME,Const.DB_QXT_PASSWORD);
			String sql="SELECT id FROM  mo_data_pcfee";
			ArrayList<Object> list=dt.executeQuery(sql, PcWebGame.class, HeartbeatMonitoringService.class);
			if(list.size()>=50){
				javaMailSend("PC企信通挤压数量过多，数量已达到"+list.size());
			}
		} catch (Exception e) {
			javaMailSend("PC企信通监测失败");
		}
		
	}
	
	private void ctccSendGateMonitoring(){
		try {
			DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
			String sql="SELECT COUNT(0) as num FROM send";
			CachedRowSetImpl crsi=dt.executeQuery(sql,HeartbeatMonitoringService.class);
			while (crsi.next()) {
				int num=crsi.getInt("num");
				if(num>=50){
					javaMailSend("电信网关挤压数量过多，数量已达到"+num);
				}
			}
		} catch (Exception e) {
			javaMailSend("电信网关监测失败");
		}
		
	}
	
	private void dmExecLogMonitoring(){
		try {
			DbTools dt=new  DbTools(Const.DB_COMIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_COMIC_USERNAME,Const.DB_COMIC_PASSWORD);
			String sql="SELECT methodType,COUNT(0) AS num FROM exec_log WHERE getSmsType='true' and methodType<1000 and  methodType!=20 GROUP BY methodType";
			CachedRowSetImpl crsi=dt.executeQuery(sql, HeartbeatMonitoringService.class);
			StringBuffer sBuff=new StringBuffer();
			while (crsi.next()) {
				int num=crsi.getInt("num");
				int methodType=crsi.getInt("methodType");
				if(methodType>99){
					if(num>=500){
						sBuff.append("动漫刷卡服务").append(methodType).append("网关挤压数量过多，数量已达到：").append(crsi.getInt("num")).append("<hr>");
					}
				}else{
					if(num>=1500){
						sBuff.append("动漫业务服务").append(methodType).append("网关挤压数量过多，数量已达到：").append(crsi.getInt("num")).append("<hr>");
					}
				}
			}
			if(sBuff.length()!=0){
				javaMailSend(sBuff.toString());
			}
		} catch (Exception e) {
			javaMailSend("动漫网关监测失败");
		}
		
	}
	
	/**
	 * 服务监护
	 * @param httpUrl
	 */
	private void serverMonitoring(String httpUrl,String serverName) {
		boolean type = false;
		StringBuffer text = new StringBuffer();
		try {
			PostNetWork post = new PostNetWork(httpUrl);
			post.executeMethod();
			String monitoring = post.getString("utf-8");
			JSONObject jo = JSONObject.fromObject(monitoring);
			JSONObject monitoringInfo = jo.optJSONObject("monitoringInfo");

			text.append(jo.optString("serverName"));
			text.append(serverName+"服务连接异常：");
			Iterator<?> it = monitoringInfo.keys();
			String dbName = "";
			while (it.hasNext()) {// 遍历JSONObject
				dbName = (String) it.next().toString();
				if (monitoringInfo.optInt(dbName) == 0) {
					type = true;
					text.append(dbName + "、");
				}
			}
		} catch (Exception e) {
			type = true;
			text.append("心跳监护"+serverName+"服务");
			logger.error(ExceptionTools.exception(e));
		}

		if (type) {
			javaMailSend(text.toString());
		}
	}
	
	public void javaMailSend(String info){
		try {
			ArrayList<String> al = new ArrayList<String>();
			al.add("15801367782@139.com");//崔磊
			al.add("13601339069@139.com");//朱经理
			al.add("13911118349@139.com");//陈代海
			al.add("3131264326@qq.com");//邓嘉怡
			al.add("503632548@qq.com");//周梦军
			al.add("1598761569@qq.com");//张朝帧
			Email e = new Email();
			e.pushInfo(0, al, info);
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
		
	}
}
