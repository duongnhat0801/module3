<%--
  Created by IntelliJ IDEA.
  User: vansy
  Date: 5/6/24
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">HNSC SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/admin/categories/list">
                        <i class="fa-solid fa-layer-group"></i>
                        Phân Loại
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/products/list">
                        <i class="fa-solid fa-cube"></i>
                        Sản Phẩm
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/orders/list">
                        <i class="fa-solid fa-pizza-slice"></i>
                        Đơn Hàng
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/users/list">
                        <i class="fa-solid fa-users"></i>
                        Nhân sự
                    </a>
                </li>
            </ul>
            <a href="/logout" class="btn btn-dark">
                Đăng xuất
                <i class="fa-solid fa-right-from-bracket"></i>
            </a>
        </div>
    </div>
</nav>