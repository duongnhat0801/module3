<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/21/2024
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book/create" method="post">
<div class="container">
    <label>Title</label>
    <input type="text" name="title">
    <label>pageSize</label>
    <input type="text" name="pageSize">
    <label>Author</label>
    <input type="text" name="author">
    <label>Category</label>
    <input type="text" name="category">
    <button>Submit</button>
</div>
</form>
</body>
</html>
