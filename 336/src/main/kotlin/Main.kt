//https://leetcode.com/problemset/all?search=336
//https://leetcode.com/problems/palindrome-pairs/
// https://leetcode.com/problems/palindrome-pairs/discuss/79215/Easy-to-understand-AC-C%2B%2B-solution-O(n*k2)-using-map

class Solution {
	companion object {
		fun isPlaindrome(s: String): Boolean {
			var i = 0
			var j = s.lastIndex
			while(i < j && s[i] == s[j]) {
				i += 1
				j -= 1
			}
			return i >= j
		}
	}
	fun palindromePairs(words: Array<String>): List<List<Int>> {
		val h = hashMapOf<String, Int>()
		var emtpyStringIndex = -1
		val result = mutableListOf<List<Int>>()
		for((index, word) in words.withIndex()) {
			if (word.isEmpty()) {
				emtpyStringIndex = index
				continue
			}
			h[word.reversed()] = index
		}
		for((i, word) in words.withIndex()) {
			if (emtpyStringIndex >= 0) {
				if (isPlaindrome(word) && word.isNotEmpty()) {
					result.add(listOf(i, emtpyStringIndex))
					result.add(listOf(emtpyStringIndex, i))
				}
			}
			if (word.isEmpty()) {
				continue
			}
			for(j in 0..word.lastIndex) {
				val left = word.slice(0..j)
				val right = word.slice(j+1 until word.length)
				val leftCompanionIndex = h[left] ?: -1
				val rightCompanionIndex = h[right] ?: -1
				if (leftCompanionIndex >=0 && isPlaindrome(right) && leftCompanionIndex != i) {
					result.add(listOf(i, leftCompanionIndex))
				}
				if (rightCompanionIndex >=0 && isPlaindrome(left) && rightCompanionIndex != i) {
					result.add(listOf(rightCompanionIndex, i))
				}
			}
		}
		return result
	}
}

fun main() {
	println("Hello World!")
}
