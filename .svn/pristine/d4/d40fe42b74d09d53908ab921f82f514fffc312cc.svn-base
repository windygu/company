package com.astrolink.util.tools.business;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.astrolink.util.tools.ExceptionTool;
import com.astrolink.util.tools.PostNetWork;

public class DmNetWorkIO {
	private static Log			logger				= LogFactory.getLog(DmNetTools20.class);
	private  int			connectionTimeout	= 30000;
	private  int			soTimeout			= 30000;
	public  String netWorkIO(String url, Map<String, String> headers, String data) {
		PostNetWork postNetWork = null;
		String result = "";
		try {
			postNetWork = new PostNetWork(url);
			postNetWork.setConnectionTimeout(connectionTimeout);
			postNetWork.setSoTimeout(soTimeout);
			if (headers != null) {
				if (!headers.containsKey("Content-Type")) {
					postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				}
				for (Entry<String, String> entry : headers.entrySet()) {
					postNetWork.getPostMethod().addRequestHeader(entry.getKey(), entry.getValue());
				}
			}else{
				postNetWork.getPostMethod().addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			}
			postNetWork.setInfoInputStream(data);
			postNetWork.executeMethod();
			result = postNetWork.getString("UTF-8");
			postNetWork.getNetState();
		} catch (Exception e) {
			logger.error(ExceptionTool.getErrorInfo(e));
		} finally {
			postNetWork.closeConn();
		}
		return result;
	}

}
