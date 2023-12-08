<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="layout.jsp" %>
<style>
    .container {
        max-width: 800px;
        margin: 0 auto;
    }

    h3 {
        color: #333;
    }

    label {
        margin-right: 10px;
        font-weight: bold;
    }

    select {
        padding: 5px;
        font-size: 14px;
    }

    table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    .btn-link {
        color: #007bff;
        cursor: pointer;
        border: none;
        background-color: transparent;
        padding: 0;
        text-decoration: underline;
    }

    .btn-link:hover {
        text-decoration: none;
    }

    .taskRow {
        transition: background-color 0.3s;
    }

    .taskRow:hover {
        background-color: #f5f5f5;
    }
</style>

<div class="container">
    <h3>Task List</h3>
<a href="<c:url value='/index.jsp' />" class="btn-link">Home</a>
<br>
    <label for="statusFilter">Sort by Status:</label>
    <select id="statusFilter" onchange="filterTasks()">
        <option value="all">All</option>
        <option value="To Do">To-Do</option>
        <option value="In Progress">In Progress</option>
        <option value="Done">Done</option>
    </select>

    <table class="table">
        <thead>
            <tr>
                <th>Title</th>
                <th>Details</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="task" items="${tasks}">
                <tr class="taskRow" data-status="${task.status}">
                    <td>${task.title}</td>
                    <td>
                        <a href="<c:url value='/tasks/${task.id}' />" class="btn-link">Details</a>
                    </td>
                    <form action="<c:url value='/tasks/delete/${task.id}' />" method="post" id="deleteForm"
                        style="display: inline;">
                        <input type="hidden" name="_method" value="DELETE" />
                        <td><button type="submit" class="btn-link"
                                onclick="return confirm('Are you sure you want to delete this task?')">Delete</button>
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function filterTasks() {
        var selectedStatus = document.getElementById("statusFilter").value;
        var taskRows = document.getElementsByClassName("taskRow");

        for (var i = 0; i < taskRows.length; i++) {
            var taskStatus = taskRows[i].getAttribute("data-status");

            if (selectedStatus === "all" || selectedStatus === taskStatus) {
                taskRows[i].style.display = "table-row";
            } else {
                taskRows[i].style.display = "none";
            }
        }
    }
</script>


