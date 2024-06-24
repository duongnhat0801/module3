<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h2>List Book</h2>
<a href="/book/create">Add Book</a>
<table class="table">
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Title</th>
        <th scope="col">pageSize</th>
        <th scope="col">Author</th>
        <th scope="col">Category</th>
        <th scope="col">Hành Động</th>
    </tr>
    <c:forEach var="book" items="${books}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td>${book.title}</td>
            <td>${book.pageSize}</td>
            <td>${book.author}</td>
            <td>${book.category}</td>
            <td>
                <a href="/book/update?id=${book.id}" class=" btn btn-success btn-sm">Update</a>
                <a href="/book/delete?id=${book.id}" class=" btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
