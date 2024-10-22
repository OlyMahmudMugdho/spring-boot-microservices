package com.mahmud.department_service.service;

import com.mahmud.department_service.model.Department;
import com.mahmud.department_service.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
