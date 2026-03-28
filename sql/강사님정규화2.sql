select * from dvd_tb;
select * from sample_dvd_tb;

insert into dvd_tb
select
	0,
	등록번호,
    제목,
    pdt.producer_id,
    pbt.publisher_id,
    발행년,
    데이터기준일자
from
	sample_dvd_tb sdt
    left outer join producer_tb pdt on (pdt.producer_name = sdt.제작자)
    left outer join publisher_tb pbt on (pbt.publisher_name = sdt.발행자);
    
truncate dvd_tb;

# 정규화 후 합치기 where의 기준은 마스터테이블위주로 할 것
# join은 키값들 위주로 하셈
# limiy 인덱스,갯수
# 순서 FROM - WHERE - GROUP BY - SELECT - HAVING - ORDER BY - LIMIT
select
dt.dvd_id,
dt.registration_number 등록번호,
dt.title 제목,
dt.producer_id 출판사ID,
pdt.producer_name 출판사명,
dt.publisher_id 저자ID,
pbt.publisher_name 저자명,
publication_year 발행연도,
dt.database_date 발행일
from
	dvd_tb dt
left outer join producer_tb pdt on (pdt.producer_id = dt.producer_id)
left outer join publisher_tb pbt on (pbt.publisher_id = dt.publisher_id)
limit 10 , 10;

/*
CREATE TABLE `dvd_db`.`new_table` (
  `idnew_table` INT NOT NULL AUTO_INCREMENT,
  `new_tablecol` VARCHAR(45) NULL,
  PRIMARY KEY (`idnew_table`));
*/

