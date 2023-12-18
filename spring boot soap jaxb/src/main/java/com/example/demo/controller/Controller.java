package com.example.demo.controller;

import com.example.demo.dto.api.SampRequest;
import com.example.demo.service.SampService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("samp")
public class Controller implements ControllerApi {
	@Autowired
	SampService sampService;

	@PostMapping("/soap")
	@Override
	public ResponseEntity<Object> sampleCtrl(
			@Parameter(description = "Authenticate access") @RequestHeader(value = "apiKey", required = false) String apiKey,
			@Parameter(description = "Authenticate access") @RequestHeader(value = "apiSecret", required = false) String apiSecret,
			@Valid @RequestBody SampRequest sampRequest) {
		return sampService.post(sampRequest);
	}
}
