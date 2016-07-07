package com.amarante.cinema.dao;

import java.util.List;

import com.amarante.cinema.model.Sessao;

public interface SessaoDao {

	public void salvar(Sessao sessao);

	public void deletar(Sessao sessao);

	public Sessao atualizar(Sessao sessao);

	public void deletarPorId(Integer id);

	public Sessao buscaPorId(Integer id);

	public Sessao buscaPorFilme(String filme);

	public List<Sessao> listar();

}
