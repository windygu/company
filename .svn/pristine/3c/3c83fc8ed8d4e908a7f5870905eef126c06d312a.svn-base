package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.MmExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class MmDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(MmDataLinstenerThreadDao.class);
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
				DbTools dt=new  DbTools(Const.DB_COMIC_URL,Const.DB_MYSQL_DRIVER,Const.DB_COMIC_USERNAME,Const.DB_COMIC_PASSWORD);
				
				String sql="SELECT a.id,a.imei,a.imsi,a.device_cid,a.monum,a.consumeCode,a.appid,a.encodeCID,a.rand16Num,a.timeStamp,a.key1,a.key2,a.cpparam,a.cpid,b.configInfo,a.execNum,d.crackSynUrl,a.methodType  " +
						"FROM exec_log AS a INNER JOIN spinfo.sp_product_crack_info AS b ON a.spProductId=b.spProductId " +
						"INNER JOIN spinfo.cp_info AS d ON a.cpid=d.cpinfoId " +
						"where " +
							"execNum<"+Const.COMIC_LOGIC_RETRY_NUM+" " +
							"AND getSmsType='true' " +
							//"AND methodType=0 " +//正常业务
							"AND methodType=1 " +//正常业务
							//"AND methodType=100 " +//刷卡业务
							//"AND methodType=101 " +//刷卡业务
							//"AND methodType=102 " +//刷卡业务
							//"AND methodType=103 " +//刷卡业务
							"AND ((execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 10) " +
							"OR (execNum=1 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 20) " +
							"OR (execNum>=2 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 60)) order by execNum,a.id	limit 200";
				ArrayList<Object> list=dt.executeQuery(sql, MmExecLog.class, MmDataLinstenerThreadDao.class);
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
