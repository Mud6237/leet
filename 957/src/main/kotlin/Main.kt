//https://leetcode.com/problemset/all?search=957
//https://leetcode.com/problems/prison-cells-after-n-days/

class Solution {
	fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {
		var m = cells.joinToString("").toInt(2)
		val h = hashMapOf<Int, Int>()
		var i = 1
		var r = -1
		while(i <= n) {
			val m1 = ((m shl 2) and 255)
			val m2 = m xor m1
			val m3 = m2.inv() and 255
			val m4 = m3 shr 1 
			val m5 = m4 and 254
			m = m5
			if (r < 0) {
				r = h[m] ?: -1
				if (r >= 0) {
					val c = i - r
					i = n - ((n - i) % c)
				}
			}
			if (r < 0) {
				h[m] = i
			}
			i += 1
		}	
		var res = IntArray(cells.size)
		val mBits = m.toString(2).toCharArray()
		var j = res.lastIndex
		for(k in mBits.lastIndex downTo 0) {
			res[j] = mBits[k] - '0'
			j -= 1
		}
		return res
	}
}
