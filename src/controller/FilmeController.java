package controller;

import javax.swing.JOptionPane;

import model.Filme;
import servico.FilmeServico;

public class FilmeController {
	private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;
    
    private int telaAtual = 0;
    private int linhaSelecionada = -1;
    
    private JanelaFilme janela;
    
    private FilmeServico servicoFilme;
    
    public FilmeController() {
        telaAtual = TABELA;
        servicoFilme = new FilmeServico();
    }
    
    public void setJanela(JanelaFilme janela) {
        this.janela = janela;
    }
    
    public void inserirFilme() {
        FormularioFilme painelForm = this.janela.getPainelFormulario();
        
        painelForm.limparCampos(); 

        painelForm.getjLabelMensagem().setText("Preencha os Dados do Filme");
        painelForm.getJtID().setVisible(false);
        painelForm.getjLabelID().setVisible(false);
        painelForm.getjLabelObservacao().setVisible(false);
        painelForm.getJbCadastrar().setVisible(true);
        painelForm.getJbCadastrar().setText("Cadastrar");
        painelForm.habilitaEdicaoFormFilme(true);
        
        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaFilme.PAINELFORM);
    }
    
    public void editarFilme() {
        TabelaFilme painelTabela = this.janela.getPainelTabela();
        FormularioFilme painelForm = this.janela.getPainelFormulario();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabela().getModel();
        
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela, "Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }
        Filme Filme = tableModel.getFilme(linhaSelecionada);
        painelForm.carregaDados(Filme.getId(),Filme.getNome(), Filme.getRg(), Filme.getTelefone());

        painelForm.getjLabelMensagem().setText("Atualize os Dados do Filme");
        painelForm.getjLabelID().setVisible(true);
        painelForm.getJtID().setVisible(true);
        painelForm.getjLabelObservacao().setVisible(true);
        painelForm.getJbCadastrar().setVisible(true);
        painelForm.getJbCadastrar().setText("Editar");
        painelForm.habilitaEdicaoFormFilme(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaFilme.PAINELFORM);
    }
    
    public void visualizarFilmes() {
        TabelaFilme painelTabela = this.janela.getPainelTabela();
        FormularioFilme form = this.janela.getPainelFormulario();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabela().getModel();

        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Nao ha nenhum elemento selecionado na tabela", "Alerta", JOptionPane.ERROR_MESSAGE);                    
            return;
        }
        Filme Filme = tableModel.getFilme(linhaSelecionada);
        form.carregaDados(Filme.getId(),Filme.getNome(),Filme.getRg(), Filme.getTelefone());        
        
        form.getjLabelID().setVisible(true);
        form.getJtID().setVisible(true);
        form.getjLabelObservacao().setVisible(false);
        form.getjLabelMensagem().setText("Dados do Filme Selecionado");
        form.getJbCadastrar().setVisible(false);
        form.getJbCadastrar().setText("");
        form.habilitaEdicaoFormFilme(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaFilme.PAINELFORM);
    }
    
    public void removerFilme() {
        TabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabela().getModel();
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }
        Filme Filme = tableModel.getFilme(linhaSelecionada);        
        servicoFilme.deletarFilme(Filme);
        JOptionPane.showMessageDialog(janela,"Remocao realizada com sucesso!");
        
        this.atualizaTabela();
    }
    
    public void salvarFilme(String nome, String RG, String tele) {
        FormularioFilme painelForm = this.janela.getPainelFormulario();
        TabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel tableModel = (FilmeTableModel) painelTabela.getTabela().getModel();
        if(telaAtual==FORMCADASTRO){
            Filme Filme = new Filme(nome, RG, tele);
            servicoFilme.addFilme(Filme);
            JOptionPane.showMessageDialog(janela,"Cadastro realizado com sucesso!");
            painelForm.limparCampos();
        }
        else{
            linhaSelecionada = painelTabela.getTabela().getSelectedRow();
            int idFilme = tableModel.getFilme(linhaSelecionada).getId();
            Filme Filme = new Filme(idFilme, nome, RG, tele);
            servicoFilme.atualizaFilme(Filme);
            JOptionPane.showMessageDialog(janela,"Edicao realizada com sucesso!");          
        }        
    }
    
    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaFilme.PAINELTABELA);
    }
    
    public void atualizaTabela() {
        TabelaFilme painelTabela = this.janela.getPainelTabela();
        FilmeTableModel modelo = (FilmeTableModel) painelTabela.getTabela().getModel();
        
        modelo.setFilmes(servicoFilme.listarFilme());
        
        painelTabela.getTabela().updateUI();
    }

}
