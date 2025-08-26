package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.repositories.EmployeesRepo;

@RestController
@RequestMapping("/")
public class EmployeeController {

    EmployeesRepo empRepo = new EmployeesRepo();

    @GetMapping("/employees")
    public ArrayList<Employee> index() {
        return empRepo.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmp(@PathVariable int id) {
        return empRepo.findById(id);
    }

    @PostMapping("/employees")
    public void addEmp(@RequestBody Employee employee) {

        empRepo.addEmp(employee);

    }

    @DeleteMapping("/employees/{id}")
    public void removeEmp(@PathVariable int id) {

        empRepo.removeEmp(id);
    }

    @PutMapping("/employees/{id}")
    public Employee putMethodName(@PathVariable int id, @RequestBody Employee emp) {
        empRepo.updateEmp(id, emp);
        return emp;
    }
}
