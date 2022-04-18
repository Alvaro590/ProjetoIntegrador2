/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas;

import Controle.DespesasControle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.entidades.Despesas;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import persistencia.DespesasPersistencia;
import static persistencia.DespesasPersistencia.listarComboBoxDespesa;
import static persistencia.DespesasPersistencia.listarComboBoxDespesa2;
import static persistencia.DespesasPersistencia.listarComboBoxDespesa3;

/**
 *
 * @author Sciencegamer
 */
public class TelaDespesa extends javax.swing.JFrame {

    DespesasControle dControle = new DespesasControle();
    DespesasPersistencia dPersistencia = new DespesasPersistencia("C:\\Users\\Sciencegamer\\ArquivosDadosPI\\Despesas.txt");

    public TelaDespesa() throws Exception {
        initComponents();
        mostrarListagem();
        listarComboBoxDespesa(comboBoxCartao);
        listarComboBoxDespesa2(comboBoxConta);
        tableDespesa.setAutoCreateRowSorter(true);
    }

    public void limparTela() {
        textId.setText("");
        textDescricao.setText("");
        textValor.setText("");
        textData.setDate(null);
        comboBoxCartao.setSelectedIndex(0);
        textParcela.setText("");
        check1.setEnabled(true);
        comboBoxConta.setSelectedIndex(0);

    }

