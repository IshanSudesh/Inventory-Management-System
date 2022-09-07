/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author EACMS
 */
public class DBDelete {

    Statement stmt;

    public void delete_all_materials_according_to_productId(Object product_id) {
        try {
            String sql = "DELETE FROM product_planing WHERE product_id='" + product_id + "'";
            stmt = DBConnection.getStatementConnection();
            stmt.executeUpdate(sql);
            DBConnection.closeCon();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    
    //Customer Handling by Pavan Fernando
    public boolean deleteACustomer(int customerId){
        
        boolean isSuccess = false;
        
        try {
            
            String sql = "DELETE FROM customerdetails WHERE customer_id ='" + customerId + "'";
            stmt = DBConnection.getStatementConnection();
            int res = stmt.executeUpdate(sql);
            DBConnection.closeCon();
           
            if(res == 1){
                isSuccess = true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return isSuccess; 
    }

}
