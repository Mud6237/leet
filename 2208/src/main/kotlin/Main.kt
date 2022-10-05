//https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
import java.util.PriorityQueue
class Solution {
	fun halveArray(nums: IntArray): Int {
		val pq = PriorityQueue<Float>(reverseOrder())
		var s = 0.0
		for(n in nums) {
			val f = n.toFloat()
			pq.add(f)
			s += f
		}
		var q = 0.0
		var steps = 0
		while(pq.isNotEmpty() && q < s) {
			val r = pq.poll() / 2
			q += r
			s -= r
			steps += 1
			if (r > 0) {
				pq.add(r)
			}
		}
		return steps
	}
}