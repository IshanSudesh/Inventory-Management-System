/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Statement;

/**
 *
 * @author Pavan Fernando
 */
public class DBUpdate {
    
    Statement stmt;
    
    public boolean add_New_Customer_Details(int customerId, String name, String address, String phone, String email) {
        
        boolean isSuccess = false;
        
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "UPDATE customerdetails SET cus_name='" + name + "', cus_address='" + address + "', cus_telephone='" + phone + "', cus_email='" + email + "' WHERE customer_id='"+customerId+"'";
            int result = stmt.executeUpdate(sql);
            
            if(result == 1){
                isSuccess = true;
            }
            
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return isSuccess;
    }
    
    //werehouse done By Pavan Fernando
    //order_materials qty reduce from material stock qty
    public boolean changing_Material_Stock(String material_id, double qty) {
        
        boolean isSuccess = false;
        
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "UPDATE rawmaterial SET stock_quantity='" + qty + "' WHERE material_id = '"+material_id+"'";
            int result = stmt.executeUpdate(sql);
            
            if(result == 1){
                isSuccess = true;
            }
            
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return isSuccess;
    }
    
    public void qty_price_update(String order_id, String material_id, String order_material_total_qty, String order_material_total_price){
               
        try{
            
            stmt = DBConnection.getStatementConnection();
            String sql = "UPDATE order_rawmaterial SET order_material_total_qty='"+order_material_total_qty+"', "
                    + "order_material_total_price='"+order_material_total_price+"' "
                    + "WHERE order_id='"+order_id+"' and material_id='"+material_id+"' ";
            
            stmt.executeUpdate(sql);
           
            DBConnection.closeCon();
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void update_check_material_issue(String order_id, String material_id){
       
        try{
            
            stmt = DBConnection.getStatementConnection();
            String sql = "UPDATE order_rawmaterial SET check_material_issue='true'  "
                    + "WHERE order_id='"+order_id+"' AND material_id='"+material_id+"' ";
            
            stmt.executeUpdate(sql);
           
            DBConnection.closeCon();
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
