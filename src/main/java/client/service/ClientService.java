package client.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import client.entity.ClientEntity;
import client.repository.ClientRepository;

@Service	
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ClientEntity create(ClientEntity client){
		
		BigDecimal interestRate = BigDecimal.ZERO;

		if(client.getRisk().equals(RiskEnum.B.getRisk())){
			interestRate  = RiskEnum.B.getInterestRate();
		} else if(client.getRisk().equals(RiskEnum.C.getRisk())){
			interestRate  =  RiskEnum.C.getInterestRate();
		}
		client.setInterestRate(interestRate);
		
		return clientRepository.save(client);
	}
}
