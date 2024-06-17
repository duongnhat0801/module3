<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2024
  Time: 11:22 PM
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
            <c:if test="${err!=null}" >
                <c:forEach var="err" items="${err}" >
                    <p>${err}</p>
                </c:forEach>
            </c:if>
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Nhập thông tin nhân sự</h4>
                <form action="/admin/users/create" method="post">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="name" placeholder="tên" name="name">
                        <label for="name" class="form-label">Tên</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="email" placeholder="email" name="email">
                        <label for="description" class="form-label">email</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="password" placeholder="password" name="password">
                        <label for="description" class="form-label">password</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="otp_code" placeholder="otp_code" name="otp_code">
                        <label for="otp_code" class="form-label">otp_code</label>
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
