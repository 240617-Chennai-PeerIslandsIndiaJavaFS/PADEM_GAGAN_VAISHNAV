package org.example.Service;

import org.example.DAO.UserDAO;
import org.example.Models.User;

import java.sql.SQLException;

public class AdminSer {
    UserDAO user_dao;

    public AdminSer(){

    }
    public AdminSer(UserDAO user_dao) {

        this.user_dao = user_dao;
    }

    public User getUserByName(String name) throws SQLException {
        return user_dao.getUserByName(name);
    }

    public boolean updateUser(User user) throws SQLException {

        return user_dao.updateUser(user);
    }
    public boolean deleteUser(User user) throws SQLException {
        return user_dao.deleteUser(user);
    }

}