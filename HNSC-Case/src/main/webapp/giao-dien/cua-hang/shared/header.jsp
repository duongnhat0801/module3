<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
      integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm ">
    <div class="container-fluid">
        <img src="/image/HNSC.png" alt="" style="width: 100px;">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item ">
                    <a class="nav-link active fw-bold" aria-current="page" href="/">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="/store/products/list">Tất cả sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="/login">Đăng nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-bold" href="/history">Lịch sử đặt hàng</a>
                </li>
            </ul>
            <form class="d-flex pe-3 text-nowrap">
                <input class="form-control me-2" type="search" placeholder="Tìm Kiếm" aria-label="Search">
                <button class="btn btn-outline-success fw-bold" type="submit">Tìm kiếm</button>

                <button type="button" class="btn btn-primary position-relative ms-2 ">
                    <i class="fa-solid fa-cart-shopping "></i>
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                        99+
                        <span class="visually-hidden">unread messages</span>
                    </span>
                </button>
            </form>
        </div>
    </div>
</nav>


</body>


























