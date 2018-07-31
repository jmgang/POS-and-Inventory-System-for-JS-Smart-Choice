/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.core;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import net.sf.jasperreports.view.JRViewer;
import system.dynareports.ImageBannerReportTest;
import system.dynareports.SalesByDateReport;
import system.utility.DateReturn;
import system.utility.Sales;

/**
 *
 * @author JANSEN
 */
public class SalesByDate extends javax.swing.JPanel {
    public JRViewer jv;
    public String sub_add = "";
    public SalesByDate() {
        initComponents();
        
        //set default selected
        costc.setSelected(true);
        quantityc.setSelected(true);
        salesc.setSelected(true);
        profitc.setSelected(true);
        
        a4por.setSelected(true); //page and orientation default
        periodr.setSelected(true); //radiobutton default period
        period.setEnabled(true); // period combo box selected
        
        //turn non-defaults false
        yearr.setSelected(false);
        year.setEnabled(false);
        
        monthr.setSelected(false);
        dayr.setSelected(false);
      
        month.setEnabled(false);
        yearMonth.setEnabled(false);
        fromLabel.setEnabled(false);
        toLabel.setEnabled(false);
        day.setEnabled(false);
        dayTo.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        quantityc = new javax.swing.JCheckBox();
        costc = new javax.swing.JCheckBox();
        salesc = new javax.swing.JCheckBox();
        profitc = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        subtitle = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        a4por = new javax.swing.JRadioButton();
        a4land = new javax.swing.JRadioButton();
        legpor = new javax.swing.JRadioButton();
        legland = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        yearr = new javax.swing.JRadioButton();
        year = new com.toedter.calendar.JYearChooser();
        monthr = new javax.swing.JRadioButton();
        month = new com.toedter.calendar.JMonthChooser();
        yearMonth = new com.toedter.calendar.JYearChooser();
        dayr = new javax.swing.JRadioButton();
        day = new com.toedter.calendar.JDateChooser();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        dayTo = new com.toedter.calendar.JDateChooser();
        periodr = new javax.swing.JRadioButton();
        period = new javax.swing.JComboBox();
        reportPanel = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Generate Report");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Columns"));

        quantityc.setText("Sold Quantity");

        costc.setText("Cost");

        salesc.setText("Sales");

        profitc.setText("Profit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityc, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(costc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesc, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(profitc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(142, 142, 142))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(quantityc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profitc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Titles")), "Titles"));

        jLabel1.setText("Title:");

        jLabel2.setText("SubTitle:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(subtitle)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(subtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Page Size and Orientation"));

        a4por.setText("A4 Portrait");
        a4por.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4porActionPerformed(evt);
            }
        });

        a4land.setText("A4 Landscape");
        a4land.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4landActionPerformed(evt);
            }
        });

        legpor.setText("Legal Portrait");
        legpor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                legporActionPerformed(evt);
            }
        });

        legland.setText("Legal Landscape");
        legland.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leglandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a4land)
                    .addComponent(a4por))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(legpor)
                    .addComponent(legland))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a4por)
                    .addComponent(legpor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a4land)
                    .addComponent(legland))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Date"));

        yearr.setText("Year");
        yearr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearrActionPerformed(evt);
            }
        });

        monthr.setText("Month:");
        monthr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthrActionPerformed(evt);
            }
        });

        dayr.setText("Day:");
        dayr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayrActionPerformed(evt);
            }
        });

        day.setDateFormatString("yyyy-MM-dd");
        day.setMinSelectableDate(new java.util.Date(978282103000L));

        fromLabel.setText("From:");

        toLabel.setText("To:");

        dayTo.setDateFormatString("yyyy-MM-dd");

        periodr.setText("Period:");
        periodr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodrActionPerformed(evt);
            }
        });

        period.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Daily", "Weekly", "Monthly", "Yearly" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(yearr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monthr)
                            .addComponent(dayr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dayTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(fromLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(periodr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodr)
                    .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(yearMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(yearr)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(monthr)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dayr)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fromLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(day, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toLabel)
                    .addComponent(dayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        reportPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reportPanel.removeAll(); 
      //  runn();
        
        if(periodr.isSelected()){
            Sales.dateType = Sales.DateType.PERIOD;
            if(period.getSelectedIndex() == 0){
                Sales.periodType = Sales.PeriodType.DAILY;
                sub_add = "\\nDaily Sales Report";
            }else if(period.getSelectedIndex() == 1){
                Sales.periodType = Sales.PeriodType.WEEKLY;
                sub_add = "\\nWeekly Sales Report";
            }else if(period.getSelectedIndex() == 2){
                Sales.periodType = Sales.PeriodType.MONTHLY;
                sub_add = "\\nMonthly Sales Report";
            }else if(period.getSelectedIndex() == 3){
                Sales.periodType = Sales.PeriodType.YEARLY;
                sub_add = "\\nYearly Sales Report";
            }
            
            init();
            start();
        }else if(yearr.isSelected()){
            Sales.dateType = Sales.DateType.YEAR;
            Sales.Year = year.getYear();
            
            sub_add = "\\nShowing Reports of " + Sales.Year + "";
             init();
             start();
        }else if(monthr.isSelected()){
            Sales.dateType = Sales.DateType.MONTH;
            Sales.Year = yearMonth.getYear();
            Sales.Month = month.getMonth()+1;
             
            sub_add = "\\nShowing Reports of " + DateReturn.formatMonth(Sales.Month+"").trim() + ", " + Sales.Year;
             init();
             start();
        }else if(dayr.isSelected()){
            Sales.dateType = Sales.DateType.DAY;
            
            Date from = day.getDate();
            Date to = dayTo.getDate();
            if(from != null && to != null){
                String dateFro[] = DateFormat.getInstance().format(from).split("\\s+");
                String dateTo[] = DateFormat.getInstance().format(to).split("\\s+");
                Sales.From = dateFro[0];
                Sales.To = dateTo[0];
                if(Sales.From.equals(Sales.To)) 
                    sub_add = "\\nShowing Reports of " + Sales.From;
                else 
                    sub_add = "\\nShowing Reports from " + Sales.From + " to " + Sales.To;
                
                 init();
                start();
            }else{
                JOptionPane.showMessageDialog(reportPanel, "Invalid Date entered. \n"
                        + "Make sure that all fields in date are not blank."  , "Date Error" ,
                        JOptionPane.ERROR_MESSAGE);
            }
            
        } 
        
       
       
        
    }//GEN-LAST:event_jButton1ActionPerformed
     public void init(){
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 ImageIcon icon = new ImageIcon(
            getClass().getResource("/images/clock.gif")
            );
             JLabel label = new JLabel();
            RotatingIcon rotate = new RotatingIcon(icon, reportPanel);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setIcon(icon);
            reportPanel.setLayout(new BorderLayout());
            reportPanel.add(label, BorderLayout.CENTER);
            rotate.rotatingTimer.start();
          
            }
        });
     } 
     
     private void start(){
         SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>(){

             @Override
             protected Boolean doInBackground() throws Exception {
             try {
                 String subtitle_full = subtitle.getText() + sub_add;
                SalesByDateReport rep =
                new SalesByDateReport(title.getText(), subtitle_full,
                 quantityc.isSelected(), costc.isSelected(),
                 salesc.isSelected(), profitc.isSelected(), 
                a4por.isSelected(), a4land.isSelected(), legpor.isSelected(), 
                legland.isSelected());
               
                rep.testReport();
     
                jv = new JRViewer(rep.jp);
            
                
            } catch (Exception ex) {
                Logger.getLogger(SalesByDate.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
                 
                 return true;
        }

             @Override
             protected void done() {
                 try {
                     Boolean status = get();
                     if(status){
                          
                     reportPanel.removeAll();
                     reportPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    // reportPanel.setPreferredSize(new java.awt.Dimension(1000, 700));
                     reportPanel.setLayout(new java.awt.BorderLayout());
                     reportPanel.add(jv);
                     reportPanel.repaint();
                     reportPanel.revalidate();
                     }else{
                         System.out.println("Error");
                     }
                 } catch (InterruptedException ex) {
                     Logger.getLogger(SalesByDate.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (ExecutionException ex) {
                     Logger.getLogger(SalesByDate.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        
             
             
         };
         worker.execute();
     }
     
    private void a4porActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4porActionPerformed
        a4land.setSelected(false);
        legpor.setSelected(false);
        legland.setSelected(false);
        
    }//GEN-LAST:event_a4porActionPerformed

    private void legporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_legporActionPerformed
       a4por.setSelected(false);
       a4land.setSelected(false);
       legland.setSelected(false);
    }//GEN-LAST:event_legporActionPerformed

    private void a4landActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4landActionPerformed
      a4por.setSelected(false);
      legpor.setSelected(false);
      legland.setSelected(false);
      
    }//GEN-LAST:event_a4landActionPerformed

    private void leglandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leglandActionPerformed
       a4por.setSelected(false);
       a4land.setSelected(false);
       legpor.setSelected(false);
    }//GEN-LAST:event_leglandActionPerformed

    private void yearrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearrActionPerformed
       monthr.setSelected(false);
       dayr.setSelected(false);
      
       month.setEnabled(false);
       yearMonth.setEnabled(false);
       day.setEnabled(false);
       fromLabel.setEnabled(false);
       toLabel.setEnabled(false);
       dayTo.setEnabled(false);
       
       periodr.setSelected(false);
       period.setEnabled(false);
       
       if(!year.isEnabled()) year.setEnabled(true);
    }//GEN-LAST:event_yearrActionPerformed

    private void monthrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthrActionPerformed
       yearr.setSelected(false);
       dayr.setSelected(false);
       
       year.setEnabled(false);
       day.setEnabled(false);
       fromLabel.setEnabled(false);
       toLabel.setEnabled(false);
       dayTo.setEnabled(false);
       
       periodr.setSelected(false);
       period.setEnabled(false);
       
       if(!month.isEnabled() && !yearMonth.isEnabled()){
           month.setEnabled(true);
           yearMonth.setEnabled(true);
       }
    }//GEN-LAST:event_monthrActionPerformed

    private void dayrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayrActionPerformed
       monthr.setSelected(false);
       yearr.setSelected(false);
       
       month.setEnabled(false);
       yearMonth.setEnabled(false);
       year.setEnabled(false);
       
       periodr.setSelected(false);
       period.setEnabled(false);
       
       if(!day.isEnabled() && !fromLabel.isEnabled() && !toLabel.isEnabled() && 
               !dayTo.isEnabled()) {
           day.setEnabled(true);
           fromLabel.setEnabled(true);
           toLabel.setEnabled(true);
           dayTo.setEnabled(true);
       }
    }//GEN-LAST:event_dayrActionPerformed

    private void periodrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodrActionPerformed
       monthr.setSelected(false);
       yearr.setSelected(false);
       dayr.setSelected(false);
       
       month.setEnabled(false);
       yearMonth.setEnabled(false);
       year.setEnabled(false);
       day.setEnabled(false);
       dayTo.setEnabled(false);
       
       if( !period.isEnabled()){
           period.setEnabled(true);
       }
    }//GEN-LAST:event_periodrActionPerformed
    
     private static class RotatingIcon implements Icon{
    private final Icon delegateIcon;
    private double angleInDegrees = 90;
    public final Timer rotatingTimer;
    private RotatingIcon( Icon icon, final JComponent component ) {
      delegateIcon = icon;
      rotatingTimer = new Timer( 0, new ActionListener() {
        @Override
        public void actionPerformed( ActionEvent e ) {
          angleInDegrees = angleInDegrees + 10;
          if ( angleInDegrees == 360 ){
            angleInDegrees = 0;
          }
          component.repaint();
          component.revalidate();
        }
      } );
      rotatingTimer.setRepeats( false );
      rotatingTimer.start();
      
    }

    @Override
    public void paintIcon( Component c, Graphics g, int x, int y ) {
      rotatingTimer.stop();
      Graphics2D g2 = (Graphics2D )g.create();
      int cWidth = delegateIcon.getIconWidth() / 2;
      int cHeight = delegateIcon.getIconHeight() / 2;
      Rectangle r = new Rectangle(x, y, delegateIcon.getIconWidth(), delegateIcon.getIconHeight());
      g2.setClip(r);
      AffineTransform original = g2.getTransform();
      AffineTransform at = new AffineTransform();
      at.concatenate(original);
      at.rotate(Math.toRadians( angleInDegrees ), x + cWidth, y + cHeight);
      g2.setTransform(at);
      delegateIcon.paintIcon(c, g2, x, y);
      g2.setTransform(original);
      rotatingTimer.start();
    }

    @Override
    public int getIconWidth() {
      return delegateIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return delegateIcon.getIconHeight();
    }
  } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton a4land;
    private javax.swing.JRadioButton a4por;
    private javax.swing.JCheckBox costc;
    private com.toedter.calendar.JDateChooser day;
    private com.toedter.calendar.JDateChooser dayTo;
    private javax.swing.JRadioButton dayr;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton legland;
    private javax.swing.JRadioButton legpor;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JRadioButton monthr;
    private javax.swing.JComboBox period;
    private javax.swing.JRadioButton periodr;
    private javax.swing.JCheckBox profitc;
    private javax.swing.JCheckBox quantityc;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JCheckBox salesc;
    private javax.swing.JTextField subtitle;
    private javax.swing.JTextField title;
    private javax.swing.JLabel toLabel;
    private com.toedter.calendar.JYearChooser year;
    private com.toedter.calendar.JYearChooser yearMonth;
    private javax.swing.JRadioButton yearr;
    // End of variables declaration//GEN-END:variables
}
