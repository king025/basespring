package com.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.api.RMRequest;
import com.api.service.InquireRmTrailerService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("v1/customeraccounts/unitas")
public class RMController implements RMApi {

	@Autowired
	private InquireRmTrailerService inquireRmTrailerService;

	@PostMapping("/inqRMTrailers2")
	@Override
	public ResponseEntity<Object> inqRMTrailers2(
			@Parameter(description = "The apiKey used to authenticate access", required = true) @RequestHeader String apiKey,
			@Parameter(description = "The apiSecret used to authenticate access", required = true) @RequestHeader String apiSecret,
			@Parameter(description = "Request Unique ID", required = true) @RequestHeader String requestUID,
			@Parameter(description = "Resource Owner ID - Online or Mobile", required = true) @RequestHeader String resourceOwnerId,
			@RequestBody @Valid RMRequest request) {
		return new ResponseEntity<>(inquireRmTrailerService.get(request), HttpStatus.OK);
	}

}
