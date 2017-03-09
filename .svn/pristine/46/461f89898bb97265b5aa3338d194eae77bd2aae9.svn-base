package com.astrolink.dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.astrolink.consts.Const;
import com.astrolink.domain.MmsExecLog;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IDbObjectReciver;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;

/**
 * 数据监听线程
 * @author sjh
 * @date 2016-4-15
 */
public class MmsDataLinstenerThreadDao extends JobThread{
	private Logger logger = Logger.getLogger(MmsDataLinstenerThreadDao.class);
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
				DbTools dt=new  DbTools(Const.DB_MMS_URL_GW,Const.DB_MYSQL_DRIVER,Const.DB_MMS_USERNAME_GW,Const.DB_MMS_PASSWORD_GW);
				
				String sql="select sendtmp.id,sendtmp.id as smsgid"+
						",sendtmp.gate as gate"+
						",sendtmp.SrctermID as srctermID"+
						",sendtmp.DestMainID as destMainID"+
						",sendtmp.DestAttaID as destAttaID"+
						",sendtmp.DestSecrID as destSecrID"+
						",sendtmp.FeeTermID as feeTermID"+
						",sendtmp.MmsId as mmsId"+
						",sendtmp.MmsSubject as mmsSubject"+
						",sendtmp.MmsDir as mmsDir"+
						",sendtmp.MmsPriority as mmsPriority"+
						",sendtmp.Mms_SvcID as mms_SvcID"+
						",sendtmp.MmsClass as mmsClass"+
						",sendtmp.Sendvisible as sendvisible"+
						",sendtmp.FeeType as feeType"+
						",sendtmp.FeeCode as feeCode"+
						",sendtmp.FeeUserType as feeUserType"+
						",sendtmp.Method as method"+
						",sendtmp.MsgFormat as msgFormat"+
						",sendtmp.time as time"+
						",sendtmp.LinkedID as linkedID"+
						",sendstate.status as status"+
						",sendstate.devtime as devtime"+
						",sendstate.resstat as resstate"+
						",sendstate.restext as restext"+
						",sendstate.time as stime"+
						" from sendstate left join sendtmp on sendtmp.MmsId=sendstate.Msgid where sendtmp.id is not null and sendstate.id is not null order by sendstate.time desc limit 200";
				ArrayList<Object> list=dt.executeQueryForAlias(sql, MmsExecLog.class, MmsDataLinstenerThreadDao.class);
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
