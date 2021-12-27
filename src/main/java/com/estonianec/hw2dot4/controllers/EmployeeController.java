package com.estonianec.hw2dot4.controllers;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Map<String, Employee> showAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String delEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        String fullName = employeeService.delEmployee(firstName, lastName);
        return "Сотрудник " + fullName + " удален.";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("salary") int salary,
                              @RequestParam("departmentId") int departmentId) {
        employeeService.addEmployee(firstName, lastName, salary, departmentId);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан.";
    }
}
