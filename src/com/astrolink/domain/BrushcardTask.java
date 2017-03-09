package com.astrolink.domain;

import java.math.BigDecimal;

import com.astrolink.consts.Const;
import com.astrolink.util.tools.BasicsTools;

public class BrushcardTask {

	private int taskId;
	private int spBrushCardTaskId;
	private int cpid;
	private int ssid;
	private int dicProductTypeId;
	private int execNum;
	private int retryNum;
	private int retrySpanTime;
	private int taskStatus;
	private int currentExecNum;
	private int isClient;
	
	public int getSpBrushCardTaskId() {
		return spBrushCardTaskId;
	}
	public void setSpBrushCardTaskId(int spBrushCardTaskId) {
		this.spBrushCardTaskId = spBrushCardTaskId;
		this.taskId=Integer.parseInt(BasicsTools.getUuid(false, 7, Const.random));
	}
	public int getCpid() {
		return cpid;
	}
	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	public int getDicProductTypeId() {
		return dicProductTypeId;
	}
	public void setDicProductTypeId(int dicProductTypeId) {
		this.dicProductTypeId = dicProductTypeId;
	}
	public int getExecNum() {
		return execNum;
	}
	public void setExecNum(int execNum) {
		this.execNum = execNum;
	}
	public int getRetryNum() {
		return retryNum;
	}
	public void setRetryNum(int retryNum) {
		this.retryNum = retryNum;
	}
	public int getRetrySpanTime() {
		return retrySpanTime;
	}
	public void setRetrySpanTime(int retrySpanTime) {
		this.retrySpanTime = retrySpanTime;
	}
	public int getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}
	public int getCurrentExecNum() {
		return currentExecNum;
	}
	public void setCurrentExecNum(int currentExecNum) {
		this.currentExecNum = currentExecNum;
	}
	public int getTaskId() {
		return taskId;
	}
	public int getIsClient() {
		return isClient;
	}
	public void setIsClient(int isClient) {
		this.isClient = isClient;
	}
	
	
	
	
}
