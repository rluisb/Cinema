package view;
import viewTabelas.TabelaAviao;
import viewFomularios.FormularioAviao;
import controller.AviaoController;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Thiago
 */
public class JanelaAviao extends javax.swing.JInternalFrame{
    private AviaoController controller;
    public final static String PAINELFORM = "Formulario";
    public final static String PAINELTABELA = "Tabela";
    private JPanel painelPrincipal;    
    private FormularioAviao painelFormulario;
    private TabelaAviao painelTabela;
    
    public JanelaAviao(AviaoController control) {
        this.controller = control;
        this.controller.setJanela(this);
        iniciaComponentes();
        controller.atualizaTabela();
        this.setTitle("Menu Avião");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new TabelaAviao(controller);
        this.setClosable(true);
        this.setTitle("Menu Aviões");
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new FormularioAviao(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);        
        this.add(painelPrincipal);
    }
    
    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }
    
    public FormularioAviao getPainelFormulario() {
        return painelFormulario;
    }

    public TabelaAviao getPainelTabela() {
        return painelTabela;
    }

    public void setController(AviaoController controller) {
        this.controller = controller;
    }    
}
