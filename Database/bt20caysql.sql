create database furama;
use furama;

create table loaikhach(
id int primary key auto_increment,
ten varchar(255) not null
);

create table vitri(
id int primary key auto_increment,
ten varchar(255) not null
);

create table bophan(
id int primary key auto_increment,
ten varchar(255) not null
);

create table trinhdo(
id int primary key auto_increment,
ten varchar(255) not null
);

create  table nhanvien(
id int primary key auto_increment,
hoten varchar(255) not null,
ngaysinh date,
soCMND varchar(50),
soDienthoai varchar(50),
email varchar (50),
id_trinhdo int,
id_vitri int,
luong decimal,
id_bophan int,
foreign key (id_trinhdo) references trinhdo(id),
foreign key (id_vitri) references vitri(id),
foreign key (id_bophan) references bophan(id)
);

create table khachhang(
id int primary key auto_increment,
hoten varchar(255) not null,
ngaysinh date,
gioitinh bit,
soCMND varchar(50),
soDienthoai varchar(50),
email varchar(50),
id_loaikhach int,
diachi varchar(255),
foreign key (id_loaikhach) references loaikhach(id)
);

create table kieuthue(
id int primary key auto_increment,
ten varchar(45) not null,
gia int
);

create table loaidichvu(
id int primary key auto_increment,
ten varchar(45) not null
);

create table dichvu(
id int primary key auto_increment,
ten varchar(255) not null,
dientich decimal,
chiphithue varchar(45),
songuoitoida varchar(45),
trangthai varchar(45),
id_kieuthue int,
id_loaidichvu int,
foreign key(id_kieuthue) references kieuthue(id),
foreign key(id_loaidichvu) references loaidichvu(id)
);

create table dichvudikem(
id int primary key auto_increment,
ten varchar(255) not null,
donvi varchar(255),
gia decimal
);


create table hopdong(
id int primary key auto_increment,
id_khachhang int,
id_nhanvien int,
id_dichvu int,
ngaybatdau date,
ngayketthuc date,
sotiendatcoc decimal,
tongsotien decimal,
foreign key(id_khachhang) references khachhang(id),
foreign key(id_nhanvien) references nhanvien(id),
foreign key(id_dichvu) references dichvu(id)
);

create table hopdongchitiet (
id int primary key auto_increment,
id_hopdong int,
id_dichvudikem int,
soluong int,
foreign key (id_hopdong) references hopdong(id),
foreign key (id_dichvudikem) references dichvudikem(id)
);

insert into loaikhach (ten) values
('Khách lẻ'),
('Khách đoàn'),
('Khách công ty'),
('Khách VIP'),
('Khách quốc tế');

insert into vitri (ten) values
('Nhân viên lễ tân'),
('Nhân viên phục vụ'),
('Quản lý'),
('Nhân viên kỹ thuật'),
('Nhân viên dọn phòng');

insert into bophan (ten) values
('Lễ tân'),
('Phục vụ'),
('Quản lý'),
('Kỹ thuật'),
('Dọn phòng');

insert into trinhdo (ten) values
('Cao đẳng'),
('Đại học'),
('Thạc sĩ'),
('Tiến sĩ'),
('Trung cấp');

insert into nhanvien (hoten, ngaysinh, soCMND, soDienthoai, email, id_trinhdo, id_vitri, luong, id_bophan) values
('Nguyễn Văn A', '1985-01-15', '123456789', '0912345678', 'nguyenvana@example.com', 2, 1, 10000000, 1),
('Trần Thị B', '1990-03-22', '987654321', '0987654321', 'tranthib@example.com', 1, 2, 12000000, 2),
('Lê Văn C', '1982-07-30', '135792468', '0923456789', 'levanc@example.com', 3, 3, 20000000, 3),
('Phạm Thị D', '1995-12-05', '246813579', '0934567890', 'phamthid@example.com', 4, 4, 15000000, 4),
('Hoàng Văn E', '1988-11-18', '112233445', '0945678901', 'hoangvane@example.com', 5, 5, 9000000, 5);

