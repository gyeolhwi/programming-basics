# insert into rental_tb
#insert into rental_tb
SELECT 
	distinct
    0 AS rental_id,
    FLOOR(RAND() * 3000) + 1 AS dvd_id,
    '김준일' AS customer_name,
    NOW() AS rental_date
FROM
    dvd_tb
WHERE
    dvd_id < 10
order by
	dvd_id;

select
	*
from
	rental_tb rt
		left outer join (
			SELECT 
				distinct
				0 AS rental_id,
				FLOOR(RAND() * 3000) + 1 AS dvd_id,
				'김준일' AS customer_name,
				NOW() AS rental_date
			FROM
				dvd_tb
			WHERE
				dvd_id < 10
			order by
				dvd_id
    )
from
	dvd_tb
where
	dvd_id < 10
order by
	dvd_id) rt2 on (rt2.dvd_id)

SELECT 
	distinct
    0 AS rental_id,
    FLOOR(RAND() * 3000) + 1 AS dvd_id,
    '김준일' AS customer_name,
    NOW() AS rental_date
FROM
    dvd_tb
WHERE
    dvd_id < 10
order by
	dvd_id;