package com.astrolink.util.tools.business.SSL;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public abstract class TrustAnyTrustManager implements X509TrustManager{

	public abstract void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException;

	public abstract void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException;

	public abstract X509Certificate[] getAcceptedIssuers();
}
