package com.trabalho.vendas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.trabalho.vendas.entity.Sale;

@SuppressWarnings("all")
public class SaleRepository {

	@Inject
	private EntityManager entityManager;
	
	public void save(Sale sale) {
		entityManager.persist(sale);
	}

	public List<Sale> listAll() {
		return entityManager.createQuery("select l from " + Sale.class.getSimpleName() + " l").getResultList();
	}
	
	public void delete(Sale sale) {
		entityManager.remove(entityManager.merge(sale));
	}

	public void deleteById(Integer id) {
		Sale entity = entityManager.find(Sale.class, id);
		entityManager.remove(entity);	
	}

	public void update(Sale sale) {
		entityManager.merge(sale);	
	}
	
	public Sale findByID(Integer id) {
		return entityManager.find(Sale.class, id);
	}
	
}
