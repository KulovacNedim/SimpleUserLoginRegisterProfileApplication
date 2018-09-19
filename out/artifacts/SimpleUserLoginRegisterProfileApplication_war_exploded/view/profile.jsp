
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<%@ include file="headContent.jsp"%>
	</head>

	<body>
		<div class="container">		  
		 	<div class="row">
			    <div class="col-sm-12" style="">
			    	<h1>User profile</h1>
			    </div>
		 	</div>
		 	<br>
	 		<div class="row">
	 			<div class="col-sm-12">
	 				<div class="alert alert-info  ${passwordChanged==null ? 'hidden' : 'show'}"">
					    <strong>Info:</strong> <c:out value = "${passwordChanged}"/>
					</div>

	 				<ul class="nav nav-pills" role="tablist">
					    <c:if test = "${user.role.id == 1}"><li><a href="/listusers">List users</a></li></c:if>
					    <li><a href="/editProfile"> Edit your profile</a></li>
					    <li><a href="/deleteProfile">Delete your profile</a>
					    <li><a href="/logout">Logout</a></li>        
					</ul>
	 			</div>
	 			<br><br>
	 		</div>
	 		<div  clas="row">
	 			<div class="table-responsive col-sm-8">          
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
						        <td><c:out value = "${userToUpdate.firstName}"/></td>
					      	</tr>
					      	<tr>
						        <td>Last name:</td>
						        <td><c:out value = "${userToUpdate.lastName}"/></td>
					      	</tr>
					      	<tr>
						        <td>e-mail:</td>
						        <td><c:out value = "${userToUpdate.email}"/></td>
					      	</tr>
					      	<tr>
						        <td>Street:</td>
						        <td><c:out value = "${userToUpdate.address.street}"/></td>
					      	</tr>
					      	<tr>
						        <td>City:</td>
						        <td><c:out value = "${userToUpdate.address.city}"/></td>
					      	</tr>
					      	<tr>
						        <td>Role:</td>
						        <td><c:out value = "${userToUpdate.role.roleName}"/></td>
					      	</tr>
					    </tbody>
					</table>
				  </div>
			</div>
		</div>
	</body>
</html>
