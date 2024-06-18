use library;

select b.title as "tên sách",count(br.id) as "số lần mượn"
from books b
join borrow br
on b.id = br.books_id
group by b.id
order by count(br.id) desc;

select b.title as 'Tên sách'
from books b
left join borrow br 
on b.id = br.books_id
where br.id is null;

select s.name as "tên học viên",count(br.id) as "số lần mượn"
from students s
join borrow br
on s.id = br.students_id
group by s.id
order by count(br.id) desc;

select s.name as "tên học viên",count(br.id) as "số lần mượn"
from students s
join borrow br
on s.id = br.students_id
group by s.id
order by count(br.id) desc
limit 1;



