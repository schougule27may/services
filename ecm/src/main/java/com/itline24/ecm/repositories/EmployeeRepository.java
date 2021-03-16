package com.itline24.ecm.repositories;


import com.itline24.ecm.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {


    EmployeeEntity findEmployeeEntityByEmployeeId(int employeeId);
}
