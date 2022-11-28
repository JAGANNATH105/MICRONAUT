package com.example.services;

import com.example.entities.Employee;
import com.example.repositories.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){

        return  (List<Employee>) employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){

        return employeeRepository.save(employee);
    }


    public Employee update(Employee employee, int id){
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee e = optional.get();

        if(e != null){
            e.setName(employee.getName());
            e.setAge(employee.getAge());
            e.setSal(employee.getSal());
            e.setEmail(employee.getEmail());
            e.setJoiningDate(employee.getJoiningDate());
            e.setDepartment(employee.getDepartment());

            return employeeRepository.save(e);
        }
        else {
            return null;
        }
    }

    public String deleteById(int id){
         Optional<Employee> employee = employeeRepository.findById(id);
         Employee e = employee.get();
         if(e != null){
             employeeRepository.deleteById(id);
             return "Deleted employee by id "+id;
         }
         else{
             return "Employee with id"+id+" not found";
         }
    }
}
