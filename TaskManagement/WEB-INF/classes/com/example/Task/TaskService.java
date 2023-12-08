package com.example.Task;
import java.util.*;
public class TaskService {

    private TaskDAO taskDAO = new TaskDAO();

    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    public Task getTaskById(Long id) {
        return taskDAO.getTaskById(id);
    }

    public Task createTask(Task task) {
        return taskDAO.createTask(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskDAO.updateTask(id, updatedTask);
    }

    public void deleteTask(Long id) {
        taskDAO.deleteTask(id);
    }
}
