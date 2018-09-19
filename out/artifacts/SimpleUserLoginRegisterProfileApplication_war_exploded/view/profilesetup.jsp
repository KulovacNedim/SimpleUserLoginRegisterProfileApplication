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
				<h1>One more step...</h1>
				<br><br>
				<div class="alert alert-info col-sm-5">
				    <p>Please edit your profile.</p>
				</div>
				<div class="col-sm-1">
				</div>
				<div class="alert alert-info col-sm-5">
				    <p>Change password section.</p>
				</div>
				<div class="col-sm-1">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<form  action="updateInfo" method="post">

						<input type="text" name="email" id="email" value="${userToEdit.email}" hidden/>


					    <div class="form-group">
					      <label for="firstName">First name: </label>
					      <input type="text" name="firstName" class="form-control" id="firstName" value="${userToEdit.firstName}" required autofocus>
					    </div>

					    <div class="form-group">
					      <label for="lastName">Last name: </label>
					      <input type="text" name="lastName" class="form-control" id="lastName" value="${userToEdit.lastName}" required>
					    </div>

					    <div class="form-group">
					      <label for="email">email: </label>
					      
					      <p>${userToEdit.email}</p>
					    </div>

					    <div class="form-group">
					      <label for="street">Street: </label>
					      <input type="text" name="street" class="form-control" id="street" value="${userToEdit.address.street}" required>
					    </div>

					    <div class="form-group">
					      <label for="city">City: </label>
					      <input type="text" name="city" class="form-control" id="city" value="${userToEdit.address.city}" required>
					    </div>

					    <div class="form-group ${user.role.id == 1 ? '' : 'hidden'}">
					    	<label for="roleId">Role: </label>
					    	<select class="form-control" name="roleId" id="roleId" >	
								<c:forEach items="${roles}" var="role" varStatus="loop">
									<option value="${role.id}" ${userToEdit.role.id == role.id ? 'selected' : ''} >${role.roleName}</option>
								</c:forEach>
							</select>
					    </div>

					    <br>

					    <button type="submit" class="btn btn-default">Save info</button>
				  	</form>

				  	<a href="/profile"><button class="btn btn-default">Cancel</button></a>

				</div>

				<div class="col-sm-1">
				</div>

				<div class="col-sm-5">
					<div class="alert alert-warning  ${wrongConfirmPassword==null ? 'hidden' : 'show'}"">
					    <strong>Warning!</strong> <c:out value = "${wrongConfirmPassword}"/>
					</div>

			    	<br>

					<form  action="updatePassword" method="post">

						<input type="text" name="hiddenEmail" id="hiddenEmail" value="${userToEdit.email}" hidden/>

					    <div class="form-group">
					      <label for="currentPassword">Enter current password: </label>
					      <input type="password" name="currentPassword" class="form-control" id="currentPassword" value="" required>
					    </div>

					    <div class="form-group">
					      <label for="newPassword">Enter new password: </label>
					      <input type="password" name="newPassword" class="form-control" id="newPassword" value="" title="Must contain at least 8 or more characters"  pattern=".{8,}" required>
					    </div>

					    <br>

					    <button type="submit" class="btn btn-default">Change password</button>

				  	</form>

				  	<br>

				  	<div class="alert alert-info" id="message">
					    <p class="text-primary" id="length"><strong>Info:</strong> Minimum <b>8 characters</b></p>
					</div>
				</div>
				<div class="col-sm-1">
				</div>
			</div>
		</div>

		<script>
			var myInput = document.getElementById("newPassword");
			var length = document.getElementById("length");

			// When the user starts to type something inside the password field
			myInput.onkeyup = function() {
			  // Validate length
			  if(myInput.value.length >= 8) {
			    document.getElementById("message").style.display = "none";
			  } else {
			    document.getElementById("message").style.display = "block";
			  }
			}
		</script>
	</body>
</html>
