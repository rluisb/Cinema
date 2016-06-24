package com.trabalho.vendas.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class FactoryEntityManager {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("VendasUnit");

	@Produces @RequestScoped
	public EntityManager createAnEntityManager() {
		return factory.createEntityManager();
	}
	
	public void closeAnEntityManager(@Disposes EntityManager manager){
		manager.close();
	}
}
