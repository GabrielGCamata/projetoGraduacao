/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc2;

import EncontrarCor.ClassificarCor;
import EncontrarFaixa.IdentificarCoresTcc;
import EncontrarResistor.Resistencia;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class AppResistor extends javax.swing.JFrame {

    /**
     * Creates new form AppResistor
     */
    public AppResistor() {
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

        txtCaminhoSaida = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRecorte = new javax.swing.JRadioButton();
        btnFaixa = new javax.swing.JRadioButton();
        btnCalculo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCaminhoEntrada = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Escolher a Pasta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Escolha uma opção");

        btnRecorte.setText("Recorte do Corpo do resistor");
        btnRecorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorteActionPerformed(evt);
            }
        });

        btnFaixa.setText("Recorte das faixas do resistor");

        btnCalculo.setText("Cálculo da resistencia (ohms)");
        btnCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculoActionPerformed(evt);
            }
        });

        jLabel1.setText("Ferramenta Computacional de Cálculo de Resistencia");

        jButton3.setText("Processar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Escolha pasta para processamento");

        txtCaminhoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaminhoEntradaActionPerformed(evt);
            }
        });

        jButton1.setText("Escolher a Pasta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Escolha pasta para saída");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCaminhoSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                            .addComponent(txtCaminhoEntrada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRecorte)
                                    .addComponent(btnCalculo)
                                    .addComponent(btnFaixa))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnRecorte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fc1 = new JFileChooser();
        fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        String caminho;
        int res = fc1.showOpenDialog(null);
        //        File caminho = null;
        //
        if(res == JFileChooser.APPROVE_OPTION){
            caminho = fc1.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "Caminho selecionada: " + caminho);
            txtCaminhoSaida.setText(caminho);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRecorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecorteActionPerformed

    private void btnCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalculoActionPerformed

    private void txtCaminhoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaminhoEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaminhoEntradaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc1 = new JFileChooser();
        fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        String caminho;
        int res = fc1.showOpenDialog(null);
        //        File caminho = null;
        //
        if(res == JFileChooser.APPROVE_OPTION){
            caminho = fc1.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "Caminho selecionada: " + caminho);
            txtCaminhoEntrada.setText(caminho);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
               
        if(btnCalculo.isSelected())
        {
            System.out.println("Calculo Selecionada");
            File pasta = new File(txtCaminhoEntrada.getText());
            File[] arquivos = pasta.listFiles();
            int i = 0;
            int[] arr = new int [4];
            long tempoInicial = System.currentTimeMillis();
            for (File path : arquivos) {
                try {
                    arr[i] = ClassificarCor.ClassificarCor(path.getPath(), path.getName(), txtCaminhoSaida.getText());
                    i++;
                } catch (IOException ex) {
                    Logger.getLogger(AppResistor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            System.out.println((arr[0]*10 + arr[1]) * Math.pow(10, arr[2]));
            
            FileWriter arq;
            try {
                arq = new FileWriter(txtCaminhoSaida.getText()+"\\.txt");
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.printf(String.valueOf((arr[0]*10 + arr[1]) * Math.pow(10, arr[2])) + "ohms");
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(AppResistor.class.getName()).log(Level.SEVERE, null, ex);
            }
            long tempoFinal = System.currentTimeMillis();
            System.out.println("Tempo em millis: " + (tempoFinal - tempoInicial) );
            
            JOptionPane.showMessageDialog(null, "O resultado foi salvo na pasta do projeto");
        }
        if(btnFaixa.isSelected())
        {
            File pasta = new File(txtCaminhoEntrada.getText());
            File[] arquivos = pasta.listFiles();
            long tempoInicial = System.currentTimeMillis();
            for (File path : arquivos) {
                IdentificarCoresTcc.main(path.getPath(), path.getName(), txtCaminhoSaida.getText());
            }
            JOptionPane.showMessageDialog(null, "O resultado foi salvo na pasta do projeto");
            long tempoFinal = System.currentTimeMillis();
            System.out.println("Tempo em millis: " + (tempoFinal - tempoInicial) );
        }
        
        if(btnRecorte.isSelected())
        {
            File pasta = new File(txtCaminhoEntrada.getText());
            File[] arquivos = pasta.listFiles();
            long tempoInicial = System.currentTimeMillis();
            for (File path : arquivos) {
                Resistencia.Resistencia(path.getPath(), path.getName(), txtCaminhoSaida.getText());
            }
            JOptionPane.showMessageDialog(null, "O resultado foi salvo na pasta do projeto");
            long tempoFinal = System.currentTimeMillis();
            System.out.println("Tempo em millis: " + (tempoFinal - tempoInicial) );
        }
        //for (File path : arquivos) {
          //  System.out.print(path.getAbsolutePath());
        //}
        JOptionPane.showMessageDialog(null, "O resultado foi salvo na pasta do projeto");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AppResistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppResistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppResistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppResistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppResistor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnCalculo;
    private javax.swing.JRadioButton btnFaixa;
    private javax.swing.JRadioButton btnRecorte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCaminhoEntrada;
    private javax.swing.JTextField txtCaminhoSaida;
    // End of variables declaration//GEN-END:variables
}