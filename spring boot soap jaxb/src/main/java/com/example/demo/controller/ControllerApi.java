package com.example.demo.controller;

import com.example.demo.dto.api.SampRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface ControllerApi {
	@Operation(summary = "", description = "Sample SOAP")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden Access"),
			@ApiResponse(responseCode = "404", description = "Resource Not Found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error Occurerd")})
	ResponseEntity<Object> sampleCtrl(String apiKey, String apiSecret, SampRequest sampRequest);
}
