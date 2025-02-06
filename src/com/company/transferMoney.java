package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transferMoney extends JFrame {
    Account acc;
    JLabel l1, l2, l3, l4, l5;
    JPanel p1;
    JTextField t1, t2;
    JButton b1, b2;

    transferMoney(Account account){
        acc = account;
        setSize(800,600);
        getContentPane().setBackground(Color.CYAN);
        setTitle("MONEY TRANSFER SECTION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg.png")));

        p1 = new JPanel(null);

        l1 = new JLabel("Your Current Balance is: ");
        l1.setBounds(30,50,300,50);
        l1.setFont(new Font("Arial",Font.ITALIC,23));
        l1.setForeground(Color.white);

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

        l4 = new JLabel("Enter the Account Num: ");
        l4.setBounds(30,200,280,50);
        l4.setFont(new Font("Arial",Font.ITALIC,23));
        l4.setForeground(Color.white);

        l5 = new JLabel("Enter the Amount: ");
        l5.setBounds(30,300,250,50);
        l5.setFont(new Font("Arial",Font.ITALIC,23));
        l5.setForeground(Color.white);

        t1 = new JTextField();
        t1.setBounds(320,200,300,40);
        t1.setFont(new Font("Serif", Font.PLAIN,18));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFocusable(true);

        t2 = new JTextField();
        t2.setBounds(320,300,300,40);
        t2.setFont(new Font("Serif", Font.PLAIN,18));
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFocusable(true);


        b1 = new JButton("BACK");
        b1.setBounds(150,400,150,50);
        b1.setFocusable(false);

        b2 = new JButton("TRANSFER");
        b2.setBounds(450,400,150,50);
        b2.setFocusable(false);



        this.add(l1);
        this.add(l2);
        this.add(p1);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(t1);
        this.add(t2);
        this.add(b1);
        this.add(b2);



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
            if (e.getActionCommand().equals("BACK")) {
                dispose();
                new loginMenu(acc);
            }
            else if (e.getActionCommand().equals("TRANSFER")) {
                int accNum = 0;
                double amount = 0;
                boolean check1, check2;
                Account account;

                if(t1.getText().isEmpty() && t2.getText().isEmpty()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please fill the Required Fields!");
                }
                else if(t1.getText().isEmpty()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter the Account Number!");
                }
                else if(t2.getText().isEmpty()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Please Enter the Amount !");
                }
                else{
                    try{
                        accNum = Integer.parseInt(t1.getText());
                        check1 = true;
                    }
                    catch (Exception ex) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Please Enter a Valid Account Number! \ne.g 15345");
                        check1 = false;
                    }

                    if(check1){
                        try{
                            amount = Double.parseDouble(t2.getText());
                            check2 = true;
                        }
                        catch (Exception ex) {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Please Enter a Double-Type amount!");
                            check2 = false;
                        }

                        if (check2){
                            account = AccountFileOperations.searchAnAccount(String.valueOf(accNum));
                            //If the Account exists on this account num
                            if(account != null){
                                if(acc.getBalance() > amount){
                                    acc.setBalance(acc.getBalance() - amount);
                                    //Add amount to the other account
                                    account.setBalance(account.getBalance() + amount);
                                    //Update the File
                                    AccountFileOperations.saveData();
                                    JFrame f = new JFrame();
                                    JOptionPane.showMessageDialog(f, "Amount has been transferred successfully !");
                                    dispose();
                                    new transferMoney(acc);
                                }
                                else {
                                    JFrame f = new JFrame();
                                    JOptionPane.showMessageDialog(f, "Your Balance is insufficient !");
                                }
                            }
                            else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "No Account Found on this Account Number !");
                            }
                        }
                    }
                }
            }
        }
    }
}
