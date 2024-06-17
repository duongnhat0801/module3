
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<div class="container">
    <div class="row bg-white p-3 my-4 rounded">
        <div class="col-5">
            <img src="${product.avatar}" class="img-fluid" alt="">
        </div>
        <div class="col-7">
            <div>
                <h3>${product.name}</h3>
                <h1 class="text-danger">${product.price}</h1>
                <p>Số lượng:</p>
                <div class="mb-3">
                    <div class="d-flex">
                        <button class="btn btn-secondary rounded-end-0 border-end-0 btn-minus">-</button>
                        <input type="text" id ="number" class="form-control rounded-0 border-secondary text-center" style="width: 70px;" value="1">
                        <button class="btn btn-secondary rounded-start-0 border-start-0 btn-plus">+</button>
                    </div>
                </div>
                <div class="mb-3">
                    <button type="button" class="btn btn-outline-success"><i class="fa-solid fa-cart-shopping"></i> Thêm vào giỏ hàng</button>
                    <button type="button" class="btn btn-danger px-4">Mua ngay</button>
                </div>
                <div class="mb-3">
                    <b>Thông tin chi tiết:</b>
                    ${product.description}
                       </div>
            </div>
        </div>


    </div>

</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>

</body>

</html>