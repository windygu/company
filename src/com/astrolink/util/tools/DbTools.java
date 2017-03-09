package com.astrolink.util.tools;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.connection.DbConnection;
import com.sun.rowset.CachedRowSetImpl;


public class DbTools {
	private Connection conn;
	public Logger logger = Logger.getLogger(DbTools.class);
	private Statement stmt = null;
	
	public DbTools(String dbUrl,String driverName,String dbUserName,String dbPassWord) {
		try {
			DbConnection db = new DbConnection();
			conn = db.getDB(dbUrl, driverName, dbUserName, dbPassWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Object> executeQuery(String sqlStr, Class<?> objectClass, Class<?> logClass) {

		CachedRowSetImpl crsi = executeQuery(sqlStr, logClass);

		HashMap<String, Method> classMap = ObjectTools.ConverBean(objectClass);

		ArrayList<Object> list = new ArrayList<Object>();

		try {
			ResultSetMetaData rsmd = crsi.getMetaData();
			
			while (crsi.next()) {
				HashMap<String, Object> valueMap = new HashMap<String, Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					valueMap.put(rsmd.getColumnName(i + 1), crsi.getObject(i + 1));
				}

				Object object = objectClass.newInstance();
				ObjectTools.invokeFiled(valueMap, classMap, object);

				list.add(object);
			}

		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}

		return list;
	}
	
	public ArrayList<Object> executeQueryForAlias(String sqlStr, Class<?> objectClass, Class<?> logClass) {

		CachedRowSetImpl crsi = executeQuery(sqlStr, logClass);

		HashMap<String, Method> classMap = ObjectTools.ConverBean(objectClass);

		ArrayList<Object> list = new ArrayList<Object>();

		try {
			ResultSetMetaData rsmd = crsi.getMetaData();
			
			while (crsi.next()) {
				HashMap<String, Object> valueMap = new HashMap<String, Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					valueMap.put(rsmd.getColumnLabel(i + 1), crsi.getObject(i + 1));
				}

				Object object = objectClass.newInstance();
				ObjectTools.invokeFiled(valueMap, classMap, object);

				list.add(object);
			}

		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}

		return list;
	}

	public CachedRowSetImpl executeQuery(String sqlStr, Class obj) {
		// logger.info(obj.getName() + ":" + sqlStr);
		if (!sqlStr.equals("")) {
			ResultSet rs = null;
			CachedRowSetImpl crs = null;
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlStr);
				crs = new CachedRowSetImpl();
				crs.populate(rs);
			} catch (SQLException SQLE) {
				crs = null;
				logger.error(ExceptionTools.exception(SQLE));
				SQLE.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (rs != null)
						rs.close();
					if (conn != null)
						conn.close();
				} catch (Exception ex1) {
					logger.error(obj.getName() + ":" + ExceptionTools.exception(ex1));
				}
			}
			return crs;
		} else {
			logger.info("sql不能为空");
			return null;
		}
	}

	public boolean insertJson(String tableName, JSONObject json, Class obj) {

		StringBuffer colNames = new StringBuffer();
		StringBuffer values = new StringBuffer();
		Iterator<Entry<String, Object>> iterator = json.entrySet().iterator();
		json.size();
		int index = 0;

		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();

			colNames.append(entry.getKey());
			if (index < json.size() - 1) {
				colNames.append(",");
			}
			String value = BasicsTools.toString(entry.getValue());

			if (!value.contains("()")) {
				values.append("'");
			}
			values.append(value);
			if (!value.contains("()")) {
				values.append("'");
			}
			if (index < json.size() - 1) {
				values.append(",");
			}

			index++;
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO ");

		buffer.append(tableName);
		buffer.append(" (");
		buffer.append(colNames.toString());
		buffer.append(") ");

		buffer.append("VALUES");
		buffer.append(" (");
		buffer.append(values.toString());
		buffer.append(") ");

		return upDate(buffer.toString(), obj);

	}
	
	
	public int insertJsonToId(String tableName, JSONObject json, Class obj) {

		StringBuffer colNames = new StringBuffer();
		StringBuffer values = new StringBuffer();
		Iterator<Entry<String, Object>> iterator = json.entrySet().iterator();
		json.size();
		int index = 0;

		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();

			colNames.append(entry.getKey());
			if (index < json.size() - 1) {
				colNames.append(',');
			}
			String value = BasicsTools.toString(entry.getValue());

			if (!value.contains("()")) {
				values.append("'");
			}
			values.append(value);
			if (!value.contains("()")) {
				values.append("'");
			}
			if (index < json.size() - 1) {
				values.append(',');
			}

			index++;
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO ");

		buffer.append(tableName);
		buffer.append(" (");
		buffer.append(colNames.toString());
		buffer.append(") ");

		buffer.append("VALUES");
		buffer.append(" (");
		buffer.append(values.toString());
		buffer.append(") ");

		return upDateId(buffer.toString(),obj);

	}
	
	public boolean insertJson(String tableName, JSONObject json, Class obj,String charsetName) {

		StringBuffer colNames = new StringBuffer();
		StringBuffer values = new StringBuffer();
		Iterator<Entry<String, Object>> iterator = json.entrySet().iterator();
		json.size();
		int index = 0;

		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();

			colNames.append(entry.getKey());
			if (index < json.size() - 1) {
				colNames.append(",");
			}
			String value = BasicsTools.toString(entry.getValue());

			if (!value.contains("()")) {
				values.append("'");
			}
			values.append(value);
			if (!value.contains("()")) {
				values.append("'");
			}
			if (index < json.size() - 1) {
				values.append(",");
			}

			index++;
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO ");

		buffer.append(tableName);
		buffer.append(" (");
		buffer.append(colNames.toString());
		buffer.append(") ");

		buffer.append("VALUES");
		buffer.append(" (");
		buffer.append(values.toString());
		buffer.append(") ");
		
		String sql="";
		try {
			sql = new String(buffer.toString().getBytes("GBK"), charsetName);
		} catch (UnsupportedEncodingException e) {
			logger.error(obj.getName() + ":" +ExceptionTools.exception(e));
		}

		return upDate(sql, obj);

	}

	public boolean upDate(String sqlStr, Class obj) {
		logger.info(obj.getName() + ":" + sqlStr);
		boolean result = false;
		if (!sqlStr.equals("")) {
			try {
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				if(stmt.executeUpdate(sqlStr)==1){
					result = true;
				}				
			} catch (SQLException SQLE) {
				result = false;
				logger.error(obj.getName() + ":" +ExceptionTools.exception(SQLE));
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception ex1) {
					logger.error(obj.getName() + ":" +ExceptionTools.exception(ex1));
				}
			}
			return result;
		} else {
			logger.info(obj.getName() + ":sql不能为空");
			return result;
		}
	}
	
	public int upDateId(String sqlStr,Class obj) {
		logger.info(obj.getName() + ":" + sqlStr);
		int result = -1;
		if (!sqlStr.equals("")) {
			try {
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				stmt.executeUpdate(sqlStr, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					result = rs.getInt(1);
				}
			} catch (SQLException SQLE) {
				logger.error(obj.getName() + ":" +ExceptionTools.exception(SQLE));
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception ex1) {
					logger.error(obj.getName() + ":" +ExceptionTools.exception(ex1));
				}
			}
			return result;
		} else {
			logger.info(obj.getName() +"sql不能为空");
			return result;
		}
	}

	public boolean handleTransaction(ArrayList<String> sqlArray, Class obj) {
		boolean result = false;
		int AList = sqlArray.size();
		if (AList != 0) {
			try {
				stmt = conn.createStatement();
				conn.setAutoCommit(false);
				for (int i = 0; i < AList; i++) {
					logger.info(obj.getName() + ":" + sqlArray.get(i));
					stmt.executeUpdate(sqlArray.get(i));
				}
				conn.commit();
				conn.setAutoCommit(true);
				result = true;
			} catch (SQLException SQLE) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					logger.error(obj.getName() + ":" +ExceptionTools.exception(e));
				}
				logger.error(obj.getName() + ":" +ExceptionTools.exception(SQLE));
				return result;
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception ex1) {
					logger.error(obj.getName() + ":" + ExceptionTools.exception(ex1));
				}
			}
			return result;
		} else {
			logger.info(obj.getName() + ":没有可以更新的sql语句");
			return result;
		}
	}

}
