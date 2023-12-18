package com.example.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice({"com.example.demo.controller"})
public class DefaultExceptionHandler extends DefaultHandlerExceptionResolver {
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		return new ResponseEntity<>("", HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(MissingRequestHeaderException ex) {
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}
}
