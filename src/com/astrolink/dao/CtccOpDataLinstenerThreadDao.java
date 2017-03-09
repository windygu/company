package com.astrolink.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.CtccOp;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;


/**
 * 电信开放平台数据监听线程
 * @author sjh
 * @date 2016-05-06
 */
public class CtccOpDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccOpDataLinstenerThreadDao.class);
	private String dbTableName;
	public IDbObjectReciver dbObjectReciver; 
	
	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}
	
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	@Override
	public void exec() {
		while (true) { 
			int taskNum=0;
			try {
				DbTools dt=new  DbTools(Const.DB_QXT_URL,Const.DB_MYSQL_DRIVER,Const.DB_QXT_USERNAME,Const.DB_QXT_PASSWORD);
				String sql="SELECT * FROM  "+this.dbTableName+" ORDER BY time LIMIT 10";
				ArrayList<Object> list=dt.executeQuery(sql, CtccOp.class, CtccOpDataLinstenerThreadDao.class);
				taskNum=list.size();
				if (taskNum > 0) {
					logger.info(this.dbTableName + "扫描结束，需要处理的数据个数" + taskNum);
				}
				
				if (dbObjectReciver != null) {
					dbObjectReciver.dataRecived(list);
				}
			} catch (Exception e) {
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
