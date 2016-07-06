package controller;

import comboBoxModel.VooComboBoxModel;
import javax.swing.JOptionPane;
import model.Passagem;
import servico.ClienteServico;
import tableModels.PassagemTableModel;
import viewFomularios.FormularioSala;
import viewTabelas.TabelaPassagem;
import servico.VooServico;
import servico.PassagemServico;
import view.JanelaPassagem;
/**
 *
 * @author Thiago
 */
public class PassagemController {
    
    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;
    
    private int telaAtual = 0;
    private int linhaSelecionada = -1;
    
    private JanelaPassagem janela;
    
    private PassagemServico servicoP;
    private VooServico servicoV;
    private ClienteServico servicoC;
    
    public PassagemController() {
        telaAtual = TABELA;
        servicoV = new VooServico();
        servicoP = new PassagemServico();
        servicoC = new ClienteServico();
    }
    
    public PassagemController(JanelaPassagem janela) {
        this.telaAtual = TABELA;
        this.servicoV = new VooServico();
        this.servicoP = new PassagemServico();
        this.servicoC = new ClienteServico();
        this.janela = janela;
    }
    
    public void inserirPassagem() {
        FormularioSala painelForm = this.janela.getPainelFormulario();

        painelForm.limparCampos();
        
        painelForm.getjLabelMensagem().setText("Preencha os Dados da Passagem");
        painelForm.getjLabelID().setVisible(false);
        painelForm.getjTextFieldID().setVisible(false);
        painelForm.getjBCadastrar().setVisible(true);
        painelForm.getjBCadastrar().setText("Cadastrar");
        painelForm.getjTextHoraAtual().setVisible(false);
        painelForm.getjLabelHoraAtual().setVisible(false);
        painelForm.getjLabelObservacao().setVisible(false);
        
        painelForm.habilitaEdicaoFormPassagem(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaPassagem.PAINELFORM);
    }
    
    public void editarPassagem() {
        TabelaPassagem painelTabela = this.janela.getPainelTabela();
        FormularioSala painelForm = this.janela.getPainelFormulario();
        PassagemTableModel tableModel = (PassagemTableModel) painelTabela.getTabela().getModel();
        
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela, "Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Passagem passagem = tableModel.getPassagem(linhaSelecionada);
        painelForm.carregaDados(passagem.getCodigo(), passagem.getCliente().getRG(), passagem.getVoo(), passagem.getHoraVenda());

        painelForm.getjLabelMensagem().setText("Atualize os Dados da Passagem");
        painelForm.getjLabelID().setVisible(true);
        painelForm.getjTextFieldID().setVisible(true);
        painelForm.getjBCadastrar().setVisible(true);
        painelForm.getjBCadastrar().setText("Editar");
        painelForm.getjTextHoraAtual().setVisible(true);
        painelForm.getjLabelHoraAtual().setVisible(true);
        painelForm.getjLabelObservacao().setVisible(true);
        painelForm.habilitaEdicaoFormPassagem(true);

        telaAtual = FORMEDICAO;
        this.janela.getPainelFormulario().carregaText();
        this.janela.mostrarPainel(JanelaPassagem.PAINELFORM);
    }
    
    public void visualizarPassagem() {
        TabelaPassagem painelTabela = this.janela.getPainelTabela();
        FormularioSala painelForm = this.janela.getPainelFormulario();
        PassagemTableModel tableModel = (PassagemTableModel) painelTabela.getTabela().getModel();
        
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela, "Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Passagem passagem = tableModel.getPassagem(linhaSelecionada);
        painelForm.carregaDados(passagem.getCodigo(), passagem.getCliente().getRG(), passagem.getVoo(), passagem.getHoraVenda());

        painelForm.getjLabelMensagem().setText("Dados da Passagem");
        painelForm.getjLabelID().setVisible(true);
        painelForm.getjTextFieldID().setVisible(true);
        painelForm.getjBCadastrar().setVisible(false);
        painelForm.getjBCadastrar().setText("");
        painelForm.getjTextHoraAtual().setVisible(true);
        painelForm.getjLabelHoraAtual().setVisible(true);
        painelForm.getjLabelObservacao().setVisible(false);
        painelForm.habilitaEdicaoFormPassagem(false);
        UIController.makeComboReadonly(janela.getPainelFormulario().getjComboBoxVoo());

        telaAtual = FORMEDICAO;
        this.janela.getPainelFormulario().carregaText();
        this.janela.mostrarPainel(JanelaPassagem.PAINELFORM);
    }
    
    public void removerPassagem() {
        TabelaPassagem painelTabela = this.janela.getPainelTabela();
        PassagemTableModel tableModel = (PassagemTableModel) painelTabela.getTabela().getModel();
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Passagem voo = tableModel.getPassagem(linhaSelecionada);        
        servicoP.deletarPassagem(voo);
        JOptionPane.showMessageDialog(janela,"Remoção realizada com sucesso!");
        
        this.atualizaTabela();
    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.atualizaComboBox();
        this.janela.mostrarPainel(JanelaPassagem.PAINELTABELA);
    }
    
    public void atualizaTabela() {
        TabelaPassagem painelTabela = this.janela.getPainelTabela();
        PassagemTableModel modelo = (PassagemTableModel) painelTabela.getTabela().getModel();

        //PacienteDao dao = new PacienteDaoBd();
        modelo.setPassagens(servicoP.listarPassagem());

        painelTabela.getTabela().updateUI();
    }
    
    public void atualizaComboBox() {
        FormularioSala painelFormulario = this.janela.getPainelFormulario();
        VooComboBoxModel modeloVoo = (VooComboBoxModel) painelFormulario.getjComboBoxVoo().getModel();
                
        modeloVoo.setVoos(servicoV.listarVoo());        
        painelFormulario.getjComboBoxVoo().updateUI();        
    }

    public void setJanela(JanelaPassagem janela) {
        this.janela = janela;
    }    
}
