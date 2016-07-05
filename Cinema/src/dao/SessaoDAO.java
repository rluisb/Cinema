package dao;

import java.util.List;

import model.Sessao;

public interface SessaoDAO {
	
	public void inserir(Sessao filme);
    public void deletar(Sessao filme);
    public void atualizar(Sessao filme);
    public Sessao buscarPorId(int id);
    public List<Sessao> listar();

}
