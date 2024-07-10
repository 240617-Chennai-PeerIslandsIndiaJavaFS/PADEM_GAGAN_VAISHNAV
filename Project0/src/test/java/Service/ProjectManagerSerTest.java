package Service;

import org.example.DAO.ProjectDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.MilestoneDAO;
import org.example.DAO.ActivityLogDAO;
import org.example.Models.Project;
import org.example.Models.Task;
import org.example.Models.Milestone;
import org.example.Models.ActivityLog;
import org.example.Service.ProjectManagerSer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectManagerSerTest {

    @Mock
    private ProjectDAO projectDAO;

    @Mock
    private TaskDAO taskDAO;

    @Mock
    private MilestoneDAO milestoneDAO;

    @Mock
    private ActivityLogDAO activityLogDAO;

    @InjectMocks
    private ProjectManagerSer projectManagerSer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testResetPassword() throws SQLException {
        when(projectDAO.resetPassword("test@example.com", "newpassword")).thenReturn(true);

        boolean result = projectManagerSer.resetPassword("test@example.com", "newpassword");

        assertTrue(result);
        verify(projectDAO, times(1)).resetPassword("test@example.com", "newpassword");
    }

    @Test
    void testManageClientInfo() throws SQLException {
        Project project = new Project();
        when(projectDAO.updateProject(project)).thenReturn(true);

        boolean result = projectManagerSer.manageClientInfo(project);

        assertTrue(result);
        verify(projectDAO, times(1)).updateProject(project);
    }

    @Test
    void testAddTeamMemberToProject() throws SQLException {
        when(projectDAO.addUserToProject(1, 2)).thenReturn(true);

        boolean result = projectManagerSer.addTeamMemberToProject(1, 2);

        assertTrue(result);
        verify(projectDAO, times(1)).addUserToProject(1, 2);
    }

    @Test
    void testAssignTask() throws SQLException {
        Task task = new Task();
        when(taskDAO.createTask(task)).thenReturn(true);

        boolean result = projectManagerSer.assignTask(task);

        assertTrue(result);
        verify(taskDAO, times(1)).createTask(task);
    }

    @Test
    void testCreateMilestone() throws SQLException {
        Milestone milestone = new Milestone();
        when(milestoneDAO.createMilestone(milestone)).thenReturn(true);

        boolean result = projectManagerSer.createMilestone(milestone);

        assertTrue(result);
        verify(milestoneDAO, times(1)).createMilestone(milestone);
    }

    @Test
    void testCreateActivityLog() throws SQLException {
        ActivityLog log = new ActivityLog();
        when(activityLogDAO.createActivityLog(log)).thenReturn(true);

        boolean result = projectManagerSer.createActivityLog(log);

        assertTrue(result);
        verify(activityLogDAO, times(1)).createActivityLog(log);
    }
}
