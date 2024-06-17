<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/5/2024
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Sửa sản phẩm</h4>
                <form method="post" action="/admin/products/update">
                    <input type="hidden" value="${product.id}" name="id">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" value="${product.sku}" id="sku" placeholder="Nhập Sku mới" name="sku">
                        <label for="sku" class="form-label">Nhập Sku mới</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" value="${product.name}" id="name" placeholder="Nhập tên sản phẩm mới" name="name">
                        <label for="name" class="form-label">Nhập tên sản phẩm mới</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" value="${product.price}" id="price" placeholder="Nhập giá mới" name="price">
                        <label for="price" class="form-label">Nhập giá mới</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" value="${product.description}" id="description" placeholder="Nhập mô tả mới" name="description">
                        <label for="description" class="form-label">Nhập mô tả mới</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" value="${product.costPrice}" id="cost_price" placeholder="Nhập giá gốc mới" name="cost_price">
                        <label for="cost_price" class="form-label">Nhập giá gốc</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" value="${product.quantity}" id="quantity" placeholder="Nhập số lượng mới" name="quantity">
                        <label for="quantity" class="form-label">Nhập số lượng mới</label>
                    </div>

                    <div class="input-group mb-3">
                        <label class="input-group-text" for="imageInput">Upload</label>
                        <input type="file" class="form-control" id="imageInput">
                    </div>
                    <div id="previewContainer">
                        <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar" value="${category.avatar}">
                        <img id="imagePreview" src="${product.avatar}" class="img-fluid" alt="Image Preview">
                    </div>
                    <select class="form-select form-select-lg mb-3" name="category_id">
                        <c:forEach var="item" items="${categories}">
                            <option ${product.categoryId == item.id ? "selected" : ""} value="${item.id}">${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg">Lưu</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/views/shared/footer.jsp" %>

</body>
</html>
