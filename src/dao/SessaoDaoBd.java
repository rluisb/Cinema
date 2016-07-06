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
import model.Sessao;

public class SessaoDaoBd implements SessaoDao {

	private Connection conexao;
	private PreparedStatement comando;

	@Override
	public void inserir(Sessao sessao) {
		int id = 0;
		try {
			String sql = "INSERT INTO sessao (sala, data) " + "VALUES (?,?)";

			conectarObtendoId(sql);
			comando.setInt(1, sessao.getSala().getId());
			java.sql.Timestamp dataSql = new java.sql.Timestamp(sessao.getHora().getTime());
			comando.setTimestamp(2, dataSql);
			comando.executeUpdate();
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next()) {
				id = resultado.getInt(1);
				sessao.setId(id);
			}

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public void deletar(Sessao sessao) {
		try {
			String sql = "DELETE FROM sessao WHERE id = ?";

			conectar(sql);
			comando.setInt(1, sessao.getId());
			comando.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public void atualizar(Sessao sessao) {
		try {
			String sql = "UPDATE sessao SET sala=?, data=? WHERE id=?";

			conectar(sql);
			comando.setInt(1, sessao.getSala().getId());
			java.sql.Timestamp dataSql = new java.sql.Timestamp(sessao.getHora().getTime());
			comando.setTimestamp(2, dataSql);
			comando.setInt(3, sessao.getId());
			comando.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public List<Sessao> listar() {
		List<Sessao> listaSessaos = new ArrayList<>();

		String sql = "SELECT s.id, s.data, r.id, r.numero, r.poltronas, r.filme,"
				+ " f.nome, f.sinopse, f.genero "
				+ "FROM sessao AS s"
				+ "INNER JOIN sala AS r"
				+ "ON s.sala = r.id"
				+ "INNER JOIN filme AS f"
				+ "ON r.filme = f.id"
				+ "ORDER BY s.data";

		try {
			conectar(sql);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				int idSessao = resultado.getInt(1);
				java.sql.Timestamp dataSql = resultado.getTimestamp(2);
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idSala = resultado.getInt(3);
				int numeroSala = resultado.getInt(4);
				int poltronasSala = resultado.getInt(5);
				int idFilme = resultado.getInt(6);
				String nomeFilme = resultado.getString(7);
				String sinopseFilme = resultado.getString(8);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numeroSala, poltronasSala, filme);
				
				Sessao sessao = new Sessao(idSessao, sala, dataUtil);

				listaSessaos.add(sessao);
			}

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (listaSessaos);
	}

	@Override
	public Sessao procurarPorId(int id) {
		String sql = "SELECT s.id, s.data, r.id, r.numero, r.poltronas, r.filme,"
				+ " f.nome, f.sinopse, f.genero "
				+ "FROM sessao AS s"
				+ "INNER JOIN sala AS r"
				+ "ON s.sala = r.id"
				+ "INNER JOIN filme AS f"
				+ "ON r.filme = f.id"
				+ "WHERE s.id =?"
				+ "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setInt(1, id);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				int idSessao = resultado.getInt(1);
				java.sql.Timestamp dataSql = resultado.getTimestamp(2);
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idSala = resultado.getInt(3);
				int numeroSala = resultado.getInt(4);
				int poltronasSala = resultado.getInt(5);
				int idFilme = resultado.getInt(6);
				String nomeFilme = resultado.getString(7);
				String sinopseFilme = resultado.getString(8);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numeroSala, poltronasSala, filme);
				
				Sessao sessao = new Sessao(idSessao, sala, dataUtil);

				return sessao;
			}

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (null);
	}

	@Override
	public Sessao procurarPorGenero(String genero) {
		String sql = "SELECT s.id, s.data, r.id, r.numero, r.poltronas, r.filme,"
				+ " f.nome, f.sinopse, f.genero "
				+ "FROM sessao AS s"
				+ "INNER JOIN sala AS r"
				+ "ON s.sala = r.id"
				+ "INNER JOIN filme AS f"
				+ "ON r.filme = f.id"
				+ "WHERE f.genero =?"
				+ "ORDER BY s.data";

		try {
			conectar(sql);
			comando.setString(1, genero);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				int idSessao = resultado.getInt(1);
				java.sql.Timestamp dataSql = resultado.getTimestamp(2);
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idSala = resultado.getInt(3);
				int numeroSala = resultado.getInt(4);
				int poltronasSala = resultado.getInt(5);
				int idFilme = resultado.getInt(6);
				String nomeFilme = resultado.getString(7);
				String sinopseFilme = resultado.getString(8);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numeroSala, poltronasSala, filme);
				
				Sessao sessao = new Sessao(idSessao, sala, dataUtil);

				return sessao;
			}

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (null);
	}

	@Override
	public List<Sessao> procurarPorFilme(String nome) {
		List<Sessao> listaSessaos = new ArrayList<>();
		String sql = "SELECT s.id, s.data, r.id, r.numero, r.poltronas, r.filme,"
				+ " f.nome, f.sinopse, f.genero "
				+ "FROM sessao AS s"
				+ "INNER JOIN sala AS r"
				+ "ON s.sala = r.id"
				+ "INNER JOIN filme AS f"
				+ "ON r.filme = f.id"
				+ "WHERE f.nome LIKE ?"
				+ "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setString(1, "%" + nome + "%");
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				int idSessao = resultado.getInt(1);
				java.sql.Timestamp dataSql = resultado.getTimestamp(2);
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idSala = resultado.getInt(3);
				int numeroSala = resultado.getInt(4);
				int poltronasSala = resultado.getInt(5);
				int idFilme = resultado.getInt(6);
				String nomeFilme = resultado.getString(7);
				String sinopseFilme = resultado.getString(8);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numeroSala, poltronasSala, filme);
				
				Sessao sessao = new Sessao(idSessao, sala, dataUtil);

				listaSessaos.add(sessao);
			}

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (listaSessaos);
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
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Sessao procurarPorNumero(int numero) {
		String sql = "SELECT s.id, s.data, r.id, r.numero, r.poltronas, r.filme,"
				+ " f.nome, f.sinopse, f.genero "
				+ "FROM sessao AS s"
				+ "INNER JOIN sala AS r"
				+ "ON s.sala = r.id"
				+ "INNER JOIN filme AS f"
				+ "ON r.filme = f.id"
				+ "WHERE r.numero = ?"
				+ "ORDER BY s.id";

		try {
			conectar(sql);
			comando.setInt(1, numero);

			ResultSet resultado = comando.executeQuery();

			if (resultado.next()) {
				int idSessao = resultado.getInt(1);
				java.sql.Timestamp dataSql = resultado.getTimestamp(2);
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
				int idSala = resultado.getInt(3);
				int numeroSala = resultado.getInt(4);
				int poltronasSala = resultado.getInt(5);
				int idFilme = resultado.getInt(6);
				String nomeFilme = resultado.getString(7);
				String sinopseFilme = resultado.getString(8);
				String generoFilme = resultado.getString(7);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numeroSala, poltronasSala, filme);
				
				Sessao sessao = new Sessao(idSessao, sala, dataUtil);

				return sessao;
			}

		} catch (SQLException ex) {
			Logger.getLogger(SessaoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (null);
	}

}
