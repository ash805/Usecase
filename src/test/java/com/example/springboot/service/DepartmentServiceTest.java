package com.example.springboot.service;

import com.example.springboot.entity.Department;
import com.example.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hibernate.sql.results.LoadingLogger.LOGGER;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("CHENNAI")
                        .departmentCode("IT-01")
                        .departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Department Based On a Valid DepartmentName")
    @Disabled
    public void whenValidDepartmentNameThenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found =
                departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());



    }
}