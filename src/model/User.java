/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pavan Fernando
 */
public class User {
      
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String password;
    
    public User(int id, String name, String email, String phone, String address, String department, String password){
        
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.department = address;
        this.password = password;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getDepartment(){
        return this.department;
    }
    
    public String getPassword(){
        return this.password;
    }
}
