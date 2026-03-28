SELECT * FROM sample_dvd_tb;
SELECT * FROM producer_tb;
SELECT * FROM publisher_tb;

insert into producer_tb
select
	distinct # or group by
    0,
	제작자
from
	sample_dvd_tb;
	# group by 제작자;
    
insert into publisher_tb
select 
    0,
    발행자
from
	sample_dvd_tb
group by 
	발행자;