package com.example.SpringBootTutorial.controllerTest;

import com.example.SpringBootTutorial.entity.Department;
import com.example.SpringBootTutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @MockBean
    private DepartmentService departmentService;
    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .deptId(1L)
                .deptName("CSE")
                .deptAddress("Kolkata")
                .deptCode("CSE-100")
                .build();
        Mockito.when(departmentService.saveDept(Mockito.any(Department.class))).thenReturn(department);
    }

    @Test
    void saveDept() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"deptName\": \"CSE\",\n" +
                        "    \"deptAddress\": \"Kolkata\",\n" +
                        "    \"deptCode\": \"CSE-100\"\n" +
                        "  }"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}