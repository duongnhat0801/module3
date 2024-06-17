<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vansy
  Date: 3/6/24
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<div class="container my-3">

    <div class="row">
        <div class="col-8">
            <img src="https://hcm.fstorage.vn/images/2024/06/240515_sub-banner_867x400-egg-copy-20240603015608.jpg"
                 alt="" class="h-100 img-fluid object-fit-cover">
        </div>
        <div class="col-4 d-flex flex-column p-0">
            <div class="mb-2">
                <img src="https://hcm.fstorage.vn/images/2023/02/867x400_web.jpg" alt="" class="img-fluid">
            </div>
            <div>
                <img src="https://hcm.fstorage.vn/images/2023/05/614x397_online-01-1--20230505011530.jpg" alt=""
                     class="img-fluid">
            </div>
        </div>
    </div>
    <div class="mt-5">
    <div class="row">
        <c:forEach items="${categories}" var="category">
            <div class="col-4 mb-2">
                <a href="/store/categories/show?id=${category.id}" class="text-dark text-decoration-none shadow-sm bg-white rounded-2 p-3 d-flex align-items-center">
                    <div>
                        <img src="${category.avatar}" class="rounded-circle object-fit-cover" style="width: 80px; height: 80px;">
                    </div>
                    <div class="ms-2">
                        <h6>${category.name}</h6>
                        <p class="mb-0"><small>${category.description}</small></p>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
    <div class="mt-5">
        <div class="p-3 rounded bg-white mb-2">
            <h4 class="mb-0">Sản phẩm mới</h4>
        </div>
        <div>
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-3 mb-3">
                        <div class="card border-0 shadow-sm">
                            <img src="${product.avatar}"
                                 class="card-img-top">
                            <div class="card-body">
                                <h6 class="card-title mb-1"><a href="/store/products/show?id=${product.id}" class="text-dark text-decoration-none">${product.name}</a></h6>
                                <div class="d-flex align-items-end">
                                    <p class="mb-0 me-3 fs-5 fw-bold text-primary">${product.price}</p>
                                    <p class="mb-0 text-decoration-line-through"><small>${product.costPrice}</small></p>
                                </div>
                                <div class="d-grid mt-4">
                                    <a href="/store/add_cart?product_id=?${product.id}" class="btn btn-outline-primary">
                                        <i class="fa-solid fa-cart-plus me-2"></i>Thêm vào giỏ hàng
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>

<script src="${pageContext.request.contextPath}/js/coundown.js"></script>
</body>
</html>