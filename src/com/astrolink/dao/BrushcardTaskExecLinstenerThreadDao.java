package com.astrolink.dao;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.astrolink.consts.Const;
import com.astrolink.domain.BrushcardTask;
import com.astrolink.domain.Complaint;
import com.astrolink.logic.listener.JobThread;
import com.astrolink.service.IExecFinish;
import com.astrolink.util.tools.BasicsTools;
import com.astrolink.util.tools.DbTools;
import com.astrolink.util.tools.ExceptionTools;
import com.astrolink.util.tools.GetNetWork;

public class BrushcardTaskExecLinstenerThreadDao extends JobThread {

	private Logger logger = Logger.getLogger(BrushcardTaskExecLinstenerThreadDao.class);
	public BrushcardTask brushcardTask;
	public IExecFinish execFinish;
	
	public BrushcardTaskExecLinstenerThreadDao(BrushcardTask brushcardTask) {
		this.brushcardTask = brushcardTask;
	}
	
	public void setExecFinish(IExecFinish execFinish) {
		this.execFinish = execFinish;
	}
	 
	@Override
	public void exec() {
		logger.info("开始数据同步确认，id为" + this.getKey());
		try {
			JSONObject getMobileInfo=getInfo("http://211.103.34.91:9912/server/?action=getMobile&uid=njzhou&token=0edbcd0528499ba55f58e303a6f72a9a&pid="+brushcardTask.getSsid());
			if(getMobileInfo!=null && getMobileInfo.getInt("result")==0){
				String mobile=getMobileInfo.getString("mobile");
				try {
					JSONObject getJdGameSms=new JSONObject();
					if(brushcardTask.getIsClient()==0){
						getJdGameSms=getInfo("http://42.96.169.232:8081/logic/jdGameSms?ssid="+brushcardTask.getSsid()+"&cpparam="+BasicsTools.getUuid(false, 8, Const.random)+"&cpid="+brushcardTask.getCpid()+"&returnType=3000&methodType=900&paymethod=VerifyCode&mobile="+mobile);
					}else{
						getJdGameSms=getInfo("http://42.96.169.232:8081/logic/jdGameSms?ssid="+brushcardTask.getSsid()+"&cpparam="+BasicsTools.getUuid(false, 8, Const.random)+"&cpid="+brushcardTask.getCpid()+"&returnType=4000&methodType=4000&paymethod=clientVerifyCode&mobile="+mobile);
					}
					if( brushcardTask.getIsClient()==1 || (getJdGameSms!=null && getJdGameSms.getBoolean("getCodeType")==true) ){
						String nextUrl=getJdGameSms.getString("nextUrl");//.replaceAll("42.96.169.232:8081", "127.0.0.1:8080");
						String verifyCodeUrl=nextUrl;
						Thread.sleep(brushcardTask.getRetrySpanTime());
						JSONObject getVerifyCode=getInfo("http://211.103.34.91:9912/server/?action=getSMS&mobile="+mobile);
						if(getVerifyCode!=null && getVerifyCode.getInt("result")==0){
							String verifyCode=getVerifyCode.getString("code");
							JSONObject jdGamePayCode=getInfo(verifyCodeUrl+verifyCode);
							if(jdGamePayCode!=null && jdGamePayCode.getInt("message")==200000){
								DbTools udt=new  DbTools(Const.DB_SPINFO_URL,Const.DB_MYSQL_DRIVER,Const.DB_SPINFO_USERNAME,Const.DB_SPINFO_PASSWORD);
								udt.upDate("UPDATE spinfo.sp_brushcard_task SET successNum = successNum+1 WHERE spBrushCardTaskId ="+brushcardTask.getSpBrushCardTaskId() ,BrushcardTaskExecLinstenerThreadDao.class);
							}
							
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					getInfo("http://211.103.34.91:9912/server/?action=ReleaseMobile&state=4&mobile="+mobile);
				}
				
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}finally {
			if (execFinish != null) {
				execFinish.execDone(this.getKey());
				logger.info("处理请求结束，id为" + this.getKey());
			}
			
		}

	}
	
	
	public JSONObject getInfo(String url){
		try {
			logger.info(url);
			GetNetWork getInfo=new GetNetWork(url);
			getInfo.executeMethod();
			String info=getInfo.getString();
			if(!info.equals("")){
				JSONObject json=JSONObject.fromObject(info);
				logger.info(json);
				return json;
			}
		} catch (Exception e) {
			logger.error(ExceptionTools.exception(e));
		}
		return null;
	}
}
