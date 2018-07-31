/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static system.core.SellingArea.con;
import system.helper.Helper;
import system.model.SellingAreaBean;
import system.model.WareHouseBean;

/**
 *
 * @author JANSEN ANG 
 */
public class Ware extends javax.swing.JPanel implements DocumentListener {

     public static int productId = 20170001;
    public Dimension desktopSize;
    public static boolean active = true;
    public static final int MAX_ID = 20179999;
    public Ware() {
        initComponents();
        findUsers();
        totaltf.setText("TOTAL: " + wtable.getModel().getRowCount());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        tabpane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pidtf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pdesc = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        cat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        storqty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cost = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        order = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        supp = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        newtf = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        export = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        wtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchtf = new javax.swing.JTextField();
        searchtf.getDocument().addDocumentListener(this);
        totaltf = new javax.swing.JLabel();

        panel.setBackground(new java.awt.Color(255, 255, 255));

        tabpane.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Information"));

        jLabel2.setText("Product Id:");

        pidtf.setEditable(false);
        pidtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidtfActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name:");

        jLabel4.setText("Product Description:");

        pdesc.setColumns(20);
        pdesc.setLineWrap(true);
        pdesc.setRows(5);
        jScrollPane2.setViewportView(pdesc);

        jLabel5.setText("Category:");

        jLabel6.setText("Storage Quantity:");

        jLabel7.setText("Unit Cost:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(206, 206, 206))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pname, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(pidtf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cat)
                                    .addComponent(storqty)
                                    .addComponent(cost, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pidtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(storqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabpane.addTab("Basic Info", jPanel1);

        jLabel8.setText("Barcode:");

        jLabel9.setText("On Order:");

        jLabel10.setText("Supplier:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supp, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(supp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        tabpane.addTab("Storage Info", jPanel4);

        jLabel11.setText("Selling Price:");

        jLabel12.setText("Selling Quantity:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(price)
                    .addComponent(qty, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        tabpane.addTab("Selling Info", jPanel5);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        newtf.setText("NEW");
        newtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newtfActionPerformed(evt);
            }
        });

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        export.setText("EXPORT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newtf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newtf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabpane)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(tabpane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search "));

        wtable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(wtable);
        wtable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(active){
                    pidtf.setText(wtable.getValueAt(wtable.getSelectedRow(), 0).toString());
                    barcode.setText(wtable.getValueAt(wtable.getSelectedRow(), 1).toString());
                    pname.setText(wtable.getValueAt(wtable.getSelectedRow(), 2).toString());
                    pdesc.setText(wtable.getValueAt(wtable.getSelectedRow(),3).toString());
                    cat.setText(wtable.getValueAt(wtable.getSelectedRow(), 4).toString());
                    storqty.setText(wtable.getValueAt(wtable.getSelectedRow(), 5).toString());
                    cost.setText(wtable.getValueAt(wtable.getSelectedRow(), 6).toString());
                    order.setText(wtable.getValueAt(wtable.getSelectedRow(), 7).toString());
                    supp.setText(wtable.getValueAt(wtable.getSelectedRow(), 8).toString());

                }
            }
        });

