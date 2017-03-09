package com.astrolink.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.dao.Music2DataLinstenerThreadDao;
import com.astrolink.dao.Music2ExecLinstenerThreadDao;
import com.astrolink.domain.Music2ExecLog;
import com.astrolink.domain.MusicExecLog;
import com.astrolink.system.pool.ThreadPoolManager;

/**
 * 音乐2.0网关逻辑
 * @author sjh
 * @date 2015-11-30
 */
public class Music2Service implements IDbObjectReciver,IExecFinish {
	private static Music2Service instance;
	private static Logger logger = Logger.getLogger(Music2Service.class);
	//缓冲任务池
	private ConcurrentHashMap<Object, Music2ExecLog> waitMap = new ConcurrentHashMap<Object, Music2ExecLog>();
	//执行任务池
	private ConcurrentHashMap<Object, Object> execMap = new ConcurrentHashMap<Object, Object>();
	private ArrayList<Object> delList = new ArrayList<Object>();
	//等待任务最大数量
	private static final int WAIT_MAP_MAX = 100;
	private static final String dbTableName=Const.MUSIC_TABLE_EXEX_LOG;
	public static Music2Service getInstance(){
		if (instance == null) {
			instance = new Music2Service();
		}
		return instance;
	}
	
	public void doMusic2Exec(int methodType){
		logger.info("启动音乐2.0计费确认监听服务");
		
		Music2DataLinstenerThreadDao dlt = new Music2DataLinstenerThreadDao();
		dlt.setDbObjectReciver(this);
		dlt.setDbTableName(dbTableName);
		dlt.setMethodType(methodType);
		ThreadPoolManager.getInstance().addJobThread("Music2ExecLog", dlt);

		logger.info("启动音乐2.0计费确认监听服务完毕");
	}

	@Override
	public synchronized void dataRecived(Object object) {
		ArrayList<Object> list = (ArrayList<Object>) object;
		for(Object o:list){
			Music2ExecLog music2ExecLog=(Music2ExecLog)o;
			if(waitMap.size()<WAIT_MAP_MAX && !waitMap.containsKey(music2ExecLog.getId()) && !execMap.containsKey(music2ExecLog.getId())){
				waitMap.put(music2ExecLog.getId(), music2ExecLog);
			}
			
			if (waitMap.size() > 0 || execMap.size() > 0) {
				logger.info("数据到达接收器，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size());
			}
		}	
		
		Iterator<Entry<Object, Music2ExecLog>> iterator = waitMap.entrySet().iterator();
		while (iterator.hasNext()) {

			Entry<Object, Music2ExecLog> entry = iterator.next();

			if (!execMap.containsKey(entry.getKey())) {
				logger.info("查询到,音乐计费确认处理线程，开始添加，id为" + entry.getKey());
				execMap.put(entry.getKey(), entry.getValue());
				// 添加服务器访问线程
				entry.getValue().getId();
				Music2ExecLinstenerThreadDao cslt=new Music2ExecLinstenerThreadDao(entry.getValue());
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
