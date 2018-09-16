<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>One more step...</h1>

<c:out value = "${regSucc}"/>

<p>Add your info</p>

<form action="updateInfo" method="post" class="form">
		
		<label>First name: </label> 
		<input type="text" name="firstName" id="firstName" value="<c:out value = "${user.firstName}"/>" required autofocus><br>
			
		<label>Last name: </label> 
		<input type="text" name="lastName" id="lastName" value="<c:out value = "${user.lastName}"/>" required><br>

		<label>email: </label> 
		<input type="text" name="email" id="email" value="<c:out value = "${user.email}"/>" disabled><br>

		<label>Password: </label> 
		<input type="text" name="password" id="password" value="<c:out value = "${user.password}"/>" required><br>

		<label>Street: </label> 
		<input type="text" name="street" id="street" value="<c:out value = "${user.address.street}"/>" required><br>

		<label>City: </label> 
		<input type="text" name="city" id="city" value="<c:out value = "${user.address.city}"/>" required><br>

		<label>Role: </label> 
		<input type="text" name="roleName" id="roleName" value="<c:out value = "${user.role.roleName}"/>" disabled><br>

		<br /> <br />
		<input class="button" type="submit" value="Save info">

	</form>
</body>
</html>
