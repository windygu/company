package com.astrolink.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	/**
	 * 获取数据连接
	 * @param dbUrl	
	 * @param driverName
	 * @param dbUserName
	 * @param dbPassWord
	 * @return
	 */
	public Connection getDB(String dbUrl,String driverName,String dbUserName,String dbPassWord) {
		String dbURL = dbUrl; // 连接服务器和数据库test
		Connection dbConn = null;
		try {
			Class.forName(driverName);// 加载JDBC驱动
			dbConn = DriverManager.getConnection(dbURL, dbUserName, dbPassWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbConn;
	}
}
