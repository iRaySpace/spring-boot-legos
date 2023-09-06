package com.example.demo.employee;

import java.util.List;
import java.util.LinkedList;

import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private List<Employee> employees = new LinkedList<Employee>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    } 
}
