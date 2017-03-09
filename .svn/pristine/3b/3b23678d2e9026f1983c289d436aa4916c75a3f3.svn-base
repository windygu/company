package com.astrolink.domain;

import net.sf.json.JSONObject;

public class SupportAttrLog {
	private long supportExecLogId;
	private String supportAttrInfo;
	
	private int execNum;
	private int methodType;
	private String crackSynUrl;
	private String imsi;
	
	public long getSupportExecLogId() {
		return supportExecLogId;
	}
	public void setSupportExecLogId(long supportExecLogId) {
		this.supportExecLogId = supportExecLogId;
	}
	public JSONObject getSupportAttrInfoToJSON() {
		try {
			return JSONObject.fromObject(supportAttrInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void setSupportAttrInfo(String supportAttrInfo) {
		this.supportAttrInfo = supportAttrInfo;
	}
	public int getExecNum() {
		return execNum;
	}
	public void setExecNum(int execNum) {
		this.execNum = execNum;
	}
	public int getMethodType() {
		return methodType;
	}
	public void setMethodType(int methodType) {
		this.methodType = methodType;
	}
	public String getCrackSynUrl() {
		return crackSynUrl;
	}
	public void setCrackSynUrl(String crackSynUrl) {
		this.crackSynUrl = crackSynUrl;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	
}
