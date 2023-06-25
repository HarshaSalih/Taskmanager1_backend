package com.example.Task_manager.controller;

import com.example.Task_manager.model.Tasks;
import com.example.Task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks tasks) {
        Tasks createdTask = taskService.createTask(tasks);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<Tasks> updateTask(@PathVariable int taskId, @RequestBody Tasks updatedTask) {
        Tasks tasks = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Deleted successfully");
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Tasks>>getAllTasks(@PathVariable int userId) {
        List<Tasks> tasks = taskService.getAllTasks(userId);
        return ResponseEntity.ok(tasks);
    }
}
