/**
 * SendSmsServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
package cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service;

/*
 *  SendSmsServiceStub java implementation
 */
public class SendSmsServiceStub extends org.apache.axis2.client.Stub {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();
	private javax.xml.namespace.QName[] opNameArray = null;
	
	/**
	 * Constructor that takes in a configContext
	 */
	public SendSmsServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public SendSmsServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext, java.lang.String targetEndpoint, boolean useSeparateListener) throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

		configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

		_serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
	}

	/**
	 * Default Constructor
	 */
	public SendSmsServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
		this(configurationContext, "http://localhost:9080/SendSmsService/services/SendSms");
	}

	/**
	 * Default Constructor
	 */
	public SendSmsServiceStub() throws org.apache.axis2.AxisFault {
		this("http://localhost:9080/SendSmsService/services/SendSms");
	}

	/**
	 * Constructor taking the target endpoint
	 */
	public SendSmsServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {
		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("SendSmsService" + this.hashCode());

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[4];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSms"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSmsLogo"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSmsRingtone"));
		_service.addOperation(__operation);

		_operations[2] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "getSmsDeliveryStatus"));
		_service.addOperation(__operation);

		_operations[3] = __operation;
	}

	// populates the faults
	private void populateFaults() {
		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$PolicyException3");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$ServiceException2");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$PolicyException3");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$ServiceException2");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$PolicyException3");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$ServiceException2");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$PolicyException3");

		faultExceptionNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException");
		faultMessageMap.put(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException"), "cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub$ServiceException2");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#sendSms
	 * @param sendSms0
	 */
	public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4 sendSms(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7 sendSms0) throws java.rmi.RemoteException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException {
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("\"\"");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sendSms0, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSms")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4.class, getEnvelopeNamespaces(_returnEnv));
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);

			return (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4) object;
		} catch (org.apache.axis2.AxisFault f) {
			org.apache.axiom.om.OMElement faultElt = f.getDetail();

			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex;
						}

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#startsendSms
	 * @param sendSms0
	 */
	public void startsendSms(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7 sendSms0, final cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceCallbackHandler callback) throws java.rmi.RemoteException {
		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction("\"\"");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.
		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sendSms0, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSms")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4.class, getEnvelopeNamespaces(resultEnv));
					callback.receiveResultsendSms((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4) object);
				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorsendSms(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();

					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

								// message class
								java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
									callback.receiveErrorsendSms((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex);

									return;
								}

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
									callback.receiveErrorsendSms((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex);

									return;
								}

								callback.receiveErrorsendSms(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSms(f);
							}
						} else {
							callback.receiveErrorsendSms(f);
						}
					} else {
						callback.receiveErrorsendSms(f);
					}
				} else {
					callback.receiveErrorsendSms(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				// Do nothing by default
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

		if ((_operations[0].getMessageReceiver() == null) && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#sendSmsLogo
	 * @param sendSmsLogo2
	 */
	public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9 sendSmsLogo(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11 sendSmsLogo2) throws java.rmi.RemoteException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException {
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction("\"\"");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sendSmsLogo2, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSmsLogo")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9.class, getEnvelopeNamespaces(_returnEnv));
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);

			return (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9) object;
		} catch (org.apache.axis2.AxisFault f) {
			org.apache.axiom.om.OMElement faultElt = f.getDetail();

			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex;
						}

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#startsendSmsLogo
	 * @param sendSmsLogo2
	 */
	public void startsendSmsLogo(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11 sendSmsLogo2, final cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceCallbackHandler callback) throws java.rmi.RemoteException {
		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction("\"\"");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.
		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sendSmsLogo2, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSmsLogo")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9.class, getEnvelopeNamespaces(resultEnv));
					callback.receiveResultsendSmsLogo((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9) object);
				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorsendSmsLogo(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();

					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

								// message class
								java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
									callback.receiveErrorsendSmsLogo((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex);

									return;
								}

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
									callback.receiveErrorsendSmsLogo((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex);

									return;
								}

								callback.receiveErrorsendSmsLogo(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsLogo(f);
							}
						} else {
							callback.receiveErrorsendSmsLogo(f);
						}
					} else {
						callback.receiveErrorsendSmsLogo(f);
					}
				} else {
					callback.receiveErrorsendSmsLogo(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				// Do nothing by default
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

		if ((_operations[1].getMessageReceiver() == null) && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#sendSmsRingtone
	 * @param sendSmsRingtone4
	 */
	public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6 sendSmsRingtone(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10 sendSmsRingtone4) throws java.rmi.RemoteException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException {
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
			_operationClient.getOptions().setAction("\"\"");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sendSmsRingtone4, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSmsRingtone")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6.class, getEnvelopeNamespaces(_returnEnv));
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);

			return (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6) object;
		} catch (org.apache.axis2.AxisFault f) {
			org.apache.axiom.om.OMElement faultElt = f.getDetail();

			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex;
						}

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#startsendSmsRingtone
	 * @param sendSmsRingtone4
	 */
	public void startsendSmsRingtone(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10 sendSmsRingtone4, final cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceCallbackHandler callback) throws java.rmi.RemoteException {
		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
		_operationClient.getOptions().setAction("\"\"");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.
		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), sendSmsRingtone4, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "sendSmsRingtone")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6.class, getEnvelopeNamespaces(resultEnv));
					callback.receiveResultsendSmsRingtone((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6) object);
				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorsendSmsRingtone(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();

					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

								// message class
								java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
									callback.receiveErrorsendSmsRingtone((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex);

									return;
								}

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
									callback.receiveErrorsendSmsRingtone((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex);

									return;
								}

								callback.receiveErrorsendSmsRingtone(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorsendSmsRingtone(f);
							}
						} else {
							callback.receiveErrorsendSmsRingtone(f);
						}
					} else {
						callback.receiveErrorsendSmsRingtone(f);
					}
				} else {
					callback.receiveErrorsendSmsRingtone(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				// Do nothing by default
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

		if ((_operations[2].getMessageReceiver() == null) && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[2].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#getSmsDeliveryStatus
	 * @param getSmsDeliveryStatus6
	 */
	public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8 getSmsDeliveryStatus(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5 getSmsDeliveryStatus6) throws java.rmi.RemoteException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException {
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
			_operationClient.getOptions().setAction("\"\"");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

			// create a message context
			org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getSmsDeliveryStatus6, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "getSmsDeliveryStatus")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8.class, getEnvelopeNamespaces(_returnEnv));
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);

			return (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8) object;
		} catch (org.apache.axis2.AxisFault f) {
			org.apache.axiom.om.OMElement faultElt = f.getDetail();

			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex;
						}

						if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
							throw (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService#startgetSmsDeliveryStatus
	 * @param getSmsDeliveryStatus6
	 */
	public void startgetSmsDeliveryStatus(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5 getSmsDeliveryStatus6, final cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceCallbackHandler callback) throws java.rmi.RemoteException {
		org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
		_operationClient.getOptions().setAction("\"\"");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.
		env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getSmsDeliveryStatus6, optimizeContent(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "getSmsDeliveryStatus")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(), cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8.class, getEnvelopeNamespaces(resultEnv));
					callback.receiveResultgetSmsDeliveryStatus((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8) object);
				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorgetSmsDeliveryStatus(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();

					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();

								// message class
								java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage", new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) {
									callback.receiveErrorgetSmsDeliveryStatus((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.PolicyException) ex);

									return;
								}

								if (ex instanceof cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) {
									callback.receiveErrorgetSmsDeliveryStatus((cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.ServiceException) ex);

									return;
								}

								callback.receiveErrorgetSmsDeliveryStatus(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetSmsDeliveryStatus(f);
							}
						} else {
							callback.receiveErrorgetSmsDeliveryStatus(f);
						}
					} else {
						callback.receiveErrorgetSmsDeliveryStatus(f);
					}
				} else {
					callback.receiveErrorgetSmsDeliveryStatus(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				// Do nothing by default
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;

		if ((_operations[3].getMessageReceiver() == null) && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[3].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);
	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) { 
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();

		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}

		return returnMap;
	}

	private boolean optimizeContent(javax.xml.namespace.QName opName) {
		if (opNameArray == null) {
			return false;
		}

		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}

		return false;
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.om.OMElement toOM(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			return param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8.MY_QNAME, org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7.MY_QNAME, factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10.MY_QNAME, factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11.MY_QNAME, factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5 param, boolean optimizeContent) throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
			emptyEnvelope.getBody().addChild(param.getOMElement(cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5.MY_QNAME, factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type, java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {
		try {
			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSms7.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsResponse4.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtone10.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsRingtoneResponse6.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogo11.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.SendSmsLogoResponse9.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatus5.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.GetSmsDeliveryStatusResponse8.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.PolicyException3.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}

			if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.class.equals(type)) {
				return cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceStub.ServiceException2.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

		return null;
	}

	// http://localhost:9080/SendSmsService/services/SendSms
	public static class RequestSOAPHeader implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for SpId
		 */
		protected java.lang.String localSpId;

		/**
		 * field for SpPassword
		 */
		protected java.lang.String localSpPassword;

		/**
		 * field for TimeStamp
		 */
		protected java.lang.String localTimeStamp;

		/**
		 * field for ProductId
		 */
		protected java.lang.String localProductId;

		/**
		 * field for SAN
		 */
		protected java.lang.String localSAN;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSANTracker = false;

		/**
		 * field for TransactionId
		 */
		protected java.lang.String localTransactionId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTransactionIdTracker = false;

		/**
		 * field for TransEnd
		 */
		protected EndReason localTransEnd;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTransEndTracker = false;

		/**
		 * field for LinkId
		 */
		protected java.lang.String localLinkId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localLinkIdTracker = false;

		/**
		 * field for OA
		 */
		protected org.apache.axis2.databinding.types.URI localOA;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localOATracker = false;

		/**
		 * field for FA
		 */
		protected org.apache.axis2.databinding.types.URI localFA;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localFATracker = false;

		/**
		 * field for MulticastMessaging
		 */
		protected boolean localMulticastMessaging;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localMulticastMessagingTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * RequestSOAPHeader Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1 Namespace
		 * Prefix = ns1
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSpId() {
			return localSpId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SpId
		 */
		public void setSpId(java.lang.String param) {
			this.localSpId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSpPassword() {
			return localSpPassword;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SpPassword
		 */
		public void setSpPassword(java.lang.String param) {
			this.localSpPassword = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTimeStamp() {
			return localTimeStamp;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TimeStamp
		 */
		public void setTimeStamp(java.lang.String param) {
			this.localTimeStamp = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getProductId() {
			return localProductId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ProductId
		 */
		public void setProductId(java.lang.String param) {
			this.localProductId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSAN() {
			return localSAN;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SAN
		 */
		public void setSAN(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSANTracker = true;
			} else {
				localSANTracker = false;
			}

			this.localSAN = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTransactionId() {
			return localTransactionId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TransactionId
		 */
		public void setTransactionId(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localTransactionIdTracker = true;
			} else {
				localTransactionIdTracker = false;
			}

			this.localTransactionId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return EndReason
		 */
		public EndReason getTransEnd() {
			return localTransEnd;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TransEnd
		 */
		public void setTransEnd(EndReason param) {
			if (param != null) {
				// update the setting tracker
				localTransEndTracker = true;
			} else {
				localTransEndTracker = false;
			}

			this.localTransEnd = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getLinkId() {
			return localLinkId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            LinkId
		 */
		public void setLinkId(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localLinkIdTracker = true;
			} else {
				localLinkIdTracker = false;
			}

			this.localLinkId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI
		 */
		public org.apache.axis2.databinding.types.URI getOA() {
			return localOA;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            OA
		 */
		public void setOA(org.apache.axis2.databinding.types.URI param) {
			if (param != null) {
				// update the setting tracker
				localOATracker = true;
			} else {
				localOATracker = false;
			}

			this.localOA = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI
		 */
		public org.apache.axis2.databinding.types.URI getFA() {
			return localFA;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FA
		 */
		public void setFA(org.apache.axis2.databinding.types.URI param) {
			if (param != null) {
				// update the setting tracker
				localFATracker = true;
			} else {
				localFATracker = false;
			}

			this.localFA = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return boolean
		 */
		public boolean getMulticastMessaging() {
			return localMulticastMessaging;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            MulticastMessaging
		 */
		public void setMulticastMessaging(boolean param) {
			// setting primitive attribute tracker to true
			if (false) {
				localMulticastMessagingTracker = false;
			} else {
				localMulticastMessagingTracker = true;
			}

			this.localMulticastMessaging = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					RequestSOAPHeader.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "spId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "spId");
				}
			} else {
				xmlWriter.writeStartElement("spId");
			}

			if (localSpId == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("spId cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localSpId);
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "spPassword", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "spPassword");
				}
			} else {
				xmlWriter.writeStartElement("spPassword");
			}

			if (localSpPassword == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("spPassword cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localSpPassword);
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "timeStamp", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "timeStamp");
				}
			} else {
				xmlWriter.writeStartElement("timeStamp");
			}

			if (localTimeStamp == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("timeStamp cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localTimeStamp);
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "productId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "productId");
				}
			} else {
				xmlWriter.writeStartElement("productId");
			}

			if (localProductId == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("productId cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localProductId);
			}

			xmlWriter.writeEndElement();

			if (localSANTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "SAN", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "SAN");
					}
				} else {
					xmlWriter.writeStartElement("SAN");
				}

				if (localSAN == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("SAN cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSAN);
				}

				xmlWriter.writeEndElement();
			}

			if (localTransactionIdTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "transactionId", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "transactionId");
					}
				} else {
					xmlWriter.writeStartElement("transactionId");
				}

				if (localTransactionId == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("transactionId cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localTransactionId);
				}

				xmlWriter.writeEndElement();
			}

			if (localTransEndTracker) {
				if (localTransEnd == null) {
					throw new org.apache.axis2.databinding.ADBException("transEnd cannot be null!!");
				}

				localTransEnd.serialize(new javax.xml.namespace.QName("", "transEnd"), factory, xmlWriter);
			}

			if (localLinkIdTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "linkId", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "linkId");
					}
				} else {
					xmlWriter.writeStartElement("linkId");
				}

				if (localLinkId == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("linkId cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localLinkId);
				}

				xmlWriter.writeEndElement();
			}

			if (localOATracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "OA", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "OA");
					}
				} else {
					xmlWriter.writeStartElement("OA");
				}

				if (localOA == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("OA cannot be null!!");
				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOA));
				}

				xmlWriter.writeEndElement();
			}

			if (localFATracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "FA", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "FA");
					}
				} else {
					xmlWriter.writeStartElement("FA");
				}

				if (localFA == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("FA cannot be null!!");
				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFA));
				}

				xmlWriter.writeEndElement();
			}

			if (localMulticastMessagingTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "multicastMessaging", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "multicastMessaging");
					}
				} else {
					xmlWriter.writeStartElement("multicastMessaging");
				}

				if (false) {
					throw new org.apache.axis2.databinding.ADBException("multicastMessaging cannot be null!!");
				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMulticastMessaging));
				}

				xmlWriter.writeEndElement();
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "spId"));

			if (localSpId != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpId));
			} else {
				throw new org.apache.axis2.databinding.ADBException("spId cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "spPassword"));

			if (localSpPassword != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpPassword));
			} else {
				throw new org.apache.axis2.databinding.ADBException("spPassword cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "timeStamp"));

			if (localTimeStamp != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTimeStamp));
			} else {
				throw new org.apache.axis2.databinding.ADBException("timeStamp cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "productId"));

			if (localProductId != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductId));
			} else {
				throw new org.apache.axis2.databinding.ADBException("productId cannot be null!!");
			}

			if (localSANTracker) {
				elementList.add(new javax.xml.namespace.QName("", "SAN"));

				if (localSAN != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSAN));
				} else {
					throw new org.apache.axis2.databinding.ADBException("SAN cannot be null!!");
				}
			}

			if (localTransactionIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "transactionId"));

				if (localTransactionId != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTransactionId));
				} else {
					throw new org.apache.axis2.databinding.ADBException("transactionId cannot be null!!");
				}
			}

			if (localTransEndTracker) {
				elementList.add(new javax.xml.namespace.QName("", "transEnd"));

				if (localTransEnd == null) {
					throw new org.apache.axis2.databinding.ADBException("transEnd cannot be null!!");
				}

				elementList.add(localTransEnd);
			}

			if (localLinkIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "linkId"));

				if (localLinkId != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLinkId));
				} else {
					throw new org.apache.axis2.databinding.ADBException("linkId cannot be null!!");
				}
			}

			if (localOATracker) {
				elementList.add(new javax.xml.namespace.QName("", "OA"));

				if (localOA != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOA));
				} else {
					throw new org.apache.axis2.databinding.ADBException("OA cannot be null!!");
				}
			}

			if (localFATracker) {
				elementList.add(new javax.xml.namespace.QName("", "FA"));

				if (localFA != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFA));
				} else {
					throw new org.apache.axis2.databinding.ADBException("FA cannot be null!!");
				}
			}

			if (localMulticastMessagingTracker) {
				elementList.add(new javax.xml.namespace.QName("", "multicastMessaging"));

				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMulticastMessaging));
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static RequestSOAPHeader parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				RequestSOAPHeader object = new RequestSOAPHeader();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"RequestSOAPHeader".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (RequestSOAPHeader) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "spId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSpId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "spPassword").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSpPassword(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "timeStamp").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setTimeStamp(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "productId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setProductId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "SAN").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSAN(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "transactionId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setTransactionId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "transEnd").equals(reader.getName())) {
						object.setTransEnd(EndReason.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "linkId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setLinkId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "OA").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setOA(org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "FA").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setFA(org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "multicastMessaging").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setMulticastMessaging(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsRingtoneResponse implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Result
		 */
		protected java.lang.String localResult;

		/*
		 * This type was generated from the piece of schema that had name =
		 * sendSmsRingtoneResponse Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getResult() {
			return localResult;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Result
		 */
		public void setResult(java.lang.String param) {
			this.localResult = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsRingtoneResponse.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "result", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "result");
				}
			} else {
				xmlWriter.writeStartElement("result");
			}

			if (localResult == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localResult);
			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result"));

			if (localResult != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResult));
			} else {
				throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsRingtoneResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsRingtoneResponse object = new SendSmsRingtoneResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"sendSmsRingtoneResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SendSmsRingtoneResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setResult(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsLogo implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Addresses This was an Array!
		 */
		protected org.apache.axis2.databinding.types.URI[] localAddresses;

		/**
		 * field for SenderName
		 */
		protected java.lang.String localSenderName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSenderNameTracker = false;

		/**
		 * field for Charging
		 */
		protected ChargingInformation localCharging;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localChargingTracker = false;

		/**
		 * field for Image
		 */
		protected javax.activation.DataHandler localImage;

		/**
		 * field for SmsFormat
		 */
		protected SmsFormat localSmsFormat;

		/**
		 * field for ReceiptRequest
		 */
		protected SimpleReference localReceiptRequest;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceiptRequestTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * sendSmsLogo Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI[]
		 */
		public org.apache.axis2.databinding.types.URI[] getAddresses() {
			return localAddresses;
		}

		/**
		 * validate the array for Addresses
		 */
		protected void validateAddresses(org.apache.axis2.databinding.types.URI[] param) {
			if ((param != null) && (param.length < 1)) {
				throw new java.lang.RuntimeException();
			}
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Addresses
		 */
		public void setAddresses(org.apache.axis2.databinding.types.URI[] param) {
			validateAddresses(param);

			this.localAddresses = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            org.apache.axis2.databinding.types.URI
		 */
		public void addAddresses(org.apache.axis2.databinding.types.URI param) {
			if (localAddresses == null) {
				localAddresses = new org.apache.axis2.databinding.types.URI[] {};
			}

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localAddresses);
			list.add(param);
			this.localAddresses = (org.apache.axis2.databinding.types.URI[]) list.toArray(new org.apache.axis2.databinding.types.URI[list.size()]);
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSenderName() {
			return localSenderName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SenderName
		 */
		public void setSenderName(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSenderNameTracker = true;
			} else {
				localSenderNameTracker = false;
			}

			this.localSenderName = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return ChargingInformation
		 */
		public ChargingInformation getCharging() {
			return localCharging;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Charging
		 */
		public void setCharging(ChargingInformation param) {
			if (param != null) {
				// update the setting tracker
				localChargingTracker = true;
			} else {
				localChargingTracker = false;
			}

			this.localCharging = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.activation.DataHandler
		 */
		public javax.activation.DataHandler getImage() {
			return localImage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Image
		 */
		public void setImage(javax.activation.DataHandler param) {
			this.localImage = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SmsFormat
		 */
		public SmsFormat getSmsFormat() {
			return localSmsFormat;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SmsFormat
		 */
		public void setSmsFormat(SmsFormat param) {
			this.localSmsFormat = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SimpleReference
		 */
		public SimpleReference getReceiptRequest() {
			return localReceiptRequest;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceiptRequest
		 */
		public void setReceiptRequest(SimpleReference param) {
			if (param != null) {
				// update the setting tracker
				localReceiptRequestTracker = true;
			} else {
				localReceiptRequestTracker = false;
			}

			this.localReceiptRequest = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsLogo.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (localAddresses != null) {
				namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

				boolean emptyNamespace = (namespace == null) || (namespace.length() == 0);
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);

				for (int i = 0; i < localAddresses.length; i++) {
					if (localAddresses[i] != null) {
						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "addresses", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);
							} else {
								xmlWriter.writeStartElement(namespace, "addresses");
							}
						} else {
							xmlWriter.writeStartElement("addresses");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddresses[i]));

						xmlWriter.writeEndElement();
					} else {
						throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
					}
				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
			}

			if (localSenderNameTracker) {
				namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "senderName", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "senderName");
					}
				} else {
					xmlWriter.writeStartElement("senderName");
				}

				if (localSenderName == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("senderName cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSenderName);
				}

				xmlWriter.writeEndElement();
			}

			if (localChargingTracker) {
				if (localCharging == null) {
					throw new org.apache.axis2.databinding.ADBException("charging cannot be null!!");
				}

				localCharging.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging"), factory, xmlWriter);
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "image", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "image");
				}
			} else {
				xmlWriter.writeStartElement("image");
			}

			if (localImage != null) {
				xmlWriter.writeDataHandler(localImage);
			}

			xmlWriter.writeEndElement();

			if (localSmsFormat == null) {
				throw new org.apache.axis2.databinding.ADBException("smsFormat cannot be null!!");
			}

			localSmsFormat.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "smsFormat"), factory, xmlWriter);

			if (localReceiptRequestTracker) {
				if (localReceiptRequest == null) {
					throw new org.apache.axis2.databinding.ADBException("receiptRequest cannot be null!!");
				}

				localReceiptRequest.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest"), factory, xmlWriter);
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localAddresses != null) {
				for (int i = 0; i < localAddresses.length; i++) {
					if (localAddresses[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddresses[i]));
					} else {
						throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
					}
				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
			}

			if (localSenderNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "senderName"));

				if (localSenderName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSenderName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("senderName cannot be null!!");
				}
			}

			if (localChargingTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging"));

				if (localCharging == null) {
					throw new org.apache.axis2.databinding.ADBException("charging cannot be null!!");
				}

				elementList.add(localCharging);
			}

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "image"));

			elementList.add(localImage);

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "smsFormat"));

			if (localSmsFormat == null) {
				throw new org.apache.axis2.databinding.ADBException("smsFormat cannot be null!!");
			}

			elementList.add(localSmsFormat);

			if (localReceiptRequestTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest"));

				if (localReceiptRequest == null) {
					throw new org.apache.axis2.databinding.ADBException("receiptRequest cannot be null!!");
				}

				elementList.add(localReceiptRequest);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsLogo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsLogo object = new SendSmsLogo();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"sendSmsLogo".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SendSmsLogo) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses").equals(reader.getName())) {
						// Process the array and step past its final element's
						// end.
						list1.add(reader.getElementText());

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;

						while (!loopDone1) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}

							// Step out of this element
							reader.next();

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();

							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses").equals(reader.getName())) {
									list1.add(reader.getElementText());
								} else {
									loopDone1 = true;
								}
							}
						}

						// call the converter utility to convert and set the
						// array
						object.setAddresses((org.apache.axis2.databinding.types.URI[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(org.apache.axis2.databinding.types.URI.class, list1));
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "senderName").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSenderName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging").equals(reader.getName())) {
						object.setCharging(ChargingInformation.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "image").equals(reader.getName())) {
						reader.next();

						if (isReaderMTOMAware(reader) && java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_BINARY))) {
							// MTOM aware reader - get the datahandler directly
							// and put it in the object
							object.setImage((javax.activation.DataHandler) reader.getProperty(org.apache.axiom.om.OMConstants.DATA_HANDLER));
						} else {
							if ((reader.getEventType() == javax.xml.stream.XMLStreamConstants.START_ELEMENT) && reader.getName().equals(new javax.xml.namespace.QName(org.apache.axiom.om.impl.MTOMConstants.XOP_NAMESPACE_URI, org.apache.axiom.om.impl.MTOMConstants.XOP_INCLUDE))) {
								java.lang.String id = org.apache.axiom.om.util.ElementHelper.getContentID(reader, "UTF-8");
								object.setImage(((org.apache.axiom.soap.impl.builder.MTOMStAXSOAPModelBuilder) ((org.apache.axiom.om.impl.llom.OMStAXWrapper) reader).getBuilder()).getDataHandler(id));
								reader.next();

								reader.next();
							} else if (reader.hasText()) {
								// Do the usual conversion
								java.lang.String content = reader.getText();
								object.setImage(org.apache.axis2.databinding.utils.ConverterUtil.convertToBase64Binary(content));

								reader.next();
							}
						}

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "smsFormat").equals(reader.getName())) {
						object.setSmsFormat(SmsFormat.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest").equals(reader.getName())) {
						object.setReceiptRequest(SimpleReference.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class GetSmsDeliveryStatusResponse implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Result This was an Array!
		 */
		protected DeliveryInformation[] localResult;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localResultTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * getSmsDeliveryStatusResponse Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return DeliveryInformation[]
		 */
		public DeliveryInformation[] getResult() {
			return localResult;
		}

		/**
		 * validate the array for Result
		 */
		protected void validateResult(DeliveryInformation[] param) {
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Result
		 */
		public void setResult(DeliveryInformation[] param) {
			validateResult(param);

			if (param != null) {
				// update the setting tracker
				localResultTracker = true;
			} else {
				localResultTracker = false;
			}

			this.localResult = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            DeliveryInformation
		 */
		public void addResult(DeliveryInformation param) {
			if (localResult == null) {
				localResult = new DeliveryInformation[] {};
			}

			// update the setting tracker
			localResultTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localResult);
			list.add(param);
			this.localResult = (DeliveryInformation[]) list.toArray(new DeliveryInformation[list.size()]);
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					GetSmsDeliveryStatusResponse.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (localResultTracker) {
				if (localResult != null) {
					for (int i = 0; i < localResult.length; i++) {
						if (localResult[i] != null) {
							localResult[i].serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result"), factory, xmlWriter);
						} else {
							// we don't have to do any thing since minOccures is
							// zero
						}
					}
				} else {
					throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
				}
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localResultTracker) {
				if (localResult != null) {
					for (int i = 0; i < localResult.length; i++) {
						if (localResult[i] != null) {
							elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result"));
							elementList.add(localResult[i]);
						} else {
							// nothing to do
						}
					}
				} else {
					throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GetSmsDeliveryStatusResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetSmsDeliveryStatusResponse object = new GetSmsDeliveryStatusResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"getSmsDeliveryStatusResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (GetSmsDeliveryStatusResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result").equals(reader.getName())) {
						// Process the array and step past its final element's
						// end.
						list1.add(DeliveryInformation.Factory.parse(reader));

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;

						while (!loopDone1) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();

							// Step out of this element
							reader.next();

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();

							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result").equals(reader.getName())) {
									list1.add(DeliveryInformation.Factory.parse(reader));
								} else {
									loopDone1 = true;
								}
							}
						}

						// call the converter utility to convert and set the
						// array
						object.setResult((DeliveryInformation[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(DeliveryInformation.class, list1));
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsLogoResponse implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Result
		 */
		protected java.lang.String localResult;

		/*
		 * This type was generated from the piece of schema that had name =
		 * sendSmsLogoResponse Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getResult() {
			return localResult;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Result
		 */
		public void setResult(java.lang.String param) {
			this.localResult = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsLogoResponse.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "result", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "result");
				}
			} else {
				xmlWriter.writeStartElement("result");
			}

			if (localResult == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localResult);
			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result"));

			if (localResult != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResult));
			} else {
				throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsLogoResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsLogoResponse object = new SendSmsLogoResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"sendSmsLogoResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SendSmsLogoResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setResult(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class ServiceException implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for MessageId
		 */
		protected java.lang.String localMessageId;

		/**
		 * field for Text
		 */
		protected java.lang.String localText;

		/**
		 * field for Variables This was an Array!
		 */
		protected java.lang.String[] localVariables;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localVariablesTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * ServiceException Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1 Namespace
		 * Prefix = ns1
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getMessageId() {
			return localMessageId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            MessageId
		 */
		public void setMessageId(java.lang.String param) {
			this.localMessageId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getText() {
			return localText;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Text
		 */
		public void setText(java.lang.String param) {
			this.localText = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String[]
		 */
		public java.lang.String[] getVariables() {
			return localVariables;
		}

		/**
		 * validate the array for Variables
		 */
		protected void validateVariables(java.lang.String[] param) {
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Variables
		 */
		public void setVariables(java.lang.String[] param) {
			validateVariables(param);

			if (param != null) {
				// update the setting tracker
				localVariablesTracker = true;
			} else {
				localVariablesTracker = false;
			}

			this.localVariables = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            java.lang.String
		 */
		public void addVariables(java.lang.String param) {
			if (localVariables == null) {
				localVariables = new java.lang.String[] {};
			}

			// update the setting tracker
			localVariablesTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localVariables);
			list.add(param);
			this.localVariables = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					ServiceException.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "messageId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "messageId");
				}
			} else {
				xmlWriter.writeStartElement("messageId");
			}

			if (localMessageId == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("messageId cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localMessageId);
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "text", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "text");
				}
			} else {
				xmlWriter.writeStartElement("text");
			}

			if (localText == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("text cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localText);
			}

			xmlWriter.writeEndElement();

			if (localVariablesTracker) {
				if (localVariables != null) {
					namespace = "";

					boolean emptyNamespace = (namespace == null) || (namespace.length() == 0);
					prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);

					for (int i = 0; i < localVariables.length; i++) {
						if (localVariables[i] != null) {
							if (!emptyNamespace) {
								if (prefix == null) {
									java.lang.String prefix2 = generatePrefix(namespace);

									xmlWriter.writeStartElement(prefix2, "variables", namespace);
									xmlWriter.writeNamespace(prefix2, namespace);
									xmlWriter.setPrefix(prefix2, namespace);
								} else {
									xmlWriter.writeStartElement(namespace, "variables");
								}
							} else {
								xmlWriter.writeStartElement("variables");
							}

							xmlWriter.writeCharacters(localVariables[i]);

							xmlWriter.writeEndElement();
						} else {
							// we have to do nothing since minOccurs is zero
						}
					}
				} else {
					throw new org.apache.axis2.databinding.ADBException("variables cannot be null!!");
				}
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "messageId"));

			if (localMessageId != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessageId));
			} else {
				throw new org.apache.axis2.databinding.ADBException("messageId cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "text"));

			if (localText != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localText));
			} else {
				throw new org.apache.axis2.databinding.ADBException("text cannot be null!!");
			}

			if (localVariablesTracker) {
				if (localVariables != null) {
					for (int i = 0; i < localVariables.length; i++) {
						if (localVariables[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "variables"));
							elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVariables[i]));
						} else {
							// have to do nothing
						}
					}
				} else {
					throw new org.apache.axis2.databinding.ADBException("variables cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static ServiceException parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				ServiceException object = new ServiceException();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"ServiceException".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (ServiceException) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list3 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "messageId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setMessageId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "text").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setText(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "variables").equals(reader.getName())) {
						// Process the array and step past its final element's
						// end.
						list3.add(reader.getElementText());

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone3 = false;

						while (!loopDone3) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}

							// Step out of this element
							reader.next();

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();

							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone3 = true;
							} else {
								if (new javax.xml.namespace.QName("", "variables").equals(reader.getName())) {
									list3.add(reader.getElementText());
								} else {
									loopDone3 = true;
								}
							}
						}

						// call the converter utility to convert and set the
						// array
						object.setVariables((java.lang.String[]) list3.toArray(new java.lang.String[list3.size()]));
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSms7 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSms", "ns2");

		/**
		 * field for SendSms
		 */
		protected SendSms localSendSms;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SendSms
		 */
		public SendSms getSendSms() {
			return localSendSms;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SendSms
		 */
		public void setSendSms(SendSms param) {
			this.localSendSms = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSms7.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localSendSms == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localSendSms.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localSendSms.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSms7 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSms7 object = new SendSms7();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSms").equals(reader.getName())) {
								object.setSendSms(SendSms.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SimpleReference implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Endpoint
		 */
		protected org.apache.axis2.databinding.types.URI localEndpoint;

		/**
		 * field for InterfaceName
		 */
		protected java.lang.String localInterfaceName;

		/**
		 * field for Correlator
		 */
		protected java.lang.String localCorrelator;

		/*
		 * This type was generated from the piece of schema that had name =
		 * SimpleReference Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1 Namespace
		 * Prefix = ns1
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI
		 */
		public org.apache.axis2.databinding.types.URI getEndpoint() {
			return localEndpoint;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Endpoint
		 */
		public void setEndpoint(org.apache.axis2.databinding.types.URI param) {
			this.localEndpoint = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getInterfaceName() {
			return localInterfaceName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            InterfaceName
		 */
		public void setInterfaceName(java.lang.String param) {
			this.localInterfaceName = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCorrelator() {
			return localCorrelator;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Correlator
		 */
		public void setCorrelator(java.lang.String param) {
			this.localCorrelator = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SimpleReference.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "endpoint", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "endpoint");
				}
			} else {
				xmlWriter.writeStartElement("endpoint");
			}

			if (localEndpoint == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("endpoint cannot be null!!");
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndpoint));
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "interfaceName", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "interfaceName");
				}
			} else {
				xmlWriter.writeStartElement("interfaceName");
			}

			if (localInterfaceName == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("interfaceName cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localInterfaceName);
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "correlator", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "correlator");
				}
			} else {
				xmlWriter.writeStartElement("correlator");
			}

			if (localCorrelator == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("correlator cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localCorrelator);
			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "endpoint"));

			if (localEndpoint != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndpoint));
			} else {
				throw new org.apache.axis2.databinding.ADBException("endpoint cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "interfaceName"));

			if (localInterfaceName != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInterfaceName));
			} else {
				throw new org.apache.axis2.databinding.ADBException("interfaceName cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "correlator"));

			if (localCorrelator != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCorrelator));
			} else {
				throw new org.apache.axis2.databinding.ADBException("correlator cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SimpleReference parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SimpleReference object = new SimpleReference();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"SimpleReference".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SimpleReference) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "endpoint").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setEndpoint(org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "interfaceName").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setInterfaceName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "correlator").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setCorrelator(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class GetSmsDeliveryStatus implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for RequestIdentifier
		 */
		protected java.lang.String localRequestIdentifier;

		/*
		 * This type was generated from the piece of schema that had name =
		 * getSmsDeliveryStatus Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getRequestIdentifier() {
			return localRequestIdentifier;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            RequestIdentifier
		 */
		public void setRequestIdentifier(java.lang.String param) {
			this.localRequestIdentifier = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					GetSmsDeliveryStatus.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "requestIdentifier", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "requestIdentifier");
				}
			} else {
				xmlWriter.writeStartElement("requestIdentifier");
			}

			if (localRequestIdentifier == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("requestIdentifier cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localRequestIdentifier);
			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "requestIdentifier"));

			if (localRequestIdentifier != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRequestIdentifier));
			} else {
				throw new org.apache.axis2.databinding.ADBException("requestIdentifier cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GetSmsDeliveryStatus parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetSmsDeliveryStatus object = new GetSmsDeliveryStatus();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"getSmsDeliveryStatus".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (GetSmsDeliveryStatus) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "requestIdentifier").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setRequestIdentifier(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsResponse4 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsResponse", "ns2");

		/**
		 * field for SendSmsResponse
		 */
		protected SendSmsResponse localSendSmsResponse;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SendSmsResponse
		 */
		public SendSmsResponse getSendSmsResponse() {
			return localSendSmsResponse;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SendSmsResponse
		 */
		public void setSendSmsResponse(SendSmsResponse param) {
			this.localSendSmsResponse = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsResponse4.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localSendSmsResponse == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localSendSmsResponse.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localSendSmsResponse.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsResponse4 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsResponse4 object = new SendSmsResponse4();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsResponse").equals(reader.getName())) {
								object.setSendSmsResponse(SendSmsResponse.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class EndReason implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "EndReason", "ns1");
		private static java.util.HashMap _table_ = new java.util.HashMap();
		public static final java.lang.String _value1 = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("0");
		public static final java.lang.String _value2 = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("-1");
		public static final java.lang.String _value3 = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("1");
		public static final java.lang.String _value4 = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("2");
		public static final EndReason value1 = new EndReason(_value1, true);
		public static final EndReason value2 = new EndReason(_value2, true);
		public static final EndReason value3 = new EndReason(_value3, true);
		public static final EndReason value4 = new EndReason(_value4, true);

		/**
		 * field for EndReason
		 */
		protected java.lang.String localEndReason;

		// Constructor
		protected EndReason(java.lang.String value, boolean isRegisterValue) {
			localEndReason = value;

			if (isRegisterValue) {
				_table_.put(localEndReason, this);
			}
		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		public java.lang.String getValue() {
			return localEndReason;
		}

		public boolean equals(java.lang.Object obj) {
			return (obj == this);
		}

		public int hashCode() {
			return toString().hashCode();
		}

		public java.lang.String toString() {
			return localEndReason.toString();
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					EndReason.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String localName = parentQName.getLocalPart();

			if (!namespace.equals("")) {
				java.lang.String prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, localName, namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, localName);
				}
			} else {
				xmlWriter.writeStartElement(localName);
			}

			if (localEndReason == null) {
				throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
			} else {
				xmlWriter.writeCharacters(localEndReason);
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME, new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT, org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndReason) }, null);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			public static EndReason fromValue(java.lang.String value) throws java.lang.IllegalArgumentException {
				EndReason enumeration = (EndReason) _table_.get(value);

				if (enumeration == null) {
					throw new java.lang.IllegalArgumentException();
				}

				return enumeration;
			}

			public static EndReason fromString(java.lang.String value, java.lang.String namespaceURI) throws java.lang.IllegalArgumentException {
				try {
					return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
				} catch (java.lang.Exception e) {
					throw new java.lang.IllegalArgumentException();
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static EndReason parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				EndReason object = null;

				// initialize a hash map to keep values
				java.util.Map attributeMap = new java.util.HashMap();
				java.util.List extraAttributeList = new java.util.ArrayList();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {
							java.lang.String content = reader.getElementText();

							if (content.indexOf(":") > 0) {
								// this seems to be a Qname so find the
								// namespace and send
								prefix = content.substring(0, content.indexOf(":"));
								namespaceuri = reader.getNamespaceURI(prefix);
								object = EndReason.Factory.fromString(content, namespaceuri);
							} else {
								// this seems to be not a qname send and empty
								// namespace incase of it is
								// check is done in fromString method
								object = EndReason.Factory.fromString(content, "");
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class ExtensionMapper {
		public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName, javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "sendSmsResponse".equals(typeName)) {
				return SendSmsResponse.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "RequestSOAPHeader".equals(typeName)) {
				return RequestSOAPHeader.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "getSmsDeliveryStatus".equals(typeName)) {
				return GetSmsDeliveryStatus.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1".equals(namespaceURI) && "DeliveryStatus".equals(typeName)) {
				return DeliveryStatus.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "sendSms".equals(typeName)) {
				return SendSms.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "ServiceException".equals(typeName)) {
				return ServiceException.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "sendSmsLogo".equals(typeName)) {
				return SendSmsLogo.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "SimpleReference".equals(typeName)) {
				return SimpleReference.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "sendSmsRingtoneResponse".equals(typeName)) {
				return SendSmsRingtoneResponse.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "EndReason".equals(typeName)) {
				return EndReason.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1".equals(namespaceURI) && "SmsFormat".equals(typeName)) {
				return SmsFormat.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "NotifySOAPHeader".equals(typeName)) {
				return NotifySOAPHeader.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "ChargingInformation".equals(typeName)) {
				return ChargingInformation.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "getSmsDeliveryStatusResponse".equals(typeName)) {
				return GetSmsDeliveryStatusResponse.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1".equals(namespaceURI) && "DeliveryInformation".equals(typeName)) {
				return DeliveryInformation.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "sendSmsLogoResponse".equals(typeName)) {
				return SendSmsLogoResponse.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1".equals(namespaceURI) && "PolicyException".equals(typeName)) {
				return PolicyException.Factory.parse(reader);
			}

			if ("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local".equals(namespaceURI) && "sendSmsRingtone".equals(typeName)) {
				return SendSmsRingtone.Factory.parse(reader);
			}

			throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
		}
	}

	public static class ChargingInformation implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Description
		 */
		protected java.lang.String localDescription;

		/**
		 * field for Currency
		 */
		protected java.lang.String localCurrency;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCurrencyTracker = false;

		/**
		 * field for Amount
		 */
		protected java.math.BigDecimal localAmount;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localAmountTracker = false;

		/**
		 * field for Code
		 */
		protected java.lang.String localCode;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localCodeTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * ChargingInformation Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1 Namespace
		 * Prefix = ns1
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getDescription() {
			return localDescription;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Description
		 */
		public void setDescription(java.lang.String param) {
			this.localDescription = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCurrency() {
			return localCurrency;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Currency
		 */
		public void setCurrency(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localCurrencyTracker = true;
			} else {
				localCurrencyTracker = false;
			}

			this.localCurrency = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.math.BigDecimal
		 */
		public java.math.BigDecimal getAmount() {
			return localAmount;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Amount
		 */
		public void setAmount(java.math.BigDecimal param) {
			if (param != null) {
				// update the setting tracker
				localAmountTracker = true;
			} else {
				localAmountTracker = false;
			}

			this.localAmount = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getCode() {
			return localCode;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Code
		 */
		public void setCode(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localCodeTracker = true;
			} else {
				localCodeTracker = false;
			}

			this.localCode = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					ChargingInformation.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "description", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "description");
				}
			} else {
				xmlWriter.writeStartElement("description");
			}

			if (localDescription == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("description cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localDescription);
			}

			xmlWriter.writeEndElement();

			if (localCurrencyTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "currency", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "currency");
					}
				} else {
					xmlWriter.writeStartElement("currency");
				}

				if (localCurrency == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("currency cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localCurrency);
				}

				xmlWriter.writeEndElement();
			}

			if (localAmountTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "amount", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "amount");
					}
				} else {
					xmlWriter.writeStartElement("amount");
				}

				if (localAmount == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("amount cannot be null!!");
				} else {
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAmount));
				}

				xmlWriter.writeEndElement();
			}

			if (localCodeTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "code", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "code");
					}
				} else {
					xmlWriter.writeStartElement("code");
				}

				if (localCode == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("code cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localCode);
				}

				xmlWriter.writeEndElement();
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "description"));

			if (localDescription != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
			} else {
				throw new org.apache.axis2.databinding.ADBException("description cannot be null!!");
			}

			if (localCurrencyTracker) {
				elementList.add(new javax.xml.namespace.QName("", "currency"));

				if (localCurrency != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCurrency));
				} else {
					throw new org.apache.axis2.databinding.ADBException("currency cannot be null!!");
				}
			}

			if (localAmountTracker) {
				elementList.add(new javax.xml.namespace.QName("", "amount"));

				if (localAmount != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAmount));
				} else {
					throw new org.apache.axis2.databinding.ADBException("amount cannot be null!!");
				}
			}

			if (localCodeTracker) {
				elementList.add(new javax.xml.namespace.QName("", "code"));

				if (localCode != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCode));
				} else {
					throw new org.apache.axis2.databinding.ADBException("code cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static ChargingInformation parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				ChargingInformation object = new ChargingInformation();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"ChargingInformation".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (ChargingInformation) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "description").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setDescription(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "currency").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setCurrency(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "amount").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setAmount(org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "code").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setCode(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class PolicyException3 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException", "ns1");

		/**
		 * field for PolicyException
		 */
		protected PolicyException localPolicyException;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return PolicyException
		 */
		public PolicyException getPolicyException() {
			return localPolicyException;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            PolicyException
		 */
		public void setPolicyException(PolicyException param) {
			this.localPolicyException = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					PolicyException3.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localPolicyException == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localPolicyException.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localPolicyException.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static PolicyException3 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				PolicyException3 object = new PolicyException3();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException").equals(reader.getName())) {
								object.setPolicyException(PolicyException.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class NotifySOAPHeader implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for SpRevId
		 */
		protected java.lang.String localSpRevId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSpRevIdTracker = false;

		/**
		 * field for SpRevpassword
		 */
		protected java.lang.String localSpRevpassword;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSpRevpasswordTracker = false;

		/**
		 * field for SpId
		 */
		protected java.lang.String localSpId;

		/**
		 * field for SAN
		 */
		protected java.lang.String localSAN;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSANTracker = false;

		/**
		 * field for TransactionId
		 */
		protected java.lang.String localTransactionId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localTransactionIdTracker = false;

		/**
		 * field for LinkId
		 */
		protected java.lang.String localLinkId;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localLinkIdTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * NotifySOAPHeader Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1 Namespace
		 * Prefix = ns1
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSpRevId() {
			return localSpRevId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SpRevId
		 */
		public void setSpRevId(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSpRevIdTracker = true;
			} else {
				localSpRevIdTracker = false;
			}

			this.localSpRevId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSpRevpassword() {
			return localSpRevpassword;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SpRevpassword
		 */
		public void setSpRevpassword(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSpRevpasswordTracker = true;
			} else {
				localSpRevpasswordTracker = false;
			}

			this.localSpRevpassword = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSpId() {
			return localSpId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SpId
		 */
		public void setSpId(java.lang.String param) {
			this.localSpId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSAN() {
			return localSAN;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SAN
		 */
		public void setSAN(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSANTracker = true;
			} else {
				localSANTracker = false;
			}

			this.localSAN = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getTransactionId() {
			return localTransactionId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            TransactionId
		 */
		public void setTransactionId(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localTransactionIdTracker = true;
			} else {
				localTransactionIdTracker = false;
			}

			this.localTransactionId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getLinkId() {
			return localLinkId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            LinkId
		 */
		public void setLinkId(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localLinkIdTracker = true;
			} else {
				localLinkIdTracker = false;
			}

			this.localLinkId = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					NotifySOAPHeader.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (localSpRevIdTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "spRevId", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "spRevId");
					}
				} else {
					xmlWriter.writeStartElement("spRevId");
				}

				if (localSpRevId == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("spRevId cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSpRevId);
				}

				xmlWriter.writeEndElement();
			}

			if (localSpRevpasswordTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "spRevpassword", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "spRevpassword");
					}
				} else {
					xmlWriter.writeStartElement("spRevpassword");
				}

				if (localSpRevpassword == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("spRevpassword cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSpRevpassword);
				}

				xmlWriter.writeEndElement();
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "spId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "spId");
				}
			} else {
				xmlWriter.writeStartElement("spId");
			}

			if (localSpId == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("spId cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localSpId);
			}

			xmlWriter.writeEndElement();

			if (localSANTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "SAN", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "SAN");
					}
				} else {
					xmlWriter.writeStartElement("SAN");
				}

				if (localSAN == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("SAN cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSAN);
				}

				xmlWriter.writeEndElement();
			}

			if (localTransactionIdTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "transactionId", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "transactionId");
					}
				} else {
					xmlWriter.writeStartElement("transactionId");
				}

				if (localTransactionId == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("transactionId cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localTransactionId);
				}

				xmlWriter.writeEndElement();
			}

			if (localLinkIdTracker) {
				namespace = "";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "linkId", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "linkId");
					}
				} else {
					xmlWriter.writeStartElement("linkId");
				}

				if (localLinkId == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("linkId cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localLinkId);
				}

				xmlWriter.writeEndElement();
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localSpRevIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "spRevId"));

				if (localSpRevId != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpRevId));
				} else {
					throw new org.apache.axis2.databinding.ADBException("spRevId cannot be null!!");
				}
			}

			if (localSpRevpasswordTracker) {
				elementList.add(new javax.xml.namespace.QName("", "spRevpassword"));

				if (localSpRevpassword != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpRevpassword));
				} else {
					throw new org.apache.axis2.databinding.ADBException("spRevpassword cannot be null!!");
				}
			}

			elementList.add(new javax.xml.namespace.QName("", "spId"));

			if (localSpId != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSpId));
			} else {
				throw new org.apache.axis2.databinding.ADBException("spId cannot be null!!");
			}

			if (localSANTracker) {
				elementList.add(new javax.xml.namespace.QName("", "SAN"));

				if (localSAN != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSAN));
				} else {
					throw new org.apache.axis2.databinding.ADBException("SAN cannot be null!!");
				}
			}

			if (localTransactionIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "transactionId"));

				if (localTransactionId != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTransactionId));
				} else {
					throw new org.apache.axis2.databinding.ADBException("transactionId cannot be null!!");
				}
			}

			if (localLinkIdTracker) {
				elementList.add(new javax.xml.namespace.QName("", "linkId"));

				if (localLinkId != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLinkId));
				} else {
					throw new org.apache.axis2.databinding.ADBException("linkId cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static NotifySOAPHeader parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				NotifySOAPHeader object = new NotifySOAPHeader();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"NotifySOAPHeader".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (NotifySOAPHeader) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "spRevId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSpRevId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "spRevpassword").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSpRevpassword(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "spId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSpId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "SAN").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSAN(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "transactionId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setTransactionId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "linkId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setLinkId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSms implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Addresses This was an Array!
		 */
		protected org.apache.axis2.databinding.types.URI[] localAddresses;

		/**
		 * field for SenderName
		 */
		protected java.lang.String localSenderName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSenderNameTracker = false;

		/**
		 * field for Charging
		 */
		protected ChargingInformation localCharging;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localChargingTracker = false;

		/**
		 * field for Message
		 */
		protected java.lang.String localMessage;

		/**
		 * field for ReceiptRequest
		 */
		protected SimpleReference localReceiptRequest;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceiptRequestTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * sendSms Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI[]
		 */
		public org.apache.axis2.databinding.types.URI[] getAddresses() {
			return localAddresses;
		}

		/**
		 * validate the array for Addresses
		 */
		protected void validateAddresses(org.apache.axis2.databinding.types.URI[] param) {
			if ((param != null) && (param.length < 1)) {
				throw new java.lang.RuntimeException();
			}
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Addresses
		 */
		public void setAddresses(org.apache.axis2.databinding.types.URI[] param) {
			validateAddresses(param);

			this.localAddresses = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            org.apache.axis2.databinding.types.URI
		 */
		public void addAddresses(org.apache.axis2.databinding.types.URI param) {
			if (localAddresses == null) {
				localAddresses = new org.apache.axis2.databinding.types.URI[] {};
			}

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localAddresses);
			list.add(param);
			this.localAddresses = (org.apache.axis2.databinding.types.URI[]) list.toArray(new org.apache.axis2.databinding.types.URI[list.size()]);
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSenderName() {
			return localSenderName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SenderName
		 */
		public void setSenderName(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSenderNameTracker = true;
			} else {
				localSenderNameTracker = false;
			}

			this.localSenderName = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return ChargingInformation
		 */
		public ChargingInformation getCharging() {
			return localCharging;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Charging
		 */
		public void setCharging(ChargingInformation param) {
			if (param != null) {
				// update the setting tracker
				localChargingTracker = true;
			} else {
				localChargingTracker = false;
			}

			this.localCharging = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getMessage() {
			return localMessage;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Message
		 */
		public void setMessage(java.lang.String param) {
			this.localMessage = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SimpleReference
		 */
		public SimpleReference getReceiptRequest() {
			return localReceiptRequest;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceiptRequest
		 */
		public void setReceiptRequest(SimpleReference param) {
			if (param != null) {
				// update the setting tracker
				localReceiptRequestTracker = true;
			} else {
				localReceiptRequestTracker = false;
			}

			this.localReceiptRequest = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSms.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (localAddresses != null) {
				namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

				boolean emptyNamespace = (namespace == null) || (namespace.length() == 0);
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);

				for (int i = 0; i < localAddresses.length; i++) {
					if (localAddresses[i] != null) {
						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "addresses", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);
							} else {
								xmlWriter.writeStartElement(namespace, "addresses");
							}
						} else {
							xmlWriter.writeStartElement("addresses");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddresses[i]));

						xmlWriter.writeEndElement();
					} else {
						throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
					}
				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
			}

			if (localSenderNameTracker) {
				namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "senderName", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "senderName");
					}
				} else {
					xmlWriter.writeStartElement("senderName");
				}

				if (localSenderName == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("senderName cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSenderName);
				}

				xmlWriter.writeEndElement();
			}

			if (localChargingTracker) {
				if (localCharging == null) {
					throw new org.apache.axis2.databinding.ADBException("charging cannot be null!!");
				}

				localCharging.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging"), factory, xmlWriter);
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "message", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "message");
				}
			} else {
				xmlWriter.writeStartElement("message");
			}

			if (localMessage == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("message cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localMessage);
			}

			xmlWriter.writeEndElement();

			if (localReceiptRequestTracker) {
				if (localReceiptRequest == null) {
					throw new org.apache.axis2.databinding.ADBException("receiptRequest cannot be null!!");
				}

				localReceiptRequest.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest"), factory, xmlWriter);
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localAddresses != null) {
				for (int i = 0; i < localAddresses.length; i++) {
					if (localAddresses[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddresses[i]));
					} else {
						throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
					}
				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
			}

			if (localSenderNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "senderName"));

				if (localSenderName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSenderName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("senderName cannot be null!!");
				}
			}

			if (localChargingTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging"));

				if (localCharging == null) {
					throw new org.apache.axis2.databinding.ADBException("charging cannot be null!!");
				}

				elementList.add(localCharging);
			}

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "message"));

			if (localMessage != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessage));
			} else {
				throw new org.apache.axis2.databinding.ADBException("message cannot be null!!");
			}

			if (localReceiptRequestTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest"));

				if (localReceiptRequest == null) {
					throw new org.apache.axis2.databinding.ADBException("receiptRequest cannot be null!!");
				}

				elementList.add(localReceiptRequest);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSms parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSms object = new SendSms();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"sendSms".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SendSms) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses").equals(reader.getName())) {
						// Process the array and step past its final element's
						// end.
						list1.add(reader.getElementText());

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;

						while (!loopDone1) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}

							// Step out of this element
							reader.next();

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();

							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses").equals(reader.getName())) {
									list1.add(reader.getElementText());
								} else {
									loopDone1 = true;
								}
							}
						}

						// call the converter utility to convert and set the
						// array
						object.setAddresses((org.apache.axis2.databinding.types.URI[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(org.apache.axis2.databinding.types.URI.class, list1));
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "senderName").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSenderName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging").equals(reader.getName())) {
						object.setCharging(ChargingInformation.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "message").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setMessage(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest").equals(reader.getName())) {
						object.setReceiptRequest(SimpleReference.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsRingtone implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Addresses This was an Array!
		 */
		protected org.apache.axis2.databinding.types.URI[] localAddresses;

		/**
		 * field for SenderName
		 */
		protected java.lang.String localSenderName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localSenderNameTracker = false;

		/**
		 * field for Charging
		 */
		protected ChargingInformation localCharging;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localChargingTracker = false;

		/**
		 * field for Ringtone
		 */
		protected java.lang.String localRingtone;

		/**
		 * field for SmsFormat
		 */
		protected SmsFormat localSmsFormat;

		/**
		 * field for ReceiptRequest
		 */
		protected SimpleReference localReceiptRequest;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localReceiptRequestTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * sendSmsRingtone Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI[]
		 */
		public org.apache.axis2.databinding.types.URI[] getAddresses() {
			return localAddresses;
		}

		/**
		 * validate the array for Addresses
		 */
		protected void validateAddresses(org.apache.axis2.databinding.types.URI[] param) {
			if ((param != null) && (param.length < 1)) {
				throw new java.lang.RuntimeException();
			}
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Addresses
		 */
		public void setAddresses(org.apache.axis2.databinding.types.URI[] param) {
			validateAddresses(param);

			this.localAddresses = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            org.apache.axis2.databinding.types.URI
		 */
		public void addAddresses(org.apache.axis2.databinding.types.URI param) {
			if (localAddresses == null) {
				localAddresses = new org.apache.axis2.databinding.types.URI[] {};
			}

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localAddresses);
			list.add(param);
			this.localAddresses = (org.apache.axis2.databinding.types.URI[]) list.toArray(new org.apache.axis2.databinding.types.URI[list.size()]);
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSenderName() {
			return localSenderName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SenderName
		 */
		public void setSenderName(java.lang.String param) {
			if (param != null) {
				// update the setting tracker
				localSenderNameTracker = true;
			} else {
				localSenderNameTracker = false;
			}

			this.localSenderName = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return ChargingInformation
		 */
		public ChargingInformation getCharging() {
			return localCharging;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Charging
		 */
		public void setCharging(ChargingInformation param) {
			if (param != null) {
				// update the setting tracker
				localChargingTracker = true;
			} else {
				localChargingTracker = false;
			}

			this.localCharging = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getRingtone() {
			return localRingtone;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Ringtone
		 */
		public void setRingtone(java.lang.String param) {
			this.localRingtone = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SmsFormat
		 */
		public SmsFormat getSmsFormat() {
			return localSmsFormat;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SmsFormat
		 */
		public void setSmsFormat(SmsFormat param) {
			this.localSmsFormat = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SimpleReference
		 */
		public SimpleReference getReceiptRequest() {
			return localReceiptRequest;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ReceiptRequest
		 */
		public void setReceiptRequest(SimpleReference param) {
			if (param != null) {
				// update the setting tracker
				localReceiptRequestTracker = true;
			} else {
				localReceiptRequestTracker = false;
			}

			this.localReceiptRequest = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsRingtone.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			if (localAddresses != null) {
				namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

				boolean emptyNamespace = (namespace == null) || (namespace.length() == 0);
				prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);

				for (int i = 0; i < localAddresses.length; i++) {
					if (localAddresses[i] != null) {
						if (!emptyNamespace) {
							if (prefix == null) {
								java.lang.String prefix2 = generatePrefix(namespace);

								xmlWriter.writeStartElement(prefix2, "addresses", namespace);
								xmlWriter.writeNamespace(prefix2, namespace);
								xmlWriter.setPrefix(prefix2, namespace);
							} else {
								xmlWriter.writeStartElement(namespace, "addresses");
							}
						} else {
							xmlWriter.writeStartElement("addresses");
						}

						xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddresses[i]));

						xmlWriter.writeEndElement();
					} else {
						throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
					}
				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
			}

			if (localSenderNameTracker) {
				namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

				if (!namespace.equals("")) {
					prefix = xmlWriter.getPrefix(namespace);

					if (prefix == null) {
						prefix = generatePrefix(namespace);

						xmlWriter.writeStartElement(prefix, "senderName", namespace);
						xmlWriter.writeNamespace(prefix, namespace);
						xmlWriter.setPrefix(prefix, namespace);
					} else {
						xmlWriter.writeStartElement(namespace, "senderName");
					}
				} else {
					xmlWriter.writeStartElement("senderName");
				}

				if (localSenderName == null) {
					// write the nil attribute
					throw new org.apache.axis2.databinding.ADBException("senderName cannot be null!!");
				} else {
					xmlWriter.writeCharacters(localSenderName);
				}

				xmlWriter.writeEndElement();
			}

			if (localChargingTracker) {
				if (localCharging == null) {
					throw new org.apache.axis2.databinding.ADBException("charging cannot be null!!");
				}

				localCharging.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging"), factory, xmlWriter);
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "ringtone", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "ringtone");
				}
			} else {
				xmlWriter.writeStartElement("ringtone");
			}

			if (localRingtone == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("ringtone cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localRingtone);
			}

			xmlWriter.writeEndElement();

			if (localSmsFormat == null) {
				throw new org.apache.axis2.databinding.ADBException("smsFormat cannot be null!!");
			}

			localSmsFormat.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "smsFormat"), factory, xmlWriter);

			if (localReceiptRequestTracker) {
				if (localReceiptRequest == null) {
					throw new org.apache.axis2.databinding.ADBException("receiptRequest cannot be null!!");
				}

				localReceiptRequest.serialize(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest"), factory, xmlWriter);
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localAddresses != null) {
				for (int i = 0; i < localAddresses.length; i++) {
					if (localAddresses[i] != null) {
						elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses"));
						elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddresses[i]));
					} else {
						throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
					}
				}
			} else {
				throw new org.apache.axis2.databinding.ADBException("addresses cannot be null!!");
			}

			if (localSenderNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "senderName"));

				if (localSenderName != null) {
					elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSenderName));
				} else {
					throw new org.apache.axis2.databinding.ADBException("senderName cannot be null!!");
				}
			}

			if (localChargingTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging"));

				if (localCharging == null) {
					throw new org.apache.axis2.databinding.ADBException("charging cannot be null!!");
				}

				elementList.add(localCharging);
			}

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "ringtone"));

			if (localRingtone != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRingtone));
			} else {
				throw new org.apache.axis2.databinding.ADBException("ringtone cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "smsFormat"));

			if (localSmsFormat == null) {
				throw new org.apache.axis2.databinding.ADBException("smsFormat cannot be null!!");
			}

			elementList.add(localSmsFormat);

			if (localReceiptRequestTracker) {
				elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest"));

				if (localReceiptRequest == null) {
					throw new org.apache.axis2.databinding.ADBException("receiptRequest cannot be null!!");
				}

				elementList.add(localReceiptRequest);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsRingtone parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsRingtone object = new SendSmsRingtone();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"sendSmsRingtone".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SendSmsRingtone) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses").equals(reader.getName())) {
						// Process the array and step past its final element's
						// end.
						list1.add(reader.getElementText());

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;

						while (!loopDone1) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}

							// Step out of this element
							reader.next();

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();

							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "addresses").equals(reader.getName())) {
									list1.add(reader.getElementText());
								} else {
									loopDone1 = true;
								}
							}
						}

						// call the converter utility to convert and set the
						// array
						object.setAddresses((org.apache.axis2.databinding.types.URI[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(org.apache.axis2.databinding.types.URI.class, list1));
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "senderName").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setSenderName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "charging").equals(reader.getName())) {
						object.setCharging(ChargingInformation.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "ringtone").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setRingtone(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "smsFormat").equals(reader.getName())) {
						object.setSmsFormat(SmsFormat.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "receiptRequest").equals(reader.getName())) {
						object.setReceiptRequest(SimpleReference.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class PolicyException implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for MessageId
		 */
		protected java.lang.String localMessageId;

		/**
		 * field for Text
		 */
		protected java.lang.String localText;

		/**
		 * field for Variables This was an Array!
		 */
		protected java.lang.String[] localVariables;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method for this attribute. It will be used to determine
		 * whether to include this field in the serialized XML
		 */
		protected boolean localVariablesTracker = false;

		/*
		 * This type was generated from the piece of schema that had name =
		 * PolicyException Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1 Namespace
		 * Prefix = ns1
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getMessageId() {
			return localMessageId;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            MessageId
		 */
		public void setMessageId(java.lang.String param) {
			this.localMessageId = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getText() {
			return localText;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Text
		 */
		public void setText(java.lang.String param) {
			this.localText = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String[]
		 */
		public java.lang.String[] getVariables() {
			return localVariables;
		}

		/**
		 * validate the array for Variables
		 */
		protected void validateVariables(java.lang.String[] param) {
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Variables
		 */
		public void setVariables(java.lang.String[] param) {
			validateVariables(param);

			if (param != null) {
				// update the setting tracker
				localVariablesTracker = true;
			} else {
				localVariablesTracker = false;
			}

			this.localVariables = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            java.lang.String
		 */
		public void addVariables(java.lang.String param) {
			if (localVariables == null) {
				localVariables = new java.lang.String[] {};
			}

			// update the setting tracker
			localVariablesTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localVariables);
			list.add(param);
			this.localVariables = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					PolicyException.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "messageId", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "messageId");
				}
			} else {
				xmlWriter.writeStartElement("messageId");
			}

			if (localMessageId == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("messageId cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localMessageId);
			}

			xmlWriter.writeEndElement();

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "text", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "text");
				}
			} else {
				xmlWriter.writeStartElement("text");
			}

			if (localText == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("text cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localText);
			}

			xmlWriter.writeEndElement();

			if (localVariablesTracker) {
				if (localVariables != null) {
					namespace = "";

					boolean emptyNamespace = (namespace == null) || (namespace.length() == 0);
					prefix = emptyNamespace ? null : xmlWriter.getPrefix(namespace);

					for (int i = 0; i < localVariables.length; i++) {
						if (localVariables[i] != null) {
							if (!emptyNamespace) {
								if (prefix == null) {
									java.lang.String prefix2 = generatePrefix(namespace);

									xmlWriter.writeStartElement(prefix2, "variables", namespace);
									xmlWriter.writeNamespace(prefix2, namespace);
									xmlWriter.setPrefix(prefix2, namespace);
								} else {
									xmlWriter.writeStartElement(namespace, "variables");
								}
							} else {
								xmlWriter.writeStartElement("variables");
							}

							xmlWriter.writeCharacters(localVariables[i]);

							xmlWriter.writeEndElement();
						} else {
							// we have to do nothing since minOccurs is zero
						}
					}
				} else {
					throw new org.apache.axis2.databinding.ADBException("variables cannot be null!!");
				}
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "messageId"));

			if (localMessageId != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessageId));
			} else {
				throw new org.apache.axis2.databinding.ADBException("messageId cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "text"));

			if (localText != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localText));
			} else {
				throw new org.apache.axis2.databinding.ADBException("text cannot be null!!");
			}

			if (localVariablesTracker) {
				if (localVariables != null) {
					for (int i = 0; i < localVariables.length; i++) {
						if (localVariables[i] != null) {
							elementList.add(new javax.xml.namespace.QName("", "variables"));
							elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVariables[i]));
						} else {
							// have to do nothing
						}
					}
				} else {
					throw new org.apache.axis2.databinding.ADBException("variables cannot be null!!");
				}
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static PolicyException parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				PolicyException object = new PolicyException();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"PolicyException".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (PolicyException) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list3 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "messageId").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setMessageId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "text").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setText(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "variables").equals(reader.getName())) {
						// Process the array and step past its final element's
						// end.
						list3.add(reader.getElementText());

						// loop until we find a start element that is not part
						// of this array
						boolean loopDone3 = false;

						while (!loopDone3) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}

							// Step out of this element
							reader.next();

							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();

							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone3 = true;
							} else {
								if (new javax.xml.namespace.QName("", "variables").equals(reader.getName())) {
									list3.add(reader.getElementText());
								} else {
									loopDone3 = true;
								}
							}
						}

						// call the converter utility to convert and set the
						// array
						object.setVariables((java.lang.String[]) list3.toArray(new java.lang.String[list3.size()]));
					} // End of if for expected property start element

					else {
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class RequestSOAPHeader0 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "RequestSOAPHeader", "ns1");

		/**
		 * field for RequestSOAPHeader
		 */
		protected RequestSOAPHeader localRequestSOAPHeader;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return RequestSOAPHeader
		 */
		public RequestSOAPHeader getRequestSOAPHeader() {
			return localRequestSOAPHeader;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            RequestSOAPHeader
		 */
		public void setRequestSOAPHeader(RequestSOAPHeader param) {
			this.localRequestSOAPHeader = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					RequestSOAPHeader0.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localRequestSOAPHeader == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localRequestSOAPHeader.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localRequestSOAPHeader.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static RequestSOAPHeader0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				RequestSOAPHeader0 object = new RequestSOAPHeader0();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "RequestSOAPHeader").equals(reader.getName())) {
								object.setRequestSOAPHeader(RequestSOAPHeader.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsLogoResponse9 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsLogoResponse", "ns2");

		/**
		 * field for SendSmsLogoResponse
		 */
		protected SendSmsLogoResponse localSendSmsLogoResponse;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SendSmsLogoResponse
		 */
		public SendSmsLogoResponse getSendSmsLogoResponse() {
			return localSendSmsLogoResponse;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SendSmsLogoResponse
		 */
		public void setSendSmsLogoResponse(SendSmsLogoResponse param) {
			this.localSendSmsLogoResponse = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsLogoResponse9.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localSendSmsLogoResponse == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localSendSmsLogoResponse.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localSendSmsLogoResponse.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsLogoResponse9 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsLogoResponse9 object = new SendSmsLogoResponse9();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsLogoResponse").equals(reader.getName())) {
								object.setSendSmsLogoResponse(SendSmsLogoResponse.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsResponse implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Result
		 */
		protected java.lang.String localResult;

		/*
		 * This type was generated from the piece of schema that had name =
		 * sendSmsResponse Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local
		 * Namespace Prefix = ns2
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getResult() {
			return localResult;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Result
		 */
		public void setResult(java.lang.String param) {
			this.localResult = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsResponse.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "result", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "result");
				}
			} else {
				xmlWriter.writeStartElement("result");
			}

			if (localResult == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
			} else {
				xmlWriter.writeCharacters(localResult);
			}

			xmlWriter.writeEndElement();

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result"));

			if (localResult != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResult));
			} else {
				throw new org.apache.axis2.databinding.ADBException("result cannot be null!!");
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsResponse object = new SendSmsResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"sendSmsResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (SendSmsResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "result").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setResult(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsRingtone10 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsRingtone", "ns2");

		/**
		 * field for SendSmsRingtone
		 */
		protected SendSmsRingtone localSendSmsRingtone;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SendSmsRingtone
		 */
		public SendSmsRingtone getSendSmsRingtone() {
			return localSendSmsRingtone;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SendSmsRingtone
		 */
		public void setSendSmsRingtone(SendSmsRingtone param) {
			this.localSendSmsRingtone = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsRingtone10.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localSendSmsRingtone == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localSendSmsRingtone.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localSendSmsRingtone.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsRingtone10 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsRingtone10 object = new SendSmsRingtone10();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsRingtone").equals(reader.getName())) {
								object.setSendSmsRingtone(SendSmsRingtone.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class ServiceException2 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException", "ns1");

		/**
		 * field for ServiceException
		 */
		protected ServiceException localServiceException;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return ServiceException
		 */
		public ServiceException getServiceException() {
			return localServiceException;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ServiceException
		 */
		public void setServiceException(ServiceException param) {
			this.localServiceException = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					ServiceException2.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localServiceException == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localServiceException.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localServiceException.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static ServiceException2 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				ServiceException2 object = new ServiceException2();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException").equals(reader.getName())) {
								object.setServiceException(ServiceException.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class NotifySOAPHeader1 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "NotifySOAPHeader", "ns1");

		/**
		 * field for NotifySOAPHeader
		 */
		protected NotifySOAPHeader localNotifySOAPHeader;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1")) {
				return "ns1";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return NotifySOAPHeader
		 */
		public NotifySOAPHeader getNotifySOAPHeader() {
			return localNotifySOAPHeader;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            NotifySOAPHeader
		 */
		public void setNotifySOAPHeader(NotifySOAPHeader param) {
			this.localNotifySOAPHeader = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					NotifySOAPHeader1.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localNotifySOAPHeader == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localNotifySOAPHeader.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localNotifySOAPHeader.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static NotifySOAPHeader1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				NotifySOAPHeader1 object = new NotifySOAPHeader1();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "NotifySOAPHeader").equals(reader.getName())) {
								object.setNotifySOAPHeader(NotifySOAPHeader.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class DeliveryStatus implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1", "DeliveryStatus", "ns3");
		private static java.util.HashMap _table_ = new java.util.HashMap();
		public static final java.lang.String _DeliveredToNetwork = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeliveredToNetwork");
		public static final java.lang.String _DeliveryUncertain = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeliveryUncertain");
		public static final java.lang.String _DeliveryImpossible = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeliveryImpossible");
		public static final java.lang.String _MessageWaiting = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("MessageWaiting");
		public static final java.lang.String _DeliveredToTerminal = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeliveredToTerminal");
		public static final java.lang.String _DeliveryNotificationNotSupported = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("DeliveryNotificationNotSupported");
		public static final java.lang.String _AuthPriceFailed = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("AuthPriceFailed");
		public static final DeliveryStatus DeliveredToNetwork = new DeliveryStatus(_DeliveredToNetwork, true);
		public static final DeliveryStatus DeliveryUncertain = new DeliveryStatus(_DeliveryUncertain, true);
		public static final DeliveryStatus DeliveryImpossible = new DeliveryStatus(_DeliveryImpossible, true);
		public static final DeliveryStatus MessageWaiting = new DeliveryStatus(_MessageWaiting, true);
		public static final DeliveryStatus DeliveredToTerminal = new DeliveryStatus(_DeliveredToTerminal, true);
		public static final DeliveryStatus DeliveryNotificationNotSupported = new DeliveryStatus(_DeliveryNotificationNotSupported, true);
		public static final DeliveryStatus AuthPriceFailed = new DeliveryStatus(_AuthPriceFailed, true);

		/**
		 * field for DeliveryStatus
		 */
		protected java.lang.String localDeliveryStatus;

		// Constructor
		protected DeliveryStatus(java.lang.String value, boolean isRegisterValue) {
			localDeliveryStatus = value;

			if (isRegisterValue) {
				_table_.put(localDeliveryStatus, this);
			}
		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1")) {
				return "ns3";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		public java.lang.String getValue() {
			return localDeliveryStatus;
		}

		public boolean equals(java.lang.Object obj) {
			return (obj == this);
		}

		public int hashCode() {
			return toString().hashCode();
		}

		public java.lang.String toString() {
			return localDeliveryStatus.toString();
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					DeliveryStatus.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String localName = parentQName.getLocalPart();

			if (!namespace.equals("")) {
				java.lang.String prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, localName, namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, localName);
				}
			} else {
				xmlWriter.writeStartElement(localName);
			}

			if (localDeliveryStatus == null) {
				throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
			} else {
				xmlWriter.writeCharacters(localDeliveryStatus);
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME, new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT, org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeliveryStatus) }, null);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			public static DeliveryStatus fromValue(java.lang.String value) throws java.lang.IllegalArgumentException {
				DeliveryStatus enumeration = (DeliveryStatus) _table_.get(value);

				if (enumeration == null) {
					throw new java.lang.IllegalArgumentException();
				}

				return enumeration;
			}

			public static DeliveryStatus fromString(java.lang.String value, java.lang.String namespaceURI) throws java.lang.IllegalArgumentException {
				try {
					return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
				} catch (java.lang.Exception e) {
					throw new java.lang.IllegalArgumentException();
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DeliveryStatus parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				DeliveryStatus object = null;

				// initialize a hash map to keep values
				java.util.Map attributeMap = new java.util.HashMap();
				java.util.List extraAttributeList = new java.util.ArrayList();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {
							java.lang.String content = reader.getElementText();

							if (content.indexOf(":") > 0) {
								// this seems to be a Qname so find the
								// namespace and send
								prefix = content.substring(0, content.indexOf(":"));
								namespaceuri = reader.getNamespaceURI(prefix);
								object = DeliveryStatus.Factory.fromString(content, namespaceuri);
							} else {
								// this seems to be not a qname send and empty
								// namespace incase of it is
								// check is done in fromString method
								object = DeliveryStatus.Factory.fromString(content, "");
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class GetSmsDeliveryStatus5 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "getSmsDeliveryStatus", "ns2");

		/**
		 * field for GetSmsDeliveryStatus
		 */
		protected GetSmsDeliveryStatus localGetSmsDeliveryStatus;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return GetSmsDeliveryStatus
		 */
		public GetSmsDeliveryStatus getGetSmsDeliveryStatus() {
			return localGetSmsDeliveryStatus;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            GetSmsDeliveryStatus
		 */
		public void setGetSmsDeliveryStatus(GetSmsDeliveryStatus param) {
			this.localGetSmsDeliveryStatus = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					GetSmsDeliveryStatus5.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localGetSmsDeliveryStatus == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localGetSmsDeliveryStatus.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localGetSmsDeliveryStatus.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GetSmsDeliveryStatus5 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetSmsDeliveryStatus5 object = new GetSmsDeliveryStatus5();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "getSmsDeliveryStatus").equals(reader.getName())) {
								object.setGetSmsDeliveryStatus(GetSmsDeliveryStatus.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsLogo11 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsLogo", "ns2");

		/**
		 * field for SendSmsLogo
		 */
		protected SendSmsLogo localSendSmsLogo;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SendSmsLogo
		 */
		public SendSmsLogo getSendSmsLogo() {
			return localSendSmsLogo;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SendSmsLogo
		 */
		public void setSendSmsLogo(SendSmsLogo param) {
			this.localSendSmsLogo = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsLogo11.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localSendSmsLogo == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localSendSmsLogo.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localSendSmsLogo.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsLogo11 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsLogo11 object = new SendSmsLogo11();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsLogo").equals(reader.getName())) {
								object.setSendSmsLogo(SendSmsLogo.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class GetSmsDeliveryStatusResponse8 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "getSmsDeliveryStatusResponse", "ns2");

		/**
		 * field for GetSmsDeliveryStatusResponse
		 */
		protected GetSmsDeliveryStatusResponse localGetSmsDeliveryStatusResponse;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return GetSmsDeliveryStatusResponse
		 */
		public GetSmsDeliveryStatusResponse getGetSmsDeliveryStatusResponse() {
			return localGetSmsDeliveryStatusResponse;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            GetSmsDeliveryStatusResponse
		 */
		public void setGetSmsDeliveryStatusResponse(GetSmsDeliveryStatusResponse param) {
			this.localGetSmsDeliveryStatusResponse = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					GetSmsDeliveryStatusResponse8.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localGetSmsDeliveryStatusResponse == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localGetSmsDeliveryStatusResponse.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localGetSmsDeliveryStatusResponse.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static GetSmsDeliveryStatusResponse8 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetSmsDeliveryStatusResponse8 object = new GetSmsDeliveryStatusResponse8();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "getSmsDeliveryStatusResponse").equals(reader.getName())) {
								object.setGetSmsDeliveryStatusResponse(GetSmsDeliveryStatusResponse.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SmsFormat implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1", "SmsFormat", "ns3");
		private static java.util.HashMap _table_ = new java.util.HashMap();
		public static final java.lang.String _Ems = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("Ems");
		public static final java.lang.String _SmartMessaging = org.apache.axis2.databinding.utils.ConverterUtil.convertToString("SmartMessaging");
		public static final SmsFormat Ems = new SmsFormat(_Ems, true);
		public static final SmsFormat SmartMessaging = new SmsFormat(_SmartMessaging, true);

		/**
		 * field for SmsFormat
		 */
		protected java.lang.String localSmsFormat;

		// Constructor
		protected SmsFormat(java.lang.String value, boolean isRegisterValue) {
			localSmsFormat = value;

			if (isRegisterValue) {
				_table_.put(localSmsFormat, this);
			}
		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1")) {
				return "ns3";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		public java.lang.String getValue() {
			return localSmsFormat;
		}

		public boolean equals(java.lang.Object obj) {
			return (obj == this);
		}

		public int hashCode() {
			return toString().hashCode();
		}

		public java.lang.String toString() {
			return localSmsFormat.toString();
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SmsFormat.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			java.lang.String namespace = parentQName.getNamespaceURI();
			java.lang.String localName = parentQName.getLocalPart();

			if (!namespace.equals("")) {
				java.lang.String prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, localName, namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, localName);
				}
			} else {
				xmlWriter.writeStartElement(localName);
			}

			if (localSmsFormat == null) {
				throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");
			} else {
				xmlWriter.writeCharacters(localSmsFormat);
			}

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME, new java.lang.Object[] { org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT, org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSmsFormat) }, null);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			public static SmsFormat fromValue(java.lang.String value) throws java.lang.IllegalArgumentException {
				SmsFormat enumeration = (SmsFormat) _table_.get(value);

				if (enumeration == null) {
					throw new java.lang.IllegalArgumentException();
				}

				return enumeration;
			}

			public static SmsFormat fromString(java.lang.String value, java.lang.String namespaceURI) throws java.lang.IllegalArgumentException {
				try {
					return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
				} catch (java.lang.Exception e) {
					throw new java.lang.IllegalArgumentException();
				}
			}

			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SmsFormat parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SmsFormat object = null;

				// initialize a hash map to keep values
				java.util.Map attributeMap = new java.util.HashMap();
				java.util.List extraAttributeList = new java.util.ArrayList();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement() || reader.hasText()) {
							java.lang.String content = reader.getElementText();

							if (content.indexOf(":") > 0) {
								// this seems to be a Qname so find the
								// namespace and send
								prefix = content.substring(0, content.indexOf(":"));
								namespaceuri = reader.getNamespaceURI(prefix);
								object = SmsFormat.Factory.fromString(content, namespaceuri);
							} else {
								// this seems to be not a qname send and empty
								// namespace incase of it is
								// check is done in fromString method
								object = SmsFormat.Factory.fromString(content, "");
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class DeliveryInformation implements org.apache.axis2.databinding.ADBBean {
		/**
		 * field for Address
		 */
		protected org.apache.axis2.databinding.types.URI localAddress;

		/**
		 * field for DeliveryStatus
		 */
		protected DeliveryStatus localDeliveryStatus;

		/*
		 * This type was generated from the piece of schema that had name =
		 * DeliveryInformation Namespace URI =
		 * http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1 Namespace Prefix
		 * = ns3
		 */
		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1")) {
				return "ns3";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return org.apache.axis2.databinding.types.URI
		 */
		public org.apache.axis2.databinding.types.URI getAddress() {
			return localAddress;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Address
		 */
		public void setAddress(org.apache.axis2.databinding.types.URI param) {
			this.localAddress = param;
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return DeliveryStatus
		 */
		public DeliveryStatus getDeliveryStatus() {
			return localDeliveryStatus;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DeliveryStatus
		 */
		public void setDeliveryStatus(DeliveryStatus param) {
			this.localDeliveryStatus = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					DeliveryInformation.this.serialize(parentQName, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();

			if (namespace != null) {
				java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

				if (writerPrefix != null) {
					xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
				} else {
					if (prefix == null) {
						prefix = generatePrefix(namespace);
					}

					xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				}
			} else {
				xmlWriter.writeStartElement(parentQName.getLocalPart());
			}

			namespace = "";

			if (!namespace.equals("")) {
				prefix = xmlWriter.getPrefix(namespace);

				if (prefix == null) {
					prefix = generatePrefix(namespace);

					xmlWriter.writeStartElement(prefix, "address", namespace);
					xmlWriter.writeNamespace(prefix, namespace);
					xmlWriter.setPrefix(prefix, namespace);
				} else {
					xmlWriter.writeStartElement(namespace, "address");
				}
			} else {
				xmlWriter.writeStartElement("address");
			}

			if (localAddress == null) {
				// write the nil attribute
				throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddress));
			}

			xmlWriter.writeEndElement();

			if (localDeliveryStatus == null) {
				throw new org.apache.axis2.databinding.ADBException("deliveryStatus cannot be null!!");
			}

			localDeliveryStatus.serialize(new javax.xml.namespace.QName("", "deliveryStatus"), factory, xmlWriter);

			xmlWriter.writeEndElement();
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			elementList.add(new javax.xml.namespace.QName("", "address"));

			if (localAddress != null) {
				elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAddress));
			} else {
				throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
			}

			elementList.add(new javax.xml.namespace.QName("", "deliveryStatus"));

			if (localDeliveryStatus == null) {
				throw new org.apache.axis2.databinding.ADBException("deliveryStatus cannot be null!!");
			}

			elementList.add(localDeliveryStatus);

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static DeliveryInformation parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				DeliveryInformation object = new DeliveryInformation();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;

							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}

							nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"DeliveryInformation".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);

								return (DeliveryInformation) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}
						}
					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "address").equals(reader.getName())) {
						java.lang.String content = reader.getElementText();

						object.setAddress(org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(content));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() && new javax.xml.namespace.QName("", "deliveryStatus").equals(reader.getName())) {
						object.setDeliveryStatus(DeliveryStatus.Factory.parse(reader));

						reader.next();
					} // End of if for expected property start element

					else {
						// A start element we are not expecting indicates an
						// invalid parameter was passed
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement()) {
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
					}
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}

	public static class SendSmsRingtoneResponse6 implements org.apache.axis2.databinding.ADBBean {
		public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsRingtoneResponse", "ns2");

		/**
		 * field for SendSmsRingtoneResponse
		 */
		protected SendSmsRingtoneResponse localSendSmsRingtoneResponse;

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")) {
				return "ns2";
			}

			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Auto generated getter method
		 * 
		 * @return SendSmsRingtoneResponse
		 */
		public SendSmsRingtoneResponse getSendSmsRingtoneResponse() {
			return localSendSmsRingtoneResponse;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SendSmsRingtoneResponse
		 */
		public void setSendSmsRingtoneResponse(SendSmsRingtoneResponse param) {
			this.localSendSmsRingtoneResponse = param;
		}

		/**
		 * isReaderMTOMAware
		 * 
		 * @return true if the reader supports MTOM
		 */
		public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
			boolean isReaderMTOMAware = false;

			try {
				isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
			} catch (java.lang.IllegalArgumentException e) {
				isReaderMTOMAware = false;
			}

			return isReaderMTOMAware;
		}

		/**
		 * 
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {
			org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {
				public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
					SendSmsRingtoneResponse6.this.serialize(MY_QNAME, factory, xmlWriter);
				}
			};

			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory, org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			if (localSendSmsRingtoneResponse == null) {
				throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
			}

			localSendSmsRingtoneResponse.serialize(MY_QNAME, factory, xmlWriter);
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName, javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}

			java.lang.String attributeValue;

			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */
		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();

			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}
			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}

					namespaceURI = qnames[i].getNamespaceURI();

					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);

						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}

				xmlWriter.writeCharacters(stringToWrite.toString());
			}
		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);

			if (prefix == null) {
				prefix = generatePrefix(namespace);

				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}

				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}

			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 * 
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {
			// We can safely assume an element has only one type associated with
			// it
			return localSendSmsRingtoneResponse.getPullParser(MY_QNAME);
		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {
			/**
			 * static method to create the object Precondition: If this object
			 * is an element, the current or next start element starts this
			 * object and any intervening reader events are ignorable If this
			 * object is not an element, it is a complex type and the reader is
			 * at the event just after the outer start element Postcondition: If
			 * this object is an element, the reader is positioned at its end
			 * element If this object is a complex type, the reader is
			 * positioned at the end element of its outer element
			 */
			public static SendSmsRingtoneResponse6 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				SendSmsRingtoneResponse6 object = new SendSmsRingtoneResponse6();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";

				try {
					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					while (!reader.isEndElement()) {
						if (reader.isStartElement()) {
							if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", "sendSmsRingtoneResponse").equals(reader.getName())) {
								object.setSendSmsRingtoneResponse(SendSmsRingtoneResponse.Factory.parse(reader));
							} // End of if for expected property start element

							else {
								// A start element we are not expecting
								// indicates an invalid parameter was passed
								throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
							}
						} else {
							reader.next();
						}
					} // end of while loop
				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}
		} // end of factory class
	}
}
