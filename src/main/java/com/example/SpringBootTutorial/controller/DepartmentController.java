package com.example.SpringBootTutorial.controller;

import com.example.SpringBootTutorial.entity.Department;
import com.example.SpringBootTutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveAll")
    public List<Department> saveMultipleDepartments(@RequestBody List<Department> departmentList) {
        return departmentService.saveMultipleDepartments(departmentList);
    }

    @PostMapping("/save")
    public Department saveDept(@RequestBody Department department) {
        return departmentService.saveDept(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments() {
        return departmentService.fetchDepartments();
    }

    /**
     * when using PathVariable, same var name should be used in params as in url
     */
    @GetMapping("/departments/{deptId}")
    public List<Department> fetchDepartmentById(@PathVariable("deptId") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{deptId}")
    public String deleteDepartmentById(@PathVariable("deptId") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
}
