package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class AccountFileOperations {
    public static ArrayList<Account> bankRecord;

    public static void addAccount(Account u){
        ObjectOutputStream oos;
        try{
            File f = new File("Accounts.txt");
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            bankRecord.add(u);
            oos.writeObject(u);
            oos.close();
        }
        catch (Exception e) {
            System.out.println("Error while adding user to the file.");
            e.printStackTrace();
        }
    }

    public static void saveData(){
        try{
            //Rewrite data to the file from the ArrayList
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Accounts.txt", false));
            for (Account account : bankRecord) {
                oos.writeObject(account);
            }
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void readAllFromFile(){
        try {
            bankRecord = new ArrayList<Account>();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Accounts.txt"));
            while (true){
                Account s = (Account) ois.readObject();
                bankRecord.add(s);
            }
        }
        catch (EOFException e){
            System.out.println("Data has been retrieved (Accounts).");
//            return null;
        }
        catch (IOException e){
            System.out.println("Reading/Writing error in Accounts File.");
        }
        catch (Exception e) {
//            e.printStackTrace();
        }
    }


    public static boolean searchAnAccount(String accountNum, String cnic){
        boolean check = false;

        for (Account acc : bankRecord) {
            System.out.println(acc.getAccountNum());
            if ((acc.getAccountNum().equals(accountNum)) && acc.getCnic().equals(cnic))
            {
                System.out.println("Account Exists in the File Record data.");
                check = true;
                break;
            }
        }
        return check;
    }

    public static Account searchAnAccount(String accountNum){
        Account a = null;

        for (Account acc : bankRecord) {
            if ((acc.getAccountNum().equals(accountNum)))
            {
                a = acc;
                System.out.println("Account Exists in the File Record data.");
                break;
            }
        }
        return a;
    }





    public static void deleteRecord(String accNum, String passWord)  throws IOException {
        if (bankRecord.size() == 0){
            JOptionPane.showMessageDialog(new JFrame(),"No Accounts Exist in the record!");
        }
        //First, delete from Array List
        for (int i = 0; i < bankRecord.size(); i++){
            if (bankRecord.get(i).getAccountNum().equals(accNum) && bankRecord.get(i).getPassWord().equals(passWord)){
                bankRecord.remove(i);
                System.out.println("Deletion fromm Bank Record ArrayList successful.");
                break;
            }
        }
        //Then, rewrite data on File from ArrayList
        saveData();
    }

}
