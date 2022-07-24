package com.example.SpringBootTutorial.service;

import com.example.SpringBootTutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> saveMultipleDepartments(List<Department> departmentList);

    Department saveDept(Department department);

    List<Department> fetchDepartments();

    List<Department> fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentNameById(Long departmentId, Department department);

    List<Department> fetchDepartmentUsingName(String deptName);
}
