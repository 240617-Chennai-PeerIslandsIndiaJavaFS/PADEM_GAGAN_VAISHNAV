package org.revature.springbootdemo.service;

import org.revature.springbootdemo.dao.TaskRepository;
import org.revature.springbootdemo.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Tasks> getTaskById(int task_id){
        return taskRepository.findById(task_id);
    }

    public Tasks createTask(Tasks tasks){
        return taskRepository.save(tasks);
    }

    public Optional<Tasks> deleteTask(int task_id){
        Optional<Tasks> tasks=taskRepository.findById(task_id);
        taskRepository.deleteById(task_id);
        return tasks;
    }

    public Tasks updateTasks(Tasks tasks){
        //taskRepository.findById(task_id);
        return taskRepository.save(tasks);
    }

//    public List<Tasks> getTasksByProjectId(int project_id) {
//        return taskRepository.findByProjectId(project_id);
//    }
}
