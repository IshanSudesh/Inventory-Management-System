package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pavan Fernando
 */
public class DBSearch {

    Statement stmt;
    ResultSet result;

    public ResultSet getOrderID() {

        try {
            String sql = "SELECT * FROM ordersplacing ORDER BY order_id DESC LIMIT 1";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public ResultSet getCustomerDetails() {

        try {
            String sql = "SELECT * FROM customerdetails";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public List<Customer> getLastCustomerID() {

        ArrayList<Customer> customer = new ArrayList<>();

        try {
            String sql = "SELECT * FROM customerdetails ORDER BY customer_id  DESC LIMIT 1";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

            if (result.next()) {
                Customer cus = new Customer(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                customer.add(cus);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return customer;
    }

    public List<Customer> allCustomerDetails() {

        ArrayList<Customer> customer = new ArrayList<>();

        try {
            String sql = "SELECT * FROM customerdetails";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

            while (result.next()) {
                Customer cus = new Customer(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                customer.add(cus);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return customer;
    }

    public ResultSet getProductDetails() {

        try {
            String sql = "SELECT * FROM productdetails";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public ResultSet searchSelectedProductID(Object id) {

        try {
            String sql = "SELECT * FROM productdetails WHERE product_id = '" + id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public ResultSet searchSelectedCustomerID(Object id) {

        try {
            String sql = "SELECT * FROM customerdetails WHERE customer_id = '" + id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    // chandima MRP functions
    public ResultSet getOrderIDs() {

        try {
            String sql = "SELECT order_id FROM ordersplacing";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    //get product ids and quntity fromm order products table
    public ResultSet getProductIds(Object id) {

        try {
            String sql = "SELECT * FROM order_products WHERE order_id = '" + id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    //get material ids
    public ResultSet getMaterialDetails() {

        try {
            String sql = "SELECT * FROM rawmaterial";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    //get customer detalis according to the order id
    public ResultSet get_Customer_Details_From_OrderId(Object id) {

        try {
            String sql = "SELECT ordersplacing.order_id, ordersplacing.order_date, customerdetails.customer_id, customerdetails.cus_name , customerdetails.cus_address, customerdetails.cus_telephone, customerdetails.cus_email  FROM ordersplacing\n"
                    + "INNER JOIN customerdetails ON ordersplacing.customer_id=customerdetails.customer_id WHERE ordersplacing.order_id='" + id + "' ";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }
// just material qty

    public ResultSet get_Material_Details_According_to_OrderId(Object id) {

        try {
            String sql = "SELECT order_products.order_id, rawmaterial.material_id,  rawmaterial.material_name ,rawmaterial.stock_quantity,\n"
                    + "SUM(product_planing.product_material_quantity * order_products.order_product_quantity) AS qty_for_order\n"
                    + "FROM order_products\n"
                    + "INNER JOIN product_planing ON order_products.product_id=product_planing.product_id\n"
                    + "INNER JOIN productdetails ON order_products.product_id=productdetails.product_id\n"
                    + "INNER JOIN rawmaterial ON product_planing.material_id=rawmaterial.material_id\n"
                    + "WHERE order_products.order_id='" + id + "' GROUP BY rawmaterial.material_name ORDER BY rawmaterial.material_id;";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public ResultSet get_All_Material_Details_According_to_OrderId(String id) {

        try {
            String sql = "SELECT order_products.order_id, order_products.product_id, productdetails.product_name, rawmaterial.material_name, product_planing.product_material_quantity ,order_products.order_product_quantity, rawmaterial.price_per_unit ,rawmaterial.stock_quantity,\n"
                    + "product_planing.product_material_quantity * order_products.order_product_quantity AS qty_for_order\n"
                    + "FROM order_products\n"
                    + "INNER JOIN product_planing ON order_products.product_id=product_planing.product_id\n"
                    + "INNER JOIN productdetails ON order_products.product_id=productdetails.product_id\n"
                    + "INNER JOIN rawmaterial ON product_planing.material_id=rawmaterial.material_id\n"
                    + "WHERE order_products.order_id='" + id + "' ORDER BY order_products.product_id;";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }
    
        public ResultSet get_Material_and_price_Details_According_to_OrderId(Object id) {

        try {
            String sql = "SELECT order_products.order_id, rawmaterial.material_id,  rawmaterial.material_name ,rawmaterial.stock_quantity, rawmaterial.price_per_unit,\n"
                    + "SUM(product_planing.product_material_quantity * order_products.order_product_quantity) AS qty_for_order, SUM(product_planing.product_material_quantity * order_products.order_product_quantity) * rawmaterial.price_per_unit AS bill_for_order\n"
//                  "SUM(product_planing.product_material_quantity * order_products.order_product_quantity) * rawmaterial.price_per_unit AS bill_for_order\n"
                    + "FROM order_products\n"
                    + "INNER JOIN product_planing ON order_products.product_id=product_planing.product_id\n"
                    + "INNER JOIN rawmaterial ON product_planing.material_id=rawmaterial.material_id\n"
                    + "WHERE order_products.order_id='" + id + "' GROUP BY rawmaterial.material_name ORDER BY rawmaterial.material_id;";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    // product details
    public ResultSet get_material_details_from_product_id(Object product_id) {
        try {
            String sql = "SELECT product_planing.product_id,product_planing.material_id, rawmaterial.material_name, product_planing.product_material_quantity \n"
                    + "FROM product_planing\n"
                    + "INNER JOIN rawmaterial ON product_planing.material_id =rawmaterial.material_id\n"
                    + "WHERE product_planing.product_id='" + product_id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    public ResultSet get_maaterial_name_from_id(Object id) {

        try {
            String sql = "SELECT * FROM rawmaterial WHERE rawmaterial.material_id='" + id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    //Add New User => Pavan Fernando
    public List<User> getLastUserID() {

        ArrayList<User> userArrayList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM userdetails ORDER BY user_id   DESC LIMIT 1";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

            if (result.next()) {
                User user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
                userArrayList.add(user);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return userArrayList;
    }

    //werehouse done by Pavan Fernando
    //to get all materials from one order
    public ResultSet get_Material_id_And_Material_Name(String order_id) {
        try {
            String sql = "SELECT ord.material_id, ord.order_material_total_qty, rwl.material_name, check_material_issue "
                    + "FROM order_rawmaterial ord INNER JOIN rawmaterial rwl ON ord.material_id = rwl.material_id "
                    + "WHERE ord.order_id = '" + order_id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    //check material stocks
    public ResultSet check_Availability_Material_Stock(String material_id) {
        try {

            String sql = "SELECT material_id, material_name, stock_quantity FROM rawmaterial WHERE material_id = '" + material_id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }
    
    //check materials are issued or not
    public ResultSet check_Material_Issued_Or_Not(String material_id) {
        try {

            String sql = "SELECT material_id, material_name, stock_quantity FROM rawmaterial WHERE material_id = '" + material_id + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }

    //Eacms
    public ResultSet get_soled_items_for_month(Object product_id, String start_date, String end_date) {
        try { //ordersplacing.order_id ,productdetails.product_name ,

            String sql = "SELECT SUM(order_products.order_product_quantity) FROM order_products\n"
                    + "INNER JOIN ordersplacing ON order_products.order_id = ordersplacing.order_id\n"
                    + "INNER JOIN productdetails ON order_products.product_id= productdetails.product_id\n"
                    + "WHERE order_products.product_id='" + product_id + "' AND\n"
                    + "ordersplacing.order_date BETWEEN '" + start_date + "' AND '" + end_date + "'";
            stmt = DBConnection.getStatementConnection();

            result = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return result;
    }
    
    //Login part Parami 
    public ResultSet searchLogin(String u_name) {

        try {
            String sql = "SELECT * FROM userdetails WHERE u_name='" + u_name + "'";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);
            
            } catch (Exception e) {
                System.out.println(e.toString());
             }
         return result;
    }
    
    //Admin 
    
    public ResultSet getUserDetails() {

        try {
            String sql = "SELECT * FROM userdetails";
            stmt = DBConnection.getStatementConnection();
            result = stmt.executeQuery(sql);
            
            } catch (Exception e) {
                System.out.println(e.toString());
            }
         return result;
    } 
}
