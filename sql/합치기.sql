# group by 그룹
# 집계 -> count , max , min , sum , avg , 
select * from student_tb;

SELECT
	phone,
    COUNT(*)
FROM
	student_tb
GROUP BY
	phone;
    
    