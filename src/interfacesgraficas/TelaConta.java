/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas;

import Controle.ContaControle;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.entidades.Conta;

import persistencia.ContaPersistencia;
import static persistencia.ContaPersistencia.listarComboBoxConta;

/**
 *
 * @author Sciencegamer
 */
public class TelaConta extends javax.swing.JFrame {

    ContaControle cControle = new ContaControle();
    ContaPersistencia cPersistencia = new ContaPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Contas.txt");

    /**
     * Creates new form TelaConta
     */
    public TelaConta() throws Exception {
        initComponents();
        mostrarListagem();
        listarComboBoxConta(comboBanco);
        tableConta.setAutoCreateRowSorter(true);        
    }

    public void limparTela() {
        textCId.setText("");
        textSaldo.setText("");
        textLimite.setText("");
        textTaxa.setText("00,00%");
        comboBanco.setSelectedIndex(0);
    }

    private void mostrarListagem() {
        try {
            ArrayList<Conta> aux = cControle.listagem();
            DefaultTableModel model = (DefaultTableModel) tableConta.getModel();
            model.setNumRows(0);
            for (int pos = 0; pos < aux.size(); pos++) {
                String[] saida = new String[5];
                DecimalFormat df = new DecimalFormat("R$#,##0.00");
                DecimalFormat df1 = new DecimalFormat("#,###0.00");
                
                Conta c1 = aux.get(pos);
                saida[0] = c1.getId() + "";
                saida[1] = df.format(c1.getSaldo());
                saida[2] = c1.getBanco() + "";
                saida[3] = df.format(c1.getLimite());
                saida[4] = df1.format(c1.getTaxa()) + "%";

                //incluir nova linha na tabela
                model.addRow(saida);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoIncluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textCId = new javax.swing.JTextField();
        textSaldo = new javax.swing.JTextField();
        botaoConsultar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        comboBanco = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        textLimite = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textTaxa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableConta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyCash");

        botaoIncluir.setBackground(new java.awt.Color(0, 255, 255));
        botaoIncluir.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoIncluir.setText("Incluir");
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONTAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(374, 374, 374))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(39, 39, 39))
        );

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("IDENTIFICADOR DA CONTA:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("SALDO:");

        textCId.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textCId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCIdKeyTyped(evt);
            }
        });

        textSaldo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSaldoKeyTyped(evt);
            }
        });

        botaoConsultar.setBackground(new java.awt.Color(0, 255, 255));
        botaoConsultar.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoConsultar.setText("Consultar");
        botaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarActionPerformed(evt);
            }
        });

        botaoExcluir.setBackground(new java.awt.Color(0, 255, 255));
        botaoExcluir.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoExcluir.setText("Excluir ");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAlterar.setBackground(new java.awt.Color(0, 255, 255));
        botaoAlterar.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("IDENTIFICADOR DO BANCO*:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("*Identificador 0 significa que a conta não possui vínculo com instituição bancária");

        botaoVoltar.setBackground(new java.awt.Color(0, 255, 255));
        botaoVoltar.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoVoltar.setText("Voltar ao menu principal");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        comboBanco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("LIMITE:");

        textLimite.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textLimiteKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("TAXA:");

        textTaxa.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textTaxa.setText("00,00%");
        textTaxa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTaxaKeyTyped(evt);
            }
        });

        tableConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "SALDO", "IDENTIFICADOR DO BANCO", "LIMITE", "TAXA"
            }
        ));
        jScrollPane1.setViewportView(tableConta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(textCId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(textSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(comboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoIncluir)
                                .addGap(42, 42, 42)
                                .addComponent(botaoConsultar)
                                .addGap(42, 42, 42)
                                .addComponent(botaoExcluir)
                                .addGap(39, 39, 39)
                                .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(botaoVoltar)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textCId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(textLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        // TODO add your handling code here:
        try {

            if (textCId.getText().equals("") || textSaldo.getText().equals("") || textLimite.getText().equals("") || textTaxa.getText().equals("")) {
                throw new Exception("Algum dos campos está vazio");
            }
            
            int id = Integer.parseInt(textCId.getText());         
                        
            String aux1 = textSaldo.getText().replaceAll(",", ".");
            Double saldo = Double.parseDouble(aux1);  
            
            String banco = comboBanco.getSelectedItem()+"";
            
            aux1 = textLimite.getText().replaceAll(",", ".");
            double limite = Double.parseDouble(aux1);
            
            aux1 = textTaxa.getText().replaceAll("%", "");
            aux1 = aux1.replaceAll(",", ".");
            double taxa = Double.parseDouble(aux1);         
            
            Conta aux = new Conta(id, saldo, banco, limite, taxa);
            cControle.incluir(aux);

            limparTela();
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed

        try {
            String str = textCId.getText();
            if (str.length() == 0) {
                throw new Exception("Identificador da conta está vazio");
            }
            int id = Integer.parseInt(str);
            Conta aux = cControle.consultar(id);
            if (aux == null) {
                throw new Exception("Cartão não existe");
            }
            DecimalFormat df2 = new DecimalFormat("#,##0.00");
            textCId.setText(aux.getId() + "");
            textSaldo.setText(df2.format(aux.getSaldo()));
            for (int i = 0; i < comboBanco.getItemCount(); i++) {
                String x1 = comboBanco.getItemAt(i);
                if (x1.equals(aux.getBanco())) {
                    comboBanco.setSelectedItem(x1);
                }
            } 
            textLimite.setText(df2.format(aux.getLimite()));
            textTaxa.setText(df2.format(aux.getTaxa()) + "%");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        try {
            String str = textCId.getText();
            if (str.length() == 0) {
                throw new Exception("Identificador da conta está vazio");
            }
            int id = Integer.parseInt(str);
            cControle.apagar(id);
            limparTela();
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        try {
            String str1 = textCId.getText();

            if (textCId.getText().equals("") || textSaldo.getText().equals("") || textLimite.getText().equals("") || textTaxa.getText().equals("")) {
                throw new Exception("Algum campo está vazio");
            }
            Conta aux = new Conta();
            aux.setId(Integer.parseInt(str1));
            
            String aux1 = textSaldo.getText().replaceAll(",", ".");
            aux.setSaldo(Double.parseDouble(aux1));
            
            aux.setBanco(comboBanco.getSelectedItem() + "");
            
            aux1 = textLimite.getText().replaceAll(",", ".");
            aux.setLimite(Double.parseDouble(aux1));
            
            aux1 = textTaxa.getText().replaceAll("%", "");
            aux1 = aux1.replaceAll(",", ".");
            aux.setTaxa(Double.parseDouble(aux1));

            cControle.alterar(Integer.parseInt(str1), aux);
            limparTela();
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed

        TelaMenu nova2 = new TelaMenu();
        this.dispose();
        nova2.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void textCIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCIdKeyTyped
        char test = evt.getKeyChar();
        if (!Character.isDigit(test)) {
            evt.consume();
        }
    }//GEN-LAST:event_textCIdKeyTyped

    private void textSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSaldoKeyTyped
        char test = evt.getKeyChar();
        if (test != ',') {
            if (test != '.') {
                if (test != '-') {
                    if (!Character.isDigit(test)) {
                        evt.consume();
                    }
                }

            }
        }
    }//GEN-LAST:event_textSaldoKeyTyped

    private void textLimiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textLimiteKeyTyped
        char test = evt.getKeyChar();
        if (test != ',') {
            if (test != '.') {
                if (!Character.isDigit(test)) {
                    evt.consume();
                }

            }
        }
    }//GEN-LAST:event_textLimiteKeyTyped

    private void textTaxaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTaxaKeyTyped
        char test = evt.getKeyChar();
        if (test != ',') {
            if (test != '.') {
                if (test != '%') {
                    if (!Character.isDigit(test)) {
                        evt.consume();
                    }
                }

            }
        }
    }//GEN-LAST:event_textTaxaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaConta().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoConsultar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> comboBanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableConta;
    private javax.swing.JTextField textCId;
    private javax.swing.JTextField textLimite;
    private javax.swing.JTextField textSaldo;
    private javax.swing.JTextField textTaxa;
    // End of variables declaration//GEN-END:variables
}
