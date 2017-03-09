package com.astrolink.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.astrolink.dao.CtccGameDataLinstenerThreadDao;
import com.astrolink.dao.CtccGameExecLinstenerThreadDao;
import com.astrolink.domain.CtccGameExecLog;
import com.astrolink.system.pool.ThreadPoolManager;

/**
 * 电信爱游戏网关逻辑
 * @author sjh
 * @date 2016-05-19
 */
public class CtccGameService implements IDbObjectReciver,IExecFinish {
	private static CtccGameService instance;
	private static Logger logger = Logger.getLogger(CtccGameService.class);
	//缓冲任务池
	private ConcurrentHashMap<Object, CtccGameExecLog> waitMap = new ConcurrentHashMap<Object, CtccGameExecLog>();
	//执行任务池
	private ConcurrentHashMap<Object, Object> execMap = new ConcurrentHashMap<Object, Object>();
	private ArrayList<Object> delList = new ArrayList<Object>();
	//等待任务最大数量
	private static final int WAIT_MAP_MAX = 100;
	private static final String dbTableName="game_exec_log";
	public static CtccGameService getInstance(){
		if (instance == null) {
			instance = new CtccGameService();
		}
		return instance;
	}
	
	public void doCtccGameExec(){
		logger.info("启动电信爱游戏计费确认监听服务");
		
		CtccGameDataLinstenerThreadDao dlt = new CtccGameDataLinstenerThreadDao();
		dlt.setDbObjectReciver(this);
		dlt.setDbTableName(dbTableName);
		ThreadPoolManager.getInstance().addJobThread("CtccGameExecLog", dlt);

		logger.info("启动电信爱游戏计费确认监听服务完毕");
	}

	@Override
	public synchronized void dataRecived(Object object) {
		ArrayList<Object> list = (ArrayList<Object>) object;
		for(Object o:list){
			CtccGameExecLog CtccGameExecLog=(CtccGameExecLog)o;
			if(waitMap.size()<WAIT_MAP_MAX && !waitMap.containsKey(CtccGameExecLog.getId()) && !execMap.containsKey(CtccGameExecLog.getId())){
				waitMap.put(CtccGameExecLog.getId(), CtccGameExecLog);
			}
			
			if (waitMap.size() > 0 || execMap.size() > 0) {
				logger.info("数据到达接收器，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size());
			}
		}	
		
		Iterator<Entry<Object, CtccGameExecLog>> iterator = waitMap.entrySet().iterator();
		while (iterator.hasNext()) {

			Entry<Object, CtccGameExecLog> entry = iterator.next();

			if (!execMap.containsKey(entry.getKey())) {
				logger.info("查询到,电信爱游戏计费确认处理线程，开始添加，id为" + entry.getKey());
				execMap.put(entry.getKey(), entry.getValue());
				// 添加服务器访问线程
				entry.getValue().getId();
				CtccGameExecLinstenerThreadDao cslt=new CtccGameExecLinstenerThreadDao(entry.getValue());
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
