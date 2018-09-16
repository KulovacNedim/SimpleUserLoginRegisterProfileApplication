
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>In order to change password, you have to confirm new password. </p>

<p>Note: all other infos are already updated. </p>

<form action="saveNewPassword" method="post" class="form">
						 
	<label>Please re-enter new password: </label>
	<input type="password" name="password" id="passReg" title="Must contain at least 8 or more characters"  pattern=".{8,}" required><br /> <br />
	<input class="button" type="submit" value="Save new password">

</form>


cancel

</body>
</html>
