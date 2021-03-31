package com.itline24.ecm.repositories;


import com.itline24.ecm.entity.TimeSheetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeSheetRepository extends CrudRepository<TimeSheetEntity, Integer> {

    List<TimeSheetEntity> findByClientByClientId_ClientIdAndStatus(Integer clientId, String status);

}
