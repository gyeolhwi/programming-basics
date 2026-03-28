SELECT * FROM study.student_tb;

# 전체순위
select
    student_tb.*,
    dense_rank() over(order by score desc) `등수`
from
	student_tb;
    
# 반별순위
select
    student_tb.*,
    dense_rank() over( partition by class order by score desc) `dense_rank`
from
	student_tb;
    

