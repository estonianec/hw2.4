package com.estonianec.hw2dot4.services.impl;

import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;
import com.estonianec.hw2dot4.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<String> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public List<String> showAllEmployees() {
        return employees;
    }

    public String makeFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Override
    public void addEmployee (String firstName, String lastName){
        String fullName = makeFullName(firstName, lastName);
        employees.add(fullName);
    }

    @Override
    public String delEmployee(String firstName, String lastName) {
        String fullName = makeFullName(firstName, lastName);
        if (employees.contains(fullName)) {
            employees.remove(fullName);
            return fullName;
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String fullName = makeFullName(firstName, lastName);
        if (employees.contains(fullName)) {
            return fullName;
        } else throw new EmployeeNotFoundException();
    }
}

