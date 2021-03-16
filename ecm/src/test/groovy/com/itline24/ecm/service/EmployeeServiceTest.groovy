package com.itline24.ecm.service

import com.itline24.ecm.dto.EmployeeDto
import com.itline24.ecm.entity.EmployeeEntity
import com.itline24.ecm.repositories.EmployeeRepository
import spock.lang.Specification

class EmployeeServiceTest extends Specification {

    def EmployeeService employeeService

    def EmployeeRepository employeeRepository;

    def setup() {
        employeeRepository = Mock(EmployeeRepository);
        employeeService = new EmployeeService(employeeRepository:employeeRepository);
    }

    def "Add a employee with happy path scenario" () {
        given :
        //You need a payload data
        EmployeeDto employeeDto =
                EmployeeDto.builder()
                .emailAddress("emp1@temp.com")
                .firstName("emp1")
                .lastName("lName")
                .active(true)
                .countryCode(1)
                .mobile(1234567890)
                .address("XYZ Street")
                .nickName("TestEmp1")
                .status(true)
                .shortDesc("Test Profile for employee as a java full stack")
                .keyTechStack("JAVA, Spring boot, AngularJS")
                .autoExp("9")
                        .build();

        when :
    employeeService.employee(employeeDto)

        then :
        1 * employeeRepository.save(_)
        //validate all data is saved as expected
    }

    def "Update a existing employee " () {
        given :
        //You need a payload data
        EmployeeDto employeeDto =
                EmployeeDto.builder()
                .employeeId(10)
                        .emailAddress("emp1@temp.com")
                        .firstName("emp1")
                        .lastName("lName")
                        .active(true)
                        .countryCode(1)
                        .mobile(1234567890)
                        .address("XYZ Street")
                        .nickName("TestEmp1")
                        .status(true)
                        .shortDesc("Test Profile for employee as a java full stack")
                        .keyTechStack("JAVA, Spring boot, AngularJS")
                        .autoExp("9")
                        .build();
        EmployeeEntity saved = EmployeeEntity.builder().build();
        when :
        saved = employeeService.employee(employeeDto)

        then :
        1 * employeeRepository.findEmployeeEntityByEmployeeId(employeeDto.getEmployeeId()) >> saved
        1 * employeeRepository.save(_) >> saved
        saved.getFirstName() == "emp1"
        saved.getLastName() == "lName"
        saved.getNickName() == "TestEmp1"
        saved.getActive() == false
        saved.getEmployeeId() == 10
        //validate all data is saved as expected
    }
}
