//https://leetcode.com/problemset/all?search=1192
//https://leetcode.com/problems/critical-connections-in-a-network/

class Solution {

	fun criticalConnectionsImpl(
		source: Int,
		parent: Int,
		count: Int,
		adjMatrix: Array<MutableList<Int>>,
		pre: IntArray,
		post: IntArray,
		result: MutableList<List<Int>> = mutableListOf<List<Int>>()
	) {
		pre[source] = count + 1
		post[source] = count + 1
		for(v in adjMatrix[source]) {
			if(pre[v] == 0) {
				criticalConnectionsImpl(v, source, count + 1, adjMatrix, pre, post, result)
				post[source] = Math.min(post[source], post[v])
				if (post[v] == pre[v]) {
					result.add(listOf(source, v))
				}
			} else {
				if (v != parent) {
					post[source] = Math.min(post[source], pre[v])
				}
			}
		}
	}

	fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
		val adjMap = Array(n, { mutableListOf<Int>() })
		for((u, v) in connections) {
			adjMap[u].add(v)
			adjMap[v].add(u)
		}
		val result = mutableListOf<List<Int>>()
		val pre = IntArray(n)
		val post = IntArray(n)
		val count = 1
		for(i in 0 until n ) {
			if (pre[i] == 0) {
				criticalConnectionsImpl(i, i, count, adjMap, pre, post, result)
			}
		}
		return result
	}
}

fun main() {
	println(Solution().criticalConnections(13, listOf(
		listOf(4, 2),
		listOf(2, 3),
		listOf(6, 0),
		listOf(0, 1),
		listOf(2, 0),
		listOf(11, 12),
		listOf(12, 9),
		listOf(9, 10),
		listOf(9, 11),
		listOf(7, 9),
		listOf(10, 12),
		listOf(11, 4),
		listOf(4, 3),
		listOf(3, 5),
		listOf(6, 8),
		listOf(5, 4),
		listOf(0, 5),
		listOf(6, 4),
		listOf(6, 9),
		listOf(7, 6),
	)))
	println(Solution().criticalConnections(4, listOf(listOf(0,1),listOf(1,2),listOf(2,0),listOf(1,3))))
	println(Solution().criticalConnections(2, listOf(listOf(0,1)))) 
	println(Solution().criticalConnections(6, listOf(listOf(0,1),listOf(1,2),listOf(2,0),listOf(1,3),listOf(3,4),listOf(4,5),listOf(5,3))))
}