package org.example.DAO;

import org.example.Connection.DBConn;
import org.example.Models.User;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws SQLException {
        connection = DBConn.getInstance().getConnection();
    }

    public boolean createUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, password_hash, email, first_name, last_name, user_role) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, user.getUser_name());
        pstmt.setString(2, user.getUser_password());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getFirst_name());
        pstmt.setString(5, user.getLast_name());
        pstmt.setString(6, user.getUser_role());
        pstmt.executeUpdate();
        return true;
    }

    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE users SET username=?, email=?, password_hash=?, first_name=?, last_name=?, user_role=?, status=? WHERE user_id=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, user.getUser_name());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getUser_password());
        pstmt.setString(4, user.getFirst_name());
        pstmt.setString(5, user.getLast_name());
        pstmt.setString(6, user.getUser_role());
        pstmt.setString(7, user.getAccount_status());
        pstmt.setInt(8, user.getUser_id());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }

    public boolean deleteUser(User user) throws SQLException {
        String query = "DELETE FROM users WHERE user_id=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, user.getUser_id());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }

    public User getUserByName(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("username"));
            user.setUser_password(rs.getString("password_hash"));
            user.setEmail(rs.getString("email"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setUser_role(rs.getString("user_role"));
            user.setAccount_status(rs.getString("status"));
            return user;
        }
        return null;
    }

    public User getByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("username"));
            user.setUser_password(rs.getString("password_hash"));
            user.setEmail(rs.getString("email"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setUser_role(rs.getString("user_role"));
            user.setAccount_status(rs.getString("status"));
            return user;
        }
        return null;
    }

    public User getUserById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setUser_name(rs.getString("username"));
            user.setUser_password(rs.getString("password_hash"));
            user.setEmail(rs.getString("email"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setUser_role(rs.getString("user_role"));
            user.setAccount_status(rs.getString("status"));
            return user;
        }
        return null;
    }

}
