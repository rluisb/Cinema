package controller;

import javax.swing.JOptionPane;

import dao.FilmeDaoBd;
import model.Filme;
import view.FilmeTableModel;
import view.JanelaCrudFilme;
import view.PainelFormularioCliente;
import view.PainelFormularioFilme;
import view.PainelTabelaCliente;
import view.PainelTabelaFilme;

public class FilmeController {

	private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;

    private JanelaCrudFilme janela;
    
    FilmeDaoBd filmebd = new FilmeDaoBd();
    PainelFormularioCliente form = new PainelFormularioCliente();

    public FilmeController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudFilme janela) {
        this.janela = janela;
    }

    public void inserirFilme() {
        PainelFormularioFilme form = this.janela.getPainelFormulario();

        form.getLabelPainelFormulario().setText("Cadastrar Filme");
        form.getBotaoSalvar().setVisible(true);
        form.getBotaoSalvar().setText("Cadastrar");
        this.habilitaEdicaoFormFilme(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaCrudFilme.PAINELFORM);
    }

    public void editarFilme() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        PainelFormularioFilme painelForm = this.janela.getPainelFormulario();
        
        if(painelTabela.getTabelaFilme().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        painelForm.getLabelPainelFormulario().setText("Editar Filme");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        this.habilitaEdicaoFormFilme(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaCrudFilme.PAINELFORM);
    }

    public void visualizarFilme() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        PainelFormularioFilme form = this.janela.getPainelFormulario();

        if(painelTabela.getTabelaFilme().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        form.getLabelPainelFormulario().setText("Visualizar Filme");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        this.habilitaEdicaoFormFilme(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaCrudFilme.PAINELFORM);
    }

    public void removerFilme() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilme().getModel();;
        filmebd.deletar(tableModel.getFilme(painelTabela.getTabelaFilme().getSelectedRow()));
        this.atualizaTabela();
    }

    
    public void salvarFilme(Filme filme) {
        filmebd.inserir(filme);
        this.voltarPrincipal();
    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaCrudFilme.PAINELTABELA);
    }
    
    
    public void atualizaTabela() {
        PainelTabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabelaFilme().getModel();
        tableModel.setFilmes(filmebd.listar());
        
        painelTabela.getTabelaFilme().updateUI();
    }


    private void habilitaEdicaoFormFilme(boolean valor) {
        PainelFormularioFilme form = this.janela.getPainelFormulario();
        
        form.getTextNome().setEditable(valor);
        form.getTextSinopse().setEditable(valor);
        form.getTextGenero().setEditable(valor);
    }

    private void printMessageError(String msg) {
            JOptionPane.showMessageDialog(janela, 
                    msg,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);        
    }
	
}
