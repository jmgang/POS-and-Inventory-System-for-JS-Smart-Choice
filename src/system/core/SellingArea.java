/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import java.awt.Color;
import java.awt.Container;
import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static system.core.Login.db;

import system.helper.Helper;
import system.model.SellingAreaBean;
import system.utility.ConnectionUtil;
import suggest.AutoSuggestor;
import suggest.frame;

/**
 *
 * @author JANSEN
 */
public class SellingArea extends javax.swing.JInternalFrame implements DocumentListener {

     public static Connection con = ConnectionUtil.getDBConnection(db);
     public static boolean active = true;
     AutoSuggestor autoSuggestor;
    public SellingArea() {       
        initComponents();
         findUsers();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sellingAreaPanel = new javax.swing.JPanel();
        searchtf = new javax.swing.JTextField();
        searchtf.getDocument().addDocumentListener(this);
        jScrollPane1 = new javax.swing.JScrollPane();
        satable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idtf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nametf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        desctf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        pricetf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        qtytf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        barcodetf = new javax.swing.JTextField();

        setClosable(true);

        sellingAreaPanel.setBackground(new java.awt.Color(255, 255, 255));

        satable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        satable.setDragEnabled(true);
        jScrollPane1.setViewportView(satable);
        satable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(active){
                    idtf.setText(satable.getValueAt(satable.getSelectedRow(), 0).toString());
                    nametf.setText(satable.getValueAt(satable.getSelectedRow(), 1).toString());
                    barcodetf.setText(satable.getValueAt(satable.getSelectedRow(),2).toString());
                    desctf.setText(satable.getValueAt(satable.getSelectedRow(), 3).toString());
                    pricetf.setText(satable.getValueAt(satable.getSelectedRow(), 5).toString());
                    qtytf.setText(satable.getValueAt(satable.getSelectedRow(), 6).toString());
                }
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search:");

        jLabel2.setText("Product Id:");

        idtf.setEditable(false);
        idtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtfActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name:");

        nametf.setEditable(false);

        jLabel4.setText("Product Description:");

        desctf.setEditable(false);

        jLabel5.setText("Category:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Selling Price:");

        pricetf.setEditable(false);
        pricetf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetfActionPerformed(evt);
            }
        });

        jLabel7.setText("Stock Quantity:");

        jButton1.setText("Update Qty");

        jLabel8.setText("Barcode:");

        barcodetf.setEditable(false);

        javax.swing.GroupLayout sellingAreaPanelLayout = new javax.swing.GroupLayout(sellingAreaPanel);
        sellingAreaPanel.setLayout(sellingAreaPanelLayout);
        sellingAreaPanelLayout.setHorizontalGroup(
            sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingAreaPanelLayout.createSequentialGroup()
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingAreaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12))
                                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(qtytf))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingAreaPanelLayout.createSequentialGroup()
                                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pricetf)
                                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(23, 23, 23)))))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingAreaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(154, 154, 154))
                    .addComponent(desctf, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sellingAreaPanelLayout.createSequentialGroup()
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barcodetf)
                            .addComponent(idtf)))
                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nametf)))
                .addGap(20, 20, 20)
                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchtf, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                        .addGap(56, 56, 56)))
                .addContainerGap())
        );
        sellingAreaPanelLayout.setVerticalGroup(
            sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(searchtf, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idtf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcodetf)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nametf))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desctf)
                        .addGap(18, 18, 18)
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1))
                        .addGap(18, 18, 18)
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pricetf))
                        .addGap(20, 20, 20)
                        .addGroup(sellingAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtytf))
                        .addGap(33, 33, 33)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(sellingAreaPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sellingAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sellingAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtfActionPerformed

    private void pricetfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetfActionPerformed
        
    }//GEN-LAST:event_pricetfActionPerformed
        
     public ArrayList<SellingAreaBean> ListUsers(String value)
    {   
         String query = 
                    "Select * from SellingArea where ProductId like '%"+value+"%' or "
                 + " Barcode like '%"+value+"%' or ProductName like '%"+value+"%' or"
                 + " ProductDesc like '%"+value+"%' or Category like '%"+value+"%' or SellPrice like '%"+value+"%' or "
                 + " StockQty like '%"+value+"%' ";
         ResultSet rs = Helper.getData(con, query);
        ArrayList<SellingAreaBean> usersList = new ArrayList<SellingAreaBean>();
        try{
            SellingAreaBean sab;
            
            while(rs.next())
            {
                sab = new SellingAreaBean(
                               rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("Barcode"),
                                rs.getString("ProductDesc"),
                               rs.getString("Category"), rs.getFloat("SellPrice"), rs.getInt("StockQty"));
                usersList.add(sab);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return usersList;
    }
    
    // function to display data in jtable
    public void findUsers()
    {   
        if(searchtf.getText()!= null){
        ArrayList<SellingAreaBean> users = ListUsers(searchtf.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Product ID", "Barcode", "Product Name","Product Description","Category",
                                                "Selling Price", "Stock Quantity"});
        Object[] row = new Object[8];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getProductId();
            row[1] = users.get(i).getBarcode();
            row[2] = users.get(i).getProductName();
            row[3] = users.get(i).getProductDesc();
            row[4] = users.get(i).getCategory();
            row[5] = users.get(i).getSellPrice();
            row[6] = users.get(i).getQty();
            model.addRow(row);
        }
       satable.setModel(model);
       
    }
    }
    
    public void refresh(){
        getContentPane().removeAll();
        initComponents();
        ;
        findUsers();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcodetf;
    private javax.swing.JTextField desctf;
    private javax.swing.JTextField idtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametf;
    private javax.swing.JTextField pricetf;
    private javax.swing.JTextField qtytf;
    private javax.swing.JTable satable;
    private javax.swing.JTextField searchtf;
    private javax.swing.JPanel sellingAreaPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
       active = false;
        satable.setRowSelectionAllowed(false);
        findUsers();
         satable.setRowSelectionAllowed(true);
         active = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        active = false;
        satable.setRowSelectionAllowed(false);
        findUsers();
         satable.setRowSelectionAllowed(true);
         active = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
