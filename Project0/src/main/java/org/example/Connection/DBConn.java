package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static DBConn instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/db";
    private String username = "root";
    private String password = "Gagan@2002";

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

    public static DBConn getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConn();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConn();
        }

        return instance;
    }

    public static void setConnection(Connection connection) {
        if (instance == null) {
            try {
                instance = new DBConn();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        instance.connection = connection;
    }
}
