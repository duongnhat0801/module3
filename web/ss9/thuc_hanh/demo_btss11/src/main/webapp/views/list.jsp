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
<div class = container1>
<form action="/book/search" method="GET" class="mt-3 mb-3">
    <div class="input-group">
        <input type="text" name="title" class="form-control" placeholder="Search by Title">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>
</div>
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
                <button class=" btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteBook${book.id}">Delete</button>
                <div class="modal fade" id="deleteBook${book.id}" tabindex="-1" aria-labelledby="deleteBookLabel${book.id}" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="deleteBookLabel${book.id}">Delete book</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có chắc chắn muốn xoá sách ${book.title}
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <a href="/book/delete?id=${book.id}" type="button" class="btn btn-primary">Confirm Delete</a>
                            </div>
                        </div>
                    </div>
                </div>

            </td>
        </tr>

    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
