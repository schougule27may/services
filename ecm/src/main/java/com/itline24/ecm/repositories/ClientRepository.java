package com.itline24.ecm.repositories;

import com.itline24.ecm.entity.Books;
import com.itline24.ecm.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
}
