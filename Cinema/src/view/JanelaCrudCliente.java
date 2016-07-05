package view;

import controller.ClienteController;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaCrudCliente extends JFrame {
    private ClienteController controller;
    
    public final static String PAINELFORM = "Formulario";
    public final static String PAINELTABELA = "Tabela";
    private JPanel painelPrincipal;    
    private PainelFormularioCliente painelFormulario;
    private PainelTabelaCliente painelTabela;

    public JanelaCrudCliente(ClienteController controller) {
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
        painelTabela = new PainelTabelaCliente(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioCliente(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);
        this.add(painelPrincipal);
    }
    

    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioCliente getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaCliente getPainelTabela() {
        return painelTabela;
    }

    public void setController(ClienteController controller) {
        this.controller = controller;
    }
    
    

}
