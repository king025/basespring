package com.ntt.employeespringboot3.exceptions;

public class EmptyInputException extends RuntimeException{

    public EmptyInputException(String message) {
        super(message);
    }

}
