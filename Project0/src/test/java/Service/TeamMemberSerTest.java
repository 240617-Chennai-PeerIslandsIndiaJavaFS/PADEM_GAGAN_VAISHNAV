package Service;

import org.example.DAO.ProjectDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.TaskUpdateDAO;
import org.example.Models.Project;
import org.example.Models.Task;
import org.example.Models.TaskUpdate;
import org.example.Service.TeamMemberSer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamMemberSerTest {

    @Mock
    private ProjectDAO projectDAO;

    @Mock
    private TaskDAO taskDAO;

    @Mock
    private TaskUpdateDAO taskUpdateDAO;

    @InjectMocks
    private TeamMemberSer teamMemberSer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testViewProjectDetails() throws SQLException {
        Project project = new Project();
        project.setProject_id(1);
        project.setProject_name("Project 1");

        when(projectDAO.getProjectById(1)).thenReturn(project);

        Project result = teamMemberSer.viewProjectDetails(1);

        assertNotNull(result);
        assertEquals("Project 1", result.getProject_name());
        verify(projectDAO, times(1)).getProjectById(1);
    }

    @Test
    void testGetTasksByUserId() throws SQLException {
        Task task1 = new Task();
        task1.setTask_id(1);
        task1.setTitle("Task 1");

        Task task2 = new Task();
        task2.setTask_id(2);
        task2.setTitle("Task 2");

        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskDAO.getTasksByUserId(1)).thenReturn(tasks);

        List<Task> result = teamMemberSer.getTasksByUserId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(taskDAO, times(1)).getTasksByUserId(1);
    }

    @Test
    void testUpdateTaskStatus() throws SQLException {
        TaskUpdate taskUpdate = new TaskUpdate();
        taskUpdate.setTask_id(1);
        taskUpdate.setStatus("Completed");
        taskUpdate.setProgress_description("Finished the task");

        when(taskUpdateDAO.createTaskUpdate(any(TaskUpdate.class))).thenReturn(true);
        when(taskDAO.updateTaskStatus(1, "Completed", "Finished the task")).thenReturn(true);

        boolean result = teamMemberSer.updateTaskStatus(1, "Completed", "Finished the task");

        assertTrue(result);
        verify(taskUpdateDAO, times(1)).createTaskUpdate(any(TaskUpdate.class));
        verify(taskDAO, times(1)).updateTaskStatus(1, "Completed", "Finished the task");
    }
}
