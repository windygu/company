package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.CtccSmsSend;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;


/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccSmsDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccSmsDataLinstenerThreadDao.class);
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
		while (true) {
			int taskNum=0;
			try {
				DbTools dt=new  DbTools(Const.DB_CTCCSMS_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCCSMS_USERNAME,Const.DB_CTCCSMS_PASSWORD);
				//String sql="SELECT id,dest,src,OA,FA,subject,msg,service_id,link_id,method,session_id,session_end,time FROM  "+this.dbTableName+"  LIMIT 100";
				String sql="SELECT id,dest,src,OA,FA,SUBJECT,msg,service_id,link_id,method,session_id,session_end,TIME,IFNULL(tempCpid,0) as tempCpid,IFNULL(cmdErrorId,0) as cmdErrorId FROM  "+this.dbTableName+" AS a LEFT JOIN send_otherInfo AS b ON a.id=b.sendId LIMIT 100";
				ArrayList<Object> list=dt.executeQuery(sql, CtccSmsSend.class, CtccSmsDataLinstenerThreadDao.class);
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
