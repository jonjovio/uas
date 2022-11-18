/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jonjovio
 */
public class Menu_login implements ActionListener{
    JFrame frameLogin;
    JButton buttonLogin, buttonMainMenu; 
    JTextField username, pass;
    
    public Menu_login(){
        frameLogin = new JFrame();
        frameLogin.getContentPane().setBackground(Color.green);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image;
        JLabel img = new JLabel();
        image = new ImageIcon(getClass().getResource("logo.png"));
        img.setBounds(90, 30, 400, 200);
        img.setHorizontalAlignment(SwingConstants.CENTER);
        img.setIcon(image);
        
        
        JLabel title = new JLabel("SOCIAL GAJELAS");
        title.setBounds(90, 230, 400, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(50, 300, 100, 30);
        labelUsername.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 18));
        username = new JTextField("");
        username.setBounds(200, 300, 250, 30);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(50, 350, 100, 30);
        labelPassword.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 18));
        pass = new JTextField("");
        pass.setBounds(200, 350, 250, 30);
        
        buttonLogin = new JButton("LOG IN");
        buttonLogin.setBounds(100, 450, 150, 50);
        buttonLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        buttonLogin.addActionListener(this);
        
        buttonMainMenu = new JButton("BACK");
        buttonMainMenu.setBounds(325, 450, 150, 50);
        buttonMainMenu.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        buttonMainMenu.addActionListener(this);
        
        frameLogin.add(img);
        frameLogin.add(title);
        frameLogin.add(labelUsername);
        frameLogin.add(username);
        frameLogin.add(labelPassword);
        frameLogin.add(pass);
        frameLogin.add(buttonLogin);
        frameLogin.add(buttonMainMenu);
        frameLogin.setSize(600, 950);
        frameLogin.setLayout(null);
        frameLogin.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonLogin) {
            Controller ctrl = new Controller();
            if (ctrl.checkLogin(username.getText(), pass.getText())) {
                JOptionPane.showMessageDialog(null, "LOGIN berhasil!", "Alert", JOptionPane.WARNING_MESSAGE);
                
            }else{
                JOptionPane.showMessageDialog(null, "LOGIN Gagal!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if (ae.getSource() == buttonMainMenu) {
            frameLogin.dispose();
            new Menu_utama();
        }
    }
    
    public static void main(String[] args) {
        new Menu_login();
    }
    
}
