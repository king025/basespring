package com.example.demo.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ssl.rest.proxy")
@Data
public class ProxyConfigProperties {
	private String host;
	private Integer port;
}
