package servico;

import java.util.List;

import dao.SalaDao;
import dao.SalaDaoBd;
import model.Sala;

public class SalaServico {
	
	 public boolean salaExiste(int id) {
        SalaDao dao = new SalaDaoBd();
        Sala sala = dao.procurarPorId(id);
        return (sala != null);
    }

    public void addSala(Sala sala) {
        new SalaDaoBd().inserir(sala);
    }

    public void atualizaSala(Sala sala) {
        new SalaDaoBd().atualizar(sala);
    }

    public void deletarSala(Sala sala) {
        new SalaDaoBd().deletar(sala);
    }

    public List<Sala> listarSala() {
        return (new SalaDaoBd().listar());
    }

    public void mostrarSalas() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-4s", "ID") + "\t"
                + String.format("%-27s", "|NUMERO") + "\t"
                + String.format("%-10s", "|POLTRONAS") + "\t"
                + String.format("%-10s", "|FILME"));
        for (Sala sala : listarSala()) {
            System.out.println(String.format("%-4s", sala.getId()) + "\t"
                    + String.format("%-27s", sala.getNumero()) + "\t"
                    + String.format("%-10s", "|" + sala.getPoltronas()) + "\t"
                    + String.format("%-10s", "|" + sala.getFilme().getNome()));
        }
        System.out.println("\n");
    }

    public void mostrarSalas(List<Sala> salas) {
        System.out.println("-----------------------------\n");
        System.out.println("Esses foram os nomes encontrados");
        System.out.println(String.format("%-4s", "ID") + "\t"
                + String.format("%-27s", "|NUMERO") + "\t"
                + String.format("%-10s", "|POLTRONAS") + "\t"
                + String.format("%-10s", "|FILME"));
        for (Sala sala : salas) {
            System.out.println(String.format("%-4s", sala.getId()) + "\t"
                    + String.format("%-27s", sala.getNumero()) + "\t"            
                    + String.format("%-10s", "|" + sala.getPoltronas()) + "\t"   
                    + String.format("%-10s", "|" + sala.getFilme().getNome()));  
        }
        System.out.println("\n");
    }

    public Sala devolveSala(int id) {
        return (new SalaDaoBd().procurarPorId(id));
    }

    public Sala devolveSalaPorNumero(int numero) {
        return (new SalaDaoBd().procurarPorNumero(numero));
    }

}
