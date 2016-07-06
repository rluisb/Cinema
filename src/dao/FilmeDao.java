package dao;

import java.util.List;

import model.Filme;

public interface FilmeDao {

	public void inserir(Filme filme);

    public void deletar(Filme filme);

    public void atualizar(Filme filme);

    public List<Filme> listar();

    public Filme procurarPorId(int id);

    public Filme procurarPorGenero(String genero);

    public List<Filme> procurarPorNome(String nome);
	
}
