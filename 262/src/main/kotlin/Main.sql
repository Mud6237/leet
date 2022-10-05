with cte as (
	select * from trips
	left outer join users on trips.client_id = users.users_id
	union
	select * from trips
	left outer join users on trips.driver_id = users.users_id
), cte1 as (
 	select distinct id, status, request_at from cte
 	where id not in (select distinct id from cte where lower(banned) = 'yes')
 	and request_at::date >= '2013-10-01'::date and request_at::date <= '2013-10-03'::date
 ), cte2 as (
   select request_at, count(*) as trips_count from cte1 
   group by request_at 
 ), cte3 as (
   select request_at, count(*) as cancellation_count from cte1
   where status != 'completed'
   group by request_at
 )
 select cte2.request_at as Day, TRUNC(coalesce(cte3.cancellation_count, 0)::numeric/cte2.trips_count::numeric, 2) as "Cancellation Rate"
 from cte2
 left outer join cte3 on cte2.request_at = cte3.request_at