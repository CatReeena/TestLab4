<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Spring MVC </title>
    <style type="text/css">
        body {
            background-image: url('https://crunchify.com/bg.png');
        }
    </style>
</head>
<body>

<c:forEach items="${supplierNames}" var="name">
    ${name}<br>
</c:forEach>


<c:forEach items="${requestScope.supplierNames}" var="item">
    ${item}<br>
</c:forEach>

${supplierNames}




<c:forEach items="${movies}" var="movie">

    <tr>
        <td>${movie.name}</td>
        <td>${movie.name}</td>
        <td><button class="delete" data-value="${cinema.name}">Remove</button></td>
    </tr>

</c:forEach>

<br>
<br>


</body>
</html>