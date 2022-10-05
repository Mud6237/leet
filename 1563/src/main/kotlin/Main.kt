//https://leetcode.com/problemset/all?search=1563
//https://leetcode.com/problems/stone-game-v/
class Solution {
	fun stoneGameV(stoneValue: IntArray): Int {
		val prefixSums = IntArray(stoneValue.size + 1)
		for(i in 0 until stoneValue.size) {
			prefixSums[i+1] = stoneValue[i] + prefixSums[i]
		}
		val dp = Array(stoneValue.size, { IntArray(stoneValue.size) })
		for(u in 2..stoneValue.size) {
			//println("size = $u")
			for(v in 0..stoneValue.size - u) {
				var m = Int.MIN_VALUE
				for(w in v+u-1 downTo v+1) {
					val rightSum = prefixSums[v+u] - prefixSums[w]
					val leftSum = prefixSums[w] - prefixSums[v]
					val s = Math.min(rightSum, leftSum)
					val r = dp[w][v+u-1]
					val l = dp[v][w-1]
					if (rightSum == leftSum) {
						m = Math.max(m, s + Math.max(r, l))
					} else if (leftSum < rightSum) {
						m = Math.max(m, s + l)
					} else {
						m = Math.max(m, s + r)
					}
					//println("left = ${stoneValue.slice(v until w)} leftSum = $leftSum right = ${stoneValue.slice(w until v+u)} rightSum = $rightSum ")
				}
				dp[v][v+u-1] = m
			}
		}
		return dp.first().last()
	}
}