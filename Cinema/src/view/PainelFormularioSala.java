package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.SalaController;
import model.Sala;


public class PainelFormularioSala extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private SalaController controller;

	public PainelFormularioSala() {
        initComponents();
    }

    PainelFormularioSala(SalaController controller) {
        this.controller=controller;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        botaoSalvar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        textPoltronas = new javax.swing.JTextField();
        textNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelPainelFormulario = new javax.swing.JLabel();

        botaoSalvar.setText("Cadastrar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero:");

        jLabel4.setText("Poltronas:");

        labelPainelFormulario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPainelFormulario.setText("Cadastro de Salas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textNumero)
                                .addComponent(textPoltronas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botaoSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelPainelFormulario)
                        .addGap(34, 34, 34)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelPainelFormulario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPoltronas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoVoltar))
                .addGap(30, 30, 30))
        );
    }

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {
         Sala sala = new Sala(Integer.parseInt(textNumero.getText()),Integer.parseInt(textPoltronas.getText()));
        controller.salvarSala(sala);
    }

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        controller.voltarPrincipal();
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public JButton getBotaoVoltar() {
        return botaoVoltar;
    }

    public JLabel getLabelPainelFormulario() {
        return labelPainelFormulario;
    }

    public JTextField getTextPoltronas() {
        return textPoltronas;
    }

    public JTextField getTextNumero() {
        return textNumero;
    }
    
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelPainelFormulario;
    private javax.swing.JTextField textPoltronas;
    private javax.swing.JTextField textNumero;

}
