package org.example.DAO;

import org.example.Connection.DBConn;
import org.example.Models.TaskUpdate;
import java.sql.*;

public class TaskUpdateDAO {
    private Connection connection;

    public TaskUpdateDAO() throws SQLException {
        connection = DBConn.getInstance().getConnection();
    }

    public boolean createTaskUpdate(TaskUpdate taskUpdate) throws SQLException {
        String query = "INSERT INTO task_updates (task_id, user_id, status, progress_description, updated_at) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, taskUpdate.getTask_id());
        pstmt.setInt(2, taskUpdate.getUser_id());
        pstmt.setString(3, taskUpdate.getStatus());
        pstmt.setString(4, taskUpdate.getProgress_description());
        pstmt.setTimestamp(5, taskUpdate.getUpdated_at());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }
}