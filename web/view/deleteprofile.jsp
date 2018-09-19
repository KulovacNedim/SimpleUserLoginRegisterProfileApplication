<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	    <%@ include file="headContent.jsp"%>
	</head>

	<body>

		<div class="container">
			<div class="row">
			    <div class="col-sm-12" style="">
			    	<h1>Delete user profile?</h1>
			    </div>
		 	</div>

		 	<br>

		 	<div class="row">
			    <div class="col-sm-12" style="">
			    	<table class="table">
					    <thead>
						    <tr>
						        <th>User info</th>
						        <th></th>
						    </tr>
					    </thead>
					    <tbody>
					      	<tr>
						        <td>First name:</td>
						        <td><c:out value = "${userToDelete.firstName}"/></td>
					      	</tr>
					      	<tr>
						        <td>Last name:</td>
						        <td><c:out value = "${userToDelete.lastName}"/></td>
					      	</tr>
					      	<tr>
						        <td>e-mail:</td>
						        <td><c:out value = "${userToDelete.email}"/></td>
					      	</tr>
					      	<tr>
						        <td>Street:</td>
						        <td><c:out value = "${userToDelete.address.street}"/></td>
					      	</tr>
					      	<tr>
						        <td>City:</td>
						        <td><c:out value = "${userToDelete.address.city}"/></td>
					      	</tr>
					      	<tr>
						        <td>Role:</td>
						        <td><c:out value = "${userToDelete.role.roleName}"/></td>
					      	</tr>
					    </tbody>
					</table>
			    </div>
		 	</div>

		 	<div class="row">
			    <div class="col-sm-12" style="">
			    	<form action="deleteProfile" method="post" class="form">

						<input type="text" name="userToDelete" id="userToDelete" value="${userToDelete.email}" hidden>
							       
						<button type="submit" class="btn btn-default">Delete profile</button>
					</form>
					<br>
					<a href="/profile"><button class="btn btn-default" style="float: left;">Cancel</button></a>
			    </div>
			</div>

		</div>
	</body>
</html>
