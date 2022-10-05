class Solution {
	companion object {
		fun charToIndex(c: Char): Int {
			if (c >= 'a' && c <= 'z') {
				return c - 'a'
			}
			return c - 'A' + 26
		}
	}
	fun minWindow(s: String, t: String): String {
		val cMap = IntArray(26 * 2)
		for(c in t) {
			cMap[charToIndex(c)] += 1
		}
		var l = 0
		var r = 0
		var k = 0
		var x = 0
		var y = 0
		var d = Int.MAX_VALUE
		val wMap = IntArray(cMap.size)
		while(r < s.length) {
			val mMap = cMap.copyOf()
			while(r < s.length && k != t.length) {
				//println("inner loop c = ${s[r]} k = $k")
				val ci = charToIndex(s[r])
				if (mMap[ci] > 0 && wMap[ci] < cMap[ci]) {
					k += 1
					mMap[ci] -= 1
				}
				wMap[ci] += 1
				r += 1
			}
			//println("r = ${s.substring(l, r)} k = $k")
			if (k != t.length) {
				break
			}
			while(
				l < r &&
				wMap[charToIndex(s[l])] > cMap[charToIndex(s[l])]
			) {
				wMap[charToIndex(s[l])]	-= 1
				l += 1
			}
			//println("l = $l, r = $r")
			//println("shortest slice = ${s.slice(l until r)} \n")
			if (r - l < d) {
				d = r - l
				x = l
				y = r
				if (d == t.length) {
					break
				}
			}
			wMap[charToIndex(s[l])] -= 1
			l += 1
			k -= 1
		}
		return s.slice(x until y)
	}
}