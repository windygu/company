package com.astrolink.util.tools;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author cuilei
 * @date 2015-4-16
 */
public class ObjectTools {

	/**
	 * 使用valueMap给对象赋值
	 * 
	 * @param valueMap
	 * @param test
	 */
	public static void invokeFiled(HashMap<String, Object> valueMap,
			Object object) {
		HashMap<String, Method> classMap = ConverBean(object.getClass());
		invokeFiled(valueMap, classMap, object);

	}

	/**
	 * 使用valueMap给对象赋值
	 * 
	 * @param valueMap
	 * @param test
	 */
	public static void invokeFiled(HashMap<String, Object> valueMap,HashMap<String, Method> classMap, Object object) {

		// Method method = classMap.get(name.toLowerCase());
		for (Entry<String, Method> entry : classMap.entrySet()) {

			String key = entry.getKey();
			if (!valueMap.containsKey(key)) {
				System.err.println(key + "未被赋值");
			} else {
				Method method = entry.getValue();
				
				Object value = valueMap.get(key);
				try {
					method.invoke(object, value);
				} catch (Exception e) {
					System.err.println(key + "赋值异常");
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * 获取对象属性-方法map
	 * 
	 * @param drbean
	 * @return
	 */
	public static HashMap<String, Method> ConverBean(Class<?> drbean) {
		Class<?> stopClass = null;
		// 存放class信息
		BeanInfo drbeaninfo = null;
		// 存放属性信息
		PropertyDescriptor[] props;
		HashMap<String, Method> map = new HashMap<String, Method>();
		try {
			// 获取class中得属性方法信息
			drbeaninfo = Introspector.getBeanInfo(drbean, stopClass);
			// 把class中属性放入PropertyDescriptor数组中
			props = drbeaninfo.getPropertyDescriptors();
			
			for (int i = 0; i < props.length; i++) {
				// 获取属性所对应的set方法
				Method setMethod = props[i].getWriteMethod();
				// 判断属性是否有set方法 如果有放入map<属性名，set方法>中
				if (setMethod != null) {
					String field = props[i].getName();// .toLowerCase();
					map.put(field, setMethod);
				}
			}
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
