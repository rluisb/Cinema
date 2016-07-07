package com.amarante.cinema.dao;

import java.util.List;

import com.amarante.cinema.model.Filme;

public interface FilmeDao {
	
	public void salvar(Filme filme);
	
	public void deletar(Filme filme);
	
	public Filme atualizar(Filme filme);
	
	public void deletarPorId(Integer id);
	
	public Filme buscaPorId(Integer id);
	
	public Filme buscaPorNome(String nome);
	
	public List<Filme> listar();
	
}
