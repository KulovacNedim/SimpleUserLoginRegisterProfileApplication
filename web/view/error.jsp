<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" isErrorPage="true"%>
<html>
	<head>
	    <%@ include file="headContent.jsp"%>
	  </head>
	<body>
		<div class="container">
			<div class="row">
				<h1>Error page</h1>
			</div>

			<div class="row">
				<br><br>
				<p> ${errorMessage}</p>
			</div>

			<div class="row">
				<br><br>
				<a href="/profile"><p>Go to home page</p></a>
			</div>
		</div>
	</body>
</html>