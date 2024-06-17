drop database if exists demo;
create database if not exists demo;
use demo;

CREATE TABLE Hocsinh(
MaHS varchar(20) primary key , 
tenHS varchar(50),
Ngaysinh datetime,
Lop varchar(20),
GT varchar(20)
);


CREATE TABLE MonHoc(
 MaMH VARCHAR(20) PRIMARY KEY,
 TenMH VARCHAR(50),
 MaGV VARCHAR(20)
);

CREATE TABLE Bangdiem(
MaHS varchar(20),
MaMH varchar(50),
primary key(MaHS,MaMH),
Diemthi int,
NgayKT datetime,
FOREIGN KEY (MaHS) REFERENCES HocSinh(MaHS),
FOREIGN KEY (MaMH) REFERENCES MonHoc(MaMH)
);

CREATE TABLE Giaovien(
MaGV varchar(20) primary key,
TenGV varchar(50),
SDT varchar(10)
);

ALTER TABLE MonHoc ADD CONSTRAINT FK_MaGV FOREIGN KEY (MaGV) REFERENCES GiaoVien(MaGV);

insert into Hocsinh(MaHS,tenHS,Ngaysinh,Lop,GT) value ("HS01",'nhat','2000-12-12','cc','deptrainhuahoi');
insert into Hocsinh(MaHS,tenHS,Ngaysinh,Lop,GT) value ("HS02",'HOI','2000-12-12','cc','deptrainhuahoi');

insert into Giaovien(MaGV,TenGV,SDT) value ("GV1",'ADGSG','0123456789');
insert into Giaovien(MaGV,TenGV,SDT) value ("GV2",'Na','0123456712');

insert into MonHoc(MaMH,TenMH,MaGV) value ("MH1",'TOAN',"GV1");
insert into MonHoc(MaMH,TenMH,MaGV) value ("MH2",'ANH',"GV1");

insert into Bangdiem(MaHS,MaMH,Diemthi,NgayKT) value ("HS01",'MH1',8,'2020-12-12');
insert into Bangdiem(MaHS,MaMH,Diemthi,NgayKT) value ("HS01",'MH2',9,'2020-12-12');



