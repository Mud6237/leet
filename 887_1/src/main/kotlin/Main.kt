//https://leetcode.com/problems/super-egg-drop/
class Solution {
	fun superEggDrop(k: Int, n: Int): Int {
		if (n < 2) {
			return n
		}
		val dp = Array(n + 1, { IntArray(k+1) })
		for(i in 1..k) {
			dp[1][i] = 1
		}
		for(i in 1..n) {
			dp[i][1] = i
		}
		for(f in 2..n) {
			for(e in 2..k) {
				var m = Int.MAX_VALUE
				var l = 1
				var h = f
				while(l <= h) {
					val mid = l + (h - l) / 2
					m = Math.min(m, Math.max(dp[mid-1][e-1], dp[f-mid][e]))
					if(dp[mid-1][e-1] < dp[f-mid][e]) {
						l = mid + 1
					} else {
						h = mid - 1
					}
				}
				dp[f][e] = 1 + m
			}
		}
		return dp[n][k]
	}
}