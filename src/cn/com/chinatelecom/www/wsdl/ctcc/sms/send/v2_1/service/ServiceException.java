/**
 * ServiceException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
package cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service;

public class ServiceException extends java.lang.Exception {
	private cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2 faultMessage;

	public ServiceException() {
		super("ServiceException");
	}

	public ServiceException(java.lang.String s) {
		super(s);
	}

	public ServiceException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public void setFaultMessage(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2 msg) {
		faultMessage = msg;
	}

	public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2 getFaultMessage() {
		return faultMessage;
	}
}
