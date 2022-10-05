//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
import java.util.PriorityQueue
class Solution {
	fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
		var h = hashMapOf<Int,Int>()
		for(n in arr) {
			h[n] = h.getOrDefault(n, 0) + 1
		}
		var pq = PriorityQueue<Int>({ a, b -> (h[a] ?: 0) - (h[b] ?: 0)})
		for(key in h.keys) {
			pq.add(key)
		}
		var j = k
		while(j > 0 && pq.isNotEmpty()) {
			val t = pq.poll()
			j -= h[t] ?: 0
		}
		return if (j < 0) pq.size + 1 else pq.size
	}
}