//https://leetcode.com/problemset/all?search=696
class Solution {
	fun countBinarySubstrings(s: String): Int {
		var i = 0
		var count = 0
		var p = 0
		while(i < s.length) {
			var c = s[i]
			var j = i + 1
			while(j < s.length && s[j] == c) {
				j += 1
			}
			val k = j - i
			count += Math.min(p, k)
			p = k
			i = j
		}
		return count
	}
}