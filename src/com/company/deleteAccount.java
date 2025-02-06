package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class deleteAccount extends JFrame {
    JLabel l1,  l2, l3,  l4;
    JTextField t1, t2;
    JButton b1, b2;

    deleteAccount(){
        setSize(700,700);
        getContentPane().setBackground(Color.CYAN);
        setTitle("ACCOUNT DELETION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg-700.png")));

        l1 = new JLabel("ENTER FOLLOWING INFORMATION FOR DELETION PURPOSE");
        l1.setBounds(30,200,700,50);
        l1.setFont(new Font("Arial",Font.BOLD + Font.ITALIC,20));
        l1.setForeground(Color.white);

        l2 = new JLabel(new ImageIcon("smallLogo.jpg"));
        l2.setBounds(470,10,200,150);


        l3 = new JLabel("ACCOUNT NUM:");
        l3.setBounds(30,300,200,50);
        l3.setFont(new Font("Arial",Font.BOLD,25));
        l3.setForeground(Color.white);

        l4 = new JLabel("PASSWORD:");
        l4.setBounds(30,370,200,50);
        l4.setFont(new Font("Arial",Font.BOLD,25));
        l4.setForeground(Color.white);


        t1 = new JTextField();
        t1.setBounds(250,300,300,40);
        t1.setFont(new Font("Serif", Font.PLAIN,18));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFocusable(true);

        t2 = new JTextField();
        t2.setBounds(250,370,300,40);
        t2.setFont(new Font("Serif", Font.PLAIN,18));
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFocusable(true);


        b1 = new JButton("BACK");
        b1.setBounds(150,450,100,50);
        b1.setFocusable(false);

        b2 = new JButton("DELETE");
        b2.setBounds(400,450,100,50);
        b2.setFocusable(false);


        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);


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
                new userMenu();
            }
            else if (e.getActionCommand().equals("DELETE")) {

                if(t1.getText().isBlank() || t2.getText().isBlank()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Enter the Required Fields !!");
                }
                else{
                    String accNum = t1.getText();
                    String password = t2.getText();
                    Account acc = AccountFileOperations.searchAnAccount(accNum);

                    if(acc == null){
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f,"No Account exists with the given information!");
                    }
                    else if((acc.getAccountNum().equals(accNum)) && !(acc.getPassWord().equals(password))){
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Wrong Password !");
                    }
                    else{
                        String an = acc.getAccountNum();
                        try {
                            AccountFileOperations.deleteRecord(an,password);
                        } catch (IOException ex) {
                            System.out.println("Error while deleting the account.");
                            ex.printStackTrace();
                        }
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Account " + an + " Deleted Successfully.");
                        AccountFileOperations.saveData();
                        dispose();
                        new userMenu();
                    }

                }
            }

        }
    }
}
