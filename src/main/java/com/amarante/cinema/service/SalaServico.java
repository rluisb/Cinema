package com.amarante.cinema.service;

import java.util.List;

import com.amarante.cinema.dao.impl.SalaDaoImpl;
import com.amarante.cinema.model.Sala;

public class SalaServico {

	private SalaDaoImpl salaDaoImpl = new SalaDaoImpl();

	public void salvar(Sala sala) {
		if (sala.getId() == null) {
			salaDaoImpl.salvar(sala);
		} else {
			salaDaoImpl.atualizar(sala);
		}
	}

	public List<Sala> listarTodos() {
		return salaDaoImpl.listar();
	}

	public void excluir(Sala sala) {
		salaDaoImpl.deletar(sala);
	}

	public Sala buscarPorId(Integer id) {
		return salaDaoImpl.buscaPorId(id);
	}
	
	public Sala buscarPorNumero(Integer numero) {
		return salaDaoImpl.buscaPorNumero(numero);
	}

	public Sala atualizar(Sala sala) {
		return salaDaoImpl.atualizar(sala);
	}

}
