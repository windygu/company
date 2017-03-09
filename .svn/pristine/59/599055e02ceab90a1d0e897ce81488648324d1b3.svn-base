package com.astrolink.domain;

import java.sql.Timestamp;

import net.sf.json.JSONObject;

public class Cmd {

	private long id;
	private String senderAddress;
	private String message;
	private String SAN;
	private String linkId;
	private String smsServiceActivationNumber;
	private Timestamp inserttime;
	private long tempCpid;
	private long cmdErrorId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSAN() {
		return SAN;
	}
	public void setSAN(String sAN) {
		SAN = String.valueOf(sAN).replaceAll("tel:","");
	}
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public String getSmsServiceActivationNumber() {
		return smsServiceActivationNumber;
	}
	public void setSmsServiceActivationNumber(String smsServiceActivationNumber) {
		this.smsServiceActivationNumber = smsServiceActivationNumber;
	}
	public Timestamp getInserttime() {
		return inserttime;
	}
	public void setInserttime(Timestamp inserttime) {
		this.inserttime = inserttime;
	}
	public long getTempCpid() {
		return tempCpid;
	}
	public void setTempCpid(long tempCpid) {
		this.tempCpid = tempCpid;
	}
	public long getCmdErrorId() {
		return cmdErrorId;
	}
	public void setCmdErrorId(long cmdErrorId) {
		this.cmdErrorId = cmdErrorId;
	}
	
	@Override
	public String toString() {
		return "Cmd [id=" + id + ", senderAddress=" + senderAddress + ", message=" + message + ", SAN=" + SAN + ", linkId=" + linkId + ", smsServiceActivationNumber=" + smsServiceActivationNumber + ", inserttime=" + inserttime + ", tempCpid=" + tempCpid + ", cmdErrorId=" + cmdErrorId + "]";
	}
	public JSONObject toJson(){
		JSONObject json=new JSONObject();
		json.put("senderAddress",senderAddress);
		json.put("message",message);
		json.put("SAN",SAN);
		json.put("linkId",linkId);
		json.put("smsServiceActivationNumber",smsServiceActivationNumber);
		json.put("inserttime",inserttime.toString());
		return json;
	}
	
}
