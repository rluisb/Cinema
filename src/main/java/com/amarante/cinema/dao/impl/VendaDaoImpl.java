package com.amarante.cinema.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.amarante.cinema.dao.Dao;
import com.amarante.cinema.dao.VendaDao;
import com.amarante.cinema.model.Venda;

public class VendaDaoImpl extends Dao implements VendaDao{

	private EntityManager em = getEntityManager();

	public void salvar(Venda venda) {
		try {
			em.getTransaction().begin();
			em.persist(venda);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		EntityManager em = getEntityManager();
		try {
			return em.createQuery("FROM " + Venda.class.getName()).getResultList();
		} finally {
			em.close();
		}
	}

	public Venda atualizar(Venda venda) {
		try {
			em.getTransaction().begin();
			em.merge(venda);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		return venda;
	}

	public void deletarPorId(Integer id) {

		try {
			Venda venda = buscaPorId(id);
			deletar(venda);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletar(Venda venda) {

		try {
			em.getTransaction().begin();
			venda = em.find(Venda.class, venda.getId());
			em.remove(venda);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public Venda buscaPorId(Integer id) {
		return em.find(Venda.class, id);
	}

	public Venda buscaPorData(LocalDate data) {
		return em.find(Venda.class, data);
	}

}
