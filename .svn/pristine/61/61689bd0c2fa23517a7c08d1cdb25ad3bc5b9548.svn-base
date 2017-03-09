package com.astrolink.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.dao.DmSmsPay20DataLinstenerThreadDao;
import com.astrolink.dao.DmSmsPay20ExecLinstenerThreadDao;
import com.astrolink.domain.SupportAttrLog;
import com.astrolink.system.pool.ThreadPoolManager;
import com.astrolink.util.tools.DbTools;

/**
 * 动漫20计费监听服务
 * 
 * @author cuilei
 * @date 2015-11-30
 */
public class DmSmsPay20Service implements IDbObjectReciver, IExecFinish {
	private static DmSmsPay20Service instance;
	private static Logger logger = Logger.getLogger(DmSmsPay20Service.class);
	// 缓冲任务池
	private ConcurrentHashMap<Object, SupportAttrLog> waitMap = new ConcurrentHashMap<Object, SupportAttrLog>();
	// 执行任务池
	private ConcurrentHashMap<Object, Object> execMap = new ConcurrentHashMap<Object, Object>();
	private Vector<Object> delList = new Vector<Object>();
	
	// 等待任务最大数量
	private static final int WAIT_MAP_MAX = 200;

	public static DmSmsPay20Service getInstance() {
		if (instance == null) {
			instance = new DmSmsPay20Service();
		}
		return instance;
	}

	public void doDmSmsPay20Exec(int methodType) {
		logger.info("启动动漫20计费监听服务");

		DmSmsPay20DataLinstenerThreadDao dlt = new DmSmsPay20DataLinstenerThreadDao();
		dlt.setDbObjectReciver(this);
		ThreadPoolManager.getInstance().addJobThread("Dm20ExecLog", dlt);

		logger.info("启动动漫计20费确认监听服务完毕");
	}

	@Override
	public synchronized void dataRecived(Object object) {
		ArrayList<Object> list = (ArrayList<Object>) object;
		for (Object o : list) {
			SupportAttrLog supportAttrLog = (SupportAttrLog) o;

			if (waitMap.size() < WAIT_MAP_MAX && !waitMap.containsKey(supportAttrLog.getImsi()) && !execMap.containsKey(supportAttrLog.getImsi())) {
				waitMap.put(supportAttrLog.getImsi(), supportAttrLog);
			}else{
				String sql = "UPDATE support_exec_log SET updateDate = DATE_ADD(NOW(),INTERVAL 1 MINUTE),random=0 where id=" + supportAttrLog.getSupportExecLogId();
				DbTools dt1 = new DbTools(Const.DB_SPINFO_URL, Const.DB_MYSQL_DRIVER, Const.DB_SPINFO_USERNAME, Const.DB_SPINFO_PASSWORD);
				dt1.upDate(sql, DmSmsPay20Service.class);
			}

			if (waitMap.size() > 0 || execMap.size() > 0) {
				logger.info("数据到达接收器，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size());
			}
		}

		Iterator<Entry<Object, SupportAttrLog>> iterator = waitMap.entrySet().iterator();
		while (iterator.hasNext()) {

			Entry<Object, SupportAttrLog> entry = iterator.next();

			if (!execMap.containsKey(entry.getKey())) {
				logger.info("查询到,动漫20计费处理线程，开始添加，id为" + entry.getKey());
				execMap.put(entry.getKey(), entry.getValue());
				// 添加服务器访问线程
				DmSmsPay20ExecLinstenerThreadDao cslt = new DmSmsPay20ExecLinstenerThreadDao(entry.getValue());
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
				delList = new Vector<Object>();
			}

			if (waitMap.size() > 0 || execMap.size() > 0 || delList.size() > 0) {
				logger.info("清除处理结束的缓存，waitMap数据缓冲数量" + waitMap.size() + "execMap执行缓冲数量" + execMap.size() + "删除缓冲" + delList.size());
			}
		}
	}

	@Override
	public void execDone(Object key) {
//		synchronized (delList) {
			if (!delList.contains(key)) {
				delList.add(key);
			}
//		}
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
