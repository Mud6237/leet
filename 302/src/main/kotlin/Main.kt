//https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
class Solution {
	companion object {
		val directions = arrayOf(
			intArrayOf(0, 1),
			intArrayOf(1, 0),
			intArrayOf(-1, 0),
			intArrayOf(0, -1)
		)
	}
	private fun minAreaImpl(
		x: Int,
		y: Int,
		image: Array<CharArray>,
		xAxis: IntArray,
		yAxis: IntArray,
	) {
		xAxis[0] = Math.min(xAxis[0], x)
		xAxis[1] = Math.max(xAxis[1], x)
		yAxis[0] = Math.min(yAxis[0], y)
		yAxis[1] = Math.max(yAxis[1], y)
		image[x][y] = '2'
		for(dir in directions) {
			val u = x + dir.first()
			val v = y + dir.last()
			if (u >= 0 && u < image.size && v >= 0 && v < image[u].size && image[u][v] == '1') {
				minAreaImpl(u, v, image, xAxis, yAxis)
				image[u][v] = '2'
			}
		}
	}

	fun minArea(image: Array<CharArray>, x: Int, y: Int): Int {
		val xAxis = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
		val yAxis = intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE)
		minAreaImpl(x, y, image, xAxis, yAxis)
		val l = (xAxis.last() - xAxis.first()) + 1
		val b = (yAxis.last() - yAxis.first()) + 1
		return l * b		
	}
}