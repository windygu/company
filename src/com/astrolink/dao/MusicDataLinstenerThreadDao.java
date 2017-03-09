package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.MusicExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class MusicDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(MusicDataLinstenerThreadDao.class);
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
				
				String sql="SELECT a.id,a.imei,a.imsi,a.miguopen_appid,a.pubKey,a.packageName,a.mode,a.serviceId,a.ctype,a.timeStamp,a.contentId,a.chid,a.excode,a.sdksessionid,a.apkstatus,a.transId,a.itemId,a.itemPrice,a.itemSafeLevel,a.itemMethod,a.device_cid,a.monum,a.consumeCode,a.appid,a.encodeCID,a.rand16Num,a.key1,a.key2,a.cpparam,a.cpid,b.configInfo,a.execNum,d.crackSynUrl,a.methodType,a.cpInfoId,a.pramType,a.smsInfo,a.spProductId,a.generateCpparam,a.getSmsType,a.deleteType,a.spProductConsumeCodeId,a.sessionrep  " +
						"FROM exec_log AS a INNER JOIN spinfo.sp_product_crack_info AS b ON a.spProductId=b.spProductId " +
						"INNER JOIN spinfo.cp_info AS d ON a.cpinfoId=d.cpinfoId " +
						"where " +
							"execNum<"+Const.MUSIC_LOGIC_RETRY_NUM+" " +
							"AND getSmsType='true' " +
							"AND methodType="+methodType+" " ;//正常业务
					if(methodType<100){	
					  sql+="AND ((execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 60) " +
							"OR (execNum=1 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 90) " +
							"OR (execNum>=2 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 120)) order by execNum,a.id	limit "+(200-taskNum);
					}else{		
				      sql+="AND ((execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 40) " +
							"OR (execNum=1 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 55) " +
						    "OR (execNum>=2 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 100)) order by execNum,a.id	limit "+(200-taskNum);
					}
				ArrayList<Object> list=dt.executeQuery(sql, MusicExecLog.class, MusicDataLinstenerThreadDao.class);
				taskNum=list.size();
				logger.info(this.dbTableName + "扫描结束，需要处理的数据个数" + taskNum);
				
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
