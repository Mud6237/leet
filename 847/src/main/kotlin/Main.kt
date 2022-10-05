//https://leetcode.com/problemset/all?search=847
//https://leetcode.com/problems/shortest-path-visiting-all-nodes/
class Solution {

	companion object {
		fun isVisited(mask: Int, vertex: Int): Boolean {
			val m = 1 shl (vertex)
			if ((mask and m) == m)  {
				return true
			}
			return false
		}
		
		fun visit(mask: Int, vertex: Int ): Int {
			val m = 1 shl vertex
			return mask or m
		}

		fun unvisit(mask: Int, vertex: Int): Int {
			val p = 1 shl vertex
			if (isVisited(mask, vertex)) {
				return mask xor p
			}
			return mask
		}
	}

	fun shortestPathLength_wrong(graph: Array<IntArray>): Int { 
		var m = Int.MAX_VALUE
		val finalMask = (1 shl graph.size) - 1
		for(i in 0 until graph.size) {
			val res = intArrayOf(Int.MAX_VALUE)
			val source = i
			val visitedMask = 1 shl source
			dfs(graph, source, 0, visitedMask, finalMask, res)
			m = Math.min(m, res.first())
			if (m == graph.size - 1) {
				return m
			}
		}
		return m
	}

	fun swap(a: IntArray, i: Int, j: Int) {
		val t = a[i]
		a[i] = a[j]
		a[j] = t
	}

	fun dfs(
	graph: Array<IntArray>,
	source: Int,
	length: Int,
	visitedMask: Int,
	finalMask: Int, 
	res: IntArray
	): Pair<Int, Int> {
		//println(visitedMask.toString(2))
		if(visitedMask == finalMask) {
			res[0] = Math.min(res[0], length)
			return Pair(length, visitedMask)
		}
		val adjVertices = graph[source]
		var m: Int = visitedMask
		var len: Int = length
		for(i in 0 until adjVertices.size) {
			if (isVisited(visitedMask, adjVertices[i])) {
				continue
			}
			swap(adjVertices, 0, i)
			len = length
			m = visitedMask
			for(v in adjVertices) {
				if(!isVisited(m, v)) {
					//println("Going to $v from $source len = ${len + 1}")
					m = visit(m, v)
					val p = dfs(graph, v, len + 1, m, finalMask, res)
					len = p.first
					m =  m or p.second
				}
			}
			swap(adjVertices, 0, i)
		}
		return Pair(len + 1, m)
	}


	fun shortestPathLength(graph: Array<IntArray>): Int {
		val finalPath = (1 shl graph.size) - 1
		var visited = Array(graph.size, { IntArray(1 shl graph.size) })
		var minLevel = Int.MAX_VALUE
		for(vertex in 0 until graph.size) {
			val queue = ArrayDeque<IntArray>()
			var path = visit(0, vertex)
			queue.addLast(intArrayOf(vertex, path))
			var level = 0
			visited[vertex][path] = vertex
			while(queue.isNotEmpty()) {
				repeat(queue.size) {
					val (currentVertex, forwardPath) = queue.removeFirst()
					val adjVertices = graph[currentVertex]
					for(adjVertex in adjVertices) {
						val nextPath = visit(forwardPath, adjVertex)
						if (nextPath == finalPath) {
							minLevel = Math.min(minLevel, level + 1)
							break
						}
						if (visited[adjVertex][nextPath] != vertex) {
							queue.addLast(intArrayOf(adjVertex, nextPath))
							visited[adjVertex][nextPath] = vertex
						}
					}
				}
				level += 1
			}
		}
		if (minLevel == Int.MAX_VALUE) {
			return 0
		}
		return minLevel
	}

}

fun main() {
	var graph = arrayOf(intArrayOf(1,2,3), intArrayOf(0), intArrayOf(0), intArrayOf(0))
	println(Solution().shortestPathLength(graph))
	graph = arrayOf(intArrayOf(1),intArrayOf(0,2,4),intArrayOf(1,3,4),intArrayOf(2),intArrayOf(1,2))
	println(Solution().shortestPathLength(graph))
	graph = arrayOf(intArrayOf(1),intArrayOf(0,2,4),intArrayOf(1,3),intArrayOf(2),intArrayOf(1,5),intArrayOf(4))
	println(Solution().shortestPathLength(graph))
	graph = arrayOf(intArrayOf(6,7),intArrayOf(6),intArrayOf(6),intArrayOf(5,6),intArrayOf(6),intArrayOf(3),intArrayOf(2,0,3,4,1),intArrayOf(0))
	println(Solution().shortestPathLength(graph))
}

/*
0 ---- 6 ,7
1 ---- 6 
2 ---- 6 
3 ---- 5 ,6
4 ---- 6 
5 ---- 3 
6 ---- 2 0,3,4,1
7 ---- 0 
*/