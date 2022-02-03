package com.estonianec.hw2dot4.services.impl;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.exceptions.EmployeeNotFoundException;
import com.estonianec.hw2dot4.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    Map<String, Employee> employees = new HashMap<>();
        Employee employee1 = new Employee("Евгений", "Васин", 135_000, 1);
        Employee employee2 = new Employee("Светлана", "Васина", 130_000, 1);
        Employee employee3 = new Employee("Алла", "Попова", 56_000, 2);
        Employee employee4 = new Employee("Григорий", "Попов", 45_000, 2);
        Employee employee5 = new Employee("Наталья", "Васина", 45_000, 3);
        Employee employee6 = new Employee("Юрий", "Васин", 135_000, 3);

    @BeforeEach
    private void setUp() {
        when(employeeServiceMock.showAllEmployees()).thenReturn(employees);
        employees.put("Евгений Васин", employee1);
        employees.put("Светлана Васина", employee2);
        employees.put("Алла Попова", employee3);
        employees.put("Григорий Попов", employee4);
        employees.put("Наталья Васина", employee5);
        employees.put("Юрий Васин", employee6);
    }

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    DepartmentServiceImpl out;

    @Test
    void findEmployeeWithMaxSalaryInDepartment() {
        assertEquals(employees.get("Евгений Васин"), out.findEmployeeWithMaxSalaryInDepartment(1));
    }

    @Test
    void findEmployeeWithMaxSalaryInNotExistDepartment() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryInDepartment(9));
    }

    @Test
    void findEmployeeWithMinSalaryInDepartment() {
        assertEquals(employees.get("Григорий Попов"), out.findEmployeeWithMinSalaryInDepartment(2));
    }

    @Test
    void findEmployeeWithMinSalaryInNotExistDepartment() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryInDepartment(9));
    }

    @Test
    void showAllEmployeesFromDepartment() {
        List<Employee> expected = new ArrayList<>();
        expected.add(employee5);
        expected.add(employee6);
        assertEquals(expected, out.showAllEmployeesFromDepartment(3));
    }

    @Test
    void showAllEmployeesFromNotExistDepartment() {
        Collection<Employee> result = out.showAllEmployeesFromDepartment(9);
        assertEquals(EMPTY_LIST, result);
    }

    @Test
    void showAllEmployees() {
        List<Employee> expected = new ArrayList<>();
        expected.add(employee1);
        expected.add(employee2);
        expected.add(employee4);
        expected.add(employee3);
        expected.add(employee5);
        expected.add(employee6);
        assertEquals(expected, out.showAllEmployees());
    }
}