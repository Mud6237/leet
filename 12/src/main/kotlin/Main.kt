class Solution {
	fun intToRoman(num: Int): String {
		var a = listOf(
			0 to "",
			1 to "I",
			4 to  "IV",
			5 to "V",
			9 to "IX",
			10 to "X",
			40 to "XL",
			50 to "L",
			90 to "XC",
			100 to "C",
			400 to "CD",
			500 to "D",
			900 to "CM",
			1000 to "M"
		)
		var n = num
		val result = mutableListOf<String>()
		while(n > 0) {
			var i = a.binarySearchBy(n) {it.first}
			if (i < 0) {
				i = (-i - 1) - 1
			}
			val p = a[i]
			//println("i = ${i}, n = ${n}, ${a[i-1].second}")
			result.add(p.second)
			n -= p.first
		}
		return result.joinToString("")
	}
}