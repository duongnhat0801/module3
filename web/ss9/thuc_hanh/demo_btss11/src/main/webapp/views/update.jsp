<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/book/update" method="post">
        <input type="hidden" id="id" name="id" value="${book.id}">
        Title: <input type="text" id="title" name="title" value="${book.title}">
        PageSize: <input type="text" id="pageSize" name="pageSize" value="${book.pageSize}">
        Author: <input type="text" id="author" name="author" value="${book.author}">
        Category: <input type="text" id="category" name="category" value="${book.category}">
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>



