//https://leetcode.com/problems/connecting-cities-with-minimum-cost/
//https://leetcode.com/problemset/all/?search=1135
import java.util.PriorityQueue

class UnionFind(val n: Int) {
    private val v: IntArray = IntArray(n, { it })
    private val w: IntArray = IntArray(n, { 1 })

    private fun root(i: Int): Int {
        var j = i
        while(j != v[j]) {
            v[j] = v[v[j]]
            j = v[j]
        }
        return j
    }

    fun union(i: Int, j: Int) {
        val x = root(i)
        val y = root(j)
        if (w[x] <= w[y]) {
            v[x] = y
            w[y] += w[x]
        } else {
            v[y] = x
            w[x] += w[y]
        }
    }

    fun find(i: Int, j: Int): Boolean {
        return root(i) == root(j)
    }
}

class Solution {
    fun minimumCost(n: Int, connections: Array<IntArray>): Int {
        val pq = PriorityQueue<IntArray>{ edge1, edge2 -> 
            edge1.last() - edge2.last()
        }
        connections.forEach { pq.add(it) }
        val uf = UnionFind(n + 1)
        var count = 0
        var weight = 0
        while(pq.isNotEmpty() && count < n-1) {
            val top = pq.poll()
            val (u, v, w) = top
            if(!uf.find(u, v)) {
                count += 1
                weight += w
                uf.union(u, v)
            }
        }
        return if (count < n - 1) - 1 else weight
    }
}
fun main() {
	println(Solution().minimumCost(3, arrayOf(
        intArrayOf(1,2,5),
        intArrayOf(1,3,6),
        intArrayOf(2,3,1) 
    )))
	println(Solution().minimumCost(4, arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(3,4,4),
    )))
}
