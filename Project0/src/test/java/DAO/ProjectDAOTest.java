package DAO;
import org.example.Connection.DBConn;
import org.example.DAO.ProjectDAO;
import org.example.Models.Project;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDAOTest {

    private ProjectDAO projectDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;", "sa", "");
        connection = cp.getConnection();
        DBConn.setConnection(connection);  // Set the connection for testing
        projectDAO = new ProjectDAO();

        // Create table and insert test data
        connection.createStatement().execute("CREATE TABLE projects (" +
                "project_id INT PRIMARY KEY, " +
                "project_name VARCHAR(100), " +
                "description TEXT, " +
                "client_name VARCHAR(100), " +
                "start_date DATE, " +
                "end_date DATE)");
        connection.createStatement().execute("INSERT INTO projects (project_id, project_name) VALUES (1, 'Test Project')");
    }

    @Test
    void testGetProjectById() throws SQLException {
        Project project = projectDAO.getProjectById(1);

        assertNotNull(project);
        assertEquals("Test Project", project.getProject_name());
    }

    @Test
    void testUpdateProject() throws SQLException {
        Project project = new Project();
        project.setProject_id(1);
        project.setProject_name("Updated Project");

        boolean result = projectDAO.updateProject(project);

        assertTrue(result);

        Project updatedProject = projectDAO.getProjectById(1);
        assertEquals("Updated Project", updatedProject.getProject_name());
    }

    @Test
    void testAddUserToProject() throws SQLException {
        connection.createStatement().execute("CREATE TABLE user_project_roles (" +
                "user_project_role_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "user_id INT, " +
                "project_id INT)");

        boolean result = projectDAO.addUserToProject(1, 2);

        assertTrue(result);
    }

    @Test
    void testResetPassword() throws SQLException {
        connection.createStatement().execute("CREATE TABLE users (email VARCHAR(100), password_hash VARCHAR(255))");
        connection.createStatement().execute("INSERT INTO users (email, password_hash) VALUES ('test@example.com', 'oldpassword')");

        boolean result = projectDAO.resetPassword("test@example.com", "newpassword");

        assertTrue(result);
    }
}