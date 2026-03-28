-- order by - 정렬
select * from category_tb;
-- ASC → 오름차순 (생략가능) , DESC → 내림차순(생략불가)

select 
	*
from 
	category_tb
order by 
	category_id desc;

# publisher id는 내림차순
select
	*
from
	book_tb
order by
	# 맨 위 부터 우선순위에 있음
    category_id asc,
	publisher_id desc,
	book_id asc;
