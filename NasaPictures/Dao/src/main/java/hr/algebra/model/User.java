/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author trisek
 */
public final class User {
    private String username;
    private String password;
    private int userType;
    
    
    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userType = 0;
    }
    
    public User(String username, String password, int userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    
    public String getUsername() {
        return username;
    }
        
    public String getPassword() {
        return password;
    }
            
    public int getUserType() {
        return userType;
    }
    
}
