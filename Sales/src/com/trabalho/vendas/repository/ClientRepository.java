package com.trabalho.vendas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.trabalho.vendas.entity.Client;

@SuppressWarnings("all")
public class ClientRepository {
	
	@Inject
	private EntityManager entityManager;
	
	public void save(Client client) {
		entityManager.persist(client);
	}

	public List<Client> listAll() {
		return entityManager.createQuery("select l from " + Client.class.getSimpleName() + " l").getResultList();
	}
	
	public void delete(Client client) {
		entityManager.remove(entityManager.merge(client));
	}

	public void deleteById(Integer id) {
		Client entity = entityManager.find(Client.class, id);
		entityManager.remove(entity);	
	}

	public void update(Client client) {
		entityManager.merge(client);	
	}
	
	public Client findByID(Integer id) {
		return entityManager.find(Client.class, id);
	}

}
