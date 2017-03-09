package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.CtccSmsSend;
import com.astrolink.domain.SynData;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;


/**
 * 数据监听线程
 * @author cuilei
 * @date 2015-11-30
 */
public class SynDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(SynDataLinstenerThreadDao.class);
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
				DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
				String sql = "CALL syn_cp_data()";
				/*
				String sql ="SELECT a.spProductConsumeCodeId,a.synSpIncomeId,a.cpInfoId,a.synSpIncomeId,b.codeUser,imei,imsi,message,prov_ID,city_ID,CONCAT(mobile,'') AS mobile,pseudoCode,pseudoNum,price,opType,cpParam,linkId,a.status,synUrl,total,otherInfo,CONCAT(CASE WHEN deductType=0  THEN 2 ELSE 0 END,'') AS deductType "+
							"FROM syn_spincome AS a  "+
							"INNER JOIN cp_info AS b ON a.cpInfoId=b.cpInfoId "+ 
							"INNER JOIN ( "+
								"SELECT * FROM  syn_spincomededuct WHERE dayTime=DATE_FORMAT(NOW(),'%Y-%m-%d') AND ADDTIME>DATE_ADD(NOW(),INTERVAL -240 MINUTE) "+
							") AS c ON a.synSpIncomeId=c.synSpIncomeId  "+
							"WHERE a.synSpIncomeId=21061944";
				System.out.println(sql);
				*/
				ArrayList<Object> list=dt.executeQuery(sql, SynData.class, SynDataLinstenerThreadDao.class);
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
