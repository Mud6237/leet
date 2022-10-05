//https://leetcode.com/problemset/all?search=223
//https://leetcode.com/problems/rectangle-area/

class Solution {

	fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
		val a1 = Math.abs((ax2 - ax1) * (ay1 - ay2))
		val a2 = Math.abs((bx2 - bx1) * (by2 - by1))
		var overlapArea: Int
		if (
			bx1 > ax2 ||
			bx2 < ax1 ||
			by2 < ay1 ||
			by1 > ay2
 		) {
			overlapArea = 0
		} else {
			val x1 = Math.max(ax1, bx1)
			val y1 = Math.max(ay1, by1)
			val x2 = Math.min(ax2, bx2)
			val y2 = Math.min(ay2, by2)
			overlapArea = Math.abs((x2-x1) * (y2-y1))
		}
		return a1 + a2 - overlapArea
	}
}

fun main() {}
