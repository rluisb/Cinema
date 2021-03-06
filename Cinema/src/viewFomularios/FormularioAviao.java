/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFomularios;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Aviao;
import servico.AviaoServico;
import controller.AviaoController;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class FormularioAviao extends javax.swing.JPanel {
    
    AviaoServico servicoA;
    AviaoController controller;

    /**
     * Creates new form PainelFormularioAviao
     */
    public FormularioAviao() {
        servicoA = new AviaoServico();
        controller = new AviaoController();
        initComponents();
    }
    
    public FormularioAviao(AviaoController control){
        servicoA = new AviaoServico();
        controller = control;
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
        jtNome = new javax.swing.JTextField();
        jlabelCod = new javax.swing.JLabel();
        jLabelMensagem = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        jtCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(getPreferredSize());

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

        jtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeActionPerformed(evt);
            }
        });
        jtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNomeKeyPressed(evt);
            }
        });

        jlabelCod.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        jlabelCod.setText("Código:");

        jLabelMensagem.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelMensagem.setText("Escreva o NOME do Avião");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCodActionPerformed(evt);
            }
        });
        jtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        jLabel4.setText("Nome: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelCod, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        if(jbCadastrar.getText().equalsIgnoreCase("Editar")){
            editarAviao();
            controller.voltarPrincipal();
        }else{
            cadastrarAviao();
            controller.voltarPrincipal();
        }
    }//GEN-LAST:event_jbCadastrarActionPerformed
    
    public void cadastrarAviao() {
        try {
            String nomeAviao = jtNome.getText();
            if (servicoA.aviaoExiste(nomeAviao)) {
                JOptionPane.showMessageDialog(this, "Avião já existente no cadastro", "Erro: Avião Existente", JOptionPane.ERROR_MESSAGE);
            } else if (nomeAviao.matches("\\s*")) {
                JOptionPane.showMessageDialog(this, "Erro: NOME VAZIO!!!", "Erro: NOME em branco", JOptionPane.ERROR_MESSAGE);
            } else {
                servicoA.addAviao(new Aviao(nomeAviao));
                JOptionPane.showMessageDialog(this, "Avião " + nomeAviao + " cadastrado com sucesso!");                
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao Cadastrar o avião", "Erro: Inesperado", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void editarAviao() {
        //servicoA.mostrarAvioes();
        try {
            int idUpdate = (Integer.parseInt(jtCod.getText()));
            if (servicoA.aviaoExiste(idUpdate)) {
                String nome = jtNome.getText();
                if (servicoA.aviaoExiste(nome)) {
                    JOptionPane.showMessageDialog(this, "Avião já existente no cadastro", "Erro: Avião Existente", JOptionPane.ERROR_MESSAGE);
                } 
                else if (nome.matches("\\s*")) {
                    JOptionPane.showMessageDialog(this,"Erro: NOME VAZIO!!!", "Erro: NOME em branco", JOptionPane.ERROR_MESSAGE);
                } else {
                    servicoA.atualizaAviao(new Aviao(idUpdate, nome));
                    JOptionPane.showMessageDialog(this,"Avião " + nome + " atualizado com sucesso!");
                }
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao Editar o avião", "Erro: Inesperado", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void carregaDados(int cod, String nome){
        this.jtCod.setText(Integer.toString(cod));
        this.jtNome.setText(nome);
    }

    public void limparCampoNome() {
        jtNome.setText("");
    }
    
    public javax.swing.JButton getJbCadastrar() {
        return jbCadastrar;
    }
    
    public void habilitaEdicaoFormAviao(boolean valor) {
        this.jtCod.setEditable(false);
        this.jtNome.setEditable(valor);        
    }

    public JLabel getJlabelCod() {
        return jlabelCod;
    }

    public void setJlabelCod(JLabel jlabelCod) {
        this.jlabelCod = jlabelCod;
    }

    public JTextField getJtCod() {
        return jtCod;
    }

    public void setJtCod(JTextField jtCod) {
        this.jtCod = jtCod;
    }
    
    public javax.swing.JLabel getjLabelMensagem() {
        return jLabelMensagem;
    }

    public void setjLabelMensagem(javax.swing.JLabel jLabelMensagem) {
        this.jLabelMensagem = jLabelMensagem;
    }
    
    private void jbCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbCadastrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(jbCadastrar.getText().equalsIgnoreCase("Editar")){
            editarAviao();
            controller.voltarPrincipal();
            }else{
            cadastrarAviao();
            controller.voltarPrincipal();
            }            
        }
    }//GEN-LAST:event_jbCadastrarKeyPressed

    private void jtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(jbCadastrar.getText().equalsIgnoreCase("Editar")){
            editarAviao();
            controller.voltarPrincipal();
            }else{
            cadastrarAviao();
            controller.voltarPrincipal();
            }            
        }
    }//GEN-LAST:event_jtNomeKeyPressed

    private void jtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeActionPerformed
        // Ao clicar no campo nome não dispara evento 
    }//GEN-LAST:event_jtNomeActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        controller.voltarPrincipal();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void jtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCodActionPerformed
        // // Ao clicar no campo código não dispara evento
    }//GEN-LAST:event_jtCodActionPerformed

    private void jtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodKeyPressed
        // // Ao pressionar ENTER no campo código não dispara evento
    }//GEN-LAST:event_jtCodKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMensagem;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JLabel jlabelCod;
    private javax.swing.JTextField jtCod;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables

}
