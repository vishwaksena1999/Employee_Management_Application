package com.bean.employee.employeemanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@RestControllerAdvice

public class EmployeeGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<Object> handleEmployeeNotFound(Exception ex, WebRequest webRequest){
        EmployeeExceptionResponse employeeExceptionResponse = new EmployeeExceptionResponse(ex.getMessage(),
                webRequest.getDescription(  false),new Date());
        return new ResponseEntity<Object>(employeeExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        EmployeeExceptionResponse employeeExceptionResponse = new EmployeeExceptionResponse(ex.getMessage(),
                request.getDescription(  false),
                new Date());
        return new ResponseEntity<Object>(employeeExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
        EmployeeExceptionResponse employeeExceptionResponse = new EmployeeExceptionResponse(ex.getMessage(),
                webRequest.getDescription(  false),
                new Date());
        return new ResponseEntity<Object>(employeeExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
