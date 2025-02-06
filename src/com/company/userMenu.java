package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userMenu extends JFrame {
    JLabel l1, l2;
    JPanel p1;
    JButton b1, b2, b3, b4, b5;


    userMenu(){
        setSize(800,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("USER MENU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg.png")));

        p1 = new JPanel(null);

        l1 = new JLabel("How would you like to proceed?");
        l1.setSize(590,40);
        l1.setBounds(200,200,550,40);
        l1.setFont(new Font("Arial",Font.ITALIC,25));
        l1.setForeground(Color.white);

        p1.setLayout(null);
        p1.setVisible(true);
        p1.setBounds(100,200,570,50);
        p1.setBackground(Color.BLACK);
        p1.add(l1);

        l2 = new JLabel(new ImageIcon("smallLogo.jpg"));
        l2.setBounds(550,10,200,150);


        b1 = new JButton("LOGIN");
        b1.setBounds(150,300,150,50);
        b1.setFocusable(false);

        b2 = new JButton("CREATE ACCOUNT");
        b2.setBounds(450,300,150,50);
        b2.setFocusable(false);

        b3 = new JButton("ACTIVATE ACC");
        b3.setBounds(150,400,150,50);
        b3.setFocusable(false);

        b4 = new JButton("DELETE ACCOUNT");
        b4.setBounds(450,400,150,50);
        b4.setFocusable(false);

        b5 = new JButton("HOME");
        b5.setBounds(300,480,150,50);
        b5.setFocusable(false);


        this.add(l1);
        this.add(l2);
        this.add(p1);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);


        this.invalidate();
        this.validate();
        this.repaint();
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("HOME")) {
                dispose();
                new mainMenu();
            }
            else if (e.getActionCommand().equals("LOGIN")) {
                dispose();
                new loginPage();
            }
            else if (e.getActionCommand().equals("CREATE ACCOUNT")){
                dispose();
                new createAccount();
            }
            else if(e.getActionCommand().equals("ACTIVATE ACC")){
                dispose();
                new activateAccount();
            }
            else if(e.getActionCommand().equals("DELETE ACCOUNT")){
                dispose();
                new deleteAccount();
            }
        }
    }
}
