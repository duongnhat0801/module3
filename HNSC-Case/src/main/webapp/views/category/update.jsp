<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/5/2024
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>

<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <c:if test="${err!=null}" >
                <c:forEach var="err" items="${err}" >
                    <p>${err}</p>
                </c:forEach>
            </c:if>
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Nhập thông tin cần sửa</h4>
                <form action="/admin/categories/update" method="post">
                    <input type="hidden" name="id" value="${category.id}">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="tên" name="name" value="${category.name}">
                        <label for="name" class="form-label">Tên</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="description" placeholder="Mô tả" name="description" value="${category.description}">
                        <label for="description" class="form-label">Mô tả</label>
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="imageInput">Upload</label>
                        <input type="file" class="form-control" id="imageInput">
                    </div>
                    <div id="previewContainer">
                        <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar" value="${category.avatar}">
                        <img id="imagePreview" src="${category.avatar}" alt="Image Preview">
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg" >Lưu</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/views/shared/footer.jsp" %>

</body>
</html>
