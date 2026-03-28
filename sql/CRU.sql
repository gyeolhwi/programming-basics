SELECT * FROM study.sample_book_tb;

-- insert select
insert into library_tb(library_name,library_code,library_url)
-- 도서관 정보 테이블 데이터 추출
select
	도서관명,
	도서관구분코드,
	도서관홈페이지
from
	sample_book_tb
# group by > 어느 영역까지 그룹으로 묶어줄지 설정
group by
	도서관명,
	도서관구분코드,
	도서관홈페이지;


select * from category_tb;

insert into category_tb(category_name)
-- 카테고리 정보 테이블 데이터 추출
select
	카테고리
from
	sample_book_tb
group by
	카테고리;
    

select * from publisher_tb;
insert into publisher_tb
-- 출판사 정보 테이블 데이터 추출
select
	0,
	출판사
from
	sample_book_tb
group by
	출판사;
    
    
-- 형식 정보 테이블 데이터 추출
insert into book_type_tb
select
	0,
	형식
from
	sample_book_tb
group by
	형식;

# 정규화된 데이터 매칭
update
	sample_book_tb sbt
    left outer join library_tb lt on (lt.library_name = sbt.도서관명)
    left outer join category_tb ct on (ct.category_name = sbt.카테고리)
    left outer join publisher_tb pt on (pt.publisher_name= sbt.출판사)
    left outer join book_type_tb btt on (btt.book_type_name = sbt.형식)
set
	도서관ID = lt.library_id,
    카테고리ID = ct.category_id,
    출판사ID = if(sbt.출판사 ="", null , pt.publisher_id),
    형식ID = btt.book_type_id;
# update - set
/*
    update
		수정할 테이블
        left outer join 값을 불러온 거 
        = 가상의 테이블을 만들어서 기준컬럼에 원하는값만을 대입(set)한다
*/

    SELECT * FROM study.library_tb;
    SELECT * FROM study.book_tb;
    SELECT * FROM study.sample_book_tb;
    


insert into book_tb
select
	0,
	도서관ID,
    도서명,
    저자명,
    `국제표준도서번호(ISBN)`,
    카테고리ID,
    출판사ID,
    `표지주소(URL)`,
    형식ID
FROM
	sample_book_tb;
    
truncate table book_type_tb;
truncate table book_tb;

/*
	insert select → select로 불러온 값을 insert한다 컬럼의 위치와 형식이 맞으면 가능
    insert into 테이블명 (데이터를 넣을 컬럼) select
    
*/