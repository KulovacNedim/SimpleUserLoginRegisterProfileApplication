<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.09.2018.
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${users}" var="item">
    ${item.toString()} <a href="deleteProfile?userid=${item.id}">Delete</a>
   <a href="editProfile?userid=${item.id}">Edit</a> <br>
</c:forEach>

</body>
</html>
