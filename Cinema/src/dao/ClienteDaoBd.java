package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

public class ClienteDaoBd implements ClienteDao{

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente (rg,nome,endereco,telefone) VALUES(?,?,?,?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            comando.setString(1, cliente.getRg());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getEndereco());
            comando.setString(4, cliente.getTelefone());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next())
                cliente.setId(resultado.getInt(1));
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        try {
            String sql = "DELETE FROM cliente WHERE id=?";
            conectar(sql);
            comando.setInt(1, cliente.getId());
            comando.executeUpdate();
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Cliente pessoa) {
        try {
            String sql = "UPDATE cliente SET rg=?, nome=?, endereco=?, telefone=? WHERE id=?";
            conectar(sql);
            comando.setString(1, pessoa.getRg());
            comando.setString(2, pessoa.getNome());
            comando.setString(3, pessoa.getEndereco());
            comando.setString(4, pessoa.getTelefone());
            comando.setInt(5, pessoa.getId());
            comando.executeUpdate();
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE id=?";
            conectar(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente(resultado.getInt("id"),
                        resultado.getString("rg"),
                        resultado.getString("nome"),
                        resultado.getString("endereco"),
                        resultado.getString("telefone"));
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public Cliente buscarPorRg(String rg) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM cliente WHERE rg=?";
            conectar(sql);
            comando.setString(1, rg);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                cliente = new Cliente(resultado.getInt("id"),
                        resultado.getString("rg"),
                        resultado.getString("nome"),
                        resultado.getString("endereco"),
                        resultado.getString("telefone"));
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
    @Override
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
            conectar(sql);
            comando.setString(1, "%"+nome+"%");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getInt("id"),
                        resultado.getString("rg"),
                        resultado.getString("nome"),
                        resultado.getString("endereco"),
                        resultado.getString("telefone"));
                listaClientes.add(cliente);
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            String sql = "SELECT * FROM cliente";
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getInt("id"),
                        resultado.getString("rg"),
                        resultado.getString("nome"),
                        resultado.getString("endereco"),
                        resultado.getString("telefone"));
                listaClientes.add(cliente);
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    private void conectar(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }

    private void fecharConexao() throws SQLException {
        comando.close();
        conexao.close();
    }
    
}
