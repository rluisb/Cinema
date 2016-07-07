package com.amarante.cinema.service;

import java.util.List;

import com.amarante.cinema.dao.impl.FilmeDaoImpl;
import com.amarante.cinema.model.Filme;

public class FilmeServico {
	
	private FilmeDaoImpl filmeDaoImpl = new FilmeDaoImpl();

	public void salvar(Filme filme){
		if(filme.getId() == null){
			filmeDaoImpl.salvar(filme);
		}else{
			filmeDaoImpl.atualizar(filme);
		}
	}
	
	public List<Filme> listarTodos() {
		return filmeDaoImpl.listar();
	}

	public void excluir(Filme filme) {
		filmeDaoImpl.deletar(filme);
	}
	
	public Filme buscarPorId(Integer id) {
		return filmeDaoImpl.buscaPorId(id);
	}
	
	public Filme atualizar(Filme filme) {
		return filmeDaoImpl.atualizar(filme);
	}
	
}
