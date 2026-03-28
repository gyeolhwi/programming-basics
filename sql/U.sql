SELECT * FROM study.student_tb;
# 데이터 수정(DML - UPDATE)
# update - where - set
#여러개일 경우 in을 쓰기
UPDATE student_tb 
SET 
    email = 'gyeori0626@gmail.com'
WHERE
    student_id = (SELECT 
					temp_student_tb.student_id
				   FROM
					(select * from student_tb) as temp_student_tb
				   WHERE
					student_name = "김준오");
update
	student_tb
set
	phone = "010-1234-4321",
    email = "bbb@naver.com"
where
	student_id < 30;
    

update
	student_tb
set
	introduce = null
where
	introduce is not null;
    
# 이메일 데이터 중 @앞에 bbb가 포함된 정보의 introduce 컬럼에 / student_id 5~7 삭제
update
	student_tb
set
	email = "aaabbb@gmail.com"
where
	student_id > 26 and
    student_id < 30;
    
update
	student_tb
set
	introduce = "bbb를 포함하고있는 계정입니다"
where
	email LIKE "bbb%@%";

DELETE FROM
	student_tb
where
	student_id between 1 and 25;
    # student_id > 4 and student_id < 8;