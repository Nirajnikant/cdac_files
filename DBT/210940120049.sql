--Q1. WRITE A QUERY TO DISPLAY FULL NAME ( FIRST_NAME , LAST_NAME) , EMAIL ,MANAGER_ID FROM EMPLOYEES TABLE.

	select concat(first_name,' ',last_name) 'Full name',email 'E-mail',manager_id 'Manager Id' from employees;

--Q2. WRITE A QUERY TO DISPLAY FULL NAME ( FIRST_NAME , LAST_NAME ) , EMAIL , JOB_ID , SALARY FROM EMPLOYEES TABLE WHERE EMPLOYEES ARE JOINS IN THE YEAR OF 	     1990.

	select concat(first_name,' ',last_name) 'Full name',email 'E-mail',job_id 'Job Id',Salary 
	from employees 
	where hire_date between '1990/01/01' and '1990/12/31';


--Q3. WRITE A QUERY TO DISPALY THE NUMBER OF EMPLOYEES IN EACH DEPARTMENTS.

	select department_id 'Department Id', count(employee_id) 'Total no. of Employees'
	from employees
	group by department_id
	order by department_id;


--Q4. WRITE A QUERY TO DISPLAY FIRST_NAME , LAST_NAME , EMAIL , PHONE_NUMBER , DEPARTMENT_ID , DEPARTMENT_NAME FROM EMPLOYEES .

	select first_name,last_name,email,phone_number,e.department_id,department_name
	from employees e
	join departments d
	on d.department_id= e.department_id;

--Q5. WRITE A QUERY TO DISPALY THE EMPLOYEES FIRST_NAME , LAST_NAME WHOSE FIRST_NAME START WITH 'S'

	select first_name,last_name
	from employees e
	where first_name like 's%';

--Q6. WRITE A QUERY TO DISPLAY THE EMPLOYEES FIRST_NAME , CITY IN CAPITAL LATTERS.

	select upper(first_name),upper(city)
	from employees e
	join departments using (department_id)
	join locations using (location_id);

--Q8.  CREATE A STORED PROCEDURE TO CHECK WHETHER GIVEN NUMBER IS ODD OR EVEN.

	DELIMITER //
	CREATE PROCEDURE `num`( IN input_num int, OUT output varchar(200))
   	BEGIN
        SELECT IF(LEFT(input_num, 1) % 2 <> 0, "number is odd", "number is even") INTO output;
    	END//


--Q9.  CREATE A FUNCTION WHICH WILL CHECK THE GIVEN NUMBER IS POSITIVE OR NEGATIVE OR ZERO.

	DELIMITER //
	
	CREATE FUNCTION signn ( numb INT )
	RETURNS varchar(20) DETERMINISTIC

	BEGIN

	   DECLARE result INT;
	   DECLARE ans VARCHAR(20);
	   select SIGN(numb) into result;
	   IF result=1 THEN
		SET ans = 'Positive';

	   ELSEIF result=-1 THEN
		SET ans = 'Negative';
	   ELSE 
	  	SET ans = "Zero";
	   END IF;

   	RETURN ans;

	END; //

	DELIMITER ;

---------------------------------

--Q10. CREATE A STORED PROCEDURE WHICH WILL RETURNS COMMA SEPERATED LIST OF EMPLOYEES FIRST_NAME .

delimiter $$ 
USE 'hrschema'$$
create definer='root'@'localhost' procedure'empListComma'()
begin
	declare v_fname varchar(20);
	declare result varchar(2000);
	declare not_found BOOLEAN DEFAULT FALSE;

	decalre c cursor for (Select first_name from employees);

	declare continue handler for not found set no_found =true;

	open c;
	cyc_loop:LOOP
		fetch c into v_fname;
		if (not_found) then leave cyc_loop;
		elseif (result is null) then set result = v_fname;
		else set result = concat(result,', ',v_fname);
		end if;
	end loop;
	close c;
	select result 'Employees';
end$$

