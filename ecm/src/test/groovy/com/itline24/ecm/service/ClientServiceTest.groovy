package com.itline24.ecm.service

import com.itline24.ecm.dto.ClientDto
import com.itline24.ecm.dto.ClientJobDetailsDto
import com.itline24.ecm.entity.ClientEntity
import com.itline24.ecm.entity.ClientJobDetailsEntity
import com.itline24.ecm.repositories.ClientJobDetailsRepository
import com.itline24.ecm.repositories.ClientRepository
import spock.lang.Specification

class ClientServiceTest extends Specification {

    def ClientService clientService;

    def ClientRepository clientRepository;

    def ClientJobDetailsRepository clientJobDetailsRepository;

    def setup() {
        clientRepository =  Mock(ClientRepository)
        clientJobDetailsRepository = Mock(ClientJobDetailsRepository)
        clientService = new ClientService(clientRepository:clientRepository
        , clientJobDetailsRepository:clientJobDetailsRepository
        )
    }

    def "Get all clients without any filtering"() {
        given:
        List<ClientEntity> clientEntities = new ArrayList<>();
        ClientEntity clientEntity  = new ClientEntity();
        clientEntity.setActive(true);
        clientEntity.setClientId(1);
        clientEntity.setFirstName("client- fname");
        clientEntity.setLastName("client- lname");
        clientEntities.add(clientEntity);

        ClientEntity clientEntity1  = new ClientEntity();
        clientEntity1.setActive(true);
        clientEntity1.setClientId(1);
        clientEntity1.setFirstName("client- xyz");
        clientEntity1.setLastName("client- lname");
        clientEntities.add(clientEntity1);

        when :
        List<ClientDto> clientDtoList = clientService.getClients()

        then :
        1 * clientRepository.findAllByActiveIsTrue() >> clientEntities
        clientDtoList.size() == 2
        clientDtoList.get(0).getActive() == true
        clientDtoList.get(0).getFirstName() == 'client- fname'
        clientDtoList.get(1).getFirstName() == 'client- xyz'
    }

    def "Get client job details by client id"() {

        given :
        int clientId =10;
        ClientJobDetailsEntity clientJobDetailsEntity = new ClientJobDetailsEntity();
        clientJobDetailsEntity.setJobDetailId(1);
        clientJobDetailsEntity.setProjectDetails("JAVA , Spring boot along with angular");
        when :
        ClientJobDetailsDto clientJobDetailsDto  = clientService.getClientJobDetails(clientId);

        then :
        1 * clientJobDetailsRepository.findByClientByClientId_ClientId(clientId) >> clientJobDetailsEntity
        clientJobDetailsDto != null;
        clientJobDetailsDto.getProjectDetails() == 'JAVA , Spring boot along with angular'
        clientJobDetailsDto.getJobDetailId() == 1
        println clientJobDetailsDto
    }
}
