package com.example.SpringBootTutorial.service;

import com.example.SpringBootTutorial.entity.Department;
import com.example.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> saveMultipleDepartments(List<Department> departmentList) {
        return departmentRepository.saveAll(departmentList);
    }

    @Override
    public Department saveDept(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> fetchDepartmentById(Long departmentId) {
        return departmentRepository.findAllById(Collections.singleton(departmentId));
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteAllById(Collections.singleton(departmentId));
    }
}
