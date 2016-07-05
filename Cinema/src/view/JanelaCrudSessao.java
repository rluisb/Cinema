package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.SessaoController;

public class JanelaCrudSessao extends JFrame {
    private SessaoController controller;
    
    public final static String PAINELFORM = "Formulario";
    public final static String PAINELTABELA = "Tabela";
    private JPanel painelPrincipal;    
    private PainelFormularioSessao painelFormulario;
    private PainelTabelaSessao painelTabela;

    public JanelaCrudSessao(SessaoController controller) {
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
        painelTabela = new PainelTabelaSessao(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioSessao(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);
        this.add(painelPrincipal);
    }
    

    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioSessao getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaSessao getPainelTabela() {
        return painelTabela;
    }

    public void setController(SessaoController controller) {
        this.controller = controller;
    }
    
    

}
