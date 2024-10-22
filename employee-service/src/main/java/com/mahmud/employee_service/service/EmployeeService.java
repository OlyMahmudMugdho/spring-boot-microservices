package com.mahmud.employee_service.service;

import com.mahmud.employee_service.dto.Department;
import com.mahmud.employee_service.dto.EmployeeResponse;
import com.mahmud.employee_service.model.Employee;
import com.mahmud.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public EmployeeResponse getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + id, Department.class);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        assert employee != null;
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setDepartment(department);
        return employeeResponse;
    }
}
