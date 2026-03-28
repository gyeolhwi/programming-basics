use sys;

select * from sample_book_tb ;

select 
	*
from 
sample_book_tb ;

# TABLE 생성
CREATE TABLE `library_tb`(
	`library_id`INT NOT NULL AUTO_INCREMENT,
    `library_name` VARCHAR(45) null,
    PRIMARY KEY(`library_id`));
    
# TABLE 삭제
DROP TABLE library;
    
# TABLE 비우기
TRUNCATE TABLE library_tb;
# 조회
select * from library_tb;


# 중복제거를 한 데이터만을 코드부여하고 넣기 (1정규화)
insert INTO library_tb
SELECT 
	0,
    도서관명
FROM sample_book_tb
GROUP BY
	도서관명;
    
insert into 
	sample_book_tb
values
("명장도서관","051403","www.naver.com","인간에맞지않는","임미정",null,"임미정판타지","임미정집중저하의원인","hhtps","임미정은형식적이야"),
("금정도서관","051442","www.google.com","녹나무의 파수꾼","히가시노게이",null,"판타지소설","집중이안돼","hhtps","형식이무니다");
select * from sample_book_tb;
select * from library_code_tb;



CREATE TABLE `library_code_tb`(
	`library_code_id` INT NOT NULL AUTO_INCREMENT,
    `library_code_code` INT NOT NULL,
    PRIMARY KEY (`library_code_id`));
DROP TABLE library_code;

insert into library_code_tb
select
	0,
    도서관구분코드
from
	sample_book_tb
group by
	도서관구분코드;
    
CREATE TABLE `library_url_tb`(
	`library_url_id` INT NOT NULL AUTO_INCREMENT,
    `library_url_name` VARCHAR(45),
    PRIMARY KEY (`library_url_id`));

select * from library_url_tb;
drop table library_url;
    
insert into library_url_tb
select
	distinct
	0,
    도서관홈페이지
from
	sample_book_tb;
    
select * from sample_book_tb;

select
	*
from
	library_url_tb;

CREATE TABLE `category_tb`(
`category_tb_id` int not null auto_increment ,
`category_tb_name` varchar(45) not null,
primary key (`category_tb_id`),
unique index `category_tb_name_unique` (`category_tb_name` asc) visible);
    
select * from category_tb;
select * from sample_book_tb;

insert into category_tb
select
	distinct
	0,
    카테고리
from
	sample_book_tb;

CREATE TABLE `publisher_tb`(
	`publisher_tb_id`int not null auto_increment,
    `publisher_tb_name`varchar(45),
    primary key (`publisher_tb_id`),
    unique index `publisher_tb_name_unique` (`publisher_tb_id` asc) visible);

insert into publisher_tb
select
	0,
	출판사
from 
	sample_book_tb
group by
	출판사;
select * from publisher_tb;

select
	출판사
from
	sample_book_tb;

select
	distinct
	출판사
from
	sample_book_tb;
    
select
	sbt.출판사,
    lt.*,
    lct.*,
    pbt.*
    
from
	sample_book_tb sbt
    left outer join library_tb lt on (sbt.도서관명 = lt.library_name)
    left outer join library_code_tb lct on (sbt.도서관구분코드 = lct.library_code_code)
    left outer join publisher_tb pbt on (sbt.출판사 =  pbt.publisher_tb_name);
    
CREATE TABLE `sys`.`nomalization_book_tb` (
  `번호` INT NOT NULL AUTO_INCREMENT,
  `도서관id` INT NULL,
  `도서관명` TEXT NULL,
  `도서관구분ID` INT NULL,
  `도서관구분코드` TEXT NULL,
  `도서관홈페이지ID` INT NULL,
  `도서관홈페이지` TEXT NULL,
  `도서명` TEXT NULL,
  `저자명` TEXT NULL,
  `국제표준도서번호(ISBN)` TEXT NULL,
  `카테고리ID` INT NULL,
  `카테고리` TEXT NULL,
  `출판사ID` INT NULL,
  `출판사` TEXT NULL,
  `표지주소(URL)` TEXT NULL,
  `형식` TEXT NULL,
  PRIMARY KEY (`번호`));

select * from sample_book_tb;
select * from library_tb;
select * from nomalization_book_tb;

insert into nomalization_book_tb
select
	0,
    도서관ID,
    도서관구분ID,
    도서관홈페이지ID,
    카테고리ID,
    출판사ID
from
	sample_book_tb;

# 카피테이블 값 넣어주기
insert into nomalization_book_tb (도서관명,도서관구분코드,도서관홈페이지,도서명,저자명,`국제표준도서번호(ISBN)`,카테고리,출판사,`표지주소(URL)`,형식)
select
	도서관명,
    도서관구분코드,
    도서관홈페이지,
    도서명,
    저자명,
     `국제표준도서번호(ISBN)`,
    카테고리,
    출판사,
    `표지주소(URL)`,
    형식
FROM
	sample_book_tb;

select * from nomalization_book_tb;

# 카피테이블 ID 넣기
update
	nomalization_book_tb nbt
    left outer join library_tb lt on (nbt.도서관명 = lt.library_name)
    left outer join library_code_tb lct on (nbt.도서관구분코드 = lct.library_code_code)
    left outer join library_url_tb lut on (nbt.도서관홈페이지 = lut.library_url_name)
    left outer join category_tb ct on (nbt.카테고리 = ct.category_tb_name )
    left outer join publisher_tb pbt on (nbt.출판사 = pbt.publisher_tb_name)
set
	도서관id = lt.library_id,
    도서관구분ID = lct.library_code_id,
    도서관홈페이지ID = lut.library_url_id,
    카테고리ID = ct.category_tb_id,
    출판사ID = pbt.publisher_tb_id;
    
select * from nomalization_book_tb;
    

select * from sample_book_tb;
select * from library_tb;
select * from publisher_tb;

select * from category_tb;

# truncate nomalization_book_tb;

ALTER TABLE `sys`.`nomalization_book_tb` 
ADD COLUMN `저자명ID` INT NULL AFTER `도서명`;

CREATE TABLE `author_tb`(
	`author_id`INT NOT NULL AUTO_INCREMENT,
    `author_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`author_id`));

SELECT * FROM author_tb;

SELECT* FROM sample_book_tb;

INSERT INTO
	author_tb
SELECT
	0,
    저자명
FROM
	sample_book_tb
GROUP BY
	저자명;
truncate table author_tb;