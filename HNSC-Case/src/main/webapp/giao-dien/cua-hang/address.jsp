
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Nhập địa chỉ giao hàng</h4>
                <form>
                    <div class="mb-3 form-floating">
                        <input type="email" class="form-control" id="name" placeholder="Họ và tên">
                        <label for="name" class="form-label">Họ và tên</label>
                    </div>

                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="phone" placeholder="Số điện thoại ">
                        <label for="phone" class="form-label">Số điện thoại</label>

                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="email" placeholder="Email">
                        <label for="email" class="form-label">Email</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="address" placeholder="Địa chỉ">
                        <label for="address" class="form-label">Địa chỉ</label>
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg">Đặt Hàng</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>
</body>
</html>

