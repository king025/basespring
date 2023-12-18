package com.example.demo.service.client;

import com.example.demo.config.client.SoapFeignConfiguration;
import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "${samp.client.name}", url = "${samp.client.base}", primary = false, configuration = SoapFeignConfiguration.class)
public interface SampClient {
	@PostMapping(value = "${samp.client.url}", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
	CountryNameResponse postCountryIso(CountryName countryName);
}
