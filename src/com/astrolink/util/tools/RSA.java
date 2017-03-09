package com.astrolink.util.tools;

public class RSA
{
	public static native String getPublicKey( );

	public static native String getPrivateKey( );

	public static native String EncryptWithPublic( String data, String publickey );

	public static native String DecryptWithPrivate( String data, String privatekey );

	public static native String SHA1AndSignWithPrivatekey( String data, String privatekey );

	static
	{
		System.loadLibrary( "RSA_x64" );
	}

	public static void main( String[] argv )
	{
		return;
	}
}
