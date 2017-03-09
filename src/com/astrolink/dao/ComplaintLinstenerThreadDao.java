package com.astrolink.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.Complaint;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
/**
 * 数据监听线程
 * @author Administrator
 *
 */
public class ComplaintLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(ComplaintLinstenerThreadDao.class);
	public String dbTableName = "";
	public IDbObjectReciver dbObjectReciver; 
	
	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}
	
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	@Override
	public void exec() {
		while(true) {
			int taskNum=0;
			try {
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				String sql = "SELECT * FROM sp_complaint WHERE synType=0 AND spComplaintId>=4278 AND mobile!=0 AND mobile IS NOT NULL AND cpInfoId=1 AND cpParam IS NOT NULL";
				ArrayList<Object> list = dt.executeQuery(sql, Complaint.class,ComplaintLinstenerThreadDao.class);
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
				if(taskNum==0){
					Thread.sleep(5000);
				}else{
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
		}
	}

}
