/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static system.core.Login.db;
import static system.core.SuppControl.MAX_ID;
import static system.core.SuppControl.checkExistingProductId;
import static system.core.SuppControl.sid;
import system.helper.Helper;
import system.model.SupplierBean;
import system.utility.ConnectionUtil;


public class Suppliers extends javax.swing.JPanel implements DocumentListener {
   
    static SuppControl control;  
    public static boolean active = true;
    
    public static Connection con = ConnectionUtil.getDBConnection(db);
    public static int index;
    public Suppliers() {
        initComponents();
        control = new SuppControl();
        control.setBounds(0,0, getWidth(), getHeight());
        findUsers();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        supplayer = new javax.swing.JLayeredPane();
        SuppTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchtf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        stable.setBorder(new javax.swing.border.MatteBorder(null));
        stable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(stable);
        stable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                /*    if(active){
                    pid.setText(stable.getValueAt(stable.getSelectedRow(), 0).toString());
                    barcode.setText(stable.getValueAt(stable.getSelectedRow(), 1).toString());
                    pname.setText(stable.getValueAt(stable.getSelectedRow(), 2).toString());
                    pdesc.setText(stable.getValueAt(stable.getSelectedRow(),3).toString());
                    cat.setText(stable.getValueAt(stable.getSelectedRow(), 4).toString());
                    storqty.setText(stable.getValueAt(stable.getSelectedRow(), 5).toString());
                    cost.setText(stable.getValueAt(stable.getSelectedRow(), 6).toString());
                    order.setText(stable.getValueAt(stable.getSelectedRow(), 7).toString());
                    supp.setText(stable.getValueAt(stable.getSelectedRow(), 8).toString());

                }*/
            }
        });
        stable.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    index = stable.getSelectedRow();
                    SuppControl.highlight(index);
                    supplayer.remove(SuppTable);
                    supplayer.setLayout(new BorderLayout());

                    supplayer.add(control);
                    supplayer.moveToFront(control);
                    supplayer.repaint();
                    supplayer.revalidate();
                }
            }

        });

        jLabel1.setText("Search:");

        jLabel2.setText("TOTAL: ");

        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SuppTableLayout = new javax.swing.GroupLayout(SuppTable);
        SuppTable.setLayout(SuppTableLayout);
        SuppTableLayout.setHorizontalGroup(
            SuppTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SuppTableLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        SuppTableLayout.setVerticalGroup(
            SuppTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuppTableLayout.createSequentialGroup()
                .addGroup(SuppTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuppTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        searchtf.getDocument().addDocumentListener(this);

        javax.swing.GroupLayout supplayerLayout = new javax.swing.GroupLayout(supplayer);
        supplayer.setLayout(supplayerLayout);
        supplayerLayout.setHorizontalGroup(
            supplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplayerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(SuppTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        supplayerLayout.setVerticalGroup(
            supplayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SuppTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        supplayer.setLayer(SuppTable, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(supplayer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(supplayer, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        supplayer.remove(SuppTable);
        supplayer.setLayout(new BorderLayout());
        supplayer.add(control);
        supplayer.moveToFront(control); 
        supplayer.repaint();
        supplayer.revalidate();
       
         String pid = checkExistingProductId();
        
        if(!pid.equals(MAX_ID)) pid = "S" + 201710000;
        else sid.setText(pid+"");
    }//GEN-LAST:event_jButton1ActionPerformed
     
    public ArrayList<SupplierBean> ListUsers(String value)
    {   
        String query = 
                    "Select * from Supplier where SuppId like '"+value+"%' or "
                 + " Name like '%"+value+"%' or ContactPerson like '%"+value+"%' or"
                 + " Phone like '%"+value+"%' or Email like '%"+value+"%' or Website like '"+value+"%' or "
                 + " Address1 like '"+value+"%' or Address2 like '"+value+"%' or City like '"+value+"%'  "
                 + " or StateProvince like '%"+value+"%' or Zip like '%"+value+"%' or Country like '%"+value+"%' "
                + "  or Discount like '"+value+"%'";
        
         ResultSet rs = Helper.getData(con, query);
        ArrayList<SupplierBean> usersList = new ArrayList<SupplierBean>();
        try{
            SupplierBean sb;
            
            while(rs.next())
            {
                sb = new SupplierBean(
                               rs.getString("SuppId"), rs.getString("Name"), rs.getString("ContactPerson"),
                                rs.getString("Phone"), rs.getString("Email"), rs.getString("Website"),
                               rs.getString("Address1"), rs.getString("Address2"), rs.getString("City"),
                               rs.getString("StateProvince"), rs.getString("Zip"), rs.getString("Country"), 
                               rs.getFloat("Discount"));
                usersList.add(sb);
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
        ArrayList<SupplierBean> users = ListUsers(searchtf.getText());
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        
        model.setColumnIdentifiers(new Object[]{"Supplier ID", "Name", "Contact Person", "Phone", "Email", "Website",
                                                 "Address 1", "Address 2" , "City", "State/Province", "Zip/Postal Code", 
                                                 "Country", "Discount"});
        Object[] row = new Object[15];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getSuppId();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getContactPerson();
            row[3] = users.get(i).getPhone();
            row[4] = users.get(i).getEmail();
            row[5] = users.get(i).getWebsite();
            row[6] = users.get(i).getAdd1();  
            row[7] = users.get(i).getAdd2();
            row[8] = users.get(i).getCity();
            row[9] = users.get(i).getState();
            row[10] = users.get(i).getZip();
            row[11] = users.get(i).getCountry();
            row[12] = users.get(i).getDiscount();
            model.addRow(row);
        }
       stable.setModel(model);
       
    }
}
    
    public static void changeLayer(boolean flag){
        if(flag){
             supplayer.remove(control);
             supplayer.setLayout(new BorderLayout());

             supplayer.add(SuppTable);
             supplayer.moveToFront(SuppTable);
             supplayer.repaint();
             supplayer.revalidate();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel SuppTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtf;
    private javax.swing.JTable stable;
    private static javax.swing.JLayeredPane supplayer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
         active = false;
        stable.setRowSelectionAllowed(false);
        findUsers();
         stable.setRowSelectionAllowed(true);
         active = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
           active = false;
        stable.setRowSelectionAllowed(false);
        findUsers();
         stable.setRowSelectionAllowed(true);
         active = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
