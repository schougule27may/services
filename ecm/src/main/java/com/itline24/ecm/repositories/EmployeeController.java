package com.itline24.ecm.repositories;


import com.itline24.ecm.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "employees")
    public List<EmployeeEntity> getEmployees(){
        List<EmployeeEntity> employeeEntities
                  = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeEntity ->
                employeeEntities.add(employeeEntity) );
        return employeeEntities;
    }
}
