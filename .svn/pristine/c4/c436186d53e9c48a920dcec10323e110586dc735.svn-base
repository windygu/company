package com.astrolink.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.DmLogin;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
/**
 * 数据监听线程
 * @author Administrator
 *
 */
public class DmGgLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(DmGgLinstenerThreadDao.class);
	public String dbTableName = "";
	public IDbObjectReciver dbObjectReciver;

	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}

	@Override
	public void exec() {
		Map<String,Integer> map = new HashMap<String,Integer>();
		while(true) {
			int taskNum = 0;
			Calendar calender = Calendar.getInstance();
			int  hour = calender.get(Calendar.HOUR_OF_DAY);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(new Date());
			try {
				if(hour == 15 || hour == 22) {
					if(!map.containsValue(hour)) {
						map.put("hour", hour);
						DbTools dts=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
						String sql = "UPDATE sp_product_task SET automaticState='1' WHERE TYPE=8";
						dts.upDate(sql, DmGgLinstenerThreadDao.class);
						
						dts=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
						sql = "DELETE FROM sp_product_announcement WHERE type=1 AND inputDate RLIKE '"+date+"'";
						dts.upDate(sql, DmGgLinstenerThreadDao.class);
					}
					sleep(1000*3600);
				}
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				String sql = "SELECT a.*,b.spProductName FROM sp_product_task AS a INNER JOIN sp_product AS b ON a.spProductId=b.spProductId WHERE automaticState=1 AND type=8 LIMIT 10";
				ArrayList<Object> list = dt.executeQuery(sql, DmLogin.class,DmGgLinstenerThreadDao.class);
				taskNum = list.size();
				if (taskNum > 0) {
					logger.info(this.dbTableName + "扫描结束，需要处理的数据个数" + taskNum);
				}
				if(dbObjectReciver != null) {
					dbObjectReciver.dataRecived(list);
				}
			}catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			}
			try {
				Thread.sleep(4000*60);
			}catch(InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
			
		}
	}

}
