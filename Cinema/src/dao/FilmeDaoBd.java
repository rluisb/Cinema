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

public class FilmeDaoBd implements FilmeDAO {

	private Connection conexao;
	private PreparedStatement comando;

	@Override
	public void inserir(Filme filme) {
		try {
			String sql = "INSERT INTO filme (nome, sinopse, genero) VALUES(?,?,?)";
			conectar(sql);
			comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			comando.setString(1, filme.getNome());
			comando.setString(2, filme.getSinopse());
			comando.setString(3, filme.getGenero());
			comando.executeUpdate();
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next())
				filme.setId(resultado.getInt(1));
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void deletar(Filme filme) {
		try {
			String sql = "DELETE FROM filme WHERE id=?";
			conectar(sql);
			comando.setInt(1, filme.getId());
			comando.executeUpdate();
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void atualizar(Filme filme) {
		try {
			String sql = "UPDATE filme SET nome=?, sinopse=?, genero=? WHERE id=?";
			conectar(sql);
			comando.setString(1, filme.getNome());
			comando.setString(2, filme.getSinopse());
			comando.setString(3, filme.getGenero());
			comando.setInt(4, filme.getId());
			comando.executeUpdate();
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Filme buscarPorId(int id) {
		Filme filme = null;
		try {
			String sql = "SELECT * FROM filme WHERE id=?";
			conectar(sql);
			comando.setInt(1, id);
			ResultSet resultado = comando.executeQuery();
			if (resultado.next()) {
				filme = new Filme(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("sinopse"),
						resultado.getString("genero"));
			}
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
		return filme;
	}

	@Override
	public List<Filme> buscarPorNome(String nome) {
		List<Filme> listaFilmes = new ArrayList<Filme>();
		try {
			String sql = "SELECT * FROM filme WHERE nome LIKE ?";
			conectar(sql);
			comando.setString(1, "%" + nome + "%");
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Filme filme = new Filme(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("sinopse"), resultado.getString("genero"));
				listaFilmes.add(filme);
			}
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaFilmes;
	}

	@Override
	public List<Filme> listar() {
		List<Filme> listaFilmes = new ArrayList<Filme>();
		try {
			String sql = "SELECT * FROM filme";
			conectar(sql);
			ResultSet resultado = comando.executeQuery();
			while (resultado.next()) {
				Filme filme = new Filme(resultado.getInt("id"), resultado.getString("nome"),
						resultado.getString("sinopse"), resultado.getString("genero"));
				listaFilmes.add(filme);
			}
			fecharConexao();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaFilmes;
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
