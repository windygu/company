package com.astrolink.dao;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;

import com.astrolink.domain.DmLogin;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.DmLoginTools;
import com.astrolink.util.tools.ExceptionTools;

public class DmLoginExecLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(DmLoginExecLinstenerThreadDao.class);
	public DmLogin dmLogin;
	public IExecFinish execFinish;
	public Map<Object, Object> map;
	
	
	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}

	public DmLoginExecLinstenerThreadDao(DmLogin dmLogin) {
		this.dmLogin = dmLogin;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	
	public void setDbTableName(String dbTableName) {
	}
	
	@Override
	public void exec() {
		DmLoginTools bml=new DmLoginTools();
		bml.setMap(map);
		try {
			String loginInfo="";
			HttpClient httpclient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
			switch(dmLogin.getType()) {
			case 1:
				logger.info("开始处理动漫CP收入，id为" + dmLogin.getSpProductTaskId());
				bml.doWork(loginInfo,dmLogin,"动漫CP收入",httpclient);//下载上传收入表
				break;
			case 2:
				logger.info("开始处理动漫CP投诉，id为" + this.getKey());
				bml.doWork(loginInfo,dmLogin,"动漫CP投诉",httpclient);//下载上传投诉表
				break;
			case 3:
				logger.info("开始处理月报表，id为" + this.getKey());
				bml.doWork(loginInfo,dmLogin,"月报表",httpclient);//下载上传月报表
				break;
			case 4:
				logger.info("开始处理动漫渠道收入，id为" + this.getKey());
				bml.doWork(loginInfo,dmLogin,"动漫渠道收入",httpclient);//下载上传动漫渠道收入
				break;
			case 5:
				logger.info("开始处理动漫渠道投诉，id为" + this.getKey());
				bml.doWork(loginInfo,dmLogin,"动漫渠道投诉",httpclient);//下载上传动漫渠道投诉
				break;
			case 6:
				logger.info("开始处理全量投诉，id为" + this.getKey());
				bml.doWork(loginInfo,dmLogin,"全量投诉",httpclient);//全量
				break;
			}
			
		} catch (Exception e) {
			
			logger.error(ExceptionTools.exception(e));
		}finally {
			try {
				bml.setDataLog(dmLogin);
			} catch (Exception e2) {
				logger.info("处理请求失败，id为" + this.getKey() + ExceptionTools.exception(e2));
			}finally {
				if (execFinish != null) {
					execFinish.execDone(this.getKey());
					logger.info("处理请求结束，id为" + this.getKey());
				}
			}
		}

	}
}
