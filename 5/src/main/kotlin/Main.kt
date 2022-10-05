//https://leetcode.com/problemset/all?search=5
//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
	fun longestPalindrome(s: String): String {
		if (s.length < 1) {
			return ""
		}
		var mx = -1
		var my = -1
		var i = 0
		while(i  < 2 * s.length) {
			var x = if (i % 2 == 0) i / 2 - 1 else i / 2
			var y = if (i % 2 == 0) i / 2 + 1 else (i + 1) / 2
			while (x >=0 && y < s.length && s[x] == s[y] ) {
				x -= 1
				y += 1
			}
			var l = y - x
			if (l > my - mx) {
				my = y
				mx = x
			}
			i += 1
		}
		return s.substring(Math.max(mx + 1, 0), Math.min(my, s.length))
	}
}