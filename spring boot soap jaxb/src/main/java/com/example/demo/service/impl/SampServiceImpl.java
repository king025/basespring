package com.example.demo.service.impl;

import com.example.demo.dto.api.SampRequest;
import com.example.demo.exception.SampException;
import com.example.demo.service.SampService;
import com.example.demo.service.client.SampClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.oorsprong.websamples.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.ByteArrayOutputStream;
import java.util.jar.JarException;

@Component
@Slf4j
public class SampServiceImpl implements SampService {
	@Autowired
	SampClient sampClient;

	@Override
	public ResponseEntity<Object> post(SampRequest sampRequest) {
		CountryNameResponse countryNameResponse = null;
		ObjectFactory objectFactory = new ObjectFactory();
		CountryName countryName = objectFactory.createCountryName();
		countryName.setSCountryISOCode(sampRequest.countryIso());
		try {
			countryNameResponse = sampClient.postCountryIso(countryName);
		} catch (FeignException ex) {
			throw new SampException(ex);
		}
		return new ResponseEntity<>(countryNameResponse, HttpStatus.OK);
	}

	private void logSoapRequest(CountryName countryName){
		ByteArrayOutputStream xmlString = new ByteArrayOutputStream();
		try{
			JAXBContext contextObj = JAXBContext.newInstance(CountryName.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(new JAXBElement<CountryName>(new QName("uri","local"), CountryName.class, countryName), xmlString);
		} catch (JAXBException e) {
			log.error("JAXBException");
		}
		log.info("\nSOAP Response: \n"+ xmlString);
	}
}
