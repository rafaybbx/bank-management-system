package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class takeLoan extends JFrame {
    Account acc;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JPanel p1, p2, p3;
    JTextField t1;
    JButton b1, b2, b3;
    Admin adm;             //For interest rate

    takeLoan(Account account){
        acc = account;
        setSize(800,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("LOAN SECTION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg.png")));


        try {
            adm = AdminFileOperations.getAdmin();
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error while Fetching Admin From File.");
            ex.printStackTrace();
        }


        l1 = new JLabel("Your Current Balance is: ");
        l1.setBounds(30,50,300,50);
        l1.setFont(new Font("Arial",Font.ITALIC,23));
        l1.setForeground(Color.white);

        p1 = new JPanel(null);

        l2 = new JLabel(String.valueOf(acc.getBalance()));
        l2.setBounds(120,115,100,40);
        l2.setFont(new Font("Arial",Font.BOLD,23));
        l2.setForeground(Color.white);

        p1.setLayout(null);
        p1.setVisible(true);
        p1.setBounds(80,110,150,50);
        p1.setBackground(Color.BLACK);
        p1.add(l2);

        l3 = new JLabel(new ImageIcon("smallLogo.jpg"));
        l3.setBounds(550,10,200,150);


        l4 = new JLabel("Your Loan Amount taken is: ");
        l4.setBounds(30,170,300,50);
        l4.setFont(new Font("Arial",Font.ITALIC,23));
        l4.setForeground(Color.white);

        p2 = new JPanel(null);

        l5 = new JLabel(String.valueOf(acc.getLoan()));
        l5.setBounds(125,225,100,40);
        l5.setFont(new Font("Arial",Font.BOLD,23));
        l5.setForeground(Color.white);

        p2.setLayout(null);
        p2.setVisible(true);
        p2.setBounds(80,220,150,50);
        p2.setBackground(Color.BLACK);
        p2.add(l5);

        l6 = new JLabel("Your Loan Amount Payable is: ");
        l6.setBounds(430,170,350,50);
        l6.setFont(new Font("Arial",Font.ITALIC,23));
        l6.setForeground(Color.white);

        p3 = new JPanel(null);

        l7 = new JLabel(String.valueOf(acc.getLonePayable()));
        l7.setBounds(530,225,100,40);
        l7.setFont(new Font("Arial",Font.BOLD,23));
        l7.setForeground(Color.white);

        p3.setLayout(null);
        p3.setVisible(true);
        p3.setBounds(500,220,150,50);
        p3.setBackground(Color.BLACK);
        p3.add(l7);


        l8 = new JLabel("Enter the Amount: ");
        l8.setBounds(30,350,250,50);
        l8.setFont(new Font("Arial",Font.ITALIC,23));
        l8.setForeground(Color.white);

        t1 = new JTextField();
        t1.setBounds(320,350,300,40);
        t1.setFont(new Font("Serif", Font.PLAIN,18));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFocusable(true);

        b1 = new JButton("BACK");
        b1.setBounds(100,450,150,50);
        b1.setFocusable(false);

        b2 = new JButton("TAKE LOAN");
        b2.setBounds(300,450,150,50);
        b2.setFocusable(false);

        b3 = new JButton("PAY LOAN");
        b3.setBounds(500,450,150,50);
        b3.setFocusable(false);


        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(p1);
        this.add(l4);
        this.add(l5);
        this.add(p2);
        this.add(l6);
        this.add(l7);
        this.add(l8);
        this.add(p3);
        this.add(t1);
        this.add(b1);
        this.add(b2);
        this.add(b3);



        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);

        this.invalidate();
        this.validate();
        this.repaint();
    }

    public class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("BACK")) {
                dispose();
                new loginMenu(acc);
            }
            else if (e.getActionCommand().equals("TAKE LOAN")) {
                double amount = 0;
                boolean check;

                if(t1.getText().isEmpty()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter an Amount!");
                }
                else{
                    try{
                        amount = Double.parseDouble(t1.getText());
                        check = true;
                    }
                    catch (Exception ex) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Please Enter a Double-Type amount!");
                        check = false;
                    }
                    if (check){
                        if(amount < 0){
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Please Enter a Positive Amount!");
                        }
                        else if(amount < 10000 && amount > 0){
                            if(acc.getLoan() + amount > 10000){
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "NOT POSSIBLE! \nYou have already taken loan amount of "+acc.getLoan()+" !\nPay the previous loan first.");
                            }
                            else {
                                double lonePayAble = 0.0;
//                                acc.loan = acc.loan + amount;
                                acc.setLoan(acc.getLoan() + amount);
                                lonePayAble = acc.getLonePayable() + (acc.getLoan() + (acc.getLoan() * adm.interestRate/100));
                                acc.setLonePayable(lonePayAble);
                                AccountFileOperations.saveData();
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "You have been successfully granted with a loan amount of "+amount+" !");
                                dispose();
                                new takeLoan(acc);
                            }
                        }
                        else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "NOT POSSIBLE! \nYou can only take loan of maximum 10,000 pkr!");
                        }
                    }
                }
            }

            else if(e.getActionCommand().equals("PAY LOAN")){

                if(t1.getText().isEmpty()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter an Amount!");
                }
                else {
                    boolean check;
                    double amount = 0.0;
                    try{
                        amount = Double.parseDouble(t1.getText());
                        check = true;
                    }
                    catch (Exception ex) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Please Enter a Double-Type amount!");
                        check = false;
                    }
                    if(check){
                        if(amount < 0){
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Please Enter a Positive Amount!");
                        }
                        else if(amount > acc.getLonePayable()){
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "You are in-debt of just Rs. "+acc.getLonePayable()+" !");
                        }
                        else {
                            if(acc.getLonePayable() - amount < 0){
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "You don't have this much loan to pay!");
                            }
                            else if(acc.getLonePayable() - amount == 0){
                                acc.setLonePayable(0.0);
                                acc.setLoan(0.0);
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "Loan Payed Successfully!");
                            }
                            else {
                                acc.setLoan(acc.getLoan() - amount);
                                acc.setLonePayable(acc.getLonePayable() - amount);
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "Loan Payed Successfully!");
                            }
                            AccountFileOperations.saveData();
                            dispose();
                            new takeLoan(acc);
                        }
                    }
                }
            }

        }
    }
}
