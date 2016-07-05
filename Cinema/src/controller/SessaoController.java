package controller;

import javax.swing.JOptionPane;

import dao.SessaoDaoBd;
import model.Sessao;
import view.JanelaCrudSessao;
import view.PainelFormularioSessao;
import view.PainelTabelaSessao;
import view.SessaoTableModel;

public class SessaoController {

	private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;

    private JanelaCrudSessao janela;
    
    SessaoDaoBd sessaobd = new SessaoDaoBd();
    PainelFormularioSessao form = new PainelFormularioSessao();

    public SessaoController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudSessao janela) {
        this.janela = janela;
    }

    public void inserirSessao() {
        PainelFormularioSessao form = this.janela.getPainelFormulario();

        form.getLabelPainelFormulario().setText("Cadastrar Sessao");
        form.getBotaoSalvar().setVisible(true);
        form.getBotaoSalvar().setText("Cadastrar");
        this.habilitaEdicaoFormSessao(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaCrudSessao.PAINELFORM);
    }

    public void editarSessao() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        PainelFormularioSessao painelForm = this.janela.getPainelFormulario();
        
        if(painelTabela.getTabelaSessao().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        painelForm.getLabelPainelFormulario().setText("Editar Sessao");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        this.habilitaEdicaoFormSessao(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaCrudSessao.PAINELFORM);
    }

    public void visualizarSessao() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        PainelFormularioSessao form = this.janela.getPainelFormulario();

        if(painelTabela.getTabelaSessao().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        form.getLabelPainelFormulario().setText("Visualizar Sessao");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        this.habilitaEdicaoFormSessao(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaCrudSessao.PAINELFORM);
    }

    public void removerSessao() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessao().getModel();;
        sessaobd.deletar(tableModel.getSessao(painelTabela.getTabelaSessao().getSelectedRow()));
        this.atualizaTabela();
    }

    
    public void salvarSessao(Sessao sessao) {
        sessaobd.inserir(sessao);
        this.voltarPrincipal();
    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaCrudSessao.PAINELTABELA);
    }
    
    
    public void atualizaTabela() {
        PainelTabelaSessao painelTabela = this.janela.getPainelTabela();
        SessaoTableModel tableModel = (SessaoTableModel) painelTabela.getTabelaSessao().getModel();
        tableModel.setSessaos(sessaobd.listar());
        
        painelTabela.getTabelaSessao().updateUI();
    }


    private void habilitaEdicaoFormSessao(boolean valor) {
        PainelFormularioSessao form = this.janela.getPainelFormulario();
        
        form.getTextSala().setEditable(valor);
        form.getTextHora().setEditable(valor);
        form.getTextFilme().setEditable(valor);
    }

    private void printMessageError(String msg) {
            JOptionPane.showMessageDialog(janela, 
                    msg,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);        
    }
	
}
