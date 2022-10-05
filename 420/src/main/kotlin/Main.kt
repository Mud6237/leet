// https://leetcode.com/problemset/all?search=420
// https://leetcode.com/problems/strong-password-checker/

class Solution {
	companion object {
		fun isLowerCase(c: Char): Boolean {
			return c >= 'a' && c <= 'z'
		}
		fun isUpperCase(c: Char): Boolean {
			return c >= 'A' && c <= 'Z'
		}
		fun isDigit(c: Char): Boolean {
			return c >= '0' && c <= '9'
		}
	}

	fun strongPasswordChecker(password: String): Int {
		var uppercaseReplacement = 1
		var lowercaseReplacement = 1
		var digitReplacement = 1
		var repeatingSeqRemoval = 0
		var lastChar = Char.MAX_VALUE
		var lastMatchingCharIndex = 0
		for((i, c) in password.withIndex()) {
			lowercaseReplacement = if (isLowerCase(c)) 0 else lowercaseReplacement
			uppercaseReplacement = if (isUpperCase(c)) 0 else uppercaseReplacement
			digitReplacement = if (isDigit(c)) 0 else digitReplacement
			if (c != lastChar) {
				val seqLength = i - lastMatchingCharIndex
				repeatingSeqRemoval += Math.max(seqLength - 2, 0)
				lastMatchingCharIndex = i
			}
			lastChar = c
		}
		if (lastMatchingCharIndex != password.lastIndex) {
			val seqLength = password.length - lastMatchingCharIndex
			repeatingSeqRemoval += Math.max(seqLength - 2, 0)
		}
		//println("lastMatchingCharIndex = $lastMatchingCharIndex repeatingSeqRemoval $repeatingSeqRemoval")
		var excessRemoval = Math.max(password.length - 20, 0)
		repeatingSeqRemoval = Math.max(repeatingSeqRemoval - excessRemoval, 0)
		var insertCount = Math.max(6 - password.length, 0)
		var replacementCount = uppercaseReplacement + lowercaseReplacement + digitReplacement
		replacementCount = Math.max(replacementCount - insertCount - repeatingSeqRemoval, 0)
		//println("excessRemoval =${excessRemoval}")
		//println("repeatingSeqRemoval =${repeatingSeqRemoval}")
		//println("insertCount =${insertCount}")
		//println("replacementCount =${replacementCount}")
		return insertCount + replacementCount + repeatingSeqRemoval + excessRemoval
	}
}

fun main() {
	println(Solution().strongPasswordChecker("1337C0d3"))
	println(Solution().strongPasswordChecker("a"))
	println(Solution().strongPasswordChecker("aA1"))
	println(Solution().strongPasswordChecker("aaa"))
	println(Solution().strongPasswordChecker("!@#!D#!###"))
}
