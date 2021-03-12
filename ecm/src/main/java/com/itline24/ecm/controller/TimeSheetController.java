package com.itline24.ecm.controller;

import com.itline24.ecm.dto.TimeSheetDto;
import com.itline24.ecm.entity.TimeSheetEntity;
import com.itline24.ecm.repositories.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeSheetController {

    @Autowired
    TimeSheetRepository timeSheetRepository;

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

}
