/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonjovio
 */
public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private String userGender;
    private int userFollowers;
    private String password;
    private CategoryUser userCategory = new CategoryUser();

    
    public User() {
    }
    
    public User(int userId, String userName, String userEmail, String userGender, int userFollowers, CategoryUser userCategory) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userFollowers = userFollowers;
        this.userCategory = userCategory;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(int userFollowers) {
        this.userFollowers = userFollowers;
    }

    public CategoryUser getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(CategoryUser userCategory) {
        this.userCategory = userCategory;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
