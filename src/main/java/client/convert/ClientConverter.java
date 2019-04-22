package client.convert;

import client.dto.ClientDto;
import client.entity.ClientEntity;

public class ClientConverter {
	
	public static ClientEntity dtoToEntity(ClientDto clientDto){
		
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setCreditLimit(clientDto.getLimit());
		clientEntity.setName(clientDto.getName());
		clientEntity.setRisk(clientDto.getRisk());
		
		return clientEntity;
	}
	
    public static ClientDto entityToDto(ClientEntity clientEntity){
		
    	ClientDto clientDto = new ClientDto();
    	clientDto.setLimit(clientEntity.getCreditLimit());
    	clientDto.setName(clientEntity.getName());
    	clientDto.setRisk(clientEntity.getRisk());
    	clientDto.setInterestRate(clientEntity.getInterestRate());
    	
		return clientDto;
	}
}