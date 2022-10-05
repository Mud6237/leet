//https://leetcode.com/problemset/all?search=815
// https://leetcode.com/problems/bus-routes/

class Solution {
	fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
		val graph = hashMapOf<Int, MutableList<Int>>()
		for((index, route) in routes.withIndex()) {
			for(stop in route) {
				graph.getOrPut(stop, { mutableListOf<Int>() }).add(index)
			}
		}
		var minBusCount = Int.MAX_VALUE
		val startingBuses = graph.getOrDefault(source, mutableListOf())
		for(startingBus in startingBuses) {
			var busCount = 0
			val queue = ArrayDeque<Pair<Int, Int>>()
			queue.addLast(Pair(source, startingBus))
			outer@while(queue.isNotEmpty()) {
				val queueSize = queue.size
				busCount += 1
				for(k in 0 until queueSize) {
					val (srcStop, busIndex) = queue.removeFirst()
					val stops = routes[busIndex]
					for(stop in stops) {
						if (stop == target) {
							minBusCount = Math.min(busCount, minBusCount)
							break@outer
						}
						if (stop == srcStop) {
							continue
						}
						graph[stop]?.filter { it != busIndex }?.forEach { queue.add(Pair(stop, it)) }
					}
				}
			}
		}
		return if (minBusCount < Int.MAX_VALUE) minBusCount else -1
	}
}
fun main() {
	println("Hello World!")
}
