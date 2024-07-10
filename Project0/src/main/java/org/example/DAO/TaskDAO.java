package org.example.DAO;

import org.example.Connection.DBConn;
import org.example.Models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private Connection connection;

    public TaskDAO() {
        connection = DBConn.getInstance().getConnection();
    }

    public boolean createTask(Task task) throws SQLException {
        String query = "INSERT INTO tasks (project_id, assigned_to, title, description, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, task.getProject_id());
        pstmt.setInt(2, task.getAssigned_to());
        pstmt.setString(3, task.getTitle());
        pstmt.setString(4, task.getDescription());
        pstmt.setString(5, task.getStatus());
        pstmt.setDate(6, task.getStart_date());
        pstmt.setDate(7, task.getEnd_date());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }

    public List<Task> getTasksByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM tasks WHERE assigned_to = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();

        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            Task task = new Task();
            task.setTask_id(rs.getInt("task_id"));
            task.setProject_id(rs.getInt("project_id"));
            task.setAssigned_to(rs.getInt("assigned_to"));
            task.setTitle(rs.getString("title"));
            task.setDescription(rs.getString("description"));
            task.setStatus(rs.getString("status"));
            task.setStart_date(rs.getDate("start_date"));
            task.setEnd_date(rs.getDate("end_date"));
            tasks.add(task);
        }
        return tasks;
    }

    public boolean updateTaskStatus(int taskId, String status, String progressDescription) throws SQLException {
        String query = "UPDATE tasks SET status = ?, progress_description = ? WHERE task_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, status);
        pstmt.setString(2, progressDescription);
        pstmt.setInt(3, taskId);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }
}