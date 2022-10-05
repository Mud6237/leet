//https://leetcode.com/problemset/all?search=1928
//https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/
import java.util.PriorityQueue

class Solution {
	fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
		val adjMap = hashMapOf<Int, MutableList<Triple<Int, Int, Int>>>()
		for(edge in edges) {
			val u = edge[0]
			val v = edge[1]
			val t = edge[2]
			val uEdgeList = adjMap.getOrPut(u, { mutableListOf() })
			uEdgeList.add(Triple(v, passingFees[v], t))
			val vEdgeList = adjMap.getOrPut(v, { mutableListOf() })
			vEdgeList.add(Triple(u, passingFees[u], t))
		}
		val time = IntArray(passingFees.size, { Int.MAX_VALUE })
		time[0] = 0
		val fees = IntArray(passingFees.size, { Int.MAX_VALUE })
		fees[0] = passingFees[0]
		val comparator = compareBy<Triple<Int, Int, Int>>({ it.second }).thenBy({ it.third })
		var pq = PriorityQueue(comparator)
		pq.add(Triple(0, passingFees[0], 0))
		while(pq.isNotEmpty()) {
			val nextQueue = PriorityQueue(comparator)
			for(i in 0 until pq.size) {
				val front = pq.poll()
				val u = front.first
				val adjList = adjMap.getOrDefault(u, mutableListOf())
				//println("From Edge $front")
				for(adjEdge in adjList) {
					val v = adjEdge.first
					val timeToNextHop = front.third + adjEdge.third
					//println("adjEdge = $adjEdge, timeToNextHop = $timeToNextHop")
					if (timeToNextHop <= maxTime) {
						val costToNextHop = front.second + adjEdge.second
						//println("costToNextHop = $costToNextHop")
						if (costToNextHop < fees[v]) {
							fees[v] = costToNextHop
							time[v] = timeToNextHop
							nextQueue.add(Triple(adjEdge.first, costToNextHop, timeToNextHop))
						} else if (timeToNextHop < time[v]) {
							time[v] = timeToNextHop
							nextQueue.add(Triple(adjEdge.first, costToNextHop, timeToNextHop))
						}
					}
				}
			}
			pq = nextQueue
		}

		if(time.last() <= maxTime) {
			return fees.last()
		}
		return -1
	}
}