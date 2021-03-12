package com.itline24.ecm.repositories;


import com.itline24.ecm.entity.TimeSheetEntity;
import org.springframework.data.repository.CrudRepository;

public interface TimeSheetRepository extends CrudRepository<TimeSheetEntity, Integer> {
}
