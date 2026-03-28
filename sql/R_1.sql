SELECT * FROM student_tb;
# where - 조건
# 단순 비교
SELECT 
    *
FROM
    student_tb
where
	student_name = "김준일" ;
# OR연산
SELECT 
    *
FROM
    student_tb
WHERE
    student_name = '김준일'
    or student_name = '김준이';

SELECT 
    *
FROM
    student_tb
WHERE
    student_name = '김준일'
    or student_name = '김준이';

# in 포함 연산
select
	*
from
	student_tb
where
	student_name in ("김준일","김준이","김준삼");
    
SELECT 
    *
FROM
    student_tb
WHERE
    student_id between 1 and 4;
    
SELECT 
    *
FROM
    student_tb
WHERE
# 초과 ,미만
    student_id > 2
    and student_id < 5;

SELECT 
    *
FROM
    student_tb
WHERE
    student_id > 2
    and student_id < 5;

# NOT
SELECT
	*
FROM
	student_tb
WHERE
	NOT introduce = "";
        
SELECT
	*
FROM
	student_tb
WHERE
	introduce is null;
#	introduce is not null;


insert into student_tb
values 
(0, "손경태", "010-1111-2222", "aaa@gmail.com", null, now()),
(0, "김지현", "010-1111-3333", "bbb@naver.com", null, now()),
(0, "김동인", "010-2222-2222", "ccc@gmail.com", null, now()),
(0, "김정현", "010-4444-3333", "aaabbb@naver.com", null, now()),
(0, "권오광", "010-5555-2222", "bbbccc@kakao.com", null, now()),
(0, "권혁진", "010-1111-5555", "aaabbbccc@kakao.com", null, now());

select
	*
from
	student_tb
where
	student_name like "김%";

select
	*
from
	student_tb
where
	email like "%gmail.com";

select
	*
from
	student_tb
where
	phone like "%2222%"
	and not phone like "%2222";
    
select
	*
from
	student_tb
where
	#email like "%bbb%"
    #and not email like "bbb%";
    email like "___bbb%";
    