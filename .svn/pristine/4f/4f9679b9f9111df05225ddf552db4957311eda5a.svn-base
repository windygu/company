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
public class WoChannel20SmsDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(WoChannel20SmsDataLinstenerThreadDao.class);
	public IDbObjectReciver dbObjectReciver; 
	
	public void setDbObjectReciver(IDbObjectReciver dbObjectReciver) {
		this.dbObjectReciver = dbObjectReciver;
	}
	
	@Override
	public void exec() {
		while (true) {
			int taskNum=0;
			try {
				DbTools dt=new  DbTools(Const.DB_WOCHANNE_URL,Const.DB_MYSQL_DRIVER,Const.DB_WOCHANNE_USERNAME,Const.DB_WOCHANNE_PASSWORD);
				
				String sql="SELECT supportExecLogId,supportAttrInfo,a.execNum,a.methodType,c.crackSynUrl,a.imsi FROM spInfo.support_exec_log AS a "+
							"INNER JOIN spInfo.support_attr_log AS b ON a.id=b.supportExecLogId  "+
							"INNER JOIN spinfo.cp_info AS c ON a.cpInfoId=c.cpinfoId "+
							"WHERE infoState=0 AND supportState<1000001 AND execNum<3 AND methodType=0 AND supportType='woChannel.WoChannel20' AND execState=0 "+
							"AND (execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 25)  ORDER BY execNum,a.id	limit 200";
				
							//"AND ((execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 15)  "+
							//"OR (execNum=1 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 20)  "+
							//"OR (execNum>=2 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 60)) ORDER BY execNum,a.id	limit 200";
				/*
				String sql="SELECT supportExecLogId,supportAttrInfo,a.execNum,a.methodType,c.crackSynUrl,a.imsi FROM spInfo.support_exec_log AS a "+
						"INNER JOIN spInfo.support_attr_log AS b ON a.id=b.supportExecLogId  "+
						"INNER JOIN spinfo.cp_info AS c ON a.cpInfoId=c.cpinfoId "+
						"WHERE a.id=2192312";
				*/
				ArrayList<Object> list=dt.executeQuery(sql, SupportAttrLog.class, WoChannel20SmsDataLinstenerThreadDao.class);
				taskNum=list.size();
				if (taskNum > 0) {
					logger.info("woChannel.WoChannel20 扫描结束，需要处理的数据个数" + taskNum);
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
