package com.api.inquiries.rmsoapv2;

import com.api.inquiries.rmsoapv2.client.DataClient;
import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import feign.Feign;
import feign.Logger;
import feign.hc5.ApacheHttp5Client;
import feign.jaxb.JAXBContextFactory;
import feign.slf4j.Slf4jLogger;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import feign.soap.SOAPErrorDecoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;


@SpringBootTest
class Rmsoapv2ApplicationTests {

	@DisplayName("given SOAP Payload, when Request, then Return SOAP Response")
	@Test
	void numberToWordsSoapPayloadUrlTest() {
		DataClient client = Feign.builder()
				.client(new ApacheHttp5Client())
				.logger(new Slf4jLogger(DataClient.class))
				.logLevel(Logger.Level.FULL)
				.target(DataClient.class, "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL");

		String response = client.numberToWordsUrl(soapPayload());
		Assertions.assertNotNull(response);
		Assertions.assertTrue(response.contains("one thousand two hundred and thirty four"));
	}

	@DisplayName("when SOAP Request, then Return SOAP Response")
	@Test
	void numberToWordsSoapRequestUrlTest() {
		JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
				.withMarshallerJAXBEncoding("UTF-8").build();
		DataClient client = Feign.builder()
				.encoder(new SOAPEncoder(jaxbFactory))
				.errorDecoder(new SOAPErrorDecoder())
				.logger(new Slf4jLogger())
				.logLevel(Logger.Level.FULL)
				.decoder(new SOAPDecoder(jaxbFactory))
				.target(DataClient.class, "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL");
		NumberToWords request = new NumberToWords();
		request.setUbiNum(new BigInteger("1234"));
		NumberToWordsResponse response = client.numberToWordsUrl(request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals("one thousand two hundred and thirty four", response.getNumberToWordsResult().toLowerCase().trim());
	}

//	@Test //Uncomment to test Calculator in localhost
	void addNumbersLocalTest() {
		DataClient client = Feign.builder()
				.client(new ApacheHttp5Client())
				.logger(new Slf4jLogger(DataClient.class))
				.logLevel(Logger.Level.FULL)
				.target(DataClient.class, "http://localhost:8080/medium/ws/calculatorDemo.wsdl");

		String response = client.addNums(additionPayload());
		Assertions.assertNotNull(response);
		Assertions.assertTrue(response.contains("101"));
	}

	private String soapPayload() {
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.dataaccess.com/webservicesserver/\">\n" +
				"   <soapenv:Header/>\n" +
				"   <soapenv:Body>\n" +
				"      <web:NumberToWords>\n" +
				"         <web:ubiNum>1234</web:ubiNum>\n" +
				"      </web:NumberToWords>\n" +
				"   </soapenv:Body>\n" +
				"</soapenv:Envelope>";
	}

	private String additionPayload() {
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cal=\"http://medium.com/types/calculator\">\n" +
				"   <soapenv:Header/>\n" +
				"   <soapenv:Body>\n" +
				"      <cal:AdditionInput>\n" +
				"         <cal:number1>50</cal:number1>\n" +
				"         <cal:number2>51</cal:number2>\n" +
				"      </cal:AdditionInput>\n" +
				"   </soapenv:Body>\n" +
				"</soapenv:Envelope>";
	}

}
