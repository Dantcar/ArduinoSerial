/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacaoarduino;

/**
 *
 * @author decio_000
 */
public class JFInterface extends javax.swing.JFrame {
    
    Arduino conn = new Arduino();

    /**
     * Creates new form JFInterface
     */
    public JFInterface() {
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

        jPanel1 = new javax.swing.JPanel();
        jBLenOn = new javax.swing.JButton();
        jBLenOff = new javax.swing.JButton();
        jBClose = new javax.swing.JButton();
        jBTxt = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jBPiscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comando Arduíno Serial"));

        jBLenOn.setText("Ligar");
        jBLenOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBLenOnMouseClicked(evt);
            }
        });
        jBLenOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLenOnActionPerformed(evt);
            }
        });

        jBLenOff.setText("Desligar");
        jBLenOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBLenOffMouseClicked(evt);
            }
        });

        jBClose.setText("Sair");
        jBClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCloseMouseClicked(evt);
            }
        });
        jBClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCloseActionPerformed(evt);
            }
        });

        jBTxt.setText("Texto");
        jBTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTxtActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jBPiscar.setText("Piscar");
        jBPiscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPiscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBPiscar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBLenOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jBLenOff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLenOn)
                    .addComponent(jBLenOff)
                    .addComponent(jBTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBPiscar)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBClose)
                    .addComponent(jBLimpar))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLenOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLenOnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBLenOnActionPerformed

    private void jBLenOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLenOnMouseClicked
        // TODO add your handling code here:
        
        conn.comunicacaoArduino(jBLenOn);//Botao ligar pressionado
    }//GEN-LAST:event_jBLenOnMouseClicked

    private void jBLenOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLenOffMouseClicked
        // TODO add your handling code here:
        
        conn.comunicacaoArduino(jBLenOff);
    }//GEN-LAST:event_jBLenOffMouseClicked

    private void jBCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCloseMouseClicked
        // TODO add your handling code here:
        conn.comunicacaoArduino(jBClose);
        System.exit(0); //fecha a aplicacao
    }//GEN-LAST:event_jBCloseMouseClicked

    private void jBCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCloseActionPerformed
        // TODO add your handling code here:
        conn.comunicacaoArduino(jBClose);
        System.exit(0); //fecha a aplicacao
        
    }//GEN-LAST:event_jBCloseActionPerformed

    private void jBTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTxtActionPerformed
        // TODO add your handling code here:
        conn.comunicacaoArduino(jBTxt);//Botao ligar pressionado
    }//GEN-LAST:event_jBTxtActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        // TODO add your handling code here:
        conn.comunicacaoArduino(jBLimpar);//Botao limpar pressionado
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jBPiscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPiscarActionPerformed
        // TODO add your handling code here:
       conn.comunicacaoArduino(jBPiscar);//Botao limpar pressionado 
    }//GEN-LAST:event_jBPiscarActionPerformed

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
            java.util.logging.Logger.getLogger(JFInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClose;
    private javax.swing.JButton jBLenOff;
    private javax.swing.JButton jBLenOn;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBPiscar;
    private javax.swing.JButton jBTxt;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
