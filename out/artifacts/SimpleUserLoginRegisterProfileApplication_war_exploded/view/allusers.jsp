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
			    	<h1>All users list</h1>
			    </div>
		 	</div>

		 	<br>

		 	<div class="row">
			    <div class="col-sm-12" style="">
			    	<div class="table-responsive">          
						<table class="table">
						    <thead>
							    <tr>
							        <th>First name</th>
							        <th>Last name</th>
							        <th>e-mail</th>
							        <th>Street</th>
							        <th>City</th>
							        <th>Role</th>
							        <th></th>
							        <th></th>
							    </tr>
						    </thead>

							<tbody>
							    <c:forEach items="${users}" var="user">
							    	<tr>
								        <td>${user.firstName}</td>
								        <td>${user.lastName}</td>
								        <td>${user.email}</td>
								        <td>${user.address.street}</td>
								        <td>${user.address.city}</td>
								        <td>${user.role.roleName}</td>
								        <td><a href="deleteProfile?userid=${user.id}">Delete</a></td>
								        <td><a href="editProfile?userid=${user.id}">Edit</a></td>
							      	</tr>
								</c:forEach>

						    
						      	
						    </tbody>
						</table>
					  </div>

					  <a href="/profile"><button class="btn btn-default" style="margin-top: 10px;">Cancel</button></a>
			    </div>
		 	</div>
		 </div>
	
	</body>
</html>
