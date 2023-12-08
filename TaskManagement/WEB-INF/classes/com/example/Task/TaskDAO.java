package com.example.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/taskdb";
    private static final String JDBC_USER = "task";
    private static final String JDBC_PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world application
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks")) {

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setTitle(resultSet.getString("title"));
                task.setDescription(resultSet.getString("description"));
                task.setStatus(resultSet.getString("status"));
                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world application
        }

        return tasks;
    }

    public Task getTaskById(Long id) {
        Task task = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE id = ?")) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    task = new Task();
                    task.setId(resultSet.getLong("id"));
                    task.setTitle(resultSet.getString("title"));
                    task.setDescription(resultSet.getString("description"));
                    task.setStatus(resultSet.getString("status"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world application
        }

        return task;
    }

    public Task createTask(Task task) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO tasks (title, description, status) VALUES (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getStatus());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating task failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    task.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating task failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world application
        }

        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE tasks SET title=?, description=?, status=? WHERE id=?")) {

            statement.setString(1, updatedTask.getTitle());
            statement.setString(2, updatedTask.getDescription());
            statement.setString(3, updatedTask.getStatus());
            statement.setLong(4, id);

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating task failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world application
        }

        return updatedTask;
    }

    public void deleteTask(Long id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM tasks WHERE id=?")) {

            statement.setLong(1, id);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Deleting task failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in a real-world application
        }
    }

    // Other database-related methods
}
