package com.amarante.cinema.service;

import java.time.LocalDate;
import java.util.List;

import com.amarante.cinema.dao.impl.VendaDaoImpl;
import com.amarante.cinema.model.Venda;

public class VendaServico {

	private VendaDaoImpl vendaDaoImpl = new VendaDaoImpl();

	public void salvar(Venda venda) {
		if (venda.getId() == null) {
			vendaDaoImpl.salvar(venda);
		} else {
			vendaDaoImpl.atualizar(venda);
		}
	}

	public List<Venda> listarTodos() {
		return vendaDaoImpl.listar();
	}

	public void excluir(Venda venda) {
		vendaDaoImpl.deletar(venda);
	}

	public Venda buscarPorId(Integer id) {
		return vendaDaoImpl.buscaPorId(id);
	}
	
	public Venda buscarPorData(LocalDate data) {
		return vendaDaoImpl.buscaPorData(data);
	}
	
	public Venda atualizar(Venda venda) {
		return vendaDaoImpl.atualizar(venda);
	}
	
}
