package com.example.demo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
	private static final String TLSV1_2 = "TLSv1.2";

	public static TrustManager[] getTrustManager(){
		return new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) {
				log.error("UNKNOWN CLIENT CERTIFICATE: {}",chain[0].getSubjectX500Principal());
				log.error("CHECK CLIENT CERTIFICATE");
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) {
				log.error("UNKNOWN CLIENT CERTIFICATE: {}",chain[0].getSubjectX500Principal());
				log.error("CHECK CLIENT CERTIFICATE");
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[] {};
			}
		}

		};
	}

	public static SSLContext getSSLContext(TrustManager[] trustAllCerts) {
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance(TLSV1_2);
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
		log.error(e.getMessage());
		}
		return sslContext;
	}

	public static Proxy buildProxy(String proxyHost, Integer proxyPort){
		return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
	}
}
