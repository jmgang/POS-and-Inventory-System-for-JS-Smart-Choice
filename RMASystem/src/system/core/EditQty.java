/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static system.core.Login.db;
import static system.core.POS.tot;
import static system.core.POS.total;
import system.helper.Helper;
import system.model.Quantity;
import system.utility.ConnectionUtil;

/**
 *
 * @author JANSEN
 */
public class EditQty extends javax.swing.JFrame {
    public static DefaultTableModel model;
    public static int row;
    public static String barcode;
    public static int offset;
    public static Connection con = ConnectionUtil.getDBConnection(db);
    public ResultSet rs;
 
    
    public EditQty() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        quant = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT QUANTITY");

        quant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantActionPerformed(evt);
            }
        });
        quant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantKeyPressed(evt);
            }
        });

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantActionPerformed
       
    }//GEN-LAST:event_quantActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        float st = 0;
        String query = "Select * from POS";
       
        if(quant.getText() != null){
          if(!quant.getText().equals("0")){
              try {
                  int qty = Integer.parseInt(quant.getText());
                  updateThis(qty);
                  if(model != null){
                      
                      model.setValueAt(qty, row, 6);
                  }
                   ResultSet pos = Helper.getData(con, query);
                  while(pos.next()){
                      System.out.println("EDIT QTY:  Name: " + pos.getString("ProductName") +  " Quantity: " +
                              pos.getInt("Qty")  + " Price: "
                              + pos.getFloat("SellPrice") + " --- Old Total: " +  tot + " New Total: "
                              + pos.getInt("Qty") * pos.getFloat("SellPrice"));
                      tot = pos.getInt("Qty") * pos.getFloat("SellPrice") ;
                      st = st + tot;
                      
                      System.out.println("st: " + st + " total " + tot);
                      
                      total.setText("TOTAL: P " + st);
                      tot = st;
                  }
                  //tot = 0;
                  dispose();
              } catch (SQLException ex) {
                  Logger.getLogger(EditQty.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else{
              JOptionPane.showMessageDialog(this, "Quantity should be greater than zero.", "Quantity Invalid", 
                      JOptionPane.ERROR_MESSAGE);
          }
      }
      
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
     
    }//GEN-LAST:event_jButton1KeyPressed

    private void quantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          float st = 0;
          String query = "Select * from POS";
          if(quant.getText() != null){
          if(!quant.getText().equals("0")){
              try {
                  int qty = Integer.parseInt(quant.getText());
                  updateThis(qty);
                  if(model != null){
                      
                      model.setValueAt(qty, row, 6);
                  }
                   ResultSet pos = Helper.getData(con, query);
                  while(pos.next()){
                      System.out.println("EDIT QTY:  Name: " + pos.getString("ProductName") +  " Quantity: " +
                              pos.getInt("Qty")  + " Price: "
                              + pos.getFloat("SellPrice") + " --- Old Total: " +  tot + " New Total: "
                              + pos.getInt("Qty") * pos.getFloat("SellPrice"));
                      tot = pos.getInt("Qty") * pos.getFloat("SellPrice") ;
                      st = st + tot;
                      
                      System.out.println("st: " + st + " total " + tot);
                      total.setText("TOTAL: P " + st);
                      
                  }
                  //tot = 0;
                  dispose();
              } catch (SQLException ex) {
                  Logger.getLogger(EditQty.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else{
              JOptionPane.showMessageDialog(this, "Quantity should be greater than zero.", "Quantity Invalid", 
                      JOptionPane.ERROR_MESSAGE);
          }
      }
      }
    }//GEN-LAST:event_quantKeyPressed

    public void displayQuant(Quantity q, DefaultTableModel mod, int r, String bar, int off){
        quant.setText(q.getQuantity() + "");
        model = mod;
        row = r;
        barcode = bar;
        offset = off;
    }
    
    public void updateThis(int qty){
        try {
            rs = Helper.getData(con, "Select * from SellingArea");
            while(rs.next()){
                if(rs.getString("Barcode").equals(barcode)){
                    int change = qty;
                    if(change > 0){
                        if(Helper.updatePosDup(con, change, barcode)) System.out.println("Update in edit success");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditQty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(EditQty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField quant;
    // End of variables declaration//GEN-END:variables
}
