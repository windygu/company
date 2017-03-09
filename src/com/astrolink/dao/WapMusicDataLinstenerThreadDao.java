package com.astrolink.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.WapMusicExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class WapMusicDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(WapMusicDataLinstenerThreadDao.class);
	public String dbTableName = "";
	private int methodType = 0;
	public IDbObjectReciver dbObjectReciver; 
	
	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}
	
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	
	public void setMethodType(int methodType) {
		this.methodType = methodType;
	}

	@Override
	public void exec() {
		while (true) {
			int taskNum=0;
			try {
				DbTools dt=new  DbTools(Const.DB_MUSIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_MUSIC_USERNAME,Const.DB_MUSIC_PASSWORD);
				
				String sql="SELECT id,checkCode,cookie,mobile FROM `wapdm_exec_log` WHERE getSmsType='true' LIMIT 50";

				ArrayList<Object> list=dt.executeQuery(sql, WapMusicExecLog.class, WapMusicDataLinstenerThreadDao.class);
				taskNum=list.size();
				logger.info(this.dbTableName + "扫描结束，需要处理的数据个数" + taskNum);
				
				if (dbObjectReciver != null) {
					dbObjectReciver.dataRecived(list);
				}
			} catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			}

			try {
					Thread.sleep(9000000);
			} catch (InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
		}
	}

}
