<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.09.2018.
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
	<h1>Delete profile?</h1>

	
<c:out value = "${user.firstName}"/><br />
		<c:out value = "${user.lastName}"/><br />
		<c:out value = "${user.email}"/><br />
		<c:out value = "${user.address.street}"/><br />
		<c:out value = "${user.address.city}"/><br />
		<c:out value = "${user.role.roleName}"/><br />
	<form action="deleteProfile" method="post" class="form">
		
		

		<br /> <br />

		<input class="button" type="submit" value="Delete profile">

	</form>
<a href="/profile"><button>Cancel</button></a>

</body>
</html>
