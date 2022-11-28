package com.example.controllers;

import com.example.entities.Employee;
import com.example.services.EmployeeService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;

@Controller("/employee")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;

    @Get("/show")
    public List<Employee> getEmployees(){

        return employeeService.getEmployees();
    }

    @Post("/add")
    public Employee addEmployee(@Body Employee employee){

        return employeeService.addEmployee(employee);
    }

    @Transactional
    @Put("/edit/{id}")
    public Employee update(@Body Employee employee, @PathVariable int id){
        return employeeService.update(employee,id);
    }

    @Delete("/delete/{id}")
    public String deleteById(@PathVariable int id){

        return employeeService.deleteById(id);
    }
}
