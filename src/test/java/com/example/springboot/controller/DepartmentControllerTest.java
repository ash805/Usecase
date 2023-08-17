package com.example.springboot.controller;

import com.example.springboot.entity.Department;
import com.example.springboot.service.DepartmentService;
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

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp()
    {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("CSE")
                .departmentCode("CSE-03")
                .departmentAddress("CHENNAI")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentId(1L)
                .departmentName("CSE")
                .departmentCode("CSE-03")
                .departmentAddress("CHENNAI")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"departmentId\":\"4\",\n" +
                        "\"departmentName\":\"CSE\",\n" +
                        "\"departmentAddress\" : \"CHENNAI\",\n" +
                        "\"departmentCode\" : \"CSE-03\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() {
    }
}