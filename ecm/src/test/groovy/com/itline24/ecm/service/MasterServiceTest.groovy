package com.itline24.ecm.service

import com.itline24.ecm.dto.MasterRatesDto
import com.itline24.ecm.entity.MasterRatesEntity
import com.itline24.ecm.repositories.MasterRatesRepository
import spock.lang.Specification

class MasterServiceTest  extends Specification {


    def MasterRatesRepository masterRatesRepository;
    def MasterService masterService
    def setup() {
        masterRatesRepository= Mock(MasterRatesRepository);
        masterService = new MasterService(masterRatesRepository:masterRatesRepository)
    }

    def "Get Master Rates" () {

        given:

        List<MasterRatesEntity> masterRatesEntities = new ArrayList<>();
        MasterRatesEntity masterRatesEntity1 = new MasterRatesEntity();
        masterRatesEntity1.setAmount(15);
        masterRatesEntity1.setType("Hourly");
        masterRatesEntities.add(masterRatesEntity1);

        MasterRatesEntity masterRatesEntity2 = new MasterRatesEntity();
        masterRatesEntity1.setAmount(100);
        masterRatesEntity1.setType("Daily");
        masterRatesEntities.add(masterRatesEntity2);

        when:
        List<MasterRatesDto> masterRatesDtos   =  masterService.getMasterRates();
        then:
        1 * masterRatesRepository.findAll()
    }
}
