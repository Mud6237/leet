//https://leetcode.com/problemset/all?search=420
//https://leetcode.com/problems/strong-password-checker/
import java.util.PriorityQueue

class Solution {
	private fun isUppercase(c: Char): Boolean {
		return c >= 'A' && c <= 'Z'
 	}

	private fun isLowerCase(c: Char): Boolean {
		return c >= 'a' && c <= 'z'
 	}

	private fun isDigit(c: Char): Boolean {
		return c >= '0' && c <= '9'
 	}

	fun strongPasswordChecker(password: String): Int {
		var lowerCase = 1
		var upperCase = 1
		var digit = 1
		var i = 0
		val pq = PriorityQueue<Int>({ a, b -> a % 3 - b % 3})
		var replaceCount = 0
		while(i < password.length) {
			val c = password[i]
			lowerCase = if(isLowerCase(c)) 0 else lowerCase
			upperCase = if(isUppercase(c)) 0 else upperCase
			digit = if(isDigit(c)) 0 else digit
			var j = i
			var k = j + 1
			while(k < password.length && password[k] == password[j]) {
				k += 1
			}
			val count = (k - j)
			replaceCount += count / 3
			if (count > 2) {
				pq.add(count)
			}
			i = k
		}
		val misses = lowerCase + upperCase + digit
		if (password.length < 6) {
			return Math.max(6-password.length, misses)
		}
		if (password.length <= 20) {
			return Math.max(replaceCount, misses)
		}
		var removals = Math.max(password.length - 20, 0)
		var r = removals
		//println("pq = $pq")
		//println("removals = $removals")
		while(r > 0 && pq.isNotEmpty()) {
			val t = pq.poll() - 1
			if (t > 2) {
				pq.add(t)
			}
			r -= 1
		}
		//println("pq after removals = $pq")
		var edits = 0
		for(p in pq) {
			edits += p / 3
		}
		//println("edits = $edits removals = $removals misses = $misses")
		return removals + Math.max(edits, misses)
	}
}