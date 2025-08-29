package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
