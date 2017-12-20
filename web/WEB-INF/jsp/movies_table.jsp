<%--
  Created by IntelliJ IDEA.
  User: Seregy
  Date: 17.03.2017
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Movies</title>
    <style type="text/css">
        body {
            background-image: url('https://crunchify.com/bg.png');
        }
        * {
            box-sizing: border-box;
        }

        table {
            border-collapse: collapse;
            color: #000000;
            text-align: left;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }

        table th {
            color: #FFFFFF;
            background-color: #2E51A2;
        }

        tr:nth-child(odd) {
            background-color: #F6F6F6;
        }

        td:nth-last-child(-n+2) {
            text-align: center;
        }


    </style>

</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Sessions</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.getId()}</td>
            <td>${movie.getName()}</td>
            <td>
                <c:forEach items="${movie.getSessions()}" var="session">
                    <p>${session}</p>
                </c:forEach>
            </td>
            <td><button class="delete" data-value="${movie.getId()}">Remove</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>