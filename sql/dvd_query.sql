SELECT * FROM study.dvd_tb;
SELECT * FROM title_tb;##
SELECT * FROM producer_tb;##
SELECT * FROM dvd_publisher_tb; ##
SELECT * FROM dvd_publication_year_tb;##
SELECT * FROM database_date_tb;##

#정규화
insert into database_date_tb
select distinct
	0,
    database_date
from
	dvd_tb;
    
# truncate database_date_tb;

# 매칭확인 후 오류가 없으면 update
select
	*
from
dvd_tb  dt
left outer join producer_tb pt on(dt.producer = pt.producer_name)
left outer join dvd_publisher_tb dpt on(dt.dvd_publisher = dpt.dvd_publisher_name);


# update
/*
    update
		수정할 테이블
        left outer join 값을 불러온 거 (vlookup이랑 같음)
        = 가상의 테이블을 만들어서 기준컬럼에 원하는값만을 대입(set)한다
*/

update
	dvd_tb dt
	left outer join producer_tb pt on(dt.producer = pt.producer_name)
	left outer join dvd_publisher_tb dpt on(dt.dvd_publisher = dpt.dvd_publisher_name)
set
	dt.producer_id = pt.producer_id,
	dt.dvd_publisher_id = dpt.dvd_publisher_id;