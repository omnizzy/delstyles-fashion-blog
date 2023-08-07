package com.example.delstyles.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<?> ex1(InvalidDataException invalidDataException) {
        return ResponseEntity.badRequest().body(invalidDataException.getLocalizedMessage());
    }
}
