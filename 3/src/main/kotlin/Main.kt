//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
	fun lengthOfLongestSubstring(s: String): Int {
		val h = IntArray(128, { -1 })
		var r = 0
		var len = 0
		var k = 0x00.toChar()
		for(i in 0..s.lastIndex) {
			val c = s[i]
			val j = c - k
			if (h[j] >= r) {
				r = h[j] + 1
			}
			len = Math.max(len, (i - r) + 1)
			h[j] = i
		}
		return len
	}
}
