package com.company;

import java.io.*;
import java.util.ArrayList;

public class AdminFileOperations {
    public static ArrayList<Admin> adminRecord;

    public static void addData(){
        Admin u = new Admin();
        ObjectOutputStream oos;
        try{
            File f = new File("Admin.txt");
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            adminRecord.add(u);
            System.out.println("Admin Data added to file.");
            oos.writeObject(u);
            oos.close();
        }
        catch (Exception e) {
            System.out.println("Error while adding user to the file.");
            e.printStackTrace();
        }
    }

    public static void readFromFile(){
        try {
            adminRecord = new ArrayList<Admin>();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Admin.txt"));
            while (true){
                Admin s = (Admin) ois.readObject();
                adminRecord.add(s);
            }
        }
        catch (EOFException e){
            System.out.println("Data has been retrieved (Admin).");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Reading/Writing error in Admin File.");
        }
    }

    public static Admin getAdmin() throws IOException, ClassNotFoundException {
        System.out.println(adminRecord);
        Admin ad = adminRecord.get(0);
        return ad;
    }

    public static void saveData(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Admin.txt", false));
            for (Admin admin : adminRecord) {
                oos.writeObject(admin);
                System.out.println("Data saved successfully !");
            }
            oos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




























































//    public static ArrayList<Admin> adminRecord;
//
//    public static void addData(Admin u){
//        ObjectOutputStream oos;
//        adminRecord = new ArrayList<Admin>();
//        try{
//            File f = new File("Admin.txt");
//            if(f.exists()){
//                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
//            }
//            else {
//                oos = new ObjectOutputStream(new FileOutputStream(f));
//            }
//            adminRecord.add(0, u);
//            System.out.println(adminRecord.get(0).getAdminID());
//            oos.writeObject(u);
//            oos.close();
//        }
//        catch (Exception e) {
//            System.out.println("Error while adding user to the file.");
//            e.printStackTrace();
//        }
//    }
//
//    public static void saveData(){
//        try{
//            //Rewrite data to the file from the ArrayList
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Admin.txt", false));
//            for (Admin admin : adminRecord) {
//                oos.writeObject(admin);
//            }
//            oos.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public static void readAllFromFile(){
//        try {
//            adminRecord = new ArrayList<Admin>();
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Admin.txt"));
//            while (true){
//                Admin s = (Admin) ois.readObject();
//                adminRecord.add(s);
//                System.out.println("Data from file added to ArrayList Successfully.");
//            }
//        }
//        catch (EOFException e){
//            System.out.println("Data has been retrieved.");
////            return null;
//        }
//        catch (IOException e){
//            System.out.println("Reading/Writing error.");
//        }
//        catch (Exception e) {
////            e.printStackTrace();
//        }
//    }
//
//
//
//    public static Admin getAdmin(){
//        Admin a = null;
//
//        if (adminRecord.get(0) != null){
//            a = adminRecord.get(0);
//        }
//        return a;
//    }


}
