// https://leetcode.com/problemset/all?search=132
// https://leetcode.com/problems/palindrome-partitioning-ii/
class Solution {
	fun lps(s: String, m: Int = 0, n: Int = s.length): IntRange {
		var maxLength = Int.MIN_VALUE
		var x = m
		var y = m
		for(e in m + 1 until (2 * n) - 1) {
			var i = e / 2 - 1
			var j = (e - 1) / 2 + 1
			while(i >= m && j < n && s[i] == s[j]) {
				i -= 1
				j += 1
			}
			i += 1
			j -= 1
			if ((j - i) + 1 > maxLength) {
				maxLength = j - i + 1
				x = i
				y = j
			}
		}
		return x..y
	}

	fun minCutImpl(str: String, s: Int, e: Int): Int {
		var r = lps(str, s, e)
		var count = r.count()
		if (count == 1) {
			return e - s - 1
		}
		if (count == e - s) {
			return 0
		}
		var lowerRange = s until r.start
		var lowerCount = if (lowerRange.isEmpty()) 0 else minCutImpl(str, s, r.start)
		var upperRange = r.endInclusive+1 until e
		var upperCount = if (upperRange.isEmpty()) 0 else minCutImpl(str, r.endInclusive + 1, e)
		return 1 + lowerCount + upperCount
	}

	fun minCut(s: String): Int {
		return minCutImpl(s, 0, s.length)
	}
}
fun main() {
	println(Solution().minCut("banana"))
	println(Solution().minCut("aab"))
	println(Solution().minCut("a"))
	println(Solution().minCut("ab"))
}
