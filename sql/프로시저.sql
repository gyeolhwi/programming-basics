SELECT * FROM todolist_study_db.Sales;

select
	*,
	date_format(sale_date, "%Y-%m") as fd,
    sum(sale_amount),
    avg(sale_amount)
from
	Sales
where
	seller_name = "Alice" and
	date_format(sale_date, "%Y-%m") = "2024-02";
insert into Sales values(0,"Alice", 10000, "2024-02-10");

select * from Sales;
call new_procedure("Alice",'2024-02');


-- 프로시저 작성
DELIMITER $$
USE `todolist_study_db`$$
CREATE DEFINER=`admin`@`%` PROCEDURE `new_procedure`(
	in name varchar(45),
    in date varchar(45)
)
BEGIN
	select
		*,
		date_format(sale_date, "%Y-%m"),
        sum(sale_amount),
        avg(sale_amount)
	from
		Sales
	where
		seller_name = name
        and date_format(sale_date, "%Y-%m") = date;
END$$
DELIMITER ;


