// https://leetcode.com/problemset/all?search=1312
// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
class Solution {
	fun minInsertions(s: String): Int {
		val lcs = Array(s.length + 1, { IntArray(s.length + 1) })
		for(i in 1..s.length) {
			for(k in 1..s.length) {
				val j = s.length - k
				if (s[i - 1] == s[j]) {
					lcs[i][k] = 1 + lcs[i-1][k-1]
				} else {
					lcs[i][k] = Math.max(lcs[i][k-1], lcs[i-1][k])
				}
			}
		}
		return s.length - lcs[s.length][s.length]
	}
}

fun main() {
	println(Solution().minInsertions("leetcode"))
	println(Solution().minInsertions("mbadm"))
	println(Solution().minInsertions("zzazz"))
}
