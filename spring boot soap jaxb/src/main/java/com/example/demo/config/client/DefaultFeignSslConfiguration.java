package com.example.demo.config.client;

import com.example.demo.exception.BasicException;
import feign.Client;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

@Configuration
@Profile("default")
public class DefaultFeignSslConfiguration {

	@Bean
	public Feign.Builder feignBuilder(){
		return Feign.builder().client(new OkHttpClient());
	}
}
