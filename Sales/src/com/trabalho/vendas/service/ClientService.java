package com.trabalho.vendas.service;

import java.util.List;

import javax.inject.Inject;

import com.trabalho.vendas.entity.Client;
import com.trabalho.vendas.repository.ClientRepository;
import com.trabalho.vendas.transactional.Transacional;

public class ClientService {

	@Inject
	private ClientRepository clientRepository;
	
	@Transacional
	public void save(Client client) {
		if (client.getId() == null) {
			clientRepository.save(client);
		} else {
			clientRepository.update(client);
		}
	}

	@Transacional
	public List<Client> listAllRecords() {
		return clientRepository.listAll();
	}

	@Transacional
	public void delete(Client client) {
		clientRepository.delete(client);
	}
	
	@Transacional
	public Client findByID(Integer id) {
		return clientRepository.findByID(id);
	}
}
