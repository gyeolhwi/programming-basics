select * from student_tb;
# 데이터 삽입(DML - INSERT)

# insert into `study`.`student_tb` Database가 use되지 않은 경우
# insert into student_tb					 use상태인 경우
insert into student_tb
	(student_id, 
    student_name, 
    phone, 
    email, 
    admission_date)
values (
0,
"김준일",
"010-9988-1916",
"gyeori0626@kakao.com",
NOW()
);
show tables;

insert into student_tb
	(student_id, student_name, phone, email, admission_date)
values 
(0,"김준이","010-9988-1916","gyeori0626@kakao.com",NOW()),
(0,"김준삼","010-9988-1916","gyeori0626@kakao.com",NOW()),
(0,"김준사","010-9988-1916","gyeori0626@kakao.com",NOW());

insert into student_tb
	(student_id, student_name, phone, email, introduce, admission_date)
values (
0,"김준오","010-9988-1916","gyeori0626@kakao.com",null,NOW()
);
insert into student_tb
values 
(0,"김준칠","010-9988-1916","gyeori0626@kakao.com","텍스트",NOW());

