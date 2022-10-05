// https://leetcode.com/problemset/all?search=564
// https://leetcode.com/problems/find-the-closest-palindrome/discuss/649229/C%2B%2B-Concise-and-Easy-to-Understand-with-Explanation-Faster-than-100
import kotlin.math.pow
class Solution {
	fun nearesetPalindromic(n: String): String {
		if (n.length == 1) {
			return "${n.toInt() - 1}"
		}
		val candidatePalindromes = mutableListOf<Long>()
		// if the next closest palindrome has one more digit
		var base = 10.0
		val p = base.pow(n.length)
		candidatePalindromes.add((p + 1).toLong())
		//println("$candidatePalindromes")
		// if the next closest palindrome has one less digit
		candidatePalindromes.add(((p / 10) - 1).toLong() )
		//println("$candidatePalindromes")

		// if the next closest palindrome has the same number of digits

		val prefixEndIndex = (n.lastIndex - 1) / 2
		val suffixStartIndex = (n.length + 1) / 2
		val k = suffixStartIndex - prefixEndIndex - 1

		// if the next closest palindrome has the same number of digits and middle digit decreases by 1
		var middleNumber = "${n[prefixEndIndex]}".toInt() - 1
		var front = n.substring(0, prefixEndIndex)
		var reverseFront = front.reversed()
		var digitAfterMiddle = n.substring(prefixEndIndex+1, prefixEndIndex+1+k).take(k)
		candidatePalindromes.add("$front$middleNumber$digitAfterMiddle$middleNumber$reverseFront".toLong())
		//println(candidatePalindromes)

		// if the next closest palindrome has the same number of digits and middle digit stays the same so the last part is the mirror of the first part
		front = n.substring(0, prefixEndIndex+1)
		reverseFront = front.reversed()
		candidatePalindromes.add("$front$digitAfterMiddle$reverseFront".toLong())
		//println(candidatePalindromes)

		// if the next closest palindrome has the same number of digits and middle digit increase by 1 
		middleNumber = "${n[prefixEndIndex]}".toInt() + 1
		front = n.substring(0, prefixEndIndex)
		reverseFront = front.reversed()
		candidatePalindromes.add("$front$middleNumber$digitAfterMiddle$middleNumber$reverseFront".toLong())
		//println(candidatePalindromes)
		val longN = n.toLong()
		var r = candidatePalindromes.first()
		var m = Long.MAX_VALUE
		for(v in candidatePalindromes) {
			val d = Math.abs(longN - v) 
			if (d < m && d > 0 ) {
				r = v
				m = d
			}
		}
		return "$r"
	}
}

fun main(args: Array<String>) {
	println(Solution().nearesetPalindromic("4723"))
	println(Solution().nearesetPalindromic("723"))
	println(Solution().nearesetPalindromic("12"))
	println(Solution().nearesetPalindromic("10"))
	println(Solution().nearesetPalindromic("999"))
}
