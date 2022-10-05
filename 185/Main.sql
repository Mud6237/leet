/* https://leetcode.com/problems/department-top-three-salaries/ */
/*1*/
# Write your MySQL query statement below
select 
	employee,
	department,
	salary
from 
	(
		select
			employee.name as "employee",
			department.name as "department",
			salary,
			dense_rank() over(partition by departmentId  order by salary desc) as "rank"
		from 
			employee
		left outer join
			department on employee.departmentid = department.id
	) as w

where 
	w.rank <= 3

/*2*/

select 
	e1.name as "employee",
	e1.salary as "salary",
	department.name as "department"
from 
	employee as e1
left outer join 
	department on e1.departmentId = department.id
where 3 > (
	select count(distinct e2.salary)
	from employee as e2
	where e2.salary > e1.salary and e1.departmentid = e2.departmentid
)


