package com.estonianec.hw2dot4.services;

import com.estonianec.hw2dot4.data.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryInDepartment(int idDepartment);
    Employee findEmployeeWithMinSalaryInDepartment(int idDepartment);
    Collection<Employee> showAllEmployeesFromDepartment(int idDepartment);
    Collection<Employee> showAllEmployees();
}
