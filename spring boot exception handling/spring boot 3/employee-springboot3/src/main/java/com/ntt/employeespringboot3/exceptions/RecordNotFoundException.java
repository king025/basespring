package com.ntt.employeespringboot3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public RecordNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
