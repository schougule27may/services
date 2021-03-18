package com.itline24.ecm.service;

import com.itline24.ecm.dto.MasterRatesDto;
import com.itline24.ecm.entity.MasterRatesEntity;
import com.itline24.ecm.repositories.MasterRatesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterService {

    @Autowired
    MasterRatesRepository masterRatesRepository;

    public List<MasterRatesDto> getMasterRates() {
        List<MasterRatesDto> masterRatesDtos = new ArrayList<>();
        masterRatesRepository.findAll().forEach(masterRate -> {
            MasterRatesDto masterRatesDto = new MasterRatesDto();
            BeanUtils.copyProperties(masterRate, masterRatesDto);
            masterRatesDtos.add(masterRatesDto);
             }
        );
        return masterRatesDtos;
    }

    public void masterRates(MasterRatesDto masterRatesDto) {
        MasterRatesEntity masterRatesEntity
                 = new MasterRatesEntity();
        if(masterRatesDto.getMasterRatesId() > 0 ) {
            masterRatesEntity = masterRatesRepository.findById(masterRatesDto.getMasterRatesId()).get();
        }
        BeanUtils.copyProperties(masterRatesDto,masterRatesEntity);
        masterRatesRepository.save(masterRatesEntity);

    }
}
