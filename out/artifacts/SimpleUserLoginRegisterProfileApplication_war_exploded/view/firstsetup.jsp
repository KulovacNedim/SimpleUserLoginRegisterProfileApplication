<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>One more step...</h1>

<p>You are registered. Please edit your profile.</p>

<p>Add your info</p>

<form action="update" method="post" class="form">
		
		<label>First name: </label> 
		<input type="text" name="firstName" id="firstName" value="<c:out value = "${user.firstName}"/>"  autofocus><br>
			
		<label>Last name: </label> 
		<input type="text" name="lastName" id="lastName" value="<c:out value = "${user.lastName}"/>"><br>

		<label>email: </label> 
		<input type="text" name="email" id="email" value="<c:out value = "${user.email}"/>"><br>

		<label>Password: </label> 
		<input type="text" name="password" id="password" value="<c:out value = "${user.password}"/>"><br>

		<label>Street: </label> 
		<input type="text" name="street" id="street" value="<c:out value = "${user.address.street}"/>"><br>

		<label>City: </label> 
		<input type="text" name="city" id="city" value="<c:out value = "${user.address.city}"/>"><br>

		<label>Role: </label> 
		<input type="text" name="roleName" id="roleName" value="<c:out value = "${user.role.roleName}"/>" disabled><br>

		<br /> <br />
		<input class="button" type="submit" value="Save info">

	</form>
</body>
</html>
