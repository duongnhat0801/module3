<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/21/2024
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2>Student List</h2>
<table class="table">
    <tr>
        <th scope="col">Mã Học Viên</th>
        <th scope="col">Tên Học Viên</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Điểm</th>
        <th scope="col">Xếp loại</th>
    </tr>

 <c:forEach var="student" items="${students}">
     <tr>
         <td>${student.id}</td>
         <td>${student.name}</td>
         <td>${student.gender}</td>
         <td>${student.score}</td>
         <td>${student.getGrade()}
         </td>
     </tr>
 </c:forEach>
</table>
</body>
</html>
