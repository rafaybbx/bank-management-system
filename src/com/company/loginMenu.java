package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginMenu extends JFrame {
    Account acc;
    JLabel l0, l1,  l2, l3, l4, l5;
    JTextField t1, t2;
    JButton b1, b2, b3, b4, b5, b6;
    JPanel p0, p1;

    loginMenu(Account account){
        acc = account;
        setSize(800,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("LOGIN MENU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg.png")));

        p0 = new JPanel(null);
        p1 = new JPanel(null);

        l0 = new JLabel("WELCOME MR. "+acc.getName().toUpperCase()+" !");
        l0.setSize(590,40);
        l0.setBounds(110,50,400,40);
        l0.setFont(new Font("Arial",Font.ITALIC,23));
        l0.setForeground(Color.white);

        p0.setLayout(null);
        p0.setVisible(true);
        p0.setBounds(100,50,420,50);
        p0.setBackground(Color.BLACK);
        p0.add(l0);


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


        b1 = new JButton("DEPOSIT");
        b1.setBounds(150,300,150,50);
        b1.setFocusable(false);

        b2 = new JButton("WITHDRAW");
        b2.setBounds(450,300,150,50);
        b2.setFocusable(false);

        b3 = new JButton("TRANSFER");
        b3.setBounds(150,370,150,50);
        b3.setFocusable(false);

        b4 = new JButton("BAL INQUIRY");
        b4.setBounds(450,370,150,50);
        b4.setFocusable(false);

        b5 = new JButton("LOAN");
        b5.setBounds(150,440,150,50);
        b5.setFocusable(false);

        b6 = new JButton("LOG OUT");
        b6.setBounds(450,440,150,50);
        b6.setFocusable(false);


        this.add(l0);
        this.add(l1);
        this.add(l2);
        this.add(p0);
        this.add(p1);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);


        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);

        this.invalidate();
        this.validate();
        this.repaint();
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("DEPOSIT")) {
                dispose();
                new depositMoney(acc);
            }
            else if (e.getActionCommand().equals("WITHDRAW")) {
                dispose();
                new withDraw(acc);
            }
            else if (e.getActionCommand().equals("TRANSFER")) {
                dispose();
                new transferMoney(acc);
            }
            else if (e.getActionCommand().equals("BAL INQUIRY")) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,"Account Number: " + acc.getAccountNum()+
                                                         "\nAccount Holder Name: " + acc.getName().toUpperCase() +
                                                         "\nCurrent Balance: " + acc.getBalance() +
                                                         "\nPayable Loan: " + acc.getLonePayable());
            }
            else if (e.getActionCommand().equals("LOAN")) {
                dispose();
                new takeLoan(acc);
            }
            else if (e.getActionCommand().equals("LOG OUT")) {
                dispose();
                new userMenu();
            }

        }
    }
}
