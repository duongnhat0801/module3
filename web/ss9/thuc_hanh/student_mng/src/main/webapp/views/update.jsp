<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/6/2024
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class = container>
    <form action="/students/update" method="post">
        <input type="hidden" id="id" name="id" value="${student.id}">
        Tên <input type="text" id="name" name="name" value="${student.name}">
        Email <input type="text" id="email" name="email" value="${student.email}">
        Phone <input type="text" id="phone" name="phone" value = "${student.phone}">
        <button>Submit</button>
    </form>
</div>
</body>
</html>
