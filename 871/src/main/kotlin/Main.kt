// https://leetcode.com/problemset/all?search=871
// https://leetcode.com/problems/minimum-number-of-refueling-stops/
import java.util.PriorityQueue

class Solution {
	fun minRefuelStops_Dp(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
		val dp = IntArray(stations.size + 1, { startFuel })
		for(i in 1..stations.size) {
			var prev = dp[i-1]
			for(j in i..stations.size) {
				val a  = if (stations[j-1][0] <= prev) stations[j-1][0] + stations[j-1][1] + Math.max(prev - stations[j-1][0], 0) else Int.MIN_VALUE
				prev = dp[j]
				dp[j] = Math.max(a, dp[j-1])
				if (dp[j] >= target) {
					return i
				}
			}
		}
		if (target <= startFuel) {
			return 0
		}
		return -1
	}
	fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int { 
		val queue = PriorityQueue<Int>()
		var f = startFuel
		var j = 0
		for(i in 1..stations.size) {
			while(j < stations.size && stations[j][0] <= f) {
				queue.add(stations[j][1])
				j += 1
			}
			if (queue.isEmpty()) {
				return -1
			}
			f += queue.poll()
			if (f >= target) {
				return i
			}
		}
		return if (target <= startFuel) 0 else -1
	}
}

fun main() {
	var target = 1
	var startFuel = 1
	var stations = arrayOf<IntArray>()
	println(Solution().minRefuelStops(target, startFuel, stations))
	target = 100
	startFuel = 10
	stations = arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40))
	println(Solution().minRefuelStops(target, startFuel, stations))
	target = 100
	startFuel = 1
	stations = arrayOf(intArrayOf(10, 100))
	println(Solution().minRefuelStops(target, startFuel, stations))
}