insert into khachhang (hoten, ngaysinh, gioitinh, soCMND, soDienthoai, email, id_loaikhach, diachi) values
('Nguyễn Văn X', '1975-02-25', 1, '223344556', '0911223344', 'nguyenvanx@example.com', 1, 'Hà Nội'),
('Trần Thị Y', '1980-08-14', 0, '334455667', '0922334455', 'tranthiy@example.com', 2, 'Hồ Chí Minh'),
('Lê Văn Z', '1992-06-19', 1, '445566778', '0933445566', 'levanz@example.com', 3, 'Đà Nẵng'),
('Phạm Thị W', '1986-11-30', 0, '556677889', '0944556677', 'phamthiw@example.com', 4, 'Nha Trang'),
('Hoàng Văn V', '1995-05-12', 1, '667788990', '0955667788', 'hoangvanv@example.com', 5, 'Cần Thơ');

insert into kieuthue (ten, gia) values
('Theo giờ', 50000),
('Theo ngày', 300000),
('Theo tuần', 2000000),
('Theo tháng', 6000000),
('Theo năm', 72000000);

insert into loaidichvu (ten) values
('Phòng nghỉ'),
('Văn phòng'),
('Biệt thự'),
('Nhà hàng'),
('Hồ bơi');

insert into dichvu (ten, dientich, chiphithue, songuoitoida, trangthai, id_kieuthue, id_loaidichvu) values
('Phòng đơn', 20.5, '500000', '2', 'Còn trống', 2, 1),
('Phòng đôi', 35.0, '1000000', '4', 'Còn trống', 2, 1),
('Biệt thự biển', 100.0, '5000000', '8', 'Còn trống', 4, 3),
('Văn phòng hạng A', 50.0, '2000000', '10', 'Còn trống', 3, 2),
('Nhà hàng Á', 150.0, '3000000', '50', 'Còn trống', 3, 4);

insert into dichvudikem (ten, donvi, gia) values
('Dịch vụ giặt là', 'Lần', 100000),
('Dịch vụ spa', 'Giờ', 300000),
('Thuê xe đạp', 'Giờ', 50000),
('Dịch vụ hướng dẫn viên', 'Ngày', 1000000),
('Dịch vụ ăn uống tại phòng', 'Bữa', 200000);

insert into hopdong (id_khachhang, id_nhanvien, id_dichvu, ngaybatdau, ngayketthuc, sotiendatcoc, tongsotien) values
(1, 1, 1, '2023-06-01', '2023-06-05', 500000, 2000000),
(2, 2, 2, '2023-06-10', '2023-06-15', 1000000, 5000000),
(3, 3, 3, '2023-06-20', '2023-06-25', 2500000, 12500000),
(4, 4, 4, '2023-07-01', '2023-07-07', 2000000, 14000000),
(5, 5, 5, '2023-07-10', '2023-07-15', 3000000, 18000000);

insert into hopdongchitiet (id_hopdong, id_dichvudikem, soluong) values
(1, 1, 2),
(2, 2, 1),
(3, 3, 3),
(4, 4, 1),
(5, 5, 2);




select * from nhanvien where  (hoten like "H%" or hoten like "T%" or hoten like "K%") and length(hoten) <=15;

select * from khachhang where timestampdiff(year, ngaysinh, curdate()) between 18 and 50 and (diachi = 'Đà Nẵng' or diachi = 'Quảng Trị');

select kh.hoten, count(hd.id) as so_lan_dat_phong
from khachhang kh
join hopdong hd on kh.id = hd.id_khachhang
join loaikhach lk on kh.id_loaikhach = lk.id
where lk.ten = 'Diamond'
group by kh.id, kh.hoten
order by so_lan_dat_phong asc;

