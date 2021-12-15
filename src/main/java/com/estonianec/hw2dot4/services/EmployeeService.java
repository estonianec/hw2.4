package com.estonianec.hw2dot4.services;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.exceptions.EmployeeArrayOverflowException;
import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

    Employee[] showAllEmployees();
    void addEmployee(String firstName, String lastName) throws EmployeeArrayOverflowException;
    Employee[] delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

}
