package com.ntt.employeespringboot2.exceptions;

public class EmptyInputException extends RuntimeException{

    public EmptyInputException(String message) {
        super(message);
    }

}
