// https://leetcode.com/problemset/all?search=218
// https://leetcode.com/problems/the-skyline-problem/
class Solution {
	fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
		// Spilt the buildings into left and right points at axis
		val points = Array(buildings.size * 2, { IntArray(2) })
		for((i, b) in buildings.withIndex()) {
			var j = i * 2
			points[j][0] = b[0]
			points[j+1][0] = b[1]
		}
		// For each point, figure out the tallest buildings standing at the point
		for(b in buildings) {
			for(p in points) {
				if (p[0] >= b[0] && p[0] < b[1] ) { // '<' not '<=' 
					p[1] = Math.max(p[1], b[2])
				}
			}
		}
		points.sortWith{p1, p2 ->
			p1.first() - p2.first()
		}
		val result = mutableListOf<List<Int>>()
		var prev = 0
		for(p in points) {
			if (p[1] != prev) {
				result.add(p.toList())
			}
			prev = p[1]
		}
		return result
	}
}

fun main(args: Array<String>) {
	var buildings = arrayOf(intArrayOf(2,9,10),intArrayOf(3,7,15),intArrayOf(5,12,12),intArrayOf(15,20,10),intArrayOf(19,24,8))
	var result = Solution().getSkyline(buildings)
	println(result)
	buildings = arrayOf(intArrayOf(0,2,3),intArrayOf(2,5,3))
	result = Solution().getSkyline(buildings)
	println(result)
 }
