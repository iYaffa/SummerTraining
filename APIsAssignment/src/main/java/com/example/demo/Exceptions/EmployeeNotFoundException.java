package com.example.demo.Exceptions;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String id) {
        super("Employee with the id " + id + " does not exist!");
    }
}
