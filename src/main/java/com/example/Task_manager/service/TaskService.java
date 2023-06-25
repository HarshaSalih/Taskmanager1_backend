package com.example.Task_manager.service;

import com.example.Task_manager.model.Tasks;
import com.example.Task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Tasks createTask(Tasks tasks) {
        return taskRepository.save(tasks);
    }
    public Tasks updateTask(int taskId, Tasks updatedTask) {
        Tasks tasks = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + taskId));
        tasks.setTitle(updatedTask.getTitle());
        tasks.setDescription(updatedTask.getDescription());
        tasks.setStatus(updatedTask.getStatus());
        return taskRepository.save(tasks);
    }
    public void deleteTask(int taskId) {
        Tasks tasks = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + taskId));
        taskRepository.delete(tasks);
    }
    public List<Tasks> getAllTasks(int userId) {
        return taskRepository.findByUid(userId);
    }


}
