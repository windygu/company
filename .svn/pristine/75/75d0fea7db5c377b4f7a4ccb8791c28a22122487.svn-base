package com.astrolink.main.tools;

import java.io.File;

import com.astrolink.consts.Const;
import com.astrolink.consts.LoadProperties;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.GetNetWork;
import com.sun.rowset.CachedRowSetImpl;

public class toolsMob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String configName = "config";
		if (args.length == 1) {
			configName = args[0];
		}

		// 配置文件config.properties路径
		String configPath = "." + File.separator + "conf" + File.separator + configName + ".properties";

		new LoadProperties(configPath).init();
		DbTools dt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
		String sql="SELECT * FROM z_copy_mob_city WHERE optype=-1 ";
		CachedRowSetImpl crsi=dt.executeQuery(sql, toolsMob.class);
		try {
			while (crsi.next()) {
				String mob7=crsi.getString("mob7");
				String url="http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile="+mob7+"0001";
				GetNetWork get=new GetNetWork(url);
				get.executeMethod();
				String info=get.getString("GBK");
				System.out.println(info);
				String supplier=getContextByTag(info, "supplier").trim();
				String province=getContextByTag(info, "province").trim();
				String city=getContextByTag(info, "city").trim();
				
				if(!province.equals("-")){
					if(province.equals("内蒙")){
						province="内蒙古";
					}
					
					if(city.equals("宣州")){
						city="宣州区";
					}
					DbTools dt1=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
					String sql1="SELECT * FROM  dic_area WHERE parentCode!=0 AND areaName='"+city+"' AND provinceName='"+province+"' ";
					System.out.println(sql1);
					CachedRowSetImpl crsi1=dt1.executeQuery(sql1, toolsMob.class);
					while (crsi1.next()) {
						// 0、 1、 2、3
						String opType="3";
						if(String.valueOf(supplier).equals("移动")){
							opType="0";
						}else if(String.valueOf(supplier).equals("电信")){
							opType="1";
						}else if(String.valueOf(supplier).equals("联通")){
							opType="2";
						}else{
							opType="3";
						}

						String sqlNew="UPDATE  spinfo.z_copy_mob_city SET gate=0, provId=-1,cityId=-1,prov = '"+province+"',  city = '"+city+"',  provCode = '"+crsi1.getString("parentCode")+"',  cityCode = '"+crsi1.getString("areaCode")+"', opType = '"+opType+"' WHERE mob7 = '"+mob7+"'" ;
						System.out.println(sqlNew);
						DbTools dt2=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
						dt2.upDate(sqlNew, toolsMob.class);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static  String getContextByTag(String context, String tag) {
		String result = "-1";
		int start = context.indexOf("<" + tag + ">") + ("<" + tag + ">").length();
		int end = context.indexOf("</" + tag + ">");
		if (start != -1 && end != -1)
			result = context.substring(start, end);
		//System.out.println(tag + ":\t" + result);
		return result;
	}
}
