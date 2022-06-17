package com.aaronzadev.restapiexample.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorResponse{

    private final String exceptionName;
    private final String messageException;
    private final String dateTime;

    private final Map<String, String> fieldErrors = new HashMap<>();

    public ErrorResponse(Exception ex) {
        exceptionName = ex.getClass().getSimpleName();
        messageException = ex.getMessage();
        dateTime = LocalDateTime.now().toString();
    }

    public ErrorResponse(Exception ex, BindingResult results) {
        exceptionName = ex.getClass().getSimpleName();
        messageException = "Some fields can not be null or empty";
        dateTime = LocalDateTime.now().toString();
        results.getFieldErrors().forEach(it -> { fieldErrors.put(it.getField(), it.getDefaultMessage()); });
    }
}
