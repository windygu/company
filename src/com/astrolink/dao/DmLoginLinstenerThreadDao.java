package com.astrolink.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
public class DmLoginLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(DmLoginLinstenerThreadDao.class);
	public String dbTableName = "";
	public IDbObjectReciver dbObjectReciver;
	public Map<Object,Object> taskMap;
	
	public void setMap(Map<Object, Object> map) {
		this.taskMap = map;
	}

	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}

	@Override
	public void exec() {
		Map<String,String> map = new HashMap<String,String>();
		
		int type = 1;
		while(true) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calender = Calendar.getInstance();
			String date = df.format(new Date());
			int  hour = calender.get(Calendar.HOUR_OF_DAY);
			calender.add(Calendar.DATE, -1);
			Date d = calender.getTime();
			String yesD = df.format(d);
			if(!map.containsValue(date)) {
				map.put("date", date);
				taskMap.clear();
				type = 1;
			}
			int taskNum = 0;
			try {
				if(hour==14 && taskMap.size()!=0) {
					DbTools dts=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
					String delete = "DELETE FROM monitor_info WHERE inputDate RLIKE '"+date+"'";
					dts.upDate(delete, DmLoginLinstenerThreadDao.class);
					
					for(Entry<Object, Object> entry : taskMap.entrySet()) {
						DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
						String sql = "UPDATE sp_product_task SET automaticState=1 WHERE spProductTaskId="+entry.getKey();
						dt.upDate(sql, DmLoginLinstenerThreadDao.class);
					}
					sleep(1000*3600);
					taskMap.clear();
				}
				if(hour==20) {
					DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
					String sql = "UPDATE sp_product_task SET automaticState=1 WHERE TYPE=3 AND automaticState!=2 AND spProductId NOT IN ("
									+"SELECT spProductId FROM sp_complaint_new WHERE dayTime='"+yesD+"' )";
					dt.upDate(sql, DmLoginLinstenerThreadDao.class);
					sleep(1000*3600);
				}
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				String sql = "SELECT * FROM sp_product_task WHERE type="+type+" GROUP BY automaticState";
				ArrayList<Object> statusL = dt.executeQuery(sql, DmLogin.class, DmLoginLinstenerThreadDao.class);
				List<Integer> stateList = new ArrayList<Integer>();
				for(Object o:statusL) {
					DmLogin dmLogin = (DmLogin) o;
					int automaticState = dmLogin.getAutomaticState();
					stateList.add(automaticState);
				}
				if(!stateList.contains(1)) {//该类型任务全部执行完
					type++;
				}
				if(type>6) {
					type = 1;
				}
				sql = "SELECT a.*,b.spProductName FROM sp_product_task AS a INNER JOIN sp_product AS b ON a.spProductId=b.spProductId WHERE automaticState=1 AND type="+type+" LIMIT 10";
				dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				ArrayList<Object> list = dt.executeQuery(sql, DmLogin.class,DmLoginLinstenerThreadDao.class);
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
				Thread.sleep(3000*60);
			}catch(InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
			
		}
	}

}
