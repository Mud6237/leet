//https://leetcode.com/problemset/all?search=1010
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
class Solution {
	fun numPairsDivisibleBy60(time: IntArray): Int {
		val h = hashMapOf<Int, Int>()
		for(t in time) {
			val k = t % 60
			h[k] = h.getOrDefault(k, 0) + 1
		}
		var t = 0

		for((k, v) in h) {
			val j = (60 - k) % 60
			val p = h.getOrDefault(j, 0)
			if (j == k) {
				t += (v * (v-1)) / 2
			} else if (k < j) {
				t += v * p
			}
		}

		//for(k in 31 until 60) {
		//	t += h.getOrDefault(k, 0) * h.getOrDefault(60 - k, 0) 
		//}
		//var k = h.getOrDefault(30, 0)
		//t +=  (k * (k -1)) / 2
		//k = h.getOrDefault(0, 1)
		//t += (k * (k - 1)) / 2
		
		return t
	}
}
fun main() {
	println(Solution().numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)))
	println(Solution().numPairsDivisibleBy60(intArrayOf(60, 60, 60)))
	println(Solution().numPairsDivisibleBy60(intArrayOf(60)))
	println(Solution().numPairsDivisibleBy60(intArrayOf(180, 180, 180, 60)))
}
