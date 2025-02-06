package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class mainMenu extends JFrame {
    JButton b1, b2;
    JLabel l1, l2, l3, l4;
    JPanel p0, p1;

    mainMenu(){
        setSize(800,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("BANK MANAGEMENT SYSTEM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        p0 = new JPanel(null);

        l1 = new JLabel("WELCOME TO SEALED SAFE BANK");
        l1.setBounds(100,20,700,50);
        l1.setFont(new Font("Serif", Font.BOLD ,35));
        l1.setForeground(Color.white);

        p0.setVisible(true);
        p0.setLayout(null);
        p0.setBounds(80,20,660,55);
        p0.setBackground(Color.BLACK);
        p0.add(l1);

        p1 = new JPanel(null);


        l2 = new JLabel("How would you like to continue?");
        l2.setSize(590,40);
        l2.setBounds(200,300,590,40);
        l2.setFont(new Font("Arial",Font.ITALIC,25));
        l2.setForeground(Color.white);

        p1.setLayout(null);
        p1.setVisible(true);
        p1.setBounds(100,300,570,50);
        p1.setBackground(Color.BLACK);
        p1.add(l2);

        l3 = new JLabel(new ImageIcon("logo.png"));
        l3.setBounds(250,90,250,200);

        setContentPane(new JLabel(new ImageIcon("bgg.png")));


        b1 = new JButton("ACCOUNT HOLDER");
        b1.setBounds(150,400, 150, 70);
        b1.setFocusable(false);

        b2 = new JButton("ADMIN");
        b2.setBounds(450,400, 150, 70);
        b2.setFocusable(false);


        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(b1);
        this.add(b2);
        this.add(p0);
        this.add(p1);
//        this.pack();


        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);

        this.invalidate();
        this.validate();
        this.repaint();
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("ACCOUNT HOLDER")) {
                dispose();
                new userMenu();
            }
            else if (e.getActionCommand().equals("ADMIN")) {
                dispose();
                new adminLogIn();
            }
        }
    }


}















//import javax.swing.*;
//import java.awt.*;
//
//public class mainMenu extends JFrame {
//    JButton b1, b2;
//    JLabel l1, l2, l3;
//    JPanel p1;
//
//    mainMenu(){
//        setSize(800,600);
//        getContentPane().setBackground(Color.CYAN);
//        setTitle("Bank Management System");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//        setResizable(false);
//        setLayout(null);
//
//        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
//        setIconImage(icon);
//
//        l1 = new JLabel("WELCOME TO ALLIED BANK LIMITED (ABL)");
//        l1.setBounds(50,20,700,50);
//        l1.setFont(new Font("Arial",Font.ITALIC,30));
//        l1.setBackground(Color.BLACK);
//
//        p1 = new JPanel(null);
//
//        l2 = new JLabel("How would you like to continue?");
//        l2.setSize(590,40);
//        l2.setBounds(80,300,590,40);
//        l2.setFont(new Font("Arial",Font.ITALIC,25));
//        l2.setBackground(Color.white);
//
//        l3 = new JLabel();
//        l3.setIcon(new ImageIcon("\"C:\\Users\\minko\\OneDrive - Higher Education Commission\\Desktop\\Bank_Management_System\\logo.png\""));
//        l3.setBounds(150,150,260, 200);
//
//        p1.setLayout(null);
//        p1.setVisible(true);
//        p1.setBackground(Color.WHITE);
//        p1.setBounds(70,300,600,50);
//        p1.add(l2);
//
//
//        b1 = new JButton("ACCOUNT HOLDER");
//        b1.setBounds(150,400, 150, 70);
//        b1.setFocusable(false);
//
//        b2 = new JButton("ADMIN");
//        b2.setBounds(450,400, 150, 70);
//        b2.setFocusable(false);
//
//        this.add(l1);
//        this.add(l2);
//        this.add(l3);
//        this.add(b1);
//        this.add(b2);
//        this.add(p1);
//
//        this.invalidate();
//        this.validate();
//        this.repaint();
//    }
//}