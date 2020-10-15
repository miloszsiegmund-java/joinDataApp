package com.example.joinDataApp.number.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandleAdvice {

    @ExceptionHandler(CustomExceptionHandler.class)
    public final ResponseEntity<?> handleUserNotFoundException(CustomExceptionHandler ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
}
