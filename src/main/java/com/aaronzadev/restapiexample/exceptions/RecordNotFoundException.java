package com.aaronzadev.restapiexample.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public static final String DESCRIPTION = "Resource not Found (404)";

    public RecordNotFoundException(String details) {
        super(DESCRIPTION.concat(" ").concat(details));
    }
}
