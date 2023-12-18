package com.example.demo.exception;

import feign.FeignException;
import lombok.Getter;

import java.io.Serial;

@Getter
public class SampException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;
	private final transient FeignException response;

	public SampException(String message, FeignException response) {
		super(message);
		this.response = response;
	}

	public SampException(FeignException response) {
		super(response.getMessage());
		this.response = response;
	}
}
