// https://leetcode.com/problemset/all?search=273

class Solution {
	
	val lessThan20 = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
							 "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
							 "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
							)
	val multipleOf10 = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

	val billon = 1_000_000_000
	val millon = 1_000_000
	val thousand = 1_000

	fun numberToWords(num: Int): String {
		if (num == 0) {
			return "Zero"
		}
		val sb = StringBuilder()
		numberToWordsImpl(num, sb)
		return sb.trim().toString()
	}

	private fun numberToWordsImpl(num: Int, sb: StringBuilder) {
		if (num >= billon) {
			numberToWordsImpl(num/billon, sb)
			sb.append(" Billion ")
			numberToWordsImpl(num%billon, sb)
		} else if (num >= millon) {
			numberToWordsImpl(num/millon, sb)
			sb.append(" Million ")
			numberToWordsImpl(num%millon, sb)
		} else if (num >= thousand) {
			numberToWordsImpl(num/thousand, sb)
			sb.append(" Thousand ")
			numberToWordsImpl(num%thousand, sb)
		} else if (num >= 100) {	
			val t = num % 100
			sb.append(lessThan20[num/100], " Hundred ", multipleOf10[t / 10], " ", lessThan20[t % 10])
		} else if (num >= 20) {
			sb.append(multipleOf10[num / 10], " ", lessThan20[num % 10])
		} else {
			sb.append(lessThan20[num])
		}
	}
	
	

}

fun main(args: Array<String>) {
	println(Solution().numberToWords(123))
	println(Solution().numberToWords(12345))
	println(Solution().numberToWords(1234567))
	println(Solution().numberToWords(1234567891))
}
