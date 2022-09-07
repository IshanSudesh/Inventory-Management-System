/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DBSearch;

/**
 *
 * @author EACMS
 */
public class MRPController {

    Statement stmt;
    static int product_qty = 0;
    static String product_id = "";

    public static void getProductsIds(Object order_id) {

        try {
            ResultSet result = new DBSearch().getProductIds(order_id);
            while (result.next()) {
                System.out.println(result.getString(3));
                product_qty = Integer.parseInt(result.getString(3));
                product_id = result.getString(2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MRPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void get_Materials(Object product_id) {
//        try {
//            ResultSet result = new DBSearch().get_Material_Ids(product_id);
//            while (result.next()) {
//                System.out.println(result.getString(3));
//                product_qty = Integer.parseInt(result.getString(3));
//                product_id = result.getString(2);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MRPController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static void insert_Material_Details(String material_name, String material_unit, String price_per_unit, String stock_quantity) {
        new model.DBInsert().insert_Material_Details(material_name, material_unit, price_per_unit, stock_quantity);
    }

    public static void insertproduct_to_product_table(String product_name, String weight, String price) {
        new model.DBInsert().insert_product(product_name, weight, price);
    }

    public static void insert_Materials_to_product(String product_id, String material_id, String qty) {
        new model.DBInsert().insert_Materials_to_product(product_id, material_id, qty);
    }
    //eacms
     public static void insert_data_to_Order_row_material(String order_id, String material_id, String order_material_total_qty, String order_material_total_price) {
        new model.DBInsert().insert_Details_to_order_row_material(order_id, material_id, order_material_total_qty,order_material_total_price);
    }
     
    public static void update_price_to_Order_row_material(String order_id, String material_id, String order_material_total_qty, String order_material_total_price) {
      new model.DBUpdate().qty_price_update(order_id, material_id, order_material_total_qty,order_material_total_price);
      
    }
}
