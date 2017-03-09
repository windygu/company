package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.Music2ExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 音乐2.0数据监听线程
 * @author sjh
 * @date 2016-09-08
 */
public class Music2DataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(Music2DataLinstenerThreadDao.class);
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
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				
				String sql="SELECT a.id,a.ip,a.proxyIp,a.mobile,a.imei,a.imsi,a.iccid,a.cpparam,a.provId,a.cpInfoId,a.ssid,a.infoState,a.supportState,a.supportType,a.pramType,a.methodType,a.responseType,a.execNum,a.dayTime,a.inputDate,a.updateDate,a.execStep,a.execResultCode,a.execResultInfo,a.execState,e.consumeCode,s.supportAttrInfo,d.crackSynUrl  " +
						"FROM spinfo.support_exec_log AS a " +
						"INNER JOIN spinfo.sp_product_consumecode AS e ON e.spProductConsumeCodeId=a.ssid "+
						"INNER JOIN spinfo.support_attr_log AS s ON s.supportExecLogId=a.id " +
//						"INNER JOIN spinfo.sp_product_crack_info AS b ON a.spProductId=b.spProductId " +
						"INNER JOIN spinfo.cp_info AS d ON a.cpinfoId=d.cpinfoId " +
						"where infoState=0 AND supportState<1000001" + " " +
							"AND execNum<3 " +
							"AND methodType="+methodType+" " +
							"AND supportType='MUSIC'"+
				            "AND ((execNum=0 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 15) " +
							"OR (execNum=1 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 20) " +
						    "OR (execNum>=2 AND (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(a.updateDate))>= 60)) order by execNum,a.id	limit "+(200-taskNum);
				ArrayList<Object> list=dt.executeQuery(sql, Music2ExecLog.class, Music2DataLinstenerThreadDao.class);
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
