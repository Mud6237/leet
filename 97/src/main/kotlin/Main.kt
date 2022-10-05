//https://leetcode.com/problemset/all?search=97
//https://leetcode.com/problems/interleaving-string/

class Solution {

	private fun longestCommonSubsequence(s1: String, s2: String, sb: StringBuilder): Int {
		val dp = IntArray(s2.length + 1)
		for(i in 1..s1.length) {
			var a1 = 0
			var a2: Int
			for(j in 1..s2.length) {
				a2 = a1
				a1 = dp[j]
				if(s1[i-1] == s2[j-1]) {
					dp[j] = a2 + 1
				} else {
					dp[j] = Math.max(dp[j], dp[j-1])
				}
			}
		}
		for(i in dp.lastIndex downTo 1) {
			if(dp[i] == dp[i-1]) {
				sb.append(s2[i-1])
			}
		}
		println(dp.toList())
		return dp.last()
	}

	fun isInterleave(s1: String, s2: String, s3: String): Boolean {
		if (s1.length + s2.length != s3.length) {
			return false
		}
		val m = Array(s1.length + 1, {BooleanArray(s2.length + 1)})
		m[0][0] = true
		for(i in 1..s2.length) {
			m[0][i] = m[0][i-1] && s2[i-1] == s3[i-1]
		}
		for(i in 1..s1.length) {
			m[i][0] = m[i-1][0] && s1[i-1] == s3[i-1]
		}
		for(i in 1..s1.length) {
			for(j in 1..s2.length) {
				var k = i + j - 1
				if (s2[j-1] == s3[k]) {
					m[i][j] = m[i][j-1]
				}
				if (s1[i-1] == s3[k]) {
					m[i][j] = m[i][j] or m[i-1][j]
				}
			}
		}
		//m.forEach { println(it.toList()) }
		return m.last().last()
	}
}