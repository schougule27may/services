package com.itline24.ecm.repositories;

import com.itline24.ecm.entity.MasterRatesEntity;
import org.springframework.data.repository.CrudRepository;

public interface MasterRatesRepository extends
        CrudRepository <MasterRatesEntity,Integer> {

}
