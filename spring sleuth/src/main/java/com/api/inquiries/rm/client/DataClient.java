package com.api.inquiries.rm.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "${client.name}", url = "${client.url}")
public interface DataClient {

    @GetMapping(value = "/employees/1")
    Map<String, Object> getEmployee();
    @GetMapping(value = "/employees")
    Map<String, Object> getAll();
}