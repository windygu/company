package cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axis2.client.ServiceClient;

import com.astrolink.consts.Const;

public class HeaderFactory {
	protected static final String nameSpace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1";

	protected static final String SOAPHEADER_spId = "spId";
	protected static final String SOAPHEADER_spPassword = "spPassword";
	protected static final String SOAPHEADER_timeStamp = "timeStamp";
	protected static final String SOAPHEADER_productId = "productId";
	protected static final String SOAPHEADER_SPNumber = "SPNumber";
	protected static final String SOAPHEADER_transactionId = "transactionId";
	protected static final String SOAPHEADER_transEnd = "transEnd";
	protected static final String SOAPHEADER_linkId = "linkId";
	protected static final String SOAPHEADER_OA = "OA";
	protected static final String SOAPHEADER_FA = "FA";
	protected static final String SOAPHEADER_multicastMessaging = "multicastMessaging";
	protected static final String SOAPHEADER_RequestSOAPHeader = "RequestSOAPHeader";

	public static SOAPHeaderBlock creatAOMTSoapHeader(String productId, String transactionId, String transEnd, String linkId, String OA, String FA) {
		// SOAPHeader字段赋值
		String spId =Const.CTCC_SP_ID;				
		String spPassword =Const.CTCC_SP_PASSWORD;	

		if (!OA.equals(""))
			OA = "tel:+86" + OA;
		if (!FA.equals(""))
			FA = "tel:+86" + FA;

		String timeStamp = "";
		String multicastMessaging = "false";

		// 获取当前时间作为时间戳(MMddHHmmss)
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		timeStamp = sdf.format(date);

		// 获取AXIOM的对象工厂
		OMFactory fac = OMAbstractFactory.getOMFactory();
		SOAPFactory sfac = OMAbstractFactory.getSOAP11Factory();

		// 创建名字空间NameSpace
		OMNamespace omNs = fac.createOMNamespace(nameSpace, "tns");

		/*
		 * 设置SOAPHeader字段, 对应cuc_common_types_2_1.xsd中的定义:
		 * 
		 * <xsd:element name="RequestSOAPHeader"
		 * type="cuc_common_xsd:RequestSOAPHeader"/> <xsd:complexType
		 * name="RequestSOAPHeader"> <xsd:sequence> <xsd:element name="spId"
		 * type="xsd:string"/> <xsd:element name="spPassword"
		 * type="xsd:string"/> <xsd:element name="timeStamp" type="xsd:string"/>
		 * <xsd:element name="serviceId" type="xsd:string"/> <xsd:element
		 * name="SPNumber" type="xsd:string" minOccurs="0" maxOccurs="1"/>
		 * <xsd:element name="sessionId" type="xsd:string" minOccurs="0"
		 * maxOccurs="1"/> <xsd:element name="sessionEnd"
		 * type="cuc_common_xsd:EndReason" minOccurs="0" maxOccurs="1"/>
		 * <xsd:element name="linkId" type="xsd:string" minOccurs="0"
		 * maxOccurs="1"/> <xsd:element name="OA" type="xsd:string"
		 * minOccurs="0" maxOccurs="1"/> <xsd:element name="FA"
		 * type="xsd:string" minOccurs="0" maxOccurs="1"/> <xsd:element
		 * name="groupMessaging" type="xsd:boolean" minOccurs="0"
		 * maxOccurs="1"/> </xsd:sequence> </xsd:complexType>
		 */

		// 创建RequestSOAPHeader
		SOAPHeaderBlock block_RequestSOAPHeader = sfac.createSOAPHeaderBlock(SOAPHEADER_RequestSOAPHeader, omNs);

		// 设置spId
		SOAPHeaderBlock block_spId = sfac.createSOAPHeaderBlock(SOAPHEADER_spId, omNs);
		block_spId.addChild(sfac.createOMText(spId));

		// 设置spPassword: 由spId+spPassword+timeStamp作MD5加密
		String md_password = md5Digest(spId, spPassword, timeStamp);
		SOAPHeaderBlock block_spPassword = sfac.createSOAPHeaderBlock(SOAPHEADER_spPassword, omNs);
		block_spPassword.addChild(sfac.createOMText(md_password));

		// 设置timeStamp
		SOAPHeaderBlock block_timeStamp = sfac.createSOAPHeaderBlock(SOAPHEADER_timeStamp, omNs);
		block_timeStamp.addChild(sfac.createOMText(timeStamp));

		// 设置serviceId
		SOAPHeaderBlock block_serviceId = sfac.createSOAPHeaderBlock(SOAPHEADER_productId, omNs);
		block_serviceId.addChild(sfac.createOMText(productId));

		// 设置transEnd
		SOAPHeaderBlock block_transEnd = sfac.createSOAPHeaderBlock(SOAPHEADER_transEnd, omNs);
		block_transEnd.addChild(sfac.createOMText("0"));

		// 设置sessionId
		SOAPHeaderBlock block_sessionId = sfac.createSOAPHeaderBlock(SOAPHEADER_transactionId, omNs);
		block_sessionId.addChild(sfac.createOMText(transactionId));

		// 设置sessionEnd
		SOAPHeaderBlock block_sessionEnd = sfac.createSOAPHeaderBlock(SOAPHEADER_transEnd, omNs);
		block_sessionEnd.addChild(sfac.createOMText(transEnd));

		// 设置linkId
		SOAPHeaderBlock block_linkId = sfac.createSOAPHeaderBlock(SOAPHEADER_linkId, omNs);
		block_linkId.addChild(sfac.createOMText(linkId));

		// 设置OA
		SOAPHeaderBlock block_OA = sfac.createSOAPHeaderBlock(SOAPHEADER_OA, omNs);
		block_OA.addChild(sfac.createOMText(OA));

		// 设置FA
		SOAPHeaderBlock block_FA = sfac.createSOAPHeaderBlock(SOAPHEADER_FA, omNs);
		block_FA.addChild(sfac.createOMText(FA));

		// 设置groupMessaging
		SOAPHeaderBlock block_groupMessaging = sfac.createSOAPHeaderBlock(SOAPHEADER_multicastMessaging, omNs);
		block_groupMessaging.addChild(sfac.createOMText(multicastMessaging));

		// 将字段spId,spPassword,timeStamp,serviceId,SPNumber,sessionId,sessionEnd,linkId,OA,FA,groupMessaging
		// 作为RequestSOAPHeader的子节点
		block_RequestSOAPHeader.addChild(block_spId);
		block_RequestSOAPHeader.addChild(block_spPassword);
		block_RequestSOAPHeader.addChild(block_timeStamp);
		block_RequestSOAPHeader.addChild(block_serviceId);
		block_RequestSOAPHeader.addChild(block_transEnd);
		block_RequestSOAPHeader.addChild(block_sessionId);
		block_RequestSOAPHeader.addChild(block_sessionEnd);
		block_RequestSOAPHeader.addChild(block_linkId);
		block_RequestSOAPHeader.addChild(block_OA);
		block_RequestSOAPHeader.addChild(block_FA);
		block_RequestSOAPHeader.addChild(block_groupMessaging);

		/*
		 * 设置SOAPHeader结束, SOAPHeader示例:
		 * 
		 * <soapenv:Header> <tns:RequestSOAPHeader
		 * xmlns:tns="http://www.chinaunicom.com.cn/schema/cuc/common/v2_1">
		 * <tns:spId>123456</tns:spId> <tns:spPassword>123456</tns:spPassword>
		 * <tns:timeStamp>0101111111</tns:timeStamp>
		 * <tns:serviceId>123456</tns:serviceId>
		 * <tns:SPNumber>123456</tns:SPNumber>
		 * <tns:sessionId>123456</tns:sessionId>
		 * <tns:sessionEnd>-1</tns:sessionEnd> <tns:linkId>123456</tns:linkId>
		 * <tns:OA>tel:8613907550001</tns:OA> <tns:FA>tel:8613907550001</tns:FA>
		 * <tns:groupMessaging>false</tns:groupMessaging>
		 * </tns:RequestSOAPHeader> </soapenv:Header>
		 */

		System.out.println(block_RequestSOAPHeader.toString());

		return block_RequestSOAPHeader;

	}

	// MD5摘要
	private static String md5Digest(String spId, String spPassword, String timeStamp) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(spId.getBytes());
			md.update(spPassword.getBytes());
			md.update(timeStamp.getBytes());

			byte[] b = md.digest();
			String result = "";
			String temp = "";
			// 取摘要的前16字节
			for (int i = 0; i < 16; i++) {
				temp = Integer.toHexString(b[i] & 0xFF);
				if (temp.length() == 1)
					temp = "0" + temp;
				result += temp;
			}

			// MD5密码转换为大写
			result = result.toUpperCase();

			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
