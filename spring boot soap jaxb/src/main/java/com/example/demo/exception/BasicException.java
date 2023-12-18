package com.example.demo.exception;

public class BasicException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BasicException() {
		super();
	}

	public BasicException(String message) {
		super(message);
	}
}
