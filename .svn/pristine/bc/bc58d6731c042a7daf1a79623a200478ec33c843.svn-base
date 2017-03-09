package com.astrolink.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.astrolink.dao.DmGgExecLinstenerThreadDao;
import com.astrolink.dao.DmGgLinstenerThreadDao;
import com.astrolink.domain.DmLogin;
import com.astrolink.system.pool.ThreadPoolManager;

public class DmGgService implements IDbObjectReciver, IExecFinish {

	private static DmGgService instance;
	private static Logger logger = Logger.getLogger(DmGgService.class);
	//缓冲任务池
	private ConcurrentHashMap<Object, DmLogin> waitMap = new ConcurrentHashMap<Object, DmLogin>();
	//执行任务池
	private ConcurrentHashMap<Object, Object> execMap = new ConcurrentHashMap<Object, Object>();
	private ArrayList<Object> delList = new ArrayList<Object>();
	//等待任务最大数量
	private static final int WAIT_MAP_MAX = 100;
	private static final String dbTableName="sp_product_task";
	
	public static DmGgService getInstance() {
		if(instance == null) {
			instance = new DmGgService();
		}
		return instance;
	}
	
	public void doDmGgExec() {
		logger.info("数据导入监听服务");
		
		DmGgLinstenerThreadDao blt = new DmGgLinstenerThreadDao();
		blt.setDbObjectReciver(this);
		ThreadPoolManager.getInstance().addJobThread("DmLogin", blt);
		
		logger.info("数据导入监听服务完毕");
	}

	@Override
	public synchronized void dataRecived(Object object) {
		ArrayList<Object> list = (ArrayList<Object>) object;
		for(Object o:list){
			DmLogin dmLogin = (DmLogin) o;
			if(waitMap.size()<WAIT_MAP_MAX && !waitMap.containsKey(dmLogin.getSpProductTaskId()) && !execMap.containsKey(dmLogin.getSpProductTaskId())) {
				waitMap.put(dmLogin.getSpProductTaskId(), dmLogin);
			}
			
			if (waitMap.size() > 0 || execMap.size() > 0) {
				logger.info("数据到达接收器，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size());
			}
		}
		Iterator<Entry<Object, DmLogin>> iterator = waitMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Object, DmLogin> entry = iterator.next();
			
			if (!execMap.containsKey(entry.getKey())) {
				logger.info("查询到,数据同步处理线程，开始添加，id为" + entry.getKey());
				execMap.put(entry.getKey(), entry.getValue());
				//添加服务器访问线程
				DmGgExecLinstenerThreadDao cslt = new DmGgExecLinstenerThreadDao(entry.getValue());
				cslt.setExecFinish(this);
				cslt.setDbTableName(dbTableName);
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

	@Override
	public void execDone(Object key) {
		synchronized (delList) {
			if (!delList.contains(key)) {
				delList.add(key);
			}
		}
	}
	
}
