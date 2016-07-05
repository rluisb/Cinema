package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.SessaoController;
import model.Sessao;


public class PainelFormularioSessao extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private SessaoController controller;

	public PainelFormularioSessao() {
        initComponents();
    }

    PainelFormularioSessao(SessaoController controller) {
        this.controller=controller;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        botaoSalvar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        textSala = new javax.swing.JTextField();
        textHora = new javax.swing.JTextField();
        textFilme = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelPainelFormulario = new javax.swing.JLabel();

        botaoSalvar.setText("Cadastrar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					botaoSalvarActionPerformed(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Sala:");

        jLabel2.setText("Hora:");

        jLabel3.setText("Filme:");

        labelPainelFormulario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelPainelFormulario.setText("Cadastro de Sessao");

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
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botaoSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textSala, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(textHora))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(textSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoVoltar))
                .addGap(30, 30, 30))
        );
    }

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	Date data = (Date)formatter.parse(textHora.getText());
         Sessao sessao = new Sessao(Integer.parseInt(textSala.getText()), data , Integer.parseInt(textFilme.getText()));
        controller.salvarSessao(sessao);
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

    public JTextField getTextFilme() {
        return textFilme;
    }

    public JTextField getTextHora() {
        return textHora;
    }

    public JTextField getTextSala() {
        return textSala;
    }
    
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelPainelFormulario;
    private javax.swing.JTextField textFilme;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textSala;

}
