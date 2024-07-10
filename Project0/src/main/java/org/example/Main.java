package org.example;

import org.example.Controller.UserC;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            UserC userController = new UserC();
            userController.loginUser();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}