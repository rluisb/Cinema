package principal;

import controller.FilmeController;
import view.JanelaCrudFilme;

public class Main {
    public static void main(String[] args) {
        /*ClienteController controller = new ClienteController();
        JanelaCrudCliente janela = new JanelaCrudCliente(controller);
        controller.setJanela(janela);*/
    	
    	FilmeController controller = new FilmeController();
        JanelaCrudFilme janela = new JanelaCrudFilme(controller);
        controller.setJanela(janela);
    	
    	
    }
}
