package com.trabalho.vendas.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.trabalho.vendas.entity.Product;

@SuppressWarnings("all")
public class ProductRepository {

	@Inject
	private EntityManager entityManager;
	
	public void save(Product product) {
		entityManager.persist(product);
	}

	public List<Product> listAll() {
		return entityManager.createQuery("select l from " + Product.class.getSimpleName() + " l").getResultList();
	}
	
	public void delete(Product product) {
		entityManager.remove(entityManager.merge(product));
	}

	public void deleteById(Integer id) {
		Product entity = entityManager.find(Product.class, id);
		entityManager.remove(entity);	
	}

	public void update(Product product) {
		entityManager.merge(product);	
	}
	
	public Product findByID(Integer id) {
		return entityManager.find(Product.class, id);
	}
	
}
