CREATE TABLE `dvd_db`.`rental_tb` (
  `rental_id` INT NOT NULL AUTO_INCREMENT,
  `dvd_id` INT NOT NULL,
  `customer_name` VARCHAR(45) NOT NULL,
  `rental_date` DATETIME  NOT NULL,
  PRIMARY KEY (`rental_id`));
  
  CREATE TABLE `dvd_db`.`dvd_register_tb`(
	`dvd_register_id` INT  NOT NULL AUTO_INCREMENT,
    `dvd_id` 	INT,
    `dvd_register_date` DATETIME,
    PRIMARY KEY (`dvd_register_id`));
  
  
select * from dvd_register_tb;

insert into dvd_register_tb
values
	(0,1,NOW());

-- insert into dvd_register_tb    
select
	0,
    dvd_id,
    now()
from
	dvd_tb
union All
select
	0,
    dvd_id,
    now()
from
	dvd_tb
union All
select
	0,
    dvd_id,
    now()
from
	dvd_tb
order by 
	dvd_id;

# 
select
    origin_divd_id
from
	dvd_tb origin # 3800개
	# left outer join dvd_tb dtt on (dtt.dvd_id = 1 or dtt.dvd_id = 2 or dtt.dvd_id = 3);
		left outer join dvd_tb dtt on (origin.dvd_id < 4); 
        
# 중복계산
select
	title,
    producer_id,
    publisher_id,
    count(*) as dvd_count
from
	dvd_tb
group by
	title,
    producer_id,
    publisher_id
having
	dvd_count > 1;
select * from dvd_tb;