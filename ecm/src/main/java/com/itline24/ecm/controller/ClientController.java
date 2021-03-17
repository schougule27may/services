package com.itline24.ecm.controller;


import com.itline24.ecm.dto.ClientDto;
import com.itline24.ecm.dto.ClientJobDetailsDto;
import com.itline24.ecm.entity.ClientEntity;
import com.itline24.ecm.entity.EmployeeEntity;
import com.itline24.ecm.entity.EmployeeResumeEntity;
import com.itline24.ecm.repositories.ClientRepository;
import com.itline24.ecm.repositories.EmployeeRepository;
import com.itline24.ecm.repositories.EmployeeResumeRepository;
import com.itline24.ecm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "clients")
    public List<ClientDto> getAllActiveClients(){
        return clientService.getClients();
    }

    @GetMapping (value = "client/{clientId}")
    public List<ClientJobDetailsDto> getClientJobDetails(@PathVariable(value = "clientId") int clientId){
        return clientService.getClientJobDetails(clientId);
    }

    @PostMapping(value = "client")
    public void addClient(@RequestBody ClientDto clientDto
    ) {
        clientService.client(clientDto);
    }

    @PutMapping(value = "client")
    public void updateClient(@RequestBody ClientDto clientDto
    ) {
        clientService.client(clientDto);
    }

    @PostMapping(value = "clientJobDetails")
    public void addClientJobDetails(@RequestBody ClientJobDetailsDto clientJobDetailsDto){
        clientService.clientJobDetails(clientJobDetailsDto);
    }

}
