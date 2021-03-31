package com.itline24.ecm.repositories;

import com.itline24.ecm.entity.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

    List<ClientEntity> findAllByActiveIsTrue();

    ClientEntity findByClientId(int clientId);
}
