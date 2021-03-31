package com.itline24.ecm.controller;

import com.itline24.ecm.dto.TimeSheetDetailsDto;
import com.itline24.ecm.dto.TimeSheetDto;
import com.itline24.ecm.repositories.TimeSheetRepository;
import com.itline24.ecm.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeSheetController {

    @Autowired
    TimeSheetRepository timeSheetRepository;

    @Autowired
    TimesheetService  timesheetService;

    @GetMapping(value = "timesheet")
    public List<TimeSheetDto> getTimeSheet(){
        List<TimeSheetDto>  timeSheetDtos = new ArrayList<>();
        timeSheetRepository.findAll().forEach(timeSheet-> {
            TimeSheetDto timeSheetDto  = new TimeSheetDto();
            timeSheetDto.setClientId(timeSheet.getClientByClientId().getClientId());
            timeSheetDto.setDetailsEod(timeSheet.getDetailsEod());
            timeSheetDto.setNoOfHours(timeSheet.getNoOfHours());
            timeSheetDto.setStatus(timeSheet.getStatus());
            timeSheetDtos.add(timeSheetDto);

        });
        return timeSheetDtos;
    }

    @PostMapping(value = "timesheet")
    public void addEmployeeTimesheet(@RequestBody TimeSheetDto timeSheetDto) {
        timesheetService.employeeTimesheet(timeSheetDto);
    }




    @GetMapping(value = "timesheet/client/{clientId}/{status}")
    public List<TimeSheetDetailsDto> getEmployeeTimesheets(@PathVariable(value = "clientId") int clientId, @PathVariable(value = "status") String status) {
       return timesheetService.getEmployeeTimesheets(clientId, status);
    }

}
