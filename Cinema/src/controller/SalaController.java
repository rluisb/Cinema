package controller;

import javax.swing.JOptionPane;

import dao.SalaDaoBd;
import model.Sala;
import view.JanelaCrudSala;
import view.PainelFormularioSala;
import view.PainelTabelaSala;
import view.SalaTableModel;

public class SalaController {

	private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;

    private JanelaCrudSala janela;
    
    SalaDaoBd salabd = new SalaDaoBd();
    PainelFormularioSala form = new PainelFormularioSala();

    public SalaController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudSala janela) {
        this.janela = janela;
    }

    public void inserirSala() {
        PainelFormularioSala form = this.janela.getPainelFormulario();

        form.getLabelPainelFormulario().setText("Cadastrar Sala");
        form.getBotaoSalvar().setVisible(true);
        form.getBotaoSalvar().setText("Cadastrar");
        this.habilitaEdicaoFormSala(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaCrudSala.PAINELFORM);
    }

    public void editarSala() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        PainelFormularioSala painelForm = this.janela.getPainelFormulario();
        
        if(painelTabela.getTabelaSala().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        painelForm.getLabelPainelFormulario().setText("Editar Sala");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        this.habilitaEdicaoFormSala(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaCrudSala.PAINELFORM);
    }

    public void visualizarSala() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        PainelFormularioSala form = this.janela.getPainelFormulario();

        if(painelTabela.getTabelaSala().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        form.getLabelPainelFormulario().setText("Visualizar Sala");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        this.habilitaEdicaoFormSala(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaCrudSala.PAINELFORM);
    }

    public void removerSala() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSala().getModel();;
        salabd.deletar(tableModel.getSala(painelTabela.getTabelaSala().getSelectedRow()));
        this.atualizaTabela();
    }

    
    public void salvarSala(Sala sala) {
        salabd.inserir(sala);
        this.voltarPrincipal();
    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaCrudSala.PAINELTABELA);
    }
    
    
    public void atualizaTabela() {
        PainelTabelaSala painelTabela = this.janela.getPainelTabela();
        SalaTableModel tableModel = (SalaTableModel) painelTabela.getTabelaSala().getModel();
        tableModel.setSalas(salabd.listar());
        
        painelTabela.getTabelaSala().updateUI();
    }


    private void habilitaEdicaoFormSala(boolean valor) {
        PainelFormularioSala form = this.janela.getPainelFormulario();
        
        form.getTextNumero().setEditable(valor);
        form.getTextPoltronas().setEditable(valor);
    }

    private void printMessageError(String msg) {
            JOptionPane.showMessageDialog(janela, 
                    msg,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);        
    }
	
}
