package com.itline24.ecm.controller;


import com.itline24.ecm.entity.EmployeeEntity;
import com.itline24.ecm.entity.EmployeeResumeEntity;
import com.itline24.ecm.repositories.EmployeeRepository;
import com.itline24.ecm.repositories.EmployeeResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeResumeRepository employeeResumeRepository;

    @GetMapping(value = "employees")
    public List<EmployeeEntity> getEmployees(){
        List<EmployeeEntity> employeeEntities
                  = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeEntity ->
                employeeEntities.add(employeeEntity) );
        return employeeEntities;
    }

    @GetMapping(value = "employees/resume")
    public List<EmployeeResumeEntity> getEmployeeResumes(){
        List<EmployeeResumeEntity> employeeResumeEntities
                = new ArrayList<>();
        employeeResumeRepository.findAll().forEach(employeeResumeEntity ->
                employeeResumeEntities.add(employeeResumeEntity) );
        return employeeResumeEntities;
    }
}
