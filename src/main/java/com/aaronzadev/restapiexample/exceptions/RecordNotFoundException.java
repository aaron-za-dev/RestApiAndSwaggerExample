package com.aaronzadev.restapiexample.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public static final String DESCRIPTION = "Resource not found - ";

    public RecordNotFoundException(String details) {
        super(DESCRIPTION.concat(details));
    }
}
