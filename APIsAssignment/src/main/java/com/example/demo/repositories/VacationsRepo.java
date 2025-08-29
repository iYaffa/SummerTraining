package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.dto.Employee;
import com.example.demo.dto.Vacation;

public class VacationsRepo {

    private EmployeesRepo empRepo;
    private HashMap<Integer, HashMap<Integer, Vacation>> vacationsMap;
    private ArrayList<Employee> empList;

    public VacationsRepo(EmployeesRepo empRepo) {
        this.empRepo = empRepo;
        empList = empRepo.emplist;
        vacationsMap = initMap(empList);

    }

    // this method is used to generate dummy data
    private HashMap<Integer, HashMap<Integer, Vacation>> initMap(ArrayList<Employee> empList2) {
        HashMap<Integer, HashMap<Integer, Vacation>> map = new HashMap<>();

        Random rand = new Random();

        String[] statuses = { "APPROVED", "PENDING", "REJECTED" };

        for (Employee employee : empList2) {
            HashMap<Integer, Vacation> vacations = new HashMap<>();

            int vacationCount = rand.nextInt(9) + 1; // number of vacations vary from 1 to 9

            for (int i = 0; i < vacationCount; i++) {
                LocalDate start = LocalDate.of(2025, rand.nextInt(12) + 1, rand.nextInt(28) + 1);

                LocalDate end = start.plusDays(rand.nextInt(14) + 1);

                String startDate = start.toString();
                String endDate = end.toString();

                String status = statuses[rand.nextInt(statuses.length)];

                Vacation vacation = new Vacation(
                        employee.getId(),
                        startDate,
                        endDate,
                        status);
                vacations.put(vacation.getVacationId(), vacation);

            }

            map.put(employee.getId(), vacations);
        }

        return map;
    }

    public ArrayList<Vacation> getAllVacations(int id) throws EmployeeNotFoundException {
        if (vacationsMap.get(id) != null)
            return new ArrayList<>(vacationsMap.get(id).values());
        else
            throw new EmployeeNotFoundException(id + "");
    }

    public void addNewVacation(int id, Vacation vac) throws EmployeeNotFoundException {
        if (vacationsMap.get(id) != null)
            vacationsMap.get(id).put(vac.getVacationId(), vac);
        else
            throw new EmployeeNotFoundException(id + "");
    }

    public void removeVacation(int id) {
        for (HashMap<Integer, Vacation> map : vacationsMap.values()) {
            if (map.containsKey(id)) {
                map.remove(id);
                break;
            }
        }
    }

    public void updateVacation(int empId, int vacId, Vacation vac) {
        Vacation vacation = vacationsMap.get(empId).get(vacId);
        vacation.setStartDate(vac.getStartDate());
        vacation.setEndDate(vac.getEndDate());
        vacation.setStatus(vac.getStatus());
    }

    public Vacation getById(int empId, int id) {
        return vacationsMap.get(empId).get(id);
    }

    public void removeEmpsVacations(int empId) {
        vacationsMap.remove(empId);
    }
}
