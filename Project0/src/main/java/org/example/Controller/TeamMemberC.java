package org.example.Controller;

import org.example.Models.Project;
import org.example.Models.Task;
import org.example.Service.TeamMemberSer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TeamMemberC {
    private Scanner sc;
    private TeamMemberSer team_member_service;

    public TeamMemberC(TeamMemberSer team_member_service) {
        this.team_member_service = team_member_service;
        sc = new Scanner(System.in);
    }

    public void teamMember() throws SQLException {
        int choice;
        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1) View Project Details  ||  2) View My Tasks  ||  3) Update Task Status  ||  4) Logout ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Enter Your Option : ");
            choice = sc.nextInt();
            if (choice > 0 && choice < 5) {
                switch (choice) {
                    case 1:
                        viewProjectDetails();
                        break;
                    case 2:
                        viewMyTasks();
                        break;
                    case 3:
                        updateTaskStatus();
                        break;
                    case 4:
                        System.out.println("Logout Successful");
                        return;
                }
            } else {
                System.out.println("Invalid Option !!!");
            }
        }
    }

    private void viewProjectDetails() throws SQLException {
        System.out.print("Enter Project ID: ");
        int projectId = sc.nextInt();
        Project project = team_member_service.viewProjectDetails(projectId);
        if (project != null) {
            System.out.println("Project ID: " + project.getProject_id());
            System.out.println("Project Name: " + project.getProject_name());
            System.out.println("Description: " + project.getDescription());
            System.out.println("Client Name: " + project.getClient_name());
            System.out.println("Start Date: " + project.getStart_date());
            System.out.println("End Date: " + project.getEnd_date());
        } else {
            System.out.println("Project Not Found");
        }
    }

    private void viewMyTasks() throws SQLException {
        System.out.print("Enter Your User ID: ");
        int userId = sc.nextInt();
        List<Task> tasks = team_member_service.getTasksByUserId(userId);
        if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
                System.out.println("Task ID: " + task.getTask_id());
                System.out.println("Project ID: " + task.getProject_id());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Status: " + task.getStatus());
                System.out.println("Start Date: " + task.getStart_date());
                System.out.println("End Date: " + task.getEnd_date());
                System.out.println("-----------------------------------------------------------------");
            }
        } else {
            System.out.println("No Tasks Found");
        }
    }

    private void updateTaskStatus() throws SQLException {
        System.out.print("Enter Task ID: ");
        int taskId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter New Status: ");
        String status = sc.nextLine();
        System.out.print("Enter Progress Description: ");
        String progressDescription = sc.nextLine();

        if (team_member_service.updateTaskStatus(taskId, status, progressDescription)) {
            System.out.println("Task Status Updated Successfully");
        } else {
            System.out.println("Failed to Update Task Status");
        }
    }
}