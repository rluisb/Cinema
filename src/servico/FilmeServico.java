package servico;

import java.util.List;

import dao.FilmeDao;
import dao.FilmeDaoBd;
import model.Filme;

public class FilmeServico {
	
	    public boolean nomeFilmeExiste(String nome) {
	        FilmeDao dao = new FilmeDaoBd();
	        List<Filme> filme = dao.procurarPorNome(nome);
	        return (filme != null);
	    }

	    public boolean filmeExiste(int id) {
	        FilmeDao dao = new FilmeDaoBd();
	        Filme filme = dao.procurarPorId(id);
	        return (filme != null);
	    }

	    public void addFilme(Filme filme) {
	        new FilmeDaoBd().inserir(filme);
	    }

	    public void atualizaFilme(Filme filme) {
	        new FilmeDaoBd().atualizar(filme);
	    }

	    public void deletarFilme(Filme filme) {
	        new FilmeDaoBd().deletar(filme);
	    }

	    public List<Filme> listarFilme() {
	        return (new FilmeDaoBd().listar());
	    }

	    public void mostrarFilmes() {
	        System.out.println("-----------------------------\n");
	        System.out.println(String.format("%-4s", "ID") + "\t"
	                + String.format("%-27s", "|NOME") + "\t"
	                + String.format("%-10s", "|SINOPSE") + "\t"
	                + String.format("%-10s", "|GENERO"));
	        for (Filme filme : listarFilme()) {
	            System.out.println(String.format("%-4s", filme.getId()) + "\t"
	                    + String.format("%-27s", filme.getNome()) + "\t"
	                    + String.format("%-10s", "|" + filme.getSinopse()) + "\t"
	                    + String.format("%-10s", "|" + filme.getGenero()));
	        }
	        System.out.println("\n");
	    }

	    public void mostrarFilmes(List<Filme> filmes) {
	        System.out.println("-----------------------------\n");
	        System.out.println("Esses foram os nomes encontrados");
	        System.out.println(String.format("%-4s", "ID") + "\t"
	                + String.format("%-27s", "|NOME") + "\t"
	                + String.format("%-10s", "|SINOPSE") + "\t"
	                + String.format("%-10s", "|GENERO"));
	        for (Filme filme : filmes) {
	            System.out.println(String.format("%-4s", filme.getId()) + "\t"
	                    + String.format("%-27s", filme.getNome()) + "\t"
	                    + String.format("%-10s", "|" + filme.getSinopse()) + "\t"
	                    + String.format("%-10s", "|" + filme.getGenero()));
	        }
	        System.out.println("\n");
	    }

	    public Filme devolveFilme(int id) {
	        return (new FilmeDaoBd().procurarPorId(id));
	    }

	    public List<Filme> devolveFilmePorNome(String nome) {
	        return (new FilmeDaoBd().procurarPorNome(nome));
	    }

}
