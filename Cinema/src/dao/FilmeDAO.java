package dao;

import java.util.List;

import model.Filme;

public interface FilmeDAO {

	public void inserir(Filme filme);
    public void deletar(Filme filme);
    public void atualizar(Filme filme);
    public Filme buscarPorId(int id);
    public List<Filme> buscarPorNome(String nome);
    public List<Filme> listar();
	
}
