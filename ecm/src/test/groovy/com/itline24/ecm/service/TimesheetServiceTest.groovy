package com.itline24.ecm.service

import com.itline24.ecm.dto.TimeSheetDto
import com.itline24.ecm.entity.ClientEntity
import com.itline24.ecm.entity.EmployeeEntity
import com.itline24.ecm.repositories.ClientRepository
import com.itline24.ecm.repositories.EmployeeRepository
import com.itline24.ecm.repositories.TimeSheetRepository
import spock.lang.Specification

class TimesheetServiceTest extends Specification {

    def TimesheetService timesheetService;

    def  TimeSheetRepository timeSheetRepository;
    def  ClientRepository clientRepository;
    def  EmployeeRepository employeeRepository;

    def setup() {
        timeSheetRepository = Mock(TimeSheetRepository);
        clientRepository = Mock(ClientRepository);
        employeeRepository = Mock(EmployeeRepository);
        timesheetService  = new TimesheetService(timeSheetRepository: timeSheetRepository
        , clientRepository: clientRepository, employeeRepository: employeeRepository);
    }

    def "Happy path Add timesheet from employee to client" () {

        given :


        TimeSheetDto timeSheetDto = TimeSheetDto.builder()
                .noOfHours(4)
        .employeeId(1)
        .detailsEod("John 08-March-2021:\\n1.  Completed user integration.")
        .clientId(1)
                .build();
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientId(1)
        clientEntity.setNickName("Smith")

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setNickName("ABC")
        employeeEntity.setEmployeeId(1)
        when :
            timesheetService.employeeTimesheet(timeSheetDto);
        then:

         1* clientRepository.findByClientId(_) >> clientEntity
         1 * employeeRepository.findEmployeeEntityByEmployeeId(_) >> employeeEntity
         1 * timeSheetRepository.save(_)

    }
}
