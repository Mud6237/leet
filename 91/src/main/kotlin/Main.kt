//https://leetcode.com/problemset/all?search=91
//https://leetcode.com/problems/decode-ways/
class Solution {
	fun atoi(c: Char): Int {
		return c - '0'
	}
	fun numDecodings(s: String): Int {
		if (s.length < 1 || atoi(s.first()) == 0) {
			return 0
		}
		val countArray = IntArray(s.length)
		countArray[0] = 1
		for(i in 1 until s.length) {
			val c = atoi(s[i])
			val p = atoi(s[i-1])
			if (c == 0) {
				if (p != 0 && "$p$c".toInt() <= 26) {
					countArray[i] = if (i > 1) countArray[i-2] else 1
				} else {
					countArray[i] = 0
				}
			} else {
				if (p != 0 && "$p$c".toInt() <= 26) {
					countArray[i] = countArray[i-1] + if (i > 1) countArray[i-2] else 1
				} else {
					countArray[i] = countArray[i-1]
				}
			}
		}
		return countArray[s.length - 1]
	}
}

fun main() {
	println(Solution().numDecodings("12"))
	println(Solution().numDecodings("226"))
	println(Solution().numDecodings("06"))

	println(Solution().numDecodings("110"))
	println(Solution().numDecodings("110602"))
	println(Solution().numDecodings("11102"))

	println(Solution().numDecodings("11210"))
	println(Solution().numDecodings("10"))

	println(Solution().numDecodings("1123"))
	println(Solution().numDecodings("111123"))
	println(Solution().numDecodings("9123"))
	println(Solution().numDecodings("1023"))
	println(Solution().numDecodings("11023"))
	println(Solution().numDecodings("1101223"))
	

}
