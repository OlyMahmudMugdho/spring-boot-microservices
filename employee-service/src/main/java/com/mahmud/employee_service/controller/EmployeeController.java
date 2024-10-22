package com.mahmud.employee_service.controller;

import com.mahmud.employee_service.model.Employee;
import com.mahmud.employee_service.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/employee/", "/employee"})
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
