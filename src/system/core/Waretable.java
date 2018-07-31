/*
 * RMA - JANSEN ANG LICENSE
 */
package system.core;

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
import static system.core.Ware.MAX_ID;
import static system.core.Ware.checkExistingProductId;
import static system.core.Ware.pidtf;
import system.helper.Helper;
import system.model.SupplierBean;
import system.model.WareHouseBean;
import system.utility.ConnectionUtil;

/**
 *
 * @author JANSEN ANG
 */
public class Waretable extends javax.swing.JPanel implements DocumentListener {

    public static Connection con = ConnectionUtil.getDBConnection(db);
     public static boolean active = true;
     static Ware ware;
    public static int index;

    public Waretable() {
        initComponents();
        ware = new Ware();
        ware.setBounds(0,0,getWidth(),getHeight());
        findUsers();
        total.setText("TOTAL: " + wtable.getModel().getRowCount() + "");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wareLayer = new javax.swing.JLayeredPane();
        WareTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        wtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchtf = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        wtable.setBorder(new javax.swing.border.MatteBorder(null));
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
                /*    if(active){
                    pid.setText(wtable.getValueAt(wtable.getSelectedRow(), 0).toString());
                    barcode.setText(wtable.getValueAt(wtable.getSelectedRow(), 1).toString());
                    pname.setText(wtable.getValueAt(wtable.getSelectedRow(), 2).toString());
                    pdesc.setText(wtable.getValueAt(wtable.getSelectedRow(),3).toString());
                    cat.setText(wtable.getValueAt(wtable.getSelectedRow(), 4).toString());
                    storqty.setText(wtable.getValueAt(wtable.getSelectedRow(), 5).toString());
                    cost.setText(wtable.getValueAt(wtable.getSelectedRow(), 6).toString());
                    order.setText(wtable.getValueAt(wtable.getSelectedRow(), 7).toString());
                    supp.setText(wtable.getValueAt(wtable.getSelectedRow(), 8).toString());

                }*/
            }
        });
        wtable.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    index = wtable.getSelectedRow();
                    Ware.wareLight(index);
                    wareLayer.remove(WareTable);
                    wareLayer.setLayout(new BorderLayout());

                    wareLayer.add(ware);
                    wareLayer.moveToFront(ware);
                    wareLayer.repaint();
                    wareLayer.revalidate();
                }
            }

        });

        jLabel1.setText("Search:");

        total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        total.setText("TOTAL: ");

        jButton1.setText("Add new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout WareTableLayout = new javax.swing.GroupLayout(WareTable);
        WareTable.setLayout(WareTableLayout);
        WareTableLayout.setHorizontalGroup(
            WareTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WareTableLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchtf, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(92, 92, 92)
                .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addGap(91, 91, 91))
            .addGroup(WareTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        WareTableLayout.setVerticalGroup(
            WareTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WareTableLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(WareTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchtf)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(498, 498, 498))
            .addGroup(WareTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(WareTableLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)))
        );

        searchtf.getDocument().addDocumentListener(this);

        javax.swing.GroupLayout wareLayerLayout = new javax.swing.GroupLayout(wareLayer);
        wareLayer.setLayout(wareLayerLayout);
        wareLayerLayout.setHorizontalGroup(
            wareLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WareTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wareLayerLayout.setVerticalGroup(
            wareLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WareTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wareLayer.setLayer(WareTable, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wareLayer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(wareLayer)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int pid = checkExistingProductId();
        
        if(pid != MAX_ID) pidtf.setText(pid+"");
        else pid = 201710000;
    }//GEN-LAST:event_jButton1ActionPerformed
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
    }  
    
    public static void changeLayer(boolean flag){
        if(flag){
             wareLayer.remove(ware);
             wareLayer.setLayout(new BorderLayout());

             wareLayer.add(WareTable);
             wareLayer.moveToFront(WareTable);
             wareLayer.repaint();
             wareLayer.revalidate();
        }
    }
      
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel WareTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtf;
    private javax.swing.JLabel total;
    private static javax.swing.JLayeredPane wareLayer;
    private javax.swing.JTable wtable;
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
