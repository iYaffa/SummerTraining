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

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.dto.Employee;
import com.example.demo.repositories.EmployeesRepo;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    static EmployeesRepo empRepo = new EmployeesRepo();

    @GetMapping("")
    public ArrayList<Employee> index() {
        return empRepo.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmp(@PathVariable int id) throws EmployeeNotFoundException {
        return empRepo.findById(id);
    }

    @PostMapping("")
    public void addEmp(@RequestBody Employee employee) {

        empRepo.addEmp(employee);

    }

    @DeleteMapping("/{id}")
    public void removeEmp(@PathVariable int id) {
        VacationController.removeEmpsVacations(id);
        empRepo.removeEmp(id);
    }

    @PutMapping("/{id}")
    public void putMethodName(@PathVariable int id, @RequestBody Employee emp) {
        empRepo.updateEmp(id, emp);
    }

}
