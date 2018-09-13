<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Login register page</title>
</head>
<body>
	<div id="container">
		
		<div class="box1">
		
			<form action="login" method="post" class="form">
							
				<label>Enter username: </label> 
				<input type="text" name="email" id="email" autofocus> <br />
			  
				<label>Enter password: </label>
				<input type="password" name="password" id="password"><br /> <br />
			  
				<input class="button" type="submit" value="Login">
			 
			</form>
			
			<p>loginErrorMessage</p>
	</div>
		
		<div class="box2">
			<form action="register" method="post" class="form">
						 
				<label>Enter email: </label> 
				<input type="text" name="email" id="email" value="<%= request.getAttribute("email") == null ? "" : request.getAttribute("email")%>"  autofocus>
				 
				<label>Enter password: </label>
				<input type="password" name="password" id="password"  value="<%= request.getAttribute("password") == null ? "" : request.getAttribute("password")%>"><br /> <br />
				<input class="button" type="submit" value="Register">

			</form>
		</div>
	</div>

</body>
</html>