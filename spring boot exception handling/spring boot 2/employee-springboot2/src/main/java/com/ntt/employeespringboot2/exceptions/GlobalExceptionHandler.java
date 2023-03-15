package com.ntt.employeespringboot2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(RecordNotFoundException ex, WebRequest webRequest){
        return new ResponseEntity<>(new ApiException(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IllegalArgumentExceptionCustom.class, IllegalStateException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(new ApiException(ex.getMessage(),HttpStatus.BAD_REQUEST,LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EmptyInputException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(EmptyInputException ex, WebRequest webRequest){
        return new ResponseEntity<>(new ApiException(ex.getMessage(),HttpStatus.BAD_REQUEST,LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }
}
