<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>luv2code Home Page</title>
</head>
<body>
Welcome to the luv2code company home page ! - Yoohoo !
<form:form action="${pageContext.request.contextPath }/logout"
           method="POST">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
