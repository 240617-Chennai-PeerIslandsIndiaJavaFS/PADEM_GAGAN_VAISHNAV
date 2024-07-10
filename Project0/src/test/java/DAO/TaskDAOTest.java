package DAO;
import org.example.Connection.DBConn;
import org.example.DAO.TaskDAO;
import org.example.Models.Task;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskDAOTest {

    private TaskDAO taskDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;", "sa", "");
        connection = cp.getConnection();
        DBConn.setConnection(connection);  // Set the connection for testing
        taskDAO = new TaskDAO();

        // Create table and insert test data
        connection.createStatement().execute("CREATE TABLE tasks (" +
                "task_id INT PRIMARY KEY, " +
                "project_id INT, " +
                "assigned_to INT, " +
                "title VARCHAR(100), " +
                "description TEXT, " +
                "status VARCHAR(50), " +
                "start_date DATE, " +
                "end_date DATE)");
        connection.createStatement().execute("INSERT INTO tasks (task_id, title, assigned_to) VALUES (1, 'Test Task', 1)");
    }

    @Test
    void testCreateTask() throws SQLException {
        Task task = new Task();
        task.setTask_id(2);
        task.setProject_id(1);
        task.setAssigned_to(1);
        task.setTitle("New Task");
        task.setDescription("Description of new task");
        task.setStatus("Pending");

        boolean result = taskDAO.createTask(task);

        assertTrue(result);

        List<Task> tasks = taskDAO.getTasksByUserId(1);
        assertEquals(2, tasks.size());
    }

    @Test
    void testGetTasksByUserId() throws SQLException {
        List<Task> tasks = taskDAO.getTasksByUserId(1);

        assertNotNull(tasks);
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    void testUpdateTaskStatus() throws SQLException {
        boolean result = taskDAO.updateTaskStatus(1, "Completed", "Finished the task");

        assertTrue(result);

        List<Task> tasks = taskDAO.getTasksByUserId(1);
        assertEquals("Completed", tasks.get(0).getStatus());
    }
}