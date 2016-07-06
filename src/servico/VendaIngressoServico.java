package servico;

import java.util.List;

import dao.VendaIngressoDaoBd;
import model.VendaIngresso;

public class VendaIngressoServico {
	
    public void addVendaIngresso(VendaIngresso vendaIngresso) {
        new VendaIngressoDaoBd().inserir(vendaIngresso);
    }

    public void atualizaVendaIngresso(VendaIngresso vendaIngresso) {
        new VendaIngressoDaoBd().atualizar(vendaIngresso);
    }

    public void deletarVendaIngresso(VendaIngresso vendaIngresso) {
        new VendaIngressoDaoBd().deletar(vendaIngresso);
    }

    public List<VendaIngresso> listarVendaIngresso() {
        return (new VendaIngressoDaoBd().listar());
    }

    public void mostrarVendaIngressos() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-4s", "ID") + "\t"
                + String.format("%-27s", "|NOME") + "\t"
                + String.format("%-10s", "|SALA") + "\t"
                + String.format("%-10s", "|FILME") + "\t"
                + String.format("%-10s", "|GENERO") + "\t"
                + String.format("%-10s", "|DATA"));
        for (VendaIngresso vendaIngresso : listarVendaIngresso()) {
            System.out.println(String.format("%-4s", vendaIngresso.getId()) + "\t"
                    + String.format("%-27s", vendaIngresso.getCliente().getNome()) + "\t"
                    + String.format("%-10s", "|" + vendaIngresso.getSessao().getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + vendaIngresso.getSessao().getSala().getFilme().getNome()) + "\t"
              		+ String.format("%-10s", "|" + vendaIngresso.getSessao().getSala().getFilme().getGenero()) + "\t"
                    + String.format("%-10s", "|" + vendaIngresso.getSessao().getHora()));
        }
        System.out.println("\n");
    }

    public void mostrarVendaIngressos(List<VendaIngresso> vendaIngressos) {
        System.out.println("-----------------------------\n");
        System.out.println("Esses foram os nomes encontrados");
        System.out.println(String.format("%-4s", "ID") + "\t"
        		+ String.format("%-27s", "|NOME") + "\t"
                + String.format("%-10s", "|SALA") + "\t"
                + String.format("%-10s", "|FILME") + "\t"
                + String.format("%-10s", "|GENERO") + "\t"
                + String.format("%-10s", "|DATA"));
        for (VendaIngresso vendaIngresso : vendaIngressos) {
            System.out.println(String.format("%-4s", vendaIngresso.getId()) + "\t"
            		+ String.format("%-27s", vendaIngresso.getCliente().getNome()) + "\t"
                    + String.format("%-10s", "|" + vendaIngresso.getSessao().getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + vendaIngresso.getSessao().getSala().getFilme().getNome()) + "\t"
              		+ String.format("%-10s", "|" + vendaIngresso.getSessao().getSala().getFilme().getGenero()) + "\t"
                    + String.format("%-10s", "|" + vendaIngresso.getSessao().getHora()));
        }
        System.out.println("\n");
    }

}
