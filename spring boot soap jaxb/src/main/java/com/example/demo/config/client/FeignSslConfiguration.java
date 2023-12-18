package com.example.demo.config.client;

import com.example.demo.exception.BasicException;
import feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

@Slf4j
public class FeignSslConfiguration {
	@Bean
	public Client feignBuilder() {
		return new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
	}

	private SSLSocketFactory getSSLSocketFactory() {
		try {
			SSLContext sslContext = null;
			sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			return sslContext.getSocketFactory();
		} catch (Exception e) {
			throw new BasicException(e.getMessage());
		}
	}
}
