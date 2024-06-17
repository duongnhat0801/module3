<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/6/2024
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Nhập thông tin khách hàng</h4>
                <form action="/admin/orders/update" method="post">
                    <input type="hidden" name="id" value="${order.id}">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="tên" name="name" value="${order.orderAddress.name}">
                        <label for="name" class="form-label">Họ và tên</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="address" placeholder="địa chỉ" name="address" value="${order.orderAddress.address}">
                        <label for="address" class="form-label">Địa chỉ</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="email" placeholder="mail" name="email" value="${order.orderAddress.email}">
                        <label for="email" class="form-label">Email</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="numberPhone" placeholder="số điện thoại" name="numberPhone" value="${order.orderAddress.phoneNumber}">
                        <label for="numberPhone" class="form-label">Số điện thoại</label>
                    </div>
                    <div class="d-grid gap-2 mt-3">
                        <button type="submit" class="btn btn-primary btn-lg" >Lưu</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-6">
            <form action="">
                aaaaaaaaaaaaaaaa
            </form>
        </div>
    </div>


</div>
</body>
</html>
