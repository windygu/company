package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.WoShopExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 数据监听线程
 * @author sjh
 * @date 2016-05-19
 */
public class WoShopDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(WoShopDataLinstenerThreadDao.class);
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
				DbTools dt=new  DbTools(Const.DB_WOPLUS_URL,Const.DB_MYSQL_DRIVER,Const.DB_WOPLUS_USERNAME,Const.DB_WOPLUS_PASSWORD);
				
				String sql="SELECT id,cpInfoId,spProductConsumeCodeId,provId,monum,consumeCode,consumePrice,ip,imei,imsi,iccid,mobile,cpparam,proxyIp,linkId,execNum,getSmsType,pramType,methodType,dayTime,inputDate,updateDate,cpId,vac_code,chId,appId,versionCode,appversion,sdkversion,company,channel,sdkVersionCode,gameName,ua,mac,resolution,ssid,spProductId,sms " +
						"FROM woshop_exec_log " +
						"where " +
							"execNum=0 " +
							"AND getSmsType='true' " +
							"AND methodType=0 " +//正常业务 
							" order by id limit 200";
				ArrayList<Object> list=dt.executeQuery(sql, WoShopExecLog.class, WoShopDataLinstenerThreadDao.class);
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
