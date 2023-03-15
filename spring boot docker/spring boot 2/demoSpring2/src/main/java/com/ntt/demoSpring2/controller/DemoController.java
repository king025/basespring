package com.ntt.demoSpring2.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public ResponseEntity demoInfo(){
        return ResponseEntity.ok().body("Hello World");
    }
}
