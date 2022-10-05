// https://leetcode.com/problemset/all?search=32

class Solution {
	fun longestValidParentheses(s: String): Int {
		val stack = mutableListOf<Int>()
		var m = 0
		for(i in 0 until s.length) {
			if (s[i] == '(') {
				stack.add(i)
			} else {
				val k = stack.removeLastOrNull() ?: continue
				m = Math.max(m, (i - k) + 1)
			}
		}
		return m
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
