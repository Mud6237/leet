With CTE1 As (
  Select 
    caller_id as user_id,
    call_time,
    recipient_id
  From calls
  Union
  Select
    recipient_id as user_id,
    call_time,
    caller_id as recipient_id
  From calls
),
CTE2 As (
  Select
    user_id,
    recipient_id,
    Date(call_time) As day,
    Dense_Rank() Over (
      Partition By user_id, Date(call_time)
      Order By call_time Asc
    ) As RN,
    Dense_Rank() Over (
      Partition By user_id, Date(call_time)
      Order By call_time Desc
    ) As RK
  From CTE1
)

Select Distinct user_id
From CTE2
WHERE
  RN = 1 or RK = 1
Group By
  user_id, day
Having Count(Distinct recipient_id) = 1