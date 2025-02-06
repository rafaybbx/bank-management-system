package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class giveChequeBook extends JFrame {
    JLabel l1,  l2, l3,  l4;
    JTextField t1, t2;
    JButton b1, b2;
    Admin adm;

    giveChequeBook(Admin admin){
        adm = admin;
        setSize(700,700);
        getContentPane().setBackground(Color.CYAN);
        setTitle("CHEQUEBOOK PROVISION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg-700.png")));



        l1 = new JLabel("ENTER FOLLOWING INFORMATION FOR CASHBOOK PROVISION");
        l1.setBounds(30,200,700,50);
        l1.setFont(new Font("Arial",Font.BOLD + Font.ITALIC,20));
        l1.setForeground(Color.white);

        l2 = new JLabel(new ImageIcon("smallLogo.jpg"));
        l2.setBounds(470,10,200,150);


        l3 = new JLabel("ACCOUNT NUM:");
        l3.setBounds(30,300,200,50);
        l3.setFont(new Font("Arial",Font.BOLD,25));
        l3.setForeground(Color.white);



        t1 = new JTextField();
        t1.setBounds(250,300,300,40);
        t1.setFont(new Font("Serif", Font.PLAIN,18));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFocusable(true);



        b1 = new JButton("BACK");
        b1.setBounds(150,380,100,50);
        b1.setFocusable(false);

        b2 = new JButton("ALLOCATE");
        b2.setBounds(400,380,100,50);
        b2.setFocusable(false);


        this.add(l1);
        this.add(l2);
        this.add(l3);


        this.add(t1);

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
                new adminMenu(adm);
            }
            else if (e.getActionCommand().equals("ALLOCATE")) {

                if(t1.getText().isBlank()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Enter the Required Field !!");
                }
                else{
                    int accNum = 0;
                    boolean check;
                    try{
                        accNum = Integer.parseInt(t1.getText());
                        check = true;
                    }
                    catch (Exception ex) {
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f,"Please Enter a Valid Account Number! \ne.g 13232");
                        check = false;
                    }

                    if(check){
                        Account acc = AccountFileOperations.searchAnAccount(Integer.toString(accNum));
                        if(acc != null){
                            acc.setHasCheckBook(false);

                            if(acc == null){
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f,"No Account exists with the given information!");
                            }
                            else{
                                if(acc.getHasCheckBook()){
                                    JFrame f = new JFrame();
                                    JOptionPane.showMessageDialog(f, "This Account user has already been allotted with ChequeBook !");
                                }
                                else {
                                    acc.setHasCheckBook(true);
                                    AccountFileOperations.saveData();
                                    AdminFileOperations.saveData();
                                    JFrame f = new JFrame();
                                    JOptionPane.showMessageDialog(f, "ChequeBook Provided Successfully!");
                                    JOptionPane.showMessageDialog(f, acc.toString());
                                    dispose();
                                    new adminMenu(adm);
                                }
                            }
                        }
                        else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "This Account does not exist in the Bank!");
                        }
                    }
                }
            }
        }
    }
}
