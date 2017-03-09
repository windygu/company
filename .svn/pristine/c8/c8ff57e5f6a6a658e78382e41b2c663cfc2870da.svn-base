package com.astrolink.service;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;

/**
 * @Description:TODO
 * @author kai
 * @date 2015-4-17
 */
public class UpSpincomeService implements Runnable {

	private static Logger logger = Logger.getLogger(HeartbeatMonitoringService.class);

	public UpSpincomeService() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		logger.info("离线同步监听服务");
		while (true) {
			try {
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				String sql = "SELECT  a.*,synUrl FROM up_spincome AS a INNER JOIN cp_info AS b ON a.cpInfoId=b.cpInfoId WHERE synStatus=0 ";
				CachedRowSetImpl crsi =dt.executeQuery(sql,UpSpincomeService.class);
	
				ArrayList<Hashtable<String,String>> al=new ArrayList<Hashtable<String,String>>();
				StringBuffer sBuffIds = new StringBuffer();
				while (crsi.next()) {
					Hashtable<String, String> dateListHt = new Hashtable<String, String>();
					ResultSetMetaData rsmd = crsi.getMetaData();
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						String name = rsmd.getColumnName(i + 1);
						dateListHt.put(name, String.valueOf(crsi.getString(name)));
					}
					al.add(dateListHt);
					sBuffIds.append(dateListHt.get("upSpIncomeId")).append(",");
				}
				setDataLog(sBuffIds.toString());
				doGetUrl(al);
			} catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			}
			
			try {
				Thread.sleep(1000 * 60);
			} catch (InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
		}

	}
	
	public void setDataLog(String ids) {
		if (!ids.equals("")) {
			DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
			String sql = "UPDATE spinfo.up_spincome SET synStatus = '1' WHERE upSpIncomeId IN(" + ids.substring(0, ids.length() - 1) + ")";
			dt.upDate(sql,UpSpincomeService.class);
		}
	}
	
	/**
	 * 拼接同步url
	 * 
	 * @param tempDate
	 * @return
	 */
	private void doGetUrl(ArrayList<Hashtable<String,String>> al) {
		try {
			for(Hashtable<String,String> tempDate:al){
				String syncurl = "http://121.42.15.79:6400/offline/sync.ashx?";
				syncurl += "provinceCode="+tempDate.get("prov_ID")+
						"&cityCode="+tempDate.get("city_ID")+
						"&consumeCode="+tempDate.get("consumeCode")+
						"&spNumber="+tempDate.get("monum")+
						"&syncStatus=1"+
						"&fee="+tempDate.get("income")+
						"&provider="+tempDate.get("opType")+
						"&getTime="+tempDate.get("addTime")+
						"&upSpIncomeId="+tempDate.get("upSpIncomeId")+
						"&ssid="+tempDate.get("spProductConsumeCodeId");
				logger.debug(syncurl);
				GetNetWork gnw = new GetNetWork(syncurl);
				gnw.executeMethod();
				
				int synstatus = gnw.getNetState();
				String synresult = gnw.getString();
				gnw.closeConn();
				
				String inserLog="INSERT INTO spinfo.syn_cp_upincomelog (upSpIncomeId,synUrl,synstatus,synresult,inputDate) " +
						"VALUES('"+tempDate.get("upSpIncomeId")+"','"+syncurl+"','"+synstatus+"','"+synresult+"','"+BasicsTools.getForDate("yyyy-MM-dd HH:mm:ss")+"')";
						
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				dt.upDate(inserLog,UpSpincomeService.class);
			}
		} catch (Exception e) {
			logger.debug("访问同步地址出现异常");
			e.printStackTrace();
		}
	}
}
