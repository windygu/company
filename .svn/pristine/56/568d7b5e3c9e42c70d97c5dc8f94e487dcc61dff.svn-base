package com.astrolink.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.Sendtmp;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;


/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class CtccSynSmsDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccSynSmsDataLinstenerThreadDao.class);
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
				//String sql="SELECT id,dest,src,OA,FA,subject,service_id,msg,link_id,method,session_id,session_end,request_identifier,result,CONCAT(date_format(time,'%Y-%c-%d %h:%i:%s'),'') as time,dr,CONCAT(date_format(drtime,'%Y-%c-%d %h:%i:%s'),'') as drtime FROM  "+this.dbTableName+" WHERE dr IS NOT NULL limit	50";
				String sql="SELECT id,dest,src,OA,FA,SUBJECT,service_id,msg,link_id,method,session_id,session_end,request_identifier,result,CONCAT(DATE_FORMAT(TIME,'%Y-%c-%d %h:%i:%s'),'') AS time,dr,CONCAT(DATE_FORMAT(drtime,'%Y-%c-%d %h:%i:%s'),'') AS drtime ,IFNULL(tempCpid,0) AS tempCpid,IFNULL(cmdErrorId,0) AS cmdErrorId FROM  "+this.dbTableName+" AS a LEFT JOIN sendtmp_otherInfo AS b ON a.id=b.sendtmpId WHERE dr IS NOT NULL LIMIT 50";
				ArrayList<Object> list=dt.executeQuery(sql, Sendtmp.class, CtccSynSmsDataLinstenerThreadDao.class);
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
				//Thread.sleep(100000);
			} catch (InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
		}
	}

}
