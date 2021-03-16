package com.itline24.ecm.controller;


import com.itline24.ecm.dto.EmployeeDto;
import com.itline24.ecm.entity.EmployeeEntity;
import com.itline24.ecm.entity.EmployeeResumeEntity;
import com.itline24.ecm.repositories.EmployeeRepository;
import com.itline24.ecm.repositories.EmployeeResumeRepository;
import com.itline24.ecm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

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

    @PostMapping("employee")
    public void employeeAdd(@RequestBody
                         EmployeeDto employeeDto) {
        employeeService.employee(employeeDto);
    }

    @PutMapping("employee")
    public void employeeUpdate(@RequestBody
                                 EmployeeDto employeeDto) {
        employeeService.employee(employeeDto);
    }
}
