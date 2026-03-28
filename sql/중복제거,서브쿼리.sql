-- Group by 집계, 중복제거
select * from book_tb;

select
	distinct # 중복제거된 결과값 출력 (중복해서 사용할 수 없음)
    category_id,
	publisher_id
from
	book_tb;
    
# 순서 from - where - group by - select
select
	category_id,
    count(*)
from
	book_tb
where
	book_id > 7000
group by
	category_id;
    
# 도서명 중 '돈' 이라는 글자가 들어간 데이터들을 찾아 카테고리별로 묶으시오. / 카테고리 별로 도서 개수가 출력되어야한다.

SELECT 
	*
FROM
    (SELECT 
        category_id, COUNT(*)
    FROM
        book_tb
    WHERE
        book_name LIKE '%돈%'
    GROUP BY category_id) AS category_group_book_tb
WHERE
    `COUNT(*)` > 10;
    
    
    
SELECT 
	category_id, 
	COUNT(*) category_count
FROM
	book_tb
WHERE
	book_name LIKE '%돈%'
GROUP BY 
	category_id
having
	category_count > 10;