package system.utility;

import java.sql.*;
import system.model.DatabaseBean;


public class ConnectionUtil {

	public static Connection getDBConnection(DatabaseBean dbean)  {
		Connection con = null;
		
		try {
			String url = "jdbc:jtds:sqlserver://" + dbean.getHost() + ":" + dbean.getPort() 
                                + "/" + dbean.getDatabaseName();
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection(url, dbean.getUsername(), dbean.getPassword());
				
			System.out.println((con != null)
				?"successfully connected to the database"
				: "connection is null");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return con;
	}
	
}
