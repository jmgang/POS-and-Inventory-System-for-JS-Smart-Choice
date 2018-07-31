
package system.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static system.core.Login.db;
import system.helper.Helper;
import system.model.SalesByDateBean;
import system.model.SalesByProductBean;

/**
 *
 * @author JANSEN ANG
 */
public class Sales {
    public static Connection con = ConnectionUtil.getDBConnection(db);
    public static enum DateType{
        YEAR, 
        MONTH, 
        DAY, 
        PERIOD
    };
    public static enum PeriodType{
        DAILY,
        WEEKLY, 
        MONTHLY,
        YEARLY
    };
    public static DateType dateType = DateType.YEAR;
    public static PeriodType periodType = PeriodType.DAILY;
    public static int Year = 2017;
    public static int Month = 1;
    public static String From = "01/01/2001";
    public static String To = "01/01/3000";
    
    public static List getSalesbyProduct(){
        List list = new ArrayList();
        try {
            String inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";;
            
            if(dateType == DateType.YEAR){
                 inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId "
                         + "where Year(StockOut.Date) = '"+Year+"' ";
            }else if(dateType == DateType.MONTH){
                  inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId "
                          + "where Year(StockOut.Date) = '" +Year+"' and Month(StockOut.Date) = '"+Month+"' ";
            }else if(dateType == DateType.DAY){
                  inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId where " +
                        " cast(StockOut.Date as date) between '"+From+"' and '"+To+"'  ";
            }
            
            
            String outer = "Select * from Warehouse";
            
            int qty = 0;
            float costs = 0, sales = 0, profits = 0;
            ResultSet out = Helper.getData(con, outer);
            
            while(out.next()){
                ResultSet inn = Helper.getData(con, inner);
                while(inn.next()){
                    if(out.getString("Barcode").equals(inn.getString("Barcode"))){
                        qty += inn.getInt("Quantity");
                        costs += inn.getInt("Quantity") * inn.getFloat("Cost");
                        sales += inn.getInt("Quantity") * inn.getFloat("SellPrice");
                        profits += inn.getInt("Quantity") * ( inn.getFloat("SellPrice") - inn.getFloat("Cost") );       
                    }
                    
                    
                }
                
             list.add(new SalesByProductBean(out.getInt("ProductId"), out.getString("Barcode"),
                 out.getString("ProductName"), out.getString("ProductDesc"), out.getString("Category"),
                 qty, costs, sales, profits));
                qty = 0; costs = 0; sales = 0; profits = 0;
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     return list;
    }
    
    public static List getSalesByDate(){
        List list = new ArrayList();
      
            String outer = "Select * from Warehouse";
            String inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";;
            if(dateType == DateType.PERIOD){
               if(periodType == PeriodType.DAILY){
                  outer = "Select distinct(DATEADD(dd, DATEDIFF(dd, 0, date), 0)) as date from StockOut";
                  inner = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId";
                  list = getDaily(outer, inner);
               }else if(periodType == PeriodType.WEEKLY){
                   
               }else if(periodType == PeriodType.MONTHLY){
                   outer = "Select distinct(MONTH(StockOut.Date)) as Month, Year(StockOut.Date) as Year from StockOut";
                   inner = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, " +
                        " StockOut.Total, MONTH(StockOut.date) as Month, YEAR(StockOut.date) as Year from  " +
                        " Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId ";
                   list = getMonthly(outer, inner);
               }else if(periodType == PeriodType.YEARLY){
                   outer = "Select distinct(Year(StockOut.Date)) as Year from StockOut";
                    inner = "Select Warehouse.ProductName, StockOut.Quantity, WareHouse.Cost, StockOut.SellPrice, " +
                        " StockOut.Total, YEAR(StockOut.Date) as Year from  " +
                        " Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId ";
                    list = getYearly(outer, inner);
               }
            }
            else if(dateType == DateType.YEAR){
                 inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId "
                         + "where Year(StockOut.Date) = '"+Year+"' ";
                 
            }else if(dateType == DateType.MONTH){
                  inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId "
                          + "where Year(StockOut.Date) = '" +Year+"' and Month(StockOut.Date) = '"+Month+"' ";
            }else if(dateType == DateType.DAY){
                  inner =  "Select Warehouse.Barcode, Warehouse.ProductName, StockOut.Quantity, "
                        + "WareHouse.Cost, StockOut.SellPrice, "
                        + "StockOut.Total, Stockout.Date from " +
                        "Warehouse inner join StockOut on Warehouse.ProductId = StockOut.ProductId where " +
                        " cast(StockOut.Date as date) between '"+From+"' and '"+To+"'  ";
            }
            
     return list;  
        
      
    }
    
    public static List getDaily(String outer, String inner){
        List list = new ArrayList();
           try {
            int qty = 0;
            float costs = 0, sales = 0, profits = 0;
            String outerDate[];
            String innerDate[];
            String date;
            String name = "";
            ResultSet out = Helper.getData(con, outer);
            
            while(out.next()){
                outerDate = out.getTimestamp("date").toString().split("\\s+");
                date = outerDate[0];
                ResultSet inn = Helper.getData(con, inner);
                
                while(inn.next()){
                    innerDate = inn.getTimestamp("Date").toString().split("\\s+");
                    if(outerDate[0].equals(innerDate[0])){
                        
                        qty += inn.getInt("Quantity");
                        costs += inn.getInt("Quantity") * inn.getFloat("Cost");
                        sales += inn.getInt("Quantity") * inn.getFloat("SellPrice");
                        profits += inn.getInt("Quantity") * ( inn.getFloat("SellPrice") - inn.getFloat("Cost") );       
                    }
                    
                 
                }
            
           
            list.add(new SalesByDateBean(date, qty, costs, sales, profits));
                qty = 0; costs = 0; sales = 0; profits = 0;
                
                
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }
    
    public static List getMonthly(String outer, String inner){
        List list = new ArrayList();
          try {
            int qty = 0;
            float costs = 0, sales = 0, profits = 0;
            String date;
            String name = "";
            ResultSet out = Helper.getData(con, outer);
            
            while(out.next()){
                date = DateReturn.formatMonth(out.getString("Month")) + out.getString("Year");
                System.out.println("DKLJFKJDKFJKSDLFJKLSDJ    " + date);
                ResultSet inn = Helper.getData(con, inner);
                while(inn.next()){
                    
                    if(out.getString("Month").equals(inn.getString("Month")) && 
                            out.getString("Year").equals(inn.getString("Year"))){
                     
                        qty += inn.getInt("Quantity");
                        costs += inn.getInt("Quantity") * inn.getFloat("Cost");
                        sales += inn.getInt("Quantity") * inn.getFloat("SellPrice");
                        profits += inn.getInt("Quantity") * ( inn.getFloat("SellPrice") - inn.getFloat("Cost") );       
                    }
                    
                    
                }
               
            list.add(new SalesByDateBean(date, qty, costs, sales, profits));
                qty = 0; costs = 0; sales = 0; profits = 0;
         
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }
    
    public static List getYearly(String outer, String inner){
        List list = new ArrayList();
          try {
            int qty = 0;
            float costs = 0, sales = 0, profits = 0;
            String date;
            String name = "";
            ResultSet out = Helper.getData(con, outer);
            
            while(out.next()){
                date = DateReturn.formatMonth(out.getString("Month") + out.getString("Year"));
                ResultSet inn = Helper.getData(con, inner);
                while(inn.next()){
                    
                    if(out.getString("Year").equals(inn.getString("Year"))){
                       name += inn.getString("ProductName") + ", ";
                        qty += inn.getInt("Quantity");
                        costs += inn.getInt("Quantity") * inn.getFloat("Cost");
                        sales += inn.getInt("Quantity") * inn.getFloat("SellPrice");
                        profits += inn.getInt("Quantity") * ( inn.getFloat("SellPrice") - inn.getFloat("Cost") );       
                    }
                    
                   
                }
                
       
            list.add(new SalesByDateBean(date, qty, costs, sales, profits));
                qty = 0; costs = 0; sales = 0; profits = 0;
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }
    
   
   
}
