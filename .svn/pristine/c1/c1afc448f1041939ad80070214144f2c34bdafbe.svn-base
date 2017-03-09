package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.Cmd;
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
public class CtccUpSmsDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccUpSmsDataLinstenerThreadDao.class);
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
				String sql="SELECT id,senderAddress,message,SAN,linkId,smsServiceActivationNumber,inserttime FROM "+this.dbTableName+" order by inserttime desc limit 20";
				ArrayList<Object> list=dt.executeQuery(sql, Cmd.class, CtccUpSmsDataLinstenerThreadDao.class);
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
