package com.api.inquiries.rmsoapv2.client;

import com.api.inquiries.rmsoapv2.configuration.SoapWebServiceConfiguration;
import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "sample", configuration = SoapWebServiceConfiguration.class)
public interface DataClient {

    @RequestLine("POST")
    @Headers({"SOAPAction: numberToWords", "Content-Type: text/xml;charset=UTF-8",
            "Accept: text/xml"})
    String numberToWordsUrl(String request);

    @RequestLine("POST")
    @Headers({"Content-Type: text/xml;charset=UTF-8"})
    NumberToWordsResponse numberToWordsUrl(NumberToWords request);

    @RequestLine("POST")
    @Headers({"SOAPAction: addition", "Content-Type: text/xml;charset=UTF-8",
            "Accept: text/xml"})
    String addNums(String request);


}
