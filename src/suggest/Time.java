
package suggest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static system.core.Login.db;
import system.helper.Helper;
import system.utility.ConnectionUtil;

/**
 *
 * @author JANSEN
 */
public class Time {
    public static Connection con = ConnectionUtil.getDBConnection(db);
    public static void main(String[] args){
        try {
            ResultSet rs = Helper.getData(con, "Select * from StockOut");
            while(rs.next()){
                java.sql.Date date = rs.getDate("Date");
                java.sql.Time time = rs.getTime("Date");
                java.sql.Timestamp timeStamp = rs.getTimestamp("Date");
                
                java.util.Date timeCon = new java.util.Date(time.getTime());
                java.util.Date dateCon = new java.util.Date(date.getTime());
                
                System.out.println("Timestamp: " + timeStamp);
                System.out.println("Date: " + dateCon);
                System.out.println("Time: " + timeCon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
