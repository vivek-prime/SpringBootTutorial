package com.example.SpringBootTutorial.controller;

import com.example.SpringBootTutorial.entity.Department;
import com.example.SpringBootTutorial.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveAll")
    public List<Department> saveMultipleDepartments(@Valid @RequestBody List<Department> departmentList) {
        log.info("All records are inserted");
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
        log.info("departmentId - {}", departmentId);
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{deptId}")
    public Department updateDepartmentNameById(@PathVariable("deptId") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartmentNameById(departmentId, department);
    }

    //    using @RequestParam
    @GetMapping("/departments/name")
    public ResponseEntity<List<Department>> fetchDepartmentUsingName(@RequestParam(name = "deptName", defaultValue = "CSE") String deptName) {
        log.info("deptName - {}", deptName);
        List<Department> departmentList = departmentService.fetchDepartmentUsingName(deptName);
//        return ResponseEntity.ok().body(departmentList);
        return new ResponseEntity<>(departmentList, HttpStatus.valueOf(200));
    }
}
