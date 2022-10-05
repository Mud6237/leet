//https://leetcode.com/problemset/all?search=17
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
	fun letterCombinations(digits: String): List<String> {
		if (digits.length < 1) {
			return emptyList<String>()
		}
		val h = arrayOf(
			charArrayOf('a', 'b', 'c'),
			charArrayOf('d', 'e', 'f'),
			charArrayOf('g', 'h', 'i'),
			charArrayOf('j', 'k', 'l'),
			charArrayOf('m', 'n', 'o'),
			charArrayOf('p', 'q', 'r', 's'),
			charArrayOf('t', 'u', 'v'),
			charArrayOf('w', 'x', 'y', 'z')
		)
		var result = mutableListOf("")
		for(digit in digits) {
			var i = digit - '0' - 2
			val resultNext = mutableListOf<String>()
			for(r in result) {
				for(c in h[i]) {
					resultNext.add(r + c)
				}
			}
			result = resultNext
		}
		return result
	}
}
