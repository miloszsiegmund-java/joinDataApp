package com.example.joinDataApp.number.exeptions;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class CustomExceptionHandleAdvice {

    private static final String ERROR_MESSAGE = "Invalid method or data source type";

    @ExceptionHandler(CustomExceptionHandler.class)
    public final ResponseEntity<?> handleUserNotFoundException(CustomExceptionHandler ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public final ResponseEntity<?> handleConversionFailedException(RuntimeException ex) {
        return new ResponseEntity<>(ERROR_MESSAGE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public final ResponseEntity<?> handleApiResponseException(HttpStatusCodeException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
}
