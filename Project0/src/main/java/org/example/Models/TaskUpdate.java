package org.example.Models;

import java.sql.Timestamp;
import java.util.Date;

public class TaskUpdate {
    private int update_id;
    private int task_id;
    private int user_id;
    private String status;
    private String progress_description;
    private Timestamp updated_at;

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgress_description() {
        return progress_description;
    }

    public void setProgress_description(String progress_description) {
        this.progress_description = progress_description;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}