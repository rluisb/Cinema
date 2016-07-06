package dao;

import java.util.List;

import model.Sessao;

public interface SessaoDao {
	
	public void inserir(Sessao sessao);

    public void deletar(Sessao sessao);

    public void atualizar(Sessao sessao);

    public List<Sessao> listar();

    public Sessao procurarPorId(int id);

    public Sessao procurarPorNumero(int numero);
    
    public Sessao procurarPorGenero(String genero);
    
    public List<Sessao> procurarPorFilme(String nome);

}
