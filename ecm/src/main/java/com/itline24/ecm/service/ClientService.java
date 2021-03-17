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

    public List<ClientJobDetailsDto> getClientJobDetails(int clientId) {

        List<ClientJobDetailsDto> clientJobDetailsDtos  = new ArrayList<>();
        List<ClientJobDetailsEntity> clientJobDetailsEntities =
                clientJobDetailsRepository.findByClientByClientId_ClientId(clientId);

       for(ClientJobDetailsEntity clientJobDetailsEntity: clientJobDetailsEntities) {
           ClientJobDetailsDto clientJobDetailsDto  = new ClientJobDetailsDto();
           BeanUtils.copyProperties(clientJobDetailsEntity, clientJobDetailsDto);
           clientJobDetailsDtos.add(clientJobDetailsDto);
       }

        return clientJobDetailsDtos;
    }

    public void client(ClientDto clientDto){
        ClientEntity clientEntity  = new ClientEntity();
        if(clientDto.getClientId() > 0) {
            clientEntity = clientRepository.findByClientId(clientDto.getClientId());
        }
        BeanUtils.copyProperties(clientDto, clientEntity);
        clientRepository.save(clientEntity);
    }

    public void clientJobDetails(ClientJobDetailsDto clientJobDetailsDto) {

        ClientJobDetailsEntity clientJobDetailsEntity  = new ClientJobDetailsEntity()            ;
        BeanUtils.copyProperties(clientJobDetailsDto,clientJobDetailsEntity);
        ClientEntity clientEntity = clientRepository.findByClientId(clientJobDetailsDto.getClientId());
        clientJobDetailsEntity.setClientByClientId(clientEntity);
        clientJobDetailsRepository.save(clientJobDetailsEntity);
    }
}
