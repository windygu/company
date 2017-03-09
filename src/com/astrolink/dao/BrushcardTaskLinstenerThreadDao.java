package com.astrolink.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.BrushcardTask;
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
public class BrushcardTaskLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(BrushcardTaskLinstenerThreadDao.class);
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
				String sql = "SELECT spBrushCardTaskId,cpid,ssid,dicProductTypeId,execNum,retryNum,retrySpanTime,taskStatus,currentExecNum,isClient FROM  sp_brushcard_task WHERE taskStatus=0 AND dicProductTypeId=9";
				ArrayList<Object> list = dt.executeQuery(sql, BrushcardTask.class,BrushcardTaskLinstenerThreadDao.class);
				taskNum = list.size();
				if (taskNum > 0) {
					logger.info(this.dbTableName + "扫描结束，需要处理的数据个数" + taskNum);
				}
				
				if(dbObjectReciver != null) {
					for(Object o:list){
						BrushcardTask task=(BrushcardTask)o;
						if(task.getCurrentExecNum()<task.getExecNum()){
							DbTools udt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
							udt.upDate("UPDATE spinfo.sp_brushcard_task SET taskStatus =1 WHERE spBrushCardTaskId ="+task.getSpBrushCardTaskId() ,BrushcardTaskLinstenerThreadDao.class);
						}else{
							DbTools udt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
							udt.upDate("UPDATE spinfo.sp_brushcard_task SET currentExecNum = currentExecNum+1 WHERE spBrushCardTaskId ="+task.getSpBrushCardTaskId() ,BrushcardTaskLinstenerThreadDao.class);
						}
					}
					dbObjectReciver.dataRecived(list);
				}
			}catch (Exception e) {
				logger.error(ExceptionTools.exception(e));
			}
			
			try {
				if(taskNum==0){
					Thread.sleep(5000);
				}else{
					Thread.sleep(1500);
				}
			} catch (InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
		}
	}

}
