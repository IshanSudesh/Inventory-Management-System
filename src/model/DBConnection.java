package model;

import java.sql.*;

/**
 *
 * @author Pavan Fernando
 */
public class DBConnection {
    static Connection conn;
    static Statement stat;
    
    public static Statement getStatementConnection () {
        try {
            String url = "jdbc:mysql://localhost:3306/inventory_management_system";
            conn = DriverManager.getConnection(url, "root", "");
            stat = conn.createStatement();
            
            System.out.println("Successfully Connected!!");
                    
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return stat;
    }
    
    public static void closeCon() throws SQLException{
        conn.close();
    }
}
