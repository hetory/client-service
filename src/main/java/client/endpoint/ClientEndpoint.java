package client.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import client.convert.ClientConverter;
import client.dto.ClientDto;
import client.entity.ClientEntity;
import client.service.ClientService;

@RestController
public class ClientEndpoint {

	@Autowired
	private ClientService clientService;

	public ClientEndpoint(ClientService clientService) {
		this.clientService = clientService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client")
    public ResponseEntity<ClientDto>client(@Valid @RequestBody ClientDto clientDto) {
	   
	   ClientEntity client = clientService.create(ClientConverter.dtoToEntity(clientDto));
	   
	   return new ResponseEntity<ClientDto>(ClientConverter.entityToDto(client), HttpStatus.CREATED);
    }
}
