create database book_management;
use book_management;

create table  books(
id int primary key ,
name varchar(255) not null,
page_size int not null,
author varchar(255) not null
);

insert into books value(1,"Toán",45,"Nguyễn Thái Học");
insert into books value(2,"Văn",34,"Trần Minh Hoàng");
insert into books value(3,"Sử",56,"Dương Trung Quốc");
insert into books value(4,"Địa",76,"Lê Văn Hiến");
insert into books value(5,"Hoá",32,"Hà Văn Minh");

SET SQL_SAFE_UPDATES = 0;

update books set page_size = 50 where name = "Sử";

delete from  books where id = 5;

drop table books;

drop database book_management;