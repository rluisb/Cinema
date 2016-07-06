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
import model.Filme;
import model.Sala;

public class SalaDaoBd implements SalaDao {

	private Connection conexao;
	private PreparedStatement comando;

	@Override
	public void inserir(Sala sala) {
		int id = 0;
		try {
			String sql = "INSERT INTO sala (numero, poltronas, filme) " + "VALUES (?,?,?)";

			conectarObtendoId(sql);
			comando.setInt(1, sala.getNumero());
			comando.setInt(2, sala.getPoltronas());
			comando.setInt(3, sala.getFilme().getId());
			comando.executeUpdate();
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next()) {
				id = resultado.getInt(1);
				sala.setId(id);
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public void deletar(Sala sala) {
		try {
			String sql = "DELETE FROM sala WHERE id = ?";

			conectar(sql);
			comando.setInt(1, sala.getId());
			comando.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public void atualizar(Sala sala) {
		try {
			String sql = "UPDATE sala SET numero=?, poltronas=?, filme=? " + "WHERE id=?";

			conectar(sql);
			comando.setInt(1, sala.getNumero());
			comando.setInt(2, sala.getPoltronas());
			comando.setString(3, sala.getFilme().getNome());
			comando.setInt(4, sala.getId());
			comando.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public List<Sala> listar() {
		List<Sala> listaSalas = new ArrayList<>();

		String sql = "SELECT s.id, s.numero, s.poltronas, s.filme, f.nome, f.sinopse, f.genero" + "FROM sala AS s"
				+ "INNER JOIN filme AS f " + "ON s.filme = f.id " + "ORDER BY s.numero";

		try {
			conectar(sql);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				int id = resultado.getInt(1);
				int numero = resultado.getInt(2);
				int poltronas = resultado.getInt(3);
				int idFilme = resultado.getInt(4);
				String nomeFilme = resultado.getString(5);
				String sinopseFilme = resultado.getString(6);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(id, numero, poltronas, filme);

				listaSalas.add(sala);
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (listaSalas);
	}

	@Override
	public Sala procurarPorId(int id) {
		String sql = "SELECT s.id, s.numero, s.poltronas, s.filme, f.nome, f.sinopse, f.genero" + "FROM sala AS s"
				+ "INNER JOIN filme AS f " + "ON s.filme = f.id " + "WHERE s.id =?" + "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setInt(1, id);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				int idSala = resultado.getInt(1);
				int numero = resultado.getInt(2);
				int poltronas = resultado.getInt(3);
				int idFilme = resultado.getInt(4);
				String nomeFilme = resultado.getString(5);
				String sinopseFilme = resultado.getString(6);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numero, poltronas, filme);

				return sala;
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (null);
	}

	@Override
	public Sala procurarPorGenero(String genero) {
		String sql = "SELECT s.id, s.numero, s.poltronas, s.filme, f.nome, f.sinopse, f.genero" + "FROM sala AS s"
				+ "INNER JOIN filme AS f " + "ON s.filme = f.id " + "WHERE f.genero =?" + "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setString(1, genero);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				int idSala = resultado.getInt(1);
				int numero = resultado.getInt(2);
				int poltronas = resultado.getInt(3);
				int idFilme = resultado.getInt(4);
				String nomeFilme = resultado.getString(5);
				String sinopseFilme = resultado.getString(6);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numero, poltronas, filme);

				return sala;
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (null);
	}

	@Override
	public List<Sala> procurarPorFilme(String nome) {
		List<Sala> listaSalas = new ArrayList<>();
		String sql = "SELECT s.id, s.numero, s.poltronas, s.filme, f.nome, f.sinopse, f.genero" + "FROM sala AS s"
				+ "INNER JOIN filme AS f " + "ON s.filme = f.id " + "WHERE f.nome LIKE ?" + "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setString(1, "%" + nome + "%");
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				int idSala = resultado.getInt(1);
				int numero = resultado.getInt(2);
				int poltronas = resultado.getInt(3);
				int idFilme = resultado.getInt(4);
				String nomeFilme = resultado.getString(5);
				String sinopseFilme = resultado.getString(6);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numero, poltronas, filme);

				listaSalas.add(sala);
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (listaSalas);
	}

	public void conectar(String sql) throws SQLException {
		conexao = ConnectionFactory.getConnection();
		comando = conexao.prepareStatement(sql);
	}

	public void conectarObtendoId(String sql) throws SQLException {
		conexao = ConnectionFactory.getConnection();
		comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	}

	public void fecharConexao() {
		try {
			if (comando != null) {
				comando.close();
			}
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Sala procurarPorNumero(int numero) {
		String sql = "SELECT s.id, s.numero, s.poltronas, s.filme, f.nome, f.sinopse, f.genero" + "FROM sala AS s"
				+ "INNER JOIN filme AS f " + "ON s.filme = f.id " + "WHERE s.numero = ?" + "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setInt(1, numero);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				int idSala = resultado.getInt(1);
				int numeroSala = resultado.getInt(2);
				int poltronas = resultado.getInt(3);
				int idFilme = resultado.getInt(4);
				String nomeFilme = resultado.getString(5);
				String sinopseFilme = resultado.getString(6);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numero, poltronas, filme);

				return sala;
			}

		} catch (SQLException ex) {
			Logger.getLogger(SalaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (null);
	}

}
