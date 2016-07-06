package view;
import viewTabelas.TabelaCliente;
import viewFomularios.FormularioCliente;
    import controller.ClienteController;
    import java.awt.CardLayout;
    import javax.swing.JPanel;

/**
 *
 * @author Thiago
 */
public class JanelaCliente extends javax.swing.JInternalFrame {
    private ClienteController controller;
    public final static String PAINELFORM = "FormularioCliente";
    public final static String PAINELTABELA = "TabelaCliente";
    private JPanel painelPrincipal;    
    private FormularioCliente painelFormulario;
    private TabelaCliente painelTabela;
    
    public JanelaCliente(ClienteController control) {
        this.controller = control;
        this.controller.setJanela(this);
        iniciaComponentes();
        controller.atualizaTabela();        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new TabelaCliente(controller);        
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new FormularioCliente(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);        
        this.add(painelPrincipal);
        this.setClosable(true);
        this.setTitle("Menu Clientes");
    }
    
    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);
    }
    
    public FormularioCliente getPainelFormulario() {
        return painelFormulario;
    }

    public TabelaCliente getPainelTabela() {
        return painelTabela;
    }

    public void setController(ClienteController controller) {
        this.controller = controller;
    }
}
