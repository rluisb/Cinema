package com.trabalho.vendas.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.trabalho.vendas.model.entity.Client;

@RequestScoped
public class ClientRepository {

	@Inject
    private Session session;
 
    private Criteria createCriteria() {
        return session.createCriteria(Client.class);
    }
 
    @SuppressWarnings("unchecked")
    public List<Client> list() {
        return createCriteria().list();
    }
}
