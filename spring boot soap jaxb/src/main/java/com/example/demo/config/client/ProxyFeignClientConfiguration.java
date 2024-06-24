package com.example.demo.config.client;

import com.example.demo.config.properties.ProxyConfigProperties;
import com.example.demo.util.Utils;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.util.concurrent.TimeUnit;

@Configuration
@Profile("sit")
public class ProxyFeignClientConfiguration {
	@Autowired
	ProxyConfigProperties proxyConfig;

	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder().client(new OkHttpClient(buildOkHttpClient()));
	}

	private okhttp3.OkHttpClient buildOkHttpClient() {
		okhttp3.OkHttpClient.Builder newBuilder = new okhttp3.OkHttpClient.Builder();
		TrustManager[] trustAllCerts = Utils.getTrustManager();

		newBuilder.connectTimeout(1, TimeUnit.MINUTES);
		newBuilder.proxy(Utils.buildProxy(proxyConfig.getHost(), proxyConfig.getPort()));
		newBuilder.sslSocketFactory(Utils.getSSLContext(trustAllCerts).getSocketFactory(),
				(X509TrustManager) trustAllCerts[0]);
		newBuilder.hostnameVerifier((hostname, session) -> Boolean.TRUE);
		return newBuilder.build();
	}
}
