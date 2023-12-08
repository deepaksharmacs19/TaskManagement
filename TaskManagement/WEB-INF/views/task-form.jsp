<%@ include file="layout.jsp" %>
<div class="container">
    <h2 class="header-text">Create New Task</h2>
    <form action="/TaskManagement/tasks" method="post" class="task-form">
        <!-- Form fields for title, description, and status -->
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-control" required></textarea>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status" class="form-control" required>
                <option value="To Do">To Do</option>
                <option value="In Progress">In Progress</option>
                <option value="Done">Done</option>
            </select>
        </div>
        <button type="submit" class="btn create-button">Create Task</button>
    </form>
</div>

<style>
    .header-text {
        color: #333;
        text-align: center;
    }

    .task-form {
        max-width: 400px;
        margin: 0 auto;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-control {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
    }

    .create-button {
        background-color: #007BFF;
        color: #fff;
        border: none;
        padding: 10px;
        cursor: pointer;
    }

    .create-button:hover {
        background-color: #0056b3;
    }
</style>
