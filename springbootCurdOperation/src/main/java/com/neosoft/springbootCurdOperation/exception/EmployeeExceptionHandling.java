package com.neosoft.springbootCurdOperation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class EmployeeExceptionHandling {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> HandleRuntimeException(RuntimeException exception,WebRequest request){

        ErrorResponse message = ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .details(request.getDescription(false))
                .build();


        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }
}
