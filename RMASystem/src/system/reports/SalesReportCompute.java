
package system.reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static system.core.Login.db;
import system.helper.Helper;
import system.utility.ConnectionUtil;

public class SalesReportCompute {
    
    public static Connection con = ConnectionUtil.getDBConnection(db);
    public static void main(String[] args){
        String query = "Select * from StockOut where cast(dbo.StockOut.date as date ) between "
                   + " '2/10/17' and '2/10/17' " ;
           ResultSet rs2 = Helper.getData(con, "Select * from SellingArea");
           ResultSet rs = Helper.getData(con, query);
           int sum = 0;
           int total = 0;
           float sales = 0;
           float totalSales = 0;
        try {
            while(rs2.next()){
                while(rs.next()){
                    if(rs2.getInt("ProductId") == rs.getInt("ProductId")){
                        
                        sum += rs.getInt("Quantity");
                        sales += rs.getInt("Quantity") * rs.getFloat("SellPrice");
                        System.out.println(rs.getString("ProductName") + " Quantity: " + rs.getInt("Quantity")
                                           + " SellPrice: " + rs.getFloat("SellPrice"));
                    }                    
                }
                System.out.println("Total quantites sold for this item: " + sum);
                System.out.println("Total Sales for this Item: " + sales);
                total += sum;
                totalSales += sales;
                sum = 0;
                sales = 0;
                rs = Helper.getData(con, query );
            }
             System.out.println("\nTotal items sold for this period: " + total); //# of items sold of that product
              System.out.println("\nTotal sales for this period: " + totalSales);
        } catch (SQLException ex) {
            Logger.getLogger(SalesReportCompute.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}   
