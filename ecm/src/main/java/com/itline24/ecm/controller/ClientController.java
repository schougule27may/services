package com.itline24.ecm.controller;


import com.itline24.ecm.entity.ClientEntity;
import com.itline24.ecm.entity.EmployeeEntity;
import com.itline24.ecm.entity.EmployeeResumeEntity;
import com.itline24.ecm.repositories.ClientRepository;
import com.itline24.ecm.repositories.EmployeeRepository;
import com.itline24.ecm.repositories.EmployeeResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    private List<ClientEntity> getaa() {

        List<ClientEntity> clientEntities1 = new ArrayList<>();
        clientRepository.findAll().forEach(books1 -> clientEntities1.add(books1
        ));
        return clientEntities1;
    }
}
