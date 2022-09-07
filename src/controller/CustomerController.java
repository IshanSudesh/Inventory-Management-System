/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Customer;
import model.DBDelete;
import model.DBInsert;
import model.DBSearch;
import model.DBUpdate;

/**
 *
 * @author Pavan Fernando
 */
public class CustomerController {
    
    public int lastCustomerIdFinder(){
        
       List<Customer> customer = new DBSearch().getLastCustomerID();
        int id = customer.get(0).getId();
        return id;
  
    }
    public boolean addNewCustomer(String name, String address, String phone, String email){
        
        boolean isSuccess = new DBInsert().addNewCustomerDetails(name, address, phone, email);
        return isSuccess;
        
    }
    
    public List<Customer> allCustomerDetails(){
        
        List<Customer> customer = new DBSearch().allCustomerDetails();
        return customer;
    }
    
    public boolean updateACustomer(int customerId, String name, String address, String phone, String email){
        
        boolean isSuccess = new DBUpdate().add_New_Customer_Details(customerId, name, address, phone, email);
        return isSuccess;
    }
    
    public boolean deleteACustomer(int customerId){
        
        boolean isSuccess = new DBDelete().deleteACustomer(customerId);
        return isSuccess;
    }
}
