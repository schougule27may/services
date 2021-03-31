package com.itline24.ecm.service;

import com.itline24.ecm.dto.EmployeeDto;
import com.itline24.ecm.entity.EmployeeEntity;
import com.itline24.ecm.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeEntity employee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder().build();

        if(employeeDto.getEmployeeId() > 0) {
            employeeEntity =  employeeRepository.findEmployeeEntityByEmployeeId(employeeDto.getEmployeeId());
        }
        BeanUtils.copyProperties(employeeDto, employeeEntity);
        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        return saved;
    }
}
