package com.api.controller;

import org.springframework.http.ResponseEntity;

import com.api.dto.api.RMRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface RMApi {

	@Operation(tags = { "Unitas Inquire RM 	Trailer" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden Access"),
			@ApiResponse(responseCode = "404", description = "Resource Not Found"),
			@ApiResponse(responseCode = "500", description = "Internal server error occurred") })
	ResponseEntity<Object> inqRMTrailers2(String apiKey, String apiSecret, String requestUID, String resourceOwnerId,
			RMRequest request);

}
