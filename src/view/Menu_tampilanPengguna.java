/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author jonjovio
 */
public class Menu_tampilanPengguna implements ActionListener{

    JFrame frameLogin;
    JButton buttonLogin, buttonMainMenu; 
    
    public Menu_tampilanPengguna(){
        frameLogin = new JFrame();
        frameLogin.getContentPane().setBackground(Color.green);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image;
        JLabel img = new JLabel();
        image = new ImageIcon(getClass().getResource("logo.png"));
        img.setBounds(90, 30, 400, 200);
        img.setHorizontalAlignment(SwingConstants.CENTER);
        img.setIcon(image);
        
        
        JLabel title = new JLabel("BERHASIL LOGIN");
        title.setBounds(90, 230, 400, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        buttonMainMenu = new JButton("BACK");
        buttonMainMenu.setBounds(325, 450, 150, 50);
        buttonMainMenu.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        buttonMainMenu.addActionListener(this);
        
        frameLogin.add(img);
        frameLogin.add(title);
        frameLogin.add(buttonMainMenu);
        frameLogin.setSize(600, 950);
        frameLogin.setLayout(null);
        frameLogin.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonMainMenu) {
            frameLogin.dispose();
            new Menu_utama();
        }
    }
    
    
    
}
