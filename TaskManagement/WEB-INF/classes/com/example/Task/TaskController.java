package com.example.Task;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class TaskController extends HttpServlet {

    private TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            // Display task list
            List<Task> tasks = taskService.getAllTasks();
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("/WEB-INF/views/task-list.jsp").forward(request, response);
        } else if (pathInfo.startsWith("/new")) {
            // Display task creation form
            request.getRequestDispatcher("/WEB-INF/views/task-form.jsp").forward(request, response);
        } else {
            // Display individual task details
            String taskIdStr = pathInfo.substring(1);
            try {
                Long taskId = Long.parseLong(taskIdStr);
                Task task = taskService.getTaskById(taskId);
                if (task != null) {
                    request.setAttribute("task", task);
                    request.getRequestDispatcher("/WEB-INF/views/task-details.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle task creation
    String pathInfo = request.getPathInfo();
System.out.println(pathInfo);
        if (pathInfo!=null && pathInfo.startsWith("/delete/")) {
//String id=request.getParameter("id");
System.out.println("In if");
doDelete(request,response);
return;
}
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
System.out.println("Again in Post");
        if (title != null && !title.isEmpty()) {
            Task newTask = new Task();
            newTask.setTitle(title);
            newTask.setDescription(description);
            newTask.setStatus(status);
            taskService.createTask(newTask);
            response.sendRedirect(request.getContextPath() + "/tasks");
        } else {
            // Display an error message (title is required)
            request.setAttribute("error", "Title is required");
            request.getRequestDispatcher("/WEB-INF/views/task-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
System.out.println("In delete");
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.startsWith("/delete/")) {
            String taskId = pathInfo.substring("/delete/".length());
            Long id = Long.parseLong(taskId);
            taskService.deleteTask(id);
request.getRequestDispatcher("/index.jsp").forward(request,response);
//            response.sendRedirect(request.getContextPath() + "/tasks");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL for delete operation");
        }
    }

}
