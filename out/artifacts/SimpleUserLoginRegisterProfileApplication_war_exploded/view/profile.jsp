
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
moj profil
<c:out value = "${user.toString()}"/>

<c:out value = "${passwordChanged}"/>
</body>
</html>
