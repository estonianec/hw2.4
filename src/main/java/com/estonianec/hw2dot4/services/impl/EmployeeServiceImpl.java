package com.estonianec.hw2dot4.services.impl;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;
import com.estonianec.hw2dot4.exceptions.EmployeeWrongParamsException;
import com.estonianec.hw2dot4.services.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Map<String, Employee> showAllEmployees() {
        return employees;
    }

    public String makeFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Override
    public void addEmployee(String firstName, String lastName, int salary, int departmentId) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
            String fullName = makeFullName(firstName, lastName);
            Employee employee = new Employee(firstName, lastName, salary, departmentId);
            if (!employees.containsKey(fullName)) {
                employees.put(fullName, employee);
            } else throw new IllegalArgumentException();
        } else throw new EmployeeWrongParamsException();
    }
//    http://localhost:8080/employee/add?firstName=asd&lastName=as1f&salary=12&departmentId=1

    @Override
    public String delEmployee(String firstName, String lastName) {
        String fullName = makeFullName(firstName, lastName);
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
            return fullName;
        } else throw new EmployeeNotFoundException();
    }

    @Override
    public String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        String fullName = makeFullName(firstName, lastName);
        if (employees.containsKey(fullName)) {
            return fullName;
        } else throw new EmployeeNotFoundException();
    }

}

