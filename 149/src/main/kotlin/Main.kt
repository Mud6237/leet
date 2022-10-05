class Solution {
	private fun slope(p1: IntArray, p2: IntArray): String {
		val y = (p2[1] - p1[1]).toDouble()
		val x = (p2[0] - p1[0]).toDouble()
		return "${y.toDouble() / x.toDouble()}"
	}
	private fun intercept(p: IntArray, m: Int): Int {
		return (p[1] - m * p[0])
	}

	fun maxPoints(points: Array<IntArray>): Int {
		val m = hashMapOf<String, Int>()
		var c = 0
		for(i in 0..points.lastIndex) {
			for(j in (i+1)..points.lastIndex) {
				val slope = slope(points[j], points[i])
				/val intercept = intercept(points[j], slope)
				/val k = Pair(slope, intercept)
				//println("Points x = ${points[i].toList()}, y =${points[j].toList()} P = $k")
				val d = m.getOrDefault(k, 1) + 1
				c = Math.max(c, d)
				m[k] = d
			}
		}
		return c
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
