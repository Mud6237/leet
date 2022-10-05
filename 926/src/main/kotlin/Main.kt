//https://leetcode.com/problemset/all?search=926
//https://leetcode.com/problems/flip-string-to-monotone-increasing/
class Solution {
	fun minFlipsMonoIncr_cc(s: String): Int {
		var c1 = 0
		var c2 = 0
		for(c in s) {
			if (c =='1') {
				c1 += 1
			} else {
				c2 += 1
			}
			c2 = Math.min(c1, c2)
		}
		return c2
	}
	fun minFlipsMonoIncr(s: String): Int {
		var onesCount = 0
		var flipCount = 0
		for(c in s) {
			if (c == '0') {
				if (onesCount > 0) {
					onesCount -= 1
					flipCount += 1
				}
			} else {
				onesCount += 1
			}
		}
		return flipCount
	}
}

fun main() {
	println(Solution().minFlipsMonoIncr("00110"))
	println(Solution().minFlipsMonoIncr("00011000"))
	println(Solution().minFlipsMonoIncr("010110"))
	println(Solution().minFlipsMonoIncr("111011100100100"))
	println(Solution().minFlipsMonoIncr("0"))
	println(Solution().minFlipsMonoIncr("01"))
	println(Solution().minFlipsMonoIncr("1"))
	println(Solution().minFlipsMonoIncr("10"))
	println(Solution().minFlipsMonoIncr("10100"))
	println(Solution().minFlipsMonoIncr("0000010"))
	println(Solution().minFlipsMonoIncr("01111010011111110100000101110100011000000010011010"))
}
