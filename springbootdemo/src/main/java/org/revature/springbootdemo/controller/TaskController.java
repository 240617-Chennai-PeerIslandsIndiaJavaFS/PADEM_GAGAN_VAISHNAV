package org.revature.springbootdemo.controller;

import org.revature.springbootdemo.models.Tasks;
import org.revature.springbootdemo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable int task_id){
        return new ResponseEntity<Tasks>(taskService.getTaskById(task_id).get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tasks> createTasks(@RequestBody Tasks tasks){
        return new ResponseEntity<>(taskService.createTask(tasks),HttpStatus.CREATED);
    }

    @DeleteMapping("/{task_id}")
    public ResponseEntity<Optional<Tasks>> deleteTasks(@PathVariable int task_id){
        return  new ResponseEntity<>(taskService.deleteTask(task_id),HttpStatus.OK);
    }

    @PutMapping("/{task_id}")
    public ResponseEntity<Tasks> updateTasks(@RequestBody Tasks tasks){
        return new ResponseEntity<>(taskService.updateTasks(tasks),HttpStatus.ACCEPTED);
    }
}
