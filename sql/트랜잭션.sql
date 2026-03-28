# 트랜잭션(Transaction) 
# 순서가 중요하지 않음 usp_add_master
# @@ = 전역

set @name = "김준일";
select @name;

select @@autocommit;
set autocommit = 0;

insert into master_tb
values
	(0,6,1);

select * from master_tb;
commit;

start transaction; #{

set @name = "김우찐";
set @phone = "010-7777-8888";

savepoint sp_insert_name; #지금 까지동작지점 세이브
insert into join1_tb
values (0,@name);

savepoint sp_insert_phone;
insert into join2_tb
values(0, @phone);

# rollback을 하게되면 start transaction 다시 해야한다. / savepoint rollback은 상관없
rollback;
rollback to sp_insert_phone;

set @new_join1_id = 0;
set @new_join2_id = 0;

SELECT
	join1_id into @new_join1_id
FROM
	join1_tb
order by
	join1_id DESC
LIMIT 0, 1;
	
select @new_join2_id;

select
	join2_id into @new_join2_id
from
	join2_tb
order by
	join2_id DESC
limit 0,1;

insert into master_tb
values(0, @new_join1_id,@new_join2_id);

commit; # } 트랜잭션 닫힘