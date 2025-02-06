package com.company;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AdminFileOperations.readFromFile();
        // AdminFileOperations.addData();

        AccountFileOperations.readAllFromFile();
        new mainMenu();

    }
}
