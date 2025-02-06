package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAccount extends JFrame {
    JLabel l1,  l2, l3,  l4, l5, l6, l7, format1, format2;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    JRadioButton r1, r2;
    ButtonGroup combo;

    String gender;

    createAccount(){
        setSize(700,700);
        getContentPane().setBackground(Color.CYAN);
        setTitle("ACCOUNT CREATION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("logo.png");
        setIconImage(icon);

        setContentPane(new JLabel(new ImageIcon("bgg-700.png")));

        l1 = new JLabel("ENTER FOLLOWING INFORMATION CORRECTLY");
        l1.setBounds(70,20,700,50);
        l1.setFont(new Font("Arial",Font.BOLD + Font.ITALIC,25));
        l1.setForeground(Color.white);

        l2 = new JLabel("Name:");
        l2.setBounds(30,90,100,50);
        l2.setFont(new Font("Arial",Font.BOLD,25));
        l2.setForeground(Color.white);

        l3 = new JLabel("CNIC:");
        l3.setBounds(30,150,100,50);
        l3.setFont(new Font("Arial",Font.BOLD,25));
        l3.setForeground(Color.white);

        format1 = new JLabel("Format: XXXXX-XXXXXXX-X");
        format1.setBounds(250,140,250,20);
        format1.setFont(new Font("Arial",Font.PLAIN,15));
        format1.setForeground(Color.white);

        l4 = new JLabel("Password:");
        l4.setBounds(30,220,150,50);
        l4.setFont(new Font("Arial",Font.BOLD,25));
        l4.setForeground(Color.white);

        l5 = new JLabel("Phone Num:");
        l5.setBounds(30,290,150,50);
        l5.setFont(new Font("Arial",Font.BOLD,25));
        l5.setForeground(Color.white);

        format2 = new JLabel("Format: XXXX-XXXXXXX");
        format2.setBounds(250,280,250,20);
        format2.setFont(new Font("Arial",Font.PLAIN,15));
        format2.setForeground(Color.white);

        l6 = new JLabel("Initial Bal:");
        l6.setBounds(30,360,150,50);
        l6.setFont(new Font("Arial",Font.BOLD,25));
        l6.setForeground(Color.white);

        l7 = new JLabel("Gender:");
        l7.setBounds(30,430,150,50);
        l7.setFont(new Font("Arial",Font.BOLD,25));
        l7.setForeground(Color.white);


        t1 = new JTextField();
        t1.setBounds(200,90,300,40);
        t1.setFont(new Font("Serif", Font.PLAIN,18));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFocusable(true);

        t2 = new JTextField();
        t2.setBounds(200,160,300,40);
        t2.setFont(new Font("Serif", Font.PLAIN,18));
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setFocusable(true);

        t3 = new JTextField();
        t3.setBounds(200,230,300,40);
        t3.setFont(new Font("Serif", Font.PLAIN,18));
        t3.setHorizontalAlignment(JTextField.CENTER);
        t3.setFocusable(true);

        t4 = new JTextField();
        t4.setBounds(200,300,300,40);
        t4.setFont(new Font("Serif", Font.PLAIN,18));
        t4.setHorizontalAlignment(JTextField.CENTER);
        t4.setFocusable(true);

        t5 = new JTextField();
        t5.setBounds(200,370,300,40);
        t5.setFont(new Font("Serif", Font.PLAIN,18));
        t5.setHorizontalAlignment(JTextField.CENTER);
        t5.setFocusable(true);

        r1 = new JRadioButton("MALE");
        r1.setFont(new Font("Arial", Font.BOLD, 15));
        r1.setBounds(200,430,100,50);
        r1.setBackground(Color.getHSBColor(0.7f, 0.1f, 0.8f));
        r1.setVisible(true);

        r2 = new JRadioButton("FEMALE");
        r2.setFont(new Font("Arial", Font.BOLD, 15));
        r2.setBounds(350,430,100,50);
        r2.setBackground(Color.getHSBColor(0.7f, 0.1f, 0.8f));
        r2.setVisible(true);

        combo = new ButtonGroup();
        combo.add(r1);
        combo.add(r2);


        b1 = new JButton("BACK");
        b1.setBounds(150,550,100,50);
        b1.setFocusable(false);

        b2 = new JButton("SIGN UP");
        b2.setBounds(400,550,100,50);
        b2.setFocusable(false);




        this.add(l1);
        this.add(l2);
        this.add(format1);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(format2);
        this.add(l6);
        this.add(l7);

        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(t4);
        this.add(t5);

        this.add(r1);
        this.add(r2);
        this.add(b1);
        this.add(b2);


        MyActionListener a = new MyActionListener();
        r1.addActionListener(a);
        r2.addActionListener(a);
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
            else if (e.getActionCommand().equals("SIGN UP")) {

                if(r1.isSelected()){
                    gender = "Male";
                }
                else if(r2.isSelected()){
                    gender =  "Female";
                }

                if(t1.getText().isBlank() || t2.getText().isBlank() || t3.getText().isBlank() || t4.getText().isBlank() || t5.getText().isBlank()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Enter the Required Fields !!");
                }
                else if(!(Account.ValidName(t1.getText()))){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Enter Valid Name !!");
                }
                else if(!(Account.ValidCnic(t2.getText()))){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Enter Valid CNIC !!\nFormat(XXXXX-XXXXXXX-X)");
                }
                else if(!(Account.ValidNumber(t4.getText()))){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Enter Valid Number !!\nFormat(03XX-XXXXXXX)");
                }
                else if(!r1.isSelected() && !r2.isSelected()){
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Please Select your Gender !");
                }
                else{
                    Account acc = new Account(t1.getText(),t2.getText(), t3.getText(), t4.getText(), Double.parseDouble(t5.getText()), gender);
                    AccountFileOperations.addAccount(acc);
                    System.out.println(acc.toString());
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Account has been created with account no: " + acc.getAccountNum());
                    dispose();
                    new userMenu();

                }

            }
        }
    }
}
