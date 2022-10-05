;// https://leetcode.com/problemset/all?search=354
// https://leetcode.com/problems/russian-doll-envelopes/
class Solution {
	fun maxEnvelopes(envelopes: Array<IntArray>): Int {
		envelopes.sortWith { e1, e2 -> e1[0] - e2[0] }
		//envelopes.forEach{print(it.toList())}
		//println()
		var prev = intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE)
		var w = 0
		for(i in 0 until envelopes.size) {
			if (envelopes[i][0] > prev[0]) {
				w += 1
			}
			prev = envelopes[i]
		}
		envelopes.sortWith { e1, e2 -> e1[1] - e2[1] }
		prev = intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE)
		var h = 0
		for(i in 0 until envelopes.size) {
			if (envelopes[i][1] > prev[1]) {
				h += 1
			}
			prev = envelopes[i]
		}
		return Math.min(w, h)
	}
}
fun main() {
	var envelopes = arrayOf(intArrayOf(5,4),intArrayOf(6,4),intArrayOf(6,7),intArrayOf(2,3))
	println(Solution().maxEnvelopes(envelopes))
	envelopes = arrayOf(intArrayOf(1,1),intArrayOf(1,1),intArrayOf(1,1))
	println(Solution().maxEnvelopes(envelopes))
	envelopes = arrayOf(intArrayOf(1, 1),intArrayOf(3,4),intArrayOf(3,3))
	println(Solution().maxEnvelopes(envelopes))
	envelopes = arrayOf(intArrayOf(4,5),intArrayOf(4,6),intArrayOf(6,7),intArrayOf(2,3),intArrayOf(1,1))
	println(Solution().maxEnvelopes(envelopes))
}
