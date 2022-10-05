//https://leetcode.com/problemset/all?search=862
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
import java.util.LinkedList
class Solution {
	fun shortestSubarray(nums: IntArray, k: Int): Int {
		var minLen = Int.MAX_VALUE
		val p = LongArray(nums.size + 1)
		for(i in 1 until p.size) {
			p[i] = p[i-1] + nums[i-1]
		}
		val deque = LinkedList<Int>();
		//val deque = ArrayDeque<Int>()
		for(i in 0 until p.size) {
			while(deque.isNotEmpty() && p[deque.last()] >= p[i]) {
				deque.removeLast()
			}
			while(deque.isNotEmpty() && p[i] >= p[deque.first()] + k) {
				val x = deque.first()
				val y = i
				val l = if (x == y) 1 else y - x
				minLen = Math.min(minLen, l)
				deque.removeFirst()
			}
			deque.addLast(i)
		}
		return if (minLen <= nums.size) minLen else -1
	}
}