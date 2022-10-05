// https://leetcode.com/problemset/all?search=30
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
import java.util.Random
import java.math.BigInteger

class Solution {
	companion object {
		fun charToInt(c : Char): Int = c - 'a' + 97
	}
	class StringMatcher(var patterns: Array<String>) {
		private val patternLength = patterns.first().length
		private val radix = 256
		private val randomPrime = BigInteger.probablePrime(31, Random()).toInt()
		private val patternHashesToIndexMap = patterns.mapIndexed{ idx, p -> hash(p) to idx }.toMap()
		private var RM: Long = (1..patternLength-1).fold(1L) { acc, _ -> (acc * radix) % randomPrime }
		
		// horners method
		fun hash(str: String, l: Int = str.length): Long {
			var h = 0L
			for(i in 0 until l) {
				h = (h * radix + charToInt(str[i])) % randomPrime
 			}
			return h
		}

		fun lasVegasCheck(s: String, p: String, sIndex: Int): Boolean {
			for(i in 0 until p.length) {
				if (s[sIndex + i] != p[i]) {
					return false
				}
			}
			return true
		}

		fun findAllOccurenceInString(str: String): HashMap<Int, Int> {
			if (str.length < patternLength) {
				return hashMapOf<Int, Int>()
			}
			val occurences = HashMap<Int, Int>()
			var strHash = hash(str, patternLength)
			var p = patternHashesToIndexMap[strHash]
			if (p != null && lasVegasCheck(str, patterns[p], 0) ) {
				occurences[0] = p
			}
			for(i in patternLength until str.length) {
				// recalculate the hash
				strHash = (strHash + randomPrime - charToInt(str[i-patternLength]) * RM % randomPrime) % randomPrime
				strHash = (strHash * radix + charToInt(str[i])) % randomPrime
				p = patternHashesToIndexMap[strHash]
				if (p != null && lasVegasCheck(str, patterns[p], i - patternLength + 1)) {
					occurences[i-patternLength + 1] = p
				}	
			}
			return occurences
		}
	}

	fun findSubstring(s: String, words: Array<String>): List<Int> {
		var patternLength = words.first().length
		val matcher = StringMatcher(words)
		val matches = matcher.findAllOccurenceInString(s)
		val occurences = matches.keys.toMutableList()
		occurences.sort()
		var i = 0
		val result = mutableListOf<Int>()
		while(i < occurences.size - words.size + 1) {
			var j = i + 1
			var u = hashSetOf<Int?>(matches[occurences[i]])
			var valid = true
			while(j <= i + words.size - 1) {
				if (occurences[j] - occurences[j-1] != patternLength || u.contains( matches[occurences[j]] )) {
					valid = false
					break
				}
				u.add(matches[occurences[j]])
				j += 1
			}
			if (valid) {
				result.add(occurences[i])
			}
			i += 1
		}
		return result
	}
}
fun main() {
	val s  = "barfoothefoobarman"
	val words = arrayOf("foo","bar")
	println(Solution().findSubstring(s, words))
}
