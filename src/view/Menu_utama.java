/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jonjovio
 */
public class Menu_utama implements ActionListener{
    JFrame frameUtama;
    JButton butLogin, butRegis, lihatData;    
    
    public Menu_utama(){
        frameUtama = new JFrame();
        frameUtama.getContentPane().setBackground(Color.green);
        frameUtama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                
        butLogin = new JButton("LOGIN");
        butLogin.setBounds(100, 50, 390, 50);
        butLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        butLogin.addActionListener(this);
        
        butRegis = new JButton("REGISTER");
        butRegis.setBounds(100, 120, 390, 50);
        butRegis.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        butRegis.addActionListener(this);
        
        lihatData = new JButton("LIHAT DATA PENGGUNA");
        lihatData.setBounds(100, 190, 390, 50);
        lihatData.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        lihatData.addActionListener(this);
        
        
        frameUtama.add(butLogin);
        frameUtama.add(butRegis);
        frameUtama.add(lihatData);
        frameUtama.setSize(600, 950);
        frameUtama.setLayout(null);
        frameUtama.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butLogin) {
            frameUtama.dispose();
            new Menu_login();
        }
        
        if (ae.getSource() == butRegis) {
            frameUtama.dispose();
            new Menu_login();
        }
        
        if (ae.getSource() == lihatData) {
            frameUtama.dispose();
            new Menu_login();
        }
    }
    
    public static void main(String[] args) {
        new Menu_utama();
    }
    
}
