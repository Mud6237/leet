//https://leetcode.com/problems/minimum-cost-to-connect-sticks/
import java.util.PriorityQueue

class Solution {
	fun connectSticks(sticks: IntArray): Int {
		if (sticks.size <= 1) {
			return 0
		}
		val pq = PriorityQueue<Int>()			
		for(stick in sticks) {
			pq.add(stick)
		}
		var cost = 0
		while(pq.isNotEmpty()) {
			val a = pq.poll()
			val b = if (pq.isNotEmpty()) pq.poll() else 0
			cost += a + b
			if (pq.isNotEmpty()) {
				pq.add(a + b)
			}
		}
		return cost
	}
}