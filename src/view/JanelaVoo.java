package view;
import viewTabelas.TabelaVoo;
import viewFomularios.FormularioVoo;
import controller.VooController;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Thiago
 */
public class JanelaVoo extends javax.swing.JInternalFrame {
    private VooController controller;
    public final static String PAINELFORM = "FormularioVoo";
    public final static String PAINELTABELA = "TabelaVoo";
    public final static String PAINEL_PEGA_AVIAO = "TabelaAviao";
    public final static String PAINEL_PEGA_ROTA = "TabelaPonte";
    private JPanel painelPrincipal;    
    private FormularioVoo painelFormulario;
    private TabelaVoo painelTabela;
    
//    private TabelaAviao painelSelectAviao; Acho q não vou precisar trazer o painel de Tabela do aviao e sim transformar a tabela do painel do Voo em uma tabela de avião atualizada
//    private TabelaPonte painelSelectPonte;Acho q não vou precisar criar um painel de Tabela do ponte e sim transformar a tabela do painel do Voo em uma tabela de ponte atualizada
    
    public JanelaVoo(VooController control) {
        this.controller = control;
        this.controller.setJanela(this);
        iniciaComponentes();
        controller.atualizaTabela();
        controller.atualizaComboBox();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);        
    }
    
    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new TabelaVoo(controller);        
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new FormularioVoo(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);        
        this.add(painelPrincipal);
        this.setClosable(true);
        this.setTitle("Menu Voo");
    }
    
    public void mostrarPainel(String painel) {
    CardLayout card = (CardLayout) (painelPrincipal.getLayout());
    card.show(painelPrincipal, painel);        
    }
    
    public FormularioVoo getPainelFormulario() {
        return painelFormulario;
    }

    public TabelaVoo getPainelTabela() {
        return painelTabela;
    }

    public void setController(VooController controller) {
        this.controller = controller;
    }
}
