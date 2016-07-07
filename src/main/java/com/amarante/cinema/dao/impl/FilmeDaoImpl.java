package com.amarante.cinema.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.amarante.cinema.dao.Dao;
import com.amarante.cinema.dao.FilmeDao;
import com.amarante.cinema.model.Filme;

public class FilmeDaoImpl extends Dao implements FilmeDao{

	private EntityManager em = getEntityManager();

	public void salvar(Filme filme) {
		try {
			em.getTransaction().begin();
			em.persist(filme);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Filme> listar() {
		EntityManager em = getEntityManager();
		try {
			return em.createQuery("FROM " + Filme.class.getName()).getResultList();
		} finally {
			em.close();
		}
	}

	public Filme atualizar(Filme filme) {
		try {
			em.getTransaction().begin();
			em.merge(filme);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		return filme;
	}

	public void deletarPorId(Integer id) {

		try {
			Filme filme = buscaPorId(id);
			deletar(filme);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deletar(Filme filme) {

		try {
			em.getTransaction().begin();
			filme = em.find(Filme.class, filme.getId());
			em.remove(filme);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public Filme buscaPorId(Integer id) {
		return em.find(Filme.class, id);
	}

	public Filme buscaPorNome(String nome) {
		return em.find(Filme.class, nome);
	}

}
