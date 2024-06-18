use library;

create index index_title on books(title);

create view brview_books as 
select b.*, COUNT(br.id) as borrow_count
from books b
left join borrow br on b.id = br.books_id
group by b.id;


DELIMITER $$
create procedure add_book(
IN title varchar(255),
IN page_size int,
IN authors_id int,
IN category_id int
)
BEGIN
insert into books (title,page_size,category_id,authors_id)
value(title,page_size,category_id,authors_id);
END $$

DELIMITER ;

call add_book("fsdaada",10,1,1);

