//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val adj = Array(n, { mutableListOf<Int> ()})
        for(e in edges) {
            adj[e.first()].add(e.last())
        }
        var marked = BooleanArray(n)
        val stack = mutableListOf<Int>()
        var c = 0
        for(i in 0 until n) {
            if (!marked[i]) {
                c += 1
                stack.add(i)
                while(stack.isNotEmpty()) {
                    outer@while(true) {
                        val top = stack.last()
                        marked[top] = true
                        for(e in adj[top]) {
                            if (!marked[e]) {
                                stack.add(e)
                                continue@outer     
                            }
                        }
                        break
                    }
                    stack.removeAt(stack.lastIndex)
                }
            }
        }
        return c
    }
}
fun main() {
	println(Solution().countComponents(5, arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(3,4))  ))
	println(Solution().countComponents(5, arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,3),intArrayOf(3,4))  ))
}
