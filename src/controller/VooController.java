package controller;

import servico.AviaoServico;
import comboBoxModel.AviaoComboBoxModel;
import tableModels.VooTableModel;
import viewFomularios.FormularioVoo;
import viewTabelas.TabelaVoo;
import servico.VooServico;
import view.JanelaVoo;
import comboBoxModel.PonteComboBoxModel;
import javax.swing.JOptionPane;
import model.Voo;

/**
 *
 * @author Thiago
 */
public class VooController {

    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;
//    private final static int TABELA_AVIAO = 4;
//    private final static int TABELA_ROTA = 5;

    private int telaAtual = 0;
    private int linhaSelecionada = -1;

    private JanelaVoo janela;

    private VooServico servicoV;
    private AviaoServico servicoA;

    public VooController() {
        telaAtual = TABELA;
        servicoV = new VooServico();
        servicoA = new AviaoServico();
    }
    
     public VooController(JanelaVoo janela) {
        this.telaAtual = TABELA;
        this.servicoV = new VooServico();
        this.servicoA = new AviaoServico();
        this.janela = janela;
    }

    public void setJanela(JanelaVoo janela) {
        this.janela = janela;
    }

    public void inserirVoo() {
        FormularioVoo painelForm = this.janela.getPainelFormulario();

        painelForm.limparCampos();

        //painelForm.getLabelPainelFormulario().setText("Cadastrar Paciente");
        //painelForm.setTitle("Cadastrar Avião");        
//        painelForm.getjTID().setEditable(false);
//        painelForm.getjTCampoAviao().setEditable(false);
//        painelForm.getjTPonte().setEditable(false);
//        painelForm.getjComboBoxAviao().setModel(new AviaoComboBoxModel(servicoA.listarAviao()));
        painelForm.getjLabelID().setVisible(false);
        painelForm.getjtID().setVisible(false);
        painelForm.getjBCadastrar().setVisible(true);
        painelForm.getjBCadastrar().setText("Cadastrar");
        
        painelForm.habilitaEdicaoFormVoo(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaVoo.PAINELFORM);
    }
    
    public void editarVoo() {
        TabelaVoo painelTabela = this.janela.getPainelTabela();
        FormularioVoo painelForm = this.janela.getPainelFormulario();
        VooTableModel tableModel = (VooTableModel) painelTabela.getTabela().getModel();
        
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela, "Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Voo voo = tableModel.getVoo(linhaSelecionada);
        painelForm.carregaDados(voo.getCodigo(), voo.getAviao(), voo.getPonte(), voo.getHorarioDoVoo());

        //painelForm.getLabelPainelFormulario().setText("Editar Paciente");
        //painelForm.setTitle("Editar Avião");
        painelForm.getjLabelMensagem().setText("Atualize os Dados do Voo");
        painelForm.getjLabelID().setVisible(true);
        painelForm.getjtID().setVisible(true);
        painelForm.getjLabelDataIdeal().setVisible(true);
        painelForm.getjLabelHoraIdeal().setVisible(true);
        painelForm.getjBCadastrar().setVisible(true);
        painelForm.getjBCadastrar().setText("Editar");
        painelForm.habilitaEdicaoFormVoo(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaVoo.PAINELFORM);
    }
    
    public void removerVoo() {
        TabelaVoo painelTabela = this.janela.getPainelTabela();
        VooTableModel tableModel = (VooTableModel) painelTabela.getTabela().getModel();
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Voo voo = tableModel.getVoo(linhaSelecionada);        
        servicoV.deletarVoo(voo);
        JOptionPane.showMessageDialog(janela,"Remoção realizada com sucesso!");
        
        this.atualizaTabela();
    }
    
    public void visualizarVoos() {
        TabelaVoo painelTabela = this.janela.getPainelTabela();
        FormularioVoo form = this.janela.getPainelFormulario();
        VooTableModel tableModel = (VooTableModel) painelTabela.getTabela().getModel();

        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0) //|| linhaSelecionada > 1)
        {
            JOptionPane.showMessageDialog(janela,"Não há nenhum elemento selecionado na tabela", "Alerta", JOptionPane.ERROR_MESSAGE);                    
            return;
        }
        Voo voo = tableModel.getVoo(linhaSelecionada);
        form.carregaDados(voo.getCodigo(),voo.getAviao(),voo.getPonte(), voo.getHorarioDoVoo());        
        
        //form.getLabelPainelFormulario().setText("Visualizar Paciente");
        //form.setTitle("Visualizar Aviões");
        form.getjLabelID().setVisible(true);
        form.getjtID().setVisible(true);
        form.getjLabelDataIdeal().setVisible(false);
        form.getjLabelHoraIdeal().setVisible(false);
        form.getjLabelMensagem().setText("Dados do Voo Selecionado");
        form.getjBCadastrar().setVisible(false);
        form.getjBCadastrar().setText("");
        form.habilitaEdicaoFormVoo(false);
        UIController.makeComboReadonly(janela.getPainelFormulario().getjComboBoxAviao());
        UIController.makeComboReadonly(janela.getPainelFormulario().getjComboBoxPonte());

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaVoo.PAINELFORM);
    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.atualizaComboBox();
        this.janela.mostrarPainel(JanelaVoo.PAINELTABELA);
    }

    public void atualizaTabela() {
        TabelaVoo painelTabela = this.janela.getPainelTabela();
        VooTableModel modelo = (VooTableModel) painelTabela.getTabela().getModel();

        //PacienteDao dao = new PacienteDaoBd();
        modelo.setVoos(servicoV.listarVoo());

        painelTabela.getTabela().updateUI();
    }
    
    public void atualizaComboBox() {
        FormularioVoo painelFormulario = this.janela.getPainelFormulario();
        AviaoComboBoxModel modeloAviao = (AviaoComboBoxModel) painelFormulario.getjComboBoxAviao().getModel();
        PonteComboBoxModel modeloPonte = (PonteComboBoxModel) painelFormulario.getjComboBoxPonte().getModel();
        
        modeloAviao.setAvioes(servicoA.listarAviao());
        modeloPonte.setPonte(servicoV.listarPontes());
        
        painelFormulario.getjComboBoxAviao().updateUI();
        painelFormulario.getjComboBoxPonte().updateUI();
    }
}
