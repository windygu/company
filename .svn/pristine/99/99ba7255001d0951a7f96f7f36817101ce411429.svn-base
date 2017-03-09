package com.astrolink.util.tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

public class JsonTools {
	public static Logger logger = Logger.getLogger(JsonTools.class);

	public static JSONObject getJsonData(HashMap hashMap) {

		if (hashMap != null) {
			JSONObject jsonObj = new JSONObject();
			Set keys = hashMap.keySet();
			Iterator it = keys.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				jsonObj.put(key, hashMap.get(key));
			}
			return jsonObj;
		} else {
			return null;
		}

	}

	public static JSONObject getJsonData(String str) {
		try {
			JSONObject jsonObj = JSONObject.fromObject(str);
			return jsonObj;
		} catch (JSONException e) {
			logger.error("", e);
		}
		return null;
	}
	
	/**
	 * 合并JSONObject
	 */
	public static void addAttribute(JSONObject object1,JSONObject object2){
		 Iterator it = object2.keys();  
         while (it.hasNext()) {  
             String key = (String) it.next();  
             String value = object2.getString(key);  
            
             object1.put(key, value);
         }  
	}
}
