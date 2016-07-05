package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import banco.ConnectionFactory;
import model.Sessao;

public class SessaoDaoBd implements SessaoDAO{
	
	private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Sessao sessao) {
        try {
            String sql = "INSERT INTO sessao (sala, data, filme) VALUES(?,?,?)";
            conectar(sql);
            comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            comando.setInt(1, sessao.getSala());
            comando.setDate(2, (Date) sessao.getHora());
            comando.setInt(3, sessao.getFilme());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if(resultado.next())
                sessao.setId(resultado.getInt(1));
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Sessao sessao) {
        try {
            String sql = "DELETE FROM sessao WHERE id=?";
            conectar(sql);
            comando.setInt(1, sessao.getId());
            comando.executeUpdate();
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Sessao sessao) {
        try {
            String sql = "UPDATE sessao SET sala=?, hora=?, filme=? WHERE id=?";
            conectar(sql);
            comando.setInt(1, sessao.getSala());
            comando.setDate(2, (Date) sessao.getHora());
            comando.setInt(3, sessao.getFilme());
            comando.setInt(4, sessao.getId());
            comando.executeUpdate();
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Sessao buscarPorId(int id) {
        Sessao sessao = null;
        try {
            String sql = "SELECT * FROM sessao WHERE id=?";
            conectar(sql);
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                sessao = new Sessao(resultado.getInt("id"),
			                        resultado.getInt("sala"),
			                        resultado.getDate("data"),
			                        resultado.getInt("filme"));
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessao;
    }


    @Override
    public List<Sessao> listar() {
        List<Sessao> listaSessaos = new ArrayList<Sessao>();
        try {
            String sql = "SELECT * FROM sessao";
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Sessao sessao = new Sessao(resultado.getInt("id"),
                        resultado.getInt("sala"),
                        resultado.getDate("data"),
                        resultado.getInt("filme"));
                listaSessaos.add(sessao);
            }
            fecharConexao();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSessaos;
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
