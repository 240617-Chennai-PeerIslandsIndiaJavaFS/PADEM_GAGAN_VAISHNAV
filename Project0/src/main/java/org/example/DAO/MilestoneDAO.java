package org.example.DAO;

import org.example.Connection.DBConn;
import org.example.Models.Milestone;
import java.sql.*;

public class MilestoneDAO {
    private Connection connection;

    public MilestoneDAO() throws SQLException {
        connection = DBConn.getInstance().getConnection();
    }

    public boolean createMilestone(Milestone milestone) throws SQLException {
        String query = "INSERT INTO milestones (project_id, name, description, due_date) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, milestone.getProject_id());
        pstmt.setString(2, milestone.getName());
        pstmt.setString(3, milestone.getDescription());
        pstmt.setDate(4, milestone.getDue_date());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }
}
