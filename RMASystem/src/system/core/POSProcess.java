/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author JANSEN
 */
public class POSProcess extends javax.swing.JFrame implements DocumentListener{

    public float total = 0;
    public boolean success = false;
    public POSProcess() {
        initComponents();
        
    }
    
    
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForProcess = new javax.swing.JPanel();
        amountLabel = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();
        changeTf = new javax.swing.JTextField();
        amountTf = new javax.swing.JTextField();
        processBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        amountLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        amountLabel.setText("Amount:");

        changeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changeLabel.setText("Change:");

        changeTf.setEditable(false);

        processBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        processBtn.setText("Process");
        processBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelForProcessLayout = new javax.swing.GroupLayout(panelForProcess);
        panelForProcess.setLayout(panelForProcessLayout);
        panelForProcessLayout.setHorizontalGroup(
            panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForProcessLayout.createSequentialGroup()
                .addGroup(panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelForProcessLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelForProcessLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        panelForProcessLayout.setVerticalGroup(
            panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelForProcessLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelForProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        amountTf.getDocument().addDocumentListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelForProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelForProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processBtnActionPerformed
      
       dispose();
    }//GEN-LAST:event_processBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public void setTotal(Float total){
        this.total = total;
    }
    
    public float getTotal(){
        return total;
    }
    
   
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTf;
    private javax.swing.JLabel changeLabel;
    private javax.swing.JTextField changeTf;
    private javax.swing.JPanel panelForProcess;
    public static javax.swing.JButton processBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(amountTf.getText() != null){
           float amt = Float.parseFloat(amountTf.getText());
           float chang = 0;
           chang = amt - getTotal();
           System.out.println(getTotal());
           changeTf.setText(chang+"");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(amountTf.getText() != null){
           float amt = Float.parseFloat(amountTf.getText());
           float chang = 0;
           chang = amt - getTotal();
           System.out.println(getTotal());
           changeTf.setText(chang+"");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
   

