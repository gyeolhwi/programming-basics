 CREATE SCHEMA `test_db`;


CREATE TABLE Employee(
employee_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
department_id INT NOT NULL
);
CREATE TABLE Department(
department_id INT PRIMARY KEY AUTO_INCREMENT,
department_name VARCHAR(100) NOT NULL
);

SELECT * FROM Employee;
SELECT * FROM Department;

-- 직원 추가 프로시저 작성
DELIMITER $$
CREATE DEFINER=`admin`@`%` PROCEDURE `add_employee`(
	in name varchar(100),
    in email varchar(100),
    in department_id INT
)
BEGIN
INSERT INTO 
	Employee
VALUES
(0,name,email,department_id);

END$$
DELIMITER ;

-- 직원 정보 수정 프로시저 작성
DELIMITER $$
CREATE DEFINER=`admin`@`%` PROCEDURE `update_employee`(
	in employee_id INT,
    in email VARCHAR(100)
)
BEGIN

UPDATE
	Employee 
SET
	email = email
WHERE
	employee_id = employee_id;
END$$
DELIMITER ;

-- 부서별 직원 목록 조회 프로시저 작성
DELIMITER $$
CREATE DEFINER=`admin`@`%` PROCEDURE `getUserAndEmailByDepartmentId`(
	in department_id INT
)
BEGIN

SELECT
	em.name,
	em.email
FROM
	Employee em
    LEFT OUTER JOIN Department dt ON (em.department_id = dt.department_id)
WHERE
	em.department_id = department_id;
    
END$$
DELIMITER ;
-- 프로시저 호출
call add_employee("김결휘","gyeori0626@gmail.com",1);
call update_employee(1,"rufgnl0001@gmail.com");
call getUserAndEmailByDepartmentId(1);