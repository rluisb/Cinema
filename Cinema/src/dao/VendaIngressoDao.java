package dao;

import java.util.List;

import model.VendaIngresso;

public interface VendaIngressoDao {

	public void inserir(VendaIngresso venda);

    public void deletar(VendaIngresso venda);

    public void atualizar(VendaIngresso venda);

    public List<VendaIngresso> listar();
	
}
