package com.example.springboot.controller;

import com.example.springboot.entity.Department;
import com.example.springboot.error.DepartmentNotFoundException;
import com.example.springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;



    private  final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("Inside Save Department DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList()
    {
        LOGGER.info("Inside Get Department DepartmentController");
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside Get DepatrmnetById  DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        LOGGER.info("Inside Delete Department DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                        @RequestBody Department department)
    {
        LOGGER.info("Inside Update Department DepartmentController");
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName)
    {
        LOGGER.info("Inside FindDepartmentByName Department DepartmentController");
        return departmentService.getDepartmentByName(departmentName);
    }

}
