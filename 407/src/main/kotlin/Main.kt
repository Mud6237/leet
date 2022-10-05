//https://leetcode.com/problemset/all?search=407
//https://leetcode.com/problems/trapping-rain-water-ii/
class Solution {
	fun trapRainWater(heightMap: Array<IntArray>): Int {
		val a = Array(heightMap.size, { IntArray(heightMap[it].size) })
		var colMax = heightMap.first().copyOf()
		var rowMax = IntArray(heightMap.size, { heightMap[it].first() })
		for(i in 0 until heightMap.size) {
			for(j in 0 until heightMap[i].size) {
				colMax[j] = Math.max(colMax[j], heightMap[i][j])
				rowMax[i] = Math.max(rowMax[i], heightMap[i][j])
				a[i][j] = Math.min(colMax[j], rowMax[i])
			}
		}
		//heightMap.forEach { println(it.toList()) }
		//println("Max Array")
		//a.forEach { println(it.toList()) }
		colMax = heightMap.last().copyOf()
		rowMax = IntArray(heightMap.size, {heightMap[it].last()})
		for(i in heightMap.lastIndex downTo 0) {
			for(j in heightMap[i].lastIndex downTo 0) {
				colMax[j] = Math.max(colMax[j], heightMap[i][j])
				rowMax[i] = Math.max(rowMax[i], heightMap[i][j])
				a[i][j] = Math.min(a[i][j], Math.min(colMax[j], rowMax[i]))
			}
		}
		var cap = 0
		for(i in 0 until a.size) {
			for (j in 0 until a[i].size) {
				cap += a[i][j] - heightMap[i][j]
			}
		}
		//println("Max Array")
		//a.forEach { println(it.toList()) }
		//println("cap = $cap")
		return cap
	}
}
fun main() {
	val heightMap = arrayOf(intArrayOf(1,4,3,1,3,2),intArrayOf(3,2,1,3,2,4),intArrayOf(2,3,3,2,3,1))
	println(Solution().trapRainWater(heightMap))
}
