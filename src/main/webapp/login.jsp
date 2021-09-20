<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2021/9/19
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form action="/LoginServlet" method="post">
    Name: <input type="text" name = "name">
    Password: <input type="text" name = "password">
    <input type="submit">
</form>
</body>
</html>
