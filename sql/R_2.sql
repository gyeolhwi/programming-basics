SELECT * FROM  `study`.`student_tb`;
SELECT 
    `student_id`,
    `student_name`,
    `phone`,
    `email`,
    `introduce`,
    `admission_date`
FROM
    `study`.`student_tb`;
SELECT `student_name`, `phone`, `email`, `admission_date` FROM `study`.`student_tb`;
SELECT `student_name`이름 , `phone` 전화번호, `email` 이메일, `admission_date`생성날짜 FROM `study`.`student_tb`;
SELECT student_id, student_name as name from student_tb;
# union(all) 병합 조건 - 컬럼의 개수와 자료형이 동일한 select 결과만 병합 가능
# union -> 중복 제거 후 select 결과 병합
SELECT 1 as number, "김준일" as name, 31 as age
union
SELECT 2 as number, "김준이" as name, 32 as age
union
SELECT 3 as number, "김준이" as name, 33 as age
union all
SELECT 3 as number, "김준이" as name, 33 as age;

select student_id, student_name from student_tb
union all
select student_id, phone from student_tb;

select
	number,
    name
from
(SELECT 1 as number, "김준일" as name, 31 as age
union
SELECT 2 as number, "김준이" as name, 32 as age
union
SELECT 3 as number, "김준이" as name, 33 as age) as temp_tb;

/*
	FROM절에서  select와 union으로 합쳐놓은 temp_tb라는 가상의 테이블을 생성 하고 그걸 불러옴
*/