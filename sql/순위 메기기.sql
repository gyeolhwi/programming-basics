# 출판사를 기준으로 category의 count를 집계한다.

select
	#공동순위
	#rank() over(partition by publisher_id order by cnt desc) `rank`, # 1,2,2,4
	#dense_rank() over(partition by publisher_id order by cnt desc) `dense_num`, #1,2,2,3,3,4
    # 같더라도 다른순위
	row_number() over(partition by publisher_id order by cnt desc) `num`, #1,2,3,4
    pc_count_tb.*
from
	(select
		publisher_id,
		category_id,
		count(*) cnt
	from
		book_tb
	group by 
		publisher_id,
		category_id) as pc_count_tb;

select
	*
from
	(select
		row_number() over(partition by publisher_id order by cnt desc) `num`,
		pc_count_tb.*
	from
		(select
			publisher_id,
			category_id,
			count(*) cnt
		from
			book_tb
		group by 
			publisher_id,
			category_id) as pc_count_tb) as book_row_number_tb
where
	num = 1;