/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.CategoryUser;
import model.User;

/**
 *
 * @author jonjovio
 */
public class Controller {
    
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<String> getCategoryUser(){
        conn.connect();
        String query = "SELECT * FROM categoryuser";
        ArrayList<String> category = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                category.add(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    
    public boolean insertNewUser(User user) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getUserEmail());
            stmt.setString(4, user.getUserGender());
            stmt.setInt(5, user.getUserFollowers());
            stmt.setInt(6, user.getUserCategory().getCategoryId());
            stmt.setString(7, user.getPassword());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public boolean checkLogin(String username, String password){
        conn.connect();
        String query = "SELECT * FROM user WHERE userName='" + username + "'&& password='" + password + "'";
        User user =  User.getUserInst();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserEmail(rs.getString("userEmail"));
                user.setPassword(rs.getString("password"));
                user.setUserGender(rs.getString("userGender"));
                user.getUserCategory().setCategoryId(rs.getInt("userCategory"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (user.getUserName() == null) {
            return false;
        }
        return true;
    }
    
    
}
