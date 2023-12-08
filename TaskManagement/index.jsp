<%@ include file="\WEB-INF\views\layout.jsp" %>
<div class="container">
    <h2>Welcome to Task Management</h2>
    <p>Your go-to application for efficient task management.</p>

    <div class="cta-buttons">
        <a href="/TaskManagement/tasks/new" class="btn btn-primary">Create New Task</a>
        <a href="/TaskManagement/tasks" class="btn btn-secondary">Show All Tasks</a>
    </div>

    <hr/>

    <!-- Additional content or images can be added here -->

    <!-- Add a catchy image -->
    <img src="eden-constantino-iJg1YzsEfqo-unsplash.jpg" alt="Task Management Image" class="app-image">

    <!-- Add some additional information or features -->

</div>

<style>
    .container {
        text-align: center;
        margin-top: 50px;
    }

    h2 {
        color: #333;
    }

    p {
        color: #666;
        margin-bottom: 30px;
    }

    .cta-buttons {
        display: flex;
        justify-content: space-around;
        margin-bottom: 30px;
    }

    .btn {
        padding: 10px 20px;
        text-decoration: none;
        color: #fff;
        border-radius: 5px;
        cursor: pointer;
    }

    .btn-primary {
        background-color: #007bff;
    }

    .btn-secondary {
        background-color: #6c757d;
    }

    .app-image {
        width: 100%;
        max-width: 400px;
        margin-top: 30px;
    }
</style>
