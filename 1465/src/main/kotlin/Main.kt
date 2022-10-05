//https://leetcode.com/problemset/all?search=1465
//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
class Solution {
	fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
		horizontalCuts.sort()
		var mh = h - (horizontalCuts.lastOrNull() ?: 0)
		var p = 0
		for(height in horizontalCuts) {
			mh = Math.max(mh, height - p)
			p = height
		}
		var mw = w - (verticalCuts.lastOrNull() ?: 0)
		p = 0
		for(width in verticalCuts) {
			mw = Math.max(mw, width - p)
			p = width
		}
		return mh * mw
	}
}
fun main() {
	println(Solution().maxArea(5, 4, intArrayOf(3, 1), intArrayOf(1)))
	println(Solution().maxArea(5, 4, intArrayOf(3), intArrayOf(3)))
	println(Solution().maxArea(5, 4, intArrayOf(1,2,4), intArrayOf(1,3)))
}
