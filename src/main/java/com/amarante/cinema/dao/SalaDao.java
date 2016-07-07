package com.amarante.cinema.dao;

import java.util.List;

import com.amarante.cinema.model.Sala;

public interface SalaDao {

	public void salvar(Sala sala);

	public void deletar(Sala sala);

	public Sala atualizar(Sala sala);

	public void deletarPorId(Integer id);

	public Sala buscaPorId(Integer id);

	public Sala buscaPorNumero(Integer numero);

	public List<Sala> listar();

}
