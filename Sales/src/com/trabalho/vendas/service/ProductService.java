package com.trabalho.vendas.service;

import java.util.List;

import javax.inject.Inject;

import com.trabalho.vendas.entity.Product;
import com.trabalho.vendas.repository.ProductRepository;
import com.trabalho.vendas.transactional.Transacional;

public class ProductService {

	@Inject
	private ProductRepository productRepository;
	
	@Transacional
	public void save(Product product) {
		if (product.getId() == null) {
			productRepository.save(product);
		} else {
			productRepository.update(product);
		}
	}

	@Transacional
	public List<Product> listAllRecords() {
		return productRepository.listAll();
	}

	@Transacional
	public void delete(Product product) {
		productRepository.delete(product);
	}
	
	@Transacional
	public Product findByID(Integer id) {
		return productRepository.findByID(id);
	}
	
}
