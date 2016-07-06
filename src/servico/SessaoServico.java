package servico;

import java.util.List;

import dao.SessaoDao;
import dao.SessaoDaoBd;
import model.Sessao;

public class SessaoServico {

    public boolean sessaoExiste(int id) {
        SessaoDao dao = new SessaoDaoBd();
        Sessao sessao = dao.procurarPorId(id);
        return (sessao != null);
    }

    public void addSessao(Sessao sessao) {
        new SessaoDaoBd().inserir(sessao);
    }

    public void atualizaSessao(Sessao sessao) {
        new SessaoDaoBd().atualizar(sessao);
    }

    public void deletarSessao(Sessao sessao) {
        new SessaoDaoBd().deletar(sessao);
    }

    public List<Sessao> listarSessao() {
        return (new SessaoDaoBd().listar());
    }

    public void mostrarSessaos() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-4s", "ID") + "\t"
                + String.format("%-27s", "|SALA") + "\t"
                + String.format("%-10s", "|HORA"));
        for (Sessao sessao : listarSessao()) {
            System.out.println(String.format("%-4s", sessao.getId()) + "\t"
                    + String.format("%-27s", sessao.getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + sessao.getHora()));
        }
        System.out.println("\n");
    }

    public void mostrarSessaos(List<Sessao> sessaos) {
        System.out.println("-----------------------------\n");
        System.out.println("Esses foram os nomes encontrados");
        System.out.println(String.format("%-4s", "ID") + "\t"
                + String.format("%-27s", "|SALA") + "\t"
                + String.format("%-10s", "|HORA"));
        for (Sessao sessao : sessaos) {
            System.out.println(String.format("%-4s", sessao.getId()) + "\t"
            		+ String.format("%-27s", sessao.getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + sessao.getHora()));
        }
        System.out.println("\n");
    }

    public Sessao devolveSessao(int id) {
        return (new SessaoDaoBd().procurarPorId(id));
    }

    public List<Sessao> devolveSessaoPorFilme(String filme) {
        return (new SessaoDaoBd().procurarPorFilme(filme));
    }
}
