package com.amarante.cinema.dao;

import java.time.LocalDate;
import java.util.List;

import com.amarante.cinema.model.Venda;

public interface VendaDao {

	public void salvar(Venda venda);

	public void deletar(Venda venda);

	public Venda atualizar(Venda venda);

	public void deletarPorId(Integer id);

	public Venda buscaPorId(Integer id);

	public Venda buscaPorData(LocalDate data);

	public List<Venda> listar();
	
}
