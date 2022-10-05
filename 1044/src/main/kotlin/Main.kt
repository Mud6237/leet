//https://leetcode.com/problemset/all?search=1044
// https://youtu.be/VpEumOuakOU?t=734
class Solution {

	companion object {
		fun<T>Array<T>.swap(i: Int, j: Int) {
			val t = this[i]
			this[i] = this[j]
			this[j] = t
		}
		fun charAtIndex(s: String, a: Array<Int>, suffixStartIndex: Int, charIndex: Int): Char {
			return s[a[suffixStartIndex] + charIndex]
		}
		fun lengthOf(s: String, a: Array<Int>, suffixStartIndex: Int): Int {
			return s.length - a[suffixStartIndex]
		}
		fun lastIndexOf(s: String, a: Array<Int>, suffixStartIndex: Int): Int {
			return lengthOf(s, a, suffixStartIndex) - 1
		}

	}

	fun partition(s: String, a: Array<Int>, charIndex: Int, m: Int, n: Int): Pair<Int, Int> {
		var pivotIndex = m
		while(pivotIndex <= n && charIndex > lastIndexOf(s, a, pivotIndex))  {
			pivotIndex += 1
		}
		if (pivotIndex > n) {
			return Pair(Int.MIN_VALUE, Int.MAX_VALUE)
		}
		if (pivotIndex != m) {
			a.swap(pivotIndex, m)
			pivotIndex = m
		}
		//println(a[pivotIndex])
		//println(a[pivotIndex][charIndex])
		//val pivotChar = a[pivotIndex][charIndex]
		val pivotChar = charAtIndex(s, a, pivotIndex, charIndex)
		var i = m
		var j = n
		var k = pivotIndex + 1
		while(k <= j) {
			//println("K = $k, i = $i , j = $j ")
			//if (a[k].lastIndex < charIndex) {
			if (lastIndexOf(s, a, k) < charIndex) {
				a.swap(i, k)
				i += 1
			//} else if (a[k][charIndex] < pivotChar) {
			} else if (charAtIndex(s, a, k, charIndex) < pivotChar) {
				a.swap(i, k)
				i += 1
			//} else if (a[k][charIndex] > pivotChar) {
			} else if (charAtIndex(s, a, k, charIndex) > pivotChar) {
				a.swap(j, k)
				j -= 1
				k -= 1
			}
			//println("${a.toList()}")
			k += 1
		}
		return Pair(i-1, j+1)
	}

	fun fatRadixSort(s: String, a: Array<Int>, charIndex: Int,  m: Int, n: Int) {
		var (x, y) = partition(s, a, charIndex, m, n)
		if (m >= 0 && x > m) {
			fatRadixSort(s, a, charIndex, m, n = x)
		}
		if ( x + 1 >= 0 && y - 1 < s.length && y - x - 1 > 1 ) {
			fatRadixSort(s, a, charIndex + 1, m = x + 1,  n = y - 1)
		}
		if (n < s.length && y < n) {
			fatRadixSort(s, a, charIndex, m = y, n)
		}
	}

	fun computeLCP(s: String, suffixArray: Array<Int>): Array<Int> {
		val rankArray = Array<Int>(suffixArray.size, { 0 })
		for((i, v) in suffixArray.withIndex()) {
			rankArray[v] = i
		}
		val lcp = Array<Int>(suffixArray.size, { 0 })
		var l = 0
		for(i in 0..rankArray.lastIndex - 1) {
			val r = rankArray[i]
			while(charAtIndex(s, suffixArray, r, l) == charAtIndex(s, suffixArray, r-1, l)) {
				l += 1
			}
			lcp[r] =l
			//println("comparing ${s.substring(suffixArray[r], s.length)} and ${s.substring(suffixArray[r-1], s.length)} lcp value = ${lcp[r]} ")
			l = Math.max(l - 1, 0)
		}
		return lcp
	}
	
	fun longestDupSubstring(s: String): String {
		val str = "$s$"
		val suffixArray = Array<Int>(str.length, { it })
		fatRadixSort(str, suffixArray, charIndex = 0,  m = 0, n = suffixArray.lastIndex)
		val lcpArray = computeLCP(str, suffixArray)
		var maxLcpValue = Int.MIN_VALUE
		var maxLcpIndex = Int.MIN_VALUE
		for((lcpIndex, lcpValue) in lcpArray.withIndex()) {
			if ( lcpValue > maxLcpValue ) {
				maxLcpValue = lcpValue
				maxLcpIndex = lcpIndex
			}
		}
		val suffixIndex = suffixArray[maxLcpIndex]
		return "${str.substring(suffixIndex, suffixIndex + maxLcpValue)}"
	}

	fun longestDupSubstring_bruteForce(s: String): String {
		var m = 0
		var n = 0
		var l = 0
		for(i in 0..s.lastIndex) {
			var j = i
			var p = i + Math.max(1, l)
			while(p < s.lastIndex) {
				var k = p
				while(k <= s.lastIndex && s[j] == s[k]) {
					j += 1
					k += 1
				}
				if (j - i > l) {
					l = j - i
					m = i
					n = j
				}
				j = i
				p = Math.max(k, p+1)
			}
		}
		return s.substring(m, n)
	}
}

fun main(args: Array<String>) {
	println(Solution().longestDupSubstring("abacadabrabracabracadabrabrabracad"))
	println(Solution().longestDupSubstring("ba"))
	println(Solution().longestDupSubstring("b"))
	println(Solution().longestDupSubstring(""))
	println(Solution().longestDupSubstring("banana"))	
}
