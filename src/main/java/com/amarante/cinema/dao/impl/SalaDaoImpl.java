package com.amarante.cinema.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.amarante.cinema.dao.Dao;
import com.amarante.cinema.dao.SalaDao;
import com.amarante.cinema.model.Sala;

public class SalaDaoImpl extends Dao implements SalaDao{

	private EntityManager em = getEntityManager();

	public void salvar(Sala sala) {
		try {
			em.getTransaction().begin();
			em.persist(sala);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Sala> listar() {
		EntityManager em = getEntityManager();
		try {
			return em.createQuery("FROM " + Sala.class.getName()).getResultList();
		} finally {
			em.close();
		}
	}

	public Sala atualizar(Sala sala) {
		try {
			em.getTransaction().begin();
			em.merge(sala);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		return sala;
	}

	public void deletarPorId(Integer id) {

		try {
			Sala sala = buscaPorId(id);
			deletar(sala);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletar(Sala sala) {

		try {
			em.getTransaction().begin();
			sala = em.find(Sala.class, sala.getId());
			em.remove(sala);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public Sala buscaPorId(Integer id) {
		return em.find(Sala.class, id);
	}

	public Sala buscaPorNumero(Integer numero) {
		return em.find(Sala.class, numero);
	}
	
}
