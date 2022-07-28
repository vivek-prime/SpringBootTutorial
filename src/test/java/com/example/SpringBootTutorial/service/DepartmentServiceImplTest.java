package com.example.SpringBootTutorial.service;

import com.example.SpringBootTutorial.entity.Department;
import com.example.SpringBootTutorial.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Mockito.when(departmentRepository.findAllById(Mockito.any())).
                thenReturn(mockDepartmentList());
    }

    private List<Department> mockDepartmentList() {
        List<Department> departmentList = new ArrayList<>();
        Department department = Department.builder()
                .deptId(1L)
                .deptName("CSE")
                .deptAddress("Asansol")
                .deptCode("CSE-100")
                .build();
        departmentList.add(department);
        return departmentList;
    }

    @Test
    @DisplayName("Get Department when deptId is found")
    void testFetchDepartmentWhenItIsFound() {
        assertEquals(departmentService.fetchDepartmentById(1L).size(), 1);
    }
}