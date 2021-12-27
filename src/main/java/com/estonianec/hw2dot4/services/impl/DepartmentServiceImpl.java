package com.estonianec.hw2dot4.services.impl;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;
import com.estonianec.hw2dot4.services.DepartmentService;
import com.estonianec.hw2dot4.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(int idDepartment) {
        return employeeService.showAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId() == idDepartment)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmployeeWithMinSalaryInDepartment(int idDepartment) {
        return employeeService.showAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId() == idDepartment)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> showAllEmployeesFromDepartment(int idDepartment) {
        return employeeService.showAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId() == idDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Employee> showAllEmployees() {
        return employeeService.showAllEmployees().values().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}
