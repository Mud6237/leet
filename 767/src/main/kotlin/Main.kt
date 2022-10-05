//https://leetcode.com/problemset/all?search=767
// https://leetcode.com/problems/reorganize-string/
class Solution {

	fun swap(a: IntArray, i: Int, j: Int) {
		val t = a[i]
		a[i] = a[j]
		a[j] = t
	}

	fun reorganizeString(s: String): String {
		var a = IntArray(26)
		var u = 0
		for(c in s) {
			a[c - 'a'] += 1
			if(a[c - 'a'] == 1) {
				u += 1
			}
		}
		var b = a.copyOf()
		a = IntArray(26, { it })
		for(i in 0 until 26) {
			for(j in i+1 until 26) {
				if (b[j] < b[i]) {
					swap(b, i, j)
					swap(a, i, j)
				}
			}
		}
		var e = 0
		var t = 0
		for(charCount in b) {
			val p = Math.max(0, charCount - (t + 1))
			t = (t + charCount - e)
			e = p
		}
		if (e > 0) {
			return ""
		}
		var result = ByteArray(s.length)
		var x = 0
		for(i in 0 until b.last()) {
			result[x] = (97 + a.last()).toByte()
			x += 2
		}
		x -= 1
		for(i in 1 until u) {
			var j = b.lastIndex - i
			for(k in 0 until b[j]) {
				if (x >= s.length) {
					x = 1
				}
				result[x] = (97 + a[j]).toByte()
				x += 2
			}
		}
		return result.toString(Charsets.UTF_8)
	}
}
fun main() {
	println(Solution().reorganizeString("aaab"))
	println(Solution().reorganizeString("aabbbb"))
	println(Solution().reorganizeString("aaabcd"))
	println(Solution().reorganizeString("aaabbbcdd"))
	println(Solution().reorganizeString("aaabbbcdd"))
	println(Solution().reorganizeString("bfrbs"))
}
