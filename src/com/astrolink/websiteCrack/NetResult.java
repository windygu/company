package com.astrolink.websiteCrack;



/**
 * @Description:TODO
 * @author miyc
 * @date 2014-9-5
 */
public class NetResult {

	// 状态码
	public String code = "";

	// 联网返回结果
	public String content = "";

	public byte[] data;

	public String cookie;

	public String location;

	public NetResult() {
		// TODO Auto-generated constructor stub
	}

	public NetResult(String code, String content) {
		super();
		this.code = code;
		this.content = content;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	@Override
	public String toString() {
		return "NetResult [code=" + code + ", content=" + content + ", cookie="
				+ cookie + "]";
	}

}
