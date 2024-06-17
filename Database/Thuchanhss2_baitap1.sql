drop database if exists demo;
create database if not exists demo;
use demo;

create table PX(
SoPX int primary key auto_increment,
NX date
);

create table VT(
MaVT int primary key auto_increment,
TenVT varchar(255)
);

create table ct_px(
SoPX int,
MaVT int,
primary key(SoPX,MaVT),
dg_xuat varchar(255),
sl_xuat varchar(255),
foreign key (SoPX) references PX(SoPX),
foreign key (MaVT) references VT(MaVT)
);

create table PN(
so_pn int primary key auto_increment,
ngay_nhap date
);

create table ct_pn(
MaVT int,
so_pn int,
primary key(MaVT,so_pn),
dg_nhap varchar(255),
sl_xuat varchar(255),
foreign key (so_pn) references PN(so_pn),
foreign key (MaVT) references VT(MaVT)
);

create table nha_cc(
ma_ncc int primary key auto_increment,
ten_ncc varchar(255),
dia_chi varchar(255)
);

create table don_dh(
so_dh int primary key auto_increment,
ngay_dh date,
id_ncc int,
foreign key (id_ncc) references nha_cc(ma_ncc)
);

create table ct_ddh(
MaVT int,
so_dh int,
primary key(MaVT,so_dh),
foreign key (MaVT) references VT(MaVT),
foreign key (so_dh) references don_dh(so_dh)
);

create table dt(
sdt varchar(11) primary key,
id_ncc int,
foreign key (id_ncc) references nha_cc(ma_ncc)
);





insert into nha_cc(ten_ncc,dia_chi) value('a','jdjdkfk');
insert into nha_cc(ten_ncc,dia_chi) value('b','gdfg');

insert into dt(sdt,id_ncc) value ('89389384087',1);
insert into dt(sdt,id_ncc) value ('83458938407',1);
insert into dt(sdt,id_ncc) value ('83458938000',2);

