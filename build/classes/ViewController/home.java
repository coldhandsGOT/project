/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.DBConnection;
import java.awt.Image;
import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idris
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form Main_window
     */
    public home() 
    {
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

        jPanel5 = new javax.swing.JPanel();
        Med = new javax.swing.JButton();
        Infirmiers = new javax.swing.JButton();
        Btn_Malades = new javax.swing.JButton();
        Batiments = new javax.swing.JButton();
        Services = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        Med.setBackground(java.awt.SystemColor.controlHighlight);
        Med.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Med.setForeground(new java.awt.Color(45, 118, 232));
        Med.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doc.png"))); // NOI18N
        Med.setText("Médecins");
        Med.setBorderPainted(false);
        Med.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedActionPerformed(evt);
            }
        });

        Infirmiers.setBackground(java.awt.SystemColor.controlHighlight);
        Infirmiers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Infirmiers.setForeground(new java.awt.Color(45, 118, 232));
        Infirmiers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nurse-64.png"))); // NOI18N
        Infirmiers.setText("Infirmiers");
        Infirmiers.setBorderPainted(false);
        Infirmiers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfirmiersActionPerformed(evt);
            }
        });

        Btn_Malades.setBackground(java.awt.SystemColor.controlHighlight);
        Btn_Malades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_Malades.setForeground(new java.awt.Color(45, 118, 232));
        Btn_Malades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/16-512.png"))); // NOI18N
        Btn_Malades.setText("Patients");
        Btn_Malades.setBorderPainted(false);
        Btn_Malades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MaladesActionPerformed(evt);
            }
        });

        Batiments.setBackground(java.awt.SystemColor.controlHighlight);
        Batiments.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Batiments.setForeground(new java.awt.Color(45, 118, 232));
        Batiments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/build7-64.png"))); // NOI18N
        Batiments.setText("Batiments");
        Batiments.setBorderPainted(false);
        Batiments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatimentsActionPerformed(evt);
            }
        });

        Services.setBackground(java.awt.SystemColor.controlHighlight);
        Services.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Services.setForeground(new java.awt.Color(45, 118, 232));
        Services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/medical_service-64.png"))); // NOI18N
        Services.setText("Services");
        Services.setBorderPainted(false);
        Services.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Services, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Batiments, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Infirmiers, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Med, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_Malades, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Med)
                .addGap(40, 40, 40)
                .addComponent(Infirmiers)
                .addGap(40, 40, 40)
                .addComponent(Btn_Malades)
                .addGap(40, 40, 40)
                .addComponent(Batiments)
                .addGap(35, 35, 35)
                .addComponent(Services)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(45, 118, 232));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login.png"))); // NOI18N
        jLabel15.setText("Hospital management");

        jTextField1.setBackground(new java.awt.Color(45, 118, 232));
        jTextField1.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText(" Taper votre recherche");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_20px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InfirmiersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfirmiersActionPerformed
         this.hide();
        Infirmier_GUI m=new Infirmier_GUI();
        m.setVisible(true);    }//GEN-LAST:event_InfirmiersActionPerformed

    private void Btn_MaladesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MaladesActionPerformed
        this.hide();
        Malade_GUI m=new Malade_GUI();
        m.setVisible(true);
    }//GEN-LAST:event_Btn_MaladesActionPerformed

    private void BatimentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatimentsActionPerformed
         this.hide();
       Batiment_GUI bat=new Batiment_GUI();
        bat.setVisible(true);
    }//GEN-LAST:event_BatimentsActionPerformed

    private void ServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServicesActionPerformed
        this.hide();
        Service_GUI ser=new Service_GUI();
        ser.setVisible(true);
    }//GEN-LAST:event_ServicesActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void MedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedActionPerformed
        this.hide();
        Docteur_GUI meds=new Docteur_GUI();
        meds.setVisible(true);
    }//GEN-LAST:event_MedActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Batiments;
    public javax.swing.JButton Btn_Malades;
    public javax.swing.JButton Infirmiers;
    public javax.swing.JButton Med;
    public javax.swing.JButton Services;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
