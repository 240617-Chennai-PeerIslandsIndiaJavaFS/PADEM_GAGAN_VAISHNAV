package org.revature.springbootdemo.controller;
//import org.revature.springbootdemo.exceptions.ProjectNotFoundException;
import org.revature.springbootdemo.models.Projects;
import org.revature.springbootdemo.models.Tasks;
import org.revature.springbootdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Projects>> getAllProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable int project_id){
        return new ResponseEntity<Projects>(projectService.getProjectById(project_id).get(),HttpStatus.OK);
    }

    @GetMapping("/{project_id}/tasks")
    public ResponseEntity<List<Tasks>> getTaskByProjectId(@PathVariable("project_id") int project_id){
        List<Tasks> tasks = projectService.getTasksByProjectId(project_id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Projects> createProjects(@RequestBody Projects projects){
        return new ResponseEntity<>(projectService.createProject(projects),HttpStatus.CREATED);
    }

    @DeleteMapping("/{project_id}")
    public ResponseEntity<Optional<Projects>> deleteProjects(@PathVariable int project_id){
        return  new ResponseEntity<>(projectService.deleteProject(project_id),HttpStatus.OK);
    }

    @PutMapping("/{project_id}")
    public ResponseEntity<Projects> updateProjects(@RequestBody Projects projects){
        return new ResponseEntity<>(projectService.updateProjects(projects),HttpStatus.ACCEPTED);
    }

    @MessageMapping("/send")
    @SendTo("/topic/projects")
    public String sendMessage(String message){
        return message;
    }
}
