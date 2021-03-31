package com.itline24.ecm.service;


import com.itline24.ecm.dto.TimeSheetDetailsDto;
import com.itline24.ecm.dto.TimeSheetDto;
import com.itline24.ecm.entity.ClientEntity;
import com.itline24.ecm.entity.EmployeeEntity;
import com.itline24.ecm.entity.TimeSheetEntity;
import com.itline24.ecm.repositories.ClientRepository;
import com.itline24.ecm.repositories.EmployeeRepository;
import com.itline24.ecm.repositories.TimeSheetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService  {

    @Autowired
    TimeSheetRepository timeSheetRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public void employeeTimesheet(TimeSheetDto timeSheetDto) {

        ClientEntity clientEntity = clientRepository.findByClientId(timeSheetDto.getClientId());
        EmployeeEntity
                employeeEntity = employeeRepository.findEmployeeEntityByEmployeeId(timeSheetDto.getEmployeeId());
        TimeSheetEntity timeSheetEntity = new TimeSheetEntity();
        BeanUtils.copyProperties(timeSheetDto, timeSheetEntity);

        timeSheetEntity.setEmployeeByEmployeeId(employeeEntity);
        timeSheetEntity.setClientByClientId(clientEntity);
        timeSheetEntity.setStatus("Pending");
        timeSheetRepository.save(timeSheetEntity);

        // send email
        // send sms
        // reminder
        // validation - duplicate

    }

    public  List<TimeSheetDetailsDto> getEmployeeTimesheets(int clientId, String status) {
      List<TimeSheetEntity> timeSheetEntityList =   timeSheetRepository.findByClientByClientId_ClientIdAndStatus(clientId, status);
        List<TimeSheetDetailsDto> timeSheetDetailsDtos  =new ArrayList<>();

        for(TimeSheetEntity timeSheet : timeSheetEntityList) {
            TimeSheetDetailsDto timeSheetDto  = new TimeSheetDetailsDto();
            timeSheetDto.setClientId(timeSheet.getClientByClientId().getClientId());
            timeSheetDto.setDetailsEod(timeSheet.getDetailsEod());
            timeSheetDto.setNoOfHours(timeSheet.getNoOfHours());
            timeSheetDto.setStatus(timeSheet.getStatus());
            timeSheetDto.setEmployeeName(timeSheet.getEmployeeByEmployeeId().getFirstName().concat(" ").concat(timeSheet.getEmployeeByEmployeeId().getLastName()));
            timeSheetDetailsDtos.add(timeSheetDto);
        }
      return timeSheetDetailsDtos;
    }
}
