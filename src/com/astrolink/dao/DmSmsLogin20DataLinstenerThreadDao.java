package com.astrolink.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.SupportAttrLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;


/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class DmSmsLogin20DataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(DmSmsLogin20DataLinstenerThreadDao.class);
	private String dbTableName = "";
	private int methodType = 0;
	private IDbObjectReciver dbObjectReciver; 
	
	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}
	
	public void setMethodType(int methodType) {
		this.methodType = methodType;
	}
	
	@Override
	public void exec() {
		while (true) {
			int taskNum=0;
			try {
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				
				String sql="SELECT supportExecLogId,supportAttrInfo,a.execNum,a.methodType,c.crackSynUrl,a.imsi FROM support_exec_log AS a FORCE INDEX (login_index) " +
				"INNER JOIN support_attr_log AS b ON a.id=b.supportExecLogId  " +
				"INNER JOIN spinfo.cp_info AS c ON a.cpInfoId=c.cpinfoId " +
				"where supportType='dm.DmSms20' AND execNum<3 AND methodType="+methodType+" AND infoState=0 AND execState=0 AND execStep<3 AND supportState<1000001 AND responseType !=2 AND responseType !=3  " +
	            "AND ((execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 20) " +
				"OR (execNum=1 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 10) " +
			    "OR (execNum>=2 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 60)) " + 
			    "order by execNum,a.id	limit "+(200-taskNum);
				
				/*
				String sql="SELECT supportExecLogId,supportAttrInfo,a.execNum,a.methodType,c.crackSynUrl,a.imsi FROM support_exec_log AS a " +
						"INNER JOIN support_attr_log AS b ON a.id=b.supportExecLogId  " +
						"INNER JOIN spinfo.cp_info AS c ON a.cpInfoId=c.cpinfoId " +
						"where supportExecLogId=328300";
				*/
				
				//logger.info(sql);
				ArrayList<Object> list=dt.executeQuery(sql, SupportAttrLog.class, DmSmsLogin20DataLinstenerThreadDao.class);
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
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.error(ExceptionTools.exception(e));
			}
		}
	}

}
