<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/6/2024
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="/students/create" method="post">
<div class=" container">
    Tên <input type="text" id="name" name="name">
    Email <input type="text" id=" email" name="email">
    Phone <input type="text" id="phone" name="phone">
    <button>Submit</button>
</div>
</form>
</body>
</html>
