/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DBUpdate;

/**
 *
 * @author Pavan Fernando
 */
public class WarehouseController {
    
    public boolean changing_Material_Stock(String material_id, double qty) {
        
        boolean isSuccess = new DBUpdate().changing_Material_Stock(material_id, qty);
        return isSuccess;
    }
    
    public void changing_Order_material_issue(String order_id, String material_id){
        
        new DBUpdate().update_check_material_issue(order_id, material_id);
    }
}
