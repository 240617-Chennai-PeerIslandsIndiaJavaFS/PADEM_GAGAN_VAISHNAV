package org.example.Service;

import org.example.DAO.ProjectDAO;
import org.example.DAO.TaskDAO;
import org.example.DAO.MilestoneDAO;
import org.example.DAO.ActivityLogDAO;
import org.example.Models.Project;
import org.example.Models.Task;
import org.example.Models.Milestone;
import org.example.Models.ActivityLog;

import java.sql.SQLException;
import java.util.List;

public class ProjectManagerSer {
    private ProjectDAO project_dao;
    private TaskDAO task_dao;
    private MilestoneDAO milestone_dao;
    private ActivityLogDAO activity_log_dao;

    public ProjectManagerSer(ProjectDAO project_dao, TaskDAO task_dao, MilestoneDAO milestone_dao, ActivityLogDAO activity_log_dao) {
        this.project_dao = project_dao;
        this.task_dao = task_dao;
        this.milestone_dao = milestone_dao;
        this.activity_log_dao = activity_log_dao;
    }

    public boolean resetPassword(String email, String newPassword) throws SQLException {
        return project_dao.resetPassword(email, newPassword);
    }

    public boolean manageClientInfo(Project project) throws SQLException {
        return project_dao.updateProject(project);
    }

    public boolean addTeamMemberToProject(int projectId, int userId) throws SQLException {
        return project_dao.addUserToProject(projectId, userId);
    }

    public boolean assignTask(Task task) throws SQLException {
        return task_dao.createTask(task);
    }

    public boolean createMilestone(Milestone milestone) throws SQLException {
        return milestone_dao.createMilestone(milestone);
    }

    public boolean createActivityLog(ActivityLog log) throws SQLException {
        return activity_log_dao.createActivityLog(log);
    }
}