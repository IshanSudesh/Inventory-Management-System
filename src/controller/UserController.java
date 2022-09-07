/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.User;

/**
 *
 * @author Pavan Fernando
 */
public class UserController {
    
    public int lastUserIdFinder(){
        
        List<User> userList = new model.DBSearch().getLastUserID();
        return userList.get(0).getId();
    }
    
    public boolean  addNewUser(String name, String email, String phone, String address, String department, String password){
        
        return new model.DBInsert().addNewUserDetails(name, email, phone, address, department, password);
    }
}
