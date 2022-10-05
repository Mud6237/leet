//https://leetcode.com/problemset/all?search=120
//https://leetcode.com/problems/triangle/
class Solution {
	fun minimumTotal(triangle: List<List<Int>>): Int {
		var previousLevel = triangle.last()
		for(j in triangle.lastIndex-1 downTo 0) {
			var currentLevel = triangle[j].toMutableList()
			for(i in 0 until currentLevel.size) {
				val v = currentLevel[i]
				if(i < previousLevel.size) {
					currentLevel[i] += previousLevel[i]
				}
				if (i+1 < previousLevel.size) {
					currentLevel[i] = Math.min(currentLevel[i], v + previousLevel[i+1])
				}
			}
			previousLevel = currentLevel
		}
		return previousLevel.first()
	}
}