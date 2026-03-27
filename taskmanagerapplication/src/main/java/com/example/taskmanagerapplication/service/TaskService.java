package com.example.taskmanagerapplication.service;


import com.example.taskmanagerapplication.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setTitle(updatedTask.getTitle());
                t.setCompleted(updatedTask.isCompleted());
                return t;
            }
        }
        return null;
    }

    public void deleteTask(Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}