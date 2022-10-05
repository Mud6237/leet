//https://leetcode.com/problems/max-points-on-a-line/
import java.math.BigInteger
class Solution {

	private fun gcd(a: Int, b: Int): Int {
		if (b == 0) {
			return a
		}
		return gcd(b, a % b)
	}
	
	private fun slope(p1: IntArray, p2: IntArray): Pair<Int, Int> {
		var y = p2.last() - p1.last()
		var x = p2.first() - p1.first()
		if (y == 0) {
			return (0 to 0)
		}
		if (x < 0) {
			x =-x
			y =-y
		}
		val g = gcd(x, y)
		return (y / g to x / g)
	}

	fun maxPoints(points: Array<IntArray>): Int {
		var maxCount = 1
		for(i in 0 until points.size) {
			var hline = 1
			val h = hashMapOf<Pair<Int,Int>, Int>()
			val p1 = points[i]
			for (j in i+1 until points.size) {
				val p2 = points[j]
				if (p2.first() == p1.first()) {
					hline += 1
					maxCount = Math.max(maxCount, hline)
				} else {
					val m = slope(p1, p2)
					//println("points p1 =${p1.toList()} p2 =${p2.toList()} slope = ${m} ")
					val count = h.getOrDefault(m, 1) + 1
					//println("count = $count")
					h[m] = count
					maxCount = Math.max(maxCount, count)
				}
			}
		}
		return maxCount
	}
}