select 
    kh.id as IDKhachHang,
    kh.hoten as HoTen,
    lk.ten as TenLoaiKhach,
    hd.id as IDHopDong,
    dv.ten as TenDichVu,
    hd.ngaybatdau as NgayLamHopDong,
    hd.ngayketthuc as NgayKetThuc,
    (ifnull(dv.chiphithue, 0) + ifnull(sum(hdct.soluong * dvdk.gia), 0)) as TongTien
from 
    khachhang kh
left join 
    loaikhach lk on kh.id_loaikhach = lk.id
LEFT JOIN 
    hopdong hd on kh.id = hd.id_khachhang
left join
    dichvu dv on hd.id_dichvu = dv.id
left join 
    hopdongchitiet hdct on hd.id = hdct.id_hopdong
left join
    dichvudikem dvdk on hdct.id_dichvudikem = dvdk.id
group by
    kh.id, kh.hoten, lk.ten, hd.id, dv.ten, hd.ngaybatdau, hd.ngayketthuc, dv.chiphithue
order by
    kh.id;
    
    
    select 
    dv.id as IDDichVu,
    dv.ten as TenDichVu,
    dv.dientich as DienTich,
    dv.chiphithue as ChiPhiThue,
    lddv.ten as TenLoaiDichVu
from 
    dichvu dv
join 
    loaidichvu lddv on dv.id_loaidichvu = lddv.id
left join 
    hopdong hd on dv.id = hd.id_dichvu 
    and hd.ngaybatdau >= '2019-01-01' 
    and hd.ngaybatdau < '2019-04-01'
where 
    hd.id is null;
    
    select 
    dv.id as IDDichVu,
    dv.ten as TenDichVu,
    dv.dientich as DienTich,
    dv.songuoitoida as SoNguoiToiDa,
    dv.chiphithue as ChiPhiThue,
    lddv.ten as TenLoaiDichVu
from 
    dichvu dv
join 
    loaidichvu lddv on dv.id_loaidichvu = lddv.id
where 
    dv.id in (
        select distinct hd2018.id_dichvu
        from hopdong hd2018
        where hd2018.ngaybatdau >= '2018-01-01' and hd2018.ngaybatdau < '2019-01-01'
    )
and 
    dv.id not in (
       select distinct hd2019.id_dichvu
        from hopdong hd2019
        where hd2019.ngaybatdau >= '2019-01-01' and hd2019.ngaybatdau < '2020-01-01'
    );
    
    
   select distinct hoten as HoTenKhachHang from khachhang;
   
   select month(hd.ngaybatdau) as Thang, count(distinct hd.id_khachhang) as SoLuongKhachHang from hopdong hd
where 
    hd.ngaybatdau >= '2019-01-01' 
    and hd.ngaybatdau < '2020-01-01'
group by 
    month(hd.ngaybatdau)
order by 
    Thang;
    
    
    
    select 
    hd.id as IDHopDong,
    hd.ngaybatdau as NgayLamHopDong,
    hd.ngayketthuc as NgayKetThuc,
    hd.sotiendatcoc as TienDatCoc,
    COUNT(hdct.id) as SoLuongDichVuDiKem
from 
    hopdong hd
left join 
    hopdongchitiet hdct on hd.id = hdct.id_hopdong
group by 
    hd.id, hd.ngaybatdau, hd.ngayketthuc, hd.sotiendatcoc
order by 
    hd.id;
    
    
    select dvdk.ten as TenDichVuDiKem, dvdk.donvi as DonVi, dvdk.gia as Gia,
       kh.hoten as TenKhachHang, kh.diachi as DiaChi, lk.ten as TenLoaiKhachHang
from dichvudikem dvdk
join hopdongchitiet hdt on dvdk.id = hdt.id_dichvudikem
join hopdong hd on hdt.id_hopdong = hd.id
join khachhang kh on hd.id_khachhang = kh.id
join loaikhachhang lk on kh.id_loaikhach = lk.id
where lk.ten = 'Diamond'
  and (kh.diachi = 'Vinh' or kh.diachi = 'Quảng Ngãi');
  
  
  
  select hd.id as IDHopDong,
       nv.hoten as TenNhanVien,
       kh.hoten as TenKhachHang,
       kh.soDienthoai as SoDienThoaiKhachHang,
       dv.ten as TenDichVu,
       SUM(hdt.soluong) as SoLuongDichVuDikem,
       hd.sotiendatcoc as TienDatCoc
