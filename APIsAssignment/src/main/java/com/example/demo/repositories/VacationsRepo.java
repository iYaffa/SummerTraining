package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Vacation;

public class VacationsRepo {

    private EmployeesRepo empRepo;
    private HashMap<Integer, ArrayList<Vacation>> vacationsMap;
    private ArrayList<Employee> empList;
    private HashMap<Integer, Vacation> individualVacationsMap; // for each vacation

    public VacationsRepo() {
        empRepo = new EmployeesRepo();
        empList = empRepo.emplist;
        vacationsMap = initMap(empList);

    }

    // this method is used to generate dummy data
    private HashMap<Integer, ArrayList<Vacation>> initMap(ArrayList<Employee> empList2) {
        HashMap<Integer, ArrayList<Vacation>> map = new HashMap<>();
        individualVacationsMap = new HashMap<>();

        Random rand = new Random();

        String[] statuses = { "APPROVED", "PENDING", "REJECTED" };

        for (Employee employee : empList2) {
            ArrayList<Vacation> vacations = new ArrayList<>();

            int vacationCount = rand.nextInt(9); // number of vacations vary from 0 to 8

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

                vacations.add(vacation);
                individualVacationsMap.put(vacation.getVacationId(), vacation);

            }

            map.put(employee.getId(), vacations);
        }

        return map;
    }

    public ArrayList<Vacation> getAllVacations(int id) {

        return vacationsMap.get(id);

    }

    public void addNewVacation(int id, Vacation vac) {
        vacationsMap.get(id).add(vac);
    }
}
