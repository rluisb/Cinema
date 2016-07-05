package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.FilmeController;

public class JanelaCrudFilme extends JFrame {
    private FilmeController controller;
    
    public final static String PAINELFORM = "Formulario";
    public final static String PAINELTABELA = "Tabela";
    private JPanel painelPrincipal;    
    private PainelFormularioFilme painelFormulario;
    private PainelTabelaFilme painelTabela;

    public JanelaCrudFilme(FilmeController controller) {
        this.controller = controller;
        this.controller.setJanela(this);
        iniciaComponentes();
        this.controller.atualizaTabela();
        this.setTitle("Aplicacao CRUD Filmes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new PainelTabelaFilme(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioFilme(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);
        this.add(painelPrincipal);
    }
    

    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioFilme getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaFilme getPainelTabela() {
        return painelTabela;
    }

    public void setController(FilmeController controller) {
        this.controller = controller;
    }
    
    

}
