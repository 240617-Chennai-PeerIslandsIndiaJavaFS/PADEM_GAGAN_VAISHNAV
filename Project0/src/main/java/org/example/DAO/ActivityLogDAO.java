package org.example.DAO;

import org.example.Connection.DBConn;
import org.example.Models.ActivityLog;
import java.sql.*;

public class ActivityLogDAO {
    private Connection connection;

    public ActivityLogDAO() throws SQLException {
        connection = DBConn.getInstance().getConnection();
    }

    public boolean createActivityLog(ActivityLog log) throws SQLException {
        String query = "INSERT INTO activity_logs (user_id, activity_type, activity_description, timestamp) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, log.getUser_id());
        pstmt.setString(2, log.getActivity_type());
        pstmt.setString(3, log.getActivity_description());
        pstmt.setTimestamp(4, log.getTimestamp());
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    }
}