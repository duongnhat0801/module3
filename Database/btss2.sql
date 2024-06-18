create database library;
use library;

create table students(
id int primary key auto_increment,
name varchar(255) not null,
birthday date,
class_name varchar(255) not null
);

create table authors(
id int primary key auto_increment,
name varchar (255) not null
);

create table category (
id int primary key auto_increment,
name varchar(255)
);

create table books(
id int primary key auto_increment,
title varchar(255) not null,
page_size int,
category_id int,
authors_id int,
foreign key (category_id) references category(id),
foreign key (authors_id) references authors(id)
);

create table borrow(
id int primary key auto_increment,
students_id int,
books_id int,
borrow_date date,
return_date date,
foreign key (students_id) references students(id),
foreign key (books_id) references books(id)
);

insert into students(name,birthday,class_name) value ("Nguyễn Văn A","1999-12-12","CO822G1");
insert into students(name,birthday,class_name) value ("Nguyễn Văn B","1999-12-13","CO822G1");
insert into students(name,birthday,class_name) value ("Nguyễn Văn C","1999-12-14","CO822G1");
insert into students(name,birthday,class_name) value ("Nguyễn Văn D","1999-12-15","CO822G1");
insert into students(name,birthday,class_name) value ("Nguyễn Văn E","1999-12-16","CO822G1");

insert into  authors(name) value ("Nguyễn Thái Học");
insert into  authors(name) value ("Trần Minh Hoàng");
insert into  authors(name) value ("Dương Trung Quốc");
insert into  authors(name) value ("Lê Văn Hiến");
insert into  authors(name) value ("Hà Văn Minh");

insert into  category(name) value ("Tự nhiên");
insert into  category(name) value ("Xã hội");
insert into  category(name) value ("Truyện");
insert into  category(name) value ("Tiểu thuyết");
insert into  category(name) value ("Khác");

insert into books(title,page_size,authors_id,category_id) value ("Toán",45,1,1);
insert into books(title,page_size,authors_id,category_id) value ("Văn",34,2,2);
insert into books(title,page_size,authors_id,category_id) value ("Sử",56,3,2);
insert into books(title,page_size,authors_id,category_id) value ("Địa",76,4,2);
insert into books(title,page_size,authors_id,category_id) value ("Hoá",32,5,1);

insert into borrow(students_id,books_id,borrow_date,return_date) value (1,1,"2022-12-12","2022-12-13");
insert into borrow(students_id,books_id,borrow_date,return_date) value (2,2,"2022-12-12","2022-12-15");
insert into borrow(students_id,books_id,borrow_date,return_date) value (3,3,"2022-12-12","2022-12-15");
insert into borrow(students_id,books_id,borrow_date,return_date) value (4,4,"2022-12-12","2022-12-12");
insert into borrow(students_id,books_id,borrow_date,return_date) value (1,5,"2022-12-13","2022-12-15");
insert into borrow(students_id,books_id,borrow_date,return_date) value (1,5,"2022-12-14","2022-12-14");
insert into borrow(students_id,books_id,borrow_date,return_date) value (3,4,"2022-12-15","2022-12-29");
insert into borrow(students_id,books_id,borrow_date,return_date) value (3,3,"2022-12-8","2022-12-14");
insert into borrow(students_id,books_id,borrow_date,return_date) value (1,2,"2022-12-6","2022-12-30");

select b.title,c.name as "thể loại" ,a.name as 'tác giả'
from books b
join category c 
on b.category_id = c.id
join authors a
on b.authors_id = a.id;

select distinct s.name as "tên học viên"
from students s
join borrow br
on s.id = br.students_id
order by s.name asc;

select b.title as "Tên sách",count(br.id ) as "số lần mượn"
from books b
join borrow br
on b.id = br.books_id
group by b.title
order by  count(br.id) desc
limit 2;



