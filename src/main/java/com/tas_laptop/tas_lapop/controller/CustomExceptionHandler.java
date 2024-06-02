package com.tas_laptop.tas_lapop.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
        HandlerMethodValidationException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getAllValidationResults().forEach(v -> {
            String messages = v.getResolvableErrors()
                .stream()
                .map(MessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
            errors.put(v.getMethodParameter().getParameterName(), messages);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
