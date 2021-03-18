package com.itline24.ecm.controller;

import com.itline24.ecm.dto.MasterRatesDto;
import com.itline24.ecm.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MasterController {

    @Autowired
    MasterService masterService;

    @GetMapping(value = "master/rates")
    public List<MasterRatesDto> getAllMasterRates() {
        return masterService.getMasterRates();
    }

    @PostMapping(value = "master/rates")
    public List<MasterRatesDto> addMasterRates(@RequestBody MasterRatesDto masterRatesDto) {
        masterService.masterRates(masterRatesDto);
        return masterService.getMasterRates();
    }

    @PutMapping(value = "master/rates")
    public List<MasterRatesDto> updateMasterRates(@RequestBody MasterRatesDto masterRatesDto) {
        masterService.masterRates(masterRatesDto);
        return masterService.getMasterRates();
    }
}
