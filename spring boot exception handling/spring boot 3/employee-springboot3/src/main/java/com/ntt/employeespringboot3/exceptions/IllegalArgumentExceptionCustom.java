package com.ntt.employeespringboot3.exceptions;

public class IllegalArgumentExceptionCustom extends RuntimeException {

    public IllegalArgumentExceptionCustom(String message) {
        super(message);
    }
}
