package com.company;

import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable {
    private String name;
    private String cnic;
    private String phoneNum;
    private boolean isActive;
    private boolean hasCheckBook;
    private String passWord;
    private String accountNum;
    private double balance;
    private double loan;
    private double lonePayable;
    private String gender;

    Account(){
        this.hasCheckBook = false;
        this.isActive = false;
        this.passWord = null;
        this.loan = 0.0;
    }

    Account(String name, String cnic, String password, String phoneNum, double balance, String gender){
        Random rand = new Random();
        this.name = name;
        this.cnic = cnic;
        this.phoneNum = phoneNum;
        this.balance = balance;
        this.gender = gender;
        this.isActive = false;
        this.hasCheckBook = false;
        this.loan = 0.0;
        this.lonePayable = 0.0;
        this.passWord = password;
        this.accountNum = Integer.toString(rand.nextInt(10000,20000));
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    public void setActive(boolean active) {
        this.isActive = active;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void setLoan(double loan) {
        this.loan = loan;
    }
    public void setLonePayable(double lonePayable) {
        this.lonePayable = lonePayable;
    }
    public void setHasCheckBook(boolean hasCheckBook) {
        this.hasCheckBook = hasCheckBook;
    }

    //Getters
    public double getLoan() {
        return loan;
    }
    public boolean isActive() {
        return isActive;
    }
    public String getName() {
        return name;
    }
    public String getCnic() {
        return cnic;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getGender() {
        return gender;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountNum() {
        return accountNum;
    }
    public String getPassWord() {
        return passWord;
    }
    public double getLonePayable() {
        return lonePayable;
    }
    public boolean getHasCheckBook() {
        return hasCheckBook;
    }

    static boolean ValidNumber(String number) {
        return number.matches("^03[0-4][0-9]-[0-9]{7}$");
    }

    static boolean ValidName(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z' || ch == ' ')) {
                return false;
            }
        }
        return true;
    }

    static boolean ValidCnic(String cnic) {
        if(cnic.matches("^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$"))
            return true;
        else
            return false;
    }



    @Override
    public String toString() {
        return "Account Details --" +
                "\nName: " + this.name +
                "\nCNIC: " + this.cnic +
                "\nPhone Number: "+ this.phoneNum +
                "\nGender: " + this.gender +
                "\nActivated? " + this.isActive +
                "\nHas CheckBook? " + this.hasCheckBook +
                "\nPassword: " + this.passWord +
                "\nAccount Number: " + this.accountNum +
                "\nBalance: " + this.balance +
                "\nLoan Taken: " + this.loan;
    }
}
