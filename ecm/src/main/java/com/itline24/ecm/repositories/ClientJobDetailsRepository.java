package com.itline24.ecm.repositories;


import com.itline24.ecm.entity.ClientJobDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ClientJobDetailsRepository extends CrudRepository<ClientJobDetailsEntity, Integer> {

    List<ClientJobDetailsEntity> findByClientByClientId_ClientId(int clientId);
}
