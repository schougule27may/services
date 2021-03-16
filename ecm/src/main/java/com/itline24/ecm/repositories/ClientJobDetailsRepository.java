package com.itline24.ecm.repositories;


import com.itline24.ecm.entity.ClientJobDetailsEntity;
import org.springframework.data.repository.CrudRepository;



public interface ClientJobDetailsRepository extends CrudRepository<ClientJobDetailsEntity, Integer> {

    ClientJobDetailsEntity findByClientByClientId_ClientId(int clientId);
}
