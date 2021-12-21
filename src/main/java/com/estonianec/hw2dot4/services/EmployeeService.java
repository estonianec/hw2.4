package com.estonianec.hw2dot4.services;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.exceptions.EmployeeArrayOverflowException;
import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;

import java.util.Map;

public interface EmployeeService {

    Map<String, Employee> showAllEmployees();
    void addEmployee(String firstName, String lastName) throws EmployeeArrayOverflowException;
    String delEmployee(String firstName, String lastName);
    String findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

}
