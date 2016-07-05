package controller;

import javax.swing.JOptionPane;

import dao.ClienteDaoBd;
import model.Cliente;
import view.ClienteTableModel;
import view.JanelaCrudCliente;
import view.PainelFormularioCliente;
import view.PainelTabelaCliente;

public class ClienteController {

    private final static int TABELA = 0;
    private final static int FORMCADASTRO = 1;
    private final static int FORMEDICAO = 2;
    private final static int FORMVISUALIZACAO = 3;

    private int telaAtual = 0;

    private JanelaCrudCliente janela;
    
    ClienteDaoBd clientebd = new ClienteDaoBd();
    PainelFormularioCliente form = new PainelFormularioCliente();

    public ClienteController() {
        telaAtual = TABELA;
    }

    public void setJanela(JanelaCrudCliente janela) {
        this.janela = janela;
    }

    public void inserirCliente() {
        PainelFormularioCliente form = this.janela.getPainelFormulario();

        form.getLabelPainelFormulario().setText("Cadastrar Cliente");
        form.getBotaoSalvar().setVisible(true);
        form.getBotaoSalvar().setText("Cadastrar");
        this.habilitaEdicaoFormCliente(true);

        telaAtual = FORMCADASTRO;
        this.janela.mostrarPainel(JanelaCrudCliente.PAINELFORM);
    }

    public void editarCliente() {
        PainelTabelaCliente painelTabela = this.janela.getPainelTabela();
        PainelFormularioCliente painelForm = this.janela.getPainelFormulario();
        
        if(painelTabela.getTabelaCliente().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        painelForm.getLabelPainelFormulario().setText("Editar Cliente");
        painelForm.getBotaoSalvar().setVisible(true);
        painelForm.getBotaoSalvar().setText("Editar");
        this.habilitaEdicaoFormCliente(true);

        telaAtual = FORMEDICAO;
        this.janela.mostrarPainel(JanelaCrudCliente.PAINELFORM);
    }

    public void visualizarCliente() {
        PainelTabelaCliente painelTabela = this.janela.getPainelTabela();
        PainelFormularioCliente form = this.janela.getPainelFormulario();

        if(painelTabela.getTabelaCliente().getSelectedRow() < 0)
        {
            this.printMessageError("Nao ha nenhum elemento selecionado na tabela");                    
            return;
        }

        form.getLabelPainelFormulario().setText("Visualizar Cliente");
        form.getBotaoSalvar().setVisible(false);
        form.getBotaoSalvar().setText("");
        this.habilitaEdicaoFormCliente(false);

        telaAtual = FORMVISUALIZACAO;
        this.janela.mostrarPainel(JanelaCrudCliente.PAINELFORM);
    }

    public void removerCliente() {
        PainelTabelaCliente painelTabela = this.janela.getPainelTabela();
        ClienteTableModel tableModel = (ClienteTableModel) painelTabela.getTabelaCliente().getModel();;
        clientebd.deletar(tableModel.getCliente(painelTabela.getTabelaCliente().getSelectedRow()));
        this.atualizaTabela();
    }

    
    public void salvarCliente(Cliente cliente) {
        clientebd.inserir(cliente);
        this.voltarPrincipal();
    }

    public void voltarPrincipal() {
        telaAtual = TABELA;
        this.atualizaTabela();
        this.janela.mostrarPainel(JanelaCrudCliente.PAINELTABELA);
    }
    
    
    public void atualizaTabela() {
        PainelTabelaCliente painelTabela = this.janela.getPainelTabela();
        ClienteTableModel tableModel = (ClienteTableModel) painelTabela.getTabelaCliente().getModel();
        tableModel.setClientes(clientebd.listar());
        
        painelTabela.getTabelaCliente().updateUI();
    }


    private void habilitaEdicaoFormCliente(boolean valor) {
        PainelFormularioCliente form = this.janela.getPainelFormulario();
        
        form.getTextRg().setEditable(valor);
        form.getTextNome().setEditable(valor);
        form.getTextEndereco().setEditable(valor);
        form.getTextTelefone().setEditable(valor);
    }

    private void printMessageError(String msg) {
            JOptionPane.showMessageDialog(janela, 
                    msg,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);        
    }

  
}
