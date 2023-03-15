package global.ntt.legstar.controllers;

import global.ntt.legstar.exceptions.ProcessException;
import global.ntt.legstar.models.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class LegstarControllerAdvice {
    @ExceptionHandler(ProcessException.class)
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ApiError.builder().message(ex.getMessage()).errorCode("01").build(),
                new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
