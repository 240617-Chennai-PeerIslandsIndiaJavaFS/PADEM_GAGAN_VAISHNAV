package org.example;

import org.example.Controller.MainPage;
import org.example.Controller.UserC;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            MainPage mainpage=new MainPage();
            mainpage.homePage();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}