package com.astrolink.domain;

import java.sql.Timestamp;

public class CtccOp {

	private long id;
	private String mobile;
	private String content;
	private String dest;
	private Timestamp time;
	private String serial;
	private String serialRev;
	private Timestamp intime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getSerialRev() {
		return serialRev;
	}
	public void setSerialRev(String serialRev) {
		this.serialRev = serialRev;
	}
	public Timestamp getIntime() {
		return intime;
	}
	public void setIntime(Timestamp intime) {
		this.intime = intime;
	}
	public String toUrl(String url) {
		StringBuffer sBuff=new StringBuffer();
		sBuff.append(url);
		sBuff.append("?id="+id);
		sBuff.append("&mobile="+mobile);
		sBuff.append("&content="+content);
		return sBuff.toString();
	}
}
