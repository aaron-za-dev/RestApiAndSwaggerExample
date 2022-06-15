package com.aaronzadev.restapiexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RecordNotFoundException.class})
    protected final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UnsupportedOperationException.class})
    protected final ResponseEntity<ErrorResponse> handleUnsupportedOperationException(UnsupportedOperationException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
