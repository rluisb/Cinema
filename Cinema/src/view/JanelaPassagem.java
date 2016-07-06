package view;
import viewTabelas.TabelaPassagem;
import viewFomularios.FormularioPassagem;
import controller.PassagemController;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Thiago
 */
public class JanelaPassagem extends javax.swing.JInternalFrame {

    private PassagemController controller;
    public final static String PAINELFORM = "FormularioPassagem";
    public final static String PAINELTABELA = "TabelaPassagem";
    private JPanel painelPrincipal;
    private FormularioPassagem painelFormulario;
    private TabelaPassagem painelTabela;

    public JanelaPassagem(PassagemController control) {
        this.controller = control;
        this.controller.setJanela(this);
        iniciaComponentes();
        controller.atualizaTabela();
        controller.atualizaComboBox();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void mostrarPainel(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);
    }

    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new TabelaPassagem(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new FormularioPassagem(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);
        this.add(painelPrincipal);
        this.setClosable(true);
        this.setTitle("Menu Passagem");
    }
    
    public FormularioPassagem getPainelFormulario() {
        return painelFormulario;
    }

    public TabelaPassagem getPainelTabela() {
        return painelTabela;
    }

    public void setController(PassagemController controller) {
        this.controller = controller;
    }
}
