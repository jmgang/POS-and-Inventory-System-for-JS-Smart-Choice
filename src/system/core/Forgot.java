/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static system.core.Login.db;
import system.helper.Helper;
import system.utility.ConnectionUtil;

/**
 *
 * @author JANSEN
 */
public class Forgot extends javax.swing.JFrame {

    
    public Forgot() {
        initComponents();
        setLocationRelativeTo(null);
        visible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        userCon = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        currentLabel = new javax.swing.JLabel();
        newplabel = new javax.swing.JLabel();
        currenttf = new javax.swing.JPasswordField();
        newptf = new javax.swing.JPasswordField();
        retypetf = new javax.swing.JPasswordField();
        curLabel = new javax.swing.JLabel();
        retypelabel = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Forgot Password");

        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idLabel.setText("ID:");
        userPanel.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 32, 81, 23));
        userPanel.add(userCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 61, 155, -1));

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        userPanel.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 120, -1, -1));

        currentLabel.setText("Current Password:");
        userPanel.add(currentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        newplabel.setText("New Password:");
        userPanel.add(newplabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));
        userPanel.add(currenttf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 244, -1));
        userPanel.add(newptf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 244, -1));
        userPanel.add(retypetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 244, -1));

        curLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        curLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        curLabel.setText("Change Password");
        userPanel.add(curLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        retypelabel.setText("Re-Type Password:");
        userPanel.add(retypelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        userPanel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        back.setText("Back");
        userPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        close.setText("Close");
        userPanel.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void visible(boolean bool){
         idLabel.setVisible(!bool);
         userCon.setVisible(!bool);
         confirm.setVisible(!bool);
        
        curLabel.setVisible(bool);
        currentLabel.setVisible(bool);
        currenttf.setVisible(bool);
        newplabel.setVisible(bool);
        newptf.setVisible(bool);
        retypelabel.setVisible(bool);
        retypetf.setVisible(bool);
        
        save.setVisible(bool);
        back.setVisible(bool);
        close.setVisible(bool);
        
    }
    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
       
       Connection con = ConnectionUtil.getDBConnection(db);
       ResultSet acc = Helper.getData(con, "Accounts");
       
       try{
           while(acc.next()){
               System.out.println(acc.getString("EmpId"));
               if(acc.getString("EmpId").equals(userCon.getText().trim())){
                                        
                    visible(true);
                    userPanel.updateUI();
                    
                   break;
               }
           }
           if(acc.isAfterLast())
           JOptionPane.showMessageDialog(this, "User Id Not Found", "User Id Not Found", JOptionPane.ERROR_MESSAGE);
       }catch(SQLException sqle){
           sqle.printStackTrace();
       }
    }//GEN-LAST:event_confirmActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
      
    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton close;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel curLabel;
    private javax.swing.JLabel currentLabel;
    private javax.swing.JPasswordField currenttf;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel newplabel;
    private javax.swing.JPasswordField newptf;
    private javax.swing.JLabel retypelabel;
    private javax.swing.JPasswordField retypetf;
    private javax.swing.JButton save;
    private javax.swing.JTextField userCon;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
