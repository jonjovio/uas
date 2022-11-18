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
import java.util.ArrayList;
import javax.swing.*;
import model.CategoryUser;
import model.User;

/**
 *
 * @author jonjovio
 */
public class Menu_register implements ActionListener{
    JFrame frameRegister;
    JButton buttonRegister, buttonMainMenu;
    JTextField email, username, password;
    JRadioButton jk1, jk2;
    JComboBox kategori;
    ButtonGroup jk;
    
    Controller ctrl = new Controller();
    
    public Menu_register(){
        frameRegister = new JFrame();
        frameRegister.getContentPane().setBackground(Color.green);
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("REGISTER SOCIAL GAJELAS");
        title.setBounds(90, 50, 400, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 100, 100, 30);
        labelEmail.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 18));
        email = new JTextField("");
        email.setBounds(200, 100, 250, 30);
        
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(50, 150, 100, 30);
        labelUsername.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 18));
        username = new JTextField("");
        username.setBounds(200, 150, 250, 30);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(50, 200, 100, 30);
        labelPassword.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 18));
        password = new JTextField("");
        password.setBounds(200, 200, 250, 30);
        
        JLabel labelJK = new JLabel("Jenis Kelamin:");
        labelJK.setBounds(50, 250, 100, 30);
        jk1 = new JRadioButton("Male");
        jk2 = new JRadioButton("Female");
        jk1.setBounds(200, 250, 100, 30);
        jk2.setBounds(300, 250, 100, 30);
        jk = new ButtonGroup();
        jk.add(jk1);jk.add(jk2);
        
        JLabel labelKategori = new JLabel("Agama:");
        labelKategori.setBounds(50, 300, 100, 30);
//        String kat[] = {"Private Account", "Creator Account", "Business Account"};
        ArrayList<String> kat = ctrl.getCategory();
        kategori = new JComboBox(new DefaultComboBoxModel<String>(kat.toArray(new String[0])));
        kategori.setBounds(200, 300, 250, 30);
        
        
        buttonRegister = new JButton("LOG IN");
        buttonRegister.setBounds(100, 450, 150, 50);
        buttonRegister.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        buttonRegister.addActionListener(this);
        
        buttonMainMenu = new JButton("BACK");
        buttonMainMenu.setBounds(325, 450, 150, 50);
        buttonMainMenu.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        buttonMainMenu.addActionListener(this);
        
        frameRegister.add(title);
        frameRegister.add(labelEmail);
        frameRegister.add(email);
        frameRegister.add(labelUsername);
        frameRegister.add(username);
        frameRegister.add(labelPassword);
        frameRegister.add(password);
        frameRegister.add(labelJK);
        frameRegister.add(jk1);
        frameRegister.add(jk2);
        frameRegister.add(labelKategori);
        frameRegister.add(kategori);
        frameRegister.add(buttonRegister);
        frameRegister.add(buttonMainMenu);
        frameRegister.setSize(600, 950);
        frameRegister.setLayout(null);
        frameRegister.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonRegister) {
            String jenisKelamin = "";
            if (jk1.isSelected()) {
                jenisKelamin = jk1.getText();
            }else if (jk2.isSelected()) {
                jenisKelamin = jk2.getText();
            }
            
            if (email.getText().equals("") || username.getText().equals("") || password.getText().equals("") || jenisKelamin.equals("")) {
                JOptionPane.showMessageDialog(null, "ISI SEMUA DATA!", "Alert", JOptionPane.WARNING_MESSAGE);
            }else{
                User user = new User();
                user.setUserName(username.getText());
                user.setUserEmail(email.getText());
                user.setPassword(password.getText());
                user.setUserGender(jenisKelamin);
                user.getUserCategory().setCategoryName((String) kategori.getSelectedItem());
                int katId;
                if (kategori.getSelectedItem().equals("Private Account")) {
                    katId = 1;
                }else if (kategori.getSelectedItem().equals("Creator Account")) {
                    katId = 2;
                }else{
                    katId = 3;
                }
                user.getUserCategory().setCategoryId(katId);
                
                
                if (ctrl.insertNewUser(user)) {
                    JOptionPane.showMessageDialog(null, "Register berhasil!", "Alert", JOptionPane.WARNING_MESSAGE);
                    frameRegister.dispose();
                    new Menu_utama();
                }

            }
        }
        
        if (ae.getSource() == buttonMainMenu) {
            frameRegister.dispose();
            new Menu_utama();
        }
    }
    
    public static void main(String[] args) {
        new Menu_register();
    }
}
