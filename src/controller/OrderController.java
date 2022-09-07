
package controller;

import java.sql.Statement;

/**
 *
 * @author Pavan Fernando
 */
public class OrderController {
    Statement stmt;
    
    public static boolean insertOrderDetails(String date, String customer_id){
        
        boolean isSuccess = new model.DBInsert().insertOrderDetails(date, customer_id);
        return isSuccess;
    }
    
    public static boolean insertOrder_productDetails(String order_id, String product_id, String qty){
        
        boolean isSuccess = new model.DBInsert().insertOrder_productDetails(order_id, product_id, qty);
        return isSuccess;
    }
}
