<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Login register page</title>

<style>

/* The message box is shown when the user clicks on the password field */
#message {
    display:none;

}

</style>

</head>
<body>
	<div id="container">
		
		<div class="left-box">
		
			<form action="login" method="post" class="form">
							
				<label>Enter username: </label> 
				<input type="email" name="email" id="email" required autofocus> <br />
			  
				<label>Enter password: </label>
				<input type="password" name="password" id="password" required><br /> <br />
			  
				<input class="button" type="submit" value="Login">
			 
			</form>
			
			<c:out value = "${wrongCredentials}"/>
	</div>
		
		<div class="right-box">
			<form action="register" method="post" class="form">
						 
				<label>Enter email: </label> 
				<input type="email" name="email" id="email" required autofocus>
				 
				<label>Enter password: </label>
				<input type="password" name="password" id="passReg" title="Must contain at least 8 or more characters"  pattern=".{8,}" required><br /> <br />
				<input class="button" type="submit" value="Register">

			</form>

			<c:out value = "${existingEmail}"/>

			
			<div id="message">
			  <p id="length">Minimum <b>8 characters</b></p>
			</div>
			

		</div>
	</div>
<script>
var myInput = document.getElementById("passReg");
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