package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import banco.ConnectionFactory;
import model.Sala;

public class SalaDaoBd implements SalaDAO {

	private Connection conexao;
	private PreparedStatement comando;

	@Override
	public void inserir(Sala sala) {
		try {
			String sql = "INSERT INTO sala (numero, poltronas) VALUES(?,?)";
			conectar(sql);
			comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			comando.setInt(1, sala.getNumero());
			comando.setInt(2, sala.getPoltronas());
			comando.executeUpdate();
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next())
				sala.setId(resultado.getInt(1));
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void deletar(Sala sala) {
		try {
			String sql = "DELETE FROM sala WHERE id=?";
			conectar(sql);
			comando.setInt(1, sala.getId());
			comando.executeUpdate();
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void atualizar(Sala sala) {
		try {
			String sql = "UPDATE sala SET numero=?, poltronas=? WHERE id=?";
			conectar(sql);
			comando.setInt(1, sala.getNumero());
			comando.setInt(2, sala.getPoltronas());
			comando.setInt(3, sala.getId());
			comando.executeUpdate();
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Sala buscarPorId(int id) {
		Sala sala = null;
		try {
			String sql = "SELECT * FROM sala WHERE id=?";
			conectar(sql);
			comando.setInt(1, id);
			ResultSet resultado = comando.executeQuery();
			if (resultado.next()) {
				sala = new Sala(resultado.getInt("id"),
								resultado.getInt("numero"),
								resultado.getInt("poltronas"));
			}
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
		return sala;
	}

	@Override
	public List<Sala> listar() {
		List<Sala> listaSalas = new ArrayList<Sala>();
		try {
			String sql = "SELECT * FROM sala";
			conectar(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Sala sala = new Sala(resultado.getInt("id"),
						resultado.getInt("numero"),
						resultado.getInt("poltronas"));
				listaSalas.add(sala);
			}
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaSalas;
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
