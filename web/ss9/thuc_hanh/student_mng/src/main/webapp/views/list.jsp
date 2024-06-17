<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/6/2024
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class=" container">
    <a href="/students/create">Thêm học sinh</a>
    <table class="table">
        <thead>

        <tr>
            <th >STT</th>
            <th >Tên</th>
            <th >Email</th>
            <th >Phone</th>
            <th>Chức năng</th>
        </tr>
        </thead>
        <tbody>
       <c:forEach var="st" items="${student}" varStatus="stt">
           <tr>
               <th>${stt.count}</th>
               <td>${st.name}</td>
               <td>${st.email}</td>
               <td>${st.phone}</td>
               <td><a href="/students/delete?id=${st.id}">Delete</a>
                   <a href="/students/update?id=${st.id}">Update</a>
               </td>
           </tr>
       </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
