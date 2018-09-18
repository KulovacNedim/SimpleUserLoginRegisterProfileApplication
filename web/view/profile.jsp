
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
	<h1>User profile</h1>

	<c:if test = "${user.role.id == 1}">
         <p><a href="/listusers">List all users</a><p>
     </c:if>



		<p><a href="/editProfile"> Edit informations</a></p>
		<p><a href="/deleteProfile">Delete my profile</a></p>
		<p><a href="/logout">Log out</a></p>
	</div>


<c:out value = "${passwordChanged}"/>

<p>User info</p>

<c:out value = "${user.firstName}"/><br />
<c:out value = "${user.lastName}"/><br />
<c:out value = "${user.email}"/><br />
<c:out value = "${user.address.street}"/><br />
<c:out value = "${user.address.city}"/><br />
<c:out value = "${user.role.roleName}"/><br />

</body>
</html>
