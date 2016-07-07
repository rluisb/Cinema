package com.amarante.cinema.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

	private EntityManagerFactory emf; 

	public EntityManager getEntityManager(){

		return emf.createEntityManager();
	}
	public Dao() {
		emf = Persistence.createEntityManagerFactory("cinemaUnit");
	}
	
}
