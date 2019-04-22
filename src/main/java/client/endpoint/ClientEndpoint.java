package client.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.convert.ClientConverter;
import client.dto.ClientDto;
import client.entity.ClientEntity;
import client.service.ClientService;

@RestController
@RequestMapping("/v1")
public class ClientEndpoint {

	@Autowired
	private ClientService clientService;

	public ClientEndpoint(ClientService clientService) {
		this.clientService = clientService;
	}

	@CrossOrigin
    @PostMapping(path= "/client" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto>client(@Valid @RequestBody ClientDto clientDto) {
	   
	   ClientEntity client = clientService.create(ClientConverter.dtoToEntity(clientDto));
	   
	   return new ResponseEntity<ClientDto>(ClientConverter.entityToDto(client), HttpStatus.CREATED);
    }
}
