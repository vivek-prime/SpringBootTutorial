package com.example.SpringBootTutorial.controller;

import com.example.SpringBootTutorial.entity.Department;
import com.example.SpringBootTutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveAll")
    public List<Department> saveMultipleDepartments(@Valid @RequestBody List<Department> departmentList) {
        return departmentService.saveMultipleDepartments(departmentList);
    }

    @PostMapping("/save")
    public Department saveDept(@Valid @RequestBody Department department) {
        return departmentService.saveDept(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments() {
        return departmentService.fetchDepartments();
    }

    /**
     * when using "PathVariable", same var name should be used in params as in url
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

    @PutMapping("/departments/{deptId}")
    public Department updateDepartmentNameById(@PathVariable("deptId") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartmentNameById(departmentId, department);
    }

    @GetMapping("/departments/name/{deptName}")
    public List<Department> fetchDepartmentUsingName(@PathVariable("deptName") String deptName) {
        return departmentService.fetchDepartmentUsingName(deptName);
    }
}
