package com.aaronzadev.restapiexample.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse{

    private final String exceptionName;
    private final String messageException;
    private final String dateTime;
    private final String endPoint;

    public ErrorResponse(Exception ex, String endPoint) {
        exceptionName = ex.getClass().getName();
        messageException = ex.getMessage();
        dateTime = LocalDateTime.now().toString();
        this.endPoint = endPoint;
    }



}
