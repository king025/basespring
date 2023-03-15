package com.api.inquiries.rm.controller;


import brave.Span;
import brave.Tracer;
import com.api.inquiries.rm.client.DataClient;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Log
public class InquiriesController {

    @Autowired
    DataClient dataClient;

    @Autowired
    Tracer tracer;

    @GetMapping(value = "/inquiry")
    @SpanName("getAllSpan")
    public String getAll(){
        log.info("GetAll: Sleuth test");
        return "Success";
    }

    @GetMapping(value = "/inquiry/1")
    @SpanName("getEmployeeSpan")
    public String getEmployee(){
        log.info("GetEmployee: Overall spanId");
        Span newSpan = tracer.nextSpan().name("newSpan").start();
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            Thread.sleep(1000L);
            log.info("Specific code block for better tracing under a different spanId");
        } catch(InterruptedException e){

        } finally {
            newSpan.finish();
        }

        return "Success";
    }
}
