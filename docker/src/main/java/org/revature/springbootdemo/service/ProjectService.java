package org.revature.springbootdemo.service;

import org.revature.springbootdemo.dao.ProjectRepository;
//import org.revature.springbootdemo.exceptions.ProjectNotFoundException;
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

//    @Autowired
//    private NotificationService notificationService;

    public List<Projects> getAllProjects(){
        return projectRepository.findAll();
    }

    public Optional<Projects> getProjectById(int project_id){
        Optional<Projects> obj1 = projectRepository.findById(project_id);
//        if(obj1.isEmpty()){
//            throw new ProjectNotFoundException();
//        }
        return obj1;
    }

    public Projects createProject(Projects projects){
        Projects savedProject = projectRepository.save(projects);
//        notificationService.notifyAllSubscribers(savedProject);
        return savedProject;
    }

    public Optional<Projects> deleteProject(int project_id){
        Optional<Projects> projects = projectRepository.findById(project_id);
        projectRepository.deleteById(project_id);
        return projects;
    }

    public Projects updateProjects(Projects projects){
        Projects updatedProject = projectRepository.save(projects);
//        notificationService.notifyAllSubscribers(updatedProject);
        return updatedProject;
    }

    public List<Tasks> getTasksByProjectId(int project_id) {
        return new ArrayList<>(projectRepository.findById(project_id).get().getTasks());
    }
}
