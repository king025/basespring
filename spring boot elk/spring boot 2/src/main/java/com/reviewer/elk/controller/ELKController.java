package com.reviewer.elk.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.reviewer.elk.service.ELKService;
import com.reviewer.elk.service.RestService;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class ELKController {

    private static final Logger log = LoggerFactory.getLogger(ELKController.class);

    @Autowired
    private ELKService service;

    @Autowired
    private RestService restService;

    @GetMapping(value = "/hello")
    public String displayHelloWorld() {
        log.info("Inside Hello World Function");
        String response = "Hello World! " + new Date();
        log.info("Response => {}",response);
        return response;
    }

    @GetMapping(value = "/Food-Details")
    public JSONArray getFoodDetails() {
        log.info("Inside Food Detail Function");
        return service.getAllFoodDetails();
    }

    @GetMapping(value = "/weather/{city}")
    public JsonNode getWeatherInformation(@PathVariable String city){

        return restService.getPostsPlainJSON(city);
    }
}
