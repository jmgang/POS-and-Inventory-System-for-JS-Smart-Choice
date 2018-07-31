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
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import static system.core.Login.db;
import static system.core.SalesReport.fromSplit;
import system.helper.Helper;
import system.model.StockOutBean;
import system.model.WareHouseBean;
import system.utility.ConnectionUtil;
import system.utility.DateReturn;

/**
 *
 * @author JANSEN
 */
public class SalesReport extends javax.swing.JPanel {

     public static Connection con = ConnectionUtil.getDBConnection(db);
     
     public static enum PERIOD{
         DAILY, 
         WEEKLY, 
         MONTHLY, 
         YEARLY
     }
     //Default period
     public static PERIOD period = PERIOD.DAILY;
     
     //initialization of both arrays that will be the carrier for the dates
     public static String[] fromSplit, toSplit;
    public SalesReport() {
        initComponents();
        String normal = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";
        String query = "Select distinct(DATEADD(dd, DATEDIFF(dd, 0, date), 0)) as date from StockOut";
        setTable(normal, query);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        category = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        fromDate = new com.toedter.calendar.JDateChooser();
        fromText = new javax.swing.JLabel();
        toText = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        total.setBackground(new java.awt.Color(255, 255, 255));
        total.setText("TOTAL:");

        category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Daily", "Monthly", "Yearly", " " }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel1.setText("Time Period:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27))
        );

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        fromDate.setDateFormatString("yyyy-MM-dd");
        fromDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromDatePropertyChange(evt);
            }
        });

        fromText.setText("From:");

        toText.setText("To:");

        toDate.setDateFormatString("yyyy-MM-dd");
        toDate.setMinSelectableDate(new java.util.Date(978282066000L));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fromText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fromText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fromDate.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("date".equals(e.getPropertyName())) {
                        if(fromDate.getDate() != null && toDate.getDate() != null){
                            Date fdate = fromDate.getDate();
                            Date tdate = toDate.getDate();
                            String fromSplit[] =  DateFormat.getInstance()
                            .format(fdate).split("\\s+");
                            String toSplit[] =  DateFormat.getInstance()
                            .format(tdate).split("\\s+");
                            String normal = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                            + "StockOut.Total, Stockout.Date from " +
                            "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId where "
                            + "cast(StockOut.date as Date) between '"+fromSplit[0]+"' and '"+toSplit[0]+"' ";
                            String query = "Select distinct(DATEADD(dd, DATEDIFF(dd, 0, date), 0)) as date "
                            + "from StockOut where cast(StockOut.date as date) between '"+fromSplit[0]+"' and"
                            + " '"+toSplit[0]+"' ";

                            setTable(normal, query);
                        }

                    }
                }
            });
            this.add(fromDate);
            toDate.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent e) {
                        if ("date".equals(e.getPropertyName())) {
                            if(fromDate.getDate() != null && toDate.getDate() != null){
                                Date fdate = fromDate.getDate();
                                Date tdate = toDate.getDate();
                                String[] fromSplit =  DateFormat.getInstance()
                                .format(fdate).split("\\s+");
                                String[] toSplit =  DateFormat.getInstance()
                                .format(tdate).split("\\s+");
                                String normal = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                                + "StockOut.Total, Stockout.Date from " +
                                "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId where "
                                + "cast(StockOut.date as Date) between '"+fromSplit[0]+"' and '"+toSplit[0]+"' ";
                                String query = "Select distinct(DATEADD(dd, DATEDIFF(dd, 0, date), 0)) as date "
                                + "from StockOut where cast(StockOut.date as date) between '"+fromSplit[0]+"' and"
                                + " '"+toSplit[0]+"' ";

                                setTable(normal, query);
                            }

                        }
                    }
                });
                this.add(toDate);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                );
            }// </editor-fold>//GEN-END:initComponents

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
         if(category.getSelectedIndex() == 1){
             setTableforMonth();
         }
         
         if(category.getSelectedIndex() == 2){
             setTableforYear();
         }
         
         if(category.getSelectedIndex() == 0){
            String normal = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";
            String query = "Select distinct(DATEADD(dd, DATEDIFF(dd, 0, date), 0)) as date from StockOut";

             setTable(normal, query);
         }
    }//GEN-LAST:event_categoryActionPerformed

    private void fromDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromDatePropertyChange
       
    }//GEN-LAST:event_fromDatePropertyChange
    
    //Sets the table to the default period's specifications
    public void setTable(String normal, String query){ 
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        
      
        model.setColumnIdentifiers(new Object[]{"Date", "Total Items Sold", "Sales", "Costs", "Profits"});
        ResultSet rs = Helper.getData(con, query);
        String outer[];
        String inner[];
        int qty = 0; //Pertains to Total Items Sold
        float costs = 0, sales = 0, profits = 0; 

        Object[] row = new Object[5];
         try {
             while(rs.next()){
                 outer = rs.getTimestamp("date").toString().split("\\s+");
                 row[0] = outer[0];
                 ResultSet rs2 = Helper.getData(con, normal);
                 while(rs2.next()){
                     inner = rs2.getTimestamp("Date").toString().split("\\s+");
                     if(outer[0].equals(inner[0])){
                         qty += rs2.getInt("Quantity");
                         costs += rs2.getInt("Quantity") * rs2.getFloat("Cost");
                         sales += rs2.getInt("Quantity") * rs2.getFloat("SellPrice");
                         profits += rs2.getInt("Quantity") * ( rs2.getFloat("SellPrice") - rs2.getFloat("Cost") );                         
                     }
                 }
                  row[1] = qty;
                  row[2] = "₱ " + sales;
                  row[3] = "₱ " + costs;
                  row[4] = "₱ " +profits;
                  qty = 0; costs = 0; sales = 0; profits = 0;
                  model.addRow(row);
             }
             
             stable.setModel(model);
             total.setText("TOTAL: " + model.getRowCount());
         } catch (SQLException ex) {
             Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
         }
           
    }
    
    public void setTableforMonth(){
         DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        String query = "Select distinct(MONTH(StockOut.Date)) as Month, Year(StockOut.Date) as Year from StockOut";
        String normal = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, " +
                        " StockOut.Total, MONTH(StockOut.date) as Month, YEAR(StockOut.date) as Year from  " +
                        " Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId ";
        model.setColumnIdentifiers(new Object[]{"Date", "Total Items Sold", "Sales", "Costs", "Profits"});
        ResultSet rs = Helper.getData(con, query);
       
        int qty = 0; //Pertains to Total Items Sold
        float costs = 0, sales = 0, profits = 0; 

        Object[] row = new Object[5];
         try {
             while(rs.next()){          
                 row[0] = DateReturn.formatMonth(rs.getString("Month")) + rs.getString("Year");
                 ResultSet rs2 = Helper.getData(con, normal);
                 while(rs2.next()){

                     if(rs.getString("Month").equals(rs2.getString("Month")) &&
                             rs.getString("Year").equals(rs2.getString("Year"))){
                         System.out.println("OMFG it connects");
                         qty += rs2.getInt("Quantity");
                         costs += rs2.getInt("Quantity") * rs2.getFloat("Cost");
                         sales += rs2.getInt("Quantity") * rs2.getFloat("SellPrice");
                         profits += rs2.getInt("Quantity") * ( rs2.getFloat("SellPrice") - rs2.getFloat("Cost") );                         
                     }
                 }
                  row[1] = qty;
                  row[2] = "₱ " + sales;
                  row[3] = "₱ " + costs;
                  row[4] = "₱ " +profits;
                  qty = 0; costs = 0; sales = 0; profits = 0;
                  model.addRow(row);
             }
             
             stable.setModel(model);
         } catch (SQLException ex) {
             Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void setTableforYear(){
          DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        String query = "Select distinct(Year(StockOut.Date)) as Year from StockOut";
        String normal = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, " +
                        " StockOut.Total, YEAR(StockOut.Date) as Year from  " +
                        " Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId ";
        model.setColumnIdentifiers(new Object[]{"Date", "Total Items Sold", "Sales", "Costs", "Profits"});
        ResultSet rs = Helper.getData(con, query);
       
        int qty = 0; //Pertains to Total Items Sold
        float costs = 0, sales = 0, profits = 0; 

        Object[] row = new Object[5];
         try {
             while(rs.next()){          
                 row[0] = rs.getString("Year");
                 ResultSet rs2 = Helper.getData(con, normal);
                 while(rs2.next()){

                     if(rs.getString("Year").equals(rs2.getString("Year"))){
                         System.out.println("OMFG it connects");
                         qty += rs2.getInt("Quantity");
                         costs += rs2.getInt("Quantity") * rs2.getFloat("Cost");
                         sales += rs2.getInt("Quantity") * rs2.getFloat("SellPrice");
                         profits += rs2.getInt("Quantity") * ( rs2.getFloat("SellPrice") - rs2.getFloat("Cost") );                         
                     }
                 }
                  row[1] = qty;
                  row[2] = "₱ " + sales;
                  row[3] = "₱ " + costs;
                  row[4] = "₱ " +profits;
                  qty = 0; costs = 0; sales = 0; profits = 0;
                  model.addRow(row);
             }
             
             stable.setModel(model);
         } catch (SQLException ex) {
             Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
  
    public float[] computeForDay(String query){
      
        ResultSet rs = Helper.getData(con, query);
         try {
               float quantity = 0;
               float costs = 0;
               float profit = 0;
               float sales = 0;
             while(rs.next()){
                 quantity += rs.getInt("Quantity");
                 costs += rs.getInt("Quantity") * rs.getFloat("Cost");
                 sales += rs.getFloat("Total");
                 profit += rs.getFloat("Total") - ( rs.getInt("Quantity") * rs.getFloat("Quantity")  );
                 
             }
               return new float[]{(int)quantity, costs, sales, profit};
         
         } catch (SQLException ex) {
             Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
        return null;
      
    }
   
    
   
    //refresh: remove all the components, then revalidate and repaint, then start over again.
     public void refresh(){
        removeAll();
        revalidate();
        repaint();
        initComponents();
     }
     
     
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox category;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel fromText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stable;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JLabel toText;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    
}
