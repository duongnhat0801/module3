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
    <div class="bg-white">
        <div class="d-flex justify-content-between border-bottom px-3 py-2 align-items-center">
            <h6 class="text-decoration-none text-secondary mb-0 ">Tất cả sản phẩm</h6>
            <div>
                <a class="btn btn-sm btn-primary px-4"  href="/admin/orders/create">Thêm đơn hàng mới</a>
            </div>
        </div>

        <div class="p-3 ">
            <div class="row justify-content-end">

                <div class="col-5">
                    <form action="" class="d-flex">
                        <input class="form-control form-control-sm" type="text" name="keyword" placeholder="Tìm kiếm theo tên đơn hàng"
                               aria-label=".form-control-sm example">
                        <button class="btn btn-outline-primary ms-3" >Tìm</button>
                    </form>
                </div>

            </div>
        </div>
        <div class="px-3 pb-2">
            <table class="table text-center">
                <thead class="table-light">
                <tr>
                    <th>Số thứ tự</th>
                    <th>Tên khách hàng</th>
                    <th>Địa chỉ</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Mã đơn hàng</th>
                    <th>Tổng</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${order.orderAddress.name}</td>
                        <td>${order.orderAddress.address}</td>
                        <td>${order.orderAddress.email}</td>
                        <td>${order.orderAddress.phoneNumber}</td>
                        <td>${order.number}</td>
                        <td>${order.total}</td>
                        <td>
                            <a href="#" class="btn btn-sm btn-outline-danger">Xoá</a>
                            <a href="#" class="btn btn-sm btn-outline-primary ms-1">Sửa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="...">
                <ul class="pagination pagination-sm justify-content-center">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link">1</span>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
