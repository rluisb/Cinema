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
import model.Cliente;
import model.Filme;
import model.Sala;
import model.Sessao;
import model.VendaIngresso;

public class VendaIngressoDaoBd implements VendaIngressoDao{

	private Connection conexao;
	private PreparedStatement comando;

	@Override
	public void inserir(VendaIngresso vendaIngresso) {
		int id = 0;
		try {
			String sql = "INSERT INTO venda "
					+ "(sessao, cliente) "
					+ "VALUES (?,?)";

			conectarObtendoId(sql);
			comando.setInt(1, vendaIngresso.getSessao().getId());
			comando.setInt(2, vendaIngresso.getCliente().getId());
			comando.executeUpdate();
			ResultSet resultado = comando.getGeneratedKeys();
			if (resultado.next()) {
				id = resultado.getInt(1);
				vendaIngresso.setId(id);
			}

		} catch (SQLException ex) {
			Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public void deletar(VendaIngresso vendaIngresso) {
		try {
			String sql = "DELETE FROM venda WHERE id = ?";

			conectar(sql);
			comando.setInt(1, vendaIngresso.getId());
			comando.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public void atualizar(VendaIngresso vendaIngresso) {
		try {
			String sql = "UPDATE venda SET sessao=?, cliente=?"
					+ "WHERE id=?";

			conectar(sql);
			comando.setInt(1, vendaIngresso.getSessao().getId());
			comando.setInt(2, vendaIngresso.getCliente().getId());
			comando.setInt(3, vendaIngresso.getId());
			comando.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}
	}

	@Override
	public List<VendaIngresso> listar() {
		List<VendaIngresso> listaVendaIngressos = new ArrayList<>();
		String sql = "SELECT v.id, v.sessao, v.cliente, s.data,"
				+ " r.numero, r.poltronas, r.filme, f.nome,"
				+ " f.sinopse, f.genero, c.rg, c.nome, c.telefone, r.id"
				+"FROM venda AS v"
				+"INNER JOIN sessao AS s"
				+"ON v.sessao = s.id"
				+"INNER JOIN cliente AS c"
				+"ON v.cliente = c.id"
				+"INNER JOIN sala AS r"
				+"ON s.sala = r.id"
				+"INNER JOIN filme AS f"
				+"ON r.filme = f.id"
				+"ORDER BY v.id";

		try {
			conectar(sql);

			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				int idVenda = resultado.getInt(1);
				int idSessao = resultado.getInt(2);
				int idCliente = resultado.getInt(3);
				java.sql.Timestamp dataSql = resultado.getTimestamp(4);
                java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                int numeroSala = resultado.getInt(5);
                int poltronasSala = resultado.getInt(6);
                int idFilme = resultado.getInt(7);
                String nomeFilme = resultado.getString(8);
                String sinopseFilme = resultado.getString(9);
				String generoFilme = resultado.getString(10);
				String rgCliente = resultado.getString(11);
				String nomeCliente = resultado.getString(12);
				String telefoneCliente = resultado.getString(13);
				int idSala = resultado.getInt(14);
				
				Cliente cliente = new Cliente(idCliente, nomeCliente, rgCliente, telefoneCliente);

				Filme filme = new Filme(idFilme, nomeFilme, sinopseFilme, generoFilme);

				Sala sala = new Sala(idSala, numeroSala, poltronasSala, filme);
				
				Sessao sessao = new Sessao(idSessao, sala, dataUtil);

				VendaIngresso vendaIngresso = new VendaIngresso(idVenda, sessao, cliente);

				listaVendaIngressos.add(vendaIngresso);
			}

		} catch (SQLException ex) {
			Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharConexao();
		}

		return (listaVendaIngressos);
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
			Logger.getLogger(VendaIngressoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
