create database bai_tap1;
use bai_tap1;


create	table giao_vien(
ms_gv int auto_increment primary key,
ten_gv varchar(255),
diachi_gv varchar(255)
);

create table hoc_vien(
ms_hv int auto_increment primary key,
ten_hv varchar(255),
diachi_hv varchar(255)
);

create table lop_hoc(
ms_lop int auto_increment primary key,
ten_lop varchar(255),
ngay_batdau date,
ngay_kethuc date,
gio_hoc time,
buoi_hoc varchar(50),
hoc_phi decimal,
ms_gv int,
foreign key (ms_gv) references giao_vien(ms_gv)
);

create table giao_trinh(
ms_gt int auto_increment primary key,
ten_gt varchar(255),
so_trang int,
gia_tien decimal
);

create table bang_diem(
ms_bd int auto_increment primary key,
ms_hv int,
ms_lop int,
bang_diem decimal,
foreign key (ms_hv) references hoc_vien(ms_hv),
foreign key (ms_lop) references lop_hoc(ms_lop)
);

create table chung_chi(
ms_ct int auto_increment primary key,
ms_hv int,
ms_lop int,
chung_chi varchar(50),
foreign key(ms_hv) references hoc_vien(ms_hv),
foreign key(ms_lop) references lop_hoc(ms_lop)
);
