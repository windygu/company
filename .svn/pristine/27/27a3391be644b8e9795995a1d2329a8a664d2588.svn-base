package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.CtccGameExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 电信爱游戏
 * @author sjh
 * @date 2016-05-19
 */
public class CtccGameDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(CtccGameDataLinstenerThreadDao.class);
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
				DbTools dt=new  DbTools(Const.DB_CTCC_URL,Const.DB_MYSQL_DRIVER,Const.DB_CTCC_USERNAME,Const.DB_CTCC_PASSWORD);
				
				String sql="SELECT id,cpInfoId,ssid,provId,monum,consumeCode,consumePrice,spProductConsumeCodeId,ip,imei,imsi,iccid,mobile,cpparam,proxyIp,linkId,execNum,getSmsType,pramType,methodType,dayTime,inputDate,updateDate,codec,gkey,appKey,fiveZero,channelid,monum_ext,sms,spProductId,appid,gameCode,sdk_version,sdk_type,packageName,xwkey,apiVersion,ua,mac,build_id,screen_px,appName,gameId,tools_name,tools_money,tools_alias,tools_id  " +
						"FROM game_exec_log " +
						"where " +
							"execNum=0 " +
							"AND getSmsType='true' " +
							"AND methodType=0 " +//正常业务 
							" order by id limit "+(200-taskNum);
				ArrayList<Object> list=dt.executeQuery(sql, CtccGameExecLog.class, CtccGameDataLinstenerThreadDao.class);
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
