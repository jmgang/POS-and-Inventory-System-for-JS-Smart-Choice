
package system.helper;

import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.model.POSBean;
import system.model.StockOutBean;
import system.model.SupplierBean;
import system.model.WareHouseBean;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.*;
import system.model.SalesByProductBean;
import system.model.StockInBean;

public class Helper {
    public static ResultSet getData(Connection connection, String query){
        ResultSet data = null;
        try {
              
                PreparedStatement ptstmnt = connection.prepareStatement(query);
                data = ptstmnt.executeQuery();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return data;
    }
    
    
    public static boolean insertToPOS(Connection connection, POSBean b) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(b.getDate());
        cal.set(Calendar.MILLISECOND, 0);
		try {
			String sql = "Insert into POS(ProductId, Barcode, ProductName, " +
				"ProductDesc, Category, SellPrice, Qty, DateAdded) " +
				"values (?,?,?,?,?,?,?, ?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, b.getProductId());
                        ptsmnt.setString(2, b.getBarcode());
                        ptsmnt.setString(3, b.getPname());
                        ptsmnt.setString(4, b.getPdesc());
                        ptsmnt.setString(5, b.getCat());
                        ptsmnt.setFloat(6, b.getSellPrice());
                        ptsmnt.setInt(7, b.getQty());
                        ptsmnt.setTimestamp(8, new java.sql.Timestamp(b.getDate().getTime()));
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	}
    
    public static boolean insertToWarehouse(Connection connection, WareHouseBean b) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(b.getDate());
        cal.set(Calendar.MILLISECOND, 0);
		try {
			String sql = "Insert into Warehouse(ProductId, Barcode, ProductName, " +
				"ProductDesc, Category, InStock, Cost, OnOrder, Supplier, LastDateAdded) " +
				"values (?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, b.getProductId());
                        ptsmnt.setString(2, b.getBarcode());
                        ptsmnt.setString(3, b.getProductName());
                        ptsmnt.setString(4, b.getProductDesc());
                        ptsmnt.setString(5, b.getCat());
                        ptsmnt.setInt(6, b.getInStock());
                        ptsmnt.setFloat(7, b.getCost());
                        ptsmnt.setInt(8, b.getOnOrder());
                        ptsmnt.setString(9, b.getSupp());
                        ptsmnt.setTimestamp(10, new java.sql.Timestamp(b.getDate().getTime()));
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	}
    
    public static boolean insertToSupplier(Connection connection, SupplierBean b) {
       
		try {
			String sql = "Insert into Supplier(SuppId, Name, ContactPerson, " +
				"Phone, Email, Website, Address1, Address2, City, StateProvince, Zip, "
                                + "Country, Discount) " +
				"values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setString(1, b.getSuppId());
                        ptsmnt.setString(2, b.getName());
                        ptsmnt.setString(3, b.getContactPerson());
                        ptsmnt.setString(4, b.getPhone());
                        ptsmnt.setString(5, b.getEmail());
                        ptsmnt.setString(6, b.getWebsite());
                        ptsmnt.setString(7, b.getAdd1());
                        ptsmnt.setString(8, b.getAdd2());
                        ptsmnt.setString(9, b.getCity());
                        ptsmnt.setString(10, b.getState());
                        ptsmnt.setString(11, b.getZip());
                        ptsmnt.setString(12, b.getCountry());
                        ptsmnt.setFloat(13, b.getDiscount());
                       
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	}
        
    public static boolean insertToStockIn(Connection connection, StockInBean b) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(b.getDate());
        cal.set(Calendar.MILLISECOND, 0);
		try {
			String sql = "Insert into StockIn(ProductId, Barcode,ProductName, "
                                + "ProductDesc, Category, Quantity, Cost, Total, Supplier, Date) " +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, b.getProductId());
                        ptsmnt.setString(2, b.getBarcode());
                        ptsmnt.setString(3, b.getProductName());
                        ptsmnt.setString(4, b.getProductDesc());
                        ptsmnt.setString(5, b.getCat());
                        ptsmnt.setInt(6, b.getQuantity());
                        ptsmnt.setFloat(7, b.getCost());
                        ptsmnt.setFloat(8, b.getTotal());
                        ptsmnt.setString(9, b.getSupplier());
                        ptsmnt.setTimestamp(10, new java.sql.Timestamp(b.getDate().getTime()));
  
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	}
    
    
     public static boolean insertToStockOut(Connection connection, StockOutBean b) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(b.getDate());
        cal.set(Calendar.MILLISECOND, 0);
		try {
			String sql = "Insert into StockOut(ProductId, Barcode, InvoiceNo, ProductName, "
                                + "ProductDesc, Category, Quantity, SellPrice, Total, Date) " +
				"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, b.getProductId());
                        ptsmnt.setString(2, b.getBarcode());
                        ptsmnt.setString(3, b.getInvoice());
                        ptsmnt.setString(4, b.getPname());
                        ptsmnt.setString(5, b.getPdesc());
                        ptsmnt.setString(6, b.getCat());
                        ptsmnt.setInt(7, b.getQty());
                        ptsmnt.setFloat(8, b.getSellPrice());
                        ptsmnt.setFloat(9, b.getTotal());
                        ptsmnt.setTimestamp(10, new java.sql.Timestamp(b.getDate().getTime()));
                        
                        System.out.println("Helper " + b.getProductId());
                        
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	}
     
      public static boolean insertToHighestProducts(Connection connection, SalesByProductBean b) {
       
		try {
			String sql = "Insert into HighestProducts(ProductId, Barcode, ProductName, " +
				"ProductDesc, Category, Quantity, Costs, Sales, Profit) " +
				"values (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, b.getProductId());
                        ptsmnt.setString(2, b.getBarcode());
                        ptsmnt.setString(3, b.getProductName());
                        ptsmnt.setString(4, b.getProductDesc());
                        ptsmnt.setString(5, b.getCat());
                        ptsmnt.setInt(6, b.getQuantity());
                        ptsmnt.setFloat(7, b.getCosts());
                        ptsmnt.setFloat(8, b.getSales());
                        ptsmnt.setFloat(9, b.getProfit());
                       
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	}
      
     public static boolean insertToWareQueue(Connection connection, int productId) {
       
		try {
			String sql = "Insert into WareQueue(ProductId) values (?)";
				
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, productId);
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	} 
     
      public static boolean insertToSuppQueue(Connection connection, int productId) {
       
		try {
			String sql = "Insert into SuppQueue(ProductId) values (?)";
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setInt(1, productId);
			//turn off auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
                        return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
                       
			try{
				connection.rollback();
			}catch(SQLException sqlex){
				sqlex.printStackTrace();
                                return false;
			}
		}
                return false;
	} 
    
    public static boolean delete(Connection con, String query){
          try {
                PreparedStatement ptstmnt = con.prepareStatement(query);
                ptstmnt.executeUpdate();
                con.setAutoCommit(false);
                con.commit();
                return true;
		} catch (SQLException sqle) {
              try {
                  con.rollback();
              } catch (SQLException ex) {
                  Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
              }
                    sqle.printStackTrace();
                     return false;
                        
		}
		
    }
    
    public static boolean updatePos(Connection con, int qty, String barcode){
          try {
              String sql = "Update SellingArea set StockQty = " + qty + " where Barcode = " + barcode;
                PreparedStatement ptstmnt = con.prepareStatement(sql);
                ptstmnt.executeUpdate();
                con.setAutoCommit(false);
                con.commit();
                return true;
		} catch (SQLException sqle) {
              try {
                  con.rollback();
              } catch (SQLException ex) {
                  Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
              }
                    sqle.printStackTrace();
                     return false;
                        
		}
    }
    
     public static boolean updatePosDup(Connection con, int qty, String barcode){
          try {
              String sql = "Update POS set Qty = '"+qty+"' where Barcode = '"+barcode+"' ";
                PreparedStatement ptstmnt = con.prepareStatement(sql);
                ptstmnt.executeUpdate();
                con.setAutoCommit(false);
                con.commit();
                return true;
		} catch (SQLException sqle) {
              try {
                  con.rollback();
              } catch (SQLException ex) {
                  Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
              }
                    sqle.printStackTrace();
                     return false;
                        
		}
    }
     
     public static boolean updateWarehouse(Connection con, int qty, String pid){
          try {
              String sql = "Update POS set Qty = " + qty + " where Barcode = " + pid;
                PreparedStatement ptstmnt = con.prepareStatement(sql);
                ptstmnt.executeUpdate();
                con.setAutoCommit(false);
                con.commit();
                return true;
		} catch (SQLException sqle) {
              try {
                  con.rollback();
              } catch (SQLException ex) {
                  Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
              }
                    sqle.printStackTrace();
                     return false;
                        
		}
    }
}
