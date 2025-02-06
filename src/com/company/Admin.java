package com.company;

import java.io.Serializable;

public class Admin implements Serializable {
    public int adminID;
    public String name;
    public String passWord;
    public int interestRate;

    Admin(){
        this.adminID = 1122;
        this.name = "ABDULLAH";
        this.passWord = "abd";
        this.interestRate = 10;
    }

    //Setters
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public String getPassWord() {
        return passWord;
    }
    public int getInterestRate() {
        return interestRate;
    }
    public int getAdminID() {
        return adminID;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Admin Details:" +
                "\nName: " + name +
                "\nAdminID: " + adminID +
                "\nPassword: " + passWord +
                "\nInterest rate: " + interestRate;
    }
}
