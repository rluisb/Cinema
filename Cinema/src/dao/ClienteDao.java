package dao;

import java.util.List;
import model.Cliente;

public interface ClienteDao {
    public void inserir(Cliente cliente);
    public void deletar(Cliente cliente);
    public void atualizar(Cliente cliente);
    public Cliente buscarPorId(int id);
    public Cliente buscarPorRg(String rg);
    public List<Cliente> buscarPorNome(String nome);
    public List<Cliente> listar();
}
