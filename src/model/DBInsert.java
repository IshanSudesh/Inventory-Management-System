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
public class DBInsert {

    Statement stmt;

    public boolean insertOrderDetails(String date, String customer_id) {

        boolean isSuccess = false;
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO ordersplacing (order_date, customer_id) VALUES ('" + date + "', '" + customer_id + "')";
            int result = stmt.executeUpdate(sql);

            if (result == 1) {
                isSuccess = true;
            }

            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return isSuccess;
    }

    public boolean insertOrder_productDetails(String order_id, String product_id, String qty) {

        boolean isSuccess = false;
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO order_products (order_id, product_id, order_product_quantity) VALUES ('" + order_id + "', '" + product_id + "', '" + qty + "')";
            int result = stmt.executeUpdate(sql);

            if (result == 1) {
                isSuccess = true;
            }

            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return isSuccess;
    }

    public boolean addNewCustomerDetails(String name, String address, String phone, String email) {

        boolean isSuccess = false;

        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO customerdetails (cus_name, cus_address, cus_telephone, cus_email) VALUES ('" + name + "', '" + address + "', '" + phone + "', '" + email + "')";
            int result = stmt.executeUpdate(sql);

            if (result == 1) {
                isSuccess = true;
            }

            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return isSuccess;
    }

    //MRP by EACMS
    //insert raw material to database
    public void insert_Material_Details(String material_name, String material_unit, String price_per_unit, String stock_quantity) {
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO rawmaterial (material_name, material_unit, price_per_unit, stock_quantity) VALUES ('" + material_name + "', '" + material_unit + "', '" + price_per_unit + "', '" + stock_quantity + "')";
            stmt.executeUpdate(sql);
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // add data to order row material table  
    public void insert_Details_to_order_row_material(String order_id, String material_id, String order_material_total_qty, String order_material_total_price) {
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO order_rawmaterial (order_id , material_id, order_material_total_qty, order_material_total_price) VALUES ('" + order_id + "', '" + material_id + "', '" + order_material_total_qty + "', '" + order_material_total_price + "')";
            stmt.executeUpdate(sql);
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println("error in order_rawmaterial");
            System.out.println(e.toString());
        }
        
    }

    
    //add product to product table
    public void insert_product(String product_name, String weight, String price) {
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO productdetails (product_name, product_weight, product_price) VALUES ('" + product_name + "', '" + weight + "', '" + price + "')";
            stmt.executeUpdate(sql);
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void insert_Materials_to_product(String product_id, String material_id, String qty) {
        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO product_planing (product_id, material_id, product_material_quantity) VALUES ('" + product_id + "', '" + material_id + "', '" + qty + "')";
            stmt.executeUpdate(sql);
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //Add new user => Pavan Fernando
    public boolean addNewUserDetails(String name, String email, String phone, String address, String department, String password) {

        boolean isSuccess = false;

        try {
            stmt = DBConnection.getStatementConnection();
            String sql = "INSERT INTO userdetails (u_name, u_email, u_telephone, u_address, u_department, u_password) VALUES ('" + name + "', '" + address + "', '" + phone + "', '" + email + "', '" + department + "', '" + password + "')";
            int result = stmt.executeUpdate(sql);

            if (result == 1) {
                isSuccess = true;
            }

            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return isSuccess;
    }
}
