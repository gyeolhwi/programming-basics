CREATE TABLE `product_tb`(
`product_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL UNIQUE,
`price` INT NOT NULL,
`sizeId` INT NOT NULL,
`colorId`INT NOT NULL,
PRIMARY KEY (`product_id`));

CREATE TABLE `size_tb`(
`sizeId` INT primary key auto_increment,
`name` varchar(45) NOT NULL unique
);

CREATE TABLE `color_tb`(
`colorId` INT primary key auto_increment,
`name` varchar(45) NOT NULL
);

insert into 
	color_tb
values
	(0,"검정"),
    (0,"빨강"),
    (0,"파랑"),
    (0,"초록");
    
select
	*
from
	color_tb ct
inner join size_tb st on (1=1);

select
	*
from
	product_tb;
    
-- truncate product_tb;