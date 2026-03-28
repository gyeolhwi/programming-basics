insert into join1_tb
values
(0,"정령우"),
(0,"백승주"),
(0,"김정현"),
(0,"김유진"),
(0,"정찬익");

insert into join2_tb
values
	(0,"0101-1111-1111"),
	(0,"0101-2222-2222"),
	(0,"0101-3333-2222"),
	(0,"0101-4444-4444"),
	(0,"0101-5555-5555");

insert into master_tb
values
	(0,1,1),
	(0,1,2),
	(0,1,3),
	(0,2,1),
	(0,2,2),
	(0,3,3),
	(0,4,4),
	(0,5,5),
	(0,5,1);
    
select * from join1_tb;
select * from join2_tb;
select * from master_tb;

select
	*
from
	master_tb mt
	# inner join join1_tb jt1 on (jt1.join1_id = mt.name_id and jt1.join1_id > 4);
    # left outer join join1_tb jt on (jt.join1_id = mt.name_id and jt.join1_id > 4);
    
    # inner join  두개의 값이 참값이어야 나온다
    # left outer join join1_tb jt on (1 = 1); 

    left outer join join1_tb jt1 on (jt1.join1_id = mt.name_id and jt1.join1_id > 4)
    left outer join join2_tb jt2 on (jt2.join2_id = mt.phone_id);

# inner / left outer 
# inner = 두 값을 비교해서 실제 값이 있는것만 추려서 데이터가 들어옴
# left outer join 왼쪽테이블은 무조건 가지고오지만 두 값을 비교해서 다른 건 null로 표시
select * from publisher_tb;

insert into publisher_tb(publisher_name)
select
	# nullif 발행자와 "" 값이 같다면 null로 바꿔라
    # if null 만약 발행자 값이 null이라면 ""원하는값으로 바꿔라
    # 의도 : ifnull 안에 nullif로 공백이나 찾고자하는 값을 null로 바꿔줌 그리고 그 null이 걸리면 원하는값으로 바꿔준다
	-- 발행자,
	nullif(발행자, "")
    -- 괄호안의 값이 서로 같다면 바꿔라
    -- ifnull(nullif(replace(발행자," ", ""),""), "발행자 없음"), 
    -- ifnull(발행자,"발행자 없음") -> 
from
	sample_dvd_tb
group by
	발행자
having
	nullif(발행자,"")is not null;

truncate publisher_tb;