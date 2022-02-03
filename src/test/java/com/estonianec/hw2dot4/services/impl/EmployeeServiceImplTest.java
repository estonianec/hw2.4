package com.estonianec.hw2dot4.services.impl;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;
import com.estonianec.hw2dot4.exceptions.EmployeeWrongParamsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.estonianec.hw2dot4.constants.EmployeeServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeServiceImplTest {
    String result;
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    void makeFullNameTest() {
        result = out.makeFullName(FIRST_NAME, LAST_NAME);
        assertEquals(FIRST_NAME + " " + LAST_NAME, result);
    }

    @Test
    void addEmployeeTest() {
        out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        out.findEmployee(FIRST_NAME, LAST_NAME);
    }
    @Test
    void addEmployeeTwiceTest() {
        out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID));
    }

    @Test
    void addEmployeeWithNegativeDepartmentID() {
        Assertions.assertThrows(EmployeeWrongParamsException.class, () -> out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, -3));
    }

    @Test
    void addEmployeeWithNegativeSalary() {
        Assertions.assertThrows(EmployeeWrongParamsException.class, () -> out.addEmployee(FIRST_NAME, LAST_NAME, -10_000, DEPARTMENT_ID));
    }

    @Test
    void delEmployeeTest() {
        out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        out.delEmployee(FIRST_NAME, LAST_NAME);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    void delNotExistEmployee() {
        Assertions.assertThrows((EmployeeNotFoundException.class), () -> out.delEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    void findEmployeeTest() {
        out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        out.findEmployee(FIRST_NAME, LAST_NAME);
    }
    @Test
    void findNotExistEmployee() {
        Assertions.assertThrows((EmployeeNotFoundException.class), () -> out.findEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    void showAllEmployeesTest() {
        out.addEmployee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        out.addEmployee("FIRSTNAME", "LASTNAME", SALARY, DEPARTMENT_ID);
        Map<String, Employee> result = out.showAllEmployees();
        Employee employee1 = new Employee(FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID);
        Employee employee2 = new Employee("FIRSTNAME", "LASTNAME", SALARY, DEPARTMENT_ID);
        Map<String, Employee> expected = new HashMap<>();
        expected.put(FIRST_NAME + " " + LAST_NAME, employee1);
        expected.put("FIRSTNAME LASTNAME", employee2);
        assertEquals(result.size(), expected.size());
        expected.equals(result);
    }
}