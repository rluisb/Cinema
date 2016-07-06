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

public class FilmeDaoBd implements FilmeDao {

    private Connection conexao;
    private PreparedStatement comando;

    @Override
    public void inserir(Filme filme) {
        int id = 0;
        try {
            String sql = "INSERT INTO filme (nome, sinopse, genero) "
                    + "VALUES (?,?,?)";

            conectarObtendoId(sql);
            comando.setString(1, filme.getNome());
            comando.setString(2, filme.getSinopse());
            comando.setString(3, filme.getGenero());
            comando.executeUpdate();
            ResultSet resultado = comando.getGeneratedKeys();
            if (resultado.next()) {
                id = resultado.getInt(1);
                filme.setId(id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void deletar(Filme filme) {
        try {
            String sql = "DELETE FROM filme WHERE id = ?";

            conectar(sql);
            comando.setInt(1, filme.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public void atualizar(Filme filme) {
        try {
            String sql = "UPDATE filme SET rg=?, nome=?, telefone=? "
                    + "WHERE id=?";

            conectar(sql);
            comando.setString(1, filme.getNome());
            comando.setString(2, filme.getSinopse());
            comando.setString(3, filme.getGenero());
            comando.setInt(4, filme.getId());
            comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
    }

    @Override
    public List<Filme> listar() {
        List<Filme> listaFilmes = new ArrayList<>();

        String sql = "SELECT * FROM filme ";

        try {
            conectar(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");

                Filme filme = new Filme(id, nome, rg, telefone);

                listaFilmes.add(filme);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaFilmes);
    }

    @Override
    public Filme procurarPorId(int id) {
        String sql = "SELECT * FROM filme WHERE id = ?";

        try {
            conectar(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String rg = resultado.getString("rg");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");

                Filme filme = new Filme(id, nome, rg, telefone);

                return filme;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public Filme procurarPorGenero(String genero) {
        String sql = "SELECT * FROM filme WHERE genero = ?";

        try {
            conectar(sql);
            comando.setString(1, genero);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String sinopse = resultado.getString("sinopse");

                Filme filme = new Filme(id, nome, genero, sinopse);

                return filme;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (null);
    }

    @Override
    public List<Filme> procurarPorNome(String nome) {
        List<Filme> listaFilmes = new ArrayList<>();
        String sql = "SELECT * FROM filme WHERE nome LIKE ?";

        try {
            conectar(sql);
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String genero = resultado.getString("genero");
                String nomeX = resultado.getString("nome");
                String sinopse = resultado.getString("sinopse");

                Filme filme = new Filme(id, nomeX, genero, sinopse);

                listaFilmes.add(filme);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }

        return (listaFilmes);
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
            Logger.getLogger(FilmeDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
