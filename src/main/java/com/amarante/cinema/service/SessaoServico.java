package com.amarante.cinema.service;

import java.util.List;

import com.amarante.cinema.dao.impl.SessaoDaoImpl;
import com.amarante.cinema.model.Sessao;

public class SessaoServico {

	private SessaoDaoImpl sessaoDaoImpl = new SessaoDaoImpl();

	public void salvar(Sessao sessao) {
		if (sessao.getId() == null) {
			sessaoDaoImpl.salvar(sessao);
		} else {
			sessaoDaoImpl.atualizar(sessao);
		}
	}

	public List<Sessao> listarTodos() {
		return sessaoDaoImpl.listar();
	}

	public void excluir(Sessao sessao) {
		sessaoDaoImpl.deletar(sessao);
	}

	public Sessao buscarPorId(Integer id) {
		return sessaoDaoImpl.buscaPorId(id);
	}
	
	public Sessao buscarPorFilme(String filme) {
		return sessaoDaoImpl.buscaPorFilme(filme);
	}
	
	public Sessao atualizar(Sessao sessao) {
		return sessaoDaoImpl.atualizar(sessao);
	}
	
}