        wtable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    System.out.println("Double click");
                    Waretable.changeLayer(true);
                }
            }
        });

        wtable.setAutoCreateRowSorter(true);

        jLabel1.setText("Search:");

        totaltf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totaltf.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totaltf, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(totaltf, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(pidtf.getText() == null ||
            pname.getText().length() <= 0 || barcode.getText().length() <= 0  || cat.getText().length() <= 0  ||
            storqty.getText().length() <= 0  || cost.getText().length() <= 0  || order.getText().length() <= 0  ||
            supp.getText().length() <= 0 ){
            JOptionPane.showMessageDialog(this, "Nothing to Delete. Please select first." , "Delete Error", 
                    JOptionPane.ERROR_MESSAGE);
        }else{
            int reply = JOptionPane.showConfirmDialog(this, "The selected item will be deleted.", "Are you sure?" ,
                JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                if(Helper.delete(con, "Delete from Warehouse where ProductId like '"+pidtf.getText()+"' ")){
                    System.out.println(pidtf.getText() + " successfully deleted from the database.");
                    if(Helper.insertToWareQueue(con, Integer.parseInt(pidtf.getText())));
                    refresh();
                }
            }

        }
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if(pname.getText().length() <= 0 || barcode.getText().length() <= 0  || cat.getText().length() <= 0  ||
            storqty.getText().length() <= 0  || cost.getText().length() <= 0  || order.getText().length() < 0  ||
            supp.getText().length() <= 0  || price.getText().length() <= 0  || qty.getText().length() < 0){
            JOptionPane.showMessageDialog(this, "Please fill in the required fields" , "Saving Error", JOptionPane.ERROR_MESSAGE);
        }else{
            ResultSet rs = Helper.getData(con, "Select * from WareHouse where ProductId like '"+pidtf.getText()+"' ");
            try {
                if(rs.next()){ //update
                    if(Helper.delete(con, "Delete from Warehouse where ProductId = " + pidtf.getText())){
                        System.out.println("Delete Success");
                        WareHouseBean wb = new WareHouseBean();
                        wb.setProductId(Integer.parseInt(pidtf.getText()));
                        wb.setProductName(pname.getText());
                        wb.setProductDesc(pdesc.getText());
                        wb.setCat(cat.getText());
                        wb.setBarcode(barcode.getText());
                        wb.setInStock(Integer.parseInt(storqty.getText()));
                        wb.setSupp(supp.getText());
                        wb.setCost(Float.parseFloat(cost.getText()));
                        wb.setSellPrice(Float.parseFloat(price.getText()));
                        wb.setQty(Integer.parseInt(qty.getText()));
                        if(Helper.insertToWarehouse(con, wb)) System.out.println("Insert Update Success");
                        refresh();
                    }else System.out.println("Delete Failed");
                }else{ //add new
                    WareHouseBean wb = new WareHouseBean(Integer.parseInt(pidtf.getText()),  barcode.getText(),
                        pname.getText(), pdesc.getText(), cat.getText(),
                        Integer.parseInt(storqty.getText()), Float.parseFloat(cost.getText()),
                        Integer.parseInt(order.getText()), supp.getText());
                    if(Helper.insertToWarehouse(con, wb)) System.out.println("Insert New Success");
                    refresh();
                }
            } catch (SQLException ex) {
                Logger.getLogger(WareHouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        }

        public void refresh(){
            clear();
            removeAll();
            revalidate();
            repaint();
            initComponents();
            findUsers();
        }

        public void clear(){
            pidtf.setText("");
            pname.setText("");
            pdesc.setText("");
            cat.setText("");
            storqty.setText("");
            cost.setText("");
            order.setText("");
            supp.setText("");
            price.setText("");
            qty.setText("");
            barcode.setText("");
        }
        
        public ArrayList<WareHouseBean> ListUsers(String value)
        {
            String query =
            "Select * from Warehouse where ProductId like '%"+value+"%' or "
            + " Barcode like '%"+value+"%' or ProductName like '%"+value+"%' or"
            + " ProductDesc like '%"+value+"%' or Category like '%"+value+"%' or InStock like '"+value+"%' or "
            + " Cost like '"+value+"%'  "
            + " or OnOrder like '%"+value+"%' or Supplier like '%"+value+"%' or LastDateAdded like '%"+value+"%'  ";
            ResultSet rs = Helper.getData(con, query);
            ArrayList<WareHouseBean> usersList = new ArrayList<WareHouseBean>();
            try{
                WareHouseBean wb;

                while(rs.next())
                {
                    wb = new WareHouseBean(
                        rs.getInt("ProductId"),  rs.getString("Barcode"), rs.getString("ProductName"),
                        rs.getString("ProductDesc"), rs.getString("Category"), rs.getInt("InStock"),
                        rs.getFloat("Cost"), rs.getInt("OnOrder"), rs.getString("Supplier"));
                    usersList.add(wb);
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
                ArrayList<WareHouseBean> users = ListUsers(searchtf.getText());
                DefaultTableModel model = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int rowIndex, int mColIndex) {
                        return false;
                    }
                };
                model.setColumnIdentifiers(new Object[]{"Product ID", "Barcode", "Product Name","Product Description","Category",
                    "In Stock", "Cost" , "On Order", "Supplier", "Date Added"});
            Object[] row = new Object[11];

            for(int i = 0; i < users.size(); i++)
            {
                row[0] = users.get(i).getProductId();
                row[1] = users.get(i).getBarcode();
                row[2] = users.get(i).getProductName();
                row[3] = users.get(i).getProductDesc();
                row[4] = users.get(i).getCat();
                row[5] = users.get(i).getInStock();
                row[6] = users.get(i).getCost();
                row[7] = users.get(i).getOnOrder();
                row[8] = users.get(i).getSupp();
                row[9] = users.get(i).getDate();
                model.addRow(row);
            }
            wtable.setModel(model);

        }
    }//GEN-LAST:event_saveActionPerformed

    private void newtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtfActionPerformed
        clear();
        int pid = checkExistingProductId();
        
        if(pid != MAX_ID) pidtf.setText(pid+"");
        else pid = 201710000;
        

    }//GEN-LAST:event_newtfActionPerformed
    public static int checkQueue(){
        int pid = -1;
        try {
             
             ResultSet queue = Helper.getData(con, "Select * from WareQueue order by ProductId ");
             if(!queue.next()) pid = -1;
             else{
                 pid = queue.getInt("ProductId");
                 Helper.delete(con, "Delete from WareQueue");
             }
         }
         catch (SQLException ex) {
             Logger.getLogger(Ware.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return pid;
    }
    public static int checkExistingProductId(){
        ResultSet rs;
        int pid = checkQueue();
        if(pid != -1)
            return pid;
        else{
            rs = Helper.getData(con, "Select * from Warehouse order by ProductId desc");
            try {
                if(rs.next()){
                    pid = rs.getInt("ProductId");
                    pid++;
                    
                }else{
                    pid = 201700001;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Ware.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return pid;
       
    }
    
    private void pidtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidtfActionPerformed
    public static void wareLight(int index){
        try{
            ResultSet rs = Helper.getData(con, "Select * from Warehouse");
            if(index != -1 && rs.next()){
                 wtable.setRowSelectionInterval(index, Waretable.index);
                 pidtf.setText(wtable.getValueAt(index, 0).toString());
                 barcode.setText(wtable.getValueAt(index, 1).toString());
                 pname.setText(wtable.getValueAt(index, 2).toString());
                 pdesc.setText(wtable.getValueAt(index, 3).toString());
                 cat.setText(wtable.getValueAt(index, 4).toString());
                 storqty.setText(wtable.getValueAt(index, 5).toString());
                 cost.setText(wtable.getValueAt(index, 6).toString());
                 order.setText(wtable.getValueAt(index, 7).toString());
                 supp.setText(wtable.getValueAt(index, 8).toString());
                 
            }
        }catch(SQLException sqle){
            Logger.getLogger(SuppControl.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField barcode;
    private static javax.swing.JTextField cat;
    private static javax.swing.JTextField cost;
    private javax.swing.JButton delete;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newtf;
    private static javax.swing.JTextField order;
    private javax.swing.JPanel panel;
    private static javax.swing.JTextArea pdesc;
    public static javax.swing.JTextField pidtf;
    private static javax.swing.JTextField pname;
    private javax.swing.JTextField price;
    private javax.swing.JTextField qty;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchtf;
    private static javax.swing.JTextField storqty;
    private static javax.swing.JTextField supp;
    private javax.swing.JTabbedPane tabpane;
    private javax.swing.JLabel totaltf;
    private static javax.swing.JTable wtable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
         active = false;
        wtable.setRowSelectionAllowed(false);
        findUsers();
         wtable.setRowSelectionAllowed(true);
         active = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
          active = false;
        wtable.setRowSelectionAllowed(false);
        findUsers();
         wtable.setRowSelectionAllowed(true);
         active = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
