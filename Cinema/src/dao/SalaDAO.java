package dao;

import java.util.List;

import model.Sala;

public interface SalaDAO {

	public void inserir(Sala sala);
    public void deletar(Sala sala);
    public void atualizar(Sala sala);
    public Sala buscarPorId(int id);
    public List<Sala> listar();
	
}
