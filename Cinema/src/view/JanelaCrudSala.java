package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.SalaController;

public class JanelaCrudSala extends JFrame {
    private SalaController controller;
    
    public final static String PAINELFORM = "Formulario";
    public final static String PAINELTABELA = "Tabela";
    private JPanel painelPrincipal;    
    private PainelFormularioSala painelFormulario;
    private PainelTabelaSala painelTabela;

    public JanelaCrudSala(SalaController controller) {
        this.controller = controller;
        this.controller.setJanela(this);
        iniciaComponentes();
        this.controller.atualizaTabela();
        this.setTitle("Aplicacao CRUD Pacientes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new PainelTabelaSala(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioSala(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);
        this.add(painelPrincipal);
    }
    

    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioSala getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaSala getPainelTabela() {
        return painelTabela;
    }

    public void setController(SalaController controller) {
        this.controller = controller;
    }
    
    

}
