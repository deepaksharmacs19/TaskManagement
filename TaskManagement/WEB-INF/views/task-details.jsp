<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
        .container {
            text-align: center;
        }

        .task-details-table {
            border-collapse: collapse;
            width: 50%;
            margin: auto;
            margin-top: 20px;
        }

        .task-details-table, .task-details-table th, .task-details-table td {
            border: 1px solid black;
        }

        .task-details-table th, .task-details-table td {
            padding: 10px;
            text-align: left;
        }

        .additional-info-table {
            border-collapse: collapse;
            width: 50%;
            margin: auto;
            margin-top: 20px;
        }

        .additional-info-table, .additional-info-table th, .additional-info-table td {
            border: 1px solid black;
        }

        .additional-info-table th, .additional-info-table td {
            padding: 10px;
            text-align: left;
        }
    </style>


<%@ include file="layout.jsp" %>

<div class="container">
    <h2>Task Details</h2>
<a href='/TaskManagement/index.jsp' class="btn-link">Home</a>

    <c:if test="${not empty task}">
        <table class="task-details-table">
            <tr>
                <th class="label">Title:</th>
                <td>${task.title}</td>
            </tr>
            <tr>
                <th class="label">Description:</th>
                <td>${task.description}</td>
            </tr>
            <tr>
                <th class="label">Status:</th>
                <td>${task.status}</td>
            </tr>
        </table>

        </table>
    </c:if>
</div>

</body>
</html>
