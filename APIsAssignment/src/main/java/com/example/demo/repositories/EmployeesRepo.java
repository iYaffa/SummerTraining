package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.dto.Employee;

public class EmployeesRepo {

    ArrayList<Employee> emplist;
    HashMap<Integer, Employee> empMap;

    public EmployeesRepo() {
        emplist = fillList();

        empMap = fillMap(emplist);

    }

    private HashMap<Integer, Employee> fillMap(ArrayList<Employee> emplist2) {
        HashMap<Integer, Employee> empMap2 = new HashMap<>();
        for (Employee employee : emplist2) {
            empMap2.put(employee.getId(), employee);
        }
        return empMap2;
    }

    public ArrayList<Employee> getAllEmployees() {
        return emplist;
    }

    public Employee findById(int id) throws EmployeeNotFoundException {
        if (empMap.get(id) != null)
            return empMap.get(id);
        else
            throw new EmployeeNotFoundException(id + "");

    }

    public void addEmp(Employee emp) {
        emplist.add(emp);
    }

    public void removeEmp(int id) {
        for (Employee employee : emplist) {
            if (employee.getId() == id) {
                emplist.remove(employee);
                empMap.remove(id);
                break;
            }
        }
    }

    // generates dummy data
    private ArrayList<Employee> fillList() {

        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee("Alice", "HR", 5000.0));
        list.add(new Employee("Bob", "IT", 6000.0));
        list.add(new Employee("Charlie", "Finance", 5500.0));
        list.add(new Employee("Diana", "Marketing", 5200.0));
        list.add(new Employee("Ethan", "IT", 6200.0));
        list.add(new Employee("Fiona", "HR", 5100.0));
        list.add(new Employee("George", "Finance", 5800.0));
        list.add(new Employee("Hannah", "Marketing", 5400.0));
        list.add(new Employee("Ian", "IT", 6300.0));
        list.add(new Employee("Jack", "Finance", 5900.0));
        list.add(new Employee("Karen", "HR", 5050.0));
        list.add(new Employee("Liam", "IT", 6150.0));
        list.add(new Employee("Mia", "Marketing", 5250.0));
        list.add(new Employee("Noah", "Finance", 6000.0));
        list.add(new Employee("Olivia", "HR", 5100.0));
        list.add(new Employee("Peter", "IT", 6400.0));
        list.add(new Employee("Quinn", "Marketing", 5300.0));
        list.add(new Employee("Rachel", "Finance", 5950.0));
        list.add(new Employee("Sam", "HR", 5000.0));
        list.add(new Employee("Tina", "IT", 6200.0));
        list.add(new Employee("Uma", "Marketing", 5350.0));
        list.add(new Employee("Victor", "Finance", 6100.0));
        list.add(new Employee("Wendy", "HR", 5150.0));
        list.add(new Employee("Xavier", "IT", 6250.0));
        list.add(new Employee("Yara", "Marketing", 5400.0));
        list.add(new Employee("Zane", "Finance", 6050.0));

        return list;
    }

    public void updateEmp(int id, Employee emp) {
        Employee employee = empMap.get(id);
        employee.setName(emp.getName());
        employee.setSalary(emp.getSalary());
        employee.setDepartment(emp.getDepartment());

    }

}
