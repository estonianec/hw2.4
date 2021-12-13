package com.estonianec.hw2dot4;

public interface EmployeeService {

    Employee[] showAllEmployees();
    Employee[] addEmployee(String firstName, String lastName) throws EmployeeArrayOverflow;
    Employee[] delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFound;

}
