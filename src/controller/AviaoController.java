
package controller;

import javax.swing.JOptionPane;
import model.Aviao;
import view.JanelaAviao;
import tableModels.AviaoTableModel;
import viewFomularios.FormularioFilme;
import viewTabelas.TabelaAviao;
import servico.AviaoServico;
/**
 *
 * @author Thiago
 */
public class AviaoController {
    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;
    
    private int telaAtual = 0;
    private int linhaSelecionada = -1;
    
    private JanelaAviao janela;
    
    private AviaoServico servicoA;
    
    public AviaoController() {
        telaAtual = TABELA;
        servicoA = new AviaoServico();
    }
    
    public void setJanela(JanelaAviao janela) {
        this.janela = janela;
    }
    
    public void inserirAviao() {
        FormularioFilme painelForm = this.janela.getPainelFormulario();
        
        painelForm.limparCampoNome(); 

        //painelForm.getLabelPainelFormulario().setText("Cadastrar Paciente");
        //painelForm.setTitle("Cadastrar Avião");
        painelForm.getjLabelMensagem().setText("Escreva o NOME do Avião");
        painelForm.getJtCod().setVisible(false);
        painelForm.getJlabelCod().setVisible(false);
        painelForm.getJbCadastrar().setVisible(true);
        painelForm.getJbCadastrar().setText("Cadastrar");
        painelForm.habilitaEdicaoFormAviao(true);
        
        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaAviao.PAINELFORM);
    }
    
    public void editarAviao() {
        TabelaAviao painelTabela = this.janela.getPainelTabela();
        FormularioFilme painelForm = this.janela.getPainelFormulario();
        AviaoTableModel tableModel = (AviaoTableModel) painelTabela.getTabela().getModel();
        
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela, "Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Aviao avi = tableModel.getAviao(linhaSelecionada);
        painelForm.carregaDados(avi.getCodigo(), avi.getNome());

        //painelForm.getLabelPainelFormulario().setText("Editar Paciente");
        //painelForm.setTitle("Editar Avião");
        painelForm.getjLabelMensagem().setText("Atualize o NOME do Avião");
        painelForm.getJlabelCod().setVisible(true);
        painelForm.getJtCod().setVisible(true);
        painelForm.getJbCadastrar().setVisible(true);
        painelForm.getJbCadastrar().setText("Editar");
        painelForm.habilitaEdicaoFormAviao(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaAviao.PAINELFORM);        
    }
    
    public void visualizarAvioes() {
        TabelaAviao painelTabela = this.janela.getPainelTabela();
        FormularioFilme form = this.janela.getPainelFormulario();
        AviaoTableModel tableModel = (AviaoTableModel) painelTabela.getTabela().getModel();

        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Aviao avi = tableModel.getAviao(linhaSelecionada);
        form.carregaDados(avi.getCodigo(), avi.getNome());        
        
        //form.getLabelPainelFormulario().setText("Visualizar Paciente");
        //form.setTitle("Visualizar Aviões");
        form.getjLabelMensagem().setText("Os Campos não podem ser alterados");
        form.getJbCadastrar().setVisible(false);
        form.getJbCadastrar().setText("");
        form.habilitaEdicaoFormAviao(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaAviao.PAINELFORM);
    }
    
    public void removerAviao() {
        TabelaAviao painelTabela = this.janela.getPainelTabela();
        AviaoTableModel tableModel = (AviaoTableModel) painelTabela.getTabela().getModel();
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Não há nenhum elemento selecionado na tabela");                    
            return;
        }
        Aviao avi = tableModel.getAviao(linhaSelecionada);        
        //PacienteDao dao = new PacienteDaoBd();
        servicoA.deletarAviao(avi);
        JOptionPane.showMessageDialog(janela,"Remoção realizada com sucesso!");
        
        this.atualizaTabela();
    }
    
    public void salvarAviao(String nome) {
        FormularioFilme painelForm = this.janela.getPainelFormulario();
        TabelaAviao painelTabela = this.janela.getPainelTabela();
        AviaoTableModel tableModel = (AviaoTableModel) painelTabela.getTabela().getModel();
        if(telaAtual==FORMCADASTRO){
            Aviao aviao = new Aviao(nome);
            //PacienteDao dao = new PacienteDaoBd();
            servicoA.addAviao(aviao);
            JOptionPane.showMessageDialog(janela,"Cadastro realizado com sucesso!");
            painelForm.limparCampoNome();
        }
        else{
            linhaSelecionada = painelTabela.getTabela().getSelectedRow();
            int idAviao = tableModel.getAviao(linhaSelecionada).getCodigo();
            Aviao aviao = new Aviao(idAviao, nome);
            //PacienteDao dao = new PacienteDaoBd();
            servicoA.atualizaAviao(aviao);
            JOptionPane.showMessageDialog(janela,"Edição realizada com sucesso!");          
        }        
    }
    
    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaAviao.PAINELTABELA);
    }
    
    public void atualizaTabela() {
        TabelaAviao painelTabela = this.janela.getPainelTabela();
        AviaoTableModel modelo = (AviaoTableModel) painelTabela.getTabela().getModel();
        
        //PacienteDao dao = new PacienteDaoBd();
        modelo.setAvioes(servicoA.listarAviao());
        
        painelTabela.getTabela().updateUI();
    }
}
