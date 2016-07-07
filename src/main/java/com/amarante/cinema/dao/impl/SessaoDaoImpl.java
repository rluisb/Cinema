package com.amarante.cinema.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.amarante.cinema.dao.Dao;
import com.amarante.cinema.dao.SessaoDao;
import com.amarante.cinema.model.Sessao;

public class SessaoDaoImpl extends Dao implements SessaoDao{

	private EntityManager em = getEntityManager();

	public void salvar(Sessao sessao) {
		try {
			em.getTransaction().begin();
			em.persist(sessao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Sessao> listar() {
		EntityManager em = getEntityManager();
		try {
			return em.createQuery("FROM " + Sessao.class.getName()).getResultList();
		} finally {
			em.close();
		}
	}

	public Sessao atualizar(Sessao sessao) {
		try {
			em.getTransaction().begin();
			em.merge(sessao);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		return sessao;
	}

	public void deletarPorId(Integer id) {

		try {
			Sessao sessao = buscaPorId(id);
			deletar(sessao);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletar(Sessao sessao) {

		try {
			em.getTransaction().begin();
			sessao = em.find(Sessao.class, sessao.getId());
			em.remove(sessao);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public Sessao buscaPorId(Integer id) {
		return em.find(Sessao.class, id);
	}

	public Sessao buscaPorFilme(String numero) {
		return em.find(Sessao.class, numero);
	}

}
