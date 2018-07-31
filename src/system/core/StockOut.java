/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import static system.core.Login.db;
import static system.core.StockOut.fromSplit;
import system.helper.Helper;
import system.model.StockOutBean;
import system.model.WareHouseBean;
import system.utility.ConnectionUtil;

/**
 *
 * @author JANSEN
 */
public class StockOut extends javax.swing.JPanel implements DocumentListener {

     public static Connection con = ConnectionUtil.getDBConnection(db);
     public static DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
     
     public static String[] fromSplit, toSplit;
    public StockOut() {
        initComponents();
        String query = 
                    "Select * from StockOut where ProductId like '%"+searchtf.getText()+"%' or "
                 + " Barcode like '%"+searchtf.getText()+"%' or ProductName like '%"+searchtf.getText()+"%' or"
                 + " ProductDesc like '%"+searchtf.getText()+"%' or Category like '%"+searchtf.getText()+"%' "
                 + "or Quantity like '"+searchtf.getText()+"%' or "
                 + " SellPrice like '"+searchtf.getText()+"%'  "
                 + " or Total like '%"+searchtf.getText()+"%' or InvoiceNo like '%"+searchtf.getText()+"%' "
                + " order by InvoiceNo ";
        findUsers(query);
        total.setText("TOTAL: " + model.getRowCount());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fromDate = new com.toedter.calendar.JDateChooser();
        fromText = new javax.swing.JLabel();
        toText = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        searchtf = new javax.swing.JTextField();

        fromDate.setDateFormatString("yyyy-MM-dd");

        fromText.setText("From:");

        toText.setText("To:");

        toDate.setDateFormatString("yyyy-MM-dd");
        toDate.setMinSelectableDate(new java.util.Date(978282066000L));

        total.setText("TOTAL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(fromText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fromText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        fromDate.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("date".equals(e.getPropertyName())) {
                        changeTable();

                    }
                }
            });
            this.add(fromDate);
            toDate.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            changeTable();

                        }
                    }
                });
                this.add(toDate);

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

                jLabel3.setText("Search");

                searchtf.getDocument().addDocumentListener(this);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchtf, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(searchtf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                );
            }// </editor-fold>//GEN-END:initComponents
      public ArrayList<StockOutBean> ListUsers(String query)
    {   
         ResultSet rs = Helper.getData(con, query);
        ArrayList<StockOutBean> usersList = new ArrayList<StockOutBean>();
        try{
            StockOutBean sob;
            
            while(rs.next())
            {
               sob = new StockOutBean(
                               rs.getInt("ProductId"), rs.getString("Barcode"), rs.getString("InvoiceNo"), 
                               rs.getString("ProductName"), rs.getString("ProductDesc"), rs.getString("Category"), 
                               rs.getInt("Quantity"), rs.getFloat("SellPrice"), rs.getFloat("Total"), 
                               rs.getTimestamp("Date"));
                usersList.add(sob);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return usersList;
    }
    
    // function to display data in jtable
    public void findUsers(String query)
    {   
        if(searchtf.getText()!= null){
        ArrayList<StockOutBean> users = ListUsers(query);
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
      
        model.setColumnIdentifiers(new Object[]{"Invoice No.", "ProductId", "Barcode", "Product Name", 
                                                "Product Description", "Category", "Quantity", "SellPrice", 
                                                "Total", "Date"});
        
        Object[] row = new Object[11];
        
        for(int i = 0; i < users.size(); i++)
        {   
            row[0] = users.get(i).getInvoice();
            row[1] = users.get(i).getProductId();
            row[2] = users.get(i).getBarcode();
            row[3] = users.get(i).getPname();
            row[4] = users.get(i).getPdesc();
            row[5] = users.get(i).getCat();
            row[6] = users.get(i).getQty();
            row[7] = users.get(i).getSellPrice();  
            row[8] = users.get(i).getTotal();
            row[9] = users.get(i).getDate();
          
            model.addRow(row);
        }
       stable.setModel(model);
       
    }
        total.setText("TOTAL: " + model.getRowCount());
    }
    
    public void setReceiptTable(){
        String query = "Select * from StockOut order by InvoiceNo";
        findUsers(query);
    }
    
    public void setDateTable(){
        String query = "Select * from StockOut";
        refresh();
        findUsers(query);
       
    }
    
     public void refresh(){
        removeAll();
        revalidate();
        repaint();
        initComponents();
     }
     
     public void changeTable(){
          Date fdate = fromDate.getDate();
          Date tdate = toDate.getDate();
             if(fdate != null && tdate != null){
                    String tdatestr = DateFormat.getInstance().format(tdate);
                     fromSplit =  DateFormat.getInstance()
                                               .format(fdate).split("\\s+");
                     toSplit =  DateFormat.getInstance()
                                               .format(tdate).split("\\s+");
                    
                    System.out.println(fromSplit[0] + " " + toSplit[0]);
                     String query = 
                    "Select * from StockOut where cast(dbo.StockOut.Date as date ) between '"+fromSplit[0]+"' and "
                             + " '"+toSplit[0]+"' and " +
        " (ProductId like '%"+searchtf.getText()+"%' or  Barcode like '%"+searchtf.getText()+"%' or"
                  + " ProductName like '%"+searchtf.getText()+"%' or ProductDesc like '%"+searchtf.getText()+"%' or "
                  + "Category " 
                  + " like '%"+searchtf.getText()+"%' or Quantity like '%"+searchtf.getText()+"' or  "
                  + "SellPrice like '%"+searchtf.getText()+"'or Total like '%"+searchtf.getText()+"%' or "
                             + "InvoiceNo like '%"+searchtf.getText()+"%' ) order by invoiceNo   ";
                    
                    //refresh();
                 //String query = "Select * from StockOut where cast(dbo.StockOut.Date as date) between "
                   //     + "  '"+fromSplit[0]+"' and '"+toSplit[0]+"' ";
                    
                    findUsers(query);
                   
                }
     }
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel fromText;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtf;
    private javax.swing.JTable stable;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JLabel toText;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        String order = "";
      if(fromSplit != null && toSplit != null){
           String query = 
                    "Select * from StockOut where cast(dbo.StockOut.Date as date ) between '"+fromSplit[0]+"' and "
                             + " '"+toSplit[0]+"' and " +
        " (ProductId like '%"+searchtf.getText()+"%' or  Barcode like '%"+searchtf.getText()+"%' or"
                  + " ProductName like '%"+searchtf.getText()+"%' or ProductDesc like '%"+searchtf.getText()+"%' or "
                  + "Category " 
                  + " like '%"+searchtf.getText()+"%' or Quantity like '%"+searchtf.getText()+"' or  "
                  + "SellPrice like '%"+searchtf.getText()+"'or Total like '%"+searchtf.getText()+"%' or "
                             + "InvoiceNo like '%"+searchtf.getText()+"%' ) order by invoiceNo   ";
           findUsers(query);
      }else{
          String query = "Select * from StockOut where ProductId like '%"+searchtf.getText()+"%' or  Barcode like '%"+searchtf.getText()+"%' or"
                  + " ProductName like '%"+searchtf.getText()+"%' or ProductDesc like '%"+searchtf.getText()+"%' or "
                  + "Category " 
                  + " like '%"+searchtf.getText()+"%' or Quantity like '%"+searchtf.getText()+"' or  "
                  + "SellPrice like '%"+searchtf.getText()+"'or Total like '%"+searchtf.getText()+"%' or "
                             + "InvoiceNo like '%"+searchtf.getText()+"%' order by invoiceNo";
          findUsers(query);
    }
      
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        if(fromSplit != null && toSplit != null){
           String query = 
                    "Select * from StockOut where cast(dbo.StockOut.Date as date ) between '"+fromSplit[0]+"' and "
                             + " '"+toSplit[0]+"' and " +
        " (ProductId like '%"+searchtf.getText()+"%' or  Barcode like '%"+searchtf.getText()+"%' or"
                  + " ProductName like '%"+searchtf.getText()+"%' or ProductDesc like '%"+searchtf.getText()+"%' or "
                  + "Category " 
                  + " like '%"+searchtf.getText()+"%' or Quantity like '%"+searchtf.getText()+"' or  "
                  + "SellPrice like '%"+searchtf.getText()+"'or Total like '%"+searchtf.getText()+"%' or "
                             + "InvoiceNo like '%"+searchtf.getText()+"%' ) order by invoiceNo   ";
           findUsers(query);
      }else{
          String query = "Select * from StockOut where ProductId like '%"+searchtf.getText()+"%' or  Barcode like '%"+searchtf.getText()+"%' or"
                  + " ProductName like '%"+searchtf.getText()+"%' or ProductDesc like '%"+searchtf.getText()+"%' or "
                  + "Category " 
                  + " like '%"+searchtf.getText()+"%' or Quantity like '%"+searchtf.getText()+"' or  "
                  + "SellPrice like '%"+searchtf.getText()+"'or Total like '%"+searchtf.getText()+"%' or "
                             + "InvoiceNo like '%"+searchtf.getText()+"%' order by invoiceNo";
          findUsers(query);
    }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
