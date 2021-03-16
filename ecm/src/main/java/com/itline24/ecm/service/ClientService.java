package com.itline24.ecm.service;

import com.itline24.ecm.dto.ClientDto;
import com.itline24.ecm.dto.ClientJobDetailsDto;
import com.itline24.ecm.entity.ClientEntity;
import com.itline24.ecm.entity.ClientJobDetailsEntity;
import com.itline24.ecm.repositories.ClientJobDetailsRepository;
import com.itline24.ecm.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository  clientRepository;

    @Autowired
    ClientJobDetailsRepository clientJobDetailsRepository;

    public  List<ClientDto> getClients() {
        List<ClientDto> clientDtos = new ArrayList<>();
        List<ClientEntity> clientEntities = clientRepository.findAllByActiveIsTrue();
        clientEntities.forEach(clientEntity  -> {
            ClientDto clientDto = new ClientDto();
            BeanUtils.copyProperties(clientEntity,clientDto);
            clientDtos.add(clientDto);
        });

        return clientDtos;
    }

    public ClientJobDetailsDto getClientJobDetails(int clientId) {
        ClientJobDetailsDto clientJobDetailsDto  = new ClientJobDetailsDto();
        ClientJobDetailsEntity clientJobDetailsEntity =
                clientJobDetailsRepository.findByClientByClientId_ClientId(clientId);
        BeanUtils.copyProperties(clientJobDetailsEntity, clientJobDetailsDto);
        return clientJobDetailsDto;
    }

}
