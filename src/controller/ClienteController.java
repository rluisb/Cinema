package controller;

import javax.swing.JOptionPane;

import model.Cliente;
import servico.ClienteServico;
import tableModels.ClienteTableModel;
import view.JanelaCliente;
import viewFomularios.FormularioCliente;
import viewTabelas.TabelaCliente;

public class ClienteController {
    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;
    
    private int telaAtual = 0;
    private int linhaSelecionada = -1;
    
    private JanelaCliente janela;
    
    private ClienteServico servicoCliente;
    
    public ClienteController() {
        telaAtual = TABELA;
        servicoCliente = new ClienteServico();
    }
    
    public void setJanela(JanelaCliente janela) {
        this.janela = janela;
    }
    
    public void inserirCliente() {
        FormularioCliente painelForm = this.janela.getPainelFormulario();
        
        painelForm.limparCampos(); 

        painelForm.getjLabelMensagem().setText("Preencha os Dados do Cliente");
        painelForm.getJtID().setVisible(false);
        painelForm.getjLabelID().setVisible(false);
        painelForm.getjLabelObservacao().setVisible(false);
        painelForm.getJbCadastrar().setVisible(true);
        painelForm.getJbCadastrar().setText("Cadastrar");
        painelForm.habilitaEdicaoFormCliente(true);
        
        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaCliente.PAINELFORM);
    }
    
    public void editarCliente() {
        TabelaCliente painelTabela = this.janela.getPainelTabela();
        FormularioCliente painelForm = this.janela.getPainelFormulario();
        ClienteTableModel tableModel = (ClienteTableModel) painelTabela.getTabela().getModel();
        
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela, "Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }
        Cliente cliente = tableModel.getCliente(linhaSelecionada);
        painelForm.carregaDados(cliente.getId(),cliente.getNome(), cliente.getRg(), cliente.getTelefone());

        painelForm.getjLabelMensagem().setText("Atualize os Dados do Cliente");
        painelForm.getjLabelID().setVisible(true);
        painelForm.getJtID().setVisible(true);
        painelForm.getjLabelObservacao().setVisible(true);
        painelForm.getJbCadastrar().setVisible(true);
        painelForm.getJbCadastrar().setText("Editar");
        painelForm.habilitaEdicaoFormCliente(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaCliente.PAINELFORM);
    }
    
    public void visualizarClientes() {
        TabelaCliente painelTabela = this.janela.getPainelTabela();
        FormularioCliente form = this.janela.getPainelFormulario();
        ClienteTableModel tableModel = (ClienteTableModel) painelTabela.getTabela().getModel();

        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Nao ha nenhum elemento selecionado na tabela", "Alerta", JOptionPane.ERROR_MESSAGE);                    
            return;
        }
        Cliente cliente = tableModel.getCliente(linhaSelecionada);
        form.carregaDados(cliente.getId(),cliente.getNome(),cliente.getRg(), cliente.getTelefone());        
        
        form.getjLabelID().setVisible(true);
        form.getJtID().setVisible(true);
        form.getjLabelObservacao().setVisible(false);
        form.getjLabelMensagem().setText("Dados do Cliente Selecionado");
        form.getJbCadastrar().setVisible(false);
        form.getJbCadastrar().setText("");
        form.habilitaEdicaoFormCliente(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaCliente.PAINELFORM);
    }
    
    public void removerCliente() {
        TabelaCliente painelTabela = this.janela.getPainelTabela();
        ClienteTableModel tableModel = (ClienteTableModel) painelTabela.getTabela().getModel();
        linhaSelecionada = painelTabela.getTabela().getSelectedRow();
        if(linhaSelecionada < 0)
        {
            JOptionPane.showMessageDialog(janela,"Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }
        Cliente cliente = tableModel.getCliente(linhaSelecionada);        
        servicoCliente.deletarCliente(cliente);
        JOptionPane.showMessageDialog(janela,"Remocao realizada com sucesso!");
        
        this.atualizaTabela();
    }
    
    public void salvarCliente(String nome, String RG, String tele) {
        FormularioCliente painelForm = this.janela.getPainelFormulario();
        TabelaCliente painelTabela = this.janela.getPainelTabela();
        ClienteTableModel tableModel = (ClienteTableModel) painelTabela.getTabela().getModel();
        if(telaAtual==FORMCADASTRO){
            Cliente cliente = new Cliente(nome, RG, tele);
            servicoCliente.addCliente(cliente);
            JOptionPane.showMessageDialog(janela,"Cadastro realizado com sucesso!");
            painelForm.limparCampos();
        }
        else{
            linhaSelecionada = painelTabela.getTabela().getSelectedRow();
            int idCliente = tableModel.getCliente(linhaSelecionada).getId();
            Cliente cliente = new Cliente(idCliente, nome, RG, tele);
            servicoCliente.atualizaCliente(cliente);
            JOptionPane.showMessageDialog(janela,"Edicao realizada com sucesso!");          
        }        
    }
    
    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaCliente.PAINELTABELA);
    }
    
    public void atualizaTabela() {
        TabelaCliente painelTabela = this.janela.getPainelTabela();
        ClienteTableModel modelo = (ClienteTableModel) painelTabela.getTabela().getModel();
        
        modelo.setClientes(servicoCliente.listarCliente());
        
        painelTabela.getTabela().updateUI();
    }
}
