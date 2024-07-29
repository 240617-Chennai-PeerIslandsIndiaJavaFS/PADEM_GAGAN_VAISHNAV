package org.revature.springbootdemo.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    @Column(name="project_name")
    private String project_name;

    @Column(name="project_desc")
    private String project_desc;

    @OneToMany(mappedBy = "project_id", cascade = CascadeType.ALL)
    private Set<Tasks> tasks;

    public Projects(){}

    public Projects(int project_id, String project_name, String project_desc, Set<Tasks> tasks) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_desc = project_desc;
        this.tasks = tasks;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }
}
