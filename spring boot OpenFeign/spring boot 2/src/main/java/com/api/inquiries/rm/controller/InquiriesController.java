package com.api.inquiries.rm.controller;

import com.api.inquiries.rm.client.DataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InquiriesController {

    @Autowired
    private DataClient dataClient;

    @GetMapping(value = "/inquiry")
    public Map<String,Object> getData(){
        return dataClient.getData();
    }
}
