create database demosql;
use demosql;

create table teachers(
id int primary key auto_increment,
name varchar(255) not null,
dob date not null,
gender bit not null,
phone varchar(50) not null
);

create table classes(
id int primary key auto_increment,
name varchar(255) not null
);

create table students(
id int primary key auto_increment,
name varchar(50) not null,
dob date,
gender bit,
phone varchar(50) not null,
classes_id int,
foreign key(classes_id) references classes(id)
);

create table tearcher_class(
id int primary key auto_increment,
teachers_id int,
classes_id int,
foreign key(teachers_id) references teachers(id),
foreign key(classes_id) references classes(id)
);

INSERT INTO teachers (name, dob, gender, phone) VALUES 
('Teacher A', '1980-01-01', 1, '1234567890'),
('Teacher B', '1985-02-02', 0, '0987654321');

INSERT INTO classes (name) VALUES 
('Class 1'), 
('Class 2');

INSERT INTO students (name, dob, gender, phone, classes_id) VALUES 
('Tien', '2000-01-01', 1, '1111111111', 1),
('Toan', '2001-02-02', 0, '2222222222', 1),
('Student C', '2002-03-03', 1, '3333333333', 2),
('Student D', '2003-04-04', 0, '4444444444', NULL);

INSERT INTO tearcher_class (teachers_id, classes_id) VALUES 
(1, 1), (2, 2);

/*Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.*/
SELECT 
    students.id AS StudentID,
    students.name AS StudentName,
    students.dob AS DateOfBirth,
    students.gender AS Gender,
    students.phone AS Phone,
    classes.name AS ClassName
FROM 
    students
LEFT JOIN 
    classes ON students.classes_id = classes.id;

    /*Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào, lớp đó giảng viên nào dạy*/
    SELECT 
    students.id AS StudentID,
    students.name AS StudentName,
    students.dob AS DateOfBirth,
    students.gender AS Gender,
    students.phone AS Phone,
    classes.name AS ClassName,
    teachers.name AS TeacherName
FROM 
    students
LEFT JOIN 
    classes ON students.classes_id = classes.id
LEFT JOIN 
    teacher_class ON classes.id = teacher_class.classes_id
LEFT JOIN 
    teachers ON teacher_class.teachers_id = teachers.id;
    
    /*Lấy ra thông tin các học viên đang theo học tại các lớp kể cả các học viên không theo học lớp nào.*/
    SELECT 
    students.id AS StudentID,
    students.name AS StudentName,
    students.dob AS DateOfBirth,
    students.gender AS Gender,
    students.phone AS Phone,
    classes.name AS ClassName,
    teachers.name AS TeacherName
FROM 
    students
LEFT JOIN 
    classes ON students.classes_id = classes.id
LEFT JOIN 
    teacher_class ON classes.id = tearcher_class.classes_id
JOIN 
    teachers ON tearcher_class.teachers_id = teachers.id;
/*Lấy thông tin của các học viên tên ‘Tien’ và ‘Toan’. (dữ liệu tự insert để thỏa mãn)*/
SELECT 
    students.id AS StudentID,
    students.name AS StudentName,
    students.dob AS DateOfBirth,
    students.gender AS Gender,
    students.phone AS Phone,
    classes.name AS ClassName,
    teachers.name AS TeacherName
FROM 
    students
JOIN 
    classes ON students.classes_id = classes.id
JOIN 
    tearcher_class ON classes.id = tearcher_class.classes_id
JOIN 
    teachers ON tearcher_class.teachers_id = teachers.id
WHERE 
    students.name = 'Tien'
    OR students.name = 'Toan';
/*Lấy số lượng học viên từng lớp*/
SELECT 
    classes.id AS ClassID,
    classes.name AS ClassName,
    COUNT(students.id) AS NumberOfStudents
FROM 
    classes
LEFT JOIN 
    students ON classes.id = students.classes_id
GROUP BY 
    classes.id, classes.name;
    /* Lấy ra danh sách học viên và sắp xếp tên theo alphabet. */
    SELECT 
    id AS StudentID,
    name AS StudentName,
    dob AS DateOfBirth,
    gender AS Gender,
    phone AS Phone,
    classes_id AS ClassID
FROM 
    students
ORDER BY 
    name ASC;




    

