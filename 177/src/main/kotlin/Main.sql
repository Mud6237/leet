CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    select salary from (
      select salary, Dense_Rank() over (order by salary DESC) as r from employee ) as w
    where w.r = N
    limit 1
  );
END