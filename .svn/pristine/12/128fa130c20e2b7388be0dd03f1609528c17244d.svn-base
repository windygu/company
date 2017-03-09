package com.astrolink.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.astrolink.dao.WoChannel20SmsDataLinstenerThreadDao;
import com.astrolink.dao.WoChannel20SmsExecLinstenerThreadDao;
import com.astrolink.domain.SupportAttrLog;
import com.astrolink.system.pool.ThreadPoolManager;

/**
 * 小wo渠道20网关逻辑
 * @author cuilei
 * @date 2015-11-30
 */
public class WoChannel20SmsService implements IDbObjectReciver,IExecFinish {
	private static WoChannel20SmsService instance;
	private static Logger logger = Logger.getLogger(WoChannel20SmsService.class);
	//缓冲任务池
	private ConcurrentHashMap<Object, SupportAttrLog> waitMap = new ConcurrentHashMap<Object, SupportAttrLog>();
	//执行任务池
	private ConcurrentHashMap<Object, Object> execMap = new ConcurrentHashMap<Object, Object>();
	private ArrayList<Object> delList = new ArrayList<Object>();
	//等待任务最大数量
	private static final int WAIT_MAP_MAX = 100;
	public static WoChannel20SmsService getInstance(){
		if (instance == null) {
			instance = new WoChannel20SmsService();
		}
		return instance;
	}
	
	public void doWoChannel20SmsExec(){
		logger.info("启动沃渠道20计费确认监听服务");
		
		WoChannel20SmsDataLinstenerThreadDao dlt = new WoChannel20SmsDataLinstenerThreadDao();
		dlt.setDbObjectReciver(this);
		ThreadPoolManager.getInstance().addJobThread("WoChannel20ExecLog", dlt);

		logger.info("启动沃渠道20计费确认监听服务完毕");
	}

	@Override
	public synchronized void dataRecived(Object object) {
		@SuppressWarnings("unchecked")
		ArrayList<Object> list = (ArrayList<Object>) object;
		for(Object o:list){
			SupportAttrLog supportAttrLog=(SupportAttrLog)o;
			if(waitMap.size()<WAIT_MAP_MAX && !waitMap.containsKey(supportAttrLog.getImsi()) && !execMap.containsKey(supportAttrLog.getImsi())){
				waitMap.put(supportAttrLog.getImsi(), supportAttrLog);
			}
			
			if (waitMap.size() > 0 || execMap.size() > 0) {
				logger.info("数据到达接收器，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size());
			}
		}	
		
		Iterator<Entry<Object, SupportAttrLog>> iterator = waitMap.entrySet().iterator();
		while (iterator.hasNext()) {

			Entry<Object, SupportAttrLog> entry = iterator.next();

			if (!execMap.containsKey(entry.getKey())) {
				logger.info("查询到,沃渠道20计费确认处理线程，开始添加，id为" + entry.getKey());
				execMap.put(entry.getKey(), entry.getValue());
				// 添加服务器访问线程
				WoChannel20SmsExecLinstenerThreadDao cslt=new WoChannel20SmsExecLinstenerThreadDao(entry.getValue());
				cslt.setExecFinish(this);
				ThreadPoolManager.getInstance().addJobThread(entry.getKey(), cslt);
				logger.info("id为" + entry.getKey() + "的处理线程添加成功");
				iterator.remove();
			}
		}
			
		synchronized (delList) {
			for (Object key : delList) {
				waitMap.remove(key);
				execMap.remove(key);
			}

			if (delList.size() != 0 && !checkConatinsKey()) {
				delList = new ArrayList<Object>();
			}

			if (waitMap.size() > 0 || execMap.size() > 0 || delList.size() > 0) {
				logger.info("清除处理结束的缓存，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size() + "删除缓冲" + delList.size());
			}
		}
	}

	@Override
	public void execDone(Object key) {
		synchronized (delList) {
			if (!delList.contains(key)) {
				delList.add(key);
			}
		}
	}
	
	private boolean checkConatinsKey() {
		for (Object key : delList) {
			if (waitMap.contains(key)) {
				return true;
			}
			if (execMap.contains(key)) {
				return true;
			}
		}
		return false;
	}

}
