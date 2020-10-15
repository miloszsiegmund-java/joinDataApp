package com.example.joinDataApp.number.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomExceptionHandler extends RuntimeException {
    public CustomExceptionHandler(String message) {
        super(message);
    }
}
