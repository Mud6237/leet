/* https://leetcode.com/problems/rank-scores/ */
select score, (Dense_rank() over( order by score desc) ) as "rank" from scores