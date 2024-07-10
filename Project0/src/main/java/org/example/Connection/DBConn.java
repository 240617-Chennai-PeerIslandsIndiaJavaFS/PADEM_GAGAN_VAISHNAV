package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static DBConn instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/your_db_name";
    private String username = "your_db_username";
    private String password = "your_db_password";

    private DBConn() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConn getInstance() {
        try {
            if (instance == null) {
                instance = new DBConn();
            } else if (instance.getConnection().isClosed()) {
                instance = new DBConn();
            }
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }

        return instance;
    }

    // Method for testing purposes
    public static void setConnection(Connection connection) throws SQLException {
        if (instance == null) {
            instance = new DBConn();
        }
        instance.connection = connection;
    }
}
