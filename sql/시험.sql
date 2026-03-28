
insert into Student values(0, '이', '결휘', now(), 'gyeori0626@gmail.com', 2);
insert into Course values(0,'두번째강좌');

DESC todolist_study_db.Student;

SELECT * FROM Student;
SELECT * FROM Course;

-- 테이블 생성
create table Student(
student_id int primary key auto_increment,
first_name varchar(50),
last_name varchar(50),
birth_date date,
email varchar(100) not null,
course_id int not null
);

create table Course(
course_id int primary key auto_increment,
course_name varchar(100)
);


-- 데이터사전 조회
SELECT *  FROM 
	Information_schema.table_constraints  WHERE  table_name in ( "Student", "Course");

-- 조인 및 서브쿼리 활용
SELECT
	st.student_id, 
    st.first_name,
    st.last_name, 
    cr.course_id, 
    cr.course_name
FROM
	Student st
LEFT OUTER JOIN Course cr ON(st.course_id = cr.course_id);

-- 테이블 구조 및 제약조건 변경

ALTER TABLE `Student` ADD `phone_number` VARCHAR(50),
CHANGE COLUMN `email` `email` varchar(100) UNIQUE;

-- 트랜잭션 관리
START TRANSACTION;

DELETE
FROM
	Student
WHERE
	student_id = 1;
    
SAVEPOINT delete_student;

UPDATE
	Student
SET
	phone_number = "010-1234-5678"
WHERE
	student_id = 2;
    
SAVEPOINT update_student;

COMMIT;


-- 2번 문제

-- 테이블 목록 및 인덱스 정보 조회
-- 각 테이블에 설정된 인덱스를 파악하기 위한 데이터사전 조회
SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME IN ("Student","Course");

-- 인덱스 생성
SELECT
	student_id,
    CONCAT(first_name,last_name) as name,
    email
FROM
	Student;

-- 새로운 뷰 생성
CREATE VIEW `StudentCourse` AS
SELECT
	CONCAT(st.first_name, st.last_name) as name,
    cr.course_name
FROM
	Student st
    LEFT OUTER JOIN Course cr ON (st.course_id = cr.course_id);
    
-- 뷰 조회
SELECT * FROM todolist_study_db.StudentCourse;

-- Sales 테이블생성
CREATE TABLE `Sales`(
sale_id INT PRIMARY KEY AUTO_INCREMENT,
seller_name VARCHAR(50) NOT NULL,
sale_amount INT NOT NULL,
sale_date DATE
);

insert into
	Sales
values
(0, 'John',1000,2024-01-10),
(0, 'Alice',1500,2024-01-15),
(0, 'Bob',1200,2024-02-12),
(0, 'Alice',1700,2024-02-14),
(0, 'John',1300,2024-03-02),
(0, 'Bob',1100,2024-01-10),
(0, 'Alice',2000,2024-03-15);

select * from Sales;
-- SQL응용
-- 1. 각 판매자의 판매 금액 순위 구하기 (동일금액 같은순위)
SELECT
	RANK() OVER(ORDER BY sum(sale_amount) DESC) '판매 금액 순위',
    sl.seller_name '판매자',
    SUM(sl.sale_amount) '판매금액'	
FROM
	Sales sl
GROUP BY sl.seller_name;

-- 2. 판매자별로 월별 판매금액의 소계를 구하시오
SELECT
	seller_name,
	date_format(sale_date, '%Y-%m') AS 'sale_month',
    SUM( 
    sale_amount
    ) AS 'monthly_subtotal'
FROM
	Sales
GROUP BY
	seller_name,
	date_format(sale_date, '%Y-%m')
ORDER BY
'month';

-- 3. 월별로 전체 판매 금액의 중계를 구하시오

SELECT
	date_format(sale_date, '%Y-%m') as 'sale_month',
    SUM(sale_amount) OVER (ORDER BY date_format(sale_date, '%Y-%m')) as 'Running Total'
FROM
	Sales
GROUP BY
	date_format(sale_date, '%Y-%m');

-- 전체 판매 금액의 총합계
SELECT
	SUM(sale_amount) as "Total"
FROM
	Sales;