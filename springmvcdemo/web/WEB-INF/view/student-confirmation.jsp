<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 05.01.2020
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
<br><br>
Favorite language: ${student.favoriteLanguage}
<br><br>
Operating Systems:
<ul>
    <forEach var="temp" items="${student.operatingSystems}"
    <li>${temp}</li>
</ul>
</body>
</html>
