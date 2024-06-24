<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/20/2024
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Tên</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Điểm số</th>
        <th scope="col">Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hocvien" items="${hocviens}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${hocvien.name}</td>
            <td>${hocvien.gender}</td>
            <td>${hocvien.score}</td>
        </tr>
    </c:forEach>;
    </tbody>
</table>
</body>
</html>
