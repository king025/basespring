package com.ntt.employeespringboot2.exceptions;

public class IllegalArgumentExceptionCustom extends RuntimeException {

    public IllegalArgumentExceptionCustom(String message) {
        super(message);
    }
}
