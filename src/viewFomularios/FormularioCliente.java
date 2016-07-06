package viewFomularios;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Cliente;
import servico.ClienteServico;
import controller.ClienteController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Dimension;

public class FormularioCliente extends javax.swing.JPanel {
    ClienteServico servicoC;
    ClienteController controller;

    /**
     * Creates new form PainelFormularioCliente
     */
    public FormularioCliente(ClienteController control) {
        servicoC = new ClienteServico();
        controller = control;
        initComponents();
    }
    
    public FormularioCliente() {
        servicoC = new ClienteServico();
        controller = new ClienteController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jbCadastrar = new javax.swing.JButton();
        jLabelMensagem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jbVoltar = new javax.swing.JButton();
        jftTelefone = new javax.swing.JFormattedTextField();
        jtID = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setMinimumSize(new Dimension(620, 400));

        jbCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });
        jbCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbCadastrarKeyPressed(evt);
            }
        });

        jLabelMensagem.setFont(new Font("Tahoma", Font.BOLD, 25)); // NOI18N
        jLabelMensagem.setText("Cadastro de Clientes");

        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel2.setText("RG:");

        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jLabel3.setText("Telefone:");

        jtNome.setPreferredSize(null);
        jtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNomeKeyPressed(evt);
            }
        });

        jbVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        try {
            jftTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefone.setPreferredSize(null);
        jftTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftTelefoneActionPerformed(evt);
            }
        });
        jftTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftTelefoneKeyPressed(evt);
            }
        });
        jLabelID = new javax.swing.JLabel();
        
                jLabelID.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
                jLabelID.setText("ID:");
        jLabel1 = new javax.swing.JLabel();
        
                jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15)); // NOI18N
                jLabel1.setText("Nome:");
        
        textField = new JTextField();
        textField.setPreferredSize((Dimension) null);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(93)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(9)
        							.addComponent(jLabel1)
        							.addGap(55)
        							.addComponent(jtNome, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel3)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addGap(19)
        									.addComponent(jLabel2)))
        							.addGap(46)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(textField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jftTelefone, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(20)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabelMensagem, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addComponent(jLabelID)
        									.addGap(67)
        									.addComponent(jtID, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(118)
        					.addComponent(jbCadastrar)
        					.addGap(56)
        					.addComponent(jbVoltar)))
        			.addContainerGap(93, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabelMensagem, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        			.addGap(44)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabelID)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(jtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(6)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(jtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(6)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(jftTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jbCadastrar)
        				.addComponent(jbVoltar))
        			.addGap(65))
        );
        setLayout(groupLayout);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        if(jbCadastrar.getText().equalsIgnoreCase("Editar")){
            editarCliente();
            controller.voltarPrincipal();
        }
        else{
            cadastrarCliente();
            controller.voltarPrincipal();
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed
    
    public void cadastrarCliente() {
        String rg = jtID.getText();
        if (servicoC.clienteExiste(rg)) {
            JOptionPane.showMessageDialog(this, " RG já existente no banco", "Erro: Cliente Existente", JOptionPane.ERROR_MESSAGE);
        } else if (rg.replace(" ", "").isEmpty() /*testando se é vazio*/) {
            JOptionPane.showMessageDialog(this, " Erro: RG VAZIO", "Erro: RG em branco", JOptionPane.ERROR_MESSAGE);
        } else if (rg.matches("\\d{10,10}")) {
            String nome = jtNome.getText();
            if (nome.matches("\\s*")) {//testar com \s para ver se é vazio
                JOptionPane.showMessageDialog(this, " Erro: NOME VAZIO", "Erro: NOME em branco", JOptionPane.ERROR_MESSAGE);
            } else if (nome.matches("[A-Za-z]+(\\s[A-Za-z]+)*")) {
                String telefone = jftTelefone.getText();
                if (!telefone.matches("\\d{4,4}-\\d{4,4}")) {
                    JOptionPane.showMessageDialog(this, " Erro: Telefone digitado diferente do formato indicado!!!", "Erro: Formato Inválido", JOptionPane.ERROR_MESSAGE);
                } else {
                    servicoC.addCliente(new Cliente(nome, rg, telefone));
                    JOptionPane.showMessageDialog(this, " Cliente " + nome + " \ncadastrado com sucesso!\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, " Erro: O nome não pode conter números, caracteres especiais, ou começa em espaço ou ter mais de um espaço", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, " Erro:O RG não pode conter letras, espaços e no máximo 10 dígitos", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void editarCliente() {
        //servicoC.mostrarClientes();
        int idClienteUpdate = (Integer.parseInt(jtID.getText()));
        if (servicoC.clienteExiste(idClienteUpdate)) {
            String rg = jtID.getText();
            if (rg.replace(" ", "").isEmpty() /*testando se é vazio*/) {
                JOptionPane.showMessageDialog(this, " Erro: RG VAZIO", "Erro: RG em branco", JOptionPane.ERROR_MESSAGE);
            } else if (rg.matches("\\d{10,10}")) {
                String nome = jtNome.getText();
                if (nome.matches("\\s*")) {//testar com \s para ver se é vazio
                    JOptionPane.showMessageDialog(this, " Erro: NOME VAZIO", "Erro: NOME em branco", JOptionPane.ERROR_MESSAGE);
                } else if (nome.matches("[A-Za-z]+(\\s[A-Za-z]+)*")) {
                    String telefone = jftTelefone.getText();
                    if (!telefone.matches("\\d{4,4}-\\d{4,4}")) {
                        JOptionPane.showMessageDialog(this, " Erro: Telefone digitado diferente do formato indicado!!!", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        servicoC.atualizaCliente(new Cliente(idClienteUpdate, nome, rg, telefone));
                        JOptionPane.showMessageDialog(this, " Cliente " + nome + " atualizado com sucesso!\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, " Erro: O nome não pode conter números, caracteres especiais, ou começa em espaço ou ter mais de um espaço", "Formato Inválido", JOptionPane.ERROR_MESSAGE );
                }
            } else {
                JOptionPane.showMessageDialog(this, "\nErro:O RG não pode conter letras, espaços e no máximo 10 dígitos", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void carregaDados(int id, String nome, String RG, String tel){   
        this.jtID.setText(Integer.toString(id));
        this.jtNome.setText(nome);
        this.jtID.setText(RG);
        this.jftTelefone.setText(tel);
    }
    
    public void limparCampos() {
        jtID.setText("");
        jtNome.setText("");
        jftTelefone.setText("");
    }
    
    public javax.swing.JButton getJbCadastrar() {
        return jbCadastrar;
    }
    
    public void habilitaEdicaoFormCliente(boolean valor) {
        this.jtID.setEditable(false);
        this.jtID.setEditable(valor);
        this.jtNome.setEditable(valor);
        this.jftTelefone.setEditable(valor);
    }
    
    public JLabel getjLabelID() {
        return jLabelID;
    }

    public void setjLabelID(JLabel jLabelID) {
        this.jLabelID = jLabelID;
    }

    public JTextField getJtID() {
        return jtID;
    }

    public void setJtID(JTextField jtID) {
        this.jtID = jtID;
    }

    public JLabel getjLabelMensagem() {
        return jLabelMensagem;
    }

    public JLabel getjLabelObservacao() {
        return getjLabelObservacao();
    }
    
    
    
    private void jbCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCadastrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarCliente();            
        }
    }//GEN-LAST:event_jbCadastrarKeyPressed

    private void jtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarCliente();            
        }
    }//GEN-LAST:event_jtNomeKeyPressed

    private void jftTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftTelefoneActionPerformed

    private void jftTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftTelefoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarCliente();            
        }
    }//GEN-LAST:event_jftTelefoneKeyPressed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        controller.voltarPrincipal();
    }//GEN-LAST:event_jbVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMensagem;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtNome;
    private JTextField textField;
}