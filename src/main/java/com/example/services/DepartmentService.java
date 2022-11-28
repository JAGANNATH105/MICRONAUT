package com.example.services;


import com.example.entities.Department;
import com.example.repositories.DepartmentRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class DepartmentService {
    @Inject
    DepartmentRepository departmentRepository;

    public List<Department> getDepartment(){

        return  (List<Department>) departmentRepository.findAll();
    }

    public Department addDepartment(Department department){

        return departmentRepository.save(department);
    }


    public Department update(Department department, int id){
        Optional<Department> optional = departmentRepository.findById(id);
        Department e = optional.get();

        if(e != null){
            e.setDepartmentId(department.getDepartmentId());
            e.setDepartmentName(department.getDepartmentName());


            return departmentRepository.save(e);
        }
        else {
            return null;
        }
    }

    public String deleteById(int id){
        Optional<Department> department = departmentRepository.findById(id);
        Department e = department.get();
        if(e != null){
            departmentRepository.deleteById(id);
            return "Deleted department by id "+id;
        }
        else{
            return "Department with id"+id+" not found";
        }
    }
}
