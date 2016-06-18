package com.trabalho.vendas.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.trabalho.vendas.model.entity.Sale;

@RequestScoped
public class SaleRepository {

	@Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Sale.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Sale> list() {
        return createCriteria().list();
    }
	
}
