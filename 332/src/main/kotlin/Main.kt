// https://leetcode.com/problems/reconstruct-itinerary/
class Solution {
	fun makeGraph(tickets: List<List<String>>): HashMap<String, ArrayDeque<String>> {
		val g = hashMapOf<String, ArrayDeque<String>>()
		for((source, destination) in tickets) {
			g.getOrPut(source, { ArrayDeque<String>() }).apply {
				addLast(destination)
			}
		}
		for(e in g) {
			e.value.sort()
		}
		return g
	}

	fun makeItinerary(
		g: HashMap<String, ArrayDeque<String>>,
	 	s: String,
		n: Int,
		path: MutableList<String>,
		paths: MutableList<List<String>>
	) {
		path.add(s)
		//println(path)
		val outGoingEdges = g[s]
		val hasEdges = outGoingEdges?.isNotEmpty() ?: false
		if ( outGoingEdges!= null &&  hasEdges) {
			val edgesCount = outGoingEdges.size
			for(i in 0 until edgesCount) {
				val e = outGoingEdges.removeFirst()
				makeItinerary(g, e, n, path, paths)
				outGoingEdges.addLast(e)
			}
		}
		if (path.size == n + 1) {
			paths.add(path.toList())
		}
		path.removeLast()
	}

	fun findItinerary(tickets: List<List<String>>): List<String> {
		val g = makeGraph(tickets)
		val path = mutableListOf<String>()
		val paths = mutableListOf<List<String>>()
		makeItinerary(g, "JFK", tickets.size, path, paths)
		return paths.first()
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
