package org.revature.springbootdemo.models;

import jakarta.persistence.*;

@Entity
@Table(name="tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;

    @Column(name="taskname")
    private String task_name;

    @Column(name="taskdesc")
    private String task_description;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Projects project;
    @Column(name = "project_id")
    private int project_id;

    public Tasks(){}

    public Tasks(int task_id, String task_name, String task_description, int project_id) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.project_id = project_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public int getProject() {
        return project_id;
    }

    public void setProject(int project_id) {
        this.project_id = project_id;
    }
}
