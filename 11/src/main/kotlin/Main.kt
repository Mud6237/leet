//https://leetcode.com/problemset/all?search=11
//https://leetcode.com/problems/container-with-most-water/
class Solution {
	fun maxArea(height: IntArray): Int {
		var i = 0
		var j = height.lastIndex
		var maxArea = Int.MIN_VALUE
		while(j > i) {
			maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i))
			//println("maxArea = $maxArea, i = $i, j = $j height[i] = ${height[i]} height[j]=${height[j]}")
			if (height[i] < height[j]) {
				i += 1
			} else if (height[j] < height[i]) {
				j -= 1
			} else {
				j -= 1
				i += 1
			}
		}
		return maxArea
	}
}
