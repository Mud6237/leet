//https://leetcode.com/problemset/all?search=1703
//https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
//https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987607/O(n)-explanation-with-picture
class Solution {
	fun minMoves(nums: IntArray, k: Int): Int {
		val a = mutableListOf<Int>()
		for(i in 0 until nums.size) {
			if (nums[i] == 1) {
				a.add(i)
			}
		}
		println("a = ${a}")
		val b = MutableList<Long>(a.size + 1, { 0 })
		for(i in 1 until b.size) {
			b[i] = b[i-1] + a[i-1]
		}
		//println("b = ${b}")
		var moves = Long.MAX_VALUE
		for(i in 0..(a.size - k)) {
			val medianIndex = i + k / 2
			val upperIndex = i + k
			val upperSum = b[upperIndex] - b[medianIndex]
			val lowerSum = b[(k+1)/2 + i] - b[i]
			val cost = upperSum - lowerSum
			moves = Math.min(moves, cost)
		}
		return moves.toInt() - (k / 2) * ((k + 1) / 2)
	}
}