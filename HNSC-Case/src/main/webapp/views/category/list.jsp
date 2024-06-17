<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/4/2024
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body class="bg-body-tertiary">

<%@include file="/views/shared/menu.jsp" %>

<div class="container mt-5 ">
    <div>
        <div class="d-flex justify-content-between bg-white p-3 shadow-sm align-items-center mb-3">
            <h6 class="text-decoration-none text-secondary mb-0 ">Phân loại sản phẩm</h6>
            <div>
                <a class="btn btn-sm btn-primary px-4" href="/admin/categories/create">Thêm Phân loại</a>
            </div>
        </div>
        <div class="p-3 bg-white shadow-sm">
            <table class="table table-bordered align-middle">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Ảnh</th>
                        <th>Tên</th>
                        <th>Mô tả</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="category" items="${categories}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>
                            <img src="${category.avatar}" class="img-fluid" style="width: 40px;">
                        </td>
                        <td>${category.name}</td>

                        <td>${category.description}</td>
                        <td>

                            <a href="/admin/categories/update?id=${category.id}" class="btn btn-sm btn-outline-primary ms-1">
                                <i class="fa-solid fa-pen-to-square"></i>Sửa
                            </a>
                            <a href="/admin/categories/delete?id=${category.id}" class="btn btn-sm btn-outline-danger" >
                                <i class="fa-solid fa-trash"></i> Xoá
                            </a>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
