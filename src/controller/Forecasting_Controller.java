/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.MRPController.product_id;
import static controller.MRPController.product_qty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBSearch;

/**
 *
 * @author EACMS
 */
public class Forecasting_Controller {

    public static double get_soled_items_for_month(Object product_id, String start_date, String end_date) {

        double sales = 0;
        try {
            ResultSet result = new DBSearch().get_soled_items_for_month(product_id, start_date, end_date);
            while (result.next()) {
                sales = result.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MRPController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }
}
