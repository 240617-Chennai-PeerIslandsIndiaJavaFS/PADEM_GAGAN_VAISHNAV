package org.revature.springbootdemo.service;

import org.revature.springbootdemo.dao.ProjectRepository;
import org.revature.springbootdemo.models.Projects;
import org.revature.springbootdemo.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskService taskService;

    public List<Projects> getAllProjects(){
        return projectRepository.findAll();
    }

    public Optional<Projects> getProjectById(int project_id){
        return projectRepository.findById(project_id);
    }

    public Projects createProject(Projects projects){
        return projectRepository.save(projects);
    }

    public Optional<Projects> deleteProject(int project_id){
        Optional<Projects> projects=projectRepository.findById(project_id);
        projectRepository.deleteById(project_id);
        return projects;
    }

    public Projects updateProjects(Projects projects){
        return projectRepository.save(projects);
    }

    public List<Tasks> getTasksByProjectId(int project_id) {
       return new ArrayList<>(projectRepository.findById(project_id).get().getTasks());
    }
}
