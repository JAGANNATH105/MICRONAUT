package com.example.controllers;

import com.example.entities.Department;

import com.example.services.DepartmentService;

import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;
@Controller("/department")
public class DepartmentController {

    @Inject
    DepartmentService departmentService;

    @Get("/show")
    public List<Department> getDepartment(){

        return departmentService.getDepartment();
    }

    @Post("/add")
    public Department addDepartment(@Body Department department){

        return departmentService.addDepartment(department);
    }

    @Transactional
    @Put("/edit/{id}")
    public Department update(@Body Department department, @PathVariable int id){
        return departmentService.update(department,id);
    }

    @Delete("/delete/{id}")
    public String deleteById(@PathVariable int id){

        return departmentService.deleteById(id);
    }
}
