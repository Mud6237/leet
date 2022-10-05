/* https://leetcode.com/problems/department-highest-salary/  */
/* 1  */
select employee, salary, department from (
select employee.name as employee, salary, department.name as department, dense_rank() over (partition by departmentid order by salary desc) as "rank" from employee
left outer join department on employee.departmentId = department.id
) as w
where w.rank = 1
/* 2  */
select 
	Department.name as "Department",
	Employee.name as "Employee",
	Employee.salary as  "Salary"
from
	Employee
left outer join 
	Department on Employee.departmentId = Department.id
where 
	 ( Employee.departmentId, salary ) in (
		 select 
		 	departmentId,
		 	max(salary)
		 from
		 	employee
		 group by departmentId
	)