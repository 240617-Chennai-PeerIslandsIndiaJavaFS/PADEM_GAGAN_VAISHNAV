package org.example.Service;

import org.example.DAO.UserDAO;
import org.example.Models.User;

import java.sql.SQLException;

public class UserSer {
    private UserDAO user_dao;
    private AdminSer admin_service;

    public UserSer() {
        user_dao = new UserDAO();
        admin_service = new AdminSer(user_dao);
    }

    public User loginUser(String email, String password) throws SQLException {
        User user = user_dao.getByEmail(email);
        if (user != null && user.getUser_password().equals(password)) {
            return user;
        }
        return null;
    }

    public String getUserRoleById(int id) throws SQLException {
        User user = user_dao.getUserById(id);
        if (user != null) {
            return user.getUser_role();
        }
        return null;
    }

    public AdminSer getAdminService() {
        return admin_service;
    }

    public UserDAO getUserDAO() {
        return user_dao;
    }
}