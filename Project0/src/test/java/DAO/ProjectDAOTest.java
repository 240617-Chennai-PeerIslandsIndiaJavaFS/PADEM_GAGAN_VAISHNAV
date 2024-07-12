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
        DBConn.setConnection(connection);
        projectDAO = new ProjectDAO();
        connection.createStatement().execute("INSERT INTO projects (project_id, project_name) VALUES (1, 'Test Project')");
        connection.createStatement().execute("INSERT INTO user_project_roles (user_id, project_id) VALUES (1, 1)");
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
        boolean result = projectDAO.addUserToProject(1, 2);

        assertTrue(result);
    }

    @Test
    void testRemoveUserFromProject() throws SQLException {
        boolean result = projectDAO.removeUserFromProject(1, 1);

        assertTrue(result);
    }

    @Test
    void testResetPassword() throws SQLException {
        connection.createStatement().execute("INSERT INTO users (email, password_hash) VALUES ('test@example.com', 'oldpassword')");

        boolean result = projectDAO.resetPassword("test@example.com", "newpassword");

        assertTrue(result);
    }
}
