/* https://leetcode.com/problems/combine-two-tables/ */
select person.firstname, person.lastname, address.state, address.city
from person
left outer join address on address.personId = person.personId