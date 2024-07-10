package org.example.Controller;

import org.example.Service.UserSer;
import java.sql.SQLException;
import java.util.Scanner;

public class MainPage {
    private Scanner sc;
    private UserSer user_service;

    public MainPage() {
        this.sc = new Scanner(System.in);
        this.user_service = new UserSer();
    }

    public void homePage() throws SQLException, ClassNotFoundException {
        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) Admin Login  ||  2) Exit");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Enter Your Option : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    UserC userController = new UserC();
                    userController.loginUser();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option !!!");
            }
        }
    }
}
