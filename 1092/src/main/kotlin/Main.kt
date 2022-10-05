//https://leetcode.com/problemset/all?search=1092
//https://leetcode.com/problems/shortest-common-supersequence/
class Solution {

	private fun longestCommonSubsequence(
		s1: String,
		s2: String
	): String {
		val a = Array(s1.length +1, { IntArray(s2.length + 1)})
		for(i in 1..s1.length) {
			var c1 = s1[i-1]
			for(j in 1..s2.length) {
				var c2 = s2[j-1]
				if (c1 == c2) {
					a[i][j] = a[i-1][j-1] + 1
				} else {
					a[i][j] = Math.max(a[i-1][j], a[i][j-1])
				}
			}
		}
		if (a.last().last() == s2.length) {
			return s2
		}
		var sb = StringBuilder()
		var i = a.lastIndex
		var j = a[i].lastIndex
		while(i > 0 && j > 0) {
			if(s1[i-1] == s2[j-1]) {
				sb.append(s1[i-1])
				i -= 1
				j -= 1
			} else {
				if (a[i-1][j] >= a[i][j-1]) {
					i -= 1
				} else {
					j -= 1
				}
			}
		}
		sb.reverse()
		return sb.toString()
	}

	fun shortestCommonSupersequence(str1: String, str2: String): String {
		var s1 = str1
		var s2 = str2
		if (s2.length > s1.length) {
			s1 = str2
			s2 = str1
		}
		val lcs = longestCommonSubsequence(s1, s2)
		if (lcs.length == s2.length) {
			return s1
		}
		var res = StringBuilder()
		var i = 0
		var j = 0
		for(c in lcs) {
			while(s1[i] != c) {
				res.append(s1[i])
				i += 1
			}
			while(s2[j] != c) {
				res.append(s2[j])
				j += 1
			}
			res.append(c)
			i += 1
			j += 1
		}
		res.append(s1.substring(i))
		res.append(s2.substring(j))
		return res.toString()
	}
}
