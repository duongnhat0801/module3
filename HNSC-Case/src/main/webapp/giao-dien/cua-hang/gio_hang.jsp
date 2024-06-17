<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/4/2024
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>

<div class="container py-4">
    <div class="row ">
        <div class="col-8">
            <div class="p-3 rounded bg-white">
                <div class="d-flex border-bottom mb-3">
                    <div class="w-25">
                        <img src="https://media3.scdn.vn/img4/2021/02_02/JikA6AqzCC55LcNmcHjZ.png" class="img-fluid">
                    </div>
                    <div class="flex-grow-1">
                        <div class="d-flex justify-content-between">
                            <p>Tên sản phẩm</p>
                            <a href="#">
                                <button type="button" class="btn btn-primary position-relative ms-2 ">
                                    <i class="fa-regular fa-trash-can"></i>
                                </button>
                            </a>
                        </div>
                        <div>
                            <p>Mô tả</p>
                        </div>
                        <div>
                            <p>Nơi sản xuất</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>Giá</p>
                            <div class="mb-3">
                                <div class="d-flex">
                                    <button class="btn btn-secondary rounded-end-0 border-end-0 btn-minus">-
                                    </button>
                                    <input id="numbers" type="text"
                                           class="form-control rounded-0 border-secondary text-center"
                                           style="width: 50px;" value="1">
                                    <button class="btn btn-secondary rounded-start-0 border-start-0 btn-plus">
                                        +
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="d-flex border-bottom mb-3">
                    <div class="w-25">
                        <img src="https://media3.scdn.vn/img4/2021/02_02/JikA6AqzCC55LcNmcHjZ.png" class="img-fluid">
                    </div>
                    <div class="flex-grow-1">
                        <div class="d-flex justify-content-between">
                            <p>Tên sản phẩm</p>
                            <a href="#">
                                <button type="button" class="btn btn-primary position-relative ms-2 ">
                                    <i class="fa-regular fa-trash-can"></i>
                                </button>
                            </a>

                        </div>
                        <div>
                            <p>Mô tả</p>
                        </div>
                        <div>
                            <p>Nơi sản xuất</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>Giá</p>
                            <div class="mb-3">
                                <div class="d-flex">
                                    <button class="btn btn-secondary rounded-end-0 border-end-0 btn-minus">-
                                    </button>
                                    <input type="text"
                                           class="form-control rounded-0 border-secondary text-center"
                                           style="width: 50px;" value="1">
                                    <button class="btn btn-secondary rounded-start-0 border-start-0 btn-plus">
                                        +
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-4">
            <div class="p-3 rounded bg-white">
                <h2>Order Summary</h2>
                <div class="d-flex border-bottom mb-2">


                    <div class="flex-grow-1">
                        <div class="d-flex justify-content-between">
                            <p>Subtotal</p>
                            <p>....</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>Mô tả</p>
                            <p>....</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>Nơi sản xuất</p>
                            <p>....</p>
                        </div>
                        <div class="d-flex justify-content-between">
                            <p>Giá</p>
                            <div class="mb-3">
                                <div class="d-flex">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>

</body>
</html>
