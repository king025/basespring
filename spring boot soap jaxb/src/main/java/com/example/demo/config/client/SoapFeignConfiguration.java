package com.example.demo.config.client;

import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import org.springframework.context.annotation.Bean;

public class SoapFeignConfiguration {
	private static final JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder().withMarshallerJAXBEncoding("UTF-8").build();

	@Bean
	public Encoder feignEncoder() {
		return new SOAPEncoder(jaxbFactory);
	}

	@Bean
	public Decoder feignDecoder() {
		return new SOAPDecoder(jaxbFactory);
	}

	@Bean
	public Feign.Builder soapFeignBuilder() {
		return new Feign.Builder().encoder(feignEncoder()).decoder(feignDecoder());
	}
}
