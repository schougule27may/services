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
        List<ClientJobDetailsEntity> clientJobDetailsEntities = new ArrayList<>();
        clientJobDetailsEntities.add(clientJobDetailsEntity);
        when :
        List<ClientJobDetailsDto> clientJobDetails  = clientService.getClientJobDetails(clientId);

        then :
        1 * clientJobDetailsRepository.findByClientByClientId_ClientId(clientId) >> clientJobDetailsEntities
        clientJobDetails != null;
        clientJobDetails.get(0).getProjectDetails() == 'JAVA , Spring boot along with angular'
        clientJobDetails.get(0).getJobDetailId() == 1
        println clientJobDetails
    }

    def "Add a new client" () {
        given:
        ClientDto clientDto = ClientDto.builder()
                .emailAddress("abc@abc.com")
                .firstName("firstName")
                .lastName("lastName")
                .active(true)
                .countryCode(1)
                .mobile(1234567890)
                .address("XYZ Street")
                .nickName("Smith")
                .type("active")
                .build();

        when:
        clientService.client(clientDto);

        then:
        1 * clientRepository.save(_)

    }


    def "Update a exisiting client" () {
        given:
        ClientDto clientDto = ClientDto.builder()
                 .clientId(1)
                .emailAddress("xyz@abc.com")
                .firstName("firstName")
                .lastName("lastName")
                .active(true)
                .countryCode(1)
                .mobile(1234567890)
                .address("XYZ Street")
                .nickName("Smith")
                .type("active")
                .build();
        ClientEntity clientEntity = new ClientEntity();

        when:
        clientService.client(clientDto);

        then:
        1 * clientRepository.findByClientId(_) >> clientEntity
        1 * clientRepository.save(_)
        clientEntity.getEmailAddress() == 'xyz@abc.com'

    }

    def "Add client job details" () {
        given :

        ClientJobDetailsDto clientJobDetailsDto  =  ClientJobDetailsDto.builder()
                .clientId(1)
                .projectDetails("JAVA spring boot")
                .build();

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientId(1);
        when :
        clientService.clientJobDetails(clientJobDetailsDto);

        then :
        1 * clientRepository.findByClientId(_) >> clientEntity
        1 * clientJobDetailsRepository.save(_)

    }

}