from hopdong hd
join nhanvien nv on hd.id_nhanvien = nv.id
join khachhang kh on hd.id_khachhang = kh.id
join hopdongchitiet hdt on hd.id = hdt.id_hopdong
join dichvudikem dvdk on hdt.id_dichvudikem = dvdk.id
join dichvu dv on hd.id_dichvu = dv.id
where year(hd.ngaybatdau) = 2019
  and (month(hd.ngaybatdau) in (10, 11, 12)) 
  and not exists (
      select 1
      from hopdong hd_prev
      where hd_prev.id_khachhang = hd.id_khachhang
        and year(hd_prev.ngaybatdau) = 2019
        and month(hd_prev.ngaybatdau) in (1, 2, 3)
  )
group by hd.id, nv.hoten, kh.hoten, kh.soDienthoai, dv.ten, hd.sotiendatcoc;



select dvdk.id as IDDichVuDiKem,
       dvdk.ten as TenDichVuDiKem,
       COUNT(*) as SoLanSuDung
from dichvudikem dvdk
join hopdongchitiet hdt on dvdk.id = hdt.id_dichvudikem
join hopdong hd on hdt.id_hopdong = hd.id
where exists (
    select 1
    from hopdong hd_inner
    where hd_inner.id_khachhang = hd.id_khachhang
)
group by dvdk.id, dvdk.ten
order by COUNT(*) desc;




select nv.id as IDNhanVien,
       nv.hoten as HoTen,
       td.ten as TrinhDo,
       bp.ten as TenBoPhan,
       nv.soDienthoai as SoDienThoai
	
from nhanvien nv
join trinhdo td on nv.id_trinhdo = td.id
join bophan bp on nv.id_bophan = bp.id
where nv.id in (
    select hd.id_nhanvien
    from hopdong hd
    where year(hd.ngaybatdau) between 2018 and 2019
    group by hd.id_nhanvien
    having COUNT(*) <= 3
);


delete from nhanvien
where id not in (
    select nv.id
    from nhanvien nv
    join hopdong hd on nv.id = hd.id_nhanvien
    where year(hd.ngaybatdau) between 2017 and 2019
);

update khachhang
set id_loaikhach = (
    select id
    from loaikhach
    where ten = 'Diamond'
)
where id in (
    select hd.id_khachhang
    from hopdong hd
    where year(hd.ngaybatdau) = 2019
    group by hd.id_khachhang
    having SUM(hd.tongsotien) > 10000000
)
and id_loaikhach = (
    select id
    from loaikhach
    where ten = 'Platinium'
);



select kh.id
from khachhang kh
join hopdong hd on kh.id = hd.id_khachhang
where year(hd.ngaybatdau) < 2016;


update dichvudikem
set gia = gia * 2
where id in (
    select dvdk.id
    from dichvudikem dvdk
    join hopdongchitiet hdt on dvdk.id = hdt.id_dichvudikem
    join hopdong hd on hdt.id_hopdong = hd.id
    where year(hd.ngaybatdau) = 2019
    group by dvdk.id
    having COUNT(*) > 10
);




select
    nv.id as IDNhanVien,
    null as IDKhachHang,
    nv.hoten as HoTen,
    nv.email as Email,
    nv.soDienthoai as SoDienThoai,
    nv.ngaysinh as NgaySinh
from nhanvien nv

union all

select
    null as IDNhanVien,
    kh.id as IDKhachHang,
    kh.hoten as HoTen,
    kh.email as Email,
    kh.soDienthoai as SoDienThoai,
    kh.ngaysinh as NgaySinh
from khachhang kh;








    
    
    
    
    
    









 
