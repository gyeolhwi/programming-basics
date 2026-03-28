SELECT * FROM study.nomalization_dvd_tb;

insert into nomalization_dvd_tb
select
	0,
    registartation_number,
    title,
    producer_id,
    dvd_publisher_id,
    dvd_publiscation_year,
    database_date
FROM
	dvd_tb;

select
	nt.index,
    nt.title,
    pt.producer_name
from
	nomalization_dvd_tb nt
left outer join producer_tb pt on (nt.producer_id = pt.producer_id);