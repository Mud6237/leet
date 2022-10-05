class Solution {
    fun addDirection(a: IntArray, b: IntArray): IntArray {
        return intArrayOf(a.first() + b.first() , a.last() + b.last())
    }

    fun areSame(a: IntArray, b: IntArray): Boolean {
        return a.first() == b.first() && a.last() == b.last()
    }

    fun isValid(a: Array<IntArray>, d: IntArray): Boolean {
        val x = d.first()
        val y = d.last()
        if (x >= 0 && x < a.size && y >= 0 && y < a[x].size && a[x][y] == 0) {
            return true
        }
        return false
    }

    
    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        val queue = ArrayDeque<IntArray>()
        var marked = Array(maze.size, { IntArray(maze[it].size) })
        queue.addLast(start)
        var directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))
        while(queue.isNotEmpty()) {
            repeat(queue.size) {
                val top = queue.removeFirst()
                //("At ${top.toList()}")
                marked[top.first()][top.last()] = 1
                if (areSame(top, destination)) {
                    return true
                }
                for(dir in directions) {
                    var ds = top
                    while(isValid(maze, addDirection(ds, dir))) {
                        ds = addDirection(ds, dir)
                    }
                    if (!areSame(ds, top) && marked[ds.first()][ds.last()] == 0) {
                        marked[ds.first()][ds.last()] = 1
                        queue.addLast(ds)
                    }
                }
                //("next:")
                //queue.forEach { print(it.toList()) }
                //()
            }
        }
        return false
    }
}
fun main() {
    var maze = arrayOf(intArrayOf(0,0,1,0,0),intArrayOf(0,0,0,0,0),intArrayOf(0,0,0,1,0),intArrayOf(1,1,0,1,1),intArrayOf(0,0,0,0,0))
    var start = intArrayOf(0,4)
    var destination = intArrayOf(4,4)
    println(Solution().hasPath(maze, start, destination))
    maze = arrayOf(intArrayOf(0,0,1,0,0),intArrayOf(0,0,0,0,0),intArrayOf(0,0,0,1,0),intArrayOf(1,1,0,1,1),intArrayOf(0,0,0,0,0))
    start = intArrayOf(0,4)
    destination = intArrayOf(3,2)
    println(Solution().hasPath(maze, start, destination))
    maze = arrayOf(intArrayOf(0,0,0,0,0),intArrayOf(1,1,0,0,1),intArrayOf(0,0,0,0,0),intArrayOf(0,1,0,0,1),intArrayOf(0,1,0,0,0))
    start = intArrayOf(4,3)
    destination = intArrayOf(0,1)
    println(Solution().hasPath(maze, start, destination))
    maze = arrayOf(intArrayOf(0,0,1,0,0),intArrayOf(0,0,0,0,0),intArrayOf(0,0,0,1,0),intArrayOf(1,1,0,1,1),intArrayOf(0,0,0,0,0))
    start = intArrayOf(0,4)
    destination = intArrayOf(1,2)
    println(Solution().hasPath(maze, start, destination))
}
