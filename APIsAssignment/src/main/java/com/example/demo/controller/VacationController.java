package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.dto.Vacation;
import com.example.demo.repositories.VacationsRepo;

@RestController
@RequestMapping("/vacations")
public class VacationController {
    static VacationsRepo vacationsRepo = new VacationsRepo(EmployeeController.empRepo);

    @GetMapping("/{empId}")
    public ArrayList<Vacation> getAllVacations(@PathVariable int empId) throws EmployeeNotFoundException {
        return vacationsRepo.getAllVacations(empId);
    }

    @GetMapping(value = "/{empId}/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })

    public Vacation getById(@PathVariable int empId, @PathVariable int id) {
        return vacationsRepo.getById(empId, id);

    }

    @PostMapping("/{empId}")
    public void addNewVac(@RequestBody Vacation vac, @PathVariable int id) throws Exception {

        vacationsRepo.addNewVacation(id, vac);

    }

    public static void removeEmpsVacations(int id) {
        vacationsRepo.removeEmpsVacations(id);
    }

}
