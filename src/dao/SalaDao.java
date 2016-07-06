package dao;

import java.util.List;

import model.Sala;

public interface SalaDao {
	
	public void inserir(Sala sala);

    public void deletar(Sala sala);

    public void atualizar(Sala sala);

    public List<Sala> listar();

    public Sala procurarPorId(int id);

    public Sala procurarPorNumero(int numero);
    
    public Sala procurarPorGenero(String genero);
    
    public List<Sala> procurarPorFilme(String nome);

}
