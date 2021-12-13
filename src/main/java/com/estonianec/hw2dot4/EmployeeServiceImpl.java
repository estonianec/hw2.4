package com.estonianec.hw2dot4;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Employee[] employees;

    public EmployeeServiceImpl() {
        employees = new Employee[10];
    }

    @Override
    public Employee[] showAllEmployees() {
        return employees;
    }

    @Override
    public Employee[] addEmployee (String firstName, String lastName) throws EmployeeArrayOverflow {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return employees;
            }
        }
        throw new EmployeeArrayOverflow("Массив сотрудников переполнен.");
    }

    private int indexOfEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null){
                if (employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName)) {
                    return i;
                }
            }
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee[] delEmployee(String firstName, String lastName) {
        int index = indexOfEmployee(firstName, lastName);
                    employees[index] = null;
                    return employees;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFound {
        int index = indexOfEmployee(firstName, lastName);
        return employees[index];
    }
}

