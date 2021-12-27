package com.estonianec.hw2dot4.controllers;

import com.estonianec.hw2dot4.data.Employee;
import com.estonianec.hw2dot4.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryInDepartment(@RequestParam("departmentId") int idDepartment) {
        return departmentService.findEmployeeWithMaxSalaryInDepartment(idDepartment);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryInDepartment(@RequestParam("departmentId") int idDepartment) {
        return departmentService.findEmployeeWithMinSalaryInDepartment(idDepartment);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> showAllEmployeesFromDepartment(@RequestParam("departmentId" ) int idDepartment) {
        return departmentService.showAllEmployeesFromDepartment(idDepartment);
    }

    @GetMapping("/all")
    public Collection<Employee> showAllEmployees() {
        return departmentService.showAllEmployees();
    }

}
