package org.example.Models;

public class UserProjectRole {

    private int user_project_role_id;
    private int user_id;
    private int project_id;

    public int getUser_project_role_id() {
        return user_project_role_id;
    }

    public void setUser_project_role_id(int user_project_role_id) {
        this.user_project_role_id = user_project_role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}