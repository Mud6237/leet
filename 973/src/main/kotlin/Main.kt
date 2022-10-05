// https://leetcode.com/problemset/all?search=973
// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {

	fun squredDistanceFromOrigin(p1: IntArray): Long {
		var x = p1[0].toLong()
		var y = p1[1].toLong()
		return x * x + y * y
	}
	
	private fun swap(points: Array<IntArray>, i: Int, j: Int) {
		val t = points[i]
		points[i] = points[j]
		points[j] = t
	}

	private fun partition(points: Array<IntArray>, i: Int, j: Int): Int {
		if (i < 0 || i > points.lastIndex) {
			return -1
		}
		if (j < 0 || j > points.lastIndex) {
			return -1
		}
		if (j < i) {
			return -1
		}
		val pivotDistance = squredDistanceFromOrigin(points[i])
		var x = i
		var y = j
		var k = i + 1
		while(k <= y) {
			val d = squredDistanceFromOrigin(points[k])
			if (d <= pivotDistance) {
				if (d < pivotDistance) {
					swap(points, x, k)
				}
				x = x + 1
			} else {
				swap(points, y, k)
				y = y - 1
				k = k - 1
			}
			k = k + 1
		}
		return x
	}
	
	fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
		if (k >= points.size) {
			return points
		}
		val result = Array(k, { IntArray(2) })
		var j = 0
		var startIndex = 0
		var endIndex = points.lastIndex
		var total = k
		while(total > 0 && endIndex >= startIndex) {
			var pivotIndex = partition(points, startIndex, endIndex)
			var count = (pivotIndex - startIndex) + 1
			if (count <= total) {
				for(i in startIndex..pivotIndex) {
					result[j] = points[i]
					j += 1
				}
				total = total - count
				startIndex = pivotIndex + 1
			} else {
				endIndex = pivotIndex - 1
			}
		}
		return result
	}
}
