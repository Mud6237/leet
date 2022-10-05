//https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
	fun myAtoi(s: String): Int {
		var i = 0
		// ignore leading whitespace
		while(i < s.length && s[i] == ' ') {
			i += 1
		}
		var sign = 1
		if (i < s.length) {
			if (s[i]== '-') {
				sign = -1
				i += 1
			} else if (s[i] == '+') {
				i += 1
			}
		}
		// ignore leading 0
		while(i < s.length && s[i] == '0') {
			i += 1
		}
		var prev = 0
		val limit = if (sign > 0) Int.MAX_VALUE.toLong() else Int.MIN_VALUE.toLong() * sign
		val ulimit = limit / 10
		val ul = ulimit * 10 - if (sign > 0) 2 else 1
		var overflow = false
		while(i < s.length && s[i] >= '0' && s[i] <= '9') {
			val d = s[i] - '0'
			if(prev > ulimit) {
				overflow = true
				break
			} 
			prev = prev * 10
			if (prev > ul) {
				if (d > 9 - (prev - ul)) {
					overflow = true
					break
				}
			}
			prev = prev + d
			i += 1
		}
		if (overflow) {
			return if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
		}
		return prev * sign
	}
}
