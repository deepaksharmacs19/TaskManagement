# TaskManagement   

# Technology Stack:   

Java for backend logic.
JSP (JavaServer Pages) for dynamic web pages.
MySQL for data storage.
Apache Tomcat as the web server.


Key Components:  

TaskController.java:  

Handles HTTP requests related to tasks (creating, updating, deleting).
Invokes corresponding methods in TaskService based on user actions.

TaskDAO.java:  

Manages database interactions (CRUD operations) for tasks.
Uses JDBC (Java Database Connectivity) to connect to and query the MySQL database.

TaskService.java:  

Provides business logic related to tasks.
Utilizes TaskDAO for data access.

Task.java:  

Represents the Task entity with attributes like ID, title, description, and status.
JSP Files (task-form.jsp, task-details.jsp, task-list.jsp):

# Web Application Flow:  

User interacts with the web application by creating, updating, or deleting tasks.
TaskController processes the HTTP requests, delegates actions to TaskService.
TaskService interacts with TaskDAO to perform CRUD operations on the MySQL database.
JSP pages are used to render views, displaying task information.

# Additional Features:   

Basic form validation (e.g., ensuring the title is not empty).
Delete confirmation using JavaScript.
A simple navigation menu in index.jsp for creating new tasks and viewing all tasks.


# Prerequisites:
Java Development Kit (JDK):  

Make sure you have JDK installed on your machine. You can download it from Oracle's website.  

# Apache Tomcat:  

Download and install Apache Tomcat from the official Tomcat website.
  
MySQL Database:

Install and set up a MySQL database. Create a database for your application.

# Database Configuration:     

Open src/com/example/Task/TaskDAO.java.   

Update the JDBC_URL, JDBC_USER, and JDBC_PASSWORD variables with your MySQL database connection details.    

# Running the Application:  

Start Tomcat:  

Start the Tomcat server. Navigate to the Tomcat installation directory and run the startup script.  

# Access the Application:  

Open a web browser and go to http://localhost:8080/YourProject/ (replace YourProject with the name of your project).
