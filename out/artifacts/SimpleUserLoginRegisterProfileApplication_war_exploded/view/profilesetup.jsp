<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
    <title>Title</title>
</head>
<body>
<h1>One more step...</h1>

<p>You are registered. Please edit your profile.</p>

<p>Add your info</p>

<div class="left-box">

<form action="updateInfo" method="post" class="form">
		
		<label>First name: </label> 
		<input type="text" name="firstName" id="firstName" value="<c:out value = "${user.firstName}"/>" required autofocus><br>
			
		<label>Last name: </label> 
		<input type="text" name="lastName" id="lastName" value="<c:out value = "${user.lastName}"/>" required><br>

		<label>email: </label> 
		<input type="text" name="email" id="email" value="<c:out value = "${user.email}"/>" disabled><br>

		<label>Street: </label> 
		<input type="text" name="street" id="street" value="<c:out value = "${user.address.street}"/>" required><br>

		<label>City: </label> 
		<input type="text" name="city" id="city" value="<c:out value = "${user.address.city}"/>" required><br>

		<label>Role: </label> 
		<input type="text" name="roleName" id="roleName" value="<c:out value = "${user.role.roleName}"/>" disabled><br>

		<br /> <br />
		<input class="button" type="submit" value="Save info">

	</form>

</div>

<div class="right-box">

	<p>In order to chabge your password enter next inofrmations</p>


	<c:out value = "${wrongConfirmPassword}"/>


	<form action="updatePassword" method="post" class="form">
		
		<label>Enter current password: </label> 
		<input type="password" name="currentPassword" id="currentPassword" value="" required autofocus><br>
			
		<label>Enter new password: </label> 
		<input type="password" name="newPassword" id="newPassword" value="" title="Must contain at least 8 or more characters"  pattern=".{8,}" required><br>

		<br /> <br />
		<input class="button" type="submit" value="Change password">




	</form>

	<div id="message">
			  <p id="length">Minimum <b>8 characters</b></p>
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
