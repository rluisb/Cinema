package com.trabalho.vendas.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.trabalho.vendas.model.entity.Product;

@RequestScoped
public class ProductRepository {

	@Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Product.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Product> list() {
        return createCriteria().list();
    }
	
}
