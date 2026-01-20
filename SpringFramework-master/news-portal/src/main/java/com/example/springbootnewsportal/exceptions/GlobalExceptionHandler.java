package com.example.springbootnewsportal.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@ExceptionHandler(NewsNotFoundException.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception ex){
        ex.printStackTrace();
    }
}
