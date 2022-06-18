package com.aaronzadev.restapiexample.exceptions;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    //TODO Add exceptions for authorize

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex, ex.getBindingResult());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

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

    @Override //TODO finish to implement
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
