<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<div class="container mb-3">
    <div class="text-primary py-2">
        <h2>${category.name}</h2>
    </div>
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
<div class="border-top-0 border-secondary  py-5 ">
    <div class="container">
        <div class="row text-center">
            <div class="col">
                <img src="https://cdn-crownx.winmart.vn/images/prod/162964655378716287682220181-1--og.png" alt="">
                <p class="mt-2"><b>Sản phẩm an toàn</b></p>
            </div>
            <div class="col">
                <img src="https://cdn-crownx.winmart.vn/images/prod/162964658411816287682628462-1--og.png" alt="">
                <p class="mt-2"><b>Chất lượng cam kết</b></p>
            </div>
            <div class="col">
                <img src="https://cdn-crownx.winmart.vn/images/prod/162964661464516287682943943-1--og.png" alt="">
                <p class="mt-2"><b>Dịch vụ vượt trội</b></p>
            </div>
            <div class="col">
                <img src="https://cdn-crownx.winmart.vn/images/prod/162964665580516292779811154-1--og.png" alt="">
                <p class="mt-2"><b>Giao hàng nhanh</b></p>
            </div>
        </div>
    </div>
</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>
</body>
</html>