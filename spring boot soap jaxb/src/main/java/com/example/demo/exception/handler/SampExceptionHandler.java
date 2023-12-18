package com.example.demo.exception.handler;

import com.example.demo.exception.SampException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

@ControllerAdvice({"com.example.demo.controller"})
public class SampExceptionHandler {
	@ExceptionHandler
	public final ResponseEntity<Object> handleBindException(BindException ex) {
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SampException.class)
	public final ResponseEntity<Object> handleSampException(SampException ex) {
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}
}