    private void mostrarListagem() {
        try {
            ArrayList<Despesas> aux = dControle.listagem();
            DefaultTableModel model = (DefaultTableModel) tableDespesa.getModel();
            model.setNumRows(0);
            for (int pos = 0; pos < aux.size(); pos++) {
                String[] saida = new String[8];
                Despesas d1 = aux.get(pos);
                saida[0] = d1.getId() + "";
                saida[1] = d1.getDescricao();
                DecimalFormat df = new DecimalFormat("R$#,##0.00");
                saida[2] = df.format(d1.getValor());
                saida[3] = d1.getData();
                saida[4] = d1.getCartao() + "";
                saida[5] = d1.getFixa();
                saida[6] = d1.getParcelas() + "";
                saida[7] = d1.getConta();

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

        botaoVoltar = new javax.swing.JButton();
        botaoIncluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDespesa = new javax.swing.JTable();
        botaoConsultar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textValor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textParcela = new javax.swing.JTextField();
        check1 = new javax.swing.JCheckBox();
        botaoVoltar1 = new javax.swing.JButton();
        textData = new com.toedter.calendar.JDateChooser();
        comboBoxCartao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboBoxConta = new javax.swing.JComboBox<>();

        botaoVoltar.setBackground(new java.awt.Color(0, 255, 255));
        botaoVoltar.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoVoltar.setText("Voltar ao menu principal");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyCash");
        setMaximumSize(new java.awt.Dimension(855, 765));
        setMinimumSize(new java.awt.Dimension(855, 765));

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
        jLabel1.setText("Despesa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("IDENTIFICADOR:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("DESCRIÇÃO:");

        textId.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textIdFocusLost(evt);
            }
        });
        textId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textIdKeyTyped(evt);
            }
        });

        textDescricao.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        tableDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "DESCRIÇÃO", "VALOR", "DATA", "CARTÃO", "TIPO", "PARCELAS", "CONTA"
            }
        ));
        jScrollPane1.setViewportView(tableDespesa);

        botaoConsultar.setBackground(new java.awt.Color(0, 255, 255));
        botaoConsultar.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoConsultar.setText("Consulta por ID");
        botaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultarActionPerformed(evt);
            }
        });

        botaoExcluir.setBackground(new java.awt.Color(0, 255, 255));
        botaoExcluir.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoExcluir.setText("Excluir por ID");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAlterar.setBackground(new java.awt.Color(0, 255, 255));
        botaoAlterar.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoAlterar.setText("Alterar ");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("VALOR:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("DATA:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("CARTÃO:");

        textValor.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValorKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setText("PARCELAS");

        textParcela.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        textParcela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textParcelaFocusLost(evt);
            }
        });
        textParcela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textParcelaKeyTyped(evt);
            }
        });

        check1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        check1.setText(" DESPESA FIXA");

        botaoVoltar1.setBackground(new java.awt.Color(0, 255, 255));
        botaoVoltar1.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        botaoVoltar1.setText("Voltar ao menu principal");
        botaoVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltar1ActionPerformed(evt);
            }
        });

        textData.setDateFormatString("dd/MM/yy");
        textData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        comboBoxCartao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBoxCartao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("CONTA:");

        comboBoxConta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBoxConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botaoIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoConsultar)
                                    .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(comboBoxConta, 0, 140, Short.MAX_VALUE)
                                                    .addComponent(textParcela))
                                                .addGap(89, 89, 89))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(check1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(botaoExcluir)
                                        .addGap(18, 18, 18)
                                        .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)))
                        .addComponent(botaoVoltar1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(textData, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(comboBoxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(textParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            String data = dateFormat.format(textData.getDate());
            if (textId.getText().equals("") || textDescricao.getText().equals("") || textValor.getText().equals("")
                    || data.equals("")) {
                throw new Exception("Algum dos campos está vazio");
            }
            int id = Integer.parseInt(textId.getText());
            String descricao = textDescricao.getText();
            String aux1 = textValor.getText().replaceAll(",", ".");
            Double valor = Double.parseDouble(aux1);
            String cartao = comboBoxCartao.getSelectedItem()+"";
            String fixa;
            if (check1.isSelected()) {
                fixa = "Despesa fixa";
            } else {
                fixa = "Despesa variável";
            }
            int parcela = Integer.parseInt(textParcela.getText());
            String conta = comboBoxConta.getSelectedItem() + "";

            Despesas aux = new Despesas(id, descricao, valor, data, cartao, fixa, parcela, conta);
            dControle.incluir(aux);

            limparTela();
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void botaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultarActionPerformed
        try {
            String str = textId.getText();
            if (str.length() == 0) {
                throw new Exception("Identificador da tela está vazio");
            }
            int id = Integer.parseInt(str);
            Despesas aux = dControle.consultar(id);
            if (aux == null) {
                throw new Exception("Despesa não existe");
            }
            textId.setText(aux.getId() + "");
            textDescricao.setText(aux.getDescricao() + "");
            DecimalFormat df2 = new DecimalFormat("#,##0.00");
            textValor.setText(df2.format(aux.getValor()));
            Date date1 = new SimpleDateFormat("dd/MM/yy").parse(aux.getData());
            textData.setDate(date1);          
                        
            for (int i = 0; i < comboBoxCartao.getItemCount(); i++) {
                String x1 = comboBoxCartao.getItemAt(i);
                if (x1.equals(aux.getCartao())) {
                    comboBoxCartao.setSelectedItem(x1);
                }
            }  
            
            for (int i = 0; i < comboBoxConta.getItemCount(); i++) {
                String x1 = comboBoxConta.getItemAt(i);
                if (x1.equals(aux.getConta())) {
                    comboBoxConta.setSelectedItem(x1);
                }
            }  

            textParcela.setText(aux.getParcelas() + "");
            if (aux.getFixa().equals("Despesa fixa")) {
                if (check1.isSelected()) {

                } else {
                    check1.doClick();
                }

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoConsultarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        try {
            String str = textId.getText();
            if (str.length() == 0) {
                throw new Exception("Identificador da tela está vazio");
            }
            int id = Integer.parseInt(str);
            dControle.excluir(id);
            limparTela();
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
        try {
            String str1 = textId.getText();
            if (str1.length() == 0) {
                throw new Exception("Identificador da tela está vazio");
            }

            Despesas aux = new Despesas();
            aux.setId(Integer.parseInt(str1));
            aux.setDescricao(textDescricao.getText());

            String aux1 = textValor.getText().replaceAll(",", ".");
            aux.setValor(Double.parseDouble(aux1));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            aux.setData(dateFormat.format(textData.getDate()));

            aux.setCartao(comboBoxCartao.getSelectedItem() + "");
            aux.setParcelas(Integer.parseInt(textParcela.getText()));
            if (check1.isSelected()) {
                aux.setFixa("Despesa fixa");
            } else {
                aux.setFixa("Despesa variável");
            }
            aux.setConta(comboBoxConta.getSelectedItem() + "");

            dControle.alterar(aux);
            limparTela();
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed

    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltar1ActionPerformed

        TelaMenu nova2 = new TelaMenu();
        this.dispose();
        nova2.setVisible(true);
    }//GEN-LAST:event_botaoVoltar1ActionPerformed

    private void textIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textIdFocusLost
        if (Integer.parseInt(textId.getText()) < 1) {
            JOptionPane.showMessageDialog(new JFrame(), "O identificador não pode ser menor que 1", "Aviso",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_textIdFocusLost

    private void textParcelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textParcelaFocusLost
        if (Integer.parseInt(textParcela.getText()) < 1) {
            JOptionPane.showMessageDialog(new JFrame(), "O identificador não pode ser menor que 1", "Aviso",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_textParcelaFocusLost

    private void textIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textIdKeyTyped
        char test = evt.getKeyChar();
        if (!Character.isDigit(test)) {
            evt.consume();
        }
    }//GEN-LAST:event_textIdKeyTyped

    private void textValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorKeyTyped
        char test = evt.getKeyChar();
        if (test != ',') {
            if (test != '.') {
                if (!Character.isDigit(test)) {
                    evt.consume();
                }
            }
        }

    }//GEN-LAST:event_textValorKeyTyped

    private void textParcelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textParcelaKeyTyped
        char test = evt.getKeyChar();
        if (!Character.isDigit(test)) {
            evt.consume();
        }
    }//GEN-LAST:event_textParcelaKeyTyped

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
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaDespesa().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaDespesa.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton botaoVoltar1;
    private javax.swing.JCheckBox check1;
    private javax.swing.JComboBox<String> comboBoxCartao;
    private javax.swing.JComboBox<String> comboBoxConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDespesa;
    private com.toedter.calendar.JDateChooser textData;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textParcela;
    private javax.swing.JTextField textValor;
    // End of variables declaration//GEN-END:variables
}
