package com.aaronzadev.restapiexample.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse{

    private final String exceptionName;
    private final String messageException;
    private final String dateTime;

    public ErrorResponse(Exception ex) {
        exceptionName = ex.getClass().getSimpleName();
        messageException = ex.getMessage();
        dateTime = LocalDateTime.now().toString();
    }



}
