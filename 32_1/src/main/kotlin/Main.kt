//https://leetcode.com/problems/longest-valid-parentheses/
class Solution {

	private fun IntRange.contains(other: IntRange): Boolean {
		return other.start >= this.start && other.endInclusive <= this.endInclusive
	}

	private fun IntRange.adjoins(other: IntRange): Boolean {
		return this.endInclusive + 1 == other.start
	}

	private fun IntRange.merge(other: IntRange): IntRange {
		return Math.min(other.start, this.start)..Math.max(other.endInclusive, this.endInclusive)
	}

	fun longestValidParentheses(s: String): Int {
		val charStack = IntArray(s.length, { -1 })
		var charSP = -1
		val rangeStack = mutableListOf<IntRange>()
		var maxCount = 0
		for(i in 0 until s.length) {
			val c = s[i]
			if (c == ')') {
				if(charSP >=0 && s[charStack[charSP]] == '(') {
					var r = (charStack[charSP]..i)
					charSP -= 1
					while(rangeStack.isNotEmpty() && r.contains(rangeStack.last())) {
						rangeStack.removeAt(rangeStack.lastIndex)
					}
					if(rangeStack.isNotEmpty() && rangeStack.last().adjoins(r)) {
						r = rangeStack.removeAt(rangeStack.lastIndex).merge(r)
					}
					maxCount = Math.max(maxCount, r.count())
					rangeStack.add(r)
				}
			} else {
				charSP += 1
				charStack[charSP] = i
			}
		}
		return maxCount
	}
}