package com.astrolink.system.pool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.dao.CtccSmsDataLinstenerThreadDao;
import com.astrolink.logic.listener.JobThread;

public class ThreadPoolManager implements JobThreadListener {
	private Logger logger = Logger.getLogger(ThreadPoolManager.class);
	private static ThreadPoolManager instance;

	private ConcurrentHashMap<Object, JobThread> poolMap = new ConcurrentHashMap<Object, JobThread>();

	private Queue<JobThread> cacheQueue = new LinkedList<JobThread>();

	public static ThreadPoolManager getInstance() {

		if (instance == null) {
			instance = new ThreadPoolManager();
		}
		return instance;
	}

	/**
	 * 添加线程任务
	 * 
	 * @param key
	 * @param thread
	 */
	public synchronized void addJobThread(Object key, JobThread thread) {

		thread.setKey(key);

		if (poolMap.size() < Const.THREAD_MAX) {
			poolMap.put(key, thread);
			thread.setListener(this);
			thread.start();
		} else {
			cacheQueue.add(thread);
			logger.info("序列中任务挤压数量" + cacheQueue.size());
		}

	}

	/**
	 * 移除线程任务
	 * 
	 * @param key
	 */
	public synchronized void removeJobThread(Object key) {

		poolMap.remove(key);
		if (cacheQueue.size() > 0) {
			while (poolMap.size() < Const.THREAD_MAX) {
				JobThread jobThread = cacheQueue.poll();
				if (jobThread != null) {
					logger.info("=====================================开始处理挤压数据" + jobThread.getKey());
					addJobThread(jobThread.getKey(), jobThread);
				}
			}
		}

	}

	/**
	 * 监听线程任务完成
	 */
	@Override
	public synchronized void jobFinished(Object key) {
		removeJobThread(key);
	}

}